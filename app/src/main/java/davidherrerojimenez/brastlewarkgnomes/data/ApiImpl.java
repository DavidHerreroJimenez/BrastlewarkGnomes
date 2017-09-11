package davidherrerojimenez.brastlewarkgnomes.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.model.BrastlewarkGnomes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static davidherrerojimenez.brastlewarkgnomes.data.utils.Constants.*;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data
 * <p>
 * Created by dherrero on 6/09/17.
 */

public class ApiImpl implements Api {


    private List<Gnome> gnomeGnomishList;


    String message;

    @Inject
    public ApiImpl() {

        gnomeGnomishList = new ArrayList<>();

        message = "";
    }

    @Override
    public void getGnomishListData(ApiCallBack apiCallBack) {

        manageGnomishListCall(getRetrofit(BASE_URL), apiCallBack);
    }

    @Override
    public void loadGnomeData(int idGnomeToShow, ApiCallBack apiCallBack) {

        manageGnomDetailCall(getRetrofit(BASE_URL), apiCallBack, idGnomeToShow);

    }


    private Retrofit getRetrofit(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }

    private void manageGnomishListCall(Retrofit retrofit, final ApiCallBack apiCallBack){

        Call<BrastlewarkGnomes> gnomeCall = (Call<BrastlewarkGnomes>) getRetrofitCall(retrofit);

        gnomeCall.enqueue(getRetrofitCallBack(apiCallBack));
    }

    private void manageGnomDetailCall(Retrofit retrofit, ApiCallBack apiCallBack, int idGnomeToShow){

        Call<BrastlewarkGnomes> gnomeCall = (Call<BrastlewarkGnomes>) getRetrofitCall(retrofit);

        gnomeCall.enqueue(getRetrofitCallBack(apiCallBack, idGnomeToShow));
    }

    private Call<?> getRetrofitCall(Retrofit retrofit) {

        ApiRetrofitInterface apiRetrofitInterface = retrofit.create(ApiRetrofitInterface.class);

        Call<?> call = apiRetrofitInterface.readBrastlewarkGnomes();

        return call;
    }

    private Callback getRetrofitCallBack(final ApiCallBack apiCallBack) {


        Callback callback = new Callback() {

            @Override
            public void onResponse(Call call, Response response) {

                addresponseToOnApiCallBack(response, apiCallBack);


            }

            @Override
            public void onFailure(Call call, Throwable t) {

                addFailureToOnApiCallBack(t, apiCallBack);

            }
        };


        return callback;

    }

    private Callback getRetrofitCallBack(final ApiCallBack apiCallBack, final int idGnomeToShow) {


        Callback callback = new Callback() {

            @Override
            public void onResponse(Call call, Response response) {

                addresponseToOnApiCallBack(response, apiCallBack, idGnomeToShow);


            }

            @Override
            public void onFailure(Call call, Throwable t) {

                addFailureToOnApiCallBack(t, apiCallBack);

            }
        };


        return callback;

    }

    private void addresponseToOnApiCallBack(Response<BrastlewarkGnomes> response, ApiCallBack apiCallBack) {

        apiCallBack.onApiCallBack(getGnomishList(response), getMessageOfGnomeResponse(response));

    }

    private void addresponseToOnApiCallBack(Response<BrastlewarkGnomes> response, ApiCallBack apiCallBack, int idGnome) {

        apiCallBack.onApiCallBack(getGnomeDetail(response, idGnome), getMessageOfGnomeResponse(response));

    }

    private void addFailureToOnApiCallBack(Throwable t, ApiCallBack apiCallBack) {

        apiCallBack.onApiCallBack(new ArrayList<Gnome>(), getMessageOfThrowable(t));

    }


    private List<Gnome> getGnomishList(Response<BrastlewarkGnomes> gnomeResponse) {

        gnomeGnomishList = new ArrayList<>();

        if (gnomeResponse.code() == OK) {
            gnomeGnomishList = gnomeResponse.body().getGnome();
        }

        return gnomeGnomishList;
    }

    private Gnome getGnomeDetail(Response<BrastlewarkGnomes> gnomeResponse, int idGnome){

        Gnome gnome = new Gnome();

        if (gnomeResponse.code() == OK) {
            gnome = gnomeResponse.body().getGnome().get(idGnome);
        }

        return gnome;

    }

    private String getMessageOfGnomeResponse(Response<BrastlewarkGnomes> gnomeResponse) {

        message = gnomeResponse.message();

        return message;

    }

    private String getMessageOfThrowable(Throwable t) {

        message = t.toString();

        return message;
    }


}
