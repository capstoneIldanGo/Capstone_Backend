package jungsaesidae.capstone.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.domain.*;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.dto.Post.QLocationDto;
import jungsaesidae.capstone.dto.Post.QPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static jungsaesidae.capstone.domain.QItem.*;
import static jungsaesidae.capstone.domain.QLocation.*;
import static jungsaesidae.capstone.domain.QMarketPrice.*;
import static jungsaesidae.capstone.domain.QPlatform.*;
import static jungsaesidae.capstone.domain.QPost.*;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;
    private JPAQueryFactory queryFactory;
    // what is exactly "final" keyword meaning?

    public List<Post> findAll() {
        queryFactory = new JPAQueryFactory(em);

        List<Post> result = queryFactory
                .selectFrom(post)
                .where(post.isSold.eq(false))
                .fetch();

        return result;
    }

    public PostDto findOne(NumberPath<Long> postId) {
        queryFactory = new JPAQueryFactory(em);

        PostDto result = queryFactory
                .select(new QPostDto(
                        post.id,
                        post.url,
                        post.isSold,
                        post.isSClass,
                        post.uploadDate,
                        new QLocationDto(location.id, location.city, location.state),
                        platform.name,
                        marketPrice.price,
                        item.name
                ))
                .from(post)
                .where(post.id.eq(postId))
                .join(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item)
                .fetchOne();

        return result;
    }

    /**
     * platform, city, state을 조건으로 받아들여 동적쿼리를 작성합니다.
     * @param platformCond
     * @param cityCond
     * @param stateCond
     * @return List<PostDto>
     */

    public List<PostDto> findByCondition(String platformCond, String cityCond, String stateCond, String orderCond) {
        queryFactory = new JPAQueryFactory(em);

        List<PostDto> result = queryFactory
                .select(new QPostDto(
                        post.id,
                        post.url,
                        post.isSold,
                        post.isSClass,
                        post.uploadDate,
                        new QLocationDto(location.id, location.city, location.state),
                        platform.name,
                        marketPrice.price,
                        item.name
                ))
                .from(post)
                .where(platformEq(platformCond), cityEq(cityCond), stateEq(stateCond))
                .orderBy(orderFunc(orderCond))
                .join(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item)
                .fetch();

        return result;
    }


    private BooleanExpression platformEq(String platformCond) {
        return platformCond != null ? post.platform.name.eq(platformCond) : null;
    }

    private BooleanExpression cityEq(String cityCond) {
        return cityCond != null ? post.location.city.eq(cityCond) : null;
    }

    private BooleanExpression stateEq(String stateCond) {
        return stateCond != null ? post.location.state.eq(stateCond) : null;
    }

    /**
     * 정렬하는 method
     * @param orderCond
     * @return OrderSpecifier
     */

    private OrderSpecifier<?> orderFunc(String orderCond) {

        if (orderCond == null)
            return post.id.desc();

        if (orderCond.equals("UPLOADDATE_DESC"))
            return post.uploadDate.desc();
        else if (orderCond.equals("PRICE_DESC"))
            return post.marketPrice.price.desc();
        else
            return post.id.desc();
    }

    private OrderSpecifier<?> priceOrd(String priceCond) {

        if (priceCond == null)
            return post.id.desc();

        if (priceCond.equals("asc"))
            return post.marketPrice.price.asc();
        else if (priceCond.equals("desc"))
            return post.marketPrice.price.desc();
        else
            return post.id.desc();
    }

    private OrderSpecifier<?> uploadDateOrd(String uploadDateCond) {
        if (uploadDateCond == null)
            return post.id.desc();

        if (uploadDateCond.equals("asc"))
            return post.uploadDate.asc();
        else if (uploadDateCond.equals("desc"))
            return post.uploadDate.desc();
        else
            return post.id.desc();
    }

}
