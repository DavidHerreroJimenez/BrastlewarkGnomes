package davidherrerojimenez.brastlewarkgnomes.ui.gnomes;

import java.util.List;

import davidherrerojimenez.brastlewarkgnomes.model.Gnome;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes
 * <p>
 * Created by dherrero on 7/09/17.
 */

public interface GnomesView {

    void onGnomesLoaded(List<Gnome> gnomes, String message);
}
