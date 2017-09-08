package davidherrerojimenez.brastlewarkgnomes.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import davidherrerojimenez.brastlewarkgnomes.App;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.di
 * <p>
 * Created by dherrero on 7/09/17.
 */

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder app(Application application);

        AppComponent build();
    }

    void inject(App app);
}