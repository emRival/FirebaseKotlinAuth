package com.rival.firebase.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rival.firebase.DetailBukuActivity
import com.rival.firebase.DetailProdukActivity
import com.rival.firebase.R
import com.rival.firebase.model.ModelBuku
import com.rival.firebase.model.ModelProduk
import java.util.ArrayList

class AdapterBuku(var dataBuku : ArrayList<ModelBuku>, var context : Activity?) : RecyclerView.Adapter<AdapterBuku.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaBuku = view.findViewById<TextView>(R.id.tv_nama_buku)
        val tvHargaBuku = view.findViewById<TextView>(R.id.tv_harga_buku)
        val imgGambarBuku = view.findViewById<ImageView>(R.id.img_buku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return AdapterBuku.MyViewHolder(view)
    }

    override fun onBindViewHolder(tampil: MyViewHolder, position: Int) {
        tampil.tvNamaBuku.text = dataBuku[position].namaBuku
        tampil.tvHargaBuku.text = dataBuku[position].hargaBuku
        tampil.imgGambarBuku.setImageResource(dataBuku[position].gambarBuku)

        val cont = tampil.itemView.context
        tampil.itemView.setOnClickListener {
            val i = Intent(cont, DetailBukuActivity::class.java)
            i.putExtra("DTL", dataBuku?.get(position))
            cont.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return dataBuku.size
    }
}