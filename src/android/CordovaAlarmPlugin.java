package com.dellos7.cordova.alarmplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaAlarmPlugin extends CordovaPlugin {

    private static final String TAG = "CORDOVA PLUGIN ALARM";
    private Handler mHandler;
    private Runnable myTask;

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Timer autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                // Then you're allowed to execute more than twice a callback.
                PluginResult resultA = new PluginResult(PluginResult.Status.OK, "myfirstJSONResponse");
                resultA.setKeepCallback(true);
                callbackContext.sendPluginResult(resultA);

                // Some more code

                Boolean something = true;

                // bla bla bla code

                PluginResult resultB = new PluginResult(PluginResult.Status.OK, "secondJSONResponse");
                resultB.setKeepCallback(true);
                callbackContext.sendPluginResult(resultB);
            }
        }, 0, 5000);

        PluginResult pluginResult = new  PluginResult(PluginResult.Status.NO_RESULT);
        pluginResult.setKeepCallback(true); // Keep callback

        return true;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void openNewActivity( Context context ) {
        Intent intent = new Intent( context, NewActivity.class );
        this.cordova.getActivity().startActivity( intent );
    }

    private static void setTimeout( final Runnable runnable, int delay ) {
        final int _delay = delay;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep( _delay );
                    runnable.run();
                }
                catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
    
    private void refreshTimer( final Activity activity, final CallbackContext callbackContext ) {
        final CordovaInterface cordova = this.cordova;
        Timer autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                cordova.getThreadPool().execute( new Runnable() {
                    @Override
                    public void run() {
                        callbackContext.success("5 secs elapsed");
                    }
                });
                /*activity.runOnUiThread(new Runnable() {
                    public void run() {
                        callbackContext.success("5 secs elapsed");
                    }
                });*/

            }
        }, 0, 5000);
    }
}

