package com.example.domain;

/**
 * Member情報を表すドメインクラス.
 * 
 * @author igamasayuki
 *
 */
public class Member {
	
	/** ID */
	private Integer id;
	
	/** 名前 */
	private String name;
	
	/** 年齢 */
	private Integer age;
	
	/** dep_id */
	private Integer depId;


	public Member() {

	}


	public Member(Integer id, String name, Integer age, Integer depId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.depId = depId;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", depId=" + depId + "]";
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}

}
