package com.dean.homemarketplace.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.dean.homemarketplace.R
import com.dean.homemarketplace.adapter.PropertyPopularAdapter
import com.dean.homemarketplace.model.Home
//import com.dean.homemarketplace.model.ResponseItem
import kotlinx.android.synthetic.main.activity_see_all_popular.*
import org.json.JSONArray
import org.json.JSONException

class SeeAllPopularActivity : AppCompatActivity() {
//
//    private val listHome = ArrayList<Home>()
//    var responseItem: MutableList<ProductItem> = ArrayList()
//    var propertyPopularAdapter: PropertyPopularAdapter? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_see_all_popular)
//        supportActionBar?.hide()
//
//        rv_see_all_popular.setHasFixedSize(true)
//        rv_see_all_popular.layoutManager = LinearLayoutManager(this)
//        getListPopular()
//
//    }
//
//    private fun getListPopular(): ArrayList<Home> {
//        AndroidNetworking.get(com.dean.homemarketplace.utils.APIUtils.API_URL)
//                .setPriority(Priority.MEDIUM).build().getAsJSONArray(object :JSONArrayRequestListener{
//                    override fun onResponse(response: JSONArray) {
//                        for (i in 0 until response.length()){
//                            try {
//                                val dataApiPopular = ProductItem()
//                                val jsonObject = response.getJSONObject(i)
//                                dataApiPopular.name = jsonObject?.getString("name")
//                                dataApiPopular.address = jsonObject.getString("address")
//                                dataApiPopular.price = jsonObject.getInt("price")
//                                dataApiPopular.type = jsonObject.getString("type")
//                                dataApiPopular.propertyFacilities = jsonObject.getString("property_facilities")
//                                dataApiPopular.certificate = jsonObject.getString("certificate")
//                                dataApiPopular.furnished = jsonObject.getString("furnished")
//                                dataApiPopular.numberOfFloors = jsonObject.getInt("number_of_floors")
//                                dataApiPopular.surfaceArea = jsonObject.getString("surface_area")
//
//                                responseItem.add(dataApiPopular)
//                                showRecyclerList()
//                                showRecyclerGrid()
//                            } catch (e : JSONException){
//                                e.printStackTrace()
//                                Toast.makeText(this@SeeAllPopularActivity,
//                                "Gagal menampilkan data", Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        }
//                    }
//
//                    override fun onError(anError: ANError?) {
//                        Toast.makeText(this@SeeAllPopularActivity,
//                        "gabisa tampil, semangat cari eror nya!!", Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                })
//
//        return listHome
//    }
//
//    private fun showRecyclerList() {
////        propertyPopularAdapter = PropertyPopularAdapter(this@SeeAllPopularActivity.listHome)
////        rv_see_all_popular!!.adapter = propertyPopularAdapter
//    }
//
//    private fun showRecyclerGrid() {
//        TODO("Not yet implemented")
//    }


}