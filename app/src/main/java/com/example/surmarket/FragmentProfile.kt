package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment() {

    private lateinit var IMV_FRGProfile_Back: ImageView
    private lateinit var TXV_FRGProfile_Title: TextView
    private lateinit var TXV_FRGProfile_UserName: TextView
    private lateinit var TXV_FRGProfile_UserId: TextView
    private lateinit var BTN_FRGProfile_ChangePassword: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeViews(view)
        configureListeners()
    }

    private fun initalizeViews(view: View) {
        IMV_FRGProfile_Back = view.findViewById(R.id.IMV_FRGProfile_Back)
        TXV_FRGProfile_Title = view.findViewById(R.id.TXV_FRGProfile_Title)
        TXV_FRGProfile_UserName = view.findViewById(R.id.TXV_FRGProfile_UserName)
        TXV_FRGProfile_UserId = view.findViewById(R.id.TXV_FRGProfile_UserId)
        BTN_FRGProfile_ChangePassword = view.findViewById(R.id.BTN_FRGProfile_ChangePassword)
    }

    private fun configureListeners() {
        IMV_FRGProfile_Back.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        BTN_FRGProfile_ChangePassword.setOnClickListener {
            Toast.makeText(
                requireContext(),
                getString(R.string.FRGProfile_BTNChangePassword),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
