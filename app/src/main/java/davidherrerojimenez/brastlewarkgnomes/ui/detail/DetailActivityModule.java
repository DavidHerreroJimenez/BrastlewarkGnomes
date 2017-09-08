package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import dagger.Module;
import dagger.Provides;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments.DetailFragmentComponent;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail
 * <p>
 * Created by dherrero on 8/09/17.
 */

@Module(subcomponents = DetailFragmentComponent.class)
public class DetailActivityModule {

    @Provides
    DetailView provideDetailView(DetailActivity detailActivity) {
        return detailActivity;
    }

    @Provides
    DetailPresenter provideDetailPresenter(DetailView detailView, ApiImpl apiService) {
        return new DetailPresenterImpl(detailView, apiService);
    }
}