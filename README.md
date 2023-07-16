# Stellar Burgers unit-tests

Тестирование учебного сервиса, которая помогает заказать бургер в Stellar Burgers, покрытие её юнит-тестами. 

## Описание

Версия Java 11.

В проекте используется библиотека:

- JUnit 4
- Jacoco
- Mockito

## Запуск автотестов
Для запуска автотеста необходимо:

1. Склонировать репозиторий на свой компьютер с помощью команды:

 ```sh
git clone git@github.com:RimmaRazyapova/stellar-burgers-unit-tests.git
```

2. Для создания отчета в Jacoco ввести команду

```sh   
mvn clean verify
```

## Структура проекта
```bash
pom.xml
README.md
.gitignore
src
|-- main
|   |-- java
|   |   |-- org
|   |   |   |-- example
|   |   |   |   |-- Bun.java
|   |   |   |   |-- Burger.java
|   |   |   |   |-- Database.java
|   |   |   |   |-- Ingredient.java
|   |   |   |   |-- IngredientType.java
|   |   |   |   |-- Praktikum.java
|-- test
|   |-- java
|   |   |-- BunParameterizedUnitTests.java
|   |   |-- BurgerMockUnitTests.java
|   |   |-- IngredientParameterizedUnitTests.java
```

## Выполненные задачи
Написаны тесты для классов `Bun`, `Burger`, `Ingredient`, `IngredientType`, процент которых составляет не менее 85%.
