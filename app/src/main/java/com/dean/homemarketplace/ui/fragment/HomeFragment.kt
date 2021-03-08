package com.dean.homemarketplace.ui.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.DetailActivity
import com.dean.homemarketplace.activity.SeeAllTerkiniActivity
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseHome
import com.dean.homemarketplace.utils.ApiService
//import com.dean.homemarketplace.model.ResponseItem
import com.google.gson.Gson
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_see_all_terkini.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var terkiniAdapter: ProyekTerkiniAdapter
    private lateinit var rv_terkini: RecyclerView

    companion object {
        fun defaultFragment(): HomeFragment {
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
        val v : View = inflater.inflate(R.layout.fragment_home, container, false)

        rv_terkini = v.findViewById(R.id.rv_terkini)
        // Inflate the layout for this fragment
        return v

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

        GetDatas()

        tv_see_all_terkini.setOnClickListener {
            val intent = Intent(context, SeeAllTerkiniActivity::class.java)
            startActivity(intent)
        }

//        tv_see_all_popular.setOnClickListener {
//            val intentBest = Intent(context, SeeAllPopularActivity::class.java)
//            startActivity(intentBest)
//        }

        terkiniAdapter = context?.let { ProyekTerkiniAdapter(it) }!!
        rv_terkini.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = terkiniAdapter
        }
    }

    private fun GetDatas() {

        var loading = ProgressDialog.show(context, "Request Data", "Loading..")
        ApiService.endpoint.getData().enqueue(
                object : Callback<ResponseHome> {
                    override fun onResponse(call: Call<ResponseHome>, response: Response<ResponseHome>) {
//                        Log.d("Response", "Success" + response.body()?.data)


                        loading.dismiss()
                        Log.d("DATA", "hide loading")
                        if (response.isSuccessful) {
                            val data = response.body()


                            Log.d("DATA", "success")
                            if(data?.status == 200) {
                                Log.d("DATA", "200")
                                if(!data.data.isNullOrEmpty()){
                                    Log.d("DATA", "ADA")
                                    Log.d("DATA", Gson().toJson(data.data))
                                    terkiniAdapter.setData(data.data!!)
                                }

                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseHome>, t: Throwable) {
                        Log.d("Response", "Failed : " + t.localizedMessage)
                        loading.dismiss()
                    }
                }


        )

    }



//    private fun showSelected(it: Home) {
//        val page = Intent(context, DetailActivity::class.java)
//        page.putExtra(DetailActivity.KEY_POPULAR_HOME, it)
//        startActivity(page)
//    }




}


