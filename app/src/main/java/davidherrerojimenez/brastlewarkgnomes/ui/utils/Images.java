package davidherrerojimenez.brastlewarkgnomes.ui.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.utils
 * <p>
 * Created by dherrero on 9/09/17.
 */

public class Images {

    public static void loadImage(Context context, String thumbnail, ImageView imageView){


        Picasso.get()
                //.load(thumbnail)
                .load("https://i.imgur.com/DvpvklR.png")
                .fit()
                .centerInside()
                .into(imageView);

    }


}
