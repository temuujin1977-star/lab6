package edu.cmu.cs.cs214.rec04;
 
public class InheritanceSortedIntList extends SortedIntList {
 
    private int totalAdded;
 
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }
 
    
    @Override
    public boolean add(int value) {
        boolean result = super.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }
 

    @Override
    public boolean addAll(IntegerList list) {
        return super.addAll(list);
    }
 
    public int getTotalAdded() {
        return totalAdded;
    }
}