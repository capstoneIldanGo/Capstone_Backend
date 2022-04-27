package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.Post;
import jungsaesidae.capstone.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {



}
