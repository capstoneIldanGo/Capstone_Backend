package jungsaesidae.capstone.repository.custom;

import com.querydsl.core.Tuple;

import java.time.LocalDateTime;

public interface MarketPriceRepositoryCustom {

    public Double findAvgById(Long item_id, String date);
}
