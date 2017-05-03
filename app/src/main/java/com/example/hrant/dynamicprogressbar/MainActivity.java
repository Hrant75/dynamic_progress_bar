package com.example.hrant.dynamicprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ProgressBar progressBar;
    SeekBar seekBar;
    EditText editTextProgres, editTextSeekBar;
    TextView textViewProgress, textViewSeek;
    CheckBox checkBoxToggles;
    ToggleButton toggleButton2x, toggleButton4x, toggleButton6x, toggleButton8x;
    RadioButton radioButton_div2, radioButton_div4, radioButton_div8;
    Button button_clear_all_radios;
    Switch aSwitch_add10, aSwitch_add20, aSwitch_add30;

    PreferencesHelper preferencesHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        seekBar = (SeekBar)findViewById(R.id.seek_bar);
        editTextProgres = (EditText)findViewById(R.id.progress_editText);
        editTextSeekBar = (EditText)findViewById(R.id.seek_bar_editText);
        textViewProgress = (TextView)findViewById(R.id.progress_textView);
        textViewSeek = (TextView)findViewById(R.id.seek_bar_textView);
        checkBoxToggles = (CheckBox)findViewById(R.id.toggles_checkBox);
        toggleButton2x = (ToggleButton)findViewById(R.id.toggleButton_x2);
        toggleButton4x = (ToggleButton)findViewById(R.id.toggleButton_x4);
        toggleButton6x = (ToggleButton)findViewById(R.id.toggleButton_x6);
        toggleButton8x = (ToggleButton)findViewById(R.id.toggleButton_x8);
        radioButton_div2 = (RadioButton)findViewById(R.id.radioButton_div2);
        radioButton_div4 = (RadioButton)findViewById(R.id.radioButton_div4);
        radioButton_div8 = (RadioButton)findViewById(R.id.radioButton_div8);
        button_clear_all_radios = (Button)findViewById(R.id.button_clear_all_radios);
        aSwitch_add10 = (Switch)findViewById(R.id.switch_add10);
        aSwitch_add20 = (Switch)findViewById(R.id.switch_add20);
        aSwitch_add30 = (Switch)findViewById(R.id.switch_add30);

        final PreferencesHelper preferencesHelper = PreferencesHelper.getInstance(this);

        progressBar.setProgress(preferencesHelper.getProgressBarValue());
        seekBar.setProgress(preferencesHelper.getSeekBarValue());
