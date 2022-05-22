package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.ItemRepositoryCustom;
import jungsaesidae.capstone.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {

    Optional<Item> findByName(String name);
}
