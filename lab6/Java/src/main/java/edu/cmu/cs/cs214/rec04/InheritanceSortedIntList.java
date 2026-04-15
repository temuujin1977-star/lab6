package edu.cmu.cs.cs214.rec04;
 
/**
 * Даалгавар 1: Удамшлын арга (Inheritance)
 *
 * SortedIntList-ийг extend хийж, нэмэгдсэн нийт элементийн тоог хянадаг.
 * add() болон addAll() аргуудыг override хийж totalAdded-ийг нэмэгдүүлнэ.
 */
public class InheritanceSortedIntList extends SortedIntList {
 
    // Нэмэгдсэн нийт элементийн тоо (устгасан ч буцаж хасагддаггүй)
    private int totalAdded;
 
    /**
     * Шинэ хоосон жагсаалт үүсгэнэ.
     */
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
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
        boolean result = super.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }
 
    /**
     * Өөр жагсаалтын бүх элементийг нэмнэ.
     *
     * АНХААРУУЛГА: AbstractIntList.addAll() нь дотроо add()-г дуудаж хэрэгжүүлдэг.
     * Тиймээс бид add()-г override хийсэн учир addAll()-г override хийхгүй бол
     * totalAdded давхар тооцогдохгүй — зөв ажиллана.
     *
     * Гэхдээ хэрэв SortedIntList нь addAll()-г тусад нь өөрчилсөн бол
     * override хийх шаардлагатай. Тиймд аюулгүйн үүднээс override хийж тавья.
     *
     * @param list нэмэх жагсаалт
     * @return ямар нэг элемент нэмэгдсэн бол true
     */
    @Override
    public boolean addAll(IntegerList list) {
        // super.addAll() нь дотроо манай override хийсэн add()-г дуудна,
        // тиймээс totalAdded автоматаар зөв тооцогдоно.
        return super.addAll(list);
    }
 
    /**
     * Энэ жагсаалт үүсгэгдснээс хойш нэмэхийг оролдсон
     * (амжилттай нэмэгдсэн) элементийн нийт тоог буцаана.
     *
     * @return нийт нэмэгдсэн элементийн тоо
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}