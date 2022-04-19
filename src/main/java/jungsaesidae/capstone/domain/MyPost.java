package jungsaesidae.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MyPost {

    @Id @GeneratedValue
    @Column(name = "my_post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //== 연관관계 메소드 ==//

    public static MyPost createMyPost(Post post, User user) {
        MyPost myPost = new MyPost();
        myPost.setPost(post);
        myPost.setUser(user);

        return myPost;
    }
}
