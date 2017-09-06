
package davidherrerojimenez.brastlewarkgnomes.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gnome implements Parcelable
{

    @SerializedName("Brastlewark")
    @Expose
    private List<Brastlewark> brastlewark = null;
    public final static Creator<Gnome> CREATOR = new Creator<Gnome>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gnome createFromParcel(Parcel in) {
            Gnome instance = new Gnome();
            in.readList(instance.brastlewark, (Brastlewark.class.getClassLoader()));
            return instance;
        }

        public Gnome[] newArray(int size) {
            return (new Gnome[size]);
        }

    }
    ;

    public List<Brastlewark> getBrastlewark() {
        return brastlewark;
    }

    public void setBrastlewark(List<Brastlewark> brastlewark) {
        this.brastlewark = brastlewark;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(brastlewark);
    }

    public int describeContents() {
        return  0;
    }

}
