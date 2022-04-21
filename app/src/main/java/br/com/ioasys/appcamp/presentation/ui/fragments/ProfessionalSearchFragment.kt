package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentProfessionalSearchBinding
import br.com.ioasys.appcamp.presentation.viewmodel.ProfessionalsListViewModel
import br.com.ioasys.appcamp.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProfessionalSearchFragment : Fragment() {

    private var _binding: FragmentProfessionalSearchBinding? = null
    private val binding: FragmentProfessionalSearchBinding get() = _binding!!

    private val professionalsListViewModel: ProfessionalsListViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfessionalSearchBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        addObservers()

    }

    private fun addObservers() {
        professionalsListViewModel.professionalListViewState.observe(viewLifecycleOwner) { state ->
            when (state) {

                is ViewState.Success -> {
                    Toast.makeText(context, "DEU CERTOOO!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(
                    ProfessionalSearchFragmentDirections.actionSearchFragmentToListFilteredFragment()
                )
                }
                is ViewState.Error -> {
                    Toast.makeText(requireActivity(), "Deu errado, merda", Toast.LENGTH_SHORT).show()
                }
                is ViewState.Loading -> {
                    Toast.makeText(context, "Aguarde", Toast.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            SearchButton.setOnClickListener {
                professionalsListViewModel.search(
                    searchGender = professionalsListViewModel.genderSearch,
                    searchLocalization = editTextLocalization.text.toString(),
                    searchName = editTextNameSearch.text.toString(),
                    searchSpecialty = professionalsListViewModel.specialtySearch
                    )
            }
        }
        setChipText()
        setSpecialty()
    }
    
    private fun setSpecialty(){
        binding.apply { 
            chipGroupSpecialty.setOnCheckedStateChangeListener { _, checkedIds ->
                professionalsListViewModel.setSpecialtySearch(
                    when(checkedIds) {
                        psychiatrist -> R.string.psychiatrist_string.toString()
                        gynecologist -> R.string.gynecologist_string.toString()
                        urologist -> R.string.urologist_string.toString()
                        endocrinology -> R.string.endocrinology_string.toString()
                        psychology -> R.string.psychology_string.toString()
                        else -> ""
                    }
                )
            }
        }
    } 

    private fun setChipText() {
        binding.apply {
            chipGroupGender.setOnCheckedStateChangeListener { _, checkedIds ->
                professionalsListViewModel.setSearchGender(
                    when (checkedIds) {
                        cisgenderWomen -> R.string.cisgender_women_string.toString()
                        transWomen -> R.string.trans_women_string.toString()
                        cisgenderMen -> R.string.cisgender_men_string.toString()
                        transMen -> R.string.trans_men_string.toString()
                        nonBinaryPerson -> R.string.non_binary_person_string.toString()
                        else -> ""
                    }
                )
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
