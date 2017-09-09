package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    @BindView(R.id.detail_id_gnome)
    TextView idTextView;

    @BindView(R.id.detail_age_gnome)
    TextView ageTextView;

    @BindView(R.id.detail_name_gnome)
    TextView nameTextView;

    @BindView(R.id.detail_weight_gnome)
    TextView weightTextView;

    @BindView(R.id.detail_height_gnome)
    TextView heightTextView;

    @BindView(R.id.detail_haircolor_gnome)
    TextView hairTextView;

    @BindView(R.id.detail_professions_gnome)
    TextView professionTextView;

    @BindView(R.id.detail_friends_gnome)
    TextView friendsTextView;



    DetailFragmentPresenter detailFragmentPresenter;


    Brastlewark brastlewark;

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
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

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

        idTextView.setText(brastlewark.getId().toString());


        ageTextView.setText(brastlewark.getAge().toString());


        nameTextView.setText(brastlewark.getName());


        weightTextView.setText(brastlewark.getWeight().toString());


        heightTextView.setText(brastlewark.getHeight().toString());


        hairTextView.setText(brastlewark.getHairColor());


        professionTextView.setText(Utils.listOfStringsToStringFormatted(brastlewark.getProfessions()));


        friendsTextView.setText(Utils.listOfStringsToStringFormatted(brastlewark.getFriends()));

    }


    private void loadImage(Context context, String thumbnail, ImageView imageView){

        Images.loadImage(context, thumbnail, imageView);

    }
}
