# Diplom_1

В данном проекте используется Jacoco, Mockito, JUnit 4, Allure.


**Тесты**

Класс Bun

    - получение значения поля name методом getName()   
    - получение значения поля price методом getPrice()

Класс Burger

    - задание значения поля bun методом setBuns()  
    - добавление ингридиента методом addIngredient()  
    - удаление ингридиента методом removeIngredient()
    - перемещение ингридиентов методом moveIngredient()
    - получение рецепта бургера методом getReceipt()

    - Параметризованый тест подсчета цены бургера метода getPrice()
      используются моки, для изоляции от классов Bun, Ingredient

Класс Ingredient

    - получение значения поля name методом getName()   
    - получение значения поля price методом getPrice()

    - Параметризованый тест получения значения поля type методом getType()

Класс IngredientType

    - проверка IngredientType SAUCE
    - проверка IngredientType FILLING
