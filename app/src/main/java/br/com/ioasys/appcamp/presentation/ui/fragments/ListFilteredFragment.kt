package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentListFilteredBinding
import br.com.ioasys.appcamp.domain.exception.EmptyProfessionalListException
import br.com.ioasys.appcamp.domain.exception.UnknowException
import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalClickListener
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalListAdapter
import br.com.ioasys.appcamp.presentation.viewmodel.ProfessionalsListViewModel
import br.com.ioasys.appcamp.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ListFilteredFragment : Fragment(), ProfessionalClickListener {

    private lateinit var professionalListAdapter: ProfessionalListAdapter
    private var _binding: FragmentListFilteredBinding? = null
    private val binding: FragmentListFilteredBinding get() = _binding!!

    private val professionalsListViewModel: ProfessionalsListViewModel by lazy{
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListFilteredBinding.inflate(
        inflater, container, false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setItemsListData()
        addObserver()
    }

    private fun addObserver(){
        professionalsListViewModel.professionalListViewState.observe(viewLifecycleOwner){ state ->
            when(state){
                is ViewState.Success -> {
                    professionalListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable){
                        is EmptyProfessionalListException -> {
                            professionalListAdapter.submitList(listOf())
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            listFilteredReturnFilterButton.setOnClickListener {
                findNavController().navigate(
                    ListFilteredFragmentDirections.actionListFilteredFragmentToSearchFragment()
                )
            }
            listFilteredCloseButton.setOnClickListener {
                findNavController().navigate(
                    ListFilteredFragmentDirections.actionListFilteredFragmentToListFragment()
                )
            }
            listFilteredFloatingButton.setOnClickListener {
                findNavController().navigate(
                    ListFilteredFragmentDirections.actionListFilteredFragmentToSearchFragment()
                )
            }
        }
    }

    private fun setItemsListData(){
        professionalListAdapter = ProfessionalListAdapter(this)
        binding.recycleView.adapter = professionalListAdapter
        professionalsListViewModel.putProfessionalListOnView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onProfessionalClickListener(professional: Professional) {
        //implementar os dados que forem passados no perfil aqui
    }

}