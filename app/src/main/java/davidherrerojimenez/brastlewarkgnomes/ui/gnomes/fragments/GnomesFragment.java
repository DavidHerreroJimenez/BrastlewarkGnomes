package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class GnomesFragment extends Fragment implements GnomesFragmentView {

    @Inject
    GnomesFragmentPresenter gnomesFragmentPresenter;

    public static GnomesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GnomesFragment fragment = new GnomesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gnomes, container, false);

        return view;
    }

    @Override
    public void onGnomesFragmentLoaded() {

    }
}
