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
        return myPostRepository.findAll_v1(userId);
    }

    @Transactional
    public void addMyPosts(Long userId, Long postId) {

        System.out.println("userId = " + userId);
        System.out.println("postId = " + postId);

        Post post = postService.findOneById(postId);
        System.out.println("post = " + post);

        User user = userService.findOneById(userId);
        System.out.println("user = " + user);

        MyPost myPost = new MyPost();

        myPost.setPost(post);
        myPost.setUser(user);

        myPostRepository.save(myPost);
    }
}
