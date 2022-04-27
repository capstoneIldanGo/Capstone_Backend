package jungsaesidae.capstone.repository.custom;

import com.querydsl.core.types.dsl.NumberPath;
import jungsaesidae.capstone.dto.Post.PostDto;

import java.util.List;

public interface PostRepositoryCustom {

    public PostDto findOne(NumberPath<Long> postId);
    public List<PostDto> findByCondition(String platformCond, String cityCond, String stateCond, String orderCond);

}
