package librarypj1;

import java.util.List;

public interface Rental {
	public void insertRental(RentalVO vo);  //�����뿩
	public List<RentalVO> listAllRental();  //�뿩 ��ü��� ��ȯ
	public List<RentalVO> listUserRental(String id);  //�˻��� ���� �ش��ϴ� id�� �뿩����  ��� ��ȯ
	public RentalVO readRental(String id);  //�����ڵ带 ���� �뿩���� ���� ��ȯ
	
}
