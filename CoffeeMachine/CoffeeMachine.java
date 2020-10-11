package machine;


import java.util.HashMap;
import java.util.Scanner;

public class CoffeeMachine {

    private HashMap<String, Integer> ingredients = new HashMap<>();

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.ingredients.put("money", 550);
        coffeeMachine.ingredients.put("water", 400);
        coffeeMachine.ingredients.put("milk", 540);
        coffeeMachine.ingredients.put("beans", 120);
        coffeeMachine.ingredients.put("cups", 9);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        while (scanner.hasNext()) {
            String option = scanner.next();
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, " +
                            "2 - latte, 3 - cappuccino:");
                    String coffeeType = scanner.next();
                    switch (coffeeType) {
                        case "1":
                            Espresso espresso = new Espresso();
                            espresso.make(coffeeMachine.ingredients);
                            break;
                        case "2":
                            Latte latte = new Latte();
                            latte.make(coffeeMachine.ingredients);
                            break;
                        case "3":
                            Cappucino cappucino = new Cappucino();
                            cappucino.make(coffeeMachine.ingredients);
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    coffeeMachine.fillCoffeeMachine(scanner);
                    break;
                case "take":
                    System.out.printf("I gave you %s\n\n", coffeeMachine.ingredients.get("money"));
                    coffeeMachine.ingredients.put("money", 0);
                    break;
                case "remaining":
                    coffeeMachine.printIngredients(coffeeMachine.ingredients);
                    break;
                case "exit":
                    System.exit(0);
            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }

    private void printIngredients( HashMap<String,Integer> ingredients) {
        System.out.println("The coffee machine has:");
        System.out.println(String.format("%d of water\n" +
                        "%d of milk\n" +
                "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                "%d of money",
                ingredients.get("water"),
                ingredients.get("milk"),
                ingredients.get("beans"),
                ingredients.get("cups"),
                ingredients.get("money")));
        System.out.println();
    }

    private void fillCoffeeMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        ingredients.put("water", scanner.nextInt() + ingredients.get("water"));

        System.out.println("Write how many ml of milk do you want to add:");
        ingredients.put("milk", scanner.nextInt() + ingredients.get("milk"));

        System.out.println("Write how many grams of coffee beans do you want to add:");
        ingredients.put("beans", scanner.nextInt() + ingredients.get("beans"));

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        ingredients.put("cups", scanner.nextInt() + ingredients.get("cups"));
    }
}
