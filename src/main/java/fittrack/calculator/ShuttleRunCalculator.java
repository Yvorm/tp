package fittrack.calculator;

import fittrack.enums.Gender;
import fittrack.lookupkey.LookUpKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShuttleRunCalculator extends Calculator {
    // A map to store the shuttle run points table, organized by gender and age
    private static final Map<LookUpKey, TreeMap<Integer, Integer>> shuttleRunTable = new HashMap<>();

    // A flag indicating whether the table should be sorted in descending order
    private static final boolean SHOULD_SORT_DESCENDING = false;

    // Static block to initialize the data for both male and female categories
    static {
        initialiseMaleData();
        initialiseFemaleData();
    }

    /**
     * Calculates the points based on gender, age, and shuttle run time (in hundredths of seconds).
     *
     * @param gender The gender of the individual (Male or Female).
     * @param age The age of the individual.
     * @param reps The shuttle run time in hundredths of seconds.
     * @return The points for the given performance.
     */
    public static int calculatePoints(Gender gender, int age, int reps) {
        // Assert that the age is within the valid range
        assert ((age >= AGE_RANGE_LOWER_START) && (age <= AGE_RANGE_UPPER_END));
        // Call the utility method to get the points from the shuttle run table
        return getPointsFromTable(shuttleRunTable, gender, age, reps, !IS_HIGHER_NUMBER_BETTER);
    }

    /**
     * Initializes the male shuttle run data table with age-based performance points.
     */
    private static void initialiseMaleData() {
        // Age data arrays for male (time-to-points mapping in hundredths of seconds)
        int[][][] ageTables = {
                {{103, 5}, {109, 4}, {113, 3}, {117, 2}, {122, 1}}, // Age 12
                {{102, 5}, {107, 4}, {111, 3}, {115, 2}, {119, 1}}, // Age 13
                {{101, 5}, {104, 4}, {108, 3}, {112, 2}, {116, 1}}, // Age 14
                {{101, 5}, {103, 4}, {105, 3}, {109, 2}, {113, 1}}, // Age 15
                {{101, 5}, {103, 4}, {105, 3}, {107, 2}, {111, 1}}, // Age 16
                {{101, 5}, {103, 4}, {105, 3}, {107, 2}, {109, 1}}, // Age 17
                {{101, 5}, {103, 4}, {105, 3}, {107, 2}, {109, 1}}, // Age 18
                {{101, 5}, {103, 4}, {105, 3}, {107, 2}, {109, 1}}, // Age 19
                {{103, 5}, {105, 4}, {107, 3}, {109, 2}, {111, 1}}  // Age 20-24
        };
        // Add the male data to the shuttle run table
        addAllTables(shuttleRunTable, Gender.MALE, ageTables, SHOULD_SORT_DESCENDING);
    }

    /**
     * Initializes the female shuttle run data table with age-based performance points.
     */
    private static void initialiseFemaleData() {
        // Age data arrays for female (time-to-points mapping in hundredths of seconds)
        int[][][] ageTables = {
                {{114, 5}, {119, 4}, {123, 3}, {127, 2}, {132, 1}}, // Age 12
                {{112, 5}, {117, 4}, {122, 3}, {127, 2}, {132, 1}}, // Age 13
                {{114, 5}, {118, 4}, {122, 3}, {126, 2}, {130, 1}}, // Age 14
                {{112, 5}, {116, 4}, {120, 3}, {124, 2}, {128, 1}}, // Age 15
                {{112, 5}, {115, 4}, {118, 3}, {122, 2}, {126, 1}}, // Age 16
                {{112, 5}, {115, 4}, {118, 3}, {121, 2}, {125, 1}}, // Age 17
                {{112, 5}, {115, 4}, {118, 3}, {121, 2}, {124, 1}}, // Age 18
                {{112, 5}, {115, 4}, {118, 3}, {121, 2}, {124, 1}}, // Age 19
                {{115, 5}, {118, 4}, {121, 3}, {124, 2}, {127, 1}} // Age 20-24
        };
        // Add the female data to the shuttle run table
        addAllTables(shuttleRunTable, Gender.FEMALE, ageTables, SHOULD_SORT_DESCENDING);
    }
}
