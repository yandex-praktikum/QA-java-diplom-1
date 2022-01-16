package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургер.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечатать чек с информацией о бургере.
 */
public class Burger {

    public Bun bun; //создаем булку из соседнего класса

    public List<Ingredient> ingredients = new ArrayList<>();  //список-массив ингредиентов

    public void setBuns(Bun bun) {
        this.bun = bun;
    }  //сеттер для булки, зачем?

    public void addIngredient(Ingredient ingredient) {

        ingredients.add(ingredient);
    }  //добавить ингредиент в массив

    public void removeIngredient(int index) {

        ingredients.remove(index);
    }  //удалить ингредиент из массива по индексу

    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }  //передвинуть ингредиент

    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }  //обновление цены с учетом 2-х булок и цены всех ингредиентов

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getPrice()));

        return receipt.toString();
    }  //чек с названием булки и ценой бургер

}