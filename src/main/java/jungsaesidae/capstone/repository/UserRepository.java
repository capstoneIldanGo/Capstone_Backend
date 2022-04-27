package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.User;
import jungsaesidae.capstone.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {


}
