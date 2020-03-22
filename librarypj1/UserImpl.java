package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
	public List<UserVO> userList = new ArrayList<>(); // *회원목록
	
	@Override
	public void insertUser(UserVO us) { // 회원가입
		userList.add(us);
	}

	@Override
	public UserVO readUser(String id) { // id를 통해 회원검색
		for (UserVO us : userList) {
			if (us.getId().equals(id)) {
				return us;
			}
		}
		return null;
	}

	@Override
	public List<UserVO> listUser() { // 회원목록 반환
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
