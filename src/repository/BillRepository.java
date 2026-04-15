package repository;

import exception.BillNotFoundException;
import model.Bill;

import java.util.HashMap;

public class BillRepository {
    private HashMap<Integer, Bill> BillMap;
    private static int counter = 1;

    public BillRepository() {
        this.BillMap = new HashMap<>();
    }

    public Bill save(Bill Bill){
        Bill.setId(counter++);
        BillMap.put(Bill.getId(),Bill);
        return BillMap.get(Bill.getId());
    }

    public Bill findById(int BillId){
        if(BillMap.containsKey(BillId)){
            return BillMap.get(BillId);
        }
        else{
            throw new BillNotFoundException("Bill with given id does not exist");
        }
    }

    public Bill update(int BillId, Bill newBill){
        if(BillMap.containsKey(BillId)){
            return BillMap.put(BillId,newBill);
        }
        else{
            throw new BillNotFoundException("Bill with given id does not exist");
        }
    }

    public boolean delete(int BillId){
        if(BillMap.containsKey(BillId)){
            BillMap.remove(BillId);
            return true;
        }
        else{
            throw new BillNotFoundException("Bill with given id does not exist");
        }
    }
}
