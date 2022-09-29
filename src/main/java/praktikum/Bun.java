package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    //объявили поля класса
    public String name;
    public float price;
    //объявили конструктор
    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }
    //геттеры
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }

}