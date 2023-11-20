package jdbc.entity;

public class NewWord {
	private Integer newword_id;
    private Integer newword_wid;
    private Integer newword_uid;
	private Integer newword_reviewtimes;
	private Integer newword_forgettimes;
	private Integer newword_proficiency;
	private String newword_modificationtime;
	public Integer getNewword_id() {
		return newword_id;
	}
	public void setNewword_id(Integer newword_id) {
		this.newword_id = newword_id;
	}
	public Integer getNewword_wid() {
		return newword_wid;
	}
	public void setNewword_wid(Integer newword_wid) {
		this.newword_wid = newword_wid;
	}
	public Integer getNewword_uid() {
		return newword_uid;
	}
	public void setNewword_uid(Integer newword_uid) {
		this.newword_uid = newword_uid;
	}
	public Integer getNewword_reviewtimes() {
		return newword_reviewtimes;
	}
	public void setNewword_reviewtimes(Integer newword_reviewtimes) {
		this.newword_reviewtimes = newword_reviewtimes;
	}
	public Integer getNewword_forgettimes() {
		return newword_forgettimes;
	}
	public void setNewword_forgettimes(Integer newword_forgettimes) {
		this.newword_forgettimes = newword_forgettimes;
	}
	public Integer getNewword_proficiency() {
		return newword_proficiency;
	}
	public void setNewword_proficiency(Integer newword_proficiency) {
		this.newword_proficiency = newword_proficiency;
	}
	public String getNewword_modificationtime() {
		return newword_modificationtime;
	}
	public void setNewword_modificationtime(String newword_modificationtime) {
		this.newword_modificationtime = newword_modificationtime;
	}
	@Override
	public String toString() {
		return "NewWord [newword_id=" + newword_id + ", newword_wid=" + newword_wid + ", newword_uid=" + newword_uid
				+ ", newword_reviewtimes=" + newword_reviewtimes + ", newword_forgettimes=" + newword_forgettimes
				+ ", newword_proficiency=" + newword_proficiency + ", newword_modificationtime="
				+ newword_modificationtime + "]";
	}
	
}