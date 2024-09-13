package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	public Page<Member> findAll(Pageable page);
	
	// limit : 몇개, offset : 몇페이지서부터
	@Query("select m from Member m where m.age>:age order by m.age desc limit :a offset :b")
	public List<Member> findList(@Param("age")int age,@Param("a")int a,@Param("b")int b);
	
	@Modifying //DML작업할때는 반드시 어노테이션을 설정해야 함
	@Query("update  Member m set m.age=m.age+10 where m.id=:id")
	public int update(@Param("id")String id);
	
	@Query("select m from Member m where pwd=:pwd and email=:email")
	public Member findMember(@Param("pwd")String pwd,@Param("email")String email);
	
	@Query("select m from Member m where pwd=?1 and email=?2")
	public Member findMember1(String pwd,String email);
	
	@Query(value="select * from member where pwd=?1 and email=?2",nativeQuery = true)
	public Member findMember2(String pwd,String email);
	
	//쿼리메소드  메소드명 : findBy컬럼명
	public Member findByEmail(String email);
	
	public Member findByPwdAndEmail(String pwd,String email);
}











