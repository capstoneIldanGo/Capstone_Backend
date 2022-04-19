package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<PostDto> findAllByDto(String platformCond, String cityCond, String stateCond, String orderCond) {
        return postRepository.findByCondition(platformCond, cityCond, stateCond, orderCond);
    }
}
