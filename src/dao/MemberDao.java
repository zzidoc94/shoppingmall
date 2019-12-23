package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jndi.ldap.Connection;

public class MemberDao {
	java.sql.Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		con=JdbcUtil.getConnection();
	}
	public void close() {
		JdbcUtil.close(rs, pstmt, con);
	}

	
	public int access(String id, String pw) {
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		int result=-1;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getNString("pw").equals(pw)) {
					result=1; //모두 일치
				}else {
					result=-1;//비번불일치
				}
			}else {
				result=0;//아이디 불일치
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}
