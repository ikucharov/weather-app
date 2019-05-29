package com.weather.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public final class PreferencesUtil {

    private static final String PREFS_IS_FIRST_LAUNCH = "isFirstLaunch";
    private static final String PREFS_HOUR = "hour";
    private static final String PREFS_MIN = "min";
    private static final String PREFS_REMINDER_STATUS = "reminderStatus";

    private Context context;
    private SharedPreferences preferences;

    public PreferencesUtil(Context context,
                           SharedPreferences preferences) {
        this.context = context;
        this.preferences = preferences;
    }

    public void clearAll() {
        boolean isFirstLaunch = isFirstLaunch();
        preferences.edit().clear().apply();
        setFirstLaunch(isFirstLaunch);
    }

    public boolean isFirstLaunch() {
        return preferences.getBoolean(PREFS_IS_FIRST_LAUNCH, false);
    }

    public boolean setFirstLaunch(boolean isFirst) {
        return preferences.edit().putBoolean(PREFS_IS_FIRST_LAUNCH, isFirst).commit();
    }

    public int getHour() {
        return preferences.getInt(PREFS_HOUR, 20);
    }

    public int getMin() {
        return preferences.getInt(PREFS_MIN, 0);
    }

    public boolean getReminderStatus() {
        return preferences.getBoolean(PREFS_REMINDER_STATUS, false);
    }

    public void setHour(Integer hour) {
        preferences.edit().putInt(PREFS_HOUR, hour).apply();
    }

    public void setMin(Integer min) {
        preferences.edit().putInt(PREFS_MIN, min).apply();
    }

    public void setReminderStatus(Boolean status) {
        preferences.edit().putBoolean(PREFS_REMINDER_STATUS, status).apply();
    }
}