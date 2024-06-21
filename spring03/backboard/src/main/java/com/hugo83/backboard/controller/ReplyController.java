package com.hugo83.backboard.controller;

import com.hugo83.backboard.entity.Board;
import com.hugo83.backboard.entity.Member;
import com.hugo83.backboard.service.BoardService;
import com.hugo83.backboard.service.MemberService;
import com.hugo83.backboard.service.ReplyService;
import com.hugo83.backboard.validation.ReplyForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
@Log4j2
public class ReplyController {
    private final BoardService boardService;
    private final ReplyService replyService;
    private final MemberService memberService; // 작성자 입력위해 추가

    // Principal 객체 추가하면 로그인한 사용자명(Member 객체)을 알 수 있다.
    @PreAuthorize("isAuthenticated()") // 로그인시만 작성가능
    @PostMapping("/create/{bno}")
    public String create(Model model, @PathVariable("bno") Long bno,
                         @Valid ReplyForm replyForm, BindingResult bindingResult,
                         Principal principal) throws Exception {

        Board board = this.boardService.getBoard(bno);
        Member writer = this.memberService.getMember(principal.getName());  // 지금 로그인 중 사용자의 ID
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", board);
            return "board/detail";
        }
        this.replyService.setReply(board, replyForm.getContent(), writer);
        log.info("Reply Controller 댓글저장 처리완료!!");
        return String.format("redirect:/board/detail/%s", bno);
    }
}
