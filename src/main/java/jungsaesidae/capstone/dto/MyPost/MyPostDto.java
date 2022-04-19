package jungsaesidae.capstone.dto.MyPost;

import com.querydsl.core.annotations.QueryProjection;
import jungsaesidae.capstone.dto.Post.PostDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyPostDto {

    private Long myPostId;
    private PostDto post;

    @QueryProjection // 이걸 해줘야 gradle에서 compileQuerydsl을 해줬을 때, 새롭게 dto가 생성된다.
    public MyPostDto(Long myPostId, PostDto post) {
        this.myPostId = myPostId;
        this.post = post;
    }
}
