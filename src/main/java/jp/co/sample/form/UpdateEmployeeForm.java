package jp.co.sample.form;

import javax.validation.constraints.Pattern;

/**
 * 従業員の扶養人数変更時に使用するフォーム.
 * 
 * @author masaki.taguchi
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	private String id;
	/** 扶養人数 */
	@Pattern(regexp = "^[0-9]+$", message = "1つ以上の半角数字で入力してください")
	private String dependentsCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
