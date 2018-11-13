package com.own.owncommon.promotion;


import lombok.Data;

@Data
public class Promotion {
//private Long id;
//	
//	private String saleName;
//
//	private String startTime;
//	
//	private String endTime;
//	
//	private String slogan;//广告语
//	
//	private String saleAddress;
//	
//	private String saleMark;
//	
//	private String createTime;
//	
////	private int saleStatus;//活动状态
//	
////	private int examineStatus;//审核状态
//	
//	private String userName;
//	
//	private String userAccount;
//	
//	private String userRole;
//	
////	private int flag;
//	
//	private boolean allJoin;
//	
//	private int promotionTypeId;//关联促销类型的id
//	
//	private int scopeId;//关联促销范围的id
//	
//	private String mallTicketId;//关联商城券id
//	
//	private String storeTicketId;//关联店铺券id
//	
//	private String productJson;//参与促销的商品信息
//	
//	private int integral; //赠送积分
//	
//	private Double straightDown;//直降**元
//	
//	private Double disCount;//折扣
//	
//	private boolean timeLimit;//限时
//	
//	private boolean amountLimit;//限量
//	
//	private boolean oneLimit;//限购一个

    private Long id;
    private String saleName;
    private String startTime;
    private String endTime;
    private String slogan;//广告语
    private String saleAddress;
    private String saleMark;
    private String createTime;
    private int saleStatus;//活动状态
    private int examineStatus;//审核状态
    private String userName;
    private String userAccount;
    private String userRole;
    private int flag;
    private boolean allJoin;
    private int integral; //赠送积分
    private Double straightDown;//直降**元
    private Double disCount;//折扣
    private boolean timeLimit;//限时
    private boolean amountLimit;//限量
    private boolean oneLimit;//限购一个

}
