package ru.tabiin.counters.ui.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.FragmentOtherSettingsBinding;

public class OtherSettingsFragment extends Fragment {
    FragmentOtherSettingsBinding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentOtherSettingsBinding.inflate(getLayoutInflater());



        return b.getRoot();
    }
}