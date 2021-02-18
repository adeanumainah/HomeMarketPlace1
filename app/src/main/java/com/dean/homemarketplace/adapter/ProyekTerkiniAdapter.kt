package com.dean.homemarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.Home
import kotlinx.android.synthetic.main.row_listh.view.*

class ProyekTerkiniAdapter (
    private val listStaggeredHome: ArrayList<Home>):
    RecyclerView.Adapter<ProyekTerkiniAdapter.TerkiniViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TerkiniViewHolder {
        //ngeinflate layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listh, parent, false)
        return TerkiniViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggeredHome.size

    override fun onBindViewHolder(holder: TerkiniViewHolder, position: Int) {
        holder.bind(listStaggeredHome[position])
    }

    //viewholder bergunu u ngereset data ke view kita
    class TerkiniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(home: Home) {
            with(itemView) {

                tv_name_rumah.text = home.name
                tv_address_rumah.text = home.address

            }
        }
    }

}