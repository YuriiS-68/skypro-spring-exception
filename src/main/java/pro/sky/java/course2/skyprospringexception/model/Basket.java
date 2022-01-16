package pro.sky.java.course2.skyprospringexception.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Basket {

    private final HashMap<Integer, Integer> itemsByCount;


    public Basket() {
        this.itemsByCount = new HashMap<>();
        System.out.println("Basket for items is created");
    }

    public HashMap<Integer, Integer> getItemsByCount() {
        return itemsByCount;
    }

    public Collection<Integer> getNameOfItems(){
        return itemsByCount.values();
    }

    public void putItems(List<Integer> idOfItems){
        ArrayList<Integer> items = new ArrayList<>(getNameOfItems());
        for (Integer idItem : idOfItems){
            if (getItemsByCount().containsKey(idItem)){
                getItemsByCount().put(idItem, items.get(idItem) + 1);
            } else {
                getItemsByCount().put(idItem, 1);
            }
        }
    }
}
