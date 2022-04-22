package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentLoginBinding
import br.com.ioasys.appcamp.domain.exception.*
import br.com.ioasys.appcamp.presentation.viewmodel.LoginViewModel
import br.com.ioasys.appcamp.util.ViewState
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by lazy {
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

        binding.apply {
            btnLogin.setOnClickListener {

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
            btnLoginLink.setOnClickListener {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToSingUpFragment()
                )
            }

            textFieldEditPassword.addTextChangedListener {
                textFieldEmail.error = null
                txtLoginError.visibility = View.GONE
            }
            textFieldEditEmail.addTextChangedListener {
                textFieldEmail.error = null
                txtLoginError.visibility = View.GONE
            }
        }

        editEnableButton()
    }


    private fun addObserver() {
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when (state) {
                is ViewState.Success -> {
                    Toast.makeText(context, "DEU CERTOOO!", Toast.LENGTH_SHORT).show()
                    invalidPassword(false)
                    invalidEmail(false)
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToListFragment()
                    )
                }
                is ViewState.Error -> {
                    when (state.throwable) {
                        is InvalidPassword -> invalidPassword(true)
                        is InvalidEmail -> invalidEmail(true)
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
                textFieldEditPassword,
                textFieldEditEmail
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
                        val passwordInput = editTexts[0].text.toString().trim()
                        val emailInput = editTexts[1].text.toString().trim()

                        btnLogin.isEnabled = emailInput.isEmpty().not() && passwordInput.isEmpty().not()

                    }

                    override fun afterTextChanged(s: Editable?) {}

                })
            }
        }
    }

    private fun invalidEmail(hasError: Boolean) {
        binding.apply {
            if (hasError) {
                textFieldEmail.error = getString(R.string.error_text)
                txtLoginError.visibility = View.VISIBLE
            }
        }
    }

    private fun invalidPassword(hasError: Boolean) {
        binding.apply {
            if (hasError) {
                textFieldPassword.error = getString(R.string.error_text)
                txtLoginError.visibility = View.VISIBLE
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

}