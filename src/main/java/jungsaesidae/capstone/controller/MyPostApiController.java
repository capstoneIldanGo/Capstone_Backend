package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.dto.Request.CreateMyPostRequest;
import jungsaesidae.capstone.service.MyPostService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyPostApiController {

    private final MyPostService myPostService;

    @GetMapping("/myposts/{userId}")
    public List<MyPostDto> searchMyPost(@PathVariable(name = "userId") Long userId) {
        return myPostService.findMyPosts(userId);
    }

    // Post api에서 ResponseEntity로 response를 날리도록 변경 => issue 등록
    @PostMapping("/myposts/add")
    public void addMyPost(@RequestBody CreateMyPostRequest request) {
        myPostService.addMyPosts(request.getUserId(), request.getPostId());
    }
}
