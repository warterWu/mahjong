package com.mahjong.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahjong.server.mapper.GameMapper;
import com.mahjong.server.service.GameService;
import com.mahjong.server.vo.Room;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameMapper gameMapper;
	@Override
	public void sitDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Room> getRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getRooms(int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
