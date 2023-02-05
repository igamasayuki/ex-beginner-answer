package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

/**
 * 足し算処理を行うコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;

	/**
	 * 初期画面に遷移.
	 * 
	 * @return 初期画面
	 */
	@GetMapping("")
	public String index() {
		return "exam02";
	}

	/**
	 * 足し算を行い結果を表示.
	 * 
	 * @param num1 足す数
	 * @param num2 足される数
	 * @return 結果画面
	 */
	@PostMapping("/add")
	public String add(Integer num1, Integer num2) {
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("answer", num1 + num2);

		return "exam02-result";
	}

	/**
	 * 結果画面2に遷移.
	 * 
	 * @return 結果画面2
	 */
	@GetMapping("/to-page2")
	public String result2() {
		return "exam02-result2";
	}

}
