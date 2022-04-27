package jungsaesidae.capstone.repository.custom;

import jungsaesidae.capstone.dto.MyPost.MyPostDto;

import java.util.List;

public interface MyPostRepositoryCustom {

    public List<MyPostDto> findByUserId(Long userId);
}
