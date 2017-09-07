package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;

public class GnomesActivity extends AppCompatActivity implements HasSupportFragmentInjector, GnomesView{

    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    GnomesPresenter gnomesPresenter;



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
    public void onGnomesLoaded() {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
