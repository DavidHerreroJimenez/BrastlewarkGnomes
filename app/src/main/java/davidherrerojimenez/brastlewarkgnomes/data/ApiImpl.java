package davidherrerojimenez.brastlewarkgnomes.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;
import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static davidherrerojimenez.brastlewarkgnomes.data.utils.Constants.BASE_URL;
import static davidherrerojimenez.brastlewarkgnomes.data.utils.Constants.OK;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data
 * <p>
 * Created by dherrero on 6/09/17.
 */

public class ApiImpl {

    private List<Brastlewark> brastlewarkGnomishList;


    String message;

    @Inject
    public ApiImpl() {

        brastlewarkGnomishList = new ArrayList<>();

        message = "";
}


    public void getData(final ApiCallFinished apiCallFinished) {




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Gnome> gnomeCall = api.readBrastlewarkGnomes();

        gnomeCall.enqueue(new Callback<Gnome>() {
            @Override
            public void onResponse(Call<Gnome> call, Response<Gnome> response) {

                brastlewarkGnomishList = new ArrayList<>();

                if (response.code() == OK) {
                    brastlewarkGnomishList = response.body().getBrastlewark();
                }

                message = response.message();


                apiCallFinished.onApiCallsFinished(brastlewarkGnomishList,message);


            }

            @Override
            public void onFailure(Call<Gnome> call, Throwable t) {

                message = t.toString();

                brastlewarkGnomishList = new ArrayList<>();

                apiCallFinished.onApiCallsFinished(brastlewarkGnomishList,message);

            }
        });

    }

}
