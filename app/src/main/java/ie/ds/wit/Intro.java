package ie.ds.wit;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Intro extends Activity {
      MediaPlayer Cricket;
	
	   public void onCreate(Bundle ABundle) {
	        super.onCreate(ABundle);
	         setContentView(R.layout.splash);
	         Cricket = MediaPlayer.create(this, R.raw.crickets);
	         Thread logoTimer = new Thread(){
     	
	       public void run(){
     	   try{
     			int logoTimer = 0;
     			while(logoTimer<2000){
     				sleep(100);
     				logoTimer = logoTimer +100;
     			}
     			
     			startActivity(new Intent ("ie.ds.wit.CLEARSCREEN"));
     		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		
     		finally{
     			finish();
     		}
     	}
     	
     };
     
     logoTimer.start();
	
	}
	
	 @Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			Cricket.release();
			}
	 @Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			Cricket.pause();
			}
	 @Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			Cricket.start();
			}
	 
		@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
		}


		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
		}
		

		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
		}
}


