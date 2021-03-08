package com.dean.homemarketplace.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.SignInActivity
import com.dean.homemarketplace.model.Users
import com.dean.homemarketplace.utils.Constan
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity

class ProfileFragment : Fragment() {

    var auth: FirebaseAuth? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(Constan.tb_user)
        val query = myRef.orderByChild("uid").equalTo(auth?.uid)

        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (issue in snapshot?.children){
                    val data = issue?.getValue(Users::class.java)
                    showProfile(data)
                }
            }
        })
    }

    private fun showProfile(data: Users?) {
        tv_username_profile.text = data?.name
        tv_email_profile.text = data?.email
        tv_phone_profile.text = data?.phone

        btn_signout.onClick {
            auth?.signOut()
            startActivity<SignInActivity>()
        }

    }



}