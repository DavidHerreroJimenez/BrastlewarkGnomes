package davidherrerojimenez.brastlewarkgnomes.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.GnomesFragment;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.base
 * <p>
 * Created by dherrero on 26/09/17.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setTheme(getCustomTheme());
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        setLogicOnCreate();

    }

    protected abstract int getCustomTheme();

    protected abstract int getLayoutResource();

    protected abstract void setLogicOnCreate();
}
