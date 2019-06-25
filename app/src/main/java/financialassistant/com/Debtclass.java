package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Debtclass implements Parcelable {

    private String description;
    private String duedate;
    private String dateborrowed;
    public Debtclass() {

    }
    public Debtclass (String description, String duedate, String dateborrowed){

        this.description = description;
        this.duedate =duedate;
        this.dateborrowed = dateborrowed;
    }

    protected Debtclass(Parcel in) {
        description = in.readString();
        duedate = in.readString();
        dateborrowed = in.readString();
    }

    public static final Creator<Debtclass> CREATOR = new Creator<Debtclass>() {
        @Override
        public Debtclass createFromParcel(Parcel in) {
            return new Debtclass(in);
        }

        @Override
        public Debtclass[] newArray(int size) {
            return new Debtclass[size];
        }
    };

    public String getdescription() {
        return description;
    }
    public String getduedate() {
        return duedate;
    }
    public String getdateborrowed(){
        return dateborrowed;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDateborrowed(String dateborrowed){
        this.dateborrowed = dateborrowed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(duedate);
        dest.writeString(dateborrowed);
    }
}
