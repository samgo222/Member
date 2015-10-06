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
		System.out.println("1.���, 2.�˻�, 3.����, 4.����, 5.��ü���, 6.����");
		int in=sc.nextInt();
		if(in == 1 ){
			System.out.println("1.����, 2.������");
			if(sc.nextInt() == 1){
				y = c.get(Calendar.YEAR);
				m = c.get(Calendar.MONTH);
				d = c.get(Calendar.DATE);
			}
			else{
				System.out.println("��¥�� �Է��Ͻÿ�  ��)20150921");
				date = sc.next();
			}
			
			System.out.println("�����, �̸�, ��ȣ, �ּҸ� �����ϼ���");
			service.addMemberVO(new MemberVO(sc.next(),sc.next(),sc.next(),sc.next()));
			System.out.println("�ԷµǾ����ϴ�.");
			service.printAll();
			
			
		}
		else if(in==2){
			System.out.println("ã�����ϴ� ������� �Է��ϼ���");
			MemberVO vo = service.findMemberVO(sc.next());
			if(vo != null){
				System.out.println(vo);
			}
			else
				System.out.println("�������� �ʴ� �����Դϴ�.");
		
		}
		else if(in==3){
			System.out.println("���� ������� �̸�, ��ȣ, �ּҸ� ������ �����մϴ�. �˸°� �������ּ���.");
			boolean update = service.updateMemberVO(new MemberVO(sc.next(),sc.next(),sc.next(),sc.next()));
			if(update==true)
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			else
				System.out.println("������ �Ұ��� �մϴ�.");
			
		}
		else if(in==4){
			System.out.println("������ ������� �Է��ϼ��� ��� ������ �����˴ϴ�.");
				String str = sc.next();
			System.out.println("���� �����Ͻðڽ��ϱ�? Y/N");
			if(s=="Y")
			{
				service.deleteMemberVO(str);
				System.out.println("�����Ͽ����ϴ�.");
			}
			
		}
		else if(in==5){
			System.out.println("��ü ����ϰڽ��ϴ�.");
			service.printAll();
		}
			
		else if(in == 6){
			System.out.println("�����Ͻðڽ��ϱ�? Y/N");
			s = sc.next();
			if ("Y".equalsIgnoreCase(s)){
				System.out.println("����Ǿ����ϴ�.");
				flag = false;
				}
		}
		}
		
		/*service.addMemberVO(new MemberVO("java","�տ���","111","����"));
		service.addMemberVO(new MemberVO("oracle","�迬��","222","����"));
		service.addMemberVO(new MemberVO("JSP","ȫ��","333","����"));
		service.addMemberVO(new MemberVO("Ajax","��û��","444","����"));
		service.addMemberVO(new MemberVO("Spring","������","555","����"));
		service.addMemberVO(new MemberVO("Jquery", "�ڹ���", "666", "��õ"));*/
		//service.printAll();
		
	/*	MemberVO vo = service.findMemberVO("java");
		if(vo != null)
			System.out.println(vo);
		else
			System.out.println("ȸ���� �ƴմϴ�.");
		
		service.deleteMemberVO("Ajax");
		service.printAll();
		*/
		//4�� ���� : ��ǰ ����
	      //��������� ������ false�� ��ȯ�ϰ�
	      //�����Ͽ� ������ �̷������ true�� ��ȯ�޴´�.
	   /*   boolean result = service.updateMemberVO(new MemberVO("Jquery", "������", "666", "��õ"));
	      if(result)
	         System.out.println("���� �Ϸ�");
	      else
	         System.out.println("��ǰ�� ��� ���� �Ұ�");
	      service.printAll();*/
		
	}

}
