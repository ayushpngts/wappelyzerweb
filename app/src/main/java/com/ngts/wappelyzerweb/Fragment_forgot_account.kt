package com.ngts.wappelyzerweb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ngts.wappelyzerweb.databinding.FragmentForgotaccountBinding

class Fragment_forgot_account : Fragment() {
    private lateinit var binding: FragmentForgotaccountBinding
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotaccountBinding.inflate(inflater, container, false)


        binding.ico1.setOnClickListener {
            findNavController().navigate(R.id.action_forgotaccount_to_fragment_Loginscreen)
        }
        return binding.root
    }


}