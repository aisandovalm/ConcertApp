package com.multimedios.concertapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class HomeActivity extends Activity {
	
	private TextView welcome;
	String usuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			usuario = extras.getString("usuario");
		}
		
		welcome = (TextView) findViewById(R.id.txt_home_activity);
		welcome.setText(getString(R.string.mensaje_bienvenida) + " " + usuario + "!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
