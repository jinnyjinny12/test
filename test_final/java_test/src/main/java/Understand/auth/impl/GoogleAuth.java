package Understand.auth.impl;

import Understand.auth.SnsAuth;
import Understand.dto.MemberDTO;

public class GoogleAuth implements SnsAuth {

    public GoogleAuth() {

    }

    public boolean login(MemberDTO member) {
        System.out.println("구글 로그인 성공");
        return true;
    }

}
