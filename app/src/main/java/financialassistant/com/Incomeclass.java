package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Incomeclass implements Parcelable
{
    private String description;
    private String amount;
    private String date;

    public Incomeclass() {

    }
    public Incomeclass (String description, String amount, String date){

        this.description = description;
        this.amount =amount;
        this.date = date;
    }

    protected Incomeclass(Parcel in) {
        description = in.readString();
        amount = in.readString();
        date = in.readString();
    }

    public static final Creator<Incomeclass> CREATOR = new Creator<Incomeclass>() {
        @Override
        public Incomeclass createFromParcel(Parcel in) {
            return new Incomeclass(in);
        }

        @Override
        public Incomeclass[] newArray(int size) {
            return new Incomeclass[size];
        }
    };

    public String getdescription() {
        return description;
    }
    public String getamount() {
        return amount;
    }
    public String getdate(){
        return date;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date){
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(amount);
        dest.writeString(date);
    }
}
