package cnam.project.weather.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryLevelReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra("level", 0);
        if (level <= 20) {
            Toast.makeText(context, "Battery level low!", Toast.LENGTH_LONG).show();
        }
    }
}
