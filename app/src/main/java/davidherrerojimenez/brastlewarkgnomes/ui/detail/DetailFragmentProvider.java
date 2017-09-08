package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments.DetailFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments.DetailFragmentComponent;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail
 * <p>
 * Created by dherrero on 8/09/17.
 */

@Module
public abstract class DetailFragmentProvider {

    @Binds
    @IntoMap
    @FragmentKey(DetailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideDetailFragmentFactory(DetailFragmentComponent.Builder builder);
}
