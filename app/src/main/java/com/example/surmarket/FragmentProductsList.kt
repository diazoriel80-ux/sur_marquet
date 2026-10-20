package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentProductsList : Fragment(){

    private lateinit var IMV_FRGProductsList_Shoppingcart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_addProducto: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeViews(view)
        configureListener()


    }

    private fun initalizeViews(view: View)
    {
         IMV_FRGProductsList_Shoppingcart= view.findViewById(R.id.IMV_FRGProductsList_Shoppingcart)
        IMV_FRGProductsList_Search= view.findViewById(R.id.IMV_FRGProductsList_Search)
        ETX_FRGProductsList_Search= view.findViewById(R.id.ETX_FRGProductsList_Search)
         BTN_FRGProductsList_addProducto= view.findViewById(R.id.BTN_FRGProductsList_addProducto)
       RCV_FRGProductsList_ProductsList= view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
    }
 private fun configureListener(){

 }

}