package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.ioasys.appcamp.databinding.FragmentProfessionalProfileBinding

class ProfessionalProfileFragment : Fragment() {

    private var _binding: FragmentProfessionalProfileBinding? = null
    private val binding: FragmentProfessionalProfileBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfessionalProfileBinding.inflate(
        inflater, container, false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.professionalFirstName.text = getFirstName("Silvia Maranhão")
        binding.professionalLastName.text = getLastName("Silvia Maranhão")
        binding.contactButton.setOnClickListener {
            binding.run {
                contactButton.viewTreeObserver.addOnScrollChangedListener {
                    TODO("Not implemented")
                }
            }
        }
    }

    private fun onScrollChanged() {
        TODO("Not implemented")
    }

    /*

    if (scrollView.getChildAt(0).getBottom()
                 <= (scrollView.getHeight() + scrollView.getScrollY())) {
                //scroll view is at bottom
        //set the button visibility to visible here
            } else {
                //scroll view is not at bottom
        //set the button visibility to gone here
            }
        }

        */


    private fun getFirstName(fullName: String?): String? {
        val index = fullName?.lastIndexOf(' ')
        return if (index == -1) {
            fullName
        } else index?.let { it1 -> fullName.substring(0, it1) }
    }

    private fun getLastName(fullName: String?): String? {
        val index = fullName?.lastIndexOf(' ')
        return if (index == -1) {
            null
        } else return index?.plus(1)?.let { it1 -> fullName.substring(it1) }
    }
}