package Understand.service;

import Understand.auth.SnsAuth;
import Understand.dto.MemberDTO;

import java.lang.reflect.Member;

public class MemberService {

    private SnsAuth snsAuth;

    public MemberService(SnsAuth snsAuth) { this.snsAuth = snsAuth; }

    public String loginMember(MemberDTO memberDTO) {
        boolean result = this.snsAuth.login(memberDTO);
        String type = this.snsAuth.getClass().getSimpleName().replace("Auth", "");
        return type + "으로 로그인 " + (result ? "성공" : "실패");
    }
}
