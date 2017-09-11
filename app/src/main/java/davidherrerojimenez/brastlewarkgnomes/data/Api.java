package davidherrerojimenez.brastlewarkgnomes.data;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data
 * <p>
 * Created by dherrero on 7/09/17.
 */

public interface Api {

    void loadGnomeData(int idGnomeToShow, final ApiCallBack apiCallBack);

    void getGnomishListData(final ApiCallBack apiCallBack);


    interface ApiCallBack{

        void onApiCallBack(Object o, String message);
    }


}
