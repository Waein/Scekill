package com.waein.seckill.entity;

import lombok.*;

import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: User, v 0.1
 * @CreateDate 2018/11/15
 * @CreateTime 11:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String userName;
	private String phone;
	private String password;
	private String salt;
	private String head;
	private int loginCount;
	private Date registerDate;
	private Date lastLoginDate;
}
