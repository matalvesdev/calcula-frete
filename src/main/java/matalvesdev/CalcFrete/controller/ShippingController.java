package matalvesdev.CalcFrete.controller;


import matalvesdev.CalcFrete.controller.dto.ShippingResponse;
import matalvesdev.CalcFrete.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class ShippingController {


    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    @GetMapping(value = "/shipping/calculate")
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("weight") Double weight,
                                                      @RequestParam("distance") Double distance) {

       var cost = shippingService.calculate(shippingType, weight, distance);

        return ResponseEntity.ok(new ShippingResponse(cost));
    }



}
