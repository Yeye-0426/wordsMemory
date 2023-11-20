package jdbc.entity;

public class Thesaurus {
	private Integer thesaurus_id;
    private Integer thesaurus_wid;
    private String thesaurus_name;
	private String thesaurus_modificationtime;
	public Integer getThesaurus_id() {
		return thesaurus_id;
	}
	public void setThesaurus_id(Integer thesaurus_id) {
		this.thesaurus_id = thesaurus_id;
	}
	public Integer getThesaurus_wid() {
		return thesaurus_wid;
	}
	public void setThesaurus_wid(Integer thesaurus_wid) {
		this.thesaurus_wid = thesaurus_wid;
	}
	public String getThesaurus_name() {
		return thesaurus_name;
	}
	public void setThesaurus_name(String thesaurus_name) {
		this.thesaurus_name = thesaurus_name;
	}
	public String getThesaurus_modificationtime() {
		return thesaurus_modificationtime;
	}
	public void setThesaurus_modificationtime(String thesaurus_modificationtime) {
		this.thesaurus_modificationtime = thesaurus_modificationtime;
	}
	@Override
	public String toString() {
		return "Thesaurus [thesaurus_id=" + thesaurus_id + ", thesaurus_wid=" + thesaurus_wid + 
				", thesaurus_name=" + thesaurus_name + ", thesaurus_modificationtime="
				+ thesaurus_modificationtime + "]";
	}
	
	
}