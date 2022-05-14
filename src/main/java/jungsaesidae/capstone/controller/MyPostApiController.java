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

    /**
     * 조회 APi
     */

    @GetMapping("/{userId}")
    public ResponseEntity<List<MyPostDto>> searchMyPost(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(myPostService.findMyPosts(userId));
    }

    /**
     * 추가 API
     * @param request (userId, postId)
     * @return Long myPost_Id
     */

    @PostMapping("/add")
    public ResponseEntity<Long> addMyPost(@RequestBody CreateMyPostRequest request) {
        return ResponseEntity.ok(myPostService.addMyPosts(request.getUserId(), request.getPostId()));
    }

    /**
     * 삭제 API
     * @param userId
     * @param postId
     */
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

    @GetMapping("/exist")
    public boolean existMyPost(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "postId", required = true) Long postId
    ) {
        return myPostService.existMyPost(userId, postId);
    }
}
