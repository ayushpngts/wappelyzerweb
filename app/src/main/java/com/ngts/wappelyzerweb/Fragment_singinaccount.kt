package com.ngts.wappelyzerweb

import android.app.ProgressDialog
import android.drm.ProcessedData
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.navigation.fragment.findNavController
import com.ngts.wappelyzerweb.databinding.FragmentSinginaccountBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment_singinaccount : Fragment() {

     lateinit var binding: FragmentSinginaccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentSinginaccountBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSinginaccountBinding.inflate(inflater, container, false)

        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_singin_accountFragment_to_fragment_home_screen)
        }

        binding.goToLoginScreen.setOnClickListener {
            findNavController().navigate(R.id.action_singin_accountFragment_to_fragment_Loginscreen)
        }

        return binding.root
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun fetchApi() {
        val quotesService = RetrofitHelper.getInstance().create(ApiService::class.java)
        GlobalScope.launch {
            val result = quotesService.getQuotes()
            if (result != null) {
                //Checking the results
                Log.d("ayushQuptes",result.body().toString())
            }
        }
    }
}
