package com.maximapps.kalashnikovtesttask.ui.details;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.maximapps.kalashnikovtesttask.HostActivity;
import com.maximapps.kalashnikovtesttask.R;
import com.maximapps.kalashnikovtesttask.databinding.FragmentDetailsBinding;
import com.maximapps.kalashnikovtesttask.di.viewmodel.ViewModelProviderFactory;
import com.maximapps.kalashnikovtesttask.utils.DateUtil;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class DetailsFragment extends Fragment {
    private int id;
    private DetailsViewModel viewModel;
    private FragmentDetailsBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        id = DetailsFragmentArgs.fromBundle(getArguments()).getId();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, providerFactory).get(DetailsViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.editOption) {
            NavController controller = findNavController(requireView());
            controller.navigate(DetailsFragmentDirections.actionDetailsFragmentToEditFragment(
                    id, binding.description.getText().toString()));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.fetchBookById(id).observe(getViewLifecycleOwner(), book -> {
            getActionBar().setTitle(book.getName());
            String name = book.getAuthorName();
            String birthDay = DateUtil.formatDate(book.getAuthorBirthDate());
            binding.author.setText(getResources().getString(R.string.author, name, birthDay));
            binding.description.setText(book.getDescription());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private ActionBar getActionBar() {
        return ((HostActivity) requireActivity()).getSupportActionBar();
    }
}
