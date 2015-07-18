package ie.ds.wit;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import ie.ds.wit.EntertainmentActivity;
import ie.ds.wit.AddStock;

public class ListStock extends EntertainmentActivity{

	 
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.list2);
	 Bundle extras = getIntent().getExtras(); 
	 ArrayList <String> a = (ArrayList <String>) extras.getSerializable("conv");
	 
	 TextView firstText = (TextView)findViewById(R.id.textView1);
	 TextView secondText = (TextView)findViewById(R.id.textView2);
	 TextView thirdText = (TextView)findViewById(R.id.textView3);
	 TextView fourthText = (TextView)findViewById(R.id.textView4);
	 
	 Button z = (Button)findViewById(R.id.button1);
	 z.setOnClickListener(new Click());
	 firstText.setText(a.get(0));


	}
	
	class Click implements OnClickListener {
	 public void onClick(View view) 
     { 
   	  
   	  
     	try {
     if(view.getId() == R.id.button1)
     		
     {
	 Intent MenuIntent = new Intent(ListStock.this, EntertainmentActivity.class);
   	startActivity(MenuIntent);
     }
     else{
    	 Log.e("ListStock Class", "Error when selecting button");
     }
     }
     catch(Exception E){
    	 Log.e("ListStock Class", "Error when selecting button");
		}
     	}}}