package davidherrerojimenez.brastlewarkgnomes.data.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import davidherrerojimenez.brastlewarkgnomes.data.utils.Utils;

import static org.junit.Assert.*;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data.utils
 * <p>
 * Created by dherrero on 8/09/17.
 */
public class UtilsTest {

    List<String> fakeListString;
    String fakeResultListStringToStringFormatted;

    Utils utils;


    @Before
    public void setUp() throws Exception {

        fakeListString = new ArrayList<String>();

        fakeListString = Arrays.asList("Metalworker","Woodcarver","Stonecarver"," Tinker","Tailor","Potter");


        fakeResultListStringToStringFormatted = "metalworker, woodcarver, stonecarver, tinker, tailor, potter.";

    }

    @Test
    public void listOfStringsToStringFormatted() throws Exception {


        assertEquals(Utils.listOfStringsToStringFormatted(fakeListString), fakeResultListStringToStringFormatted);

    }

}