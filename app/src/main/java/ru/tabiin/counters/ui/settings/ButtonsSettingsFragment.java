package ru.tabiin.counters.ui.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CompoundButton;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.slider.Slider;

import java.util.Objects;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.FragmentButtonsSettingsBinding;
import ru.tabiin.counters.util.SharedPreferencesUtils;

public class ButtonsSettingsFragment extends Fragment {
    FragmentButtonsSettingsBinding b;
    String vibRadioFullOrPart;
    String longclickOneOrRegular;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentButtonsSettingsBinding.inflate(getLayoutInflater());

        b.clickVibratorRadioGroup.setVisibility(View.GONE);
        b.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
        b.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
        b.clickVibratorEndSwitch.setVisibility(View.GONE);
        b.counterBtnsCheckVibrateLayout.setVisibility(View.GONE);
        b.toolbarBtnsCheckVibrateLayoutLeft.setVisibility(View.GONE);
        b.toolbarBtnsCheckVibrateLayoutRight.setVisibility(View.GONE);
        b.textViewClickLayout.setVisibility(View.GONE);
        b.plusValLayout.setVisibility(View.GONE);
        b.minusValLayout.setVisibility(View.GONE);
        b.resetValLayout.setVisibility(View.GONE);
        b.saveClickObserver.setVisibility(View.GONE);
        b.clickVibrateSlider.setVisibility(View.GONE);
        b.endTargetVibrateSlider.setVisibility(View.GONE);

        b.longPressRadioGroup.setVisibility(View.GONE);

        b.textViewLongClickLayout.setVisibility(View.GONE);
        b.plusValLongLayout.setVisibility(View.GONE);
        b.minusValLongLayout.setVisibility(View.GONE);
        b.resetValLongLayout.setVisibility(View.GONE);
        b.saveLongClickObserver.setVisibility(View.GONE);

