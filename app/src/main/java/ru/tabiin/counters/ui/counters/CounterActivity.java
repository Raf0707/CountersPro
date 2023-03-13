package ru.tabiin.counters.ui.counters;

import static ru.tabiin.counters.util.UtilFragment.changeFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import ru.tabiin.counters.R;
import ru.tabiin.counters.databinding.ActivityCounterBinding;
import ru.tabiin.counters.domain.models.CounterItem;
import ru.tabiin.counters.ui.main.MainFragment;
import ru.tabiin.counters.ui.settings.SettingsFragment;
import ru.tabiin.counters.ui.settings.TutorialFragment;

public class CounterActivity extends AppCompatActivity {
    private ActivityCounterBinding binding;
    private CounterViewModel counterViewModel;
    private CounterItem counterItem;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        counterViewModel = new ViewModelProvider(this,
                (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                        .getInstance(getApplication()))
                .get(CounterViewModel.class);

        intent = new Intent();
        counterItem = (CounterItem) intent.getSerializableExtra("counterItem");

        binding.openCounterListBtn.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerCountersFragment, new MainFragment()).commit();
            finish();
        });

        binding.changeCounterModeBtn.setOnClickListener(v -> {

        });

        binding.deleteCounterBtn.setOnClickListener(v -> {
            counterViewModel.delete(counterItem);
        });

        binding.saveCounterEditions.setOnClickListener(v -> {
            counterViewModel.update(counterItem);
            //intent.putExtra("counterItem", counterItem);
            //setResult(RESULT_OK, intent);
            finish();
        });

        binding.openTutorialBtn.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerCountersFragment, new TutorialFragment());
        });

        binding.openSettingsBtn.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerCountersFragment, new SettingsFragment());
        });
    }
}