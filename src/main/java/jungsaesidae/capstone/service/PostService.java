package jungsaesidae.capstone.service;

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

    public Optional<Post> findOneById(Long id) {
        return postRepository.findById(id);
    }

    public List<PostDto> findAllByDto(String platformCond, String cityCond, String stateCond, String orderCond) {
        return postRepository.findByCondition(platformCond, cityCond, stateCond, orderCond);
    }

    public Page<PostDto> findAllByCondition(String platformCond, String cityCond, String stateCond, String orderCond, Pageable pageable) {
        return postRepository.findAllByCondition(platformCond, cityCond, stateCond, orderCond, pageable);
    }

}
