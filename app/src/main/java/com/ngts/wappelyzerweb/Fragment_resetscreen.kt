package com.ngts.wappelyzerweb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngts.wappelyzerweb.databinding.FragmentResetscreenBinding

class Fragment_resetscreen : Fragment() {
    private lateinit var binding: FragmentResetscreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetscreenBinding.inflate(inflater, container, false)
        return  binding.root
    }

}