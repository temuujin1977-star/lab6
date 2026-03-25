package edu.cmu.cs.cs214.rec04;

public class DelegationSortedIntList implements IntegerList {

    private SortedIntList list = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int value) {
        totalAdded++;
        return list.add(value);
    }

    @Override
    public boolean addAll(IntegerList items) {
        totalAdded += items.size();
        return list.addAll(items);
    }

    public int getTotalAdded() {
        return totalAdded;
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
    public boolean removeAll(IntegerList items) {
        return list.removeAll(items);
    }

    @Override
    public int size() {
        return list.size();
    }
}