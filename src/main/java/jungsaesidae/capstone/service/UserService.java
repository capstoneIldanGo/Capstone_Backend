package jungsaesidae.capstone.service;

import jungsaesidae.capstone.domain.User;
import jungsaesidae.capstone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findOneById(Long id) {
        return userRepository.findById(id);
    }
}
