package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragmentView;

public class GnomesActivity extends AppCompatActivity implements HasSupportFragmentInjector, GnomesView{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    GnomesPresenter gnomesPresenter;

    @Inject
    GnomesFragmentView gnomesFragmentView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //        setTheme(R.style.AppTheme);
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnomes);

        gnomesPresenter.loadGnomes();

        getSupportFragmentManager().beginTransaction().add(R.id.gnomes_fragment_container, GnomesFragment.newInstance()).commitAllowingStateLoss();


    }


    @Override
    public void onGnomesLoaded(List<Brastlewark> brastlewarks, String message) {

        gnomesFragmentView.onGnomesFragmentLoaded(brastlewarks, message);

    }





    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
