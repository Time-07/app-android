package br.com.ioasys.appcamp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.ProfessionalItemBinding
import br.com.ioasys.appcamp.domain.model.Professional
import coil.load


class ProfessionalListAdapter(
    private val onProfessionalClickListener: ProfessionalClickListener
): ListAdapter<Professional, ProfessionalListAdapter.ProfessionalListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalListViewHolder {
        return ProfessionalListViewHolder.create(parent, onProfessionalClickListener)
    }

    override fun onBindViewHolder(holder: ProfessionalListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Professional>() {
            override fun areItemsTheSame(oldItem: Professional, newItem: Professional): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Professional, newItem: Professional): Boolean =
                oldItem == newItem
        }
    }

    class ProfessionalListViewHolder(
        private val bindind: ProfessionalItemBinding,
        private val professionalClickListener: ProfessionalClickListener
    ): RecyclerView.ViewHolder(bindind.root){
        fun bind(professional: Professional) {
            bindind.apply {
                tvprofissionalName.text = professional.name
                professionChipCV.text = professional.specialty
                tvlocalization.text = professional.city
                tvPrize.text = professional.value.toString()
                profileImg.load(professional.imageUrl){
                    error(R.drawable.ic_baseline_person_24)
                }

                root.setOnClickListener {
                    professionalClickListener.onProfessionalClickListener(professional)
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onProfessionalClickListener: ProfessionalClickListener
            ): ProfessionalListViewHolder {
                val bindind = ProfessionalItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return ProfessionalListViewHolder(bindind, onProfessionalClickListener)
            }
        }
    }
}

