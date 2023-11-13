package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.Word;
import jdbc.utils.DBUtils;

public class WordDaoImpl implements WordDao {
	@Override
	public List<Word> listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Word> wordlist = new ArrayList<Word>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT word_id, word_en, word_soundmark, word_cn, word_note, word_sound, word_reviewtimes, "
					+ "word_forgettimes, word_proficiency, word_modificationtime FROM words";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Word word = new Word();
				word.setWord_id(rs.getInt("word_id"));
				word.setWord_en(rs.getString("word_en")); 
				word.setWord_soundmark(rs.getString("word_soundmark"));  //  set word_soundmark
				word.setWord_cn(rs.getString("word_cn"));  // Set word_cn
				word.setWord_note(rs.getString("word_note"));  // Set word_note
				word.setWord_sound(rs.getString("word_sound"));  // Set word_sound
				word.setWord_reviewtimes(rs.getInt("word_reviewtimes"));  // Set word_reviewtimes
				word.setWord_forgettimes(rs.getInt("word_forgettimes"));  // Set word_forgettimes
				word.setWord_proficiency(rs.getInt("word_proficiency"));  // Set word_proficiency
				word.setWord_modificationtime(rs.getString("word_modificationtime"));  // Set word_modificationtime
				wordlist.add(word); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return wordlist; 
	}
	@Override
	public boolean addWord(Word word) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO words(word_en, word_soundmark, word_cn, word_note, word_sound, "
					+ "word_reviewtimes, word_forgettimes, word_proficiency, word_modificationtime) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, word.getWord_en());  // Assuming word_en is a String
			pstmt.setString(2, word.getWord_soundmark());  // Assuming word_soundmark is a String
			pstmt.setString(3, word.getWord_cn());  // Assuming word_cn is a String
			pstmt.setString(4, word.getWord_note());  // Assuming word_note is a String
			pstmt.setString(5, word.getWord_sound());  // Assuming word_sound is a String
			pstmt.setInt(6, word.getWord_reviewtimes());
			pstmt.setInt(7, word.getWord_forgettimes());
			pstmt.setInt(8, word.getWord_proficiency());
			pstmt.setString(9, word.getWord_modificationtime());

			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}
	@Override
	public boolean deleteWord(String word_en) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM words WHERE word_en = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word_en); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}
	@Override
	public boolean updateWord(Word word) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE words SET " +
	                        "word_soundmark = ?, " +
	                        "word_cn = ?, " +
	                        "word_note = ?, " +
	                        "word_sound = ?, " +
	                        "word_reviewtimes = ?, " +
	                        "word_forgettimes = ?, " +
	                        "word_proficiency = ?, " +
	                        "word_modificationtime = ? " +
	                        "WHERE word_en = ?";
			pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, word.getWord_soundmark());
	        pstmt.setString(2, word.getWord_cn());
	        pstmt.setString(3, word.getWord_note());
	        pstmt.setString(4, word.getWord_sound());
	        pstmt.setInt(5, word.getWord_reviewtimes());
	        pstmt.setInt(6, word.getWord_forgettimes());
	        pstmt.setInt(7, word.getWord_proficiency());
	        pstmt.setString(8, word.getWord_modificationtime());
	        pstmt.setString(9, word.getWord_en()); 

			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0; // Return true if at least one row was updated
	}

	@Override
	public Word findWordByEn(String word_en) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Word word = new Word();
	    try {
	        conn = DBUtils.getConnection();
	        String sql = "SELECT word_id, word_en, word_soundmark, word_cn, word_note, word_sound, word_reviewtimes, "
					+ "word_forgettimes, word_proficiency, word_modificationtime FROM words WHERE word_en = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, word_en);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            word.setWord_id(rs.getInt("word_id"));
	            word.setWord_en(rs.getString("word_en"));
	            word.setWord_soundmark(rs.getString("word_soundmark"));
	            word.setWord_cn(rs.getString("word_cn"));
	            word.setWord_note(rs.getString("word_note"));
	            word.setWord_sound(rs.getString("word_sound"));
	            word.setWord_reviewtimes(rs.getInt("word_reviewtimes"));
	            word.setWord_forgettimes(rs.getInt("word_forgettimes"));
	            word.setWord_proficiency(rs.getInt("word_proficiency"));
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        DBUtils.destroy(conn, pstmt, rs);
	    }
	    return word;
	}
	
		@Override
		public List<Word> findWordByEnFuzzy(String keyword) {
			Connection conn = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			List<Word> wordlist = new ArrayList<Word>();
			try {
				conn = DBUtils.getConnection();
				String sql ="SELECT word_id, word_en, word_soundmark, word_cn, word_note, word_sound, word_reviewtimes, "
						+ "word_forgettimes, word_proficiency, word_modificationtime FROM words WHERE word_en like ?";
				pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, "%" + keyword + "%");
		        rs = pstmt.executeQuery();
				while(rs.next()) {
					Word word = new Word();
					word.setWord_id(rs.getInt("word_id"));
					word.setWord_en(rs.getString("word_en")); 
					word.setWord_soundmark(rs.getString("word_soundmark"));  //  set word_soundmark
					word.setWord_cn(rs.getString("word_cn"));  // Set word_cn
					word.setWord_note(rs.getString("word_note"));  // Set word_note
					word.setWord_sound(rs.getString("word_sound"));  // Set word_sound
					word.setWord_reviewtimes(rs.getInt("word_reviewtimes"));  // Set word_reviewtimes
					word.setWord_forgettimes(rs.getInt("word_forgettimes"));  // Set word_forgettimes
					word.setWord_proficiency(rs.getInt("word_proficiency"));  // Set word_proficiency
					word.setWord_modificationtime(rs.getString("word_modificationtime"));  // Set word_modificationtime
					wordlist.add(word); 
					}

			}catch (SQLException se) {
				se.printStackTrace();
			}finally { 
				DBUtils.destroy(conn, pstmt, rs);
			}
			return wordlist; 
		}

}

