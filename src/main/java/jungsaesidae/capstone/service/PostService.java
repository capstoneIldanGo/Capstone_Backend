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

import java.text.SimpleDateFormat;
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

    public Page<PostDto> findAllByCondition(String keyword, List<String> platformCond, String cityCond, String stateCond, boolean isMint, boolean isSold, String orderCond, Pageable pageable) {

        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        System.out.println("time_1 = " + format1.format (System.currentTimeMillis()));

        Item item = itemService.findByKeyword(keyword).orElseThrow();
        System.out.println("itemId = " + item.getId());

        System.out.println("time_2 = " + format1.format (System.currentTimeMillis()));

        return postRepository.findAllByCondition(item.getId(), platformCond, cityCond, stateCond, isMint, isSold, orderCond, pageable);
    }
}

