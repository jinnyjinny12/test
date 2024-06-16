package Understand;

import Understand.auth.impl.GoogleAuth;
import Understand.auth.impl.KakaoAuth;
import Understand.auth.impl.NaverAuth;
import Understand.dto.MemberDTO;
import Understand.service.MemberService;

import java.util.Scanner;

public class Appliaction01 {

    public Appliaction01() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
        System.out.println("----로그인 프로그램 시작 ------");
        System.out.println("1. google 로그인");
        System.out.println("2. kakao 로그인");
        System.out.println("3. Naver 로그인");
        System.out.println("9. 프로그램 종료");
        System.out.println("로그인 할 인증 수단을 선택해주세요 : ");
        int choice = scanner.nextInt();
        System.out.print("아이디를 입력해주세요: ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력해주세요: ");
        String pwd = scanner.next();
        MemberDTO memberDTO = new MemberDTO(id, pwd);
        MemberService memberService;
        String result;
        switch (choice) {
            case 1:
                memberService = new MemberService(new GoogleAuth());
                result = memberService.loginMember(memberDTO);
                break;
            case 2:
                memberService = new MemberService(new KakaoAuth());
                result = memberService.loginMember(memberDTO);
            case 3:
                memberService = new MemberService(new NaverAuth());
                result = memberService.loginMember(memberDTO);
                break;
            default:
                result = "로그인 실패";

        }

        System.out.println(result);
        }

    }
//     google, kakao, naver 의 Auth 가 선언되어 있지 않아 오류가 나고 있는 것으로 확인됩니다.
//    이렇게 수정하면 각 로그인 방식을 Auth 인터페이스로 추상화하여,
//    switch 문에서 동적으로 선택된 로그인 방식을 사용할 수 있습니다.
//    각 로그인 방식에 대한 공통 작업은 MemberService 클래스에서 처리됩니다.
}
