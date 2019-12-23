package bean;

import java.util.Date;

public class Product {
   //상품등록시에 필요없지만, 검색시 필요
   private String p_code; //p_kind(new,best) + 시퀀스
   private Date p_date;
   private String p_id; //상품 등록자
   private String p_kind; //new, best
   private String p_name; //상품명
   private String p_contents; //상품 설명
   private int p_price; //상품가격
   private int p_qty;  //상품재고
   private String p_oriFileName;
   private String p_sysFileName;
   private int p_cnt;
   
   public String getP_code() {
      return p_code;
   }
   public void setP_code(String p_code) {
      this.p_code = p_code;
   }
   public Date getP_date() {
      return p_date;
   }
   public void setP_date(Date p_date) {
      this.p_date = p_date;
   }
   public String getP_id() {
      return p_id;
   }
   public void setP_id(String p_id) {
      this.p_id = p_id;
   }
   public String getP_kind() {
      return p_kind;
   }
   public void setP_kind(String p_kind) {
      this.p_kind = p_kind;
   }
   public String getP_name() {
      return p_name;
   }
   public void setP_name(String p_name) {
      this.p_name = p_name;
   }
   public String getP_contents() {
      return p_contents;
   }
   public void setP_contents(String p_contents) {
      this.p_contents = p_contents;
   }
   public int getP_price() {
      return p_price;
   }
   public void setP_price(int p_price) {
      this.p_price = p_price;
   }
   public int getP_qty() {
      return p_qty;
   }
   public void setP_qty(int p_qty) {
      this.p_qty = p_qty;
   }
   public String getP_oriFileName() {
      return p_oriFileName;
   }
   public void setP_oriFileName(String p_oriFileName) {
      this.p_oriFileName = p_oriFileName;
   }
   public String getP_sysFileName() {
      return p_sysFileName;
   }
   public void setP_sysFileName(String p_sysFileName) {
      this.p_sysFileName = p_sysFileName;
   }
   public int getP_cnt() {
      return p_cnt;
   }
   public void setP_cnt(int p_cnt) {
      this.p_cnt = p_cnt;
   }
   
   
}