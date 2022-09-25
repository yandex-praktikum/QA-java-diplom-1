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

    //поля класса
    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    //сеттер для булочки
    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    //объявлен метод, добавляющего ингредиент в список
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    //объявлен метод, удаляющего ингредиент из списка
    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    //объявлен метод, позволяющего заменить ингредиент в списке
    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    //объявлен метод, подсчитывающий стоимость бургера
    public float getPrice() {
        //две булки, тк это бургер
        float price = bun.getPrice() * 2;
        //к стоимости булок добавляем стоимость всех ингредиентов
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    //объявлен метод для получения чека
    public String getReceipt() {
        //создан экземпляр класса StringBuilder (параметры конструктора: отформатировать чек и получить имя булки))
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        //в чек добавлена информация: тип ингредиентов, имена ингредиентов
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        //добавить имя булки в чек
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        //добавить стоимость в чек
        receipt.append(String.format("%nPrice: %f%n", getPrice()));
        //возвращает готовый чек
        return receipt.toString();
    }
}