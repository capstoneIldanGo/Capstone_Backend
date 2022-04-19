package jungsaesidae.capstone.dto.Post;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDto {

    private Long postId;
    private String url;
    private boolean isSold;
    private boolean isSClass;
    private LocalDateTime uploadDate;

    private LocationDto location;
    private String platform;
    private int price;
    private String itemName;

    @QueryProjection
    public PostDto(Long postId, String url, boolean isSold, boolean isSClass, LocalDateTime uploadDate,
                   LocationDto location, String platform, int price, String itemName) {
        this.postId = postId;
        this.url = url;
        this.isSold = isSold;
        this.isSClass = isSClass;
        this.uploadDate = uploadDate;
        this.location = location;
        this.platform = platform;
        this.price = price;
        this.itemName = itemName;
    }
}
