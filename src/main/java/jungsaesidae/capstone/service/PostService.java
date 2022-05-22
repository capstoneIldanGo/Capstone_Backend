package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.Item;
import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ItemService itemService;

    public Optional<Post> findOneById(Long id) {
        return postRepository.findById(id);
    }

    public Optional<PostDto> findDtoById(Long id) {
        return postRepository.findOne(id);
    }

    public List<PostDto> findAllByDto(String platformCond, String cityCond, String stateCond, String orderCond) {
        return postRepository.findByCondition(platformCond, cityCond, stateCond, orderCond);
    }

    public Page<PostDto> findAllByCondition(String keyword, String platformCond, String cityCond, String stateCond, boolean isMint, String orderCond, Pageable pageable) {
        Item item = itemService.findByKeyword(keyword).orElseThrow();
        Long itemId = item.getId();
        System.out.println("itemId = " + itemId);

        return postRepository.findAllByCondition(itemId, platformCond, cityCond, stateCond, isMint, orderCond, pageable);
    }

}
