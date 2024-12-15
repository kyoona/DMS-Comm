package dms;

import dms.domain.Member;
import dms.dto.MemberAddDto;
import dms.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;  

    @PostMapping
    public ResponseEntity<String > createMember(@RequestBody MemberAddDto memberAddDto) {
        Member createdMember = memberService.createMember(memberAddDto);

        String res = createdMember.getMemberName() + "회원이 되신것을 환영합니다!";
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

}