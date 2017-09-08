package davidherrerojimenez.brastlewarkgnomes.data;

import java.util.List;

import davidherrerojimenez.brastlewarkgnomes.model.Brastlewark;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data
 * <p>
 * Created by dherrero on 7/09/17.
 */

public interface ApiCallFinished {

    void onApiCallsFinished(List<Brastlewark> brastlewarkList, String messsage);
}
