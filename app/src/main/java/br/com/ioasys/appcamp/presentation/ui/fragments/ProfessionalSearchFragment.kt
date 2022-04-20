package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentProfessionalSearchBinding
import br.com.ioasys.appcamp.presentation.viewmodel.ProfessionalsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfessionalSearchFragment : Fragment() {

    private var _binding: FragmentProfessionalSearchBinding? = null
    private val binding: FragmentProfessionalSearchBinding get() = _binding!!

    private val professionalistViewModel: ProfessionalsListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfessionalSearchBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureListeners()

    }

    private fun configureListeners(){
        binding.edSearchLocalization.addTextChangedListener { inputLocalization ->
            TODO("Ainda não implementado! (usecase só do filtro)")
//            professionalsViewModel.search(input)
        }
        binding.tilSpecialistNameSearch.addTextChangedListener { inputName ->

        }
        binding.SearchButton.setOnClickListener {
            findNavController().navigate(
                ProfessionalSearchFragmentDirections.actionSearchFragmentToListFilteredFragment()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}