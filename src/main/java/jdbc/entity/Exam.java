package jdbc.entity;

public class Exam {
	private int exam_id;
	private int exam_type;
	private int exam_wid;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String exam_explain;
	private int rightindex;
	private String examModificationtime;
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getExam_type() {
		return exam_type;
	}
	public void setExam_type(int exam_type) {
		this.exam_type = exam_type;
	}
	public int getExam_wid() {
		return exam_wid;
	}
	public void setExam_wid(int exam_wid) {
		this.exam_wid = exam_wid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public String getExam_explain() {
		return exam_explain;
	}
	public void setExam_explain(String exam_explain) {
		this.exam_explain = exam_explain;
	}
	public int getRightindex() {
		return rightindex;
	}
	public void setRightindex(int rightindex) {
		this.rightindex = rightindex;
	}
	public String getExamModificationtime() {
		return examModificationtime;
	}
	public void setExamModificationtime(String examModificationtime) {
		this.examModificationtime = examModificationtime;
	}
	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", exam_type=" + exam_type + ", exam_wid=" + exam_wid + ", question="
				+ question + ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4="
				+ choice4 + ", exam_explain=" + exam_explain + ", rightindex=" + rightindex + ", examModificationtime="
				+ examModificationtime + "]";
	}
	

}