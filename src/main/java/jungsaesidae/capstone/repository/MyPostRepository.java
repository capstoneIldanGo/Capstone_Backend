package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.MyPost;
import jungsaesidae.capstone.repository.custom.MyPostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPostRepository extends JpaRepository<MyPost, Long>, MyPostRepositoryCustom {

    void deleteByUserIdAndPostId(Long userId, Long postId);
}

