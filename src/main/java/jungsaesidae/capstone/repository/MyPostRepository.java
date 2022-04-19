package jungsaesidae.capstone.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.domain.QMyPost;
import jungsaesidae.capstone.domain.QPost;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.dto.MyPost.QMyPostDto;
import jungsaesidae.capstone.dto.Post.QLocationDto;
import jungsaesidae.capstone.dto.Post.QPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static jungsaesidae.capstone.domain.QItem.item;
import static jungsaesidae.capstone.domain.QLocation.location;
import static jungsaesidae.capstone.domain.QMarketPrice.marketPrice;
import static jungsaesidae.capstone.domain.QMyPost.*;
import static jungsaesidae.capstone.domain.QPlatform.platform;
import static jungsaesidae.capstone.domain.QPost.*;

@Repository
@RequiredArgsConstructor
public class MyPostRepository {

    private final EntityManager em;
    private JPAQueryFactory queryFactory;
    private final PostRepository postRepository;

    // queryFactory를 어떻게 주입 받을 것인가에 대한 문제 해결하자.


    /**
     * MyPost 조회 기능
     * @param userId
     * @return
     */

    public List<MyPostDto> findAll_v1(Long userId) {
        queryFactory = new JPAQueryFactory(em);

        List<MyPostDto> result = queryFactory
                .select(new QMyPostDto(
                        myPost.id,
                        new QPostDto(
                                post.id,
                                post.url,
                                post.isSold,
                                post.isSClass,
                                post.uploadDate,
                                new QLocationDto(location.id, location.city, location.state),
                                platform.name,
                                marketPrice.price,
                                item.name
                        )
                ))
                .from(myPost)
                .where(myPost.user.id.eq(userId))
                .join(myPost.post, post)
                .join(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item)
                .fetch();

        return result;
    }

    /**
     * MyPost 등록 기능
     */

    public void save(MyPost myPost) {
        em.persist(myPost);
    }

}
