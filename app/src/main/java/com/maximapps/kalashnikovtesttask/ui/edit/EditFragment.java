package com.maximapps.kalashnikovtesttask.ui.edit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.maximapps.kalashnikovtesttask.databinding.FragmentEditBinding;
import com.maximapps.kalashnikovtesttask.di.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class EditFragment extends Fragment {
    private EditFragmentArgs args;
    private EditViewModel viewModel;
    private FragmentEditBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentEditBinding.inflate(inflater, container, false);
        args = EditFragmentArgs.fromBundle(getArguments());
        viewModel = new ViewModelProvider(this, providerFactory).get(EditViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.description.setText(args.getDescription());
        binding.description.setSelection(binding.description.length());
        binding.saveButton.setOnClickListener(v -> {
            viewModel.updateBookDescriptionById(args.getId(), binding.description.getText().toString());
            Navigation.findNavController(requireView()).navigateUp();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
