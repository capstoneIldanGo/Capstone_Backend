package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.User;
import jungsaesidae.capstone.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;

    public Optional<User> findOneById(Long id) {
        return userRespository.findOneById(id);
    }

}
