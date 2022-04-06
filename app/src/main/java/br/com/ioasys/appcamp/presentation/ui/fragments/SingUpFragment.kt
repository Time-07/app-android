package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ioasys.appcamp.databinding.FragmentSingUpBinding
import br.com.ioasys.appcamp.presentation.viewmodel.SingUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SingUpFragment : Fragment() {

    private var _binding: FragmentSingUpBinding? = null
    private val binding: FragmentSingUpBinding get() = _binding!!

    private val singUpViewModel: SingUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSingUpBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInputRadioButton()
        editEnableButton()
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

    override fun onDestroyView() {
        super.onDestroyView()
        /*singUpViewModel.resetViewState()*/
        _binding = null
    }
}