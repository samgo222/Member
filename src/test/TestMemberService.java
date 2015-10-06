package test;
import java.util.Calendar;
import java.util.Scanner;

import service.MemberService;
import vo.MemberVO;


public class TestMemberService {

	public static void main(String[] args) {
		
		MemberService service = new MemberService();
		
		String date;
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		int y=0, m=0, d=0;
		String s = null;
		
		boolean flag = true;
		while(flag){
		System.out.println("1.등록, 2.검색, 3.수정, 4.삭제, 5.전체출력, 6.종료");
		int in=sc.nextInt();
		if(in == 1 ){
			System.out.println("1.오늘, 2.지난날");
			if(sc.nextInt() == 1){
				y = c.get(Calendar.YEAR);
				m = c.get(Calendar.MONTH);
				d = c.get(Calendar.DATE);
			}
			else{
				System.out.println("날짜를 입력하시오  예)20150921");
				date = sc.next();
			}
			
			System.out.println("과목명, 이름, 번호, 주소를 기재하세요");
			service.addMemberVO(new MemberVO(sc.next(),sc.next(),sc.next(),sc.next()));
			System.out.println("입력되었습니다.");
			service.printAll();
			
			
		}
		else if(in==2){
			System.out.println("찾고자하는 과목명을 입력하세요");
			MemberVO vo = service.findMemberVO(sc.next());
			if(vo != null){
				System.out.println(vo);
			}
			else
				System.out.println("존재하지 않는 정보입니다.");
		
		}
		else if(in==3){
			System.out.println("같은 과목명의 이름, 번호, 주소만 변경이 가능합니다. 알맞게 기재해주세요.");
			boolean update = service.updateMemberVO(new MemberVO(sc.next(),sc.next(),sc.next(),sc.next()));
			if(update==true)
				System.out.println("수정이 완료되었습니다.");
			else
				System.out.println("수정이 불가능 합니다.");
			
		}
		else if(in==4){
			System.out.println("삭제할 과목명을 입력하세요 모든 정보가 삭제됩니다.");
				String str = sc.next();
			System.out.println("정말 삭제하시겠습니까? Y/N");
			if(s=="Y")
			{
				service.deleteMemberVO(str);
				System.out.println("삭제하였습니다.");
			}
			
		}
		else if(in==5){
			System.out.println("전체 출력하겠습니다.");
			service.printAll();
		}
			
		else if(in == 6){
			System.out.println("종료하시겠습니까? Y/N");
			s = sc.next();
			if ("Y".equalsIgnoreCase(s)){
				System.out.println("종료되었습니다.");
				flag = false;
				}
		}
		}
		
		/*service.addMemberVO(new MemberVO("java","손연재","111","구로"));
		service.addMemberVO(new MemberVO("oracle","김연아","222","군포"));
		service.addMemberVO(new MemberVO("JSP","홍명보","333","파주"));
		service.addMemberVO(new MemberVO("Ajax","이청용","444","영국"));
		service.addMemberVO(new MemberVO("Spring","박지성","555","수원"));
		service.addMemberVO(new MemberVO("Jquery", "박민혁", "666", "인천"));*/
		//service.printAll();
		
	/*	MemberVO vo = service.findMemberVO("java");
		if(vo != null)
			System.out.println(vo);
		else
			System.out.println("회원이 아닙니다.");
		
		service.deleteMemberVO("Ajax");
		service.printAll();
		*/
		//4차 구현 : 상품 수정
	      //수정대상이 없으면 false를 반환하고
	      //존재하여 수정이 이루어지면 true를 반환받는다.
	   /*   boolean result = service.updateMemberVO(new MemberVO("Jquery", "류현진", "666", "인천"));
	      if(result)
	         System.out.println("수정 완료");
	      else
	         System.out.println("상품이 없어서 수정 불가");
	      service.printAll();*/
		
	}

}
