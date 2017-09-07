package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import dagger.Module;
import dagger.Provides;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragmentComponent;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragmentView;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */


@Module(subcomponents = GnomesFragmentComponent.class)
public class GnomesModule {

    @Provides
    GnomesView provideGnomesView(GnomesActivity gnomesActivity) {

        return gnomesActivity;
    }

    @Provides
    GnomesPresenter provideGnomesPresenter(GnomesView gnomesView, ApiImpl apiImpl) {

        return new GnomesPresenterImpl(gnomesView, apiImpl);
    }

    @Provides
    GnomesFragmentView provideGnomesFragmentView(GnomesFragment gnomesFragment){

        return gnomesFragment;
    }
}
