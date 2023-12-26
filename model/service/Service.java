package model.service;

import file_system.FS;
import file_system.OOS;
import file_system.enums.StatusFileFS;
import model.ToyMachine;

public class Service {
    private ToyMachine toyMachine;
    private FS fileOperationsOOS;

    public Service(){
        toyMachine = new ToyMachine();
        fileOperationsOOS = new FS(new OOS());
    }
    public void addNewItem(int count, int chance, String name){
        toyMachine.addNewItem(count, chance, name);
    }
    public void editChanceItem(int index, int chance){
        toyMachine.editChanceItem(index, chance);
    }
    public void getListItemsInfo(){
        toyMachine.getListItemsInfo();
    }
    public void removeItemFromList(int index){
        toyMachine.removeItemFromList(index);
    }
    public boolean startLottery(int index){
        return toyMachine.startLottery(index);
    }
    public String getNameItemByID(int index){
        return toyMachine.getNameItemByID(index);
    }
    public StatusFileFS saveToysList(String file_path){
        if(fileOperationsOOS.Save(toyMachine, file_path) == StatusFileFS.FileSaved)
        {
            System.out.println("Файл со списком игрушек успешно был сохранен");
            return StatusFileFS.FileSaved;
        }
        else
        {
            System.out.println("Произошла ошибка, файл со списком игрушек не был сохранен");
        }
        return StatusFileFS.FileNotSaved;
    }
    public StatusFileFS loadToysList(String file_path){
        if(fileOperationsOOS.IsFileExist(file_path) == true)
        {
            System.out.println("Файл с списком игрушек успешно был загружен");
            toyMachine = (ToyMachine) fileOperationsOOS.Read(file_path);
            return StatusFileFS.FileLoaded;
        }
        else if (fileOperationsOOS.IsFileExist(file_path) == false)
        {
            return StatusFileFS.NoSuchFile;
        }
        return StatusFileFS.NoSuchFile;
    }
}
