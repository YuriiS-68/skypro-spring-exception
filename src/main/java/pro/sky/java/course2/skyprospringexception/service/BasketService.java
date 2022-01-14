package pro.sky.java.course2.skyprospringexception.service;

import java.util.ArrayList;
import java.util.Map;

public interface BasketService {

    void putItemsInBasket(ArrayList<Integer> idOfItems);

    Map<Integer, Integer> getItems();
}
