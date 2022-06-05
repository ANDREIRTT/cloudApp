package com.mal.cloud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mal.cloud.core.di.fragmentQualifiers.AuthFragment
import com.mal.cloud.core.di.fragmentQualifiers.FilesFragment
import com.mal.cloud.databinding.ActivityMainBinding
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    @AuthFragment
    lateinit var authFragment: Fragment

    @Inject
    @FilesFragment
    lateinit var filesFragment: Fragment

    @Inject
    lateinit var authDataRepository: AuthDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!authDataRepository.isLoggedIn()) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, authFragment)
                .commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, filesFragment)
                .commit()
        }
    }
}