package pro.sky.java.course2.skyprospringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.skyprospringexception.service.BasketService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public String helloMessage() {
        return "You can put items in basket";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam(value = "id") ArrayList<Integer> idOfItems){
        basketService.putItemsInBasket(idOfItems);
        return "List added is success";
    }

    @GetMapping("/get")
    public Map<Integer, Integer> getItems(){
        return basketService.getItems();
    }
}
