package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.data.Api;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;
import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.model.GnomeToPrint;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 9/09/17.
 */

public class DetailFragmentPresenterImpl implements DetailFragmentPresenter, Api.ApiCallBack {

    DetailFragmentView detailFragmentView;

    @Inject
    ApiImpl api;

    @Inject
    public DetailFragmentPresenterImpl(DetailFragmentView detailFragmentView) {
        this.detailFragmentView = detailFragmentView;

    }


    @Override
    public void getGnomeDetail(int idGnomeToShow) {

        api.loadGnomeData(idGnomeToShow, this);


    }

    @Override
    public void onApiCallBack(Object o, String message) {

        GnomeToPrint gnomeToPrint = convertGnomeToGnomeToPrint((Gnome) o);

        detailFragmentView.onDetailFragmentLoaded(gnomeToPrint);
    }


    private GnomeToPrint convertGnomeToGnomeToPrint(Gnome gnome) {

        GnomeToPrint gnomeToPrint = new GnomeToPrint();


        gnomeToPrint.setId(checkIdGnome(gnome.getId()));

        gnomeToPrint.setAge(checkAgeGnome(gnome.getAge()));

        gnomeToPrint.setName(checkNameGnome(gnome.getName()));

        gnomeToPrint.setWeight(checkWeightGnome(gnome.getWeight()));

        gnomeToPrint.setHeight(checkHeightGnome(gnome.getHeight()));

        gnomeToPrint.setHairColor(checkHairGnome(gnome.getHairColor()));


        gnomeToPrint.setFriends(gnome.getFriends());

        gnomeToPrint.setProfessions(gnome.getProfessions());

        gnomeToPrint.setThumbnail(gnome.getThumbnail());


        return gnomeToPrint;

    }



    private String checkIdGnome(Integer idToVerify) {

        String id = "";

        try {

            id = idToVerify.toString();

        } catch (Exception e) {

            id = "0";

        } finally {

            if (id == null || id.isEmpty()) {
                id = "0";
            }

        }


        return id;

    }


    private String checkAgeGnome(Integer ageToVerify) {

        String age = "";

        try {

            age = ageToVerify.toString();

        } catch (Exception e) {

            age = "0";

        } finally {

            if (age == null || age.isEmpty()) {
                age = "0";
            }

        }


        return age;

    }

    private String checkNameGnome(String nameToVerify) {
        String name = nameToVerify != null ? nameToVerify : "";

        return name;
    }

    private String checkWeightGnome(Double weightToVerify) {

        String weight = "";

        try {

            weight = weightToVerify != null ? weightToVerify.toString() : "0.0";

        } catch (Exception e) {

            weight = "0.0";

        } finally {

            if (weight == null || weight.isEmpty()) {
                weight = "0.0";
            }

        }

        return weight;
    }

    private String checkHeightGnome(Double heightToVerify) {

        String height = "";

        try {

            height = heightToVerify != null ? heightToVerify.toString() : "0.0";

        } catch (Exception e) {

            height = "0.0";

        } finally {

            if (height == null || height.isEmpty()) {
                height = "0.0";
            }

        }

        return height;

    }

    private String checkHairGnome(String hairToVerify) {

        String hair = hairToVerify != null ? hairToVerify : "";


        return hair;
    }
}
