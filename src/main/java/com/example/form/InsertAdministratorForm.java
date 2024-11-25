package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	
	/** 名前 */
	@NotBlank(message = "名前は必須です")
	// @Sizeで文字数バリデーションを追加しました。
	@Size(min = 1, max = 30, message = "1文字以上30文字以内で記載してください")
	private String name;
	/** メールアドレス */
	// ＠NotBlankを追加しました。// @Sizeで文字数バリデーションを追加しました。// メールアドレスの文字数制限を緩和しました。（ネット参照し技術的な上限値に設定しました。）
	@NotBlank(message = "メールアドレスは必須です")
	@Size(min = 1, max = 254, message = "254文字以内で記載してください")
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;
	/** パスワード */
	// ＠NotBlankを追加しました。//パスワードのバリデーションを修正しました。（ネット参照し一般的なセキュリティ条件を満たしているよう設定しました。）
	@NotBlank(message = "パスワードは必須です")	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$", message = "半角英数字を含む8文字以上で設定してください" )
	@Size(min=8, message = "")
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
