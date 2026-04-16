package service.strategy;

public class BillCalculationStrategyFactory {

    public static BillCalculationStrategy getBillCalculationStrategy(){
        return new LinearBillCalculationStrategy();
    }
}
