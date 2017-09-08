package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import dagger.Module;
import dagger.Provides;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.
 * Created by udhj1a on 07/09/2017 9:34.
 */


@Module
public class GnomesFragmentModule {

    @Provides
    GnomesFragmentView provideGnomesFragmentView(GnomesFragment gnomesFragment){
        return gnomesFragment;
    }

}

