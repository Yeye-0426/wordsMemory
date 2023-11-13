package jdbc.dao;

import java.util.List;

import jdbc.entity.Word;

public interface WordDao {
	public List<Word> listAll();
	public boolean addWord(Word word);
	public boolean deleteWord(String word_en);
	public boolean updateWord(Word word);;
	public Word  findWordByEn(String word_en);
	public List<Word> findWordByEnFuzzy(String keyword);
}
