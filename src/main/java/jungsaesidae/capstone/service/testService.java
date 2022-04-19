package jungsaesidae.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class testService {

    private final EntityManager em;

}
