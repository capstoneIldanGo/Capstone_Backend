package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.repository.custom.UserRepositoryCustom;
import jungsaesidae.capstone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {


}
