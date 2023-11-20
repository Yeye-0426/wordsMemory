package jdbc.dao;

import java.util.List;

import jdbc.entity.Thesaurus;

public interface ThesaurusDao {
	public List<Thesaurus> listAll();
	public boolean addThesaurus(Thesaurus thesaurus);
	public boolean deleteThesaurus(Integer thesaurus_id);
	public boolean updateThesaurus(Thesaurus thesaurus);
	public Thesaurus findThesaurusById(Integer thesaurus_id);
	public List<Thesaurus> listThesaurusByName(String thesaurus_name);
}
