package model;
public interface SlotMachineInt {
    void addNewItem(int count, int chance, String name);
    void getListItemsInfo();
    String getNameItemByID(int id);
    void editChanceItem(int index, int new_chance);
    boolean startLottery(int id);
    void removeItemFromList(int index);
}
