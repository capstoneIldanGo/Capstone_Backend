package jungsaesidae.capstone.service;


import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.dto.MarketPrice.AvgDto;
import jungsaesidae.capstone.repository.MarketPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class MarketPriceService {

    private final MarketPriceRepository marketPriceRepository;
    private final ItemService itemService;

    public Double findAvgById(String keyword, String date) {
        Item item = itemService.findByKeyword(keyword).orElseThrow();
        System.out.println("item.getId() = " + item.getId());

        return marketPriceRepository.findAvgById(item.getId(), date);
    }

    public List<AvgDto> findRecentAvgById(String keyword) {
        Item item = itemService.findByKeyword(keyword).orElseThrow();
        System.out.println("item.getId() = " + item.getId());

        List<Object[]> collects = marketPriceRepository.findRecentAvgById(item.getId());



        List<AvgDto> result = collects.stream()
                .map(objects -> new AvgDto(objects))
                .collect(toList());

//            System.out.println("objects[0] = " + objects[0]);
//            System.out.println("objects[1] = " + objects[1]);
//            for (Object obj : objects) {
//                System.out.println("obj = " + obj);

        return result;
    }
}
