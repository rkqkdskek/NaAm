package librarypj1;

public class BookVO {
	private String code;  //도서코드
	private String title;  //도서명
	private String writer;  //저자
	private String company;  //출판사

	public BookVO() {

	}

	public BookVO(String code, String title, String writer, String company) {
		this.code = code;
		this.title = title;
		this.writer = writer;
		this.company = company;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return code+"\t"+title+"\t"+writer+"\t"+company+"\t";
	}
}
