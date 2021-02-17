package com.dean.homemarketplace.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.DetailActivity
import com.dean.homemarketplace.model.Home
import com.synnapps.carouselview.ImageListener

class HomeFragment : Fragment() {

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

    }


//    private fun showSelected(it : Home) {
//        val page = Intent(context, DetailActivity::class.java)
//        page.putExtra(DetailActivity.KEY_POPULAR_HOME, it)
//        startActivity(page)
//
//    }


}