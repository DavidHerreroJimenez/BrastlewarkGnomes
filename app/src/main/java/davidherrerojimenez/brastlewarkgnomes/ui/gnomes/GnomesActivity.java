package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import android.support.v4.app.Fragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.ui.base.BaseActivity;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragmentView;

public class GnomesActivity extends BaseActivity implements HasSupportFragmentInjector, GnomesView{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    GnomesPresenter gnomesPresenter;

    @Inject
    GnomesFragmentView gnomesFragmentView;



    @Override
    public void onGnomesLoaded(List<Gnome> gnomes, String message) {

        gnomesFragmentView.onGnomesFragmentLoaded(gnomes, message);

    }



    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


    @Override
    protected int getCustomTheme() {

        return 0;

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_gnomes;
    }

    @Override
    protected void setLogicOnCreate() {

        gnomesPresenter.loadGnomes();

        getSupportFragmentManager().beginTransaction().add(R.id.gnomes_fragment_container, GnomesFragment.newInstance()).commitAllowingStateLoss();

    }
}
