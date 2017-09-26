package davidherrerojimenez.brastlewarkgnomes.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import davidherrerojimenez.brastlewarkgnomes.R;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.base.
 * Created by udhj1a on 26/09/2017 19:21.
 */

public abstract class BaseFragment extends Fragment {


    private int layoutResosurce;
    private Unbinder unbinder;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResource(), container, false);

        unbinder = ButterKnife.bind(this,view);


        setView();


        return view;
    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        menu.clear();
        inflater.inflate(getMenuResource(), menu);

        setOptionsMenu(menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    protected abstract int getLayoutResource();
    protected abstract void setView();

    protected abstract int getMenuResource();
    protected abstract void setOptionsMenu(Menu menu);

}
