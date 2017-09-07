package davidherrerojimenez.brastlewarkgnomes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import davidherrerojimenez.brastlewarkgnomes.data.ApiImplTest;
import davidherrerojimenez.brastlewarkgnomes.data.utils.UtilsTest;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.
 * Created by udhj1a on 07/09/2017 15:59.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ApiImplTest.class, UtilsTest.class})
public class GlobalUnitTest {
}
