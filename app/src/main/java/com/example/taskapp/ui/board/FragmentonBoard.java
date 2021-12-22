package com.example.taskapp.ui.board;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentOnBoardBinding;
import com.example.taskapp.databinding.PagerBoardBinding;
import com.example.taskapp.ui.home.HomeFragment;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class FragmentonBoard extends Fragment {
private FragmentOnBoardBinding binding;

private BoardAdapter adapter;
private Button button;
private ViewPager2 viewPager;
private PagerBoardBinding binding2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false);
        return binding.getRoot();


        }

        // Inflate the layout for this fragment



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.openBtn);

        viewPager = view.findViewById(R.id.boardPager);
        initViewPager();
initdots();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                 requireActivity().finish();
            }
        });
    }

    private void initdots() {

        DotsIndicator springDotsIndicator = binding.dotsIndicator;
        ViewPager2 viewPager = binding.boardPager;
        adapter = new BoardAdapter();
        viewPager.setAdapter(adapter);
        springDotsIndicator.setViewPager2(viewPager);
    }


    void initViewPager() {
        adapter = new BoardAdapter();
        binding.boardPager.setAdapter(adapter);
    }

}