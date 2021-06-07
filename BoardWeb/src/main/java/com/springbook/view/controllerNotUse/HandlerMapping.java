package com.springbook.view.controllerNotUse;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		//만든 Map인 mappings에, login.do(key) 요청이 왔을 시, LoginController(value)를 새로(new) 생성
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}

	public Controller getController(String path) {
		// login.do(key) 요청이 왔을 시, LoginController(value)를 새로(new) 생성한 값 => return하라
		return mappings.get(path);
	}
	
}
