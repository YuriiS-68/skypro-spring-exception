package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.model.Basket;
import pro.sky.java.course2.skyprospringexception.service.BasketService;

import java.util.List;
import java.util.Map;

@Service
public class BasketServiceImpl implements BasketService {

    private final Basket basket;

    public BasketServiceImpl(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void putItemsInBasket(List<Integer> idOfItems) {
        basket.putItems(idOfItems);
    }

    @Override
    public Map<Integer, Integer> getItems() {
        return basket.getItemsByCount();
    }
}
