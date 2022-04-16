package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ioasys.appcamp.databinding.FragmentProfessionalListBinding
import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalClickListener
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalListAdapter
import br.com.ioasys.appcamp.presentation.viewmodel.ProfessionalsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfessionalSearchFragment : Fragment(), ProfessionalClickListener {

    private lateinit var professionalListAdapter: ProfessionalListAdapter
    private var _binding: FragmentProfessionalListBinding? = null
    private val binding: FragmentProfessionalListBinding get() = _binding!!

    private val professionalsViewModel: ProfessionalsListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfessionalListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureListeners()

    }

    private fun configureListeners(){
        binding.edSearchLocalization.textChangeListener = { input ->
            professionalsViewModel.search(input)
        }
    }

    override fun onProfessionalClickListener(professional: Professional) {
        binding.textFilter1.setOnCloseIconClickListener {
            TODO("Not yet implemented")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}