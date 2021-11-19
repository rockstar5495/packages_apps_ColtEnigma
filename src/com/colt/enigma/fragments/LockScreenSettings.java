/*
 *  Copyright (C) 2020 ColtOS Project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.colt.enigma.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.app.Activity;
import android.content.Context;
import android.content.ContentResolver;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.preference.SwitchPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;

import android.provider.Settings;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.util.xtended.fod.FodUtils;

import com.colt.enigma.preference.SystemSettingSwitchPreference;

public class LockScreenSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String UDFPS_HAPTIC_FEEDBACK = "udfps_haptic_feedback";
    private static final String SCREEN_OFF_FOD = "screen_off_fod";

    private SystemSettingSwitchPreference mUdfpsHapticFeedback;
    private SystemSettingSwitchPreference mScreenOffFod;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.colt_enigma_lockscreen);

        ContentResolver resolver = getActivity().getContentResolver();
        final PreferenceScreen prefScreen = getPreferenceScreen();
        Resources resources = getResources();

        mUdfpsHapticFeedback = (SystemSettingSwitchPreference) findPreference(UDFPS_HAPTIC_FEEDBACK);
        mScreenOffFod = (SystemSettingSwitchPreference) findPreference(SCREEN_OFF_FOD);
        if (!FodUtils.hasFodSupport(getActivity())) {
            prefScreen.removePreference(mUdfpsHapticFeedback);
            prefScreen.removePreference(mScreenOffFod);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ContentResolver resolver = getActivity().getContentResolver();

        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }

} 
