package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import davidherrerojimenez.brastlewarkgnomes.data.Api;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 9/09/17.
 */

public class DetailFragmentPresenterImpl implements  DetailFragmentPresenter, Api.ApiCallBack {

    DetailFragmentView detailFragmentView;

    Api api;



    public DetailFragmentPresenterImpl(DetailFragmentView detailFragmentView) {
        this.detailFragmentView = detailFragmentView;

        api = new ApiImpl();
    }


    @Override
    public void getGnomeDetail(int idGnomeToShow) {

        api.loadGnomeData(idGnomeToShow, this);


    }

    @Override
    public void onApiCallBack(Object o, String message) {

        detailFragmentView.onDetailFragmentLoaded((Brastlewark) o);
    }
}