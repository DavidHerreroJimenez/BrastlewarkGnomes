package davidherrerojimenez.brastlewarkgnomes.data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

/**
 * Proyect: BrastlewarkGnomes.
 * Package name: davidherrerojimenez.brastlewarkgnomes.data.
 * Created by udhj1a on 07/09/2017 15:43.
 */
public class ApiImplTest {

    ApiImpl api;

    @Mock
    ApiCallFinished apiCallFinished;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        api = new ApiImpl();
    }

    @Test
    public void getDataFromURL() throws Exception{


        api.getData(apiCallFinished);
    }

}