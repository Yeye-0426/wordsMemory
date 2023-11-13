package jdbc.entity;

public class Word {
	private Integer word_id;
	private String word_en;
	private String word_soundmark;
	private String word_cn;
	private String word_note;
	private String word_sound;
	private Integer word_reviewtimes;
	private Integer word_forgettimes;
	private Integer word_proficiency;
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
	public String getWord_soundmark() {
		return word_soundmark;
	}
	public void setWord_soundmark(String word_soundmark) {
		this.word_soundmark = word_soundmark;
	}
	public String getWord_cn() {
		return word_cn;
	}
	public void setWord_cn(String word_cn) {
		this.word_cn = word_cn;
	}
	public String getWord_note() {
		return word_note;
	}
	public void setWord_note(String word_note) {
		this.word_note = word_note;
	}
	public String getWord_sound() {
		return word_sound;
	}
	public void setWord_sound(String word_sound) {
		this.word_sound = word_sound;
	}
	public Integer getWord_reviewtimes() {
		return word_reviewtimes;
	}
	public void setWord_reviewtimes(Integer word_reviewtimes) {
		this.word_reviewtimes = word_reviewtimes;
	}
	public Integer getWord_forgettimes() {
		return word_forgettimes;
	}
	public void setWord_forgettimes(Integer word_forgettimes) {
		this.word_forgettimes = word_forgettimes;
	}
	public Integer getWord_proficiency() {
		return word_proficiency;
	}
	public void setWord_proficiency(Integer word_proficiency) {
		this.word_proficiency = word_proficiency;
	}
	public String getWord_modificationtime() {
		return word_modificationtime;
	}
	public void setWord_modificationtime(String word_modificationtime) {
		this.word_modificationtime = word_modificationtime;
	}
	@Override
	public String toString() {
		return "Word [word_id=" + word_id + ", word_en=" + word_en + ", word_soundmark=" + word_soundmark + ", word_cn="
				+ word_cn + ", word_note=" + word_note + ", word_sound=" + word_sound + ", word_reviewtimes="
				+ word_reviewtimes + ", word_forgettimes=" + word_forgettimes + ", word_proficiency=" + word_proficiency
				+ ", word_modificationtime=" + word_modificationtime + "]";
	}
	
}