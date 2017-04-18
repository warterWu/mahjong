package com.mahjong.server.vo;

import java.util.LinkedList;
import java.util.List;

/**
 * 玩家类，把User封装为一个Player，可看做是一个客户端，可进行交互
 * 
 */
public class Player {

	private int id;

	private int roomId;// 房间id

	private int status;// 状态

	private int position;// 位置

	private User user;// 用户信息

	private List<Integer> mjData = new LinkedList<Integer>();// 麻将数据


	public Player() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<Integer> getMjData() {
		return mjData;
	}

	public void setMjData(List<Integer> mjData) {
		this.mjData = mjData;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
