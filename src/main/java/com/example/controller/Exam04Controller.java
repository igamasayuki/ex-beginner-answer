package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

//	/**
//	 * フォームをリクエストスコープに格納.
//	 * 
//	 * @return フォームオブジェクト
//	 */
//	@ModelAttribute
//	public UserForm setUpForm() {
//		return new UserForm();
//	}

	/**
	 * 初期画面に遷移.
	 * 
	 * @param form  フォーム
	 * @return 初期画面
	 */
	@GetMapping("")
	public String index(UserForm userForm) {
		return "exam04";
	}

	/**
	 * ユーザ情報を登録.
	 * 
	 * @param form フォーム
	 * @param result エラーメッセージ
	 * @param redirectAttributes リダイレクトスコープ
	 * @return 結果画面（リダイレクト）
	 */
	@PostMapping("/register-user")
	public String registerUser(@Validated UserForm form, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return index(form);
		}

		User user = new User();
		BeanUtils.copyProperties(form, user);

		// 自動でコピーされない年齢を手動コピー
		user.setAge(form.getIntAge());

		redirectAttributes.addFlashAttribute("user", user);

		return "redirect:/exam04/to-result";
	}

	/**
	 * 結果画面に遷移.
	 * 
	 * @return 結果画面
	 */
	@GetMapping("/to-result")
	public String toResult() {
		return "exam04-result";
	}

}
