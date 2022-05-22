package jungsaesidae.capstone.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Column(columnDefinition = "LONGTEXT")
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String productImage;

    private Long pid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @OneToMany(mappedBy = "post")
    private List<MyPost> myPost = new ArrayList<>();

    // <변경 후>
    @OneToOne(mappedBy = "post")
    private MarketPrice marketPrice;

    // <변경 전>
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "market_price_id")
//    private MarketPrice marketPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //== 연관관계 메소드 ==//
    // 일단은 모두 양방향

    public static Post createPost(Location location, Platform platform, Item item,
                                  String url, boolean isSold, boolean isMint, LocalDateTime uploadDate, String title, String productImage) {
        Post post = new Post();
        post.setLocation(location);
        post.setPlatform(platform);
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
