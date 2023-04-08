package praktikum;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {

    public IngredientType type;
    public String name;
    public float price;

    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        if((name.length() <= 2)
                || (name.length() > 15)
                || name.startsWith(" ")
                || name.endsWith(" ")
        ){
            return null;
        }return name;
    }
    public float getPrice() {
        if (price<0 || price>1000){
            return 0;
        }
        return price;
    }

    public IngredientType getType() {
        return type;
    }
}