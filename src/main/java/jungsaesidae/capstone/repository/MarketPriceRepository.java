package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.MarketPrice;
import jungsaesidae.capstone.repository.custom.MarketPriceRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long>, MarketPriceRepositoryCustom {



}
