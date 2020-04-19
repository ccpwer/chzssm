package com.chz.pojo;

import java.io.Serializable;

public class YuyueOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer yo_id;
	private String yo_uname;
	private String yo_uopenid;
	private String yo_utelphone;
	private String yo_ushenfen;
	private String yo_uybao;
	private Integer yo_kid;
	private String yo_date;
	private String yo_time;
	private String yo_number;
	private String yo_sex;
	private Integer yo_did;
	private String yo_doctor;
	private String yo_docmoney;
	private Integer yo_hexiao;
	private Integer states;
	private Integer remove;
	private Integer paystate;
	public Integer getYo_id() {
		return yo_id;
	}
	public void setYo_id(Integer yo_id) {
		this.yo_id = yo_id;
	}
	public String getYo_uname() {
		return yo_uname;
	}
	public void setYo_uname(String yo_uname) {
		this.yo_uname = yo_uname;
	}
	public String getYo_uopenid() {
		return yo_uopenid;
	}
	public void setYo_uopenid(String yo_uopenid) {
		this.yo_uopenid = yo_uopenid;
	}
	public String getYo_utelphone() {
		return yo_utelphone;
	}
	public void setYo_utelphone(String yo_utelphone) {
		this.yo_utelphone = yo_utelphone;
	}
	public Integer getYo_kid() {
		return yo_kid;
	}
	public void setYo_kid(Integer yo_kid) {
		this.yo_kid = yo_kid;
	}
	public String getYo_date() {
		return yo_date;
	}
	public void setYo_date(String yo_date) {
		this.yo_date = yo_date;
	}
	public String getYo_time() {
		return yo_time;
	}
	public void setYo_time(String yo_time) {
		this.yo_time = yo_time;
	}
	public String getYo_number() {
		return yo_number;
	}
	public void setYo_number(String yo_number) {
		this.yo_number = yo_number;
	}
	public String getYo_sex() {
		return yo_sex;
	}
	public void setYo_sex(String yo_sex) {
		this.yo_sex = yo_sex;
	}
	public Integer getYo_did() {
		return yo_did;
	}
	public void setYo_did(Integer yo_did) {
		this.yo_did = yo_did;
	}
	public String getYo_doctor() {
		return yo_doctor;
	}
	public void setYo_doctor(String yo_doctor) {
		this.yo_doctor = yo_doctor;
	}
	public String getYo_docmoney() {
		return yo_docmoney;
	}
	public void setYo_docmoney(String yo_docmoney) {
		this.yo_docmoney = yo_docmoney;
	}
	public Integer getYo_hexiao() {
		return yo_hexiao;
	}
	public void setYo_hexiao(Integer yo_hexiao) {
		this.yo_hexiao = yo_hexiao;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public Integer getRemove() {
		return remove;
	}
	public void setRemove(Integer remove) {
		this.remove = remove;
	}
	public Integer getPaystate() {
		return paystate;
	}
	public void setPaystate(Integer paystate) {
		this.paystate = paystate;
	}
	public String getYo_ushenfen() {
		return yo_ushenfen;
	}
	public void setYo_ushenfen(String yo_ushenfen) {
		this.yo_ushenfen = yo_ushenfen;
	}
	public String getYo_uybao() {
		return yo_uybao;
	}
	public void setYo_uybao(String yo_uybao) {
		this.yo_uybao = yo_uybao;
	}
	@Override
	public String toString() {
		return "YuyueOrder [yo_id=" + yo_id + ", yo_uname=" + yo_uname + ", yo_uopenid=" + yo_uopenid
				+ ", yo_utelphone=" + yo_utelphone + ", yo_ushenfen=" + yo_ushenfen + ", yo_uybao=" + yo_uybao
				+ ", yo_kid=" + yo_kid + ", yo_date=" + yo_date + ", yo_time=" + yo_time + ", yo_number=" + yo_number
				+ ", yo_sex=" + yo_sex + ", yo_did=" + yo_did + ", yo_doctor=" + yo_doctor + ", yo_docmoney="
				+ yo_docmoney + ", yo_hexiao=" + yo_hexiao + ", states=" + states + ", remove=" + remove + ", paystate="
				+ paystate + "]";
	}
	
	
}
