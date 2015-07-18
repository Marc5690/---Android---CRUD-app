package ie.ds.wit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Marc on 18/07/2015.
 */
public class EditItem extends MainActivity {

        private EditText itemNameText;
        private EditText itemDescriptionText;
        private EditText itemQuantityText;
        private TextView itemOriginalName;
        private Bundle bundle;
        private Intent intent;
        private Integer position;
        private Item currentItem;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.edit_item_layout);
            intent = getIntent();
            bundle = intent.getExtras();
            position = Integer.valueOf(bundle.getInt("position"));

            currentItem = items.get(position);
            itemOriginalName = (TextView) findViewById(R.id.textView4);
            Button addItemButton = (Button) findViewById(R.id.editItem);//Add item button
            Button listItemButton = (Button) findViewById(R.id.listItem);//return button

            itemOriginalName.setText(currentItem.getName());
            addItemButton.setOnClickListener(new Convert());
            listItemButton.setOnClickListener(new Convert());
        }

        private class Convert implements View.OnClickListener {


            public void onClick(View view) {


                try {
                    if (view.getId() == R.id.editItem) {
                        Intent ListItemIntent = new Intent(EditItem.this, MainActivity.class);
                        itemNameText = (EditText) findViewById(R.id.nameText);
                        itemDescriptionText =  (EditText) findViewById(R.id.descriptionText);
                        itemQuantityText =  (EditText) findViewById(R.id.quantityText);

                        Bundle bundle = new Bundle();
                        String itemName = itemNameText.getText().toString();
                        String itemDescription = itemDescriptionText.getText().toString();
                        int itemQuantity = 0;

                        try{
                            itemQuantity = Integer.valueOf(itemQuantityText.getText().toString());
                        }
                        catch(NumberFormatException nfe){
                            Toast toast = new Toast(null);
                            toast.setText("Please enter a numeric value for quantity: " + nfe.getMessage());
                            Intent retryIntent = new Intent(EditItem.this, ListItem.class);
                            startActivity(retryIntent);
                        }

                        Log.e("Before adding: ", items.toString());


                        currentItem.setName(itemName);
                        currentItem.setDescription(itemDescription);
                        currentItem.setQuantity(itemQuantity);

                        bundle.putParcelableArrayList("itemName", items);
                        ListItemIntent.putExtras(bundle);

                        startActivity(ListItemIntent);

                    }
                    else if (view.getId() == R.id.returnToMain) {
                        intent = new Intent(EditItem.this, MainActivity.class);

                    }

                } catch (Exception E) {
                    Log.e("EditItem Class", "Error when selecting buttons");
                }
            }


        }
    }

