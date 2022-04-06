package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.utils.ViewState
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentLoginBinding
import br.com.ioasys.appcamp.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel : LoginViewModel by viewModel()

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
        editEnableButton()
    }

    private fun setListener() {
        binding.mbLogin.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    textFieldEditEmail.text.toString(),
                    textFieldEditPassword.text.toString()
                )

                textFieldEditEmail.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
                textFieldEditPassword.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
            }
        }
    }


    private fun editEnableButton() {
        binding.mbLogin.isEnabled = false
        binding.apply {
            val editTexts = listOf(
                textFieldEditEmail,
                textFieldEditPassword
            )
            for (editText in editTexts){
                editText.addTextChangedListener(object: TextWatcher{
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        TODO("Not yet implemented")

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        val emailInput = editTexts[0].text.toString().trim()
                        val passwordInput = editTexts[1].text.toString().trim()

                        mbLogin.isEnabled =
                            emailInput.isNotEmpty()&&
                                    passwordInput.isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }
    }

    private fun addObserver(){
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when(state){
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionTvSignupLinkToFragmentSignup()
                    )
                }
                is ViewState.Error -> {
                    binding.txtError.text = state.throwable.message
                    binding.txtError.visibility = View.VISIBLE
                }

                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

