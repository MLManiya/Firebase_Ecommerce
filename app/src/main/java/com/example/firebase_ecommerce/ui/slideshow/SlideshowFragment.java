package com.example.firebase_ecommerce.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_ecommerce.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    ViewAdapter adapter;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return getView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}