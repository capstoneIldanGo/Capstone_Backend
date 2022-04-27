package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.domain.PriceAlarm;
import jungsaesidae.capstone.repository.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
}
