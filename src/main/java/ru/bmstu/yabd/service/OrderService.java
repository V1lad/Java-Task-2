package ru.bmstu.yabd.service;

import org.springframework.stereotype.Service;
import ru.bmstu.yabd.model.Order;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private final Map<String, Order> store = new ConcurrentHashMap<>();

    public Order create(Order order) {
        // TODO 2: Реализуйте создание заказа:
        //   1. Сгенерируйте уникальный id через UUID.randomUUID().toString()
        //   2. Создайте новый Order с этим id и полями из входного order
        //      (используйте order.product(), order.quantity(), order.price())
        //   3. Положите его в store по ключу id
        //   4. Верните сохранённый объект

        String id = UUID.randomUUID().toString();
        Order newOrder = new Order(id, order.product(), order.quantity(), order.price());
        store.put(id, newOrder);
        return newOrder;
    }

    public Order findById(String id) {
        // TODO 3: Верните заказ из store по id
        return store.get(id);
    }

    public Collection<Order> findAll() {
        // TODO 4: Верните все заказы из store
        return store.values();
    }

    public Order update(String id, Order order) {
        // TODO 5: Реализуйте обновление заказа:
        //   1. Создайте новый Order с переданным id и полями из order
        //   2. Замените объект в store
        //   3. Верните обновлённый объект

        Order updatedOrder = new Order(id, order.product(), order.quantity(), order.price());
        store.put(id, updatedOrder);
        return updatedOrder;
    }

    public void delete(String id) {
        // TODO 6: Удалите заказ из store по id
        store.remove(id);
    }

    public Map<String, Object> stats() {
        // TODO 7: Реализуйте статистику:
        //   1. Посчитайте общую сумму всех заказов (price * quantity для каждого)
        //      Подсказка: store.values().stream().mapToDouble(o -> o.price() * o.quantity()).sum()
        //   2. Верните Map с ключами "totalOrders" (количество) и "totalSum" (сумма)
        //      Подсказка: Map.of("totalOrders", ..., "totalSum", ...)

        int totalOrders = store.size();
        double totalSum = store.values().stream().mapToDouble(o -> o.price() * o.quantity()).sum();

        return Map.of(
                "totalOrders", totalOrders,
                "totalSum", totalSum
        );
    }
}
