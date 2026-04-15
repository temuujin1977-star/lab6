package edu.cmu.cs.cs214.rec04;
 
/**
 * Даалгавар 2: Бүрдмэл арга (Composition / Delegation)
 *
 * IntegerList интерфейсийг хэрэгжүүлж, дотооддоо SortedIntList объект хадгалдаг.
 * Бүх жагсаалтын үйлдлийг тухайн дотоод объект руу дамжуулна (delegation).
 * add() болон addAll()-г шалгаж totalAdded-ийг нэмэгдүүлнэ.
 */
public class DelegationSortedIntList implements IntegerList {
 
    // Дотоод SortedIntList объект — бүх жагсаалтын үйлдлийг энд дамжуулна
    private final SortedIntList list;
 
    // Нэмэгдсэн нийт элементийн тоо
    private int totalAdded;
 
    /**
     * Шинэ хоосон жагсаалт үүсгэнэ.
     */
    public DelegationSortedIntList() {
        this.list = new SortedIntList();
        this.totalAdded = 0;
    }
 
    /**
     * Жагсаалтад нэг элемент нэмнэ.
     * Амжилттай нэмэгдвэл totalAdded-ийг 1-ээр нэмнэ.
     *
     * @param value нэмэх бүхэл тоо
     * @return амжилттай нэмэгдсэн бол true
     */
    @Override
    public boolean add(int value) {
        boolean result = list.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }
 
    /**
     * Өөр жагсаалтын бүх элементийг нэмнэ.
     *
     * ЧУХАЛ: AbstractIntList.addAll()-ийн баримт бичгийг уншсанаар мэдэх нь:
     * addAll() нь дотроо add()-г дуудаж хэрэгжүүлдэг.
     * Гэхдээ бид list.addAll()-г дуудах үед list объектын add()-г дуудах тул
     * манай add() дуудагдахгүй → totalAdded тооцогдохгүй болно!
     *
     * Тиймд addAll()-г гараар хэрэгжүүлж, бүр элемент тутам манай add()-г дуудна.
     *
     * @param other нэмэх жагсаалт
     * @return ямар нэг элемент нэмэгдсэн бол true
     */
    @Override
    public boolean addAll(IntegerList other) {
        boolean changed = false;
        for (int i = 0; i < other.size(); i++) {
            // Манай add()-г дуудаж totalAdded зөв тооцогдоно
            if (this.add(other.get(i))) {
                changed = true;
            }
        }
        return changed;
    }
 
    /**
     * Тодорхой индексийн элементийг буцаана.
     * Дотоод жагсаалт руу дамжуулна.
     *
     * @param index индекс
     * @return тухайн байрлалын бүхэл тоо
     */
    @Override
    public int get(int index) {
        return list.get(index);
    }
 
    /**
     * Тодорхой утгатай элементийг устгана.
     * Дотоод жагсаалт руу дамжуулна.
     *
     * @param value устгах бүхэл тоо
     * @return олдож устгагдсан бол true
     */
    @Override
    public boolean remove(int value) {
        return list.remove(value);
    }
 
    /**
     * Жагсаалтаас тодорхой жагсаалтын элементүүдийг бүгдийг устгана.
     *
     * @param other устгах элементүүд агуулсан жагсаалт
     * @return ямар нэг элемент устгагдсан бол true
     */
    @Override
    public boolean removeAll(IntegerList other) {
        return list.removeAll(other);
    }
 
    /**
     * Жагсаалтын одоогийн хэмжээг буцаана.
     *
     * @return элементийн тоо
     */
    @Override
    public int size() {
        return list.size();
    }
 
    /**
     * Энэ жагсаалт үүсгэгдснээс хойш амжилттай нэмэгдсэн
     * элементийн нийт тоог буцаана.
     *
     * @return нийт нэмэгдсэн элементийн тоо
     */
    public int getTotalAdded() {
        return totalAdded;
    }
 
    /**
     * Жагсаалтын агуулгыг string хэлбэрт хувиргана.
     */
    @Override
    public String toString() {
        return list.toString();
    }
}