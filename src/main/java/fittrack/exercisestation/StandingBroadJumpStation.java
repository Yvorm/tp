package fittrack.exercisestation;

import fittrack.calculator.StandingBroadJumpCalculator;
import fittrack.user.User;

public class StandingBroadJumpStation extends ExerciseStation {
    private String name = "Standing Broad Jump Station";
    private int distance;

    public StandingBroadJumpStation() {
        this.distance = 0;
        this.points = 0;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void setPerformance(int performanceResult) {
        this.distance = performanceResult;
    }

    @Override
    public int getPoints(User user) {
        points = StandingBroadJumpCalculator.calculatePoints(user.gender, user.age, distance);
        return points;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Integer.toString(distance) + "cm" + " | " + Integer.toString(points);
    }
}