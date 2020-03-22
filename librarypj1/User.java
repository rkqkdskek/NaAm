package librarypj1;

import java.util.List;

public interface User {
	public void insertUser(UserVO us);  //회원가입
	public UserVO readUser(String id);  //id를 통해 회원검색
	public List<UserVO> listUser();  //회원목록 반환
	public void delete(String id);
//	public UserVO readBook(String id); // id를 통해 대여책 유무검색

}


