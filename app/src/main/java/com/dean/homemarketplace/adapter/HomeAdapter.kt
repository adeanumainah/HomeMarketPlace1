package com.dean.homemarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.ResponseItem
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.row_listh.view.*

class HomeAdapter(val dataHome: List<ResponseItem>?) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        //ngeinflate layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listh, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int = dataHome?.size ?:0

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(dataHome?.get(position))
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ResponseItem?) {
//            Glide.with(itemView.context).load(home.images)
//                    .apply(RequestOptions().override(300)).into(iv_popular)

            itemView.tv_lable_name.text = get?.name
            itemView.tv_lable_address.text = get?.address
            itemView.tv_lable_price.text = get?.price
            itemView.tv_lable_desc.text = get?.desc
            itemView.tv_lable_type.text = get?.type
            itemView.tv_lable_developer.text = get?.developer
            itemView.tv_lable_fproperty.text = get?.propertyFacilities
            itemView.tv_lable_sertifikat.text = get?.certificate
            itemView.tv_lable_furnished.text = get?.furnished
            itemView.tv_lable_lantai.text = get?.numberOfFloors
            itemView.tv_lable_luas.text = get?.surfaceArea

        }
    }
}