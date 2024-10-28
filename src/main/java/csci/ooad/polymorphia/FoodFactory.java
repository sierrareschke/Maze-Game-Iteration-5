package csci.ooad.polymorphia;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class FoodFactory {
    public static String[] NAMES = new String[]{"cupcake", "apple", "banana", "steak", "salad", "fries", "burger", "pizza", "eggs",
            "bacon", "muffin", "donut", "chicken", "pasta", "rice", "sushi", "taco", "burrito", "nachos", "chips"};

    private static final Random random = new Random();

    public Food create(String name) {
        return new Food(name);
    }

    public List<Food> createNumberOf(Integer numItems) {
        return IntStream.range(0, numItems)
                .mapToObj(i -> new Food(NAMES[i % NAMES.length], random.nextDouble(1,2)))
                .map(Food.class::cast)
                .toList();
    }
}
