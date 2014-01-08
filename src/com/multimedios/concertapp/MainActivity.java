package com.multimedios.concertapp;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.content.Intent;

import com.multimedios.concertapp.global.*;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Global global = Global.getInstance();
		
		final TextView txtBienvenida = (TextView)findViewById(R.id.bienvenida);
		
		LoginButton authButton = (LoginButton) findViewById(R.id.login_button);
		
		authButton.setSessionStatusCallback(new Session.StatusCallback(){
			
			//callback when session changes state
			@Override
			public void call(Session session, SessionState state, Exception exception){
				if(session.isOpened()){
					//make request to the /me API
					Request.newMeRequest(session, new Request.GraphUserCallback() {
						//callback after Graph API response with user object
						@Override
						public void onCompleted(GraphUser user, Response response) {
							// TODO Auto-generated method stub
							if(user != null){
								global.set_nombre(user.getName());
								//Se modifica el texto de bienvenida, con el nombre de usuario
								txtBienvenida.setText(getString(R.string.mensaje_bienvenida) + " " + user.getName());
								
								/*Intent irHomeActivity = new Intent(getApplicationContext(), HomeActivity.class);
						    	irHomeActivity.putExtra("usuario", user.getName());
						    	startActivity(irHomeActivity);*/
								Intent irPagerMainActivity = new Intent(getApplicationContext(), PagerMainActivity.class);
						    	startActivity(irPagerMainActivity);
						    	//finish();
								
							}
							else{
								txtBienvenida.setText("Sin usuario");
							}
						}
					}).executeAsync();
				}else if(session.isClosed()) {
						txtBienvenida.setText(getString(R.string.mensaje_bienvenida));
						}
			}
		});
	}
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	  } 
	
	@Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
       Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
   }
	
}
