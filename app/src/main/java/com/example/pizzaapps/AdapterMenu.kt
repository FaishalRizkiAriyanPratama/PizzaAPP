package com.example.pizzaapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapps.response.food.FoodResponse
import com.squareup.picasso.Picasso

class AdapterMenu(private val listMenu: ArrayList<FoodResponse>):
    RecyclerView.Adapter<AdapterMenu.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //inner class
        val imgGambar = view.findViewById<ImageView>(R.id.imageViewMenu)
        val txtNama = view.findViewById<TextView>(R.id.textViewNamaMenu)
        val txtharga = view.findViewById<TextView>(R.id.textViewHargaMenu)

        val context = view.context


            fun bind(response: FoodResponse){
                val name = "${response.food_name}"
                val price = "${response.price}"
                val picture = "${response.food_picture}"

                txtNama.text = name
                txtharga.text = price
                var url = "http://10.24.2.37/rest_api3384/gambar/" + picture
                Picasso.get().load(url).into(imgGambar)
            }
        }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterMenu.ViewHolder {
        val layInflate = LayoutInflater.from(parent.context)
        val cellForRow = layInflate.inflate(R.layout.card_layout_menu, parent, false)

        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: AdapterMenu.ViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

}

private fun AdapterMenu.ViewHolder.bind(response: FoodResponse) {}
