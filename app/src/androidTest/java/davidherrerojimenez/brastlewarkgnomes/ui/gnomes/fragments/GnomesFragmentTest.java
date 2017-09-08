package davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import davidherrerojimenez.brastlewarkgnomes.R;
import davidherrerojimenez.brastlewarkgnomes.ui.gnomes.GnomesActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.ui.gnomes.fragments.
 * Created by udhj1a on 07/09/2017 16:01.
 */
@RunWith(AndroidJUnit4.class)
public class GnomesFragmentTest {

    String fakeGNomeName;

    @Rule
    public ActivityTestRule<GnomesActivity> gnomesActivityActivityTestRule = new ActivityTestRule<GnomesActivity>(GnomesActivity.class);

    @Before
    public void setUp(){

        fakeGNomeName = "Emmadette";

    }

    @Test
    public void testSearchGnomes() throws Exception{

        onView(withId(R.id.search_filter_gnomes)).perform(click());
    }

}