package com.madhumankatha.kuvempuuniv.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.madhumankatha.kuvempuuniv.MainActivity;
import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.databinding.DocsFragmentBinding;
import com.madhumankatha.kuvempuuniv.utils.ProgressBar;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class DocsDetailsFragment extends Fragment implements EasyPermissions.PermissionCallbacks {
    private DocsFragmentBinding binding;
    private Bundle bundle;
    private Context context;
    private static final int WRITE_REQUEST_CODE = 300;
    private String fileUrl,filePath,fileName;
    private ProgressBar progressBar = new ProgressBar();
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.docs_fragment,container,false);

        context = getActivity();
        bundle = getArguments();

        final PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .setReadTimeout(30_000)
                .setConnectTimeout(30_000)
                .build();
        PRDownloader.initialize(context, config);

        dialog = progressBar.progressDialog(context);

        fileName = bundle.get("title").toString() + ".pdf";
        fileUrl = bundle.get("pdf").toString();
        filePath = context.getFilesDir().getPath();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(bundle.get("title").toString());

        File file =  new File(filePath + File.separator + fileName);
        dialog.show();

        if (file.isFile()){
            loadPdfFromPath(filePath + File.separator + fileName);
        }else if (EasyPermissions.hasPermissions(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            downloadFile();
        }else {
            EasyPermissions.requestPermissions(this,getString(R.string.write_file),WRITE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
        }



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        downloadFile();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            Toast.makeText(context, "Grant me storage permission", Toast.LENGTH_SHORT).show();
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    private void downloadFile(){
        dialog.show();
        PRDownloader.download(fileUrl,filePath,fileName)
                .build()
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        loadPdfFromPath(filePath + File.separator +fileName);
                    }

                    @Override
                    public void onError(Error error) {

                    }
                });
    }

    private void loadPdfFromPath(String path){
        File pdfPath = new File(path);

        dialog.dismiss();

        binding.pdfView.fromFile(pdfPath)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(new DefaultScrollHandle(context))
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                .load();
    }
}
