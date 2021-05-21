package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者登録画面を表示する.
 * 
 * @author masaki.taguchi
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;

	/** セッションスコープ */
	@Autowired
	private HttpSession session;

	/**
	 * InsertAdministratorFormをインスタンス化する.
	 * 
	 * @return インスタンス化されたInsertAdministratorForm
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * LoginFormをインスタンス化する.
	 * 
	 * @return インスタンス化されたLoginForm
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * ログイン画面へフォワード.
	 * 
	 * @return administrator/login.htmlのビュー
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	/**
	 * 管理者登録画面へフォワード.
	 * 
	 * @return administrator/insert.htmlのビュー
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param form 管理者情報のフォーム
	 * @return "/"(ログイン画面)へのリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator admin = new Administrator();
		BeanUtils.copyProperties(form, admin);
		administratorService.insert(admin);

		return "redirect:/";
	}

	/**
	 * ログイン処理とsessionスコープへの管理者情報の格納を行う.
	 * 
	 * @param form  ログインフォーム
	 * @param model requestスコープ
	 * @return ログイン成功時："/employee/showList"(従業員情報一覧ページ)へのフォワード,
	 *         ログイン失敗時："administrator/login"(ログイン画面)へのフォワード
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator admin = administratorService.login(form.getMailAddress(), form.getPassword());

		if (admin == null) {
			model.addAttribute("error", "メールアドレスまたはパスワードが不正です");
			return "administrator/login";
		}

		session.setAttribute("administratorName", admin);

		return "/employee/showList";
	}

// デバッグ用
//	@RequestMapping("/test-admin")
//	public String testAdmin() {
//
//		administratorService.testRepository();
//
//		return "finished";
//	}
}
