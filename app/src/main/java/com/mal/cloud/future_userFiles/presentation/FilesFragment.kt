package com.mal.cloud.future_userFiles.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mal.cloud.databinding.FragmentFilesBinding
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.FilesAdapter
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.FilesLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class FilesFragment : Fragment() {

    @Inject
    lateinit var filesAdapter: FilesAdapter

    @Inject
    lateinit var concatAdapter: ConcatAdapter

    @Inject
    lateinit var filesLoadStateAdapter: FilesLoadStateAdapter

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

        initRecyclerView()

        lifecycleScope.launchWhenCreated {

            viewModel.liveData.collectLatest {
                filesAdapter.submitData(it)
            }
        }
    }

    private fun initRecyclerView() {
        filesAdapter.addLoadStateListener { loadStates ->
            filesLoadStateAdapter.loadState = when (loadStates.refresh) {
                is LoadState.NotLoading -> loadStates.append
                else -> loadStates.refresh
            }
        }

        binding.recyclerView.adapter = concatAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
    }


}