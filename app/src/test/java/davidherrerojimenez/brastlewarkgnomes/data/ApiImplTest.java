package davidherrerojimenez.brastlewarkgnomes.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.data.
 * Created by udhj1a on 07/09/2017 15:43.
 */
public class ApiImplTest {

    ApiImpl api;

    @Before
    public void setUp() throws Exception {
        api = new ApiImpl();
    }

    @Test
    public void getDataFromURL() throws Exception{

        api.getData();
    }

}