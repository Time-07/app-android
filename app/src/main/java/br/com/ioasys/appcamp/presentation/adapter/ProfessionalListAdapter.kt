package br.com.ioasys.appcamp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.appcamp.databinding.ItemsCardviewBinding
import br.com.ioasys.appcamp.domain.model.Item


class ProfessionalListAdapter(
    private val professionalClickListener: ProfessionalClickListener
) : ListAdapter<Item, ProfessionalListAdapter.ProfessionalsListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalsListViewHolder {
        return ProfessionalsListViewHolder.create(parent, professionalClickListener)
    }

    override fun onBindViewHolder(holder: ProfessionalsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {

            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem

        }
    }

    class ProfessionalsListViewHolder(
        private val binding: ItemsCardviewBinding,
        private val professionalClickListener: ProfessionalClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                professionChipCV.text = item.specialty
                valueTxt.text = item.value
                cityAndState.text = item.cityAndState
                meetType.text = item.meet
                professionalName.text = item.name

                seeProfileButton.setOnClickListener {
                    professionalClickListener.onProfessionalClickListener(item)
                }
            }
        }

        companion object {

            fun create(
                parent: ViewGroup,
                professionalClickListener: ProfessionalClickListener
            ): ProfessionalsListViewHolder {
                val binding = ItemsCardviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ProfessionalsListViewHolder(binding, professionalClickListener)
            }
        }
    }

}