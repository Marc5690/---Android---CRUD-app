package ie.ds.wit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import ie.ds.wit.EntertainmentActivity;


public class AddStock extends EntertainmentActivity{
	   
	
	@Override
	    
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);
	     TextView firstText = (TextView)findViewById(R.id.textView1);
         EditText aje = (EditText) findViewById(R.id.editText2);
         Button a = (Button)findViewById(R.id.button1);//Add stock button
         Button b = (Button)findViewById(R.id.button2);//return button
          
          a.setOnClickListener(new Convert());
          b.setOnClickListener(new Convert());
      }
		
          private class Convert implements OnClickListener {
  	 
          	
          
		public void onClick(View view) 
          { 
        	  
        	  
          	try {
          if(view.getId() == R.id.button1)
          {
        	  EditText aj = (EditText) findViewById(R.id.editText2);
              String m;
              m = aj.getText().toString();
              t.add(m);              
              Bundle extras = new Bundle();     
              
              
              extras.putSerializable("conv", t);     
              Intent ListStockIntent = new Intent(AddStock.this, ListStock.class);
             ListStockIntent.putExtras(extras); 
          	startActivity(ListStockIntent);
          }
          else
          	if(view.getId() == R.id.button2)
          	{
          		Intent AddStockIntent = new Intent(AddStock.this, EntertainmentActivity.class);
              	startActivity(AddStockIntent);
          	}
         
          	}
          	catch (Exception E){
         		Log.e("AddStock Class", "Error when selecting buttons");
          	}}
          
          
          }
          }
    

