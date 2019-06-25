package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Reccurentexpensesclass implements Parcelable {

    private String description;
    private String amount;

    public Reccurentexpensesclass() {

    }
    public Reccurentexpensesclass(String description, String amount){

        this.description = description;
        this.amount =amount;

    }

    protected Reccurentexpensesclass(Parcel in) {
        description = in.readString();
        amount = in.readString();
    }

    public static final Creator<Reccurentexpensesclass> CREATOR = new Creator<Reccurentexpensesclass>() {
        @Override
        public Reccurentexpensesclass createFromParcel(Parcel in) {
            return new Reccurentexpensesclass(in);
        }

        @Override
        public Reccurentexpensesclass[] newArray(int size) {
            return new Reccurentexpensesclass[size];
        }
    };

    public String getdescription() {
        return description;
    }
    public String getamount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(amount);
    }
}
