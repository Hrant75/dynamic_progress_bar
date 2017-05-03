package com.example.hrant.dynamicprogressbar;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hrant on 02.05.2017.
 */

public class PreferencesHelper {


    private static final String PREFERENCES_NAME = "preferences";

    private static final String PROGRESS_BAR_VALUE = "progress_bar_value";
    private static final String PROGRESS_BAR_MAX = "progress_bar_max";
    private static final String SEEK_BAR_VALUE = "seek_bar_value";
    private static final String SEEK_BAR_MAX = "seek_bar_max";
    private static final String CHEKBOX_STATE = "chekbox_state";
    private static final String TOGGLE_BUTTON2x_STATE = "toggle_button2x_state";
    private static final String TOGGLE_BUTTON4x_STATE = "toggle_button4x_state";
    private static final String TOGGLE_BUTTON6x_STATE = "toggle_button6x_state";
    private static final String TOGGLE_BUTTON8x_STATE = "toggle_button8x_state";
    private static final String RADIO_BUTTON_DIV2_STATE = "toggle_button_div2_state";
    private static final String RADIO_BUTTON_DIV4_STATE = "toggle_button_div4_state";
    private static final String RADIO_BUTTON_DIV8_STATE = "toggle_button_div8_state";
    private static final String SWITCH_ADD10 = "tswitch_add10";
    private static final String SWITCH_ADD20 = "tswitch_add20";
    private static final String SWITCH_ADD30 = "tswitch_add30";

    private SharedPreferences preferences;

    private static PreferencesHelper instance;

    public static PreferencesHelper getInstance(Context context){
        if(instance == null){
            instance = new PreferencesHelper(context.getApplicationContext());
        }

        return instance;
    }

    private PreferencesHelper(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }

    public int getProgressBarValue() {
        return preferences.getInt(PROGRESS_BAR_VALUE, 0);
    }

    public void setProgressBarValue(int value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putInt(PROGRESS_BAR_VALUE, value);
        editor.apply();
    }

    public int getProgressBarMax() {
        return preferences.getInt(PROGRESS_BAR_MAX, 100);
    }

    public void setProgressBarMax(int value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putInt(PROGRESS_BAR_MAX, value);
        getEditor().apply();
    }

    public int getSeekBarValue() {
        return preferences.getInt(SEEK_BAR_VALUE, 0);
    }

    public void setSeekBarValue(int value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putInt(SEEK_BAR_VALUE, value);
        getEditor().apply();
    }

    public int getSeekBarMax() {
        return preferences.getInt(SEEK_BAR_MAX, 100);
    }

    public void setSeekBarMax(int value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putInt(SEEK_BAR_MAX, value);
        editor.apply();
    }

    public boolean getCheckBoxState() {
        return preferences.getBoolean(CHEKBOX_STATE, false);
    }

    public void setCheckBoxState(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(CHEKBOX_STATE, value);
        editor.apply();
    }

    public boolean getToggle2xState() {
        return preferences.getBoolean(TOGGLE_BUTTON2x_STATE, false);
    }

    public void setToggle2xState(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TOGGLE_BUTTON2x_STATE, value);
        editor.apply();
    }

    public boolean getToggle4xState() {
        return preferences.getBoolean(TOGGLE_BUTTON4x_STATE, false);
    }

    public void setToggle4xState(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TOGGLE_BUTTON4x_STATE, value);
        editor.apply();
    }

    public boolean getToggle6xState() {
        return preferences.getBoolean(TOGGLE_BUTTON6x_STATE, false);
    }

    public void setToggle6xState(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TOGGLE_BUTTON6x_STATE, value);
        editor.apply();
    }

    public boolean getToggle8xState() {
        return preferences.getBoolean(TOGGLE_BUTTON8x_STATE, false);
    }

    public void setToggle8xState(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TOGGLE_BUTTON8x_STATE, value);
        editor.apply();
    }

    public boolean getRadioButtonDiv2State() {
        return preferences.getBoolean(RADIO_BUTTON_DIV2_STATE, false);
    }

    public void setRadioButtonDiv2State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(RADIO_BUTTON_DIV2_STATE, value);
        editor.apply();
    }

    public boolean getRadioButtonDiv4State() {
        return preferences.getBoolean(RADIO_BUTTON_DIV4_STATE, false);
    }

    public void setRadioButtonDiv4State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(RADIO_BUTTON_DIV4_STATE, value);
        editor.apply();
    }

    public boolean getRadioButtonDiv8State() {
        return preferences.getBoolean(RADIO_BUTTON_DIV8_STATE, false);
    }

    public void setRadioButtonDiv8State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(RADIO_BUTTON_DIV8_STATE, value);
        editor.apply();
    }

    public boolean getSwitchAdd10State() {
        return preferences.getBoolean(SWITCH_ADD10, false);
    }

    public void setSwitchAdd10State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(SWITCH_ADD10, value);
        editor.apply();
    }

    public boolean getSwitchAdd20State() {
        return preferences.getBoolean(SWITCH_ADD20, false);
    }

    public void setSwitchAdd20State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(SWITCH_ADD20, value);
        editor.apply();
    }

    public boolean getSwitchAdd30State() {
        return preferences.getBoolean(SWITCH_ADD30, false);
    }

    public void setSwitchAdd30State(boolean value){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(SWITCH_ADD30, value);
        editor.apply();
    }


//    public long getUserId() {
//        return preferences.getLong(USER_ID, -1);
//    }
//
//    public void setUserId(long userId) {
//        final SharedPreferences.Editor editor = getEditor();
//
//        editor.putLong(USER_ID, userId);
//        editor.apply();
//    }
}
