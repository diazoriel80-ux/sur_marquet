package com.example.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class AdapterCart(
    private val cartList: List<product>,
    private val clickOnPlus: (product) -> Unit,
    private val clickOnMinus: (product) -> Unit
) : RecyclerView.Adapter<AdapterCart.ViewHolderCart>() {

    class ViewHolderCart(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val TXV_ITCart_Category: TextView = itemView.findViewById(R.id.TXV_ITCart_Category)
        val TXV_ITCart_ProductName: TextView = itemView.findViewById(R.id.TXV_ITCart_ProductName)
        val TXV_ITCart_Price: TextView = itemView.findViewById(R.id.TXV_ITCart_Price)
        val TXV_ITCart_Quantity: TextView = itemView.findViewById(R.id.TXV_ITCart_Quantity)
        val BTN_ITCart_Minus: Button = itemView.findViewById(R.id.BTN_ITCart_Minus)
        val BTN_ITCart_Plus: Button = itemView.findViewById(R.id.BTN_ITCart_Plus)
        val IMV_ITCart_ProductImage: ImageView = itemView.findViewById(R.id.IMV_ITCart_ProductImage)
        val stringCategory = itemView.context.getString(R.string.category)
        val stringPrice = itemView.context.getString(R.string.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCart {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolderCart(itemView = vista)
    }

    override fun onBindViewHolder(holder: ViewHolderCart, position: Int) {
        val product = cartList[position]

        holder.TXV_ITCart_Category.text = holder.stringCategory + ": " + product.category
        holder.TXV_ITCart_ProductName.text = product.name
        holder.TXV_ITCart_Price.text = holder.stringPrice + ": " + "${product.price}"
        holder.IMV_ITCart_ProductImage.setImageResource(R.drawable.s_market)

        holder.BTN_ITCart_Plus.setOnClickListener {
            Toast.makeText(holder.itemView.context, "MAS", Toast.LENGTH_SHORT).show()
            clickOnPlus(product)
        }

        holder.BTN_ITCart_Minus.setOnClickListener {
            Toast.makeText(holder.itemView.context, "MENOS", Toast.LENGTH_SHORT).show()
            clickOnMinus(product)
        }
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    fun notifyChanged() {
        notifyDataSetChanged()
    }
}
