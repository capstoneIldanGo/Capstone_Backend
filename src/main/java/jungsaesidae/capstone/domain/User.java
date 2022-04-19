package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String contact;

    @OneToMany(mappedBy = "user")
    private List<MyPost> myPost = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PriceAlarm> priceAlarm = new ArrayList<>();
}
