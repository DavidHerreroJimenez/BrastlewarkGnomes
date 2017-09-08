package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.
 * Created by udhj1a on 07/09/2017 9:33.
 */




@Subcomponent(modules = GnomesFragmentModule.class)
public interface GnomesFragmentComponent extends AndroidInjector<GnomesFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GnomesFragment> {
    }
}
