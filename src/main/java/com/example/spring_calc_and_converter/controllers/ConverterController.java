package com.example.spring_calc_and_converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/converter")
    public String converter() {
        return "converter";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("fromCurrency") String fromCurrency,
                          @RequestParam("toCurrency") String toCurrency,
                          @RequestParam("amount") double amount,
                          Model model) {
        double rate = getExchangeRate(fromCurrency, toCurrency);
        double result = amount * rate;

        model.addAttribute("result", result);
        return "convertResult";
    }

    private double getExchangeRate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.85;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 1.18;
        } else {
            return 1;
        }
    }
}
