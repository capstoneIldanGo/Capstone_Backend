package jungsaesidae.capstone.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.dto.MyPost.QMyPostDto;
import jungsaesidae.capstone.dto.Post.QLocationDto;
import jungsaesidae.capstone.dto.Post.QPostDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static jungsaesidae.capstone.domain.QItem.item;
import static jungsaesidae.capstone.domain.QLocation.location;
import static jungsaesidae.capstone.domain.QMarketPrice.marketPrice;
import static jungsaesidae.capstone.domain.QMyPost.myPost;
import static jungsaesidae.capstone.domain.QPlatform.platform;
import static jungsaesidae.capstone.domain.QPost.post;

@RequiredArgsConstructor
public class MyPostRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    /**
     * MyPost 조회 기능
     * @param userId
     * @return
     */

    public List<MyPostDto> findByUserId(Long userId) {

        List<MyPostDto> result = queryFactory
                .select(new QMyPostDto(
                        myPost.id,
                        new QPostDto(
                                post.id,
                                post.url,
                                post.isSold,
                                post.isMint,
                                post.uploadDate,
                                new QLocationDto(location.id, location.city, location.state),
                                platform.name,
                                marketPrice.price,
                                item.name,
                                post.title,
                                post.productImage
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

}
