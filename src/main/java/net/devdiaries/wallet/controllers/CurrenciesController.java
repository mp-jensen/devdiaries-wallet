package net.devdiaries.wallet.controllers;

import net.devdiaries.wallet.domain.Currency;
import net.devdiaries.wallet.domain.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrenciesController {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrenciesController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/currencies")
    public Iterable<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    @PostMapping("/currencies")
    void addCurrency(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }

    @PutMapping("/currencies")
    void updateCurrency(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable Long id) {
        currencyRepository.deleteById(id);
    }
}
