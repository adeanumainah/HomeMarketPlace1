package com.dean.homemarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.Home
import kotlinx.android.synthetic.main.row_listh.view.*

class ProyekTerkiniAdapter(val data: ArrayList<Home>):
    RecyclerView.Adapter<ProyekTerkiniAdapter.TerkiniViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerkiniViewHolder {
        //ngeinflate layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listh, parent, false)
        return TerkiniViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: TerkiniViewHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    //viewholder bergunu u ngereset data ke view kita
    class TerkiniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Home) {

            itemView.tv_name_rumah.text = get?.name
            itemView.tv_address_rumah.text = get?.address
        }
    }

}