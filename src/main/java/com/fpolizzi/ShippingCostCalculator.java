package com.fpolizzi;

/**
 * Created by fpolizzi on 11.04.26
 */
public class ShippingCostCalculator {

    public double calculate(double weightKg, String region, boolean express) {
        // TODO: implement using TDD
        double base = 0;

        if (weightKg <= 1.0 ) {
            base = 5.00;
        }

        return base;
    }
}
