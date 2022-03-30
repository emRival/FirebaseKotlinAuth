package com.rival.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rival.firebase.model.ModelBuku
import com.rival.firebase.model.ModelProduk
import kotlinx.android.synthetic.main.activity_detail_buku.*
import kotlinx.android.synthetic.main.activity_detail_produk.*
import kotlinx.android.synthetic.main.activity_detail_produk.img_detail

class DetailBukuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_buku)

        val data = intent.getParcelableExtra<ModelBuku>("DTL")
        if (data != null) {
            tv_nama_buku.text = data.namaBuku
            tv_harga_buku.text = data.hargaBuku
            img_detail.setImageResource(data.gambarBuku)
        }
    }
}