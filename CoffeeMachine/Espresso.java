package machine;

import java.util.HashMap;

public class Espresso implements Coffee{

    int requiredWater = 250;
    int requiredBeans = 16;
    int cost = 4;


    @Override
    public void make(HashMap<String, Integer> ingredients) {
        int waterAvail = ingredients.get("water");
        int beansAvail = ingredients.get("beans");
        int currMoney = ingredients.get("money");
        int currCups = ingredients.get("cups");

        if (requiredWater >= waterAvail) {
            System.out.println("Sorry not enough water");
        } else if (requiredBeans >= beansAvail) {
            System.out.println("Sorry not enough coffee beans");
        } else if (currCups <= 0) {
            System.out.println("Sorry not enough disposable cups");
        } else {
            ingredients.put("water", waterAvail - requiredWater);
            ingredients.put("beans", beansAvail - requiredBeans);
            ingredients.put("money", cost + currMoney);
            ingredients.put("cups", --currCups);
        }
    }
}
