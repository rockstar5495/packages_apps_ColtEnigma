/*
 * Copyright (C) 2017 The ABC rom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.colt.enigma.tabs;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import android.provider.Settings;

import com.android.internal.logging.nano.MetricsProto;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class System extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.system_tab);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.ENIGMA;
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
} 
