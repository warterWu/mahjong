package com.mahjong.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mahjong.server.util.WebResponse;
import com.mahjong.server.vo.Room;

@Controller
@RequestMapping(value = "room")
public class RoomController {
	@RequestMapping(value = "/list/{roomId}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public WebResponse<Room> listRoomNum(@PathVariable(value = "roomId") int roomId) {
		WebResponse<Room> webResponse = new WebResponse<Room>();
		return webResponse;

	}
}
