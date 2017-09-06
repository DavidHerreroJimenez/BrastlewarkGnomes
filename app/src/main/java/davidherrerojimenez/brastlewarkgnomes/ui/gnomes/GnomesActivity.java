package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import davidherrerojimenez.brastlewarkgnomes.R;

public class GnomesActivity extends AppCompatActivity implements GnomesView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnomes);


    }
}
