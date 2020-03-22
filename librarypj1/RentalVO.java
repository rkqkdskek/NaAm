package librarypj1;

public class RentalVO {
	private String code;  //대여도서코드
	private String id;  //대여한사람 id
	private String rentDate;  //대여일자
	private String returnDate;  //반납일자

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
		if(rd==null) {  //returnDate가 null이면 미반납이므로 미반납을 출력
			rd="미반납";
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