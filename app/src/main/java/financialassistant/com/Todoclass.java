package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Todoclass implements Parcelable {
    private String description;
    private String date;

    public Todoclass() {

    }
    public Todoclass (String description, String date){

        this.description = description;
        this.date =date;

    }

    protected Todoclass(Parcel in) {
        description = in.readString();
        date = in.readString();
    }

    public static final Creator<Todoclass> CREATOR = new Creator<Todoclass>() {
        @Override
        public Todoclass createFromParcel(Parcel in) {
            return new Todoclass(in);
        }

        @Override
        public Todoclass[] newArray(int size) {
            return new Todoclass[size];
        }
    };

    public String getdescription() {
        return description;
    }
    public String getdate() {
        return date;
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
        dest.writeString(date);
    }
}
