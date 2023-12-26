package presenter;

import file_system.enums.StatusFileFS;
import model.service.Service;

public class Presenter {
    Service service;

    public Presenter(){
        service = new Service();
    }
    public void addNewItem(int count, int chance, String name){
        service.addNewItem(count, chance, name);
    }
    public void editChanceItem(int index, int chance){
        service.editChanceItem(index, chance);
    }
    public void getListItemsInfo(){
        service.getListItemsInfo();
    }
    public void removeItemFromList(int index){
        service.removeItemFromList(index);
    }
    public boolean startLottery(int index){
        return service.startLottery(index);
    }
    public String getNameItemByID(int index){
        return service.getNameItemByID(index);
    }
    public StatusFileFS saveToysList(String file_path){
        return service.saveToysList(file_path);
    }
    public StatusFileFS loadToysList(String file_path){
        return service.loadToysList(file_path);
    }
    
}
