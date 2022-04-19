package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.repository.MyPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyPostService {

    private final MyPostRepository myPostRepository;


    public List<MyPostDto> findMyPosts(Long userId) {
        return myPostRepository.findAll_v1(userId);
    }

    public void addMyPosts() {


    }
}
