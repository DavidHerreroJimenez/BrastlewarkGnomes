package davidherrerojimenez.brastlewarkgnomes.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.GnomesComponent;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.di
 * <p>
 * Created by dherrero on 7/09/17.
 */

@Module(subcomponents = GnomesComponent.class)
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

}
