package net.devdiaries.wallet;

import net.devdiaries.wallet.domain.Currency;
import net.devdiaries.wallet.domain.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class WalletApplication {

    @Autowired private CurrencyRepository currencyRepository;

    public static void main(String[] args) {

        SpringApplication.run(WalletApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            currencyRepository.save(new Currency("US Dollar", "USD", new BigDecimal(100), new BigDecimal(3.92)));
            currencyRepository.save(new Currency("Euro", "EUR", new BigDecimal(300), new BigDecimal(4.52)));
        };
    }

}
