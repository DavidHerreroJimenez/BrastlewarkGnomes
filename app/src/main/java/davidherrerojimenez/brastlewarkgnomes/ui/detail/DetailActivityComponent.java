package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail
 * <p>
 * Created by dherrero on 8/09/17.
 */

@Subcomponent(modules = {
        DetailActivityModule.class,
        DetailFragmentProvider.class})
public interface DetailActivityComponent extends AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity> {
    }
}
