package br.com.ioasys.appcamp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ioasys.appcamp.R

class BottomNavigationFragment : Fragment() {

    private var _binding: BottomNavigationFragment? = null
    private val binding: BottomNavigationFragment get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}