package com.example.eindwerk.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eindwerk.databinding.ListItemOphaalBinding
import com.example.eindwerk.models.Ophaal

class OphaalAdapter(private  var ophaalClickListener: OphaalClickListener): ListAdapter<Ophaal, OphaalViewHolder>(OphaalDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OphaalViewHolder {
        return OphaalViewHolder(ListItemOphaalBinding.inflate(LayoutInflater.from(parent.context),parent , false ))
    }

    override fun onBindViewHolder(holder: OphaalViewHolder, position: Int) {
        val ophaal = getItem(position)
        holder.bindData(ophaal)
        holder.itemView.setOnClickListener { ophaalClickListener.onOphaalClicked(ophaal) }
    }

}
private class OphaalDiffCallback: DiffUtil.ItemCallback<Ophaal>(){
    override fun areItemsTheSame(oldItem: Ophaal, newItem: Ophaal): Boolean {
        return oldItem.recordid == newItem.recordid
    }

    override fun areContentsTheSame(oldItem: Ophaal, newItem: Ophaal): Boolean {
        return oldItem == newItem
    }

}

class OphaalViewHolder(val binding: ListItemOphaalBinding): RecyclerView.ViewHolder(binding.root){
    fun bindData(ophaal: Ophaal){
        binding.ophaal = ophaal
    }

}

interface OphaalClickListener{
    fun onOphaalClicked(ophaal: Ophaal)
}