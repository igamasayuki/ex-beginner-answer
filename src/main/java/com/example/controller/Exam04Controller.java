package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

/**
 * ユーザ登録を行うコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	/**
	 * フォームをリクエストスコープに格納.
	 * 
	 * @return フォームオブジェクト
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	/**
	 * 初期画面に遷移.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	/**
	 * ユーザ情報を登録.
	 * 
	 * @param form　リクエストパラメータ
	 * @param result　エラーメッセージ
	 * @param redirectAttributes　リダイレクトスコープ
	 * @return 結果画面（リダイレクト）
	 */
	@RequestMapping("/output")
	public String output(
			@Validated UserForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		user.setAge(form.getIntAge());
		
		redirectAttributes.addFlashAttribute("user", user);
		
		return "redirect:/exam04/output2";
	}
	
	/**
	 * 結果画面に遷移.
	 * 
	 * @return 結果画面
	 */
	@RequestMapping("/output2")
	public String output2() {
		return "exam04-result";
	}
	
}
