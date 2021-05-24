package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 管理者情報更新時に使用するフォーム.
 *
 * @author masaki.taguchi
 *
 */
public class UpdateAdministratorForm {
	/** 管理者ID */
	@NotBlank
	private String id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "UpdateAdministratorForm [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password="
				+ password + "]";
	}

}
