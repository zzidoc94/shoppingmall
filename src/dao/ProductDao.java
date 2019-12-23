package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.Order;
import bean.Product;

public class ProductDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ProductDao() {
		con=JdbcUtil.getConnection();
	}
	
	public boolean insertProduct(Product product) {
		String sql = "INSERT INTO P(P_CODE,P_ID,P_NAME,P_PRICE,P_QTY, "
				+"P_CONTENTS,P_DATE,P_ORIFILENAME,P_SYSFILENAME) "
				+"VALUES(?||P_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, product.getP_kind());
			pstmt.setNString(2, product.getP_id());
			pstmt.setNString(3, product.getP_name());
			pstmt.setInt(4, product.getP_price());
			pstmt.setInt(5, product.getP_qty());
			pstmt.setNString(6, product.getP_contents());
			pstmt.setNString(7, product.getP_oriFileName());
			pstmt.setNString(8, product.getP_sysFileName());
			
			int result = pstmt.executeUpdate();
			if(result!=0) { //작업 성공
				System.out.println("상품등록 성공");
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("상품등록 예외");
			e.printStackTrace();
		} 
		return false;  //상품 등록 실패
	}

	public void close() {
		JdbcUtil.close(rs, pstmt, con);
	}

	public List<Product> getItemList(String kind) {
		String sql = "SELECT * FROM PRODUCT WHERE P_CODE LIKE '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, kind);
			rs = pstmt.executeQuery();
			List<Product> pList = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setP_code(rs.getNString("P_CODE"));
				product.setP_name(rs.getNString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_sysFileName(rs.getNString("P_SYSFILENAME"));
				pList.add(product);
			}
			return pList;
		} catch (SQLException e) {
			System.out.println("list예외발생");
			e.printStackTrace();
		}
		
		return null;
	}

	public Product getAjaxDetail(String pCode) {
		Product product = new Product();
		String sql = "SELECT * FROM PRODUCT WHERE P_CODE=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, pCode);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt("p_price"));
				product.setP_code(rs.getNString("P_CODE"));
				product.setP_contents(rs.getNString("p_contents"));
				product.setP_id(rs.getNString("p_id"));
				product.setP_name(rs.getNString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_qty(rs.getInt("p_qty"));
				product.setP_oriFileName(rs.getNString("p_oriFileName"));
				product.setP_sysFileName(rs.getNString("p_sysFileName"));
				product.setP_date(rs.getDate("P_DATE"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product.getP_price());
		System.out.println(product.getP_contents());
		
		
		return product;
	}

	public int insertCart(Cart cart) {
		int flag= 0;
		String sql = "insert into cart values(cart_id.nextval,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, cart.getcPcode());
			System.out.println("cart:"+cart.getcPcode());
			pstmt.setNString(2, cart.getcBuyer());
			pstmt.setInt(3, cart.getcCnt());
			
			
			flag = pstmt.executeUpdate();
			
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return flag;
	}
	
	
	public List<Product> printCart(String user) {
	      String sql = "select p.p_code,p.p_name,p.p_contents,p.p_price,p.p_qty,p.p_sysfilename, cart.c_cnt "
	            + "from p inner join cart on p.p_code=cart.c_pcode where cart.C_BUYER=?";
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setNString(1, user);
	         rs = pstmt.executeQuery();
	         List<Product> pList = new ArrayList<Product>();
	         while (rs.next()) {
	            Product product = new Product();
	            product.setP_code(rs.getNString("p_code"));
	            product.setP_contents(rs.getNString("p_contents"));
	            product.setP_price(rs.getInt("p_price"));
	            product.setP_name(rs.getNString("p_name"));
	            product.setP_qty(rs.getInt("P_qty"));
	            product.setP_sysFileName(rs.getNString("P_SYSFILENAME"));
	            product.setP_cnt(rs.getInt("c_cnt"));
	            pList.add(product);
	            }
	         for(int i=0;i <pList.size();i++) {
	            System.out.println(i+":"+pList.get(i).getP_contents());
	            System.out.println(i+":"+pList.get(i).getP_price());
	            System.out.println(i+":"+pList.get(i).getP_name());
	         }
	         return pList;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      System.err.println("출력오류");
	      }
	      
	      return null;
	   }

	   public List<Order> purchasePrint(String user) {
	      String sql="select ordtbl.o_paydate, orddetail.od_item, orddetail.od_itemcose, ordtbl.o_totalcost, ordtbl.o_payment, orddetail.od_itemcnt "
	            + "from ordtbl inner join orddetail on ordtbl.o_num=orddetail.o_num where ordtbl.o_buyer=?";

	      try {
	         pstmt = con.prepareStatement(sql);
	         System.out.println("result: " + (pstmt==null));
	         System.out.println(user);
	         pstmt.setNString(1, user);
	         rs = pstmt.executeQuery();
	         List<Order> oList = new ArrayList<Order>();
	         while (rs.next()) {
	            Order order = new Order();
	            order.setO_totalcost(rs.getInt("o_totalcost"));
	            order.setO_paydate(rs.getDate("o_paydate"));
	            order.setO_payment(rs.getString("o_payment"));
	            order.setOd_item(rs.getNString("od_item"));
	            order.setOd_itemcnt(rs.getInt("od_itemcnt"));
	            order.setOd_itemcost(rs.getInt("od_itemcose"));
	            oList.add(order);
	         }
	         oList.stream().forEach(s->System.out.println(s)); //람다
	         return oList;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return null;
	   }
	   
	   public void insertOrder(Order o) {
		      String sql = "insert into ordtbl values(ordtblid.nextval,?,?,sysdate,?)";
		      try {
		         pstmt = con.prepareStatement(sql);
		         pstmt.setNString(1, o.getO_buyer());
		         pstmt.setString(2, o.getO_payment());
		         pstmt.setInt(3, o.getO_totalcost());
		         
		         int result = pstmt.executeUpdate();
		         if(result!=0) { //작업 성공
		            System.out.println("주문 성공");
		         }
		         
		      } catch (SQLException e) {
		         System.out.println("주문 예외");
		         e.printStackTrace();
		      } 
		      
		   }

		   public void insertOrderDetail(Order od) {
		      String sql = "insert into orddetail values(orddetailid.nextval,?,?,?,ordtblid.currval,?)";
		      try {
		         pstmt = con.prepareStatement(sql);
		         pstmt.setNString(1, od.getOd_item());
		         pstmt.setInt(2, od.getOd_itemcnt());
		         pstmt.setInt(3, od.getOd_itemcost());
		         System.out.println(od.getOd_product());
		         pstmt.setNString(4, od.getOd_product());
		         
		         int result = pstmt.executeUpdate();
		         if(result!=0) { //작업 성공
		            System.out.println("주문 상세 성공");
		         }
		         
		      } catch (SQLException e) {
		         System.out.println("주문 상세 예외");
		         e.printStackTrace();
		      } 
		      
		   }


}
