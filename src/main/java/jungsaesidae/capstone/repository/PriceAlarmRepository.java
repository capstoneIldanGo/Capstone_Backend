package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.PriceAlarmRepositoryCustom;
import jungsaesidae.capstone.domain.PriceAlarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceAlarmRepository extends JpaRepository<PriceAlarm, Long>, PriceAlarmRepositoryCustom {

    List<PriceAlarm> findAllByUserId(Long userId);
    void deleteByUserIdAndItemId(Long userId, Long itemId);
    boolean existsPriceAlarmsByUserIdAndItemId(Long userId, Long itemId);
}
