package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding: FragmentOnboardingBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentOnboardingBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners(){
        binding.apply {
            btnLoginLink.setOnClickListener {
                findNavController().navigate(
                    OnboardingFragmentDirections.actionOnboardingToLogin()
                )
            }

            backBtn.setOnClickListener {
                findNavController().navigate(
                    OnboardingFragmentDirections.actionOnboardingToOnboarding2()
                )
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}