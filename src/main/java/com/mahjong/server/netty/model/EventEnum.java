package com.mahjong.server.netty.model;

/**
 * 操作类型枚举
 * 
 * @since
 *        <p>
 *        更新时间: 2016年7月31日 v0.1
 *        </p>
 *        <p>
 *        版本内容: 创建
 *        </p>
 */
public enum EventEnum {
	
	/** 登录请求消息 */
    AUTH_REQ(1),
	/** 登录响应消息 */
    AUTH_RESP(2),
    
	/** 进入房间请求消息 */
	ROOM_ENTER_REQ(3),
	/** 进入房间响应消息 */
	ROOM_ENTER_RESP(4),
    
	/** 创建房间请求消息 */
	CREATE_ROOM_REQ(5),
	/** 创建房间响应消息 */
	CREATE_ROOM_RESP(6),
    
	/** 解散房间请求消息 */
	KILL_ROOM_REQ(7),
	KILL_ROOM_RESP(8),
	GRANT_RECORD_REQ(9),
    /** 心跳响应消息*/
	GRANT_RECORD_RESP(10),
	/**
	 * 起牌请求
	 */
	GET_ONE_CARD_REQ(11),
	/**
	 * 起牌响应消息
	 */
	GET_ONE_CARD_RESP(12),
	/**
	 * 第一次发牌请求
	 */
	DEAL_CARD_START_REQ(13),
	/**
	 * 第一次发牌响应消息
	 */
	DEAL_CARD_START_RESP(14),
	/**
	 * 一次出牌请求
	 */
	DROP_ONE_CARD_REQ(15),
	/**
	 * 一次出牌请求响应
	 */
	DROP_ONE_CARD_RESP(16);

    private Integer value;

    public Integer getValue() {
        return value;
    }

    EventEnum(Integer value) {
        this.value = value;
    }
}
