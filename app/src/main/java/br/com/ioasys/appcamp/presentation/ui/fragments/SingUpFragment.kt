package br.com.ioasys.appcamp.presentation.ui.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentSingUpBinding
import br.com.ioasys.appcamp.domain.exception.EmptyInputException
import br.com.ioasys.appcamp.domain.exception.InvalidEmailException
import br.com.ioasys.appcamp.domain.exception.InvalidPasswordException
import br.com.ioasys.appcamp.presentation.viewmodel.SingUpViewModel
import br.com.ioasys.appcamp.utils.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SingUpFragment : Fragment() {

    private var _binding: FragmentSingUpBinding? = null
    private val binding: FragmentSingUpBinding get() = _binding!!

    private val singUpViewModel : SingUpViewModel by lazy {
        getViewModel()
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSingUpBinding.inflate(inflater, container,
        false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserves()
        setListeners()
    }

    private fun setListeners(){
        binding.singUpButton.setOnClickListener {
            binding.run {
                singUpViewModel.singUp(
                    user = userTextInputEditText.text.toString(),
                    email = emailTextInputEditText.text.toString(),
                    password = passwordTextInputEditText.text.toString(),
                    confirmPassword = confirmPasswordTextInputEditText.text.toString(),
                    genre = singUpViewModel.genreValue
                )
                emailTextInputEditText.addTextChangedListener{
                    errorEmailSingUp.visibility = View.GONE
                }
                confirmPasswordTextInputEditText.addTextChangedListener {
                    confirmPasswordTextLayoutInput.error = null
                    binding.errorPasswordSingUp.visibility = View.GONE
                }
                passwordTextInputEditText.addTextChangedListener{
                    errorPasswordSingUp.visibility = View.GONE
                }
                otherOptionTextInputEditText.addTextChangedListener {
                    errorRequiredGenreSingUp.visibility = View.GONE
                }
                radioGroupSingUp.setOnCheckedChangeListener { _, checkedId ->
                    when(checkedId){
                        0, 1, 2 -> errorRequiredGenreSingUp.visibility = View.GONE
                    }
                }
            }
        }
        getInputRadioButton()
        editEnableButton()
    }

    private fun addObserves(){
        singUpViewModel.singUpViewState.observe(viewLifecycleOwner){ state ->
            when(state){
                is ViewState.Success -> {
                    Toast.makeText(context, "DEU CERTOOO!", Toast.LENGTH_SHORT).show()
                    showInvalidPasswordError(false)
                    showInvalidEmailError(false)
                    showInvalidRequiredGenreError(false)
                }
                is ViewState.Error -> {
                    when(state.throwable){
                        is InvalidPasswordException -> showInvalidPasswordError(true)
                        is InvalidEmailException -> showInvalidEmailError(true)
                        is EmptyInputException -> showInvalidRequiredGenreError(true)
                        else -> Unit
                    }
                }
                is ViewState.Loading -> {
                    Toast.makeText(context, "Aguarde", Toast.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        }
    }



    private fun getInputRadioButton() {

        binding.apply {
            radioGroupSingUp.setOnCheckedChangeListener { _, checkedId ->

                var isVisible = false

                singUpViewModel.setGenre(
                    when (checkedId) {
                        buttonFirstOption.id -> buttonFirstOption.text.toString()
                        buttonSecondOption.id -> buttonSecondOption.text.toString()
                        buttonThirdOption.id -> buttonThirdOption.text.toString()
                        buttonFourthOption.id -> {
                            isVisible = true
                            otherOptionTextInputEditText.text.toString()
                        }
                        else -> ""
                    }
                )
                otherOptionTextInputLayout.visibility = setVisibility(isVisible)
            }
        }
    }

    private fun editEnableButton() {
        binding.singUpButton.isEnabled = false
        binding.apply {
            val editTexts = listOf(
                userTextInputEditText,
                emailTextInputEditText,
                passwordTextInputEditText,
                confirmPasswordTextInputEditText
            )
            for (editText in editTexts) {
                editText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        val userInput = editTexts[0].text.toString().trim()
                        val emailInput = editTexts[1].text.toString().trim()
                        val passwordInput = editTexts[2].text.toString().trim()
                        val confirmPasswordInput = editTexts[3].text.toString().trim()

                        singUpButton.isEnabled =
                            userInput.isEmpty().not() &&
                                    emailInput.isEmpty().not() &&
                                    passwordInput.isEmpty().not() &&
                                    confirmPasswordInput.isEmpty().not()
                    }

                    override fun afterTextChanged(s: Editable?) {}

                })
            }
        }
    }

    private fun setVisibility(isVisible: Boolean): Int = if (isVisible) View.VISIBLE else View.GONE

    private fun showInvalidEmailError(hasError: Boolean){
        binding.apply {
            errorEmailSingUp.visibility = if(hasError) View.VISIBLE else View.GONE
        }    }

    private fun showInvalidPasswordError(hasError: Boolean){
        if (hasError){
            binding.confirmPasswordTextLayoutInput.error = getString(R.string.error_password_string)
            binding.errorPasswordSingUp.visibility = View.VISIBLE
        }
    }

    private fun showInvalidRequiredGenreError(hasError: Boolean){
        binding.errorRequiredGenreSingUp.visibility = if(hasError) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        singUpViewModel.resetViewState()
        _binding = null
    }
}