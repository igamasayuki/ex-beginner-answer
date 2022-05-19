package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

/**
 * メンバー情報の処理制御を行うコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

	@Autowired
	private MemberRepository memberRepository;

	/**
	 * 初期画面に遷移.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("")
	public String index() {
		return "exam05";
	}

	/**
	 * 名前の曖昧検索を行い、検索結果画面へ遷移.
	 * 
	 * @param name  名前
	 * @param model リクエストスコープ
	 * @return 検索結果画面
	 */
	@RequestMapping("/search")
	public String search(String name, Model model) {

		List<Member> memberList = memberRepository.findByLikeName(name);
		model.addAttribute("memberList", memberList);

		return "exam05-result";
	}
}
