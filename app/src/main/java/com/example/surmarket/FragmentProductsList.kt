package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product
import kotlin.Int
import kotlin.String

class FragmentProductsList : Fragment(){

    private lateinit var IMV_FRGProductsList_Shoppingcart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_addProducto: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    private lateinit var  adapterProducts: AdapterProducts
    private var listaProductos= mutableListOf<product>()

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
        configureRecyclerView()
        loadSampleProducts()


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
     BTN_FRGProductsList_addProducto.setOnClickListener (){
         Toast.makeText(requireContext(),getString(R.string.AddProduct), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_products_list_to_add_product)
     }
     IMV_FRGProductsList_Shoppingcart.setOnClickListener {
         findNavController().navigate(R.id.action_products_list_to_cart)
     }

 }
    private fun configureRecyclerView(){
     adapterProducts= AdapterProducts(
         productsList= listaProductos,
         { product ->
             Toast.makeText(requireContext(),getString(R.string.addCart)+"${product.name}",
                 Toast.LENGTH_SHORT).show()
         }
     )
        RCV_FRGProductsList_ProductsList.apply {
            layoutManager= LinearLayoutManager(requireContext())
            adapter= adapterProducts
        }
    }
    private fun loadSampleProducts(){
        val productsSample = listOf(
            product(
                id= 1,
                name="camisa",
                category= "Ropa de Varón ",
                price = 180.0,
                imageUrl= "",
                description= "Camisa de varón Tommy Roja" ,
                available= true,
                stock= 1
            ),
            product(
                id= 2,
                name="Pantalón",
                category= "Ropa de Varón ",
                price = 210.0,
                imageUrl= "",
                description= "Pantalón de jean azul" ,
                available= true,
                stock= 1
            ),
            product(
                id= 3,
                name="Polera ",
                category= "Ropa de Varón ",
                price = 160.0,
                imageUrl= "",
                description= "Polera polo totto azul" ,
                available= true,
                stock= 1
            ),
            product(
                id= 4,
                name="Zapatilla",
                category= "Ropa de Varón ",
                price = 530.0,
                imageUrl= "",
                description= "Zapatillas nike blanco" ,
                available= true,
                stock= 1
            ),
            product(
                id= 5,
                name="Zapatos",
                category= "Ropa de Varón ",
                price = 330.0,
                imageUrl= "",
                description= "zapatos negros manaco" ,
                available= true,
                stock= 1
            ),

        )
        listaProductos.clear()
        listaProductos.addAll(productsSample)
        adapterProducts.notifyChanged()
    }

}