package model.service;

import model.ToyMachine;

public class Service {
    private ToyMachine toyMachine;

    public Service(){
        toyMachine = new ToyMachine();
    }
    public void addNewItem(){
        toyMachine.addNewItem(0, 0, null);
    }
    public void editChance(){
        
    }
    public void editChanceItem(){
        
    }
    public void getListItemsInfo(){

    }
    public void removeItemFromList(){
        
    }
}
