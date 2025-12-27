package matalvesdev.CalcFrete.domain;

import org.springframework.stereotype.Component;

@Component

public class ExpressShippingCalculator implements ShippingCalculator{

    @Override
    public Double calculate(Double weight, Double distance) {
        return weight * 1.5 + distance * 0.75;
    }
}
