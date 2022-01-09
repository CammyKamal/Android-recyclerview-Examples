package org.k.recyclerviewwithdatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.k.recyclerviewwithdatabinding.model.DataModel
import org.k.recyclerviewwithdatabinding.databinding.ItemRowBinding

class Adapter(
    var dataList: List<DataModel>?,
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of item_row.xml
    // ie ItemRowBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // bind the items with each item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dataList!![position]){
                binding.tvLangName.text = this.studentName
                binding.tvExp.text = this.branch
            }
        }
    }

    // return the size of List
    override fun getItemCount(): Int {
        return dataList!!.size
    }
}
