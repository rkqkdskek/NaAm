package librarypj1;

import java.util.List;

public interface Book {
	public void bput(BookVO bo);  //도서등록
    public List<BookVO> listbook();  //도서목록반환
    public List<BookVO> listBook(String title); // 제목으로 도서 검색 (제목 중 일부만 입력해도 일치하는 도서 리스트 출력)
    public BookVO readBook(String code);  //도서코드로 도서검색
}
