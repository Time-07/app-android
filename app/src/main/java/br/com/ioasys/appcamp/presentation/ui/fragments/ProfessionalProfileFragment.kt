package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.ioasys.appcamp.databinding.FragmentProfessionalProfileBinding
import br.com.ioasys.appcamp.domain.model.Item
import br.com.ioasys.appcamp.presentation.ui.CustomDialogFragment

class ProfessionalProfileFragment : Fragment() {

    private var _binding: FragmentProfessionalProfileBinding? = null
    private val binding: FragmentProfessionalProfileBinding get() = _binding!!

    private val args: ProfessionalProfileFragmentArgs by navArgs()

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
        setUpView()
        binding.appBar.logoutBtn.setOnClickListener{
            val dialog = CustomDialogFragment()
            dialog.show(parentFragmentManager,  dialog.tag)
        }
    }

    private fun setListeners() {
        binding.appBar.backIcon.setOnClickListener {
            findNavController().navigate(
                ProfessionalProfileFragmentDirections.actionProfessionalProfileFragmentToListFilteredFragment()
            )
        }
        binding.contactButton.setOnClickListener {
            binding.run {
                binding.contactScrollView.scrollView.isSmoothScrollingEnabled
                when {
                    (binding.contactScrollView.scrollView.getChildAt(0).bottom) <=
                            (binding.contactScrollView.scrollView.height) + (binding.contactScrollView.scrollView.scrollY) -> binding.contactScrollView.scrollView.visibility = View.VISIBLE
                    else -> binding.contactScrollView.scrollView.visibility = GONE
                }
            }
        }
    }

    private fun setUpView(){
        binding.apply {
            specialtyChip.text = args.itemArgs.specialty
            crmCrp.text = args.itemArgs.crmCrp
            meetTypeSection.text = args.itemArgs.meet
            priceSection.text = args.itemArgs.value
            locationSection.text = args.itemArgs.cityAndState
            address.text = args.itemArgs.address
            healthInsurance.text = args.itemArgs.healthPlan
            inclusiveBathroom.text = args.itemArgs.bathroomSpecific
            treatmentPronoun.text = args.itemArgs.treatmentPronoun
            professionalFirstName.text = args.itemArgs.professionalFirstName
            professionalLastName.text = args.itemArgs.professionalLastName
            textsContainers.expandableText.text = args.itemArgs.experience
            textsContainers2.expandableText.text = args.itemArgs.curriculum

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): ProfessionalProfileFragment {
            return ProfessionalProfileFragment()
        }
    }
}