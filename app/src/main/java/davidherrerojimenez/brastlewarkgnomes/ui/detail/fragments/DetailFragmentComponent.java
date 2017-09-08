package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 8/09/17.
 */

@Subcomponent(modules = DetailFragmentModule.class)
public interface DetailFragmentComponent extends AndroidInjector<DetailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailFragment> {
    }
}
