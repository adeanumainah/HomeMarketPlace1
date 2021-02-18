package com.dean.homemarketplace.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.DetailActivity
import com.dean.homemarketplace.activity.SeeAllPopularActivity
import com.dean.homemarketplace.activity.SeeAllTerkiniActivity
import com.dean.homemarketplace.adapter.HomeAdapter
import com.dean.homemarketplace.adapter.PropertyPopularAdapter
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseItem
import com.dean.homemarketplace.utils.NetworkConfig
import com.dean.homemarketplace.utils.ProductServices
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_see_all_terkini.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class HomeFragment : Fragment() {

    private val rumahList = ArrayList<Home>()
    var list: List<ResponseItem> = ArrayList<ResponseItem>()
    private lateinit var proyekterkiniAdapter: ProyekTerkiniAdapter
    var propertyServices: ProductServices? = null
    var rv: ListView? = null
    private lateinit var propertypopularAdapter: PropertyPopularAdapter

    companion object{
        fun defaultFragment(): HomeFragment{
            val home_fragment = HomeFragment()
            //ngirim ke oncreate
            val bundle = Bundle()
            //arguments default function u ngirim data
            home_fragment.arguments = bundle
            return home_fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

        ListHome

    }

    private val ListHome: Unit
        get() {
            val call: Call<List<ResponseItem>>? = propertyServices?.product
            call?.enqueue(object : Callback<List<ResponseItem>> {

                override fun onResponse(call: Call<List<ResponseItem>>, response: Response<List<ResponseItem>>) {
                    if (response.isSuccessful) {
                        list = response.body()!!
                        rv!!.adapter = PropertyPopularAdapter(
                            this@HomeFragment.context,
                            R.layout.row_listh, list
                        )

                    }
                }

                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                    Log.e("ERROR: ", t.message!!)
                }

            })
        }

    val imageContentSlider = intArrayOf(
        R.drawable.rumah1,
        R.drawable.rumah2,
        R.drawable.rumah3,
        R.drawable.rumah4

    )

    val imageContentList: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            imageView?.setImageResource(imageContentSlider[position])

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carouselView = is_main as CarouselView
        //set yang sudah ditempel
        carouselView.setImageListener(imageContentList)
        //membaca maximum index yang dibaca
        carouselView.setPageCount(imageContentSlider.count())

        tv_see_all_terkini.setOnClickListener {
            val intent = Intent(context, SeeAllTerkiniActivity::class.java)
            startActivity(intent)
        }

        tv_see_all_popular.setOnClickListener {
            val intentBest = Intent(context, SeeAllPopularActivity::class.java)
            startActivity(intentBest)
        }

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResponseItem>> {
                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                    Toast.makeText(activity,"Yahh! Ga muncul kasian dehh",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ResponseItem>>,
                    response: Response<List<ResponseItem>>
                ) {
                    rv_terkini.adapter = HomeAdapter(response.body())
                }

            })

    }

    private fun showSelected(it: Home) {
        val page = Intent(context, DetailActivity::class.java)
        page.putExtra(DetailActivity.KEY_POPULAR_HOME, it)
        startActivity(page)
    }


}