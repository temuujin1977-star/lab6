package edu.cmu.cs.cs214.rec04;
 

public class DelegationSortedIntList implements IntegerList {

    private final SortedIntList list;

    private int totalAdded;
 

    public DelegationSortedIntList() {
        this.list = new SortedIntList();
        this.totalAdded = 0;
    }
 
    
    @Override
    public boolean add(int value) {
        boolean result = list.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }
 
    @Override
    public boolean addAll(IntegerList other) {
        boolean changed = false;
        for (int i = 0; i < other.size(); i++) {
            if (this.add(other.get(i))) {
                changed = true;
            }
        }
        return changed;
    }
 
   
    @Override
    public int get(int index) {
        return list.get(index);
    }
 
    @Override
    public boolean remove(int value) {
        return list.remove(value);
    }
 
    @Override
    public boolean removeAll(IntegerList other) {
        return list.removeAll(other);
    }
 
    
    @Override
    public int size() {
        return list.size();
    }
 
    public int getTotalAdded() {
        return totalAdded;
    }
 
  
    @Override
    public String toString() {
        return list.toString();
    }
}