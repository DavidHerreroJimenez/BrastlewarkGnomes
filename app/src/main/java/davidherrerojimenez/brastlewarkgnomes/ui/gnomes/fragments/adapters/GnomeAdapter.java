package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;

import static davidherrerojimenez.brastlewarkgnomes.data.utils.Utils.listOfStringsToStringFormatted;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.adapters
 * <p>
 * Created by dherrero on 7/09/17.
 */


public class GnomeAdapter extends RecyclerView.Adapter<GnomeAdapter.ViewHolderAdapterHeroesList> implements View.OnClickListener {

    private Context context;
    private List<Brastlewark> brastlewarkGnomishList;
    private View.OnClickListener listener;


    public GnomeAdapter(Context context, List<Brastlewark> brastlewarkGnomishList) {

        this.context = context;
        this.brastlewarkGnomishList = brastlewarkGnomishList;
    }

    @Override
    public ViewHolderAdapterHeroesList onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_gnome_list, parent, false);

        view.setOnClickListener(this);

        return new ViewHolderAdapterHeroesList(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapterHeroesList holder, int position) {

        holder.tvName.setText(brastlewarkGnomishList.get(position).getName().trim());
        holder.tvDescription.setText(listOfStringsToStringFormatted(brastlewarkGnomishList.get(position).getProfessions()));

        Picasso.with(context)
                .load(brastlewarkGnomishList.get(position).getThumbnail())
                .fit()
                .into(holder.thumbnailImage);

    }

    @Override
    public int getItemCount() {
        return brastlewarkGnomishList.size();
    }

    public void setList(List<Brastlewark> newGnomishList){


        brastlewarkGnomishList.clear();
        brastlewarkGnomishList.addAll(newGnomishList);
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onClick(view);

        }
    }





    public class ViewHolderAdapterHeroesList extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_gnome_list_imageview)
        ImageView thumbnailImage;
        @BindView(R.id.adapter_gnome_list_textview_name)
        TextView tvName;
        @BindView(R.id.adapter_gnome_list_textview_professions)
        TextView tvDescription;

        public ViewHolderAdapterHeroesList(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }


    }
}

