package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    public void setBuns(Bun bun) {
        this.bun = bun;
    }
    //добавляем ингредиенты к списку ингредиентов
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    //убрать ингредиент по его индексу
    public void removeIngredient(int index) {
        ingredients.remove(index);
    }
    //изменить индекс ингредиента на новый, а старый удалить
    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    // получить сумму цен булочек и составляющих ингредиентов
    public float getPrice() {
        // в price записали цену булочки и умножили цену на 2
        float price = bun.getPrice() * 2;
        // для каждого ингредиента из списка ингредиентов берем цену и прабавляем к price
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        //возвращаем стоимость
        return price;
    }

    // получить состав бургера
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getPrice()));

        return receipt.toString();
    }
}