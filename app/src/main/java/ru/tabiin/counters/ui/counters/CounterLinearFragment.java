package ru.tabiin.counters.ui.counters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.FragmentCounterLinearBinding;

public class CounterLinearFragment extends Fragment {
    private FragmentCounterLinearBinding binding;
    private CounterViewModel counterViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCounterLinearBinding.inflate(getLayoutInflater());

        counterViewModel = new ViewModelProvider(this,
                (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                        .getInstance(getActivity().getApplication()))
                .get(CounterViewModel.class);

        /**
         * onClickListener
         */


        binding.counterBtnPlus.setOnClickListener(v -> {

        });

        binding.counterBtnMinus.setOnClickListener(v -> {

        });

        binding.counterResetBtn.setOnClickListener(v -> {

        });

        binding.editCounterBtn.setOnClickListener(v -> {

        });



        return binding.getRoot();
    }
}