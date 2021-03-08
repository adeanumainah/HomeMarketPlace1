package com.dean.homemarketplace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.DataItem
//import com.dean.homemarketplace.model.ResponseItem
import kotlinx.android.synthetic.main.row_listh.view.*

class ProyekTerkiniAdapter(var context: Context)
    : RecyclerView.Adapter<ProyekTerkiniAdapter.ViewHolder>() {

    private var listData: List<DataItem> = ArrayList()

    fun setData(items: List<DataItem>) {
        listData = items
        //buat ngereload/syncronize data
        notifyDataSetChanged()
    }

    //viewholder bergunu u ngereset data ke view kita
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: DataItem) {
            with(itemView) {
                tv_name_rumah.text = data.name
                tv_address_rumah.text = data.address
                Glide.with(context).load(data.image).centerCrop().into(iv_rumah)
                itemView.setOnClickListener {
                    itemView.context
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_listh, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProyekTerkiniAdapter.ViewHolder, position: Int) {
        holder.bind(listData.get(position))

    }

    override fun getItemCount(): Int = listData.size

}