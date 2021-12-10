package com.example.taskapp.ui.profile;


import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentHomeBinding;
import com.example.taskapp.databinding.FragmentProfileFragementBinding;

import java.io.IOException;


public class ProfileFragement extends Fragment {
    private static final int GALLERY_REQUEST = 1;
    String imageView;
private FragmentProfileFragementBinding binding;
private ActivityResultLauncher<String> mGetContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileFragementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initListener1();
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                Toast.makeText(requireContext(), result.toString(), Toast.LENGTH_SHORT).show();
                binding.ImageViewId.setImageURI(result);
            }
        });
    }
    public void initListener() {
        binding.ImageViewId.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
              /*  Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);*/
                mGetContent.launch("image/*");
            } else {
                ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        });
    }



    private void initListener1() {
    binding.ImageViewId.setOnClickListener(v -> {
        mGetContent.launch("image/*");
    });
    }



        }



