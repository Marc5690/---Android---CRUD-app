package ie.ds.wit;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import ie.ds.wit.AddStock;
import ie.ds.wit.ListStock;
import ie.ds.wit.EntertainmentActivity;

public class EntertainmentActivity extends Activity {
    /** Called when the activity is first created. */
	ArrayList <String> t = new ArrayList <String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//main
      
        Button a = (Button)findViewById(R.id.button1);//Add stock button
        Button b = (Button)findViewById(R.id.button2);//List all stock button
        Button c = (Button)findViewById(R.id.button3);//exit button
       
        a.setOnClickListener(new Click());
        b.setOnClickListener(new Click());
        c.setOnClickListener(new Click());
    }
    
		 class Click implements OnClickListener {
			Intent AddStockIntent = new Intent(EntertainmentActivity.this, AddStock.class);
		    Intent ListStockIntent2 = new Intent(EntertainmentActivity.this, ListStock.class);
		public void onClick(View v) 
        {
        	
        	try {
        if(v.getId() == R.id.button1)
        {
        	startActivity(AddStockIntent);
        }
        else
        	if(v.getId() == R.id.button2)
        	{
            	startActivity(ListStockIntent2);
        	}
        	else
        		if(v.getId() == R.id.button3){
        			finish();
                    System.exit(0);
        		}
        	}
        	catch (Exception E){

        		Log.e("AddStock Class", "Error when selecting buttons");
        	}
 
        }
    }
		
		}
