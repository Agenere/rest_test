package cafe.jjdev.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.restapi.service.BoardService;
import cafe.jjdev.restapi.vo.Board;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@Controller view 연결
	//@RestController 함수
	@GetMapping("/list")
	public List<Board> boardList(){	
		System.out.println("list 실행");
		return boardService.selectBoardList();	
	}
	@PostMapping("/add")
	//json 방식을 매개변수로 받는 방법
	public int addboard(Board board) {
		System.out.println("add 실행");
		return boardService.addBoard(board);
		
	}
	@PostMapping("/modifyById")
	public int modifyById(Board board) {
		System.out.println("modify 실행");
		return boardService.modifyBoard(board);
		
	}
	@GetMapping("/remove")
	public int remove(@RequestParam(value="ck[]") int[] ck) {
		System.out.println("remove 실행");
		return boardService.removeBoard(ck);
		
	}
}