//        editTextProgres.setText(preferencesHelper.getProgressBarMax());
//        editTextSeekBar.setText(preferencesHelper.getSeekBarMax());
        textViewProgress.setText("ProgressBar: " + progressBar.getProgress());
        textViewSeek.setText("SeekBar: " + seekBar.getProgress());
        checkBoxToggles.setChecked(preferencesHelper.getCheckBoxState());
        toggleButton2x.setChecked(preferencesHelper.getToggle2xState());
        toggleButton4x.setChecked(preferencesHelper.getToggle4xState());
        toggleButton6x.setChecked(preferencesHelper.getToggle6xState());
        toggleButton8x.setChecked(preferencesHelper.getToggle8xState());
        radioButton_div2.setChecked(preferencesHelper.getRadioButtonDiv2State());
        radioButton_div4.setChecked(preferencesHelper.getRadioButtonDiv4State());
        radioButton_div8.setChecked(preferencesHelper.getRadioButtonDiv8State());
        aSwitch_add10.setChecked(preferencesHelper.getSwitchAdd10State());
        aSwitch_add20.setChecked(preferencesHelper.getSwitchAdd20State());
        aSwitch_add30.setChecked(preferencesHelper.getSwitchAdd30State());

        checkBoxToggles.setOnClickListener(this);
        toggleButton2x.setOnClickListener(this);
        toggleButton4x.setOnClickListener(this);
        toggleButton6x.setOnClickListener(this);
        toggleButton8x.setOnClickListener(this);
        radioButton_div2.setOnClickListener(this);
        radioButton_div4.setOnClickListener(this);
        radioButton_div8.setOnClickListener(this);
        aSwitch_add10.setOnClickListener(this);
        aSwitch_add20.setOnClickListener(this);
        aSwitch_add30.setOnClickListener(this);

        button_clear_all_radios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                radioButton_div2.setChecked(false);
                radioButton_div4.setChecked(false);
                radioButton_div8.setChecked(false);
                calculateProgressBarValue();
            }
        });

        editTextProgres.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                int progressBarMax = Integer.parseInt(s.toString());
                progressBar.setMax(progressBarMax);
                preferencesHelper.setProgressBarMax(progressBarMax);
            }
        });

        editTextSeekBar.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                int seekBarMax = Integer.parseInt(s.toString());
                seekBar.setMax(seekBarMax);
                preferencesHelper.setSeekBarMax(seekBarMax);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {
                calculateProgressBarValue();
                preferencesHelper.setProgressBarValue(progressChangedValue);
                preferencesHelper.setSeekBarValue(progressChangedValue);
            }
        });

        checkBoxToggles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    toggleButton2x.setEnabled(true);
                    toggleButton4x.setEnabled(true);
                    toggleButton6x.setEnabled(true);
                    toggleButton8x.setEnabled(true);
                }else {
                    toggleButton2x.setChecked(false);
                    preferencesHelper.setToggle2xState(false);
                    toggleButton2x.setEnabled(false);
                    toggleButton4x.setChecked(false);
                    preferencesHelper.setToggle4xState(false);
                    toggleButton4x.setEnabled(false);
                    toggleButton6x.setChecked(false);
                    preferencesHelper.setToggle6xState(false);
                    toggleButton6x.setEnabled(false);
                    toggleButton8x.setChecked(false);
                    preferencesHelper.setToggle8xState(false);
                    toggleButton8x.setEnabled(false);
                }
                preferencesHelper.setCheckBoxState(isChecked);
            }
        });

        calculateProgressBarValue();
    }

    private void calculateProgressBarValue(){
        int progressBarValue;
        progressBarValue = seekBar.getProgress();
        progressBarValue = toggleButton2x.isChecked()? progressBarValue * 2: progressBarValue;
        progressBarValue = toggleButton4x.isChecked()? progressBarValue * 4: progressBarValue;
        progressBarValue = toggleButton6x.isChecked()? progressBarValue * 6: progressBarValue;
        progressBarValue = toggleButton8x.isChecked()? progressBarValue * 8: progressBarValue;
        progressBarValue = radioButton_div2.isChecked()? progressBarValue / 2: progressBarValue;
        progressBarValue = radioButton_div4.isChecked()? progressBarValue / 4: progressBarValue;
        progressBarValue = radioButton_div8.isChecked()? progressBarValue / 8: progressBarValue;
        progressBarValue = aSwitch_add10.isChecked()? progressBarValue + 10: progressBarValue;
        progressBarValue = aSwitch_add20.isChecked()? progressBarValue + 20: progressBarValue;
        progressBarValue = aSwitch_add30.isChecked()? progressBarValue + 30: progressBarValue;
        progressBar.setProgress(progressBarValue);
        textViewProgress.setText("ProgressBar: " + String.valueOf(progressBar.getProgress()));
        textViewSeek.setText("SeekBar: " + String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onClick(View v) {
        final PreferencesHelper preferencesHelper = PreferencesHelper.getInstance(this);
        calculateProgressBarValue();
        preferencesHelper.setProgressBarValue(progressBar.getProgress());
        preferencesHelper.setSeekBarValue(seekBar.getProgress());
        preferencesHelper.setToggle2xState(toggleButton2x.isChecked());
        preferencesHelper.setToggle4xState(toggleButton4x.isChecked());
        preferencesHelper.setToggle6xState(toggleButton6x.isChecked());
        preferencesHelper.setToggle8xState(toggleButton8x.isChecked());
        preferencesHelper.setRadioButtonDiv2State(radioButton_div2.isChecked());
        preferencesHelper.setRadioButtonDiv4State(radioButton_div4.isChecked());
        preferencesHelper.setRadioButtonDiv8State(radioButton_div8.isChecked());
        preferencesHelper.setSwitchAdd10State(aSwitch_add10.isChecked());
        preferencesHelper.setSwitchAdd20State(aSwitch_add20.isChecked());
        preferencesHelper.setSwitchAdd30State(aSwitch_add30.isChecked());
    }
}
