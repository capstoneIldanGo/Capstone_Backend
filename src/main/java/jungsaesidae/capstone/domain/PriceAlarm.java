package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class PriceAlarm {

    @Id @GeneratedValue
    @Column(name = "price_alarm_id")
    private Long id;

    private int targetPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    public static PriceAlarm createPriceAlarm(User user, Item item, int targetPrice) {

        PriceAlarm priceAlarm = new PriceAlarm();
        priceAlarm.setUser(user);
        priceAlarm.setItem(item);
        priceAlarm.setTargetPrice(targetPrice);

        return priceAlarm;
    }
}
