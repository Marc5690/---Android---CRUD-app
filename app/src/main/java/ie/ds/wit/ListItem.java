package ie.ds.wit;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ListItem extends MainActivity {

    ArrayList<Item> listItems;
    MyCustomAdapter adapter;
    private ListView gridView;

    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listItems = getIntent().getExtras().getParcelableArrayList("itemName");
        gridView = (ListView) findViewById(R.id.list);
        adapter = new MyCustomAdapter(this.getApplicationContext());
        gridView.setAdapter(adapter);

        Button returnButton = (Button) findViewById(R.id.returnToMain);
        returnButton.setOnClickListener(new Click());
    }

    class Click implements OnClickListener {
        public void onClick(View view) {
            try {
                if (view.getId() == R.id.returnToMain) {
                    Intent MenuIntent = new Intent(ListItem.this, MainActivity.class);
                    startActivity(MenuIntent);
                } else {
                    Log.e("ListItem Class", "Error when selecting button");
                }
            } catch (Exception E) {
                Log.e("ListItem Class", "Error when selecting button");
            }
        }
    }
}