package jdbc.entity;

public class Word {
	private Integer word_id;
	private String word_en;
	private String usphone;
	private String ukphone;
	private String word_cn;
	private String sound;
	private String word_modificationtime;
	public Integer getWord_id() {
		return word_id;
	}
	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}
	public String getWord_en() {
		return word_en;
	}
	public void setWord_en(String word_en) {
		this.word_en = word_en;
	}
	public String getUsphone() {
		return usphone;
	}
	public void setUsphone(String usphone) {
		this.usphone = usphone;
	}
	public String getUkphone() {
		return ukphone;
	}
	public void setUkphone(String ukphone) {
		this.ukphone = ukphone;
	}
	public String getWord_cn() {
		return word_cn;
	}
	public void setWord_cn(String word_cn) {
		this.word_cn = word_cn;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getWord_modificationtime() {
		return word_modificationtime;
	}
	public void setWord_modificationtime(String word_modificationtime) {
		this.word_modificationtime = word_modificationtime;
	}
	@Override
	public String toString() {
		return "Word [word_id=" + word_id + ", word_en=" + word_en + ", usphone=" + usphone + ", ukphone=" + ukphone
				+ ", word_cn=" + word_cn + ", sound=" + sound + ", word_modificationtime=" + word_modificationtime
				+ "]";
	}
	
	
}