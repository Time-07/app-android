package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.databinding.FragmentListFilteredBinding
import br.com.ioasys.appcamp.domain.model.Item
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalClickListener
import br.com.ioasys.appcamp.presentation.adapter.ProfessionalListAdapter

class ListFilteredFragment : Fragment(), ProfessionalClickListener{

    private lateinit var professionalListAdapter: ProfessionalListAdapter
    private var _binding: FragmentListFilteredBinding? = null
    private val binding: FragmentListFilteredBinding get() = _binding!!

//    private val professionalsListViewModel: ProfessionalsListViewModel by lazy{
//        getViewModel()
//    }

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
//        addObserver()
    }

//    private fun addObserver(){
//        professionalsListViewModel.professionalListViewState.observe(viewLifecycleOwner){ state ->
//            when(state){
//                is ViewState.Success -> {
//                    professionalListAdapter.submitList(state.data)
//                    binding.apply {
//                        recycleView.visibility = View.VISIBLE
//                        setVisibility(false)
//                    }
//                }
//                is ViewState.Error -> {
//                    when(state.throwable){
//                        is EmptyProfessionalListException -> {
//                            professionalListAdapter.submitList(listOf())
//                            binding.apply {
//                                recycleView.visibility = View.GONE
//                                setVisibility(true)
//                            }
//                        }
//                        else -> Unit
//                    }
//                }
//                else -> Unit
//            }
//        }
//    }

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
        professionalListAdapter.submitList(Item.getMockList())
//        professionalsListViewModel.search()
    }

    private fun setVisibility(hasError: Boolean){
        binding.apply {
        val visibility = View.VISIBLE
            if (hasError){
                binding.imgPerson.visibility = visibility
                responseEmptyText1.visibility = visibility
                responseEmptyText2.visibility = visibility
                responseEmptyText3.visibility = visibility
            } else Unit
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onProfessionalClickListener(item: Item) {
        findNavController().navigate(
            ListFilteredFragmentDirections.actionListFilteredFragmentToProfessionalProfileFragment(item)
        )
    }
}