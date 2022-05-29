package com.mal.cloud.future_auth.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mal.cloud.R
import com.mal.cloud.databinding.BottomSheetDialogAuthBinding
import com.mal.cloud.future_auth.domain.dto.UserRole
import com.mal.cloud.future_auth.presentation.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthDialogFragment : BottomSheetDialogFragment() {

    private lateinit var action: AuthAction

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        action = stringToAction(requireArguments().getString(ACTION, ""))
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).also {
            (it as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = BottomSheetDialogAuthBinding.inflate(inflater, container, false)

        when (action) {
            AuthAction.LOG_IN -> {
                binding.textViewTitle.text = resources.getString(R.string.log_in)
                binding.buttonAction.setOnClickListener {
                    authViewModel.login(
                        username = binding.editTextLogin.text.toString(),
                        password = binding.editTextRegister.text.toString()
                    )
                }
            }
            AuthAction.SING_UP -> {
                binding.textViewTitle.text = resources.getString(R.string.sing_up)
                binding.buttonAction.setOnClickListener {
                    authViewModel.register(
                        username = binding.editTextLogin.text.toString(),
                        password = binding.editTextRegister.text.toString(),
                        userRole = UserRole.ROLE_USER
                    )
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.authLiveData.observe(viewLifecycleOwner) {

        }
    }

    private fun stringToAction(action: String): AuthAction {
        return when (action) {
            AuthAction.LOG_IN.name -> {
                AuthAction.LOG_IN
            }
            AuthAction.SING_UP.name -> {
                AuthAction.SING_UP
            }
            else -> {
                throw Exception("non valid param $action to AuthAction")
            }
        }
    }


    companion object {
        const val ACTION = "logIn"
    }
}