package ru.bmstu.yabd.model;

// Объявлен record Order с нужными полями
public record Order(String id, String product, int quantity, double price) {}