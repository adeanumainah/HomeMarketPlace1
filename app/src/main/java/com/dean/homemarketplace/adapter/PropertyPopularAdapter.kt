package com.dean.homemarketplace.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.ResponseItem
import com.dean.homemarketplace.ui.fragment.HomeFragment
import java.lang.String

class PropertyPopularAdapter(context: Context?, resource: Int, objects: List<ResponseItem>) :

    ArrayAdapter<ResponseItem?>(context!!, resource, objects) {
    private val personItem: List<ResponseItem> = objects
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup

    ): View {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.row_listh, parent, false)
        val txtNameRumah = v.findViewById<TextView>(R.id.tv_name_rumah)
        val txtAddressRumah = v.findViewById<TextView>(R.id.tv_address_rumah)
        val txtIdRumah = v.findViewById<TextView>(R.id.tv_id_rumah)

        txtIdRumah.text = (String.valueOf(personItem[position].id))
        txtNameRumah.text = (String.valueOf(personItem[position].name))
        txtAddressRumah.text = String.valueOf(personItem[position].address)

        v.setOnClickListener {
            val intent = Intent(context, HomeFragment::class.java)
            intent.putExtra("id", String.valueOf(personItem[position].id))
            intent.putExtra("name", personItem[position].name)
            intent.putExtra("desc", personItem[position].desc)
            context.startActivity(intent)
        }
        return v
    }
}