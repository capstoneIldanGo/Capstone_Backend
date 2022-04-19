package jungsaesidae.capstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Location {

    @Id @GeneratedValue
    @Column(name = "location_id")
    private Long id;

    private String city;
    private String state;

    @OneToMany(mappedBy = "location")
    private List<Post> post = new ArrayList<>();
}
