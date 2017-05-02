package com.example.hrant.dynamicprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    SeekBar seekBar;
    EditText editTextProgres, editTextSeekBar;
    TextView textViewProgress, textViewSeek;
    CheckBox checkBoxToggles;
    ToggleButton toggleButton2x, toggleButton4x, toggleButton6x, toggleButton8x;
    RadioButton radioButton_div2, radioButton_div4, radioButton_div8;
    Button button_clear_all_radios;
    Switch aSwitch_add10, aSwitch_add20, aSwitch_add30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        PreferencesHelper preferencesHelper = PreferencesHelper.getInstance(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
