package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class CheckLatest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private Timestamp Bungae;
    private LocalDateTime Jonggonara;
    private LocalDateTime CarrotMarket;
    private LocalDateTime HelloMarket;

    //== 연관관계 메소드 ==//

    public static CheckLatest createCheckList(Item item, Timestamp bungae, LocalDateTime jonggonara, LocalDateTime carrotMarket, LocalDateTime helloMarket) {
        CheckLatest checkLatest = new CheckLatest();

        checkLatest.setItem(item);
        checkLatest.setBungae(bungae);
        checkLatest.setJonggonara(jonggonara);
        checkLatest.setCarrotMarket(carrotMarket);
        checkLatest.setHelloMarket(helloMarket);

        return checkLatest;
    }

}
