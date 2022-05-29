package com.mal.cloud

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mal.cloud.databinding.ActivityMainBinding
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import com.mal.cloud.future_auth.presentation.AuthViewModel
import com.mal.cloud.future_auth.presentation.fragment.AuthFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var authFragment: Fragment

    @Inject
    lateinit var authDataRepository: AuthDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!authDataRepository.isLoggedIn()) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, authFragment).commit()
        }
    }
}