package com.mal.cloud

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mal.cloud.databinding.ActivityMainBinding
import com.mal.cloud.future_auth.presentation.AuthViewModel
import com.mal.cloud.future_auth.presentation.fragment.AuthFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, AuthFragment()).commit()
    }
}