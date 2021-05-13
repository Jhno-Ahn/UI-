package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.Board;


public class BoardDao {

	DataSource ds = null;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public int insert(Board board) throws Exception {
		Connection connection = null;
		int result = 0;
		
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO post(movie_gen,title,post_content,writedate,writer,user_id,movie_title,director,image_url) VALUES(?, ?, ?, NOW(),?, ?, ?, ?, ?)";

		try {
			// 커넥션 풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, board.getGenre());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());
			stmt.setString(4, board.getWriter());
			stmt.setInt(5, board.getUserId());
			stmt.setString(6, board.getMovieTitle());
			stmt.setString(7, board.getDirector());
			stmt.setString(8, board.getImageUrl());
			
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				//DataSource가 빌려준 Connection은 close()시 연결이 종료되는 것이 아니라 반납하는 의미이다
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
//	public Member exist(String email, String password) throws Exception {
//	
//	}
	
	public List<Board> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT post_id,title,post_content from post ORDER BY post_id ASC";

		try {
			// 커넥션 풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			ArrayList<Board> selectAllBoard = new ArrayList<Board>();

			while (rs.next()) {
				selectAllBoard.add(new Board().setNo(rs.getInt("post_id")).setTitle(rs.getString("title"))
						.setContent(rs.getString("post_content")));
			}

			return selectAllBoard;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 세션에 있는 유저의 데이터 베이스 정보를 빼내기	
//	public Member selectOne(Member member) throws Exception {
//	
//	}
//	
//	public int update(Member member) throws Exception {
//	
//	}
//	
//	public int delete(int no) throws Exception {
//	
//	}
}
