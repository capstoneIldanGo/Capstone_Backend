package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.domain.MarketPrice;
import jungsaesidae.capstone.repository.MarketPriceRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class testController {

    private final MarketPriceRepository marketPriceRepository;

    @GetMapping("/api/marketprice")
    public List<MarketPrice> marketPrice() {

        List<MarketPrice> all = marketPriceRepository.findAll();

        return all;
    }

    @GetMapping("/api/marketprices")
    public List<MarketPriceDto> marketPrices() {

        List<MarketPrice> all = marketPriceRepository.findAll();

        System.out.println("----------------------");

        List<MarketPriceDto> collect = all.stream()
                .map(o -> new MarketPriceDto(o))
                .collect(Collectors.toList());

        return collect;
    }

    @Data
    static class MarketPriceDto {

        private int price;
        private String item_name;

        public MarketPriceDto(MarketPrice mp) {
            price = mp.getPrice();
            item_name = mp.getItem().getName();
        }
    }
}
