package model;
import java.io.Serializable;

public class Toy implements Serializable{
    private int id;
    private int count;
    private int chance;
    private String name;

    public Toy(int id, int count, int chance, String name) {
        this.id = id;
        this.count = count;
        this.chance = chance;
        this.name = name;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public int getChance() {
        return chance;
    }
    
    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(getId());
        sb.append(", name: ");
        sb.append(getName());
        sb.append(", count: ");
        sb.append(getCount());
        sb.append(", chance: ");
        sb.append(getChance());

        return sb.toString();
    }
}
