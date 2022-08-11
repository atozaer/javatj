package vo;

import java.util.Date;

public class OrderVO {
	public final static String TABLENAME = "`order`";
	public final static String INDEXNAME = "orderNo";
	
	private Long orderNo;
	private Long memberNo;
	private int totalPrice;
	private int usePoint;
	private int paymentPoint;
	private int delivery;
	private String orderComment;
	private Date orderDate;
	private String cardResult;
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	
	public int getPaymentPoint() {
		return paymentPoint;
	}
	public void setPaymentPoint(int paymentPoint) {
		this.paymentPoint = paymentPoint;
	}
	
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getCardResult() {
		return cardResult;
	}
	public void setCardResult(String cardResult) {
		this.cardResult = cardResult;
	}
	
	
}
