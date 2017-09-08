package davidherrerojimenez.brastlewarkgnomes.data.utils;

import java.util.List;

/**
 * Project name: BrastlewarkGnomes
 * Package name: davidherrerojimenez.brastlewarkgnomes.data.utils
 * <p>
 * Created by dherrero on 8/09/17.
 */

public class Utils {


    public static String listOfStringsToStringFormatted(List<String> list){

        String resultString = "";

        if(list != null && list.size() > 0) {

            String listToString = "";

            for (String stringToAdd : list) {

                if(stringToAdd != null && stringToAdd.trim().length() > 0)
                        listToString += stringToAdd.trim().toLowerCase() + ", ";
            }

            int valueOfLastIndexOfComa = listToString.lastIndexOf(",");

            resultString = listToString.substring(0, valueOfLastIndexOfComa) + ".";

        }

        return resultString.trim();

    }
}
