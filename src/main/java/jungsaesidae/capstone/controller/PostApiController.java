package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.domain.QPost;
import jungsaesidae.capstone.dto.Post.PostDto;
import jungsaesidae.capstone.service.PostService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/posts")
    public List<Post> post() {
        return postService.findAll();
    }

    @GetMapping("/postdto")
    public List<PostDto> postByDto(
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "ordering", required = false) String ordering
//            @RequestParam(value = "priceOrder", required = false) String priceOrd,
//            @RequestParam(value = "uploadDateOrder", required = false) String uploadDateOrd
        ) {

        return postService.findAllByDto(platform, city, state, ordering);
    }
}
