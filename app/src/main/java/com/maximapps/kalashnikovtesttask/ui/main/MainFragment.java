package com.maximapps.kalashnikovtesttask.ui.main;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.maximapps.kalashnikovtesttask.databinding.FragmentMainBinding;
import com.maximapps.kalashnikovtesttask.di.viewmodel.ViewModelProviderFactory;
import com.maximapps.kalashnikovtesttask.ui.main.list.BookListAdapter;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class MainFragment extends Fragment {
    private MainViewModel viewModel;
    private FragmentMainBinding binding;
    private final BookListAdapter adapter = new BookListAdapter();

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
            @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, providerFactory).get(MainViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bookList.setAdapter(adapter);
        adapter.setOnItemClickListener(id -> {
            NavController controller = findNavController(requireView());
            controller.navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(id));
        });
        viewModel.fetchBooks().observe(getViewLifecycleOwner(), adapter::setData);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
