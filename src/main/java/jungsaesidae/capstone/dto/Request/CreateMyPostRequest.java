package jungsaesidae.capstone.dto.Request;

import lombok.Data;

@Data
public class CreateMyPostRequest {
    private Long userId;
    private Long postId;
}
