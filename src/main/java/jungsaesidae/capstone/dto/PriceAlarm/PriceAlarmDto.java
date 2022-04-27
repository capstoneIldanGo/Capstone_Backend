package jungsaesidae.capstone.dto.PriceAlarm;

import com.querydsl.core.annotations.QueryProjection;
import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.dto.MyPost.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceAlarmDto {

    private Long priceAlarmId;
    private int targetPrice;

    private Long userId;
    private String userName;

    private Long itemId;
    private String itemName;

    @QueryProjection
    public PriceAlarmDto(Long priceAlarmId, int targetPrice, Long userId, String userName, Long itemId, String itemName) {
        this.priceAlarmId = priceAlarmId;
        this.targetPrice = targetPrice;
        this.userId = userId;
        this.userName = userName;
        this.itemId = itemId;
        this.itemName = itemName;
    }
}
