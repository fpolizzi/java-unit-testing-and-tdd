package com.fpolizzi;

/**
 * Created by fpolizzi on 11.04.26
 */
public class ShippingCostCalculator {

    public double calculate(double weightKg, String region, boolean express) {
        // TODO: implement using TDD
        double base;

        if (weightKg <= 1.0 ) {
            base = 5.00;
        } else if (weightKg <= 5) {
            base = region.equalsIgnoreCase("Local") ? 10.00 : 20.00;
        } else {
            base = region.equalsIgnoreCase("Local") ? 15.00 : 30.00;
        }

        return express ? base + 15.00 : base;
    }
}
