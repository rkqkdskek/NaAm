package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements Book {
	private List<BookVO> booklist = new ArrayList<>();  //*도서목록

	public BookImpl() {  //생성자를 통해 기본 도서정보 입력
		booklist.add(new BookVO("1001", "Perfect 오라클 ", "권순용", "엑시엄"));
		booklist.add(new BookVO("1011", "이것이 자바다       ", "HAN", "SSIT"));
		booklist.add(new BookVO("1012", "혼자 공부하는 자바", "신용권", "한빛"));
		booklist.add(new BookVO("5001", "라이온킹  스토리북", "디즈니", "대원키즈"));
		booklist.add(new BookVO("5002", "디즈니 겨울왕국2 ", "조희순", "삼호뮤직"));
		booklist.add(new BookVO("7001", "고양이 1       ", "베르나르", "열린책들"));
		booklist.add(new BookVO("7002", "고양이 2       ", "베르나르", "열린책들"));
		booklist.add(new BookVO("8011", "매일 한끼 집밥      ", "이윤서", "테이스트"));
		booklist.add(new BookVO("8021", "맥주의 정석          ", "랜디모셔", "소소북스"));
	}

	@Override
	public void bput(BookVO bo) {  //도서등록
		booklist.add(bo);
	}

	@Override
	public List<BookVO> listbook() {  //도서목록반환
		return booklist;
	}

	@Override
	public List<BookVO> listBook(String title) {	// 제목으로 도서 검색 (제목 중 일부만 입력해도 일치하는 도서 리스트 출력)
		List<BookVO> slist = new ArrayList<BookVO>();
		for (BookVO bo : booklist) {
			if (bo.getTitle().indexOf(title)>=0) {
				slist.add(bo);
			}
		}
		return slist;
	}

	@Override
	public BookVO readBook(String code) {  //도서코드로 도서검색
		for (BookVO bo : booklist) {
			if (bo.getCode().equals(code)) {
				return bo;
			}
		}
		return null;
	}
}
