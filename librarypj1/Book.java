package librarypj1;

import java.util.List;

public interface Book {
	public void bput(BookVO bo);  //�������
    public List<BookVO> listbook();  //������Ϲ�ȯ
    public List<BookVO> listBook(String title); // �������� ���� �˻� (���� �� �Ϻθ� �Է��ص� ��ġ�ϴ� ���� ����Ʈ ���)
    public BookVO readBook(String code);  //�����ڵ�� �����˻�
}
