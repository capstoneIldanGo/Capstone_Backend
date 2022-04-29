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
    private boolean isMint;
    private LocalDateTime uploadDate;

    private LocationDto location;
    private String platform;
    private int price;
    private String itemName;

    private String title;
    private String productImage;

    @QueryProjection
    public PostDto(Long postId, String url, boolean isSold, boolean isMint, LocalDateTime uploadDate, LocationDto location,
                   String platform, int price, String itemName, String title, String productImage) {
        this.postId = postId;
        this.url = url;
        this.isSold = isSold;
        this.isMint = isMint;
        this.uploadDate = uploadDate;
        this.location = location;
        this.platform = platform;
        this.price = price;
        this.itemName = itemName;
        this.title = title;
        this.productImage = productImage;
    }
}
