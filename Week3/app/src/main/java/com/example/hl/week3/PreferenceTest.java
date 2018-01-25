package com.example.hl.week3;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;


import android.os.Bundle;
import android.widget.Toast;

public class PreferenceTest extends PreferenceActivity {

    private CheckBoxPreference fly_preference;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefernce_test);
        mContext = getApplicationContext();
        fly_preference = (CheckBoxPreference) findPreference("apply_fly");

        fly_preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()

        {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(mContext, String.format("Preference的值为%s", newValue), Toast.LENGTH_LONG).show();
                return true;
            }
        });

        fly_preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()

        {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(mContext, "Preference Clicked", Toast.LENGTH_LONG).show();
                //getFragmentManager().beginTransaction().replace(android.R.id.content，new MainFragment()).commit();
                return false;
            }
        });
    }
}
