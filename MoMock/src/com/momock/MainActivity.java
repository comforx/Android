package com.momock;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.debug("onCreate");
        setContentView(R.layout.main);
        Button btnPlay = (Button)this.findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent intent = new Intent(Intent.ACTION_VIEW);
				    //Try Google play
				    intent.setData(Uri.parse("market://details?id=com.yahoo.mobile.client.android.yahoo"));
				    if (MyStartActivity(intent) == false) {
				        //Market (Google play) app seems not installed, let's try to open a webbrowser
				        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.yahoo.mobile.client.android.yahoo"));
				        if (MyStartActivity(intent) == false) {
				            //Well if this also fails, we have run out of options, inform the user.
				            Toast.makeText(MainActivity.this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
				        }
				    }
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
