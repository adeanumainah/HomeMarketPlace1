package com.dean.homemarketplace.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.dean.homemarketplace.R
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseItem
import com.dean.homemarketplace.utils.NetworkConfig
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_see_all_terkini.*
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeeAllTerkiniActivity : AppCompatActivity() {

    private val listHome = ArrayList<Home>()
    var responseItem: MutableList<ResponseItem> = ArrayList()
    var proyekTerkiniAdapter: ProyekTerkiniAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_terkini)
        supportActionBar?.hide()

        NetworkConfig().getService()
                .getUsers()
                .enqueue(object : Callback<List<ResponseItem>> {
                    override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                        Toast.makeText(this@SeeAllTerkiniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                        Log.d("TEST", "onFailure: ${t.localizedMessage}")
                    }

                    override fun onResponse(
                            call: Call<List<ResponseItem>>,
                            response: Response<List<ResponseItem>>
                    ) {
                        Log.d("TEST", "onResponse: ${Gson().toJson(response.body())}")
                        rv_see_all_terkini.adapter = ProyekTerkiniAdapter(response.body())
                    }

                })

        rv_see_all_terkini.setHasFixedSize(true)
        rv_see_all_terkini.layoutManager = LinearLayoutManager(this)
        getListHome()
    }

    private fun getListHome() {
        AndroidNetworking.get(com.dean.homemarketplace.utils.APIUtils.API_URL)
            .setPriority(Priority.MEDIUM).build().getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    for (i in 0 until response.length()) {
                        try {
                            val dataApi = ResponseItem()
                            val jsonObject = response.getJSONObject(i)
                            dataApi.name = jsonObject.getString("name")
                            dataApi.address = jsonObject.getString("address")
                            dataApi.price = jsonObject.getString("price")
                            dataApi.type = jsonObject.getString("type")
                            dataApi.propertyFacilities = jsonObject.getString("property_facilities")
                            dataApi.certificate = jsonObject.getString("certificate")
                            dataApi.furnished = jsonObject.getString("furnished")
                            dataApi.numberOfFloors = jsonObject.getString("number_of_floors")
                            dataApi.surfaceArea = jsonObject.getString("surface_area")

                            responseItem.add(dataApi)
//                            showRecyclerList()
//                            showRecyclerGrid()
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Toast.makeText(
                                this@SeeAllTerkiniActivity,
                                "Gagal menampilkan data",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(
                        this@SeeAllTerkiniActivity,
                        "Semangat benerin eror nya cantik!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })

    }

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