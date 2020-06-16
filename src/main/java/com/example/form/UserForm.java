package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * ユーザ情報が入るフォームクラス.
 * 
 * @author igamasayuki
 *
 */
public class UserForm {
	
	/** 名前 */
	@NotBlank(message = "名前を入力してください。")
	private String name;
	
	/** 年齢 */
	@NotBlank(message = "年齢を入力してください。")
	@Pattern(regexp = "[0-9]*", message = "年齢には数値を入力してください。")
	private String age;
	
	/** コメント */
	@NotBlank(message = "コメントを入力してください。")
	private String comment;
	
	/**
	 * 年齢をint型で返します.
	 * 
	 * @return int型に変換された年齢
	 */
	public int getIntAge() {
		return Integer.parseInt(age);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
