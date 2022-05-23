package jungsaesidae.capstone.repository.custom;

import com.querydsl.core.types.dsl.NumberPath;
import jungsaesidae.capstone.dto.Post.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepositoryCustom {

    public Optional<PostDto> findOne(Long postId);
    public Page<PostDto> findAllByCondition(Long itemId, List<String> platformCond, String cityCond, String stateCond, boolean isMint, boolean isSold, String orderCond, Pageable pageable);
}
