package com.vinicius.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.businesscard.data.BusinessCard
import com.vinicius.businesscard.databinding.CardItemBinding

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding : CardItemBinding
    ) :RecyclerView.ViewHolder(binding.root){
        fun bind (item: BusinessCard){
            binding.nameTv.text = item.name
            binding.companyNameTv.text = item.company
            binding.numberPhoneTv.text = item.phoneNumber
            binding.contentCd.setBackgroundColor(Color.parseColor(item.backgroundUser))
            binding.contentCd.setOnClickListener {
                listenerShare(it)
            }
        }
    }


}
class DiffCallBack: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id

}