package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Optional<Item> fineOneById(Long id) {
        return itemRepository.findById(id);
    }
}
