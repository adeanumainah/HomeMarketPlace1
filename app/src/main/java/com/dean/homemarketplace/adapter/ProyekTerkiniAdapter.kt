package com.dean.homemarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.Home
import kotlinx.android.synthetic.main.row_listh.view.*

class ProyekTerkiniAdapter (private val listener: (Home) -> Unit): RecyclerView.Adapter<ProyekTerkiniAdapter.TerkiniViewHolder>(){
    private val listRumah= ArrayList<Home>()

    fun setData(items: ArrayList<Home>){
        listRumah.clear()
        listRumah.addAll(items)
        //buat ngereload/syncronize data
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerkiniViewHolder {
        //ngeinflate layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listh, parent, false)
        return TerkiniViewHolder(view)
    }

    override fun getItemCount(): Int = listRumah.size

    override fun onBindViewHolder(holder: TerkiniViewHolder, position: Int) {
        holder.bind(listRumah[position], listener)
    }

    //viewholder bergunu u ngereset data ke view kita
    class TerkiniViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(rumah: Home, listener: (Home) -> Unit){
            with(itemView){
                tv_name_rumah.setText(rumah.name)
                tv_address_rumah.setText(rumah.address)

                itemView.setOnClickListener { listener(rumah) }
            }
        }
    }
}