package com.abdulmohsen.universities.presentation

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdulmohsen.base.BaseFragment
import com.abdulmohsen.common.UiState
import com.abdulmohsen.universities.databinding.FragmentUniversitiesBinding
import com.abdulmohsen.universities.di.UniversitiesComponentProvider
import com.abdulmohsen.universities.domain.model.University
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversitiesFragment : BaseFragment<FragmentUniversitiesBinding>() {
    @Inject
    lateinit var universitiesViewModelFactory: UniversitiesViewModelFactory

    private val viewModel: UniversitiesViewModel by viewModels { universitiesViewModelFactory }

    private lateinit var universitiesAdapter: UniversitiesAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUniversitiesBinding
        get() = FragmentUniversitiesBinding::inflate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as UniversitiesComponentProvider).provideUniversitiesComponent()
            .inject(this)
    }

    override fun setup() {
        universitiesAdapter = UniversitiesAdapter {
            val uri = Uri.parse("myApp://DetailsFragment?name=${it.name}")
            findNavController().navigate(uri)
        }

        binding.UniversitiesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.UniversitiesRv.adapter = universitiesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateflow.collect(::handleViewState)
            }
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>("should_refresh")
            ?.observe(viewLifecycleOwner) { shouldRefresh ->
                if (shouldRefresh) viewModel.refreshUniversities()
            }
    }

    private fun handleViewState(uiState: UiState<List<University>>) {
        when (uiState) {
            is UiState.Loading -> {
                binding.progressBar.isVisible = true
                binding.error.isVisible = false
                binding.UniversitiesRv.isVisible = false
            }
            is UiState.Success -> {
                universitiesAdapter.addAll(uiState.data ?: mutableListOf())
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
                binding.UniversitiesRv.isVisible = true
            }
            is UiState.Error -> {
                binding.progressBar.isVisible = false
                binding.error.isVisible = true
                binding.UniversitiesRv.isVisible = false
            }
        }
    }
}