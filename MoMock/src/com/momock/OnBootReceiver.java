package com.momock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class OnBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			Log.debug("onReceive");
			PackageManager pm = context.getPackageManager();
			Intent launch = pm
					.getLaunchIntentForPackage("com.momock");
			context.startActivity(launch);
		} catch (Exception e) {
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
		}
	}
}
