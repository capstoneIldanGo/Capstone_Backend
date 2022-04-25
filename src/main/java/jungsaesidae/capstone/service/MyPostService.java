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
import java.util.Optional;

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
    public Long addMyPosts(Long userId, Long postId) {

        // "예외 처리에 대한 부분" => Issue 등록

        Post post = postService.findOneById(postId).orElseThrow(RuntimeException::new);
        User user = userService.findOneById(userId).orElseThrow(RuntimeException::new);
        // 일단은 RuntimeExceoption으로 예외처리
        // 이후 예외들을 각각 따로 정의하여 refactoring하자.

        MyPost myPost = MyPost.createMyPost(post, user);

        myPostRepository.save(myPost);

        return myPost.getId();
    }

    @Transactional
    public void deleteMyPosts(Long myPostId) {
        myPostRepository.delete(myPostId);
    }

    @Transactional
    public void deleteMyPosts(Long userId, Long postId) {
        myPostRepository.delete(userId, postId);
    }
}
