package jdbc.dao;

import java.util.List;

import jdbc.entity.NewWord;

public interface NewWordDao {
	public List<NewWord> listAll();
	public boolean addNewWord(NewWord newword);
	public boolean deleteNewWord(Integer newword_id);
	public boolean updateNewWord(NewWord newword);
	public NewWord findNewWordById(Integer newword_id);
	public NewWord findNewWordByWidAndUid(Integer newword_wid,Integer newword_uid);
	public List<NewWord> listNewWordByUid(Integer newword_uid);
	public List<NewWord> NewwordAndThesaurus(int newword_uid, String thesaurus_name);
}
