package jdbc.entity;

public class Sentence {
    private Integer sentence_id;
    private Integer sentence_wid;
    private String sentence_wen;
    private String sentence_en;
    private String sentence_cn;
    private String sentence_modificationtime;
	public Integer getSentence_id() {
		return sentence_id;
	}
	public void setSentence_id(Integer sentence_id) {
		this.sentence_id = sentence_id;
	}
	public Integer getSentence_wid() {
		return sentence_wid;
	}
	public void setSentence_wid(Integer sentence_wid) {
		this.sentence_wid = sentence_wid;
	}
	public String getSentence_wen() {
		return sentence_wen;
	}
	public void setSentence_wen(String sentence_wen) {
		this.sentence_wen = sentence_wen;
	}
	public String getSentence_en() {
		return sentence_en;
	}
	public void setSentence_en(String sentence_en) {
		this.sentence_en = sentence_en;
	}
	public String getSentence_cn() {
		return sentence_cn;
	}
	public void setSentence_cn(String sentence_cn) {
		this.sentence_cn = sentence_cn;
	}
	public String getSentence_modificationtime() {
		return sentence_modificationtime;
	}
	public void setSentence_modificationtime(String sentence_modificationtime) {
		this.sentence_modificationtime = sentence_modificationtime;
	}
	@Override
	public String toString() {
		return "Sentence [sentence_id=" + sentence_id + ", sentence_wid=" + sentence_wid + ", sentence_wen="
				+ sentence_wen + ", sentence_en=" + sentence_en + ", sentence_cn=" + sentence_cn
				+ ", sentence_modificationtime=" + sentence_modificationtime + "]";
	}
	
}