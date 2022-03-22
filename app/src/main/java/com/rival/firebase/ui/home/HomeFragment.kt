package com.rival.firebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.rival.firebase.R
import com.rival.firebase.adapter.AdapterSlider
import com.rival.firebase.databinding.FragmentHomeBinding
import java.util.ArrayList

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
lateinit var vpCarousel : ViewPager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // menghilangkan action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        (requireActivity() as AppCompatActivity).window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)


        vpCarousel = view.findViewById(R.id.vp_carousel)

        val arraySlider = ArrayList<Int>()
        arraySlider.add(R.drawable.carousel2)
        arraySlider.add(R.drawable.carousel3)
        arraySlider.add(R.drawable.carousel4)

        val adapterSlider = AdapterSlider(arraySlider, activity)
        vpCarousel.adapter = adapterSlider

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}