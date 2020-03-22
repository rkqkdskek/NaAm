package librarypj1;

import java.util.ArrayList;
import java.util.List;

public class RentalImpl implements Rental {
	private List<RentalVO> list = new ArrayList<>();   //*�뿩 ��ü ��� (�ݳ�+�̹ݳ� ���)

	@Override
	public void insertRental(RentalVO vo) {  //�����뿩
		list.add(vo);
	}

	@Override
	public List<RentalVO> listAllRental() {  //�뿩 ��ü��� ��ȯ
		return list;
	}

	@Override
	public List<RentalVO> listUserRental(String id) {  //�˻��� ���� �ش��ϴ� id�� �뿩���� ��� ��ȯ
		List<RentalVO> ulist=new ArrayList<>();
		for(RentalVO vo:list) {
			if(vo.getId().equals(id)) {
				ulist.add(vo);
			}
		}
		return ulist;
	}
	
	@Override
	public RentalVO readRental(String code) {  //�뿩���� ������ȯ
		for(RentalVO vo:list) {
			if(vo.getCode().equals(code)&&vo.getReturnDate()==null) {
				return vo;
			}
		}
		return null;
	}
	
}
