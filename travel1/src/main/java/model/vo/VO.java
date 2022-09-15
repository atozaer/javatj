package model.vo;

public class VO {
   private String fn;
   private String frn;
   public String getFn() {
      return fn;
   }
   public void setFn(String fn) {
      this.fn = fn;
   }
   public String getFrn() {
      return frn;
   }
   public void setFrn(String frn) {
      this.frn = frn;
   }
   @Override
   public String toString() {
      return "VO [fn=" + fn + ", frn=" + frn + "]";
   }
}