package com.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Member;
import com.library.repository.MemberRepository;
import com.library.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Integer id, Member member) {

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setMobile(member.getMobile());
        existingMember.setAddress(member.getAddress());
        existingMember.setJoinDate(member.getJoinDate());

        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member getMemberById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Member> searchByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

}