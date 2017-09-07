package davidherrerojimenez.brastlewarkgnomes.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.GnomesActivity;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.GnomesComponent;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.di
 * <p>
 * Created by dherrero on 7/09/17.
 */

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(GnomesActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindGnomesActivity(GnomesComponent.Builder builder);


}