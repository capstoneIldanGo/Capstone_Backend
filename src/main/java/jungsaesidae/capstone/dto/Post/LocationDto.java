package jungsaesidae.capstone.dto.Post;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDto {

    private Long locationId;
    private String city;
    private String state;

    @QueryProjection
    public LocationDto(Long locationId, String city, String state) {
        this.locationId = locationId;
        this.city = city;
        this.state = state;
    }
}
