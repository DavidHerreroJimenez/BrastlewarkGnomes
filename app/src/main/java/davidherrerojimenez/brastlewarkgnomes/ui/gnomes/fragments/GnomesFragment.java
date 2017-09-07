package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class GnomesFragment extends Fragment implements GnomesFragmentView, TextWatcher {

//    @Inject
//    GnomesFragmentPresenter gnomesFragmentPresenter;

    @BindView(R.id.search_gnomes)
    EditText searchGnomesEditText;

    @BindView(R.id.gnomes_recyclerview)
    RecyclerView gnomesRecyclerView;

    List<Brastlewark> brastlewarkList;

    @Inject
    public GnomesFragment() {
    }

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

        ButterKnife.bind(this,view);



        return view;
    }

    @Override
    public void onGnomesFragmentLoaded(List<Brastlewark> brastlewarkList) {

        this.brastlewarkList = brastlewarkList;


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
