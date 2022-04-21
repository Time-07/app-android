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
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentSingUpBinding
import br.com.ioasys.appcamp.domain.exception.EmptyInputException
import br.com.ioasys.appcamp.domain.exception.InvalidEmailException
import br.com.ioasys.appcamp.domain.exception.InvalidPasswordException
import br.com.ioasys.appcamp.presentation.viewmodel.SingUpViewModel
import br.com.ioasys.appcamp.util.Mask
import br.com.ioasys.appcamp.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSingUpBinding? = null
    private val binding: FragmentSingUpBinding get() = _binding!!

    private val signUpViewModel: SingUpViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSingUpBinding.inflate(
        inflater, container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserves()
        setListeners()
    }

    private fun setListeners() {
        binding.run {

            cpfTIET.addTextChangedListener(Mask.mask("###.###.###-##", cpfTIET))
            singUpButton.setOnClickListener {
                if (signUpViewModel.gender.isBlank()) {
                    signUpViewModel.setGender(
                        otherOptionTextInputEditText.text.toString())
                }
                signUpViewModel.singUp(
                    user = userTextInputEditText.text.toString(),
                    email = emailTextInputEditText.text.toString(),
                    password = passwordTextInputEditText.text.toString(),
                    confirmPassword = confirmPasswordTextInputEditText.text.toString(),
                    gender = signUpViewModel.gender,
                    cpf = cpfTIET.text.toString()
                )
                emailTextInputEditText.addTextChangedListener {
                    emailTextLayoutInput.error = null
                    errorEmailSingUp.visibility = View.GONE
                }
                confirmPasswordTextInputEditText.addTextChangedListener {
                    confirmPasswordTextLayoutInput.error = null
                    binding.errorPasswordSingUp.visibility = View.GONE
                }
                passwordTextInputEditText.addTextChangedListener {
                    passwordTextLayoutInput.error = null
                    errorPasswordSingUp.visibility = View.GONE
                }
                otherOptionTextInputEditText.addTextChangedListener {
                    otherOptionTextInputLayout.error = null
                    errorRequiredGenreSignUp.visibility = View.GONE
                }
                radioGroupSingUp.setOnCheckedChangeListener { _, checkedId ->
                    when (checkedId) {
                        0, 1, 2 -> errorRequiredGenreSignUp.visibility = View.GONE
                    }
                }
            }
        }
        getInputRadioButton()
        editEnableButton()
    }

    private fun addObserves() {
        signUpViewModel.singUpViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    showInvalidPasswordError(false)
                    showInvalidEmailError(false)
                    showInvalidRequiredGenreError(false)
                    findNavController().navigate(
                        SignUpFragmentDirections.actionSingUpFragmentToLoginFragment()
                    )
                }
                is ViewState.Error -> {
                    when (state.throwable) {
                        is InvalidPasswordException -> showInvalidPasswordError(true)
                        is InvalidEmailException -> showInvalidEmailError(true)
                        is EmptyInputException -> showInvalidRequiredGenreError(true)
                        else -> Toast.makeText(requireActivity(), "Algo deu errado!", Toast.LENGTH_SHORT).show()
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

                signUpViewModel.setGender(
                    when (checkedId) {
                        buttonFirstOption.id -> getString(R.string.first_option_sing_up_string)
                        buttonSecondOption.id -> getString(R.string.second_option_sing_up_string)
                        buttonThirdOption.id -> getString(R.string.third_option_sing_up_string)
                        else -> ""
                    }
                )

                otherOptionTextInputLayout.visibility =
                    setVisibility(checkedId == buttonFourthOption.id)
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
                confirmPasswordTextInputEditText,
                cpfTIET
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
                        val cpfInput = editTexts[4].text.toString().trim()

                        singUpButton.isEnabled =
                            userInput.isEmpty().not() &&
                                    emailInput.isEmpty().not() &&
                                    passwordInput.isEmpty().not() &&
                                    confirmPasswordInput.isEmpty().not() &&
                                    cpfInput.isEmpty().not()
                    }

                    override fun afterTextChanged(s: Editable?) {}

                })
            }
        }
    }

    private fun setVisibility(isVisible: Boolean): Int = if (isVisible) View.VISIBLE else View.GONE

    private fun showInvalidEmailError(hasError: Boolean) {
        if (hasError){
        binding.apply {
            emailTextLayoutInput.error = getString(R.string.error_email_sing_up_string)
            errorEmailSingUp.visibility = View.VISIBLE
            }
        }
    }

    private fun showInvalidPasswordError(hasError: Boolean) {
        if (hasError) {
            binding.apply {
                confirmPasswordTextLayoutInput.error = getString(R.string.error_password_string)
                errorPasswordSingUp.visibility = View.VISIBLE
            }
        }
    }

    private fun showInvalidRequiredGenreError(hasError: Boolean) {
        if(hasError){
            binding.apply {
                otherOptionTextInputLayout.error = getString(R.string.required_genre_field_string)
                errorRequiredGenreSignUp.visibility = View.VISIBLE
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        signUpViewModel.resetViewState()
        _binding = null
    }
}

