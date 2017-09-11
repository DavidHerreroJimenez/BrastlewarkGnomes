
package davidherrerojimenez.brastlewarkgnomes.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gnome implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("professions")
    @Expose
    private List<String> professions = null;
    @SerializedName("friends")
    @Expose
    private List<String> friends = null;
    public final static Creator<Gnome> CREATOR = new Creator<Gnome>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gnome createFromParcel(Parcel in) {
            Gnome instance = new Gnome();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
            instance.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.weight = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.height = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.hairColor = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.professions, (String.class.getClassLoader()));
            in.readList(instance.friends, (String.class.getClassLoader()));
            return instance;
        }

        public Gnome[] newArray(int size) {
            return (new Gnome[size]);
        }

    }
    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(thumbnail);
        dest.writeValue(age);
        dest.writeValue(weight);
        dest.writeValue(height);
        dest.writeValue(hairColor);
        dest.writeList(professions);
        dest.writeList(friends);
    }

    public int describeContents() {
        return  0;
    }

}
