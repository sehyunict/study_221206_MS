package sehyunict.admin.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class AdminMemberVo {
	
	private int member_no;
	private String member_id;
	private String member_pw;
	private byte[] member_profile;
	private String member_name;
	private Date member_birthdate;
	private String member_gender;
	private String member_introduce;
	private String member_email;
	private String member_phone;
	private Date member_date;
	private String member_subscription;
	private String member_rating;
	private String member_marketingcheck;
	private List<AdminMemberVo> checkList;
	

	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public byte[] getMember_profile() {
		return member_profile;
	}
	public void setMember_profile(byte[] member_profile) {
		this.member_profile = member_profile;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Date getMember_birthdate() {
		return member_birthdate;
	}
	public void setMember_birthdate(Date member_birthdate) {
		this.member_birthdate = member_birthdate;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_introduce() {
		return member_introduce;
	}
	public void setMember_introduce(String member_introduce) {
		this.member_introduce = member_introduce;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public Date getMember_date() {
		return member_date;
	}
	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}
	public String getMember_subscription() {
		return member_subscription;
	}
	public void setMember_subscription(String member_subscription) {
		this.member_subscription = member_subscription;
	}
	public String getMember_rating() {
		return member_rating;
	}
	public void setMember_rating(String member_rating) {
		this.member_rating = member_rating;
	}
	public String getMember_marketingcheck() {
		return member_marketingcheck;
	}
	public void setMember_marketingcheck(String member_marketingcheck) {
		this.member_marketingcheck = member_marketingcheck;
	}
	public List<AdminMemberVo> getCheckList() {
		return checkList;
	}
	public void setCheckedList(List<AdminMemberVo> checkList) {
		this.checkList = checkList;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberVo [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_profile=" + Arrays.toString(member_profile) + ", member_name=" + member_name
				+ ", member_birthdate=" + member_birthdate + ", member_gender=" + member_gender + ", member_introduce="
				+ member_introduce + ", member_email=" + member_email + ", member_phone=" + member_phone
				+ ", member_date=" + member_date + ", member_subscription=" + member_subscription + ", member_rating="
				+ member_rating + ", member_marketingcheck=" + member_marketingcheck + "]";
	}
}
