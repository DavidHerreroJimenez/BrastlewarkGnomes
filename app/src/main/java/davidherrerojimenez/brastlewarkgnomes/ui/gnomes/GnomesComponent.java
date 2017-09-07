package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */


@Subcomponent(modules = {GnomesModule.class, GnomesFragmentsProvider.class})
public interface GnomesComponent extends AndroidInjector<GnomesActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GnomesActivity> {
    }
}