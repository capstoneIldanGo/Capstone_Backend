package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.Item;
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
    public Long add(Long userId, String itemName, int targetPrice) {
        PriceAlarm priceAlarm = PriceAlarm.createPriceAlarm(
                userService.findOneById(userId).orElseThrow(RuntimeException::new),
                itemService.findByKeyword(itemName).orElseThrow(RuntimeException::new),
                targetPrice
        );
        return priceAlarmRepository.save(priceAlarm).getId();
    }

    @Transactional
    public void delete(Long userId, String itemName) {
        Item item = itemService.findByKeyword(itemName).orElseThrow(RuntimeException::new);
        priceAlarmRepository.deleteByUserIdAndItemId(userId, item.getId());
    }

    @Transactional
    public void delete(Long priceAlarmId) {
        priceAlarmRepository.deleteById(priceAlarmId);
    }

    public boolean existPriceAlarm(Long userId, String itemName) {
        Item item = itemService.findByKeyword(itemName).orElseThrow(RuntimeException::new);
        return priceAlarmRepository.existsPriceAlarmsByUserIdAndItemId(userId, item.getId());
    }

    @Transactional
    public void update(Long userId, String itemName, Long targetPrice) {
        Item item = itemService.findByKeyword(itemName).orElseThrow(RuntimeException::new);
        priceAlarmRepository.updatePriceAlarm(userId, item.getId(), targetPrice);
    }
}
