package com.flowershop.login.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class UserVo {

   @NotNull(message = "아이디를 입력해주세요.")
   @Size(min = 1) // 빈 문자열 검사
   @Length(min = 4, max = 12, message = "아이디를 4~12글자로 입력해주세요.")
   @Pattern(regexp = "^[A-Za-z0-9]{4,12}$", message = "올바른 아이디를 입력하세요.")
   private String user_id;

   private Integer user_no;

   @NotNull(message = "비밀번호를 입력해주세요.")
   @Size(min = 1)
   @Length(min = 6, max = 20, message = "비밀번호를 6~20글자로 입력해주세요.")
   @Pattern(regexp = "^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "올바른 비밀번호를 입력하세요.")
   private String user_pw;

   @NotNull(message = "이름을 입력해주세요.")
   @Length(min = 2, max = 4, message = "이름을 2~4글자로 입력해주세요.")
   @Pattern(regexp = "^[가-힣]+$", message = "올바른 이름을 입력하세요.")
   @Size(min = 1)
   private String user_name;

   @NotNull(message = "이메일을 입력해주세요.")
   @Size(min = 1)
   private String user_email;
   @NotNull(message = "연락처를 입력해주세요.")
   @Size(min = 1)
   private String user_phone;
   @NotNull(message = "주소1을 입력해주세요.")
   @Size(min = 1)
   private String user_addr1;
   @NotNull(message = "주소2를 입력해주세요.")
   @Size(min = 1)
   private String user_addr2;
   @NotNull(message = "주소3을 입력해주세요.")
   @Size(min = 1)
   private String user_addr3;
   @NotNull(message = "주소4를 입력해주세요.")
   @Size(min = 1)
   private String user_addr4;
   private String user_grade;
   private String user_regdate;
   private String user_yn;
   private String user_deldate;
   private int user_point;
   private String social_id;
   private String social_state;
   private String isadmin;

   public UserVo() {
      this.user_yn = "N";
      this.user_deldate = "";
      this.user_point = 0;
      this.social_id = "";
      this.social_state = "N";
      this.isadmin = "N";
   }

   public UserVo(UserVo userVo) {
      this.user_id = userVo.getUser_id();
      this.user_no = userVo.getUser_no();
      this.user_pw = userVo.getUser_pw();
      this.user_name = userVo.getUser_name();
      this.user_email = userVo.getUser_email();
      this.user_phone = userVo.getUser_phone();
      this.user_addr1 = userVo.getUser_addr1();
      this.user_addr2 = userVo.getUser_addr2();
      this.user_addr3 = userVo.getUser_addr3();
      this.user_addr4 = userVo.getUser_addr4();
      this.user_grade = userVo.getUser_grade();
      this.user_regdate = userVo.getUser_regdate();
      this.user_yn = userVo.getUser_yn();
      this.user_deldate = userVo.getUser_deldate();
      this.user_point = userVo.getUser_point();
      this.social_id = userVo.getSocial_id();
      this.social_state = userVo.getSocial_state();
      this.isadmin = userVo.getIsadmin();

   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   public Integer getUser_no() {
      return user_no;
   }

   public void setUser_no(Integer user_no) {
      this.user_no = user_no;
   }

   public String getUser_pw() {
      return user_pw;
   }

   public void setUser_pw(String user_pw) {
      this.user_pw = user_pw;
   }

   public String getUser_name() {
      return user_name;
   }

   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }

   public String getUser_email() {
      return user_email;
   }

   public void setUser_email(String user_email) {
      this.user_email = user_email;
   }

   public String getUser_phone() {
      return user_phone;
   }

   public void setUser_phone(String user_phone) {
      this.user_phone = user_phone;
   }

   public String getUser_addr1() {
      return user_addr1;
   }

   public void setUser_addr1(String user_addr1) {
      this.user_addr1 = user_addr1;
   }

   public String getUser_addr2() {
      return user_addr2;
   }

   public void setUser_addr2(String user_addr2) {
      this.user_addr2 = user_addr2;
   }

   public String getUser_addr3() {
      return user_addr3;
   }

   public void setUser_addr3(String user_addr3) {
      this.user_addr3 = user_addr3;
   }

   public String getUser_addr4() {
      return user_addr4;
   }

   public void setUser_addr4(String user_addr4) {
      this.user_addr4 = user_addr4;
   }

   public String getUser_grade() {
      return user_grade;
   }

   public void setUser_grade(String user_grade) {
      this.user_grade = user_grade;
   }

   public String getUser_regdate() {
      return user_regdate;
   }

   public void setUser_regdate(String user_regdate) {
      this.user_regdate = user_regdate;
   }

   public String getUser_yn() {
      return user_yn;
   }

   public void setUser_yn(String user_yn) {
      this.user_yn = user_yn;
   }

   public String getUser_deldate() {
      return user_deldate;
   }

   public void setUser_deldate(String user_deldate) {
      this.user_deldate = user_deldate;
   }

   public int getUser_point() {
      return user_point;
   }

   public void setUser_point(int user_point) {
      this.user_point = user_point;
   }

   public String getSocial_id() {
      return social_id;
   }

   public void setSocial_id(String social_id) {
      this.social_id = social_id;
   }

   public String getSocial_state() {
      return social_state;
   }

   public void setSocial_state(String social_state) {
      this.social_state = social_state;
   }

   public String getIsadmin() {
      return isadmin;
   }

   public void setIsadmin(String isadmin) {
      this.isadmin = isadmin;
   }

   @Override
   public String toString() {
      return "UserVo [user_id=" + user_id + ", user_no=" + user_no + ", user_pw=" + user_pw + ", user_name="
            + user_name + ", user_email=" + user_email + ", user_phone=" + user_phone + ", user_addr1=" + user_addr1
            + ", user_addr2=" + user_addr2 + ", user_addr3=" + user_addr3 + ", user_addr4=" + user_addr4
            + ", user_grade=" + user_grade + ", user_regdate=" + user_regdate + ", user_yn=" + user_yn
            + ", user_deldate=" + user_deldate + ", user_point=" + user_point + ", social_id=" + social_id
            + ", social_state=" + social_state + ", isadmin=" + isadmin + "]";
   }

}