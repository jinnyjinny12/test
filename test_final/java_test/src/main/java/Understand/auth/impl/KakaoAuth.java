package Understand.auth.impl;

import Understand.auth.SnsAuth;
import Understand.dto.MemberDTO;

public class KakaoAuth implements SnsAuth {
    public KakaoAuth() {

    }

    public boolean login(MemberDTO member) {
        System.out.println("카카오 로그인 성공.");
        return true;
    }

}
