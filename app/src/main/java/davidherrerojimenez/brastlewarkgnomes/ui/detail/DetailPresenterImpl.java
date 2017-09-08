package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.data.Api;
import davidherrerojimenez.brastlewarkgnomes.data.ApiImpl;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail
 * <p>
 * Created by dherrero on 8/09/17.
 */

public class DetailPresenterImpl implements DetailPresenter{

    DetailView detailView;
    ApiImpl apiService;

    @Inject
    public DetailPresenterImpl(DetailView detailView, ApiImpl apiService) {
        this.detailView = detailView;
        this.apiService = apiService;
    }

    public void loadDetail(){
        detailView.onDetailLoaded();
    }
}
