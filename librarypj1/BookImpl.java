package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements Book {
	private List<BookVO> booklist = new ArrayList<>();  //*�������

	public BookImpl() {  //�����ڸ� ���� �⺻ �������� �Է�
		booklist.add(new BookVO("1001", "Perfect ����Ŭ ", "�Ǽ���", "���þ�"));
		booklist.add(new BookVO("1011", "�̰��� �ڹٴ�       ", "HAN", "SSIT"));
		booklist.add(new BookVO("1012", "ȥ�� �����ϴ� �ڹ�", "�ſ��", "�Ѻ�"));
		booklist.add(new BookVO("5001", "���̿�ŷ  ���丮��", "�����", "���Ű��"));
		booklist.add(new BookVO("5002", "����� �ܿ�ձ�2 ", "�����", "��ȣ����"));
		booklist.add(new BookVO("7001", "����� 1       ", "��������", "����å��"));
		booklist.add(new BookVO("7002", "����� 2       ", "��������", "����å��"));
		booklist.add(new BookVO("8011", "���� �ѳ� ����      ", "������", "���̽�Ʈ"));
		booklist.add(new BookVO("8021", "������ ����          ", "������", "�ҼҺϽ�"));
	}

	@Override
	public void bput(BookVO bo) {  //�������
		booklist.add(bo);
	}

	@Override
	public List<BookVO> listbook() {  //������Ϲ�ȯ
		return booklist;
	}

	@Override
	public List<BookVO> listBook(String title) {	// �������� ���� �˻� (���� �� �Ϻθ� �Է��ص� ��ġ�ϴ� ���� ����Ʈ ���)
		List<BookVO> slist = new ArrayList<BookVO>();
		for (BookVO bo : booklist) {
			if (bo.getTitle().indexOf(title)>=0) {
				slist.add(bo);
			}
		}
		return slist;
	}

	@Override
	public BookVO readBook(String code) {  //�����ڵ�� �����˻�
		for (BookVO bo : booklist) {
			if (bo.getCode().equals(code)) {
				return bo;
			}
		}
		return null;
	}
}
