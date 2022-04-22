package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.domain.User;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.repository.MyPostRepository;
import jungsaesidae.capstone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyPostService {

    private final MyPostRepository myPostRepository;
    private final PostService postService;
    private final UserService userService;

    public List<MyPostDto> findMyPosts(Long userId) {
        return myPostRepository.findByUserId(userId);
    }

    @Transactional
    public void addMyPosts(Long userId, Long postId) {

        // "예외 처리에 대한 부분" => Issue 등록

        Post post = postService.findOneById(postId);
        User user = userService.findOneById(userId);

        MyPost myPost = new MyPost();

        myPost.setPost(post);
        myPost.setUser(user);

        myPostRepository.save(myPost);
    }
}
