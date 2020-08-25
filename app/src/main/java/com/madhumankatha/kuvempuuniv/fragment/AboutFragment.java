package com.madhumankatha.kuvempuuniv.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.databinding.AboutFragmentBinding;

public class AboutFragment extends Fragment {
    private AboutFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.about_fragment,container,false);

        binding.wbAboutUs.getSettings().setJavaScriptEnabled(true);
        binding.wbAboutUs.getSettings().setAppCacheEnabled(true);
        binding.wbAboutUs.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        binding.wbAboutUs.loadUrl("file:///android_asset/about.html");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
