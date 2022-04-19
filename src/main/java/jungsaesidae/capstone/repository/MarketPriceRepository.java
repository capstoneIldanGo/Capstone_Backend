package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.MarketPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketPriceRepository {

    private final EntityManager em;

    public List<MarketPrice> findAll() {
        return em.createQuery(
                "select mp from MarketPrice mp" +
                        " join fetch mp.item i", MarketPrice.class)
                .getResultList();
    }
}
