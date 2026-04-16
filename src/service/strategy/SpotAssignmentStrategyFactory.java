package service.strategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(){
        return new LinearSpotAssignmentStrategy();
    }
}
