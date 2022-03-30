package com.rival.firebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.rival.firebase.R
import com.rival.firebase.adapter.AdapterBuku
import com.rival.firebase.adapter.AdapterProduk
import com.rival.firebase.adapter.AdapterSlider
import com.rival.firebase.databinding.FragmentHomeBinding
import com.rival.firebase.model.ModelBuku
import com.rival.firebase.model.ModelProduk
import java.util.ArrayList

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    lateinit var vpSlider : ViewPager
    lateinit var rvBaju:RecyclerView
    lateinit var rvBuku:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        (requireActivity() as AppCompatActivity).window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val view : View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)

        val arraySlider = ArrayList<Int>()
        arraySlider.add(R.drawable.carousel2)
        arraySlider.add(R.drawable.carousel3)
        arraySlider.add(R.drawable.carousel4)

        val adapterSlider = AdapterSlider(arraySlider, activity)
        vpSlider.adapter = adapterSlider


        // manggil item produk
        rvBaju = view.findViewById(R.id.rv_baju)
        val adapterBaju = AdapterProduk(arrayBaju, activity)
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        rvBaju.layoutManager = lm
        rvBaju.setHasFixedSize(true)
        rvBaju.adapter = adapterBaju

        // manggil item buku
        rvBuku = view.findViewById(R.id.rv_buku)
        val adapterBuku = AdapterBuku(arrayBuku, activity)
        val lmB = LinearLayoutManager(activity)
        lmB.orientation = LinearLayoutManager.HORIZONTAL
        rvBuku.layoutManager = lmB
        rvBuku.setHasFixedSize(true)
        rvBuku.adapter = adapterBuku


        return view
    }

    // array profuk
    val arrayBaju: ArrayList<ModelProduk>get() {
        val arrBj = ArrayList<ModelProduk>()
        val produkBaju1 = ModelProduk()
        produkBaju1.namaProduk = "Baju 1"
        produkBaju1.hargaProduk = "Rp. 100.000,-"
        produkBaju1.gambarProduk = R.drawable.baju_1

        val produkBaju2 = ModelProduk()
        produkBaju2.namaProduk = "Baju 2"
        produkBaju2.hargaProduk = "Rp. 99.000,-"
        produkBaju2.gambarProduk = R.drawable.baju_2

        val produkBaju3 = ModelProduk()
        produkBaju3.namaProduk = "jaket 1"
        produkBaju3.hargaProduk = "Rp. 100.000,-"
        produkBaju3.gambarProduk = R.drawable.jaket_1

        val produkBaju4 = ModelProduk()
        produkBaju4.namaProduk = "Baju kerah"
        produkBaju4.hargaProduk = "Rp. 100.000,-"
        produkBaju4.gambarProduk = R.drawable.kerah_1

        val produkBaju5 = ModelProduk()
        produkBaju5.namaProduk = "Baju Kerah 2"
        produkBaju5.hargaProduk = "Rp. 100.000,-"
        produkBaju5.gambarProduk = R.drawable.kerah_2

        val produkBaju6 = ModelProduk()
        produkBaju6.namaProduk = "Jaket 2"
        produkBaju6.hargaProduk = "Rp. 100.000,-"
        produkBaju6.gambarProduk = R.drawable.jaket_2

        arrBj.add(produkBaju1)
        arrBj.add(produkBaju2)
        arrBj.add(produkBaju3)
        arrBj.add(produkBaju4)
        arrBj.add(produkBaju5)
        arrBj.add(produkBaju6)

        return arrBj
    }

    // array profuk
    val arrayBuku: ArrayList<ModelBuku>get() {
        val arrBuk = ArrayList<ModelBuku>()
        val produkBuku1 = ModelBuku()
        produkBuku1.namaBuku = "Buku 1"
        produkBuku1.hargaBuku = "Rp. 100.000,-"
        produkBuku1.gambarBuku = R.drawable.buku_1

        val produkBuku2 = ModelBuku()
        produkBuku2.namaBuku = "Buku 2"
        produkBuku2.hargaBuku = "Rp. 100.000,-"
        produkBuku2.gambarBuku = R.drawable.buku_2

        val produkBuku3 = ModelBuku()
        produkBuku3.namaBuku = "Buku 3"
        produkBuku3.hargaBuku = "Rp. 100.000,-"
        produkBuku3.gambarBuku = R.drawable.buku_4



        arrBuk.add(produkBuku1)
        arrBuk.add(produkBuku2)
        arrBuk.add(produkBuku3)


        return arrBuk
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}