package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.data.utils.Utils;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;
import davidherrerojimenez.brastlewarkgnomes.ui.utils.Images;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 8/09/17.
 */

public class DetailFragment extends Fragment implements DetailFragmentView{

    @BindView(R.id.detail_image_gnome)
    ImageView imageView;

    @BindView(R.id.detail_name_gnome)
    TextView nameTextView;

    @BindView(R.id.detail_age_gnome)
    TextView ageTextView;

    @BindView(R.id.detail_weight_gnome)
    TextView weightTextView;

    @BindView(R.id.detail_height_gnome)
    TextView heightTextView;

    @BindView(R.id.detail_haircolor_gnome)
    TextView hairTextView;

    @BindView(R.id.professions_list)
    ListView professionListView;

    @BindView(R.id.friends_list)
    ListView friendsListview;

    @BindView(R.id.tabhost)
    TabHost tabHost;



    DetailFragmentPresenter detailFragmentPresenter;


    Brastlewark brastlewark;

    ArrayAdapter<String> professionsAdapter;
    ArrayAdapter<String> friendsAdapter;

    public DetailFragment() {

        brastlewark = new Brastlewark();

        detailFragmentPresenter = new DetailFragmentPresenterImpl(this);
    }

    public static DetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_constraint, container, false);

        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();

//        brastlewark = bundle.getParcelable(Brastlewark.TAG);

        int idGnomeToShow = bundle.getInt("idGnome");
        detailFragmentPresenter.getGnomeDetail(idGnomeToShow);


        return view;
    }



    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onDetailFragmentLoaded(Brastlewark brastlewark) {

        setData(brastlewark);

    }


    private void setData(Brastlewark brastlewark){

        loadImage(getContext(), brastlewark.getThumbnail(), imageView);


        ageTextView.setText(brastlewark.getAge().toString());


        nameTextView.setText(brastlewark.getName());


        weightTextView.setText(brastlewark.getWeight().toString());


        heightTextView.setText(brastlewark.getHeight().toString());


        hairTextView.setText(brastlewark.getHairColor());


        tabHost.setup();



        Resources res = getResources();



        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_assignment_ind_black_48dp));

        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_group_black_48dp));
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_work_black_48dp));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);


        int[] toViews = {android.R.id.text1};
        String[] fromColumns = brastlewark.getProfessions().toArray(new String[0]);


        professionsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,fromColumns);

        professionListView.setAdapter(professionsAdapter);


        String[] fromFriendsColumns = brastlewark.getFriends().toArray(new String[0]);


        friendsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,fromFriendsColumns);

        friendsListview.setAdapter(friendsAdapter);




    }


    private void loadImage(Context context, String thumbnail, ImageView imageView){

        Images.loadImage(context, thumbnail, imageView);

    }
}
