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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.ui.detail.DetailActivity;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.adapters.GnomeAdapter;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments
 * <p>
 * Created by dherrero on 7/09/17.
 */

public class GnomesFragment extends Fragment implements GnomesFragmentView{


    @BindView(R.id.gnomes_recyclerview)
    RecyclerView gnomesRecyclerView;

    @BindView(R.id.empty_list_textview)
    TextView emptyListtextView;

    private static List<Gnome> gnomeList;
    private String message;
    private static GnomeAdapter gnomeAdapter;
    private Unbinder unbinder;

    @Inject
    public GnomesFragment() {
        gnomeList = new ArrayList<>();
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


        gnomesRecyclerView.setHasFixedSize(true);



        gnomeAdapter = new GnomeAdapter(getContext(), gnomeList);

        gnomeAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DetailActivity.class);

                Gnome gnome = gnomeList.get(gnomesRecyclerView.getChildAdapterPosition(view));

                int idGnome = gnome.getId();

                intent.putExtra("idGnome", idGnome);


                startActivity(intent);
            }
        });


        gnomesRecyclerView.setAdapter(gnomeAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        gnomesRecyclerView.setLayoutManager(layoutManager);


        return view;
    }

    @Override
    public void onGnomesFragmentLoaded(List<Gnome> gnomeList, String message) {

        this.gnomeList = gnomeList;

        this.message = message;

        refreshListAdapter(gnomeList);

    }


    public void refreshListAdapter(List<Gnome> gnomes) {


        if(gnomeAdapter != null) {
            this.gnomeList = gnomes;
            gnomeAdapter.setList(gnomeList);
            gnomeAdapter.notifyDataSetChanged();



        }

    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        menu.clear();
        inflater.inflate(R.menu.menu_gnomes, menu);

        MenuItem search = menu.findItem(R.id.search_filter_gnomes);
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
