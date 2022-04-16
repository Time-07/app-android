package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentListFilteredBinding


class ListFilteredFragment : Fragment() {

    private var _binding: FragmentListFilteredBinding? = null
    private val binding: FragmentListFilteredBinding get() = _binding!!

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
    }

    private fun setListeners(){
        binding.listFilteredReturnFilterButton.setOnClickListener {
            findNavController().navigate(
                ListFilteredFragmentDirections.actionListFilteredFragmentToSearchFragment()
            )
        }
        binding.listFilteredCloseButton.setOnClickListener {
            findNavController().navigate(
                ListFilteredFragmentDirections.actionListFilteredFragmentToListFragment()
            )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}