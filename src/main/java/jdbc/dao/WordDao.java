package jdbc.dao;

import java.util.List;

import jdbc.entity.Word;

public interface WordDao {
	public List<Word> listAll();
	public boolean addWord(Word word);
	public boolean deleteWordById(Integer word_id);
	public boolean deleteWordByEn(String word_en);
	public boolean updateWordByEn(Word word);
	public Word findWordById(Integer word_id);
	public Word findWordByEn(String word_en);
	public List<Word> findWordByEnFuzzy(String keyword);
}
