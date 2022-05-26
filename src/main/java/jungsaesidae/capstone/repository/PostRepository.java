package jungsaesidae.capstone.repository;

import com.querydsl.core.Tuple;
import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

}
