package pro.sky.java.course2.skyprospringexception.service;

import java.util.List;
import java.util.Map;

public interface BasketService {

    void putItemsInBasket(List<Integer> idOfItems);
    Map<Integer, Integer> getItems();
}
