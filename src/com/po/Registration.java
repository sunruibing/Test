package com.po;



/**
 * 挂号订单
 * 
 * 对应数据库表：registration
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
public class Registration {

	private Integer id;//订单id
	
	private String city;//患者所选城市
	
	private String section;//所选科室

	private String title;//医生职称

	private String reservationDate;//预约时间

	private String name;//患者名字

	private String gender;//患者性别
	
	private String age;//患者年龄	
	
	private String phone;//患者电话	
	
	private String content;//患者病情描述	
	
	private String money;//挂号金额

	private String orderCode;//订单编号
	
	private String orderStatus;//订单状态
	
	private Integer userId;//所属用户id
	
	private String createTime;//订单创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", city=" + city + ", section=" + section + ", title="
				+ title + ", reservationDate=" + reservationDate + ", name=" + name + ", gender=" + gender + ", age="
				+ age + ", phone=" + phone + ", content=" + content + ", money=" + money + ", orderCode=" + orderCode
				+ ", orderStatus=" + orderStatus + ", userId=" + userId + ", createTime=" + createTime + "]";
	}

}
