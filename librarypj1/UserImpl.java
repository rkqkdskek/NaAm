package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
	public List<UserVO> userList = new ArrayList<>(); // *ȸ�����
	
	@Override
	public void insertUser(UserVO us) { // ȸ������
		userList.add(us);
	}

	@Override
	public UserVO readUser(String id) { // id�� ���� ȸ���˻�
		for (UserVO us : userList) {
			if (us.getId().equals(id)) {
				return us;
			}
		}
		return null;
	}

	@Override
	public List<UserVO> listUser() { // ȸ����� ��ȯ
		return userList;
	}
	
	@Override
	public void delete(String id) {
		userList.remove(0);
	}
//
//	@Override
//	public UserVO readBook(String id) {
//		for(UserVO us : userList) {
//			if(us.getUserbookcd().equals(id)) {
//				return us;
//			}
//		}
//		return null;
//	}


}
