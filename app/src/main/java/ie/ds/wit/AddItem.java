package ie.ds.wit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddItem extends MainActivity {


    private EditText itemNameText;
    private EditText itemDescriptionText;
    private EditText itemQuantityText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        Button addItemButton = (Button) findViewById(R.id.editItem);//Add item button
        Button listItemButton = (Button) findViewById(R.id.listItem);//return button

        addItemButton.setOnClickListener(new Convert());
        listItemButton.setOnClickListener(new Convert());
    }

    private class Convert implements OnClickListener {


        public void onClick(View view) {


            try {
                if (view.getId() == R.id.editItem) {
                    Intent ListItemIntent = new Intent(AddItem.this, ListItem.class);
                    itemNameText = (EditText) findViewById(R.id.nameText);
                    itemDescriptionText =  (EditText) findViewById(R.id.descriptionText);
                    itemQuantityText =  (EditText) findViewById(R.id.quantityText);

                    Bundle bundle = new Bundle();
                    String itemName = itemNameText.getText().toString();
                    String itemDescription = itemDescriptionText.getText().toString();
                    Integer itemQuantity = 0;
                    try{
                        itemQuantity = Integer.valueOf(itemQuantityText.getText().toString());
                    }
                    catch(NumberFormatException nfe){
                        Toast toast = new Toast(null);
                        toast.setText("Please enter a numeric value for quantity: " + nfe.getMessage());
                        Intent retryIntent = new Intent(AddItem.this, AddItem.class);
                        startActivity(retryIntent);
                    }
                    items.add(new Item(itemName, itemQuantity, itemDescription));
                    bundle.putParcelableArrayList("itemName", items);
                    ListItemIntent.putExtras(bundle);

                    startActivity(ListItemIntent);

                } else if (view.getId() == R.id.returnToMain) {
                    Intent AddItemIntent = new Intent(AddItem.this, MainActivity.class);
                    startActivity(AddItemIntent);

                }

            } catch (Exception E) {
                Log.e("AddItem Class", "Error when selecting buttons");
            }
        }


    }
}
    

