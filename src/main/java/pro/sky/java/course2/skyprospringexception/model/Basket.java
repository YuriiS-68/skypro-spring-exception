package pro.sky.java.course2.skyprospringexception.model;

import java.util.Collection;
import java.util.HashMap;

public class Basket {

    private final HashMap<Integer, Integer> products;

    public Basket() {
        this.products = new HashMap<>();
        System.out.println("Basket is created");
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public Collection<Integer> getNameOfItems(){
        /*if (products == null){
            throw new NullPointerException();
        }*/
        return products.values();
    }
}
