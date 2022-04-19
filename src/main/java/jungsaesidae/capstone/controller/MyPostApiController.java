package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.service.MyPostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyPostApiController {

    private final MyPostService myPostService;

    @GetMapping("/myposts/{userId}")
    public List<MyPostDto> mypostByDto(@PathVariable(name = "userId") Long userId) {
        return myPostService.findMyPosts(userId);
    }

    // 내가 지금 고민하고 있는 부분.
    // MyPost를 어떻게 등록할 것인가?

    // 그냥 DB에 insert를 통해, post_id, user_id를 삽입할 것인가?
    // 아님 각각의 post와 user를 find를 통해 찾아 MyPost 객체를 만들고 em.persist() 할 것인가?

    // 일단 둘다 만들어 보자. v1, v2로

    @PostMapping("/myposts/v1")
    public void addmyPostById(@RequestBody CreateMyPostRequest request) {

    }

    @Data // 근데 정확히 @Data가 뭐임?
    private class CreateMyPostRequest {
        private Long userId;
        private Long postId;
    }
}