        b.vibratorBtnsSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "vibratorBtnsSwitch"));
        //b.clickVibrateSlider.setValue(SharedPreferencesUtils.getInteger(requireContext(), "clickVibrateSlider"));
        //b.clickVibratorRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "vibration"));
        b.vibratorCounterBtnsSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "vibratorCounterBtnsSwitch"));

        //b.plusBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "plusBtnSetVib"));
        //b.minusBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "minusBtnSetVib"));
        //b.resetBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "resetBtnSetVib"));

        //b.vibratorToolBarBtnSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "vibratorToolBarBtnSwitch"));

        //b.settingsBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "settingsBtnSetVib"));
        //b.tutorialBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "tutorialBtnSetVib"));
        //b.saveBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "saveBtnSetVib"));

        //b.editBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "editBtnSetVib"));
        //b.deleteBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "deleteBtnSetVib"));
        //b.listBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "listBtnSetVib"));

        //b.clickVibratorEndSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "clickVibratorEndSwitch"));
        //b.endTargetVibrateSlider.setValue(SharedPreferencesUtils.getInteger(requireContext(), "endTargetVibrateSlider"));

        b.clickListenerSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "clickListenerSwitch"));


        //b.plusValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "plusValueClickInput", 1));
        //b.minusValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "minusValueClickInput", 1));
        //b.resetValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "resetValueClickInput", 1));


        b.longPressSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "longPressSwitch"));
        //b.longPressRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "longclick"));


        //b.plusValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "plusValueClickInput", 1));
        //b.minusValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "minusValueClickInput", 1));
        //b.resetValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "resetValueClickInput", 1));

        return b.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b.vibratorBtnsSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);

                b.clickVibratorRadioGroup.startAnimation(animation);
                b.clickVibratorEndSwitch.startAnimation(animation);
                b.clickVibrateSlider.startAnimation(animation);

                b.clickVibrateSlider.setVisibility(View.VISIBLE);
                b.clickVibrateSlider.setValue(SharedPreferencesUtils.getInteger(requireContext(), "clickVibrateSlider", 50));
                b.clickVibratorRadioGroup.setVisibility(View.VISIBLE);
                b.clickVibratorEndSwitch.setVisibility(View.VISIBLE);
                b.clickVibratorEndSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "clickVibratorEndSwitch"));

            } else {
                b.clickVibratorRadioGroup.setVisibility(View.GONE);
                b.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
                b.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
                b.clickVibratorEndSwitch.setVisibility(View.GONE);
                b.clickVibrateSlider.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "vibratorBtnsSwitch", isChecked);
            requireActivity().recreate();
        });

        b.clickVibrateSlider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                SharedPreferencesUtils.saveInteger(requireContext(), "clickVibrateSlider", (int) slider.getValue());
                requireActivity().recreate();
            }
        });

        b.clickVibratorRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "vibration"));
        b.clickVibratorRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.fullVibration:
                    //full vibration
                    b.vibratorToolBarBtnSwitch.setVisibility(View.GONE);
                    b.vibratorCounterBtnsSwitch.setVisibility(View.GONE);
                    b.counterBtnsCheckVibrateLayout.setVisibility(View.GONE);
                    b.toolbarBtnsCheckVibrateLayoutRight.setVisibility(View.GONE);
                    b.toolbarBtnsCheckVibrateLayoutLeft.setVisibility(View.GONE);

                    vibRadioFullOrPart = "fullVib";
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkVib", 0);
                    SharedPreferencesUtils.saveInteger(requireContext(), "vibration", R.id.fullVibration);
                    requireActivity().recreate();
                    break;
                case R.id.partVibration:
                    AlphaAnimation animation = new AlphaAnimation(0, 1);
                    animation.setDuration(1000);
                    b.vibratorToolBarBtnSwitch.startAnimation(animation);
                    b.vibratorCounterBtnsSwitch.startAnimation(animation);
                    b.vibratorToolBarBtnSwitch.setVisibility(View.VISIBLE);
                    b.vibratorCounterBtnsSwitch.setVisibility(View.VISIBLE);

                    b.vibratorToolBarBtnSwitch.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "vibratorToolBarBtnSwitch"));

                    vibRadioFullOrPart = "partVib";
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkVib", 1);
                    SharedPreferencesUtils.saveInteger(requireContext(), "vibration", R.id.partVibration);
                    requireActivity().recreate();
                    break;
            }

        });

        b.vibratorCounterBtnsSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                Animation animation = new AlphaAnimation(0, 1);
                b.counterBtnsCheckVibrateLayout.startAnimation(animation);
                b.counterBtnsCheckVibrateLayout.setVisibility(View.VISIBLE);

                b.plusBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "plusBtnSetVib"));
                b.minusBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "minusBtnSetVib"));
                b.resetBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "resetBtnSetVib"));


            } else {
                b.counterBtnsCheckVibrateLayout.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "vibratorCounterBtnsSwitch", isChecked);
            requireActivity().recreate();
        });

        b.plusBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "plusBtnSetVib", state);
            requireActivity().recreate();
        });

        b.minusBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "minusBtnSetVib", state);
            requireActivity().recreate();
        });

        b.resetBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "resetBtnSetVib", state);
            requireActivity().recreate();
        });

        b.vibratorToolBarBtnSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                Animation animation = new AlphaAnimation(0, 1);
                b.toolbarBtnsCheckVibrateLayoutRight.startAnimation(animation);
                b.toolbarBtnsCheckVibrateLayoutLeft.startAnimation(animation);

                b.toolbarBtnsCheckVibrateLayoutRight.setVisibility(View.VISIBLE);
                b.settingsBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "settingsBtnSetVib"));
                b.tutorialBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "tutorialBtnSetVib"));
                b.saveBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "saveBtnSetVib"));

                b.toolbarBtnsCheckVibrateLayoutLeft.setVisibility(View.VISIBLE);
                b.editBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "editBtnSetVib"));
                b.deleteBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "deleteBtnSetVib"));
                b.listBtnSetVib.setChecked(SharedPreferencesUtils.getBoolean(requireContext(), "listBtnSetVib"));

            } else {
                b.toolbarBtnsCheckVibrateLayoutRight.setVisibility(View.GONE);
                b.toolbarBtnsCheckVibrateLayoutLeft.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "vibratorToolBarBtnSwitch", isChecked);
            requireActivity().recreate();
        });

        b.settingsBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "settingsBtnSetVib", state);
            requireActivity().recreate();
        });

        b.tutorialBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "tutorialBtnSetVib", state);
            requireActivity().recreate();
        });

        b.saveBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "saveBtnSetVib", state);
            requireActivity().recreate();
        });

        b.editBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "editBtnSetVib", state);
            requireActivity().recreate();
        });

        b.deleteBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "deleteBtnSetVib", state);
            requireActivity().recreate();
        });

        b.listBtnSetVib.addOnCheckedStateChangedListener((checkBox, state) -> {
            SharedPreferencesUtils.saveInteger(requireContext(), "listBtnSetVib", state);
            requireActivity().recreate();
        });

        b.clickVibratorEndSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                Animation animation = new AlphaAnimation(0, 1);
                b.counterBtnsCheckVibrateLayout.startAnimation(animation);
                b.endTargetVibrateSlider.setVisibility(View.VISIBLE);
                b.endTargetVibrateSlider.setValue(SharedPreferencesUtils.getInteger(requireContext(), "endTargetVibrateSlider", 500));
            } else {
                b.endTargetVibrateSlider.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "clickVibratorEndSwitch", isChecked);
            requireActivity().recreate();

        });

        b.endTargetVibrateSlider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                SharedPreferencesUtils.saveInteger(requireContext(), "endTargetVibrateSlider", (int) slider.getValue());
                requireActivity().recreate();
            }
        });

        b.clickListenerSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);
                b.textViewClickLayout.startAnimation(animation);
                b.plusValLayout.startAnimation(animation);
                b.minusValLayout.startAnimation(animation);
                b.resetValLayout.startAnimation(animation);
                b.saveClickObserver.startAnimation(animation);

                b.textViewClickLayout.setVisibility(View.VISIBLE);
                b.plusValLayout.setVisibility(View.VISIBLE);
                b.minusValLayout.setVisibility(View.VISIBLE);
                b.resetValLayout.setVisibility(View.VISIBLE);
                b.saveClickObserver.setVisibility(View.VISIBLE);

                b.plusValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "plusValueClickInput", 1));
                b.minusValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "minusValueClickInput", 1));
                b.resetValueClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "resetValueClickInput", 1));

            } else {
                b.textViewClickLayout.setVisibility(View.GONE);
                b.plusValLayout.setVisibility(View.GONE);
                b.minusValLayout.setVisibility(View.GONE);
                b.resetValLayout.setVisibility(View.GONE);
                b.saveClickObserver.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "clickListenerSwitch", isChecked);
            requireActivity().recreate();
        });

        b.saveClickObserver.setOnClickListener(v -> {
            if (b.plusValueClickInput.getText() == null || b.plusValueClickInput.getText().toString() == "") {
                b.plusValueClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "plusValueClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.plusValueClickInput.getText()).toString()));

            if (b.minusValueClickInput.getText() == null || b.minusValueClickInput.getText().toString() == "") {
                b.minusValueClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "minusValueClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.minusValueClickInput.getText()).toString()));

            if (b.resetValueClickInput.getText() == null || b.resetValueClickInput.getText().toString() == "") {
                b.resetValueClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "resetValueClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.resetValueClickInput.getText()).toString()));

            b.plusValueClickInput.setCursorVisible(false);
            b.minusValueClickInput.setCursorVisible(false);
            b.resetValueClickInput.setCursorVisible(false);
        });

        b.plusValueClickInput.setOnClickListener(v -> {
            b.plusValueClickInput.setCursorVisible(true);
        });

        b.minusValueClickInput.setOnClickListener(v -> {
            b.minusValueClickInput.setCursorVisible(true);
        });

        b.resetValueClickInput.setOnClickListener(v -> {
            b.resetValueClickInput.setCursorVisible(true);
        });

        b.longPressSwitch.setOnCheckedChangeListener((v, isChecked) -> {
            if (isChecked) {
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);

                b.longPressRadioGroup.startAnimation(animation);
                b.longPressRadioGroup.setVisibility(View.VISIBLE);

            } else {
                b.longPressRadioGroup.setVisibility(View.GONE);

                b.textViewLongClickLayout.setVisibility(View.GONE);
                b.plusValLongLayout.setVisibility(View.GONE);
                b.minusValLongLayout.setVisibility(View.GONE);
                b.resetValLongLayout.setVisibility(View.GONE);
                b.saveLongClickObserver.setVisibility(View.GONE);
            }

            SharedPreferencesUtils.saveBoolean(requireContext(), "longPressSwitch", isChecked);
            requireActivity().recreate();
        });

        b.longPressRadioGroup.check(SharedPreferencesUtils.getInteger(requireContext(), "longclick"));
        b.longPressRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.oneLongClick:
                    //one long click
                    b.textViewLongClickLayout.setVisibility(View.GONE);
                    b.plusValLongLayout.setVisibility(View.GONE);
                    b.minusValLongLayout.setVisibility(View.GONE);
                    b.resetValLongLayout.setVisibility(View.GONE);
                    b.saveLongClickObserver.setVisibility(View.GONE);

                    longclickOneOrRegular = "oneLongClick";
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkLongClick", 0);
                    SharedPreferencesUtils.saveInteger(requireContext(), "longclick", R.id.oneLongClick);
                    requireActivity().recreate();
                    break;
                case R.id.regularLongClick:

                    AlphaAnimation animation = new AlphaAnimation(0, 1);
                    animation.setDuration(1000);

                    b.textViewLongClickLayout.startAnimation(animation);
                    b.plusValLongLayout.startAnimation(animation);
                    b.minusValLongLayout.startAnimation(animation);
                    b.resetValLongLayout.startAnimation(animation);
                    b.saveLongClickObserver.startAnimation(animation);

                    b.textViewLongClickLayout.setVisibility(View.VISIBLE);
                    b.plusValLongLayout.setVisibility(View.VISIBLE);
                    b.minusValLongLayout.setVisibility(View.VISIBLE);
                    b.resetValLongLayout.setVisibility(View.VISIBLE);
                    b.saveLongClickObserver.setVisibility(View.VISIBLE);

                    b.plusValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "plusValueClickInput", 1));
                    b.minusValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "minusValueClickInput", 1));
                    b.resetValueLongClickInput.setText(SharedPreferencesUtils.getInteger(requireContext(), "resetValueClickInput", 1));


                    longclickOneOrRegular = "regularLongClick";
                    SharedPreferencesUtils.saveInteger(requireContext(), "checkLongClick", 1);
                    SharedPreferencesUtils.saveInteger(requireContext(), "longclick", R.id.regularLongClick);
                    requireActivity().recreate();
                    break;
            }
        });

        b.saveLongClickObserver.setOnClickListener(v -> {
            if (b.plusValueLongClickInput.getText() == null || b.plusValueLongClickInput.getText().toString() == "") {
                b.plusValueLongClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "plusValueLongClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.plusValueLongClickInput.getText()).toString()));

            if (b.minusValueLongClickInput.getText() == null || b.minusValueLongClickInput.getText().toString() == "") {
                b.minusValueLongClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "minusValueLongClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.minusValueLongClickInput.getText()).toString()));

            if (b.resetValueLongClickInput.getText() == null || b.resetValueLongClickInput.getText().toString() == "") {
                b.resetValueLongClickInput.setText(Integer.parseInt("1"));
            }
            SharedPreferencesUtils.saveInteger(requireContext(), "resetValueLongClickInput",
                    Integer.parseInt(Objects.requireNonNull(b.resetValueLongClickInput.getText()).toString()));

            b.plusValueLongClickInput.setCursorVisible(false);
            b.minusValueLongClickInput.setCursorVisible(false);
            b.resetValueLongClickInput.setCursorVisible(false);
        });

        b.plusValueLongClickInput.setOnClickListener(v -> {
            b.plusValueLongClickInput.setCursorVisible(true);
        });

        b.minusValueLongClickInput.setOnClickListener(v -> {
            b.minusValueLongClickInput.setCursorVisible(true);
        });

        b.resetValueLongClickInput.setOnClickListener(v -> {
            b.resetValueLongClickInput.setCursorVisible(true);
        });
    }
}