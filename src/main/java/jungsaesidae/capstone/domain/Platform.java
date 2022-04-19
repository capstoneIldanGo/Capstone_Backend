package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Platform {

    @Id @GeneratedValue
    @Column(name = "platform_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "platform")
    private List<Post> post = new ArrayList<>();
}

