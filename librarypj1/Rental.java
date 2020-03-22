package librarypj1;

import java.util.List;

public interface Rental {
	public void insertRental(RentalVO vo);  //도서대여
	public List<RentalVO> listAllRental();  //대여 전체목록 반환
	public List<RentalVO> listUserRental(String id);  //검색을 통해 해당하는 id가 대여중인  목록 반환
	public RentalVO readRental(String id);  //도서코드를 통해 대여중인 도서 반환
	
}
