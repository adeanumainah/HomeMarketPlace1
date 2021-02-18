package com.dean.homemarketplace.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.Home
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_POPULAR_HOME = "key_popular_home"
    }

    private var home: Home? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        home = intent.getParcelableExtra(KEY_POPULAR_HOME)

        tv_lable_name.text = home?.name
        tv_lable_address.text = home?.address
        tv_lable_price.text = home?.price
        tv_lable_desc.text = home?.desc
        tv_lable_type.text = home?.type
        tv_lable_developer.text = home?.developer
        tv_lable_fproperty.text = home?.property_facilities
        tv_lable_sertifikat.text = home?.certificate
        tv_lable_furnished.text = home?.furnished
        tv_lable_lantai.text = home?.number_of_floors
        tv_lable_luas.text = home?.surface_area
//
//        btn_call_us.setOnClickListener {
//            val nomor = "09667347"
//            val panggil = Intent(Intent.ACTION_DIAL)
//            panggil.data = Uri.fromParts("tel", nomor, null)
//            startActivity(panggil)
//        }

    }

    fun panggil(view: View) {
        val nomor = "09667347"
        val panggil = Intent(Intent.ACTION_DIAL)
        panggil.data = Uri.fromParts("tel", nomor, null)
        startActivity(panggil)
    }


}