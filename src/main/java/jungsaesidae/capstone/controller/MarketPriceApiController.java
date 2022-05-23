package jungsaesidae.capstone.controller;

import com.querydsl.core.Tuple;
import jungsaesidae.capstone.service.MarketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MarketPriceApiController {

    private final MarketPriceService marketPriceService;

    @GetMapping("/marketprice")
    public Double getAvgPrice(
            @RequestParam(value = "itemId") Long item_id,
            @RequestParam(value = "date") String date
    ) {
        return marketPriceService.findAvgById(item_id, date);
    }
}
