package com.dean.homemarketplace.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.dean.homemarketplace.R
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.Home
//import com.dean.homemarketplace.model.ResponseItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_see_all_terkini.*
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllTerkiniActivity : AppCompatActivity() {
//
//    private val listHome = ArrayList<Home>()
//    var responseItem: MutableList<ProductItem> = ArrayList()
//    var proyekTerkiniAdapter: ProyekTerkiniAdapter? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_see_all_terkini)
//        supportActionBar?.hide()
//
//        NetworkConfig().getService()
//                .getUsers()
//                .enqueue(object : Callback<List<ProductItem>> {
//                    override fun onFailure(call: Call<List<ProductItem>>, t: Throwable) {
//                        Toast.makeText(this@SeeAllTerkiniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//                        Log.d("TEST", "onFailure: ${t.localizedMessage}")
//                    }
//
//                    override fun onResponse(
//                            call: Call<List<ProductItem>>,
//                            response: Response<List<ProductItem>>
//                    ) {
//                        Log.d("TEST", "onResponse: ${Gson().toJson(response.body())}")
//                        rv_see_all_terkini.adapter = ProyekTerkiniAdapter(response.body())
//                    }
//
//                })
//
//        rv_see_all_terkini.setHasFixedSize(true)
//        rv_see_all_terkini.layoutManager = LinearLayoutManager(this)
//        getListHome()
//    }
//
//    private fun getListHome() {
//        AndroidNetworking.get(com.dean.homemarketplace.utils.APIUtils.API_URL)
//            .setPriority(Priority.MEDIUM).build().getAsJSONArray(object : JSONArrayRequestListener {
//                override fun onResponse(response: JSONArray) {
//                    for (i in 0 until response.length()) {
//                        try {
//                            val dataApi = ProductItem()
//                            val jsonObject = response.getJSONObject(i)
//                            dataApi.name = jsonObject.getString("name")
//                            dataApi.address = jsonObject.getString("address")
//                            dataApi.price = jsonObject.getInt("price")
//                            dataApi.type = jsonObject.getString("type")
//                            dataApi.propertyFacilities = jsonObject.getString("property_facilities")
//                            dataApi.certificate = jsonObject.getString("certificate")
//                            dataApi.furnished = jsonObject.getString("furnished")
//                            dataApi.numberOfFloors = jsonObject.getInt("number_of_floors")
//                            dataApi.surfaceArea = jsonObject.getString("surface_area")
//
//                            responseItem.add(dataApi)
////                            showRecyclerList()
////                            showRecyclerGrid()
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                            Toast.makeText(
//                                this@SeeAllTerkiniActivity,
//                                "Gagal menampilkan data",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//                }
//
//                override fun onError(anError: ANError?) {
//                    Toast.makeText(
//                        this@SeeAllTerkiniActivity,
//                        "Semangat benerin eror nya cantik!!",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            })
//
//    }

//    private fun showRecyclerList() {
//        proyekTerkiniAdapter = ProyekTerkiniAdapter(this@SeeAllTerkiniActivity.listHome)
//        rv_see_all_terkini!!.adapter = proyekTerkiniAdapter
//    }
//
//    private fun showRecyclerGrid() {
//        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
//        rv_see_all_terkini.layoutManager = layoutManagerStaggered
//        rv_see_all_terkini.adapter = ProyekTerkiniAdapter(listHome)
//    }

}