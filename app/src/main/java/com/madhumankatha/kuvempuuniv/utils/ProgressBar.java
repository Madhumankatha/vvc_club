package com.madhumankatha.kuvempuuniv.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressBar {

    public ProgressDialog progressDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        return progressDialog;
    }
}
