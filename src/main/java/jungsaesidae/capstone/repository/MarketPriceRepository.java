package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.MarketPriceRepositoryCustom;
import jungsaesidae.capstone.domain.MarketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long>, MarketPriceRepositoryCustom {

    @Query(value = "select b.yyyymmdd, IFNULL(a.avg_price, 0) as avg\n" +
            "from \n" +
            "(\n" +
            "select date_format(upload_date, '%Y-%m-%d')as yyyymmdd, round(Avg(marketpric0_.price)) AS avg_price\n" +
            "from dev.market_price marketpric0_ \n" +
            "INNER JOIN dev.post post1_ ON marketpric0_.market_price_id = post1_.market_price_id\n" +
            "INNER JOIN dev.item item2_ ON marketpric0_.item_id = item2_.item_id\n" +
            "where marketpric0_.item_id = :itemId \n" +
            "\tand (upload_date between date_format(date_sub(now(), interval 13 day), '%Y-%m-%d') and date_format(date_add(now(), interval 1 day), '%Y-%m-%d'))\n" +
            "group by date_format(upload_date, '%Y-%m-%d')  \n" +
            ") a  \n" +
            "right join  \n" +
            "(\n" +
            "select  @N \\:= @N +1 AS n ,  \n" +
            "date_format( date_add(date_format(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d') , interval @N -1 day),'%Y-%m-%d') as yyyymmdd  \n" +
            "from (dev.post), (select @N \\:= 0 from dev.post ) a  \n" +
            "limit 14\n" +
            ") b on a.yyyymmdd = b.yyyymmdd \n" +
            "order by b.yyyymmdd asc\n"
            , nativeQuery = true)
    public List<Object[]> findRecentAvgById(@Param(value = "itemId") Long itemId);


//    @Query(value = "SELECT round(Avg(marketpric0_.price)) AS avg_price, DATE_FORMAT(upload_date, '%Y-%m-%d') as date" +
//            " FROM   dev.market_price marketpric0_" +
//            " INNER JOIN dev.post post1_" +
//            " ON marketpric0_.market_price_id = post1_.market_price_id" +
//            " INNER JOIN dev.item item2_" +
//            " ON marketpric0_.item_id = item2_.item_id" +
//            " WHERE  marketpric0_.item_id = :itemId" +
//            " GROUP BY date_format(post1_.upload_date, '%Y-%m-%d')" +
//            " ORDER BY post1_.upload_date DESC" +
//            " LIMIT 14", nativeQuery = true)
//    public List<Object[]> findRecentAvgById(@Param(value = "itemId") Long itemId);

}
