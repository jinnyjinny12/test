package Understand.auth.impl;

import Understand.auth.SnsAuth;
import Understand.dto.MemberDTO;

public class NaverAuth implements SnsAuth {
    public NaverAuth() {

    }

    public boolean login (MemberDTO member) {
        System.out.println("네이버 로그인 성공");
        return true;
    }

}
