package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragmentComponent;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */



@Module
public abstract class GnomesFragmentsProvider {

    @Binds
    @IntoMap
    @FragmentKey(GnomesFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideGnomesFragmentFactory(GnomesFragmentComponent.Builder builder);
}

