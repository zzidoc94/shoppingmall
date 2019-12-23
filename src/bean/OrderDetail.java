package bean;

public class OrderDetail {
   private String[] pcode;
   private int[] odcnt;
   private String[] oditem;
   private int[] oditemcost;
   
   public String[] getPcode() {
      return pcode;
   }
   public void setPcode(String[] pcode) {
      this.pcode = pcode;
   }
   public int[] getOdcnt() {
      return odcnt;
   }
   public void setOdcnt(int[] odcnt) {
      this.odcnt = odcnt;
   }
   public String[] getOditem() {
      return oditem;
   }
   public void setOditem(String[] oditem) {
      this.oditem = oditem;
   }
   public int[] getOditemcost() {
      return oditemcost;
   }
   public void setOditemcost(int[] oditemcost) {
      this.oditemcost = oditemcost;
   }
   
   
}