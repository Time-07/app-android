package br.com.ioasys.appcamp.presentation.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.presentation.ui.fragments.ListFragmentDirections

class CustomDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.closeDialogButton).setOnClickListener {
            dismiss()
        }

        view.findViewById<Button>(R.id.noDialogButton).setOnClickListener {
            dismiss()
        }

        view.findViewById<Button>(R.id.confirmDialogButton).setOnClickListener {
            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToLoginFragment()
            )
            dismiss()
        }
    }

}