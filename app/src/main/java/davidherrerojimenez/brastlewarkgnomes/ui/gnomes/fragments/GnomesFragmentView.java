package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import java.util.List;

import davidherrerojimenez.brastlewarkgnomes.model.Gnome;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments
 * <p>
 * Created by dherrero on 7/09/17.
 */

public interface GnomesFragmentView {

    void onGnomesFragmentLoaded(List<Gnome> gnomeList, String message);
}
