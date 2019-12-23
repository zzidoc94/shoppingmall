package bean;

import java.util.Date;

public class Order {
   private Date o_paydate;
   private int o_totalcost;
   private String o_payment;
   private String o_buyer;
   private int o_num;
   
   private String od_item;
   private int od_itemcost;
   private int od_itemcnt;
   private int od_detail;
private String od_product;
   
   public int getO_num() {
      return o_num;
   }

   public void setO_num(int o_num) {
      this.o_num = o_num;
   }

   public int getOd_detail() {
      return od_detail;
   }

   public void setOd_detailid(int od_detail) {
      this.od_detail = od_detail;
   }

   public String getO_buyer() {
      return o_buyer;
   }

   public void setO_buyer(String o_buyer) {
      this.o_buyer = o_buyer;
   }

   public String getOd_item() {
      return od_item;
   }

   public void setOd_item(String od_item) {
      this.od_item = od_item;
   }

   public Date getO_paydate() {
      return o_paydate;
   }

   public void setO_paydate(Date o_paydate) {
      this.o_paydate = o_paydate;
   }

   public int getOd_itemcost() {
      return od_itemcost;
   }

   public void setOd_itemcost(int od_itemcost) {
      this.od_itemcost = od_itemcost;
   }


   public String getO_payment() {
      return o_payment;
   }

   public void setO_payment(String o_payment) {
      this.o_payment = o_payment;
   }

   public int getOd_itemcnt() {
      return od_itemcnt;
   }

   public void setOd_itemcnt(int od_itemcnt) {
      this.od_itemcnt = od_itemcnt;
   }

   public int getO_totalcost() {
      return o_totalcost;
   }

   public void setO_totalcost(int o_totalcost) {
      this.o_totalcost = o_totalcost;
   }
   public String getOd_product() {
	   return od_product;
	}

	public void setOd_product(String od_product) {
	   this.od_product = od_product;
	}
   @Override
   public String toString() {
      return "Order [o_paydate=" + o_paydate + ", o_totalcost=" + o_totalcost + ", o_payment=" + o_payment
            + ", o_buyer=" + o_buyer + ", o_num=" + o_num + ", od_item=" + od_item + ", od_itemcost=" + od_itemcost
            + ", od_itemcnt=" + od_itemcnt + ", od_detail=" + od_detail + "]";
   }
   
   
}