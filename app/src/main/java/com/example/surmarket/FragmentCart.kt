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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class FragmentCart : Fragment() {

    private lateinit var IMV_FRGCart_Back: ImageView
    private lateinit var TXV_FRGCart_Title: TextView
    private lateinit var RCV_FRGCart_CartList: RecyclerView
    private lateinit var BTN_FRGCart_FinalizarCompra: Button

    private lateinit var adapterCart: AdapterCart
    private var listaCarrito = mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeViews(view)
        configureListeners()
        configureRecyclerView()
        loadSampleCartProducts()
    }

    private fun initalizeViews(view: View) {
        IMV_FRGCart_Back = view.findViewById(R.id.IMV_FRGCart_Back)
        TXV_FRGCart_Title = view.findViewById(R.id.TXV_FRGCart_Title)
        RCV_FRGCart_CartList = view.findViewById(R.id.RCV_FRGCart_CartList)
        BTN_FRGCart_FinalizarCompra = view.findViewById(R.id.BTN_FRGCart_FinalizarCompra)
    }

    private fun configureListeners() {
        IMV_FRGCart_Back.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        BTN_FRGCart_FinalizarCompra.setOnClickListener {
            Toast.makeText(requireContext(), "GRACIAS POR SU COMPRA", Toast.LENGTH_SHORT).show()
        }
    }

    private fun configureRecyclerView() {
        adapterCart = AdapterCart(
            cartList = listaCarrito,
            clickOnPlus = { _ -> },
            clickOnMinus = { _ -> }
        )
        RCV_FRGCart_CartList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterCart
        }
    }

    private fun loadSampleCartProducts() {
        val sampleCart = listOf(
            product(
                id = 1,
                name = "camisa",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Camisa de varón Tommy Roja",
                available = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Pantalón",
                category = "Ropa de Varón",
                price = 210.0,
                imageUrl = "",
                description = "Pantalón de jean azul",
                available = true,
                stock = 1
            )
        )
        listaCarrito.clear()
        listaCarrito.addAll(sampleCart)
        adapterCart.notifyChanged()
    }
}
