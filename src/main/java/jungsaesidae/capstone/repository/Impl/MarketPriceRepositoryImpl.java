package jungsaesidae.capstone.repository.Impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.domain.QItem;
import jungsaesidae.capstone.parser.LocalDateParser;
import jungsaesidae.capstone.repository.custom.MarketPriceRepositoryCustom;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static jungsaesidae.capstone.domain.QItem.*;
import static jungsaesidae.capstone.domain.QMarketPrice.marketPrice;
import static jungsaesidae.capstone.domain.QPost.post;

@RequiredArgsConstructor
public class MarketPriceRepositoryImpl implements MarketPriceRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     *
     * @param item_id
     * @param dateTime
     * @return
     */

    public Double findAvgById(Long item_id, String dateTime) {

        LocalDateParser localDateParser = new LocalDateParser(dateTime);

        Double result = queryFactory
                .select(
                        marketPrice.price.avg()
                )
                .from(marketPrice)
                .join(marketPrice.post, post)
                .join(marketPrice.item, item)
                .where(marketPrice.item.id.eq(item_id)
                        .and(marketPrice.post.uploadDate.between(localDateParser.startDate(), localDateParser.endDate())))
                .fetchOne();

        return result;
    }

//    @Query(value = "select snack_id, name, price from snack where snack_id > :id", nativeQuery = true)
//    public List<Snack> selectSQLById2(@Param(value = "id") int id);


//    public List<Double> findRecentAvgById(Long item_id, String dateTime) {
////
////
////    }
}
