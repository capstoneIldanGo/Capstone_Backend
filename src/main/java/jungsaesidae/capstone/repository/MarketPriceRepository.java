package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.MarketPriceRepositoryCustom;
import jungsaesidae.capstone.domain.MarketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long>, MarketPriceRepositoryCustom {



}
