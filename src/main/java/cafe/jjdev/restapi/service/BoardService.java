package cafe.jjdev.restapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.restapi.mapper.BoardMapper;
import cafe.jjdev.restapi.vo.Board;


//일의단위를 한개로 묶어서 한개가 잘못되면 전부 정지된다
@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	//정보를 가공 하는 역할은 service가 한다.
	public List<Board> selectBoardList(){
	
		return boardMapper.selectBoardList();
		
	}
	
	
	public int addBoard(Board board) {
		return boardMapper.insertBoard(board);

	}

	
	public int removeBoard(int[] ck) {
			
		for(int i=0; i<ck.length;i++) {
			
			boardMapper.deleteBoard(ck[i]);
		}
		return ck.length;
		
	}

	public int modifyBoard(Board board) {
		return boardMapper.updateBoard(board);
		
	}
}