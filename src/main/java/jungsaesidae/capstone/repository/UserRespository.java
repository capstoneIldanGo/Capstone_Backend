package jungsaesidae.capstone.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jungsaesidae.capstone.domain.QUser;
import jungsaesidae.capstone.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.Optional;

import static jungsaesidae.capstone.domain.QUser.*;

@Repository
@RequiredArgsConstructor
public class UserRespository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public Optional<User> findOneById(Long userId) {

        Optional<User> result = Optional.ofNullable(queryFactory
                .selectFrom(user)
                .where(user.id.eq(userId))
                .fetchOne());

        return result;
    }
}
