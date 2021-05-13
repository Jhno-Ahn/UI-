package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.FileDTO;

public class FileDao {
	
		DataSource ds = null;

		public void setDataSource(DataSource ds) {
			this.ds = ds;
		}
		
		public int upload(FileDTO fileDTO) throws Exception {
			Connection connection = null;
			int result = 0;
			
			PreparedStatement stmt = null;
			String sql = " insert Into File(post_id, file_name, save_name) values(?, ?, ?)";
			
			try {
				//커넥션 풀에서 connection 객체 빌려오기
				connection = ds.getConnection();
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, fileDTO.getPost_id());
				stmt.setString(2, fileDTO.getFileName());
				stmt.setString(3, fileDTO.getFileRealName());
				
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
		
//		참고용
//			
//		public Member exist(String email, String password) throws Exception {
//			Connection connection = null;
//			Member member = null;
//			PreparedStatement stmt = null;
//			ResultSet rs = null;
//			final String sqlExist = "SELECT MNAME,EMAIL FROM user" + " WHERE EMAIL=? AND PWD=?";
//
//			try {
//				// 커넥션 풀에서 Connection객체를 빌려온다
//				connection = ds.getConnection();
//				stmt = connection.prepareStatement(sqlExist);
//				stmt.setString(1, email);
//				stmt.setString(2, password);
//				rs = stmt.executeQuery();
//				if (rs.next()) {
//					member = new Member().setName(rs.getString("MNAME")).setEmail(rs.getString("EMAIL"));
//				} else {
//					return null;
//				}
//			} catch (Exception e) {
//				throw e;
//
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//				} catch (Exception e) {
//				}
//				try {
//					if (stmt != null)
//						stmt.close();
//				} catch (Exception e) {
//				}
//
//				try {
//				if(connection != null)
//						connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			return member;
//		}
		
//		public List<FileDTO> selectList() throws Exception {
//			Connection connection = null;
//			Statement stmt = null;
//			ResultSet rs = null;
//			final String sqlSelect = "SELECT post_id, file_name, save_name FROM file" + "\r\n"
//					+ "ORDER BY mno ASC";
//
//			try {
//				// 커넥션 풀에서 Connection객체를 빌려온다
//				connection = ds.getConnection();
//
//				stmt = connection.createStatement();
//				rs = stmt.executeQuery(sqlSelect);
//
//				ArrayList<FileDTO> files = new ArrayList<FileDTO>();
//
//				while (rs.next()) {
//					files.add(
//							new FileDTO().setPost_id(rs.getInt("post_id"))
//							.setFileName(rs.getString("file_name"))
//							.setRealFileName(rs.getString("save_name")));
//				}
//
//				return files;
//
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				try {
//					if (stmt != null)
//						stmt.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//				try {
//					if(connection != null)
//						connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		// 세션에 있는 유저의 데이터 베이스 정보를 빼내기	
//		public FileDTO selectOne(FileDTO fileDTO) throws Exception {
//			Connection connection = null;
//			PreparedStatement stmt = null;
//			ResultSet rs = null;
//
//			final String sqlSelectOne = "SELECT post_id, FileName, FileRealName FROM file" + " WHERE post_id=?";
//
//			try {
//				// 커넥션 풀에서 Connection객체를 빌려온다
//				connection = ds.getConnection();
//				stmt = connection.prepareStatement(sqlSelectOne);
//				stmt.setString(1, fileDTO.getpost_id());	
//				rs = stmt.executeQuery();
//				if (rs.next()) {
//					fileDTO = new fileDTO().setNo(rs.getInt("MNO")).setEmail(rs.getString("EMAIL"))
//							.setName(rs.getString("MNAME")).setPassword(rs.getString("PWD")).setCreatedDate(rs.getDate("CRE_DATE"));
//
//				} else {
//					throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
//				}
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//				} catch (Exception e) {
//				}
//				try {
//					if (stmt != null)
//						stmt.close();
//				} catch (Exception e) {
//				}
//
//				try {
//					/* DataSource가 빌려준 Connection은
//					 * close()시 연결이 종료되는 것이 아니라
//					 * 반납하는 의미이다
//					 * */
//					if(connection != null)
//						connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			return fileDTO;
//		}
//		
//		public int update(Member member) throws Exception {
//			Connection connection = null;
//			int result = 0;
//			PreparedStatement stmt = null;
//			final String sqlUpdate = "UPDATE user SET EMAIL=?,MNAME=?,PWD=?" + " WHERE MNO=?";
//			try {
//				// 커넥션 풀에서 Connection객체를 빌려온다
//				connection = ds.getConnection();
//				stmt = connection.prepareStatement(sqlUpdate);
//				stmt.setString(1, member.getEmail());
//				stmt.setString(2, member.getName());
//				stmt.setString(3, member.getPassword());
//				stmt.setInt(4, member.getNo());
//				result = stmt.executeUpdate();
//
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				try {
//					if (stmt != null)
//						stmt.close();
//				} catch (Exception e) {
//				}
//
//				try {
//					/* DataSource가 빌려준 Connection은
//					 * close()시 연결이 종료되는 것이 아니라
//					 * 반납하는 의미이다
//					 * */
//					if(connection != null)
//						connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return result;
//		}
		
		public int delete(int no) throws Exception {
			Connection connection = null;
			int result = 0;
			Statement stmt = null;
			final String sqlDelete = "DELETE FROM fileDTO WHERE MNO=";

			try {
				// 커넥션 풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();
				stmt = connection.createStatement();
				result = stmt.executeUpdate(sqlDelete + no);

			} catch (Exception e) {
				throw e;

			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
				}

				try {
					/* DataSource가 빌려준 Connection은
					 * close()시 연결이 종료되는 것이 아니라
					 * 반납하는 의미이다
					 * */
					if(connection != null)
						connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}
	
	
	

