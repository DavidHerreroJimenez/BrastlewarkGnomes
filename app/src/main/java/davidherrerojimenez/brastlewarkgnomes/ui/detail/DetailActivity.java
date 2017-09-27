package davidherrerojimenez.brastlewarkgnomes.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.ui.base.BaseActivity;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments.DetailFragment;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class DetailActivity extends BaseActivity implements HasSupportFragmentInjector, DetailView{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onDetailLoaded() {

    }

    @Override
    protected int getCustomTheme() {
        return 0;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    protected void setLogicOnCreate() {

        Bundle bundle = getIntent().getExtras();


        DetailFragment detailFragment = DetailFragment.newInstance();

        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.container, detailFragment).commit();

    }
}
