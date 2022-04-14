package br.com.ioasys.appcamp.presentation.ui.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentLoginBinding
import br.com.ioasys.appcamp.domain.model.exception.*
import br.com.ioasys.appcamp.presentation.viewmodel.LoginViewModel
import br.com.ioasys.appcamp.util.ViewState
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
        Log.i(ContentValues.TAG, "Click!!!")
    }


    private fun addObserver(){
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when(state){
                is ViewState.Success -> {
                    Toast.makeText(context, "DEU CERTOOO!", Toast.LENGTH_SHORT).show()
                    invalidPassword(false)
                    invalidEmail(false)
                    findNavController().navigate(
                        SingUpFragmentDirections.actionSingUpFragmentToListFragment()
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable){
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


    private fun invalidEmail(hasError: Boolean){
        binding.apply {
            txtLoginError.visibility = if(hasError) View.VISIBLE else View.GONE
        }    }

    private fun invalidPassword(hasError: Boolean){
        if (hasError){
            binding.txtLoginError.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

}