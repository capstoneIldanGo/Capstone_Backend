package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.dto.MyPost.MyPostDto;
import jungsaesidae.capstone.dto.Request.CreateMyPostRequest;
import jungsaesidae.capstone.service.MyPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myposts")
public class MyPostApiController {

    private final MyPostService myPostService;

//    @GetMapping("/myposts/{userId}")
//    public List<MyPostDto> searchMyPost(@PathVariable(name = "userId") Long userId) {
//        return myPostService.findMyPosts(userId);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<MyPostDto>> searchMyPost(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(myPostService.findMyPosts(userId));
    }

    // Post api에서 ResponseEntity로 response를 날리도록 변경 => issue 등록
    @PostMapping("/add")
    public ResponseEntity<Long> addMyPost(@RequestBody CreateMyPostRequest request) {
        return ResponseEntity.ok(myPostService.addMyPosts(request.getUserId(), request.getPostId()));
    }

    // Not sure which one would be better.
    // 이후 조언을 구하고 refactoring하자.

    @DeleteMapping("/delete/{userId}/{postId}")
    public void delete(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId) {
        myPostService.deleteMyPosts(userId, postId);
    }

    @DeleteMapping("/delete/{myPostId}")
    public void deleteMyPost(@PathVariable(name = "myPostId") Long myPostId) {
        myPostService.deleteMyPosts(myPostId);
    }
}
