package ru.tabiin.counters.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(getLayoutInflater());

        // код

        return binding.getRoot();
    }
}