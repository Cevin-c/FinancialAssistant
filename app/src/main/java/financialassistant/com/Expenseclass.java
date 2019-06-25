package financialassistant.com;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Expenseclass implements Parcelable {



        private String description_edittext;
        private String period;
        private String amount;
        public Expenseclass() {

        }
        public Expenseclass (String description_edittext, String period, String amount){

            this.description_edittext = description_edittext;
            this.period =period;
            this.amount = amount;
        }

    protected Expenseclass(Parcel in) {
        description_edittext = in.readString();
        period = in.readString();
        amount = in.readString();
    }

    public static final Creator<Expenseclass> CREATOR = new Creator<Expenseclass>() {
        @Override
        public Expenseclass createFromParcel(Parcel in) {
            return new Expenseclass(in);
        }

        @Override
        public Expenseclass[] newArray(int size) {
            return new Expenseclass[size];
        }
    };

    public String getDescription_edittext() {
            return description_edittext;
        }
        public String getperiod() {
            return period;
        }
        public String getAmount(){
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public void setDescription_edittext(String description_edittext) {
            this.description_edittext = description_edittext;
        }
        public void setPeriod(String period){
            this.period =period;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description_edittext);
        dest.writeString(period);
        dest.writeString(amount);
    }
}

