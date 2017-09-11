
package davidherrerojimenez.brastlewarkgnomes.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrastlewarkGnomes implements Parcelable
{

    @SerializedName("Brastlewark")
    @Expose
    private List<Gnome> gnome = null;
    public final static Creator<BrastlewarkGnomes> CREATOR = new Creator<BrastlewarkGnomes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BrastlewarkGnomes createFromParcel(Parcel in) {
            BrastlewarkGnomes instance = new BrastlewarkGnomes();
            in.readList(instance.gnome, (Gnome.class.getClassLoader()));
            return instance;
        }

        public BrastlewarkGnomes[] newArray(int size) {
            return (new BrastlewarkGnomes[size]);
        }

    }
    ;

    public List<Gnome> getGnome() {
        return gnome;
    }

    public void setGnome(List<Gnome> gnome) {
        this.gnome = gnome;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(gnome);
    }

    public int describeContents() {
        return  0;
    }

}
