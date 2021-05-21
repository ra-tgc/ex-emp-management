package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービス.
 * 
 * @author masaki.taguchi
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * 管理者情報を挿入する.
	 * 
	 * @param administrator 管理者情報
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}

	/**
	 * ログイン処理をする.
	 * 
	 * @param mailAddress 照合するメールアドレス
	 * @param password    照合するパスワード
	 * @return 管理者情報
	 */
	public Administrator login(String mailAddress, String password) {
		return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
	}

//  デバッグ用
//	public void testRepository() {
//		Administrator admin = administratorRepository.findByMailAddressAndPassword("iga@sample.com", "testtest");
//
//		System.out.println(admin);
//
//		admin = administratorRepository.findByMailAddressAndPassword("iga@sample.com", "testtes");
//
//		System.out.println(admin);
//
//	}
}
