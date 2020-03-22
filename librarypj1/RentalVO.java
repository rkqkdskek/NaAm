package librarypj1;

public class RentalVO {
	private String code;  //�뿩�����ڵ�
	private String id;  //�뿩�ѻ�� id
	private String rentDate;  //�뿩����
	private String returnDate;  //�ݳ�����

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		String rd=returnDate;
		if(rd==null) {  //returnDate�� null�̸� �̹ݳ��̹Ƿ� �̹ݳ��� ���
			rd="�̹ݳ�";
		}
		return code+"\t"+id+"\t"+rentDate+"\t"+rd;
	}
	
	public String toString2() {
		return code+"\t"+id+"\t"+rentDate+"\t";
	}

	public RentalVO(String code, String id, String rentDate, String returnDate) {
		this.code = code;
		this.id = id;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public RentalVO() {
	}

}