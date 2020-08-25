package com.madhumankatha.kuvempuuniv.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madhumankatha.kuvempuuniv.MainActivity;
import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.adpaters.Adpater;
import com.madhumankatha.kuvempuuniv.adpaters.DocsAdpater;
import com.madhumankatha.kuvempuuniv.databinding.RecyclerviewBinding;
import com.madhumankatha.kuvempuuniv.viewmodels.AppViewModel;

public class DocsFragment extends Fragment {
    private RecyclerviewBinding binding;
    private AppViewModel viewModel;
    private DocsAdpater adpater;
    private Context context;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.recyclerview,container,false);
        context = getActivity();
        bundle = getArguments();
        binding.recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        binding.recyclerview.setLayoutManager(layoutManager);
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        //Type 1 == Documents
        if (bundle.get("type").toString().equals("1")){
            viewModel.getEDocumentsList().observe(getViewLifecycleOwner(),docs -> {
                adpater = new DocsAdpater(docs,context);
                binding.recyclerview.setAdapter(adpater);
            });
        }
        //Type 2 == ebooks
        else if (bundle.get("type").toString().equals("2")){
            ((MainActivity) getActivity()).getSupportActionBar().setTitle("E-Books");
            viewModel.getEBookList().observe(getViewLifecycleOwner(),ebooks -> {
                adpater = new DocsAdpater(ebooks,context);
                binding.recyclerview.setAdapter(adpater);
            });
        }
        //Type 3 == earticles
        else if (bundle.get("type").toString().equals("3")){
            ((MainActivity) getActivity()).getSupportActionBar().setTitle("E-Articles");
            viewModel.getEArticlesList().observe(getViewLifecycleOwner(),earticles -> {
                adpater = new DocsAdpater(earticles,context);
                binding.recyclerview.setAdapter(adpater);
            });
        }
        //Type 4 == eqbooks
        else if (bundle.get("type").toString().equals("4")){
            ((MainActivity) getActivity()).getSupportActionBar().setTitle("E-Question Bank");
            viewModel.getEQBookList().observe(getViewLifecycleOwner(),eqbooks -> {
                adpater = new DocsAdpater(eqbooks,context);
                binding.recyclerview.setAdapter(adpater);
            });
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
