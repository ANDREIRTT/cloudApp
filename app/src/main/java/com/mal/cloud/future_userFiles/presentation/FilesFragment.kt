package com.mal.cloud.future_userFiles.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mal.cloud.databinding.FragmentFilesBinding
import com.mal.cloud.future_userFiles.presentation.adapter.FilesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class FilesFragment : Fragment() {

    @Inject
    lateinit var filesAdapter: FilesAdapter

    private val viewModel: FilesViewModel by viewModels()

    lateinit var binding: FragmentFilesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = filesAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launchWhenCreated {
            viewModel.liveData.collectLatest {
                filesAdapter.submitData(it)
            }
        }

    }
}