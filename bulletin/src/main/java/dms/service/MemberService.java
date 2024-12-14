package dms.service;

import dms.domain.Member;
import dms.MemberRepository;
import dms.dto.MemberAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(MemberAddDto memberAddDto) {
        Member member = new Member(memberAddDto.getUserName());
        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

}