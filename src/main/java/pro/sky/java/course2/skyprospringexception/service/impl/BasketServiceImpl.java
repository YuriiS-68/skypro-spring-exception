package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.model.Basket;
import pro.sky.java.course2.skyprospringexception.service.BasketService;

import java.util.ArrayList;
import java.util.Map;

@Service
public class BasketServiceImpl implements BasketService {

    private final Basket basket;

    public BasketServiceImpl(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void putItemsInBasket(ArrayList<Integer> idOfItems) {
        ArrayList<Integer> items = new ArrayList<>(basket.getNameOfItems());

        for (Integer idItem : idOfItems){
            if (basket.getProducts().containsKey(idItem)){
                basket.getProducts().put(idItem, items.get(idItem) + 1);
            } else {
                basket.getProducts().put(idItem, 1);
            }
        }
    }

    @Override
    public Map<Integer, Integer> getItems() {
        return basket.getProducts();
    }
}
