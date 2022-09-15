package com.example.marketpractice.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    public final static String TABLENAME = "member";
    public final static String INDEXNAME = "memberNo";

    private Long memberNo;
    private String memberId;
    private String password;
    private String memberName;
    private String email;
    private String tel;
    private Date regDate;
    private int memberPoint;
    private int orderCount;
}
