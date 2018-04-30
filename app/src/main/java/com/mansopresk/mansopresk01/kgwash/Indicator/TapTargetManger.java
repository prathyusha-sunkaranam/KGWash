package com.mansopresk.mansopresk01.kgwash.Indicator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mansopresk01 on 4/27/2018.
 */

public class TapTargetManger {
    SharedPreferences prefs;
    SharedPreferences.Editor editors;

    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "taptarget";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public TapTargetManger(Context context)
    {
        this._context = context;
        prefs = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editors = prefs.edit();
    }
    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editors.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editors.commit();
    }
    public boolean isFirstTimeLaunch()
    {
        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
