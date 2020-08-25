package com.madhumankatha.kuvempuuniv.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.adpaters.Adpater;
import com.madhumankatha.kuvempuuniv.databinding.DemoBinding;
import com.madhumankatha.kuvempuuniv.databinding.RecyclerviewBinding;
import com.madhumankatha.kuvempuuniv.model.Event;
import com.madhumankatha.kuvempuuniv.utils.ProgressBar;
import com.madhumankatha.kuvempuuniv.viewmodels.AppViewModel;

import java.util.List;

public class  HomeFragment extends Fragment {
    private RecyclerviewBinding binding;
    private AppViewModel viewModel;
    private Adpater adpater;
    private Context context;
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.recyclerview,container,false);
        context = getActivity();

        binding.recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        binding.recyclerview.setLayoutManager(layoutManager);
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        viewModel.getEventsList().observe(getViewLifecycleOwner(),events ->
        {
            adpater = new Adpater(events,context);
            binding.recyclerview.setAdapter(adpater);
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
