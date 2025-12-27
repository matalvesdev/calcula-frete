package matalvesdev.CalcFrete.service;


import matalvesdev.CalcFrete.domain.ExpressShippingCalculator;
import matalvesdev.CalcFrete.domain.StandardShippingCalculator;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {


    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator, ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(String shippingType, Double weight, Double distance) {

        if (shippingType.equalsIgnoreCase("standard")) {

            return standardShippingCalculator.calculate(distance, weight);
        }else {
            if (shippingType.equalsIgnoreCase("express")) {
                return expressShippingCalculator.calculate(distance, weight);
            }
        }
        return 0.0;
    }
}