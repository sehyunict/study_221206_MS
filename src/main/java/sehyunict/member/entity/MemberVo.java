package sehyunict.member.entity;

import java.sql.Date;
import java.util.Arrays;

public class MemberVo {
	private int MEMBER_No;
	private String MEMBER_Id;
	private String MEMBER_Pw;
	private byte[] MEMBER_Profile;
	private String MEMBER_Name;
	private Date MEMBER_Birthdate;
	private String MEMBER_Gender;
	private String MEMBER_Introduce;
	private String MEMBER_Email;
	private String MEMBER_Phone;
	private Date MEMBER_Date;
	private String MEMBER_Subscription;
	private String MEMBER_Rating;
	private String MEMBER_Marketingcheck;

	

	public int getMEMBER_No() {
		return MEMBER_No;
	}
	public void setMEMBER_No(int mEMBER_No) {
		MEMBER_No = mEMBER_No;
	}
	public String getMEMBER_Id() {
		return MEMBER_Id;
	}
	public void setMEMBER_Id(String mEMBER_Id) {
		MEMBER_Id = mEMBER_Id;
	}
	public String getMEMBER_Pw() {
		return MEMBER_Pw;
	}
	public void setMEMBER_Pw(String mEMBER_Pw) {
		MEMBER_Pw = mEMBER_Pw;
	}
	public byte[] getMEMBER_Profile() {
		return MEMBER_Profile;
	}
	public void setMEMBER_Profile(byte[] mEMBER_Profile) {
		MEMBER_Profile = mEMBER_Profile;
	}
	public String getMEMBER_Name() {
		return MEMBER_Name;
	}
	public void setMEMBER_Name(String mEMBER_Name) {
		MEMBER_Name = mEMBER_Name;
	}
	public Date getMEMBER_Birthdate() {
		return MEMBER_Birthdate;
	}
	public void setMEMBER_Birthdate(Date mEMBER_Birthdate) {
		MEMBER_Birthdate = mEMBER_Birthdate;
	}
	public String getMEMBER_Gender() {
		return MEMBER_Gender;
	}
	public void setMEMBER_Gender(String mEMBER_Gender) {
		MEMBER_Gender = mEMBER_Gender;
	}
	public String getMEMBER_Introduce() {
		return MEMBER_Introduce;
	}
	public void setMEMBER_Introduce(String mEMBER_Introduce) {
		MEMBER_Introduce = mEMBER_Introduce;
	}
	public String getMEMBER_Email() {
		return MEMBER_Email;
	}
	public void setMEMBER_Email(String mEMBER_Email) {
		MEMBER_Email = mEMBER_Email;
	}
	public String getMEMBER_Phone() {
		return MEMBER_Phone;
	}
	public void setMEMBER_Phone(String mEMBER_Phone) {
		MEMBER_Phone = mEMBER_Phone;
	}
	public Date getMEMBER_Date() {
		return MEMBER_Date;
	}
	public void setMEMBER_Date(Date mEMBER_Date) {
		MEMBER_Date = mEMBER_Date;
	}
	public String getMEMBER_Subscription() {
		return MEMBER_Subscription;
	}
	public void setMEMBER_Subscription(String mEMBER_Subscription) {
		MEMBER_Subscription = mEMBER_Subscription;
	}
	public String getMEMBER_Rating() {
		return MEMBER_Rating;
	}
	public void setMEMBER_Rating(String mEMBER_Rating) {
		MEMBER_Rating = mEMBER_Rating;
	}
	public String getMEMBER_Marketingcheck() {
		return MEMBER_Marketingcheck;
	}
	public void setMEMBER_Marketingcheck(String mEMBER_Marketingcheck) {
		MEMBER_Marketingcheck = mEMBER_Marketingcheck;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [MEMBER_No=" + MEMBER_No + ", MEMBER_Id=" + MEMBER_Id + ", MEMBER_Pw=" + MEMBER_Pw
				+ ", MEMBER_Profile=" + Arrays.toString(MEMBER_Profile) + ", MEMBER_Name=" + MEMBER_Name
				+ ", MEMBER_Birthdate=" + MEMBER_Birthdate + ", MEMBER_Gender=" + MEMBER_Gender + ", MEMBER_Introduce="
				+ MEMBER_Introduce + ", MEMBER_Email=" + MEMBER_Email + ", MEMBER_Phone=" + MEMBER_Phone
				+ ", MEMBER_Date=" + MEMBER_Date + ", MEMBER_Subscription=" + MEMBER_Subscription + ", MEMBER_Rating="
				+ MEMBER_Rating + ", MEMBER_Marketingcheck=" + MEMBER_Marketingcheck;
	}
	
	
	
	
}
