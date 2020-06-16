package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

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
	@NotNull(message = "年齢を入力してください。")
	@Range(min=0, max=120, message = "年齢は0〜120の間で入力してください。")
	private Integer age;
	
	/** コメント */
	@NotBlank(message = "コメントを入力してください。")
	private String comment;

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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
