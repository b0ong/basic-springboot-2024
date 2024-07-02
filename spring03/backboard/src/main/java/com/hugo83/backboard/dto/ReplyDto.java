package com.hugo83.backboard.dto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private Long rno;

    private String content;

    private LocalDateTime createDate; // 글생성일

    private LocalDateTime modifyDate;

    private String writer;
}
