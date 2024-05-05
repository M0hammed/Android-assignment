package com.abdulmohsen.universities.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.abdulmohsen.base.BaseAdapter
import com.abdulmohsen.base.BaseViewHolder
import com.abdulmohsen.universities.databinding.ItemUniversityBinding
import com.abdulmohsen.universities.domain.model.University

class UniversitiesAdapter(private val onClick: (University) -> Unit) : BaseAdapter<University>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<University> {
        val binding =
            ItemUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UniversitiesViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<University>, position: Int) {
        holder.onBind(data[position])
    }

    inner class UniversitiesViewHolder(private val binding: ItemUniversityBinding) :
        BaseViewHolder<University>(binding.root) {
        override fun onBind(item: University) {
            binding.tvUniversityName.text = item.name
            binding.tvUniversityState.text = item.stateProvince
            binding.universityItem.setOnClickListener { onClick(item) }
        }
    }
}
