package ru.tabiin.counters.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.google.android.material.color.DynamicColors;
import com.google.android.material.switchmaterial.SwitchMaterial;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.FragmentSettingsBinding;
import ru.tabiin.counters.ui.about_app.AppAboutFragment;
import ru.tabiin.counters.util.SharedPreferencesUtils;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;
    private SwitchMaterial switchMaterial;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container,false);
        switchMaterial = (SwitchMaterial) binding.dynamicColorsSwitch;
        binding.appThemeRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "checkedButton", R.id.setFollowSystemTheme));
        binding.dynamicColorsSwitch.setEnabled(DynamicColors.isDynamicColorAvailable());
        switchMaterial.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "useDynamicColors"));
        //int[] setNightModeDescription = {R.string.auto_theme_description, R.string.system_theme_description, R.string.light_theme_description, R.string.night_theme_description};
        //binding.themeDescription.setText(setNightModeDescription[SharedPreferencesUtils.getInteger(requireContext(), "nightMode", 1)]);
        binding.animationVariantsGroup.setVisibility(View.GONE);
        binding.clickVibratorRadioGroup.setVisibility(View.GONE);
        binding.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
        binding.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
        binding.vibratorEndSwitch.setVisibility(View.GONE);
        //assert binding.textViewClick != null;
        binding.textViewClickLayout.setVisibility(View.GONE);
        binding.plusValLayout.setVisibility(View.GONE);
        binding.minusValLayout.setVisibility(View.GONE);
        binding.resetValLayout.setVisibility(View.GONE);
        binding.saveClickObserver.setVisibility(View.GONE);

        binding.longPressRadioGroup.setVisibility(View.GONE);

        binding.textViewLongClickLayout.setVisibility(View.GONE);
        binding.plusValLongLayout.setVisibility(View.GONE);
        binding.minusValLongLayout.setVisibility(View.GONE);
        binding.resetValLongLayout.setVisibility(View.GONE);
        binding.saveLongClickObserver.setVisibility(View.GONE);

        binding.animationTransactionSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);
                binding.animationVariantsGroup.startAnimation(animation);
                binding.animationVariantsGroup.setVisibility(View.VISIBLE);
            } else {
                binding.animationVariantsGroup.setVisibility(View.GONE);
            }
        });

        binding.vibratorBtnsSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);

                binding.clickVibratorRadioGroup.startAnimation(animation);
                binding.vibratorEndSwitch.startAnimation(animation);


                binding.clickVibratorRadioGroup.setVisibility(View.VISIBLE);
                binding.vibratorEndSwitch.setVisibility(View.VISIBLE);

            } else {
                binding.clickVibratorRadioGroup.setVisibility(View.GONE);
                binding.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
                binding.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
                binding.vibratorEndSwitch.setVisibility(View.GONE);
            }
        });

        binding.clickVibratorRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.fullVibration:
                    //full vibration
                    binding.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
                    binding.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
                    break;
                case R.id.partVibration:
                    AlphaAnimation animation = new AlphaAnimation(0, 1);
                    animation.setDuration(1000);
                    binding.vibratorToolBarBtnSwitch.startAnimation(animation);
                    binding.vibratorCounterBtnsSwitch.startAnimation(animation);
                    binding.vibratorToolBarBtnSwitch.setVisibility(View.VISIBLE);
                    binding.vibratorCounterBtnsSwitch.setVisibility(View.VISIBLE);
                    break;
            }

            if (binding.vibratorToolBarBtnSwitch.isChecked() && binding.vibratorCounterBtnsSwitch.isChecked()) {
                binding.partVibration.setChecked(false);
                binding.fullVibration.setChecked(true);
                binding.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
                binding.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
            }
        });

        binding.vibratorToolBarBtnSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {

            }
        });

        binding.vibratorCounterBtnsSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {

            }
        });

        binding.clickListenerSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);
                binding.textViewClickLayout.startAnimation(animation);
                binding.plusValLayout.startAnimation(animation);
                binding.minusValLayout.startAnimation(animation);
                binding.resetValLayout.startAnimation(animation);
                binding.saveClickObserver.startAnimation(animation);

                binding.textViewClickLayout.setVisibility(View.VISIBLE);
                binding.plusValLayout.setVisibility(View.VISIBLE);
                binding.minusValLayout.setVisibility(View.VISIBLE);
                binding.resetValLayout.setVisibility(View.VISIBLE);
                binding.saveClickObserver.setVisibility(View.VISIBLE);
            } else {
                binding.textViewClickLayout.setVisibility(View.GONE);
                binding.plusValLayout.setVisibility(View.GONE);
                binding.minusValLayout.setVisibility(View.GONE);
                binding.resetValLayout.setVisibility(View.GONE);
                binding.saveClickObserver.setVisibility(View.GONE);
            }
        });

        binding.longPressSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);

                binding.longPressRadioGroup.startAnimation(animation);
                binding.longPressRadioGroup.setVisibility(View.VISIBLE);

            } else {
                binding.longPressRadioGroup.setVisibility(View.GONE);

                binding.textViewLongClickLayout.setVisibility(View.GONE);
                binding.plusValLongLayout.setVisibility(View.GONE);
                binding.minusValLongLayout.setVisibility(View.GONE);
                binding.resetValLongLayout.setVisibility(View.GONE);
                binding.saveLongClickObserver.setVisibility(View.GONE);
            }
        });

        binding.longPressRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.oneLongClick:
                    //one long click
                    binding.textViewLongClickLayout.setVisibility(View.GONE);
                    binding.plusValLongLayout.setVisibility(View.GONE);
                    binding.minusValLongLayout.setVisibility(View.GONE);
                    binding.resetValLongLayout.setVisibility(View.GONE);
                    binding.saveLongClickObserver.setVisibility(View.GONE);

                    break;
                case R.id.regularLongClick:

                    AlphaAnimation animation = new AlphaAnimation(0, 1);
                    animation.setDuration(1000);

                    binding.textViewLongClickLayout.startAnimation(animation);
                    binding.plusValLongLayout.startAnimation(animation);
                    binding.minusValLongLayout.startAnimation(animation);
                    binding.resetValLongLayout.startAnimation(animation);
                    binding.saveLongClickObserver.startAnimation(animation);

                    binding.textViewLongClickLayout.setVisibility(View.VISIBLE);
                    binding.plusValLongLayout.setVisibility(View.VISIBLE);
                    binding.minusValLongLayout.setVisibility(View.VISIBLE);
                    binding.resetValLongLayout.setVisibility(View.VISIBLE);
                    binding.saveLongClickObserver.setVisibility(View.VISIBLE);
                    break;
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.appThemeRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "checkedButton", R.id.setFollowSystemTheme));
        binding.appThemeRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.setFollowSystemTheme:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkedButton", R.id.setFollowSystemTheme);
                    SharedPreferencesUtils.saveInteger(requireContext(), "nightMode", 1);
                    requireActivity().recreate();
                    break;
                case R.id.setLightTheme:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkedButton", R.id.setLightTheme);
                    SharedPreferencesUtils.saveInteger(requireContext(), "nightMode", 2);
                    requireActivity().recreate();
                    break;
                case R.id.setNightTheme:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkedButton", R.id.setNightTheme);
                    SharedPreferencesUtils.saveInteger(requireContext(), "nightMode", 3);
                    requireActivity().recreate();
                    break;
            }
        });


        switchMaterial.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DynamicColors.applyToActivitiesIfAvailable(getActivity().getApplication());
            DynamicColors.applyToActivitiesIfAvailable(getActivity().getApplication(),
                    R.style.Theme_Counters);
            SharedPreferencesUtils.saveBoolean(requireContext(), "useDynamicColors", isChecked);
            requireActivity().recreate();
        });

        // поочередное открытие и закрытие
        binding.clickSwipeBtn.setOnClickListener(v -> {
            binding.clickSwipeGroup.setVisibility(View.VISIBLE);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}