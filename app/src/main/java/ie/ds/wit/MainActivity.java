package ie.ds.wit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    static ArrayList<Item> items = new ArrayList<Item>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//main

        Button addItemButton = (Button) findViewById(R.id.editItem);//Add item button
        Button listItemButton = (Button) findViewById(R.id.listItem);//List all items button
        Button exitButton = (Button) findViewById(R.id.exit);//exit button

        addItemButton.setOnClickListener(new Click());
        listItemButton.setOnClickListener(new Click());
        exitButton.setOnClickListener(new Click());
    }

    class Click implements OnClickListener {
        Intent addItemIntent = new Intent(MainActivity.this, AddItem.class);
        Intent listItemIntent = new Intent(MainActivity.this, ListItem.class);

        public void onClick(View view) {

            Bundle bundle = new Bundle();

            bundle.putParcelableArrayList("itemName",items);
            listItemIntent.putExtras(bundle);
            addItemIntent.putExtras(bundle);

            try {
                if (view.getId() == R.id.editItem) {
                    startActivity(addItemIntent);
                } else if (view.getId() == R.id.listItem) {
                    startActivity(listItemIntent);
                } else if (view.getId() == R.id.exit) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            } catch (Exception E) {
                Log.e("Main Class", "Error when selecting buttons");
            }

        }
    }

}
