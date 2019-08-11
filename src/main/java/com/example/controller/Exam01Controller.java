package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 名前を受け取るコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
	
	/**
	 * 初期画面に遷移.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	
	/**
	 * 名前を受け取り、表示する画面に遷移.
	 * @param name 名前
	 * @param model リクエストパラメータ
	 * @return 名前表示画面
	 */
	@RequestMapping("/result")
	public String result(String name, Model model) {
		model.addAttribute("name", name);
		
		return "exam01-result";
	}
	
}
