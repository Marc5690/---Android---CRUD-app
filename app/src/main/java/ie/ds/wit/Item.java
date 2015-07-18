package ie.ds.wit;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Marc on 16/07/2015.
 */
public class Item implements Parcelable {

    private String name;
    private int quantity;
    private String description;

    public Item(Parcel in){
        this.name = in.readString();
        this.quantity = in.readInt();
        this.description = in.readString();
    }

    public Item(String inName, int inQuantity, String inDescription){
        this.name = inName;
        this.quantity = inQuantity;
        this.description = inDescription;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.quantity);
        parcel.writeString(this.description);

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return this.name + " " + this.description + " " + this.quantity;
    }
}
