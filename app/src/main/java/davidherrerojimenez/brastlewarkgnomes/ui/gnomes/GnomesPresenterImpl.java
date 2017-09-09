package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import java.util.List;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.data.Api;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class GnomesPresenterImpl implements GnomesPresenter, Api.ApiCallBack {

    GnomesView gnomesView;
    ApiImpl apiImpl;

    String error;
    List<Brastlewark> gnomishList;

    @Inject
    public GnomesPresenterImpl(GnomesView gnomesView, ApiImpl apiImpl) {
        this.gnomesView = gnomesView;
        this.apiImpl = apiImpl;
    }


    @Override
    public void loadGnomes() {
        try {
            apiImpl.getGnomishListData(this);
        } catch (Exception e) {
           handleExceptions(e);
        }

    }


    private void handleExceptions(Exception e){

        error = e.getLocalizedMessage();

    }


    @Override
    public void onApiCallBack(Object o, String message) {

        gnomesView.onGnomesLoaded((List<Brastlewark>) o,message);

    }
}
