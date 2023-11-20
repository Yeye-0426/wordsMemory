package jdbc.test;

import static org.junit.Assume.assumeTrue;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;

import jdbc.dao.WordDaoImpl;
import jdbc.entity.Word;

public class WordDaoTest {
	private static WordDaoImpl wordDao;

    @BeforeClass
    public static void init() {
        // Initialize your WordDao or set up a testing database connection.
        wordDao = new WordDaoImpl();
    }

    @AfterClass
    public static void destroy() {
        // Clean up resources or close the database connection if needed.
        wordDao = null;
    }
    /*
    @Test
    public void testListAll(){
    	List<Word> list = wordDao.listAll();
    	for(Word word: list)
    		System.out.println(word);
    }

    @Test
    public void testAddWord() {
        // Test the addWord method of WordDao.
        Word word = new Word();
		word.setWord_en("an"); 
		word.setWord_soundmark("忙n; 蓹n");  
		word.setWord_cn("涓�涓紙鐢ㄤ簬鍏冮煶鍓嶏級"); 
		word.setWord_note("渚嬪彞");  
		word.setWord_sound("an_sound");  
		word.setWord_modificationtime("2023-11-08 19:40:01");
		boolean res = wordDao.addWord(word);
		assumeTrue(res);
    }

    @Test
    public void testUpdateWord() {
    	Word word = new Word();
        word.setWord_en("an");  // Replace with an existing word_en value
        word.setWord_soundmark("Updated Soundmark");
        word.setWord_cn("Updated Chinese");
        word.setWord_note("Updated Example");
        word.setWord_sound("Updated Sound");
        word.setWord_modificationtime("2023-11-08 20:00:00");
        boolean res = wordDao.updateWord(word);

        // Use assumeTrue to check if the assumption holds true
        assumeTrue(res);
    }

    @Test
    public void testFindWordByEn() {
         // Find the word by its word_en value
         Word foundWord = wordDao.findWordByEn("an");
         System.out.println(foundWord);
    }

    /*
    @Test
    public void testDeleteWord() {
        // Delete the word and check if the delete was successful
        boolean res = wordDao.deleteWordByEn("an");

        // Use assumeTrue to check if the assumption holds true
        assumeTrue(res);
    }
    */
    public void testFindWordByEnFuzzy(){
    	List<Word> list = wordDao.findWordByEnFuzzy("n");
    	for(Word word: list)
    		System.out.println(word);
    }


}

