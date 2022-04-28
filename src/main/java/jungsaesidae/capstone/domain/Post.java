package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String url;
    private boolean isSold;
    private boolean isMint;
    private LocalDateTime uploadDate;
    private String title;
    private String productImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @OneToMany(mappedBy = "post")
    private List<MyPost> myPost = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marker_price_id")
    private MarketPrice marketPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //== 연관관계 메소드 ==//
    // 일단은 모두 양방향

    public static Post createPost(Location location, Platform platform, MarketPrice markerPrice, Item item,
                                  String url, boolean isSold, boolean isMint, LocalDateTime uploadDate, String title, String productImage) {
        Post post = new Post();
        post.setLocation(location);
        post.setPlatform(platform);
        post.setMarketPrice(markerPrice);
        post.setItem(item);
        post.setUrl(url);
        post.setSold(isSold);
        post.setMint(isMint);
        post.setUploadDate(uploadDate);
        post.setTitle(title);
        post.setProductImage(productImage);

        return post;
    }

}
