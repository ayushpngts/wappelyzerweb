package com.ngts.wappelyzerweb

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.ngts.wappelyzerweb.databinding.FragmentLoginscreenBinding

class Fragment_Loginscreen : Fragment() {

    private lateinit var binding: FragmentLoginscreenBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginscreenBinding.inflate(inflater, container, false)



        binding.forgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Loginscreen_to_forgotaccount2)
        }

        binding.loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_fragment_Loginscreen_to_fragment_home_screen)
        }

        binding.createNewAccount.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Loginscreen_to_singin_accountFragment)
        }


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        auth = Firebase.auth


        binding.continueWithGoogle.setOnClickListener {
             MainActivity().click()
        }


        return binding.root
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
      result ->

        if (result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            if (task.isSuccessful){
                val account:GoogleSignInAccount?=task.result
                val credential= GoogleAuthProvider.getCredential(account?.idToken, null)
                auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(requireActivity(),"Done", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_fragment_Loginscreen_to_fragment_home_screen)
                    }else{
                       Toast.makeText(requireActivity(),"Failed",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }else{
            Toast.makeText(requireActivity(),"Failed",Toast.LENGTH_LONG).show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etEmail

    }

}

