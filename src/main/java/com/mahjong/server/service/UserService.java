package com.mahjong.server.service;

import java.util.List;

import com.mahjong.server.vo.User;

/**
 * 用户接口
 */
public interface UserService {

	public void save(User user);

	public User login(String username, String password);

	public List<User> getAllUser();
}
