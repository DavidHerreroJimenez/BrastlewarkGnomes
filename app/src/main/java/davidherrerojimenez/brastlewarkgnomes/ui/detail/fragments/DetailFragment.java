package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.model.GnomeToPrint;
import davidherrerojimenez.brastlewarkgnomes.ui.base.BaseFragment;
import davidherrerojimenez.brastlewarkgnomes.ui.utils.Images;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 8/09/17.
 */

public class DetailFragment extends BaseFragment implements DetailFragmentView{

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


    @Inject
    DetailFragmentPresenterImpl detailFragmentPresenter;


    Gnome gnome;

    ArrayAdapter<String> professionsAdapter;
    ArrayAdapter<String> friendsAdapter;

    public DetailFragment() {

        gnome = new Gnome();
    }

    public static DetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDetailFragmentLoaded(GnomeToPrint gnomeToPrint) {

        setData(gnomeToPrint);

    }


    private void setData(GnomeToPrint gnomeToPrint){


        loadImage(getContext(), gnomeToPrint.getThumbnail(), imageView);

        ageTextView.setText(gnomeToPrint.getAge());
        nameTextView.setText(gnomeToPrint.getName());
        weightTextView.setText(gnomeToPrint.getWeight());
        heightTextView.setText(gnomeToPrint.getHeight());
        hairTextView.setText(gnomeToPrint.getHairColor());

        tabHost.setup();

        Resources res = getResources();



        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_assignment_ind_black_24dp));

        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_group_black_24dp));
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_work_black_24dp));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);


        int[] toViews = {android.R.id.text1};
        String[] fromColumns = gnomeToPrint.getProfessions().toArray(new String[0]);


        professionsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,fromColumns);

        professionListView.setAdapter(professionsAdapter);


        String[] fromFriendsColumns = gnomeToPrint.getFriends().toArray(new String[0]);


        friendsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,fromFriendsColumns);

        friendsListview.setAdapter(friendsAdapter);




    }


    private void loadImage(Context context, String thumbnail, ImageView imageView){

        Images.loadImage(context, thumbnail, imageView);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_detail_constraint;
    }

    @Override
    protected void setView() {

        Bundle bundle = getArguments();

        int idGnomeToShow = bundle.getInt("idGnome");
        detailFragmentPresenter.getGnomeDetail(idGnomeToShow);
    }

    @Override
    protected int getMenuResource() {
        return 0;
    }

    @Override
    protected void setOptionsMenu(Menu menu) {

    }
}
