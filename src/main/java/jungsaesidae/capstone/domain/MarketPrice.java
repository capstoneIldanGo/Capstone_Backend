package jungsaesidae.capstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class MarketPrice {

    @Id @GeneratedValue
    @Column(name = "market_price_id")
    private Long id;

    private int price;

    // <변경 전>
    @OneToOne(mappedBy = "marketPrice", fetch = FetchType.LAZY)
    private Post post;

//     <변경 후>
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id")
//    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public static MarketPrice createMarketPrice(Item item, Post post, int price) {
        MarketPrice marketPrice = new MarketPrice();
        marketPrice.setItem(item);
        marketPrice.setPost(post);
        marketPrice.setPrice(price);

        return marketPrice;
    }
}
