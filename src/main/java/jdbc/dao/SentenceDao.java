package jdbc.dao;

import java.util.List;

import jdbc.entity.Sentence;

public interface SentenceDao {
	public List<Sentence> listAll();
	public boolean addSentence(Sentence sentence);
	public boolean deleteSentence(Integer sentence_id);
	public boolean updateSentence(Sentence sentence);
	public Sentence findSentenceById(Integer sentence_id);
	public List<Sentence> listSentenceByWid(Integer sentence_wid);
	List<Sentence> listSentenceByWen(String sentence_wen);
}
