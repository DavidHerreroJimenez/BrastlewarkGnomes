package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.DetailActivity;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.adapters.GnomeAdapter;

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

    @BindView(R.id.empty_list_textview)
    TextView emptyListtextView;

    private List<Brastlewark> brastlewarkList;
    private String message;
    private GnomeAdapter gnomeAdapter;

    @Inject
    public GnomesFragment() {
        brastlewarkList = new ArrayList<>();
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


        if(savedInstanceState != null){
            brastlewarkList.clear();

            brastlewarkList = savedInstanceState.getParcelableArrayList(Brastlewark.TAG);
        }


        searchGnomesEditText.addTextChangedListener(this);

        gnomesRecyclerView.setHasFixedSize(true);

//        gnomesFragmentPresenter.showListOrHide(listCharactersFromApi, rvHeroesList, tvEmptyList);

//        gnomesFragmentPresenter.newListIfListIsNull(brastlewarkList);

        gnomeAdapter = new GnomeAdapter(getContext(), brastlewarkList);

        gnomeAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DetailActivity.class);

                Brastlewark brastlewark = brastlewarkList.get(gnomesRecyclerView.getChildAdapterPosition(view));

                Bundle b = new Bundle();
                b.putParcelable(Brastlewark.TAG, brastlewark);

                intent.putExtra("bundle", b);

                startActivity(intent);
            }
        });


        gnomesRecyclerView.setAdapter(gnomeAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        gnomesRecyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onGnomesFragmentLoaded(List<Brastlewark> brastlewarkList, String message) {

        this.brastlewarkList = brastlewarkList;

        this.message = message;


    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        //TODO llamar a lógica que filtra los resultados

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


    public void getListOrEmptyTextIfListIsEmpty(RecyclerView gnomesRecyclerView, TextView emptyListtextView) {

        this.gnomesRecyclerView = gnomesRecyclerView;
        this.emptyListtextView = emptyListtextView;

    }


    public void refreshListAdapter(List<Brastlewark> brastlewarks) {


        if(gnomeAdapter != null) {
            this.brastlewarkList = brastlewarks;
            gnomeAdapter.setList(brastlewarkList);
            gnomeAdapter.notifyDataSetChanged();


            if (brastlewarkList == null || brastlewarkList.isEmpty()){
                gnomesRecyclerView.setVisibility(View.GONE);
                emptyListtextView.setVisibility(View.VISIBLE);
            }else{
                gnomesRecyclerView.setVisibility(View.VISIBLE);
                emptyListtextView.setVisibility(View.GONE);
            }

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        ArrayList<Brastlewark> listToSave = new ArrayList<Brastlewark>();

        if (brastlewarkList != null)
        listToSave.addAll(brastlewarkList);

        if (outState != null)
        outState.putParcelableArrayList(Brastlewark.TAG, listToSave);

        super.onSaveInstanceState(outState);


    }
}
