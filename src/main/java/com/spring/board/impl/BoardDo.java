package com.spring.board.impl;

public class BoardDo {
	//¸â¹öº¯¼ö 
	private int seq;
	private String Name;
	private String Birth;
	private String Adopted;
	
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + 
				", Name=" + Name + 
				", Birth=" + Birth + 
				", Adopted=" + Adopted + "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String Birth) {
		this.Birth = Birth;
	}
	public String getAdopted() {
		return Adopted;
	}
	public void setAdopted(String Adopted) {
		this.Adopted = Adopted;
	}
	
	
	

}
