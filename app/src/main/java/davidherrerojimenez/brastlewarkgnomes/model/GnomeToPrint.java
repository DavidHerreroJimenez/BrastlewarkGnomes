package davidherrerojimenez.brastlewarkgnomes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.model
 * <p>
 * Created by dherrero on 26/09/17.
 */

public class GnomeToPrint {


    private String id;
    private String name;
    private String thumbnail;
    private String age;
    private String weight;
    private String height;
    private String hairColor;
    private List<String> professions = null;
    private List<String> friends = null;
    private String gender;


    public GnomeToPrint() {
    }

    public GnomeToPrint(String id, String name, String thumbnail, String age, String weight, String height, String hairColor, List<String> professions, List<String> friends, String gender) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.professions = professions;
        this.friends = friends;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
