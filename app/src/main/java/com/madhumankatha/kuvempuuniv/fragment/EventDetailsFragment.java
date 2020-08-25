package com.madhumankatha.kuvempuuniv.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.databinding.EventdetailsBinding;
import com.madhumankatha.kuvempuuniv.viewmodels.AppViewModel;
import com.squareup.picasso.Picasso;

public class EventDetailsFragment extends Fragment {
    private EventdetailsBinding binding;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.eventdetails,container,false);

        bundle = getArguments();

        Picasso.
                get().
                load(bundle.get("img").toString())
                .fit()
                .into(binding.edtImgHeader);
        binding.edtTvTitle.setText(bundle.get("title").toString());
        binding.edtTvAuthor.setText(bundle.get("author").toString());
        binding.edtTvDate.setText(bundle.get("date").toString());
        binding.edtTvDesc.setText(bundle.get("desc").toString());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
