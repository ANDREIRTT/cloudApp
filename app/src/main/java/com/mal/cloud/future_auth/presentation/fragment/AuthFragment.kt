package com.mal.cloud.future_auth.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mal.cloud.databinding.FragmentAuthBinding
import com.mal.cloud.future_auth.presentation.dialog.AuthAction
import com.mal.cloud.future_auth.presentation.dialog.AuthDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : Fragment() {

    @Inject
    lateinit var authDialogFragment: BottomSheetDialogFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAuthBinding.inflate(inflater, container, false)
        binding.buttonAuth.setOnClickListener {
            openBottomSheet(AuthAction.LOG_IN)
        }
        binding.buttonRegister.setOnClickListener {
            openBottomSheet(AuthAction.SING_UP)
        }
        return binding.root
    }

    private fun openBottomSheet(action: AuthAction) {
        val fragment = authDialogFragment.apply {
            arguments = Bundle().apply {
                putString(AuthDialogFragment.ACTION, action.name)
            }
        }
        fragment.show(parentFragmentManager, "")
    }
}