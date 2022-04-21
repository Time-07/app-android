package br.com.ioasys.appcamp.presentation.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.appcamp.databinding.ItemsCardviewBinding
import br.com.ioasys.appcamp.domain.model.Items
import br.com.ioasys.appcamp.domain.model.Professional


class ProfessionalListAdapter(
//    private val professionalClickListener: ProfessionalClickListener
) : ListAdapter<Items, ProfessionalListAdapter.ProfessionalsListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalsListViewHolder {
        return ProfessionalsListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProfessionalsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>() {

            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean =
                oldItem == newItem

        }
    }

    class ProfessionalsListViewHolder(
        private val binding: ItemsCardviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            binding.apply {
                professionChipCV.text = items.specialty
                valueTxt.text = items.value
                cityAndState.text = items.cityAndState
                meetType.text = items.meet
                professionalName.text = items.name

                seeProfileButton.setOnClickListener {

                }
            }
        }

        companion object {

            fun create(
                parent: ViewGroup
            ): ProfessionalsListViewHolder {
                val binding = ItemsCardviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ProfessionalsListViewHolder(binding)
            }
        }
    }

}