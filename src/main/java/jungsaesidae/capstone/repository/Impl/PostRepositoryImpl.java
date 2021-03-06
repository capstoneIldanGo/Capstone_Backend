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

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static jungsaesidae.capstone.domain.QItem.item;
import static jungsaesidae.capstone.domain.QLocation.location;
import static jungsaesidae.capstone.domain.QMarketPrice.marketPrice;
import static jungsaesidae.capstone.domain.QPlatform.platform;
import static jungsaesidae.capstone.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Optional<PostDto> findOne(Long postId) {
        Optional<PostDto> result = Optional.ofNullable(
                queryFactory
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
                    .leftJoin(post.location, location)
                    .leftJoin(post.platform, platform)
                    .leftJoin(post.marketPrice, marketPrice)
                    .leftJoin(post.item, item)
                    .fetchOne()
        );

        return result;
    }

    /**
     * ??????API (???????????????????????? ??????)
     * @param platformCond
     * @param cityCond
     * @param stateCond
     * @param orderCond
     * @param pageable
     * @return
     */

    public Page<PostDto> findAllByCondition(Long itemId, List<String> platformCond,  String cityCond, String stateCond, boolean isMint, boolean isSold, String orderCond, Pageable pageable) {

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
                .where(post.item.id.eq(itemId))
                .where(platformEq(platformCond), cityEq(cityCond), stateEq(stateCond), isMintEq(isMint), isSoldEq(isSold))
                .orderBy(orderFunc(orderCond))
                .leftJoin(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        SimpleDateFormat format3 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        System.out.println("time_3 = " + format3.format (System.currentTimeMillis()));

        JPAQuery<Long> countQuery = queryFactory
                .select(post.count())
                .from(post)
                .where(post.item.id.eq(itemId))
                .where(platformEq(platformCond), cityEq(cityCond), stateEq(stateCond), isMintEq(isMint), isSoldEq(isSold))
                .leftJoin(post.location, location)
                .join(post.platform, platform)
                .join(post.marketPrice, marketPrice)
                .join(post.item, item);

        System.out.println("time_4 = " + format3.format (System.currentTimeMillis()));

        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchOne());
    }

    /**
     * Condition func
     * @param
     * @return
     */

    private BooleanExpression itemIdEq(Long itemId) {
        return itemId != null ? post.item.id.eq(itemId) : null;
    }

    private BooleanExpression platformEq(List<String> platformCond) {
        return platformCond != null ? post.platform.name.in(platformCond) : null;
    }

    private BooleanExpression cityEq(String cityCond) {
        return cityCond != null ? post.location.city.eq(cityCond) : null;
    }

    private BooleanExpression stateEq(String stateCond) {
        return stateCond != null ? post.location.state.eq(stateCond) : null;
    }

    private BooleanExpression isMintEq(boolean isMint) {
//        return post.isMint.eq(isMint);
        return isMint == true ? post.isMint.eq(true) : null;
    }

    private BooleanExpression isSoldEq(boolean isSold) {
        return isSold == false ? post.isSold.eq(false) : null;
    }

//    private BooleanExpression isSoldEq(boolean isSold) {
//        return isSold == null ? (isSold == True post.isSold.eq(true)) : null;
//    }

    /**
     * ???????????? method
     * @param orderCond
     * @return OrderSpecifier
     */

    private OrderSpecifier<?> orderFunc(String orderCond) {

        if (orderCond == null)
            return post.id.desc();

        if (orderCond.equals("UPLOADDATE_DESC"))
            return post.uploadDate.desc();
        else if (orderCond.equals("UPLOADDATE_ASC"))
            return post.uploadDate.asc();
        else if (orderCond.equals("PRICE_DESC"))
            return post.marketPrice.price.desc();
        else if (orderCond.equals("PRICE_ASC"))
            return post.marketPrice.price.asc();
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
