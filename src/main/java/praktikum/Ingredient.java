package praktikum;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {
    //поля класса
    public IngredientType type;
    public String name;
    public float price;

    //конструктор
    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    //объявлен метод, возвращающий цену ингредиента
    public float getPrice() {
        return price;
    }

    //объявлен метод, возвращающий название ингредиента
    public String getName() {
        return name;
    }

    //объявлен метод, возвращающий тип ингредиента
    public IngredientType getType() {
        return type;
    }
}