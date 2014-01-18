package com.multimedios.concertapp;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.multimedios.concertapp.conexionapi.DownloadActivity;
import com.multimedios.concertapp.interfaces.OnDialogAction;
import com.multimedios.concertapp.factories.MessageFactory;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;


public class MainActivity extends Activity {
	
	private ConnectivityManager connManager;
	private NetworkInfo netInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
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
								//Se modifica el texto de bienvenida, con el nombre de usuario
								txtBienvenida.setText(getString(R.string.mensaje_bienvenida) + " " + user.getName());
								
								//Manejo de conexión
								if(netInfo != null && netInfo.isConnected()){
									Intent intent = new Intent(getApplicationContext(), DownloadActivity.class);
									startActivity(intent);
									finish();
								} else {
									AlertDialog dialog = MessageFactory.getAlertDialog(MainActivity.this, new OnDialogAction() {
										
															@Override
															public void onPositiveButtonPressed(DialogInterface dialog) {
																dialog.dismiss();
																startActivity(new Intent(Settings.ACTION_SETTINGS));
															}
															
															@Override
															public void onNegativeButtonPressed(DialogInterface dialog) {
																dialog.dismiss();
															}
															
															@Override
															public void onDialogCancel(DialogInterface dialog) {
																dialog.dismiss();
															}
														},  getString(R.string.connectivity_error_title), 
															getString(R.string.connectivity_error), 
															getString(R.string.accept_button), 
															getString(R.string.config_button));
									
									if(dialog != null)
										dialog.show();
								}
								/*Intent irPagerMainActivity = new Intent(getApplicationContext(), PagerMainActivity.class);
						    	startActivity(irPagerMainActivity);
						    	finish();*/
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
	
	/*@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	  } */
	
	@Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
       Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
   }
	
	@Override
	protected void onResume() {
		super.onResume();
		netInfo = connManager.getActiveNetworkInfo();
	}
	
}
