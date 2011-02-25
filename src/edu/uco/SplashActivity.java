package edu.uco;

import edu.uco.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class SplashActivity extends Activity {
    /** Called when the activity is first created. */
	long m_dwSplashTime = 2000;
	boolean m_bPaused = false;
	boolean m_bSplashActive = true;
	private ProgressDialog pd;
	
	protected void onPause(){
		super.onPause();
		m_bPaused = true;
	}
	
	protected void onResume(){
		super.onResume();
		m_bPaused = false;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		super.onKeyDown(keyCode, event);
		m_bSplashActive = false;
		return true;
	}
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.splash);
        pd = ProgressDialog.show(this, "Loading...", "Loading the system. Please wait!", true,
                false);
        
        Thread splashTimer = new Thread(){
        	public void run(){
        		try
        		{
        			//Wait loop
        			long ms = 0;
        			while(m_bSplashActive && ms < m_dwSplashTime)
        			{
        				sleep(100);
        				//Advance the timer only if we're running.
        				if(!m_bPaused)
        					ms += 100;
        			}
        			//Advance to the next screen.
        			pd.dismiss();
        			startActivity(new Intent(
        				"com.google.app.splashy.CLEARSPLASH"));
        		}
        		catch(Exception e)
        		{
        			Log.e("Splash", e.toString());
        		}
        		finally
        		{
        			finish();
        		}
        	}
        };
        	splashTimer.start();
        }
    }
