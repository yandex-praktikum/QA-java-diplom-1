Logo
Best-README-Diplom_1

О чем речь:

Здесь выполнена первая часть дипломного проекта курса Yandex.Практикум "Автоматизатор тестирования на Java". Задание 1: юнит-тесты. 
Есть заготовка кода приложения для заказа бургеров, написаны юнит-тесты на классы:
    Bun - для тестирования использовалась параметризация, проверка названия модели булки(name) и цены булки(price).
    Burger - использовались стабы для обелтечения атомарности, перед каждым тестом создается гамбургер с указанными в анотации @Before параметрами и ценой.
    Ingredient - параметризация для проверки правилности работы методов.
    IngredientType - проверяем что ингриденты не пусты.

Технологии:

Java 11
maven 3.9.0
junit 4.13.2
mockito 3.12.4
jacoco 0.8.7
surefire 2.22.2

Getting Started:
Тесты расположены в папке test/java проекта. В проекте есть возможность получить отчет jacoco о покрытии кода тестами

Usage:
Для получения отчета о тестовом поктытии в терминале необходимо выполнить команду

mvn clean test 

Roadmap:
1. Скомпилировать проект.
2. В терминале выполнить команду составкения отчета (mvn clean test).
3. В проводнике перейти в папку проекта и открыть папку сформированного отчета (target\site\jacoco).
4. Открыть в браужере файл отчета index.
 
Contact
Niklay Lepp - https://t.me/Lihodey84 - email@example.com

Project Link: https://github.com/nilepp-hub/Diplom_1
