package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.data.Api;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class GnomesPresenterImpl implements GnomesPresenter{

    GnomesView gnomesView;
    Api api;

    @Inject
    public GnomesPresenterImpl(GnomesView gnomesView, Api api) {
        this.gnomesView = gnomesView;
        this.api = api;
    }


    @Override
    public void loadGnomes() {
        api.getData();
        gnomesView.onGnomesLoaded();
    }
}
