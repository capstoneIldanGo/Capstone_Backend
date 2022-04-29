package jungsaesidae.capstone.repository.Impl;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.dto.Post.QLocationDto;
import jungsaesidae.capstone.dto.Post.QPostDto;
import jungsaesidae.capstone.repository.custom.PostRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static jungsaesidae.capstone.domain.QItem.item;
import static jungsaesidae.capstone.domain.QLocation.location;
import static jungsaesidae.capstone.domain.QMarketPrice.marketPrice;
import static jungsaesidae.capstone.domain.QPlatform.platform;
import static jungsaesidae.capstone.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostDto findOne(NumberPath<Long> postId) {
        PostDto result = queryFactory
                .select(new QPostDto(
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

        List<PostDto> result = queryFactory
                .select(new QPostDto(
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

    /**
     * 검색API (페이지네이션으로 구현)
     * @param platformCond
     * @param cityCond
     * @param stateCond
     * @param orderCond
     * @param pageable
     * @return
     */

    public Page<PostDto> findAllByCondition(String platformCond, String cityCond, String stateCond, String orderCond, Pageable pageable) {

        List<PostDto> content = queryFactory
                .select(new QPostDto(
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
                ))
                .from(post)
                .where(platformEq(platformCond), cityEq(cityCond), stateEq(stateCond))
                .orderBy(orderFunc(orderCond))
                .join(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(post.count())
                .from(post)
                .where(platformEq(platformCond), cityEq(cityCond), stateEq(stateCond))
                .join(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item);

        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchOne());
    }


    /**
     * Condition func
     * @param platformCond
     * @return
     */

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
