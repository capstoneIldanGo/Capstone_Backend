package jungsaesidae.capstone.controller;

import com.querydsl.core.Tuple;
import jungsaesidae.capstone.dto.MarketPrice.AvgDto;
import jungsaesidae.capstone.service.MarketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MarketPriceApiController {

    private final MarketPriceService marketPriceService;

    @GetMapping("/marketprice_v0")
    public Double getAvgPrice(
            @RequestParam(value = "keyword") String keyword,
            @RequestParam(value = "date") String date
    ) {
        return marketPriceService.findAvgById(keyword, date);
    }
    @GetMapping("/marketprice")
    public List<AvgDto> getRecentAvgPrice(
            @RequestParam(value = "keyword") String keyword
    ) {
        return marketPriceService.findRecentAvgById(keyword);
    }
}
