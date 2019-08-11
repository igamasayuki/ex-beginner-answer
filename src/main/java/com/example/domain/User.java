package com.example.domain;

/**
 * ユーザ情報を表すドメインクラス.
 * 
 * @author igamasayuki
 *
 */
public class User {
	
	/** 名前 */
	private String name;
	
	/** 年齢 */
	private Integer age;
	
	/** コメント */
	private String comment;

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
