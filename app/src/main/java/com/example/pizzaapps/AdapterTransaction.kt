package com.example.pizzaapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//core - main
//1. connected card_layout & adapter, hitung jumlah data
// looping berapa kali (sesuai jmlh data)
class AdapterTransaction (private val listOrder: List<TransactionModel>) : RecyclerView.Adapter <
        AdapterTransaction.ViewHolderOrder> (){
    class ViewHolderOrder (view: View): RecyclerView.ViewHolder(view) {
        //connected adapter & card_layout
        val txtNama : TextView
        val txtHarga : TextView
        val txtJml : TextView
        val ImgGambar : ImageView
        val context = view.context
        init {
            txtNama = view.findViewById(R.id.textNamaMenu)
            txtHarga = view.findViewById(R.id.textHargaMenu)
            txtJml = view.findViewById(R.id.textQtyMenu)
            ImgGambar = view.findViewById(R.id.imageMenu)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val li = LayoutInflater.from(parent.context)
        val cfr = li.inflate(R.layout.card_layout_order, parent, false)
        return ViewHolderOrder(cfr)
    }

    override fun onBindViewHolder(holder: AdapterTransaction.ViewHolderOrder, position: Int) {
        //isi data + looping
        val modelTrx = listOrder[position]
        holder.txtNama.text = modelTrx.nama
        holder.txtHarga.text = modelTrx.harga
        holder.txtJml.text = modelTrx.jumlah
        holder.ImgGambar.setImageResource(modelTrx.gambar)

    }

    override fun getItemCount(): Int {
        return listOrder.size // hitung jumlah data yg tersimapan di list
    }

}