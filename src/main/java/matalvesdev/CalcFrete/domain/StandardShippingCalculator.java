package matalvesdev.CalcFrete.domain;

import org.springframework.stereotype.Component;

@Component

public class StandardShippingCalculator  implements ShippingCalculator {
    @Override
    public Double calculate(Double weight, Double distance) {
        return weight * 1.0 + distance * 0.5;
    }
}
