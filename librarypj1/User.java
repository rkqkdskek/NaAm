package librarypj1;

import java.util.List;

public interface User {
	public void insertUser(UserVO us);  //ȸ������
	public UserVO readUser(String id);  //id�� ���� ȸ���˻�
	public List<UserVO> listUser();  //ȸ����� ��ȯ
	public void delete(String id);
//	public UserVO readBook(String id); // id�� ���� �뿩å �����˻�

}


