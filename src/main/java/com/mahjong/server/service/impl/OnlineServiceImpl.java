package com.mahjong.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahjong.server.mapper.RoomMapper;
import com.mahjong.server.mapper.UserMapper;
import com.mahjong.server.service.OnlineService;
import com.mahjong.server.vo.Player;

@Service
public class OnlineServiceImpl implements OnlineService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoomMapper roomMapper;
	@Override
	public void addOnline(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOnline(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Player> getAllOnlinePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
