package jungsaesidae.capstone.dto.Request;

import lombok.Data;

@Data
public class PriceAlarmRequest {
    private Long userId;
    private Long itemId;
    private int targetPrice;
}
