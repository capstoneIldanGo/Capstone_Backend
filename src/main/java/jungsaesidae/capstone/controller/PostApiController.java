package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.domain.QPost;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class PostApiController {

    private final PostService postService;

    @GetMapping("/postdto")
    public List<PostDto> postByDto(
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "ordering", required = false) String ordering
        ) {

        return postService.findAllByDto(platform, city, state, ordering);
    }

    @GetMapping("/post")
    public Page<PostDto> getPostByPage(
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "isMint", required = false) boolean isMint,
            @RequestParam(value = "ordering", required = false) String ordering,
            Pageable pageable
    ) {
        return postService.findAllByCondition(platform, city, state, isMint, ordering, pageable);
    }
}
