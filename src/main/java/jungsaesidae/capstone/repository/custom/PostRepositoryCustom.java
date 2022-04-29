package jungsaesidae.capstone.repository.custom;

import com.querydsl.core.types.dsl.NumberPath;
import jungsaesidae.capstone.dto.Post.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepositoryCustom {

    public PostDto findOne(NumberPath<Long> postId);
    public List<PostDto> findByCondition(String platformCond, String cityCond, String stateCond, String orderCond);
//    public Page<PostDto> findAllByCondition(String platformCond, String cityCond, String stateCond, String orderCond);
    public Page<PostDto> findAllByCondition(String platformCond, String cityCond, String stateCond, String orderCond, Pageable pageable);
}
