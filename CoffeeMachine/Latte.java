package machine;

import java.util.HashMap;

public class Latte implements Coffee {

    int requiredWater = 350;
    int requiredMilk = 75;
    int requiredBeans = 20;
    int cost = 7;

    @Override
    public void make(HashMap<String, Integer> ingredients) {
        int waterAvail = ingredients.get("water");
        int milkAvail = ingredients.get("milk");
        int beansAvail = ingredients.get("beans");
        int currMoney = ingredients.get("money");
        int currCups = ingredients.get("cups");

        if (requiredWater >= waterAvail) {
            System.out.println("Sorry not enough water");
        } else if (requiredMilk >= milkAvail) {
            System.out.println("Sorry not enough milk");
        } else if (requiredBeans >= beansAvail) {
            System.out.println("Sorry not enough coffee beans");
        } else if (currCups <= 0) {
            System.out.println("Sorry not enough disposable cups");
        } else {
            ingredients.put("water", waterAvail - requiredWater);
            ingredients.put("milk", milkAvail - requiredMilk);
            ingredients.put("beans", beansAvail - requiredBeans);
            ingredients.put("money", cost + currMoney);
            ingredients.put("cups", --currCups);
        }

    }
}
