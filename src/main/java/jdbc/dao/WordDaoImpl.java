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
			String sql ="SELECT word_id, word_en, usphone, ukphone, word_cn, sound, "
					+ " word_modificationtime FROM words";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Word word = new Word();
				word.setWord_id(rs.getInt("word_id"));
				word.setWord_en(rs.getString("word_en")); 
				word.setUsphone(rs.getString("usphone")); 
				word.setUkphone(rs.getString("ukphone"));
				word.setWord_cn(rs.getString("word_cn")); 
				word.setSound(rs.getString("sound"));
				word.setWord_modificationtime(rs.getString("word_modificationtime"));  
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
			String sql ="INSERT INTO words(word_en, usphone, ukphone, word_cn, sound, word_modificationtime) "
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, word.getWord_en());  
			pstmt.setString(2, word.getUsphone()); 
			pstmt.setString(3, word.getUkphone()); 
			pstmt.setString(4, word.getWord_cn()); 
			pstmt.setString(5, word.getSound());  
			pstmt.setString(6, word.getWord_modificationtime());

			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}
	@Override
	public boolean deleteWordById(Integer word_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM words WHERE word_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, word_id); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}
	public boolean deleteWordByEn(String word_en) {
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
	public boolean updateWordByEn(Word word) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE words SET " +
	                        "usphone = ?, " +
	                        "ukphone = ?, " +
	                        "word_cn = ?, " +
	                        "sound = ?, " +
	                        "word_modificationtime = ? " +
	                        "WHERE word_en = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, word.getUsphone()); 
	        pstmt.setString(2, word.getUkphone()); 
	        pstmt.setString(3, word.getWord_cn()); 
	        pstmt.setString(4, word.getWord_modificationtime());
	        pstmt.setString(5, word.getWord_en()); 

			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0; // Return true if at least one row was updated
	}
	@Override
	public Word findWordById(Integer word_id) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Word word = new Word();
	    try {
	        conn = DBUtils.getConnection();
	        String sql = "SELECT word_id, word_en, usphone, ukphone, word_cn, sound, "
	        		+ " word_modificationtime FROM words WHERE word_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, word_id);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            word.setWord_id(rs.getInt("word_id"));
	            word.setWord_en(rs.getString("word_en"));
	            word.setUsphone(rs.getString("usphone"));
	            word.setUkphone(rs.getString("ukphone"));
	            word.setWord_cn(rs.getString("word_cn"));
	            word.setSound(rs.getString("sound"));
	            word.setWord_modificationtime(rs.getString("word_modificationtime"));
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        DBUtils.destroy(conn, pstmt, rs);
	    }
	    return word;
	}
	@Override
	public Word findWordByEn(String word_en) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Word word = new Word();
	    try {
	        conn = DBUtils.getConnection();
	        String sql = "SELECT word_id, word_en, usphone, ukphone, word_cn, sound, "
	        		+ " word_modificationtime FROM words WHERE word_en = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, word_en);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            word.setWord_id(rs.getInt("word_id"));
	            word.setWord_en(rs.getString("word_en"));
	            word.setUsphone(rs.getString("usphone"));
	            word.setUkphone(rs.getString("ukphone"));
	            word.setWord_cn(rs.getString("word_cn"));
	            word.setSound(rs.getString("sound"));
	            word.setWord_modificationtime(rs.getString("word_modificationtime"));
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
				String sql ="SELECT word_id, word_en, usphone, ukphone, word_cn, sound, "
		        		+ " word_modificationtime FROM words WHERE word_en like ?";
				pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, "%" + keyword + "%");
		        rs = pstmt.executeQuery();
				while(rs.next()) {
					Word word = new Word();
					word.setWord_id(rs.getInt("word_id"));
		            word.setWord_en(rs.getString("word_en"));
		            word.setUsphone(rs.getString("usphone"));
		            word.setUkphone(rs.getString("ukphone"));
		            word.setWord_cn(rs.getString("word_cn"));
		            word.setSound(rs.getString("sound"));
		            word.setWord_modificationtime(rs.getString("word_modificationtime"));
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
		public List<Word> WordAndThesaurus(String thesaurus_name) {
			Connection conn = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			List<Word> wordlist = new ArrayList<Word>();
			try {
				conn = DBUtils.getConnection();
				String sql = "SELECT word_id, word_en, usphone, ukphone, word_cn FROM thesaurus as t, words as w "
						+ "WHERE t.thesaurus_wid=w.word_id AND thesaurus_name=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, thesaurus_name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Word word = new Word();
					word.setWord_id(rs.getInt("word_id"));
					word.setWord_en(rs.getString("word_en")); 
					word.setUsphone(rs.getString("usphone")); 
					word.setUkphone(rs.getString("ukphone"));
					word.setWord_cn(rs.getString("word_cn"));  
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