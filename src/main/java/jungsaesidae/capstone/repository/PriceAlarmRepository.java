package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.PriceAlarmRepositoryCustom;
import jungsaesidae.capstone.domain.PriceAlarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceAlarmRepository extends JpaRepository<PriceAlarm, Long>, PriceAlarmRepositoryCustom {

    List<PriceAlarm> findAllByUserId(Long userId);
    void deleteByUserIdAndItemId(Long userId, Long itemId);
    boolean existsPriceAlarmsByUserIdAndItemId(Long userId, Long itemId);

    @Query(value = "update dev.price_alarm _price set target_price = :targetPrice where _price.item_id= :itemId and _price.user_id= :userId", nativeQuery = true)
    public void updatePriceAlarm(
            @Param(value = "userId") Long userId,
            @Param(value = "itemId") Long itemId,
            @Param(value = "targetPrice") Long targetPrice
    );
}
