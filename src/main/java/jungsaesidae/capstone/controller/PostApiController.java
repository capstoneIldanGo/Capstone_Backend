package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.domain.QPost;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class PostApiController {

    private final PostService postService;

    @GetMapping("/post")
    public Page<PostDto> getPostByPage(
            @RequestParam(value = "keyword", required = true) String keyword,
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "isMint", required = false) boolean isMint,
            @RequestParam(value = "isSold", required = false) boolean isSold,
            @RequestParam(value = "ordering", required = false) String ordering,
            Pageable pageable
    ) {
        return postService.findAllByCondition(keyword, platform, city, state, isMint, isSold, ordering, pageable);
    }

    @GetMapping("/post/{postId}")
    public Optional<PostDto> getPostByPostId(@PathVariable(name = "postId") Long postId) {
        return postService.findDtoById(postId);
    }

}
