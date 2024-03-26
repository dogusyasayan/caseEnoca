package com.enoca.util;

import com.enoca.exception.StockNotFoundException;

public class MathUtils {
    public static Double calculateTotalPrice(Double unitPrice, Integer quantity) {
        return unitPrice * quantity;
    }

    public static Integer increaseStock(Integer currentStock, Integer quantity) {
        return currentStock + quantity;
    }

    public static Integer decreaseStock(Integer currentStock, Integer quantity) {
        if (currentStock < quantity) {
            throw new StockNotFoundException();
        }
        return currentStock - quantity;
    }
}
