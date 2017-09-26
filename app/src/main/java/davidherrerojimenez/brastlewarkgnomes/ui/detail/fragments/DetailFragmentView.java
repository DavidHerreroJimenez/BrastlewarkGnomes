package davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments;

import davidherrerojimenez.brastlewarkgnomes.model.Gnome;
import davidherrerojimenez.brastlewarkgnomes.model.GnomeToPrint;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.detail.fragments
 * <p>
 * Created by dherrero on 8/09/17.
 */

public interface DetailFragmentView {

    void onDetailFragmentLoaded(GnomeToPrint gnomeToPrint);
}
