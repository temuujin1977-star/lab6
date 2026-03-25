package edu.cmu.cs.cs214.rec04;

public class InheritanceSortedIntList extends SortedIntList {

    private int totalAdded = 0;

    @Override
    public boolean add(int value) {
        totalAdded++;
        return super.add(value);
    }

    @Override
    public boolean addAll(IntegerList list) {
        // ✅ Зөв: нэмэгдэх тоог totalAdded-д нэмэх
        totalAdded += list.size();
        return super.addAll(list);
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
