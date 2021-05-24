package jp.co.sample.form;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 従業員の扶養人数変更時に使用するフォーム.
 * 
 * @author masaki.taguchi
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	@NotBlank
	private String id;
	/** 従業員名 */
	@NotBlank(message = "従業員名を入力してください")
	private String name;
	/** 入社日 */
	@NotNull(message = "入社日を入力してください")
	private Date hireDate;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;
	/** 郵便番号 */
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "郵便番号を入力してください")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "住所を入力してください")
	private String address;
	/** 電話番号 */
	@Pattern(regexp = "^\\\\d{2,4}-\\\\d{2,4}-\\\\d{4}$$", message = "携帯電話番号を入力してください")
	private String telephone;
	/** 給料 */
	@Pattern(regexp = "^[0-9]+$", message = "1つ以上の半角数字で入力してください")
	private String salary;
	/** 特性 */
	private String characteristics;
	/** 扶養人数 */
	@Pattern(regexp = "^[0-9]+$", message = "1つ以上の半角数字で入力してください")
	private String dependentsCount;

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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", mailAddress="
				+ mailAddress + ", zipCode=" + zipCode + ", address=" + address + ", telephone=" + telephone
				+ ", salary=" + salary + ", characteristics=" + characteristics + ", dependentsCount=" + dependentsCount
				+ "]";
	}

}
