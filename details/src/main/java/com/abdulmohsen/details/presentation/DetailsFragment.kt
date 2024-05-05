package com.abdulmohsen.details.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.abdulmohsen.base.BaseFragment
import com.abdulmohsen.common.UiState
import com.abdulmohsen.details.databinding.FragmentDetailsBinding
import com.abdulmohsen.details.di.UniversityDetailsComponentProvider
import com.abdulmohsen.details.domain.model.UniversityDetails
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    @Inject
    lateinit var universityDetailsViewModelFactory: UniversityDetailsViewModelFactory

    private val viewModel: UniversityDetailsViewModel by viewModels { universityDetailsViewModelFactory }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val name = arguments?.getString("name").orEmpty()
        (requireActivity().applicationContext as UniversityDetailsComponentProvider)
            .provideUniversityDetailsComponent(name)
            .inject(this)
    }

    override fun setup() {
        handleClickListener()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateflow.collect(::handleViewState)
            }
        }
    }

    private fun handleClickListener() {
        binding.tvRefresh.setOnClickListener {
            findNavController().previousBackStackEntry
                ?.savedStateHandle
                ?.set(key = "should_refresh", value = true)
            findNavController().popBackStack()
        }
    }

    private fun handleViewState(uiState: UiState<UniversityDetails>) = when (uiState) {
        is UiState.Success -> {
            binding.tvUniversityName.text = uiState.data?.name.orEmpty()
            binding.tvState.text = uiState.data?.stateProvince.orEmpty()
            binding.tvCountry.text = uiState.data?.country.orEmpty()
            binding.tvCountryCode.text = uiState.data?.alphaTwoCode.orEmpty()
            binding.tvWebPage.text = uiState.data?.webPages?.firstOrNull().orEmpty()
        }
        else -> {/*no-op*/
        }
    }
}