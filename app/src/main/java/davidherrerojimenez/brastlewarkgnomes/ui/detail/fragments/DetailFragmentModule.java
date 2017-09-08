package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import dagger.Module;
import dagger.Provides;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 8/09/17.
 */

@Module
public class DetailFragmentModule {

    @Provides
    DetailFragmentView provideDetailFragmentView(DetailFragment detailFragment){
        return detailFragment;
    }
}
