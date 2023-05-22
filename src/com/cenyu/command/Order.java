package com.cenyu.command;

import java.util.*;

public class Order {

    private Integer dinningTable;
    private Map<String, Integer> foodDic = new HashMap<>();

    public Integer getDinningTable() {
        return dinningTable;
    }

    public void setDinningTable(Integer dinningTable) {
        this.dinningTable = dinningTable;
    }

    public Map<String, Integer> getFoodDic() {
        return foodDic;
    }

    public void setFood(String name, Integer num) {
        foodDic.put(name, num);
    }
}

class Chef {

    public void makeFood(String name, Integer num) {
        System.out.println("    start making " + num + " servings of " + name);
    }
}

interface Command {

    void execute();
}

class OrderCommand implements Command {

    private Chef receiver;
    private Order order;

    public OrderCommand(Chef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Table: " + order.getDinningTable() + " order");
        Map<String, Integer> foodDic = order.getFoodDic();
        Set<String> keys = foodDic.keySet();
        for (String foodName : keys) {
            receiver.makeFood(foodName, foodDic.get(foodName));
        }
        System.out.println(order.getDinningTable() + " is ready\n");
    }
}

class Waiter {

    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        commands.add(command);
    }

    public void sendOrderToChef() {
        for (Command command : commands) {
            if(command != null) {
                command.execute();
            }
        }
    }
}

class Demo {

    public static void main(String[] args) {
        Order order1 = new Order();
        order1.setDinningTable(1);
        order1.setFood("pizza", 1);
        order1.setFood("beef", 2);

        Order order2 = new Order();
        order2.setDinningTable(2);
        order2.setFood("hamburger", 2);
        order2.setFood("fries", 3);

        Chef receiver = new Chef();

        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        Waiter waiter = new Waiter();
        waiter.setCommand(cmd1);
        waiter.setCommand(cmd2);
        waiter.sendOrderToChef();
    }
}
