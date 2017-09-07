package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import javax.inject.Inject;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.
 * Created by udhj1a on 07/09/2017 9:34.
 */



public class GnomesFragmentPresenter {

    GnomesFragmentView gnomesFragmentView;

    @Inject
    public GnomesFragmentPresenter(GnomesFragmentView gnomesFragmentView) {
        this.gnomesFragmentView = gnomesFragmentView;
        gnomesFragmentView.onGnomesFragmentLoaded();
    }
}