package br.com.ioasys.appcamp.presentation.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.R.*
import com.google.android.material.textfield.TextInputEditText

class CustomSearchInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyle: Int = 0
): ConstraintLayout(context, attrs, defStyle) {

    private val view = LayoutInflater.from(context).inflate(layout.custom_search_input, this, true)

    private val input: TextInputEditText by lazy {
        view.findViewById(R.id.etInput)
    }

    var textChangeListener: (input: String) -> Unit = {}

    init {
        setLayout(attrs)
        configureInputSearch()
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attibutes = context.obtainStyledAttributes(attributeSet, styleable.CustomSearchInput)

            val custonHint = attibutes.getString(styleable.CustomSearchInput_custon_hint)

            input.hint = custonHint

            attibutes.recycle()
        }
    }

    private fun configureInputSearch() {
        input.addTextChangedListener { input ->
            configureInputBackground(input.isNullOrEmpty())
            textChangeListener.invoke(input.toString())
        }
    }

    private fun configureInputBackground(empty: Boolean) {
        if(empty)
            input.backgroundTintList = null
        else {
            input.backgroundTintList = ContextCompat.getColorStateList(context, android.R.color.white)
        }

    }

}