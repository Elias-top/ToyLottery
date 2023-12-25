package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToyMachine implements Serializable, SlotMachineInt{
    private List<Toy> toysList;
    private int id;
    public ToyMachine(){
        toysList = new ArrayList<>();
    }
    public void addNewItem(int count, int chance, String name){  
        for(Toy itemToy : toysList){
            if(itemToy.getName().equals(name)){
                itemToy.setCount(count);
                itemToy.setChance(chance);
                return;
            }
        }
        id += 1; 
        toysList.add(new Toy(id, count, chance, name));
    }

    public void getListItemsInfo(){
        for(Toy itemToy : toysList){
            System.out.println(itemToy);
        }
    }

    public String getNameItemByID(int id){
        for(Toy itemToy : toysList){
            if(itemToy.getId() == id){
                return itemToy.getName();
            }
        }
        return null;
    }

    public void editChanceItem(int index, int new_chance){
        for(Toy itemToy : toysList){
            if(itemToy.getId() == index){
                itemToy.setChance(new_chance);
            }
        }
    }

    public boolean startLottery(int id){
        boolean result_of_lottery = false;

        for(Toy itemToy : toysList){
            if(itemToy.getId() == id){
                result_of_lottery = tryGetToy(itemToy);

                if(result_of_lottery == true){
                    itemToy.setCount(itemToy.getCount() - 1);
                }
            }
        }

        return result_of_lottery;
    }

    public void removeItemFromList(int index){
        for(Toy itemToy : toysList){
            if(itemToy.getId() == index){
                toysList.remove(index - 1);
            }
        }
    }

    private boolean tryGetToy(Toy toy){
        boolean result_of_lottery = ((Math.random() * 100) < toy.getChance())?true:false;
        return result_of_lottery;  
    }
}
