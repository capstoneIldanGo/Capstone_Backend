package jungsaesidae.capstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<MarketPrice> marketPrice = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Post> post = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<PriceAlarm> priceAlarm = new ArrayList<>();

    private LocalDateTime latestSearchTime;
}
