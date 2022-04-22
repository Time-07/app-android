package br.com.ioasys.appcamp.presentation.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.FragmentListBinding
import br.com.ioasys.appcamp.presentation.ui.CustomDialogFragment
import org.koin.androidx.scope.fragmentScope
import org.koin.core.component.getScopeId

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners(){
        binding.searchListButton.setOnClickListener {
            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToSearchFragment()
            )
        }

        binding.headerTitle.textButton.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(parentFragmentManager,  dialog.tag)


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}