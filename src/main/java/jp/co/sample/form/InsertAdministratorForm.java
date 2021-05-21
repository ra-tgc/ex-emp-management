package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author masaki.taguchi
 *
 */
public class InsertAdministratorForm {
	/** 管理者名 */
	@NotBlank(message = "管理者名は必須項目です")
	private String name;
	/** メールアドレス */
	@Email(message = "Eメールの形式が不正です")
	@NotBlank(message = "メールアドレスは必須項目です")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "パスワードは必須項目です")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

}
