package com.demo.member.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	@Query(value = "from Member where email = :email and password = :password")
	Optional<Member> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	// id刪改查

	@Query(value = "from Member where id = :id")
	Optional<Member> findMemberById(@Param("id") Long id);

//	@Transactional
//	@Modifying
//	@Query(value = "from Member where id = :id")
//	public Member updateMemberById(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query(value = "from Member where id = :id")
	public void deleteMemberById(@Param("id") Long id);

	/*
	 * =============================================================================
	 * ========================
	 */

	// firstname刪改查

	@Query(value = "select * from Member where firstname = :firstname", nativeQuery = true)
	List<Member> findMemberByFirstName(@Param("firstname") String firstname);

	@Transactional
	@Modifying
	@Query(value = "update * from Member where firstname = :firstname", nativeQuery = true)
	public Member updateMemberByFirstName(@Param("firstname") String firstname);

	@Transactional
	@Modifying
	@Query(value = "delete * from Member where firstname = :firstname", nativeQuery = true)
	public void deleteMemberByFirstName(@Param("firstname") String firstname);

	/*
	 * =============================================================================
	 * ========================
	 */

	// lastname刪改查

	@Query(value = "from Member where lastname = :lastname")
	List<Member> findMemberBylastName(@Param("lastname") String lastname);

	@Transactional
	@Modifying
	@Query(value = "from Member where lastname = :lastname")
	public Member updateMemberBylastName(@Param("lastname") String lastname);

	@Transactional
	@Modifying
	@Query(value = "from Member where lastname = :lastname")
	public void deleteMemberBylastName(@Param("lastname") String lastname);

	/*
	 * =============================================================================
	 * ========================
	 */

	// firstname+lastname查詢會員

	@Query(value = "from Member where firstname = :firstname and lastname = :lastname")
	List<Member> findMemberByfullName(@Param("firstname") String firstname, @Param("lastname") String lastname);

	/*
	 * =============================================================================
	 * ========================
	 */

	// birth 查詢會員

	@Query(value = "from Member where  birth = :birth")
	List<Member> findMemberByBirth(@Param("birth") Date birth);

//	@Transactional
//	@Modifying
//	@Query(value= "update * from Member where lastname = :lastname", nativeQuery = true)
//	List<Guest> updateMemberByBirth(@Param("birth") Date birth);
//	
//	@Transactional
//	@Modifying
//	@Query(value= "delete * from Member where lastname = :lastname", nativeQuery = true)
//	List<Guest> deleteMemberByBirth(@Param("birth") Date birth);

	/*
	 * =============================================================================
	 * ========================
	 */

	// phone刪改查

	@Query(value = "from Member where  phone = :phone")
	List<Member> findMemberByPhone(@Param("phone") Integer phone);

	@Transactional
	@Modifying
	@Query(value = "from Member where phone = :phone")
	List<Member> updateMemberByPhone(@Param("phone") Integer phone);

	@Transactional
	@Modifying
	@Query(value = "from Member where phone = :phone")
	List<Member> deleteMemberByPhone(@Param("phone") Integer phone);

	/*
	 * =============================================================================
	 * ========================
	 */

	// email刪改查

	@Query(value = "from Member where  email = :email")
	Optional<Member> findMemberByEmail(@Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "from Member where email = :email")
	List<Member> updateMemberByEmail(@Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "from Member where email = :email")
	List<Member> deleteMemberByEmail(@Param("email") String email);

	/*
	 * =============================================================================
	 * ========================
	 */

	// password刪改查

	@Query(value = "from Member where  password = :password")
	List<Member> findMemberByPassword(@Param("password") String password);

	@Transactional
	@Modifying
	@Query(value = "from Member where password = :password")
	List<Member> updateMemberByPassword(@Param("password") String password);

	@Transactional
	@Modifying
	@Query(value = "from Member where password = :password")
	List<Member> deleteMemberByPassword(@Param("password") String password);

	/*
	 * =============================================================================
	 * ========================
	 */

	// 依註冊時間查詢、修改客戶

	@Query(value = "from Member where registerTime = :registerTime")
	List<Member> findMemberByregisterTime(@Param("registerTime") Date registerTime);

	@Transactional
	@Modifying
	@Query(value = "from Member where registerTime = :registerTime")
	List<Member> updateMemberByregisterTime(@Param("registerTime") Date registerTime);

	/*
	 * =============================================================================
	 * ========================
	 */

	// 依性別查詢客戶

	@Query(value = "from Member where sex = :sex")
	List<Member> findMemberBygender(@Param("sex") String sex);

}
