package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.PriceAlarm;
import jungsaesidae.capstone.dto.PriceAlarm.PriceAlarmDto;
import jungsaesidae.capstone.repository.PriceAlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PriceAlarmService {

    private final PriceAlarmRepository priceAlarmRepository;
    private final UserService userService;
    private final ItemService itemService;

    public Optional<PriceAlarm> findOneById(Long id) {
        return priceAlarmRepository.findById(id);
    }

    public List<PriceAlarmDto> findAllByUserId(Long userId) {
        return priceAlarmRepository.searchByUserId(userId);
    }

    @Transactional
    public Long add(Long userId, Long itemId, int targetPrice) {
        PriceAlarm priceAlarm = PriceAlarm.createPriceAlarm(
                userService.findOneById(userId).orElseThrow(RuntimeException::new),
                itemService.fineOneById(itemId).orElseThrow(RuntimeException::new),
                targetPrice
        );
        return priceAlarmRepository.save(priceAlarm).getId();
    }

    @Transactional
    public void delete(Long userId, Long itemId) {
        priceAlarmRepository.deleteByUserIdAndItemId(userId, itemId);
    }

    @Transactional
    public void delete(Long priceAlarmId) {
        priceAlarmRepository.deleteById(priceAlarmId);
    }

    public boolean existPriceAlarm(Long userId, Long itemId) {
        return priceAlarmRepository.existsPriceAlarmsByUserIdAndItemId(userId, itemId);
    }
}
