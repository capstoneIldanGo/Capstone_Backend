package jungsaesidae.capstone.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.domain.QUser;
import jungsaesidae.capstone.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static jungsaesidae.capstone.domain.QUser.*;

@Repository
@RequiredArgsConstructor
public class UserRespository {

    private final EntityManager em;
    private JPAQueryFactory queryFactory;

    public User findOneById(Long userId) {

        queryFactory = new JPAQueryFactory(em);

        User result = queryFactory
                .selectFrom(user)
                .where(user.id.eq(userId))
                .fetchOne();

        return result;
    }
}
