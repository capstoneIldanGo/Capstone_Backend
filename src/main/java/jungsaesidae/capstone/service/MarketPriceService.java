package jungsaesidae.capstone.service;

import com.querydsl.core.Tuple;
import jungsaesidae.capstone.repository.MarketPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class MarketPriceService {

    private final MarketPriceRepository marketPriceRepository;

    public Double findAvgById(Long item_id, String date) {

        return marketPriceRepository.findAvgById(item_id, date);
    }
}
