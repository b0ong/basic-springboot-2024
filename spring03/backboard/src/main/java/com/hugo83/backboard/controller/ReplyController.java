package com.hugo83.backboard.controller;

import com.hugo83.backboard.entity.Board;
import com.hugo83.backboard.service.BoardService;
import com.hugo83.backboard.service.ReplyService;
import com.hugo83.backboard.validation.ReplyForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
@Log4j2
public class ReplyController {
    private final BoardService boardService;
    private final ReplyService replyService;

    @PostMapping("/create/{bno}")
    public String create(Model model, @PathVariable("bno") Long bno,
                         @Valid ReplyForm replyForm, BindingResult bindingResult) throws Exception {
        Board board = this.boardService.getBoard(bno);
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", board);
            return "board/detail";
        }
        this.replyService.setReply(board, replyForm.getContent());
        log.info("Reply Controller 댓글저장 처리완료!!");
        return String.format("redirect:/board/detail/%s", bno);
    }
}
