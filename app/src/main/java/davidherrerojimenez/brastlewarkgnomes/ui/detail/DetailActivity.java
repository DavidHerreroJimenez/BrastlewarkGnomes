package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments.DetailFragment;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class DetailActivity extends AppCompatActivity implements HasSupportFragmentInjector, DetailView{

    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getBundleExtra("bundle");

        DetailFragment detailFragment = DetailFragment.newInstance();

        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.container, detailFragment).commit();

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onDetailLoaded() {

    }
}
