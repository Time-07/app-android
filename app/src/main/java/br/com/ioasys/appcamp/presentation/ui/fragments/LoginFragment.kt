package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentLoginBinding
import br.com.ioasys.appcamp.domain.exception.*
import br.com.ioasys.appcamp.presentation.viewmodel.LoginViewModel
import br.com.ioasys.appcamp.utils.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel : LoginViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        addObserver()
    }

    private fun setListener() {
        binding.btnLogin.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    textFieldEditEmail.text.toString(),
                    textFieldEditPassword.text.toString()
                )

                textFieldEditEmail.addTextChangedListener {
                    txtLoginError.visibility = View.GONE
                }
                textFieldEditPassword.addTextChangedListener {
                    txtLoginError.visibility = View.GONE
                }
            }
        }

        binding.btnSignupLink.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionBtnSignupLinkToSingUpFragment()
            )
        }
        editEnableButton()
    }


    private fun addObserver(){
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when(state){
                is ViewState.Success -> {
                    Toast.makeText(context, "DEU CERTOOO!", Toast.LENGTH_SHORT).show()
                    showInvalidPassword(false)
                    showInvalidEmail(false)
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToSearchFragment()
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable){
                        is InvalidPasswordException -> showInvalidPassword(true)
                        is InvalidEmailException -> showInvalidEmail(true)
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

    private fun editEnableButton() {
        binding.btnLogin.isEnabled = false
        binding.apply {
            val editTexts = listOf(
                textFieldEditEmail,
                textFieldEditPassword
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
                        val emailInput = editTexts[0].text.toString().trim()
                        val passwordInput = editTexts[1].text.toString().trim()

                        btnLogin.isEnabled =
                                    emailInput.isEmpty().not() &&
                                    passwordInput.isEmpty().not()
                    }

                    override fun afterTextChanged(s: Editable?) {}

                })
            }
        }
    }

    private fun showInvalidEmail(hasError: Boolean){
        binding.apply {
            txtLoginError.visibility = if(hasError) View.VISIBLE else View.GONE
        }
    }

    private fun showInvalidPassword(hasError: Boolean){
        binding.apply {
            txtLoginError.visibility = if(hasError) View.VISIBLE else View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

}