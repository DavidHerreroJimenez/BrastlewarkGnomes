package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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

public class GnomesFragment extends Fragment implements GnomesFragmentView{

//    @Inject
//    GnomesFragmentPresenter gnomesFragmentPresenter;


    @BindView(R.id.gnomes_recyclerview)
    RecyclerView gnomesRecyclerView;

    @BindView(R.id.empty_list_textview)
    TextView emptyListtextView;

    private static List<Brastlewark> brastlewarkList;
    private String message;
    private static GnomeAdapter gnomeAdapter;
    private Unbinder unbinder;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gnomes, container, false);

        unbinder = ButterKnife.bind(this,view);


        if(savedInstanceState != null){
            brastlewarkList.clear();

            brastlewarkList = savedInstanceState.getParcelableArrayList(Brastlewark.TAG);
        }


        gnomesRecyclerView.setHasFixedSize(true);



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

        refreshListAdapter(brastlewarkList);

    }


    public void refreshListAdapter(List<Brastlewark> brastlewarks) {


        if(gnomeAdapter != null) {
            this.brastlewarkList = brastlewarks;
            gnomeAdapter.setList(brastlewarkList);
            gnomeAdapter.notifyDataSetChanged();



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

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_gnomes, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                gnomeAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
