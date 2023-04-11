package com.jdc.pos.utils;

public enum Menu {
    Home("Главная страница"),
    HomeGuest("Главная страница гостя"),
    HomeEmployee("Главная страница работника"),
    Pos("Корзина"),
    Sales("Добавление пользователя"),
    Category("Управление категориями"),
    Product("Управление товаром");

    private String title;

    Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getFxml() {
        return String.format("%s.fxml", name());
    }
}
