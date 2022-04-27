package jungsaesidae.capstone.repository.custom;

import jungsaesidae.capstone.domain.PriceAlarm;
import jungsaesidae.capstone.dto.PriceAlarm.PriceAlarmDto;

import java.util.List;

public interface PriceAlarmRepositoryCustom {

    List<PriceAlarmDto> searchByUserId(Long userId);
}
