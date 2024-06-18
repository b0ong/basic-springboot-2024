package com.hugo83.backboard.controller;

import com.hugo83.backboard.entity.Board;
import com.hugo83.backboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping("/board") // Restful URL은 /board로 시작
@Controller
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;    // 중간 열결책

    //    @RequestMapping("/list") // 아래와 동일
    // Model -> controller에 있는 객체를 view로 보내주는 역할을 하는 객체
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList); // thymeleaf, mustache, jsp등 view로 보내는 기능!!
        return "board/list";    // templates/board/list.html 랜더링해서 리턴하라!
    }

    @GetMapping("/detail/{bno}")
    public String detail(Model model, @PathVariable("bno") Long bno) throws Exception {
        Board board = this.boardService.getBoard(bno);
        model.addAttribute("board", board);
        return "board/detail";
    }
}
