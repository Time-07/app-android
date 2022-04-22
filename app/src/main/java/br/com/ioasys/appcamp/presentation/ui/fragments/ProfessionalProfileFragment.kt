package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.ioasys.appcamp.databinding.FragmentProfessionalProfileBinding
import br.com.ioasys.appcamp.domain.model.Item

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
    }

    private fun setListeners() {
        binding.professionalFirstName.text = getFirstName("Silvia Maranhão")
        binding.professionalLastName.text = getLastName("Silvia Maranhão")
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
        }
    }

    private fun onScrollChanged() {
        TODO("Not implemented")
    private fun expandableExperienceTextView(){
        val expTVexperience = binding.expTvExperience.expandExperienceTextView
        expTVexperience.setText("Atendo pessoas trans em transição hormonal desde 2012. Tenho ampla experiência no assunto e atuo em todos os estágios do procedimento, das primeiras consultas, passando por todo o início da terapia hormonal até.\n" +
                "\n" +
                "Atendo pessoas trans em transição hormonal desde 2012. Tenho ampla experiência no assunto e atuo em todos os estágios do procedimento, das primeiras consultas, passando por todo o início da terapia hormonal até.")
    }

    private fun expandableFormationTextView(){
        val expTVformation = binding.expTvFormation.expandFormationTextView
        expTVformation.setText("Atendo pessoas trans em transição hormonal desde 2012. Tenho ampla experiência no assunto e atuo em todos os estágios do procedimento, das primeiras consultas, passando por todo o início da terapia hormonal até.\n" +
                "\n" +
                "Atendo pessoas trans em transição hormonal desde 2012. Tenho ampla experiência no assunto e atuo em todos os estágios do procedimento, das primeiras consultas, passando por todo o início da terapia hormonal até.")
    }


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