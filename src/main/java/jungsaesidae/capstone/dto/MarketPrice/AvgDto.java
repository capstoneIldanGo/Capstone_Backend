package jungsaesidae.capstone.dto.MarketPrice;

import com.querydsl.core.Tuple;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvgDto {

    private String date;
    private int avgPrice;

    public AvgDto(Object[] objects) {
        date = objects[0].toString();
        avgPrice = Integer.parseInt(objects[1].toString());
    }
}
