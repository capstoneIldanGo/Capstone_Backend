package jungsaesidae.capstone.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.repository.custom.PriceAlarmRepositoryCustom;
import jungsaesidae.capstone.dto.PriceAlarm.PriceAlarmDto;
import jungsaesidae.capstone.dto.PriceAlarm.QPriceAlarmDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static jungsaesidae.capstone.domain.QItem.*;
import static jungsaesidae.capstone.domain.QPriceAlarm.*;
import static jungsaesidae.capstone.domain.QUser.*;

@RequiredArgsConstructor
public class PriceAlarmRepositoryImpl implements PriceAlarmRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PriceAlarmDto> searchByUserId(Long userId) {
        return jpaQueryFactory
                .select(new QPriceAlarmDto(
                        priceAlarm.id,
                        priceAlarm.targetPrice,
                        priceAlarm.user.id,
                        priceAlarm.user.name,
                        priceAlarm.item.id,
                        priceAlarm.item.name
                ))
                .from(priceAlarm)
                .where(priceAlarm.user.id.eq(userId))
                .join(priceAlarm.user, user)
                .join(priceAlarm.item, item)
                .fetch();
    }
}
