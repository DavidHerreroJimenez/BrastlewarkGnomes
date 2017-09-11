package davidherrerojimenez.brastlewarkgnomes.data;

import davidherrerojimenez.brastlewarkgnomes.model.BrastlewarkGnomes;
import retrofit2.Call;
import retrofit2.http.GET;

import static davidherrerojimenez.brastlewarkgnomes.data.utils.Constants.FINAL_URL;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.data.
 * Created by udhj1a on 07/09/2017 15:12.
 */

public interface ApiRetrofitInterface {
    @GET(FINAL_URL)
    Call<BrastlewarkGnomes> readBrastlewarkGnomes();
}
