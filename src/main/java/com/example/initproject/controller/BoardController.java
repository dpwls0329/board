package com.example.initproject.controller;

import com.example.initproject.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @RequestMapping("getBoard")
    public String getBoard(
            @RequestParam("userRole")String userRole,
            @RequestParam("userId")String userId,
            @RequestParam("title")String title,
            @RequestParam("writer")String writer,
            @RequestParam("content")String content,
            @RequestParam("createDate")String createDate,
            @RequestParam("cnt")String cnt,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("writer", writer);
        model.addAttribute("content", content);
        model.addAttribute("createDate", createDate);
        model.addAttribute("cnt", cnt);
        model.addAttribute("userId", userId);
        model.addAttribute("userRole", userRole);
        return "getBoard";
    }

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model) {
        //List 타입으로 Board객체를 넣는 boardList변수명 선언
        // = (대입연산자) heap메모리에 Arraylist타입으로 할당
        //List는 ArrayList의 부모클래스
        List<Board> boardList = new ArrayList<Board>();

        for(int i=1; i<=10; i++) {
            //Board 클래스로 board인스턴스 생성
            Board board = new Board();
            //롬북으로 자동생성된 seter 메서드로 데이터 입력
            board.setSeq(new Long(i));
            board.setTitle("게시판 테스트");
            board.setWriter("김준석");
            board.setContent("게시판 프로그램 테스트 입니다");
            board.setCreateDate(new Date());
            board.setCnt(0L);
            //boardList배열에 board객체 넣기 (for문 10번 도니까 board객체 10개 넣기)
            boardList.add(board);
        }
        model.addAttribute("boardList", boardList);
        System.out.println("출력");
        //viewResolver
        //retrun getBoardList라는 문자열로 templates에 있는 같은 이름에 html파일을 찾는다
        return "getBoardList";
    }
}
