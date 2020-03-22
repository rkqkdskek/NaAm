package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class RentalImpl implements Rental {
	private List<RentalVO> list = new ArrayList<>();   //*대여 전체 목록 (반납+미반납 모두)

	@Override
	public void insertRental(RentalVO vo) {  //도서대여
		list.add(vo);
	}

	@Override
	public List<RentalVO> listAllRental() {  //대여 전체목록 반환
		return list;
	}

	@Override
	public List<RentalVO> listUserRental(String id) {  //검색을 통해 해당하는 id가 대여중인 목록 반환
		List<RentalVO> ulist=new ArrayList<>();
		for(RentalVO vo:list) {
			if(vo.getId().equals(id)) {
				ulist.add(vo);
			}
		}
		return ulist;
	}
	
	@Override
	public RentalVO readRental(String code) {  //대여중인 도서반환
		for(RentalVO vo:list) {
			if(vo.getCode().equals(code)&&vo.getReturnDate()==null) {
				return vo;
			}
		}
		return null;
	}
	
}
