package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.ItemRepositoryCustom;
import jungsaesidae.capstone.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
}
