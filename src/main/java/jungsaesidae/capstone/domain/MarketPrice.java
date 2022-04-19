package jungsaesidae.capstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class MarketPrice {

    @Id @GeneratedValue
    @Column(name = "marker_price_id")
    private Long id;

    private int price;

    @OneToOne(mappedBy = "marketPrice", fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public static MarketPrice createMarketPrice(Item item, int price) {
        MarketPrice marketPrice = new MarketPrice();
        marketPrice.setItem(item);
        marketPrice.setPrice(price);

        return marketPrice;
    }
}
