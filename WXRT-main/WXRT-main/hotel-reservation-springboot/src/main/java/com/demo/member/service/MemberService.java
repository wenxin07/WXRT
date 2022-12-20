package com.demo.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.member.dao.MemberRepository;
import com.demo.member.entity.Member;

@Transactional
@Service
public class MemberService {

	@Autowired
	private MemberRepository mDao;

	// 會員增刪改查

	public Member addMember(Member mb) {
		return mDao.save(mb);
	}

	public List<Member> listMember() {
		return mDao.findAll();
	}
//	
//	public Member updateMemberById(Long id) {
//		return mDao.updateMemberById(id);
//	}

	public void deleteMemberById(Long id) {
		mDao.deleteById(id);

	}

	public Member findMemberById(Long id) {
		Optional<Member> optional = mDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	// 檢查email是否存在
	public Member findByEmail(String email) {

		Optional<Member> optional = mDao.findMemberByEmail(email);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	// 檢查email與密碼是否存在
	public Member findByEmailAndPassword(String email, String password) {

		Optional<Member> optional = mDao.findByEmailAndPassword(email, password);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	// 檢查帳號是否存在
	public boolean exisById(Long id) {
		boolean exist = mDao.existsById(id);
		return exist;

	}

}
