package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties

public class Userclass implements Parcelable {

    private String description;
    private String duedate;
    private String dateborrowed;
    public Userclass() {

    }
   public Userclass(String description, String duedate, String dateborrowed){

this.description = description;
this.duedate =duedate;
this.dateborrowed = dateborrowed;
   }

    protected Userclass(Parcel in) {
        description = in.readString();
        duedate = in.readString();
        dateborrowed = in.readString();
    }

    public static final Creator<Userclass> CREATOR = new Creator<Userclass>() {
        @Override
        public Userclass createFromParcel(Parcel in) {
            return new Userclass(in);
        }

        @Override
        public Userclass[] newArray(int size) {
            return new Userclass[size];
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
