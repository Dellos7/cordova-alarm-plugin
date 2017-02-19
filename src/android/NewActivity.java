package com.dellos7.cordova.alarmplugin;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by david on 19/2/17.
 */
public class NewActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        String packageName = getApplication().getPackageName();
        setContentView( getApplication().getResources().getIdentifier( "activity_new", "layout", packageName ) );
    }

}