package com.multimedios.concertapp.global;

import android.app.Application;

public class Global extends Application {
	private static Global instance;
	private String _nombre="vacio";
	
	private Global(){}
	
    public String get_nombre() {
        return _nombre;
    }
    
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    
    public static synchronized Global getInstance(){
    	if(instance==null){
    		instance=new Global();
    	}
    	return instance;
    }
    
}

