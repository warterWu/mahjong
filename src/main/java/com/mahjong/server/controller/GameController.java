package com.mahjong.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mahjong.server.service.GameService;
import com.mahjong.server.util.WebResponse;

@Controller
@RequestMapping(value = "game")
public class GameController {
	@Autowired
	private GameService gameService;
	@RequestMapping(value = "/check/cpg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public WebResponse<Integer> checkCPG() {
		WebResponse<Integer> webResponse = new WebResponse<Integer>();
		return webResponse;

	}
}
