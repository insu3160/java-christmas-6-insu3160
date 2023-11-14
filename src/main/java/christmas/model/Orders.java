package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<>();

    public void record(Order order) {
        orders.add(order);
    }

}
