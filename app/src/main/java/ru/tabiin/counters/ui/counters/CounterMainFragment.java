package ru.tabiin.counters.ui.counters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ru.tabiin.counters.databinding.FragmentCounterMainBinding;

public class CounterMainFragment extends Fragment {
    private FragmentCounterMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCounterMainBinding.inflate(getLayoutInflater());
        // код
        return binding.getRoot();
    }
}
