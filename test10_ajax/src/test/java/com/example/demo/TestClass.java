package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Commit
public class TestClass {
	@Autowired private MemberRepository memberRepository;
	
	@Test
	void test1() {
		//Member m= memberRepository.findMember("666","666@");
		//Member m= memberRepository.findMember1("666","666@");
//		Member m= memberRepository.findMember2("666","666@");
//		System.out.println(m);
		
		Member m1=memberRepository.findByEmail("666@");
		System.out.println("m1====>"+ m1);
		Member m2=memberRepository.findByPwdAndEmail("2222", "hello@naver.com");
		System.out.println("m2====>" + m2);
		
	}
}












