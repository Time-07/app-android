package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentOnboarding2Binding

class OnboardingFragment2 : Fragment() {

    private var _binding: FragmentOnboarding2Binding? = null
    private val binding: FragmentOnboarding2Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentOnboarding2Binding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners(){
        binding.apply {
            btnOnBoardingSignUp.setOnClickListener {
                findNavController().navigate(
                    OnboardingFragment2Directions.actionOnboarding2ToSignUp()
                )
            }
            btnLoginLink.setOnClickListener {
                findNavController().navigate(
                    OnboardingFragment2Directions.actionOnboarding2ToLogin()
                )
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}