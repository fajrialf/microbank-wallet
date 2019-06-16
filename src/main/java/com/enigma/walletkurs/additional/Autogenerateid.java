package com.enigma.walletkurs.additional;

public class Autogenerateid {
	String code;
	String current;
	String pad;
	int length;
	public Autogenerateid(String code,String current,String pad,int length){
		this.code=code;
		this.current=current;
		this.pad=pad;
		this.length=length;
	}
	
	public String generatedid() {
		int le=current.length();
<<<<<<< src/main/java/com/enigma/walletkurs/additional/Autogenerateid.java
		String tid= current.substring(le-this.length); 
		String newcode=String.format("%s|p%s%d|d", this.code,this.pad,this.length+1);
				return String.format(newcode.replace("|p", "%").replace("|d", "d"), Integer.parseInt(tid) +1);
=======
<<<<<<< src/main/java/com/enigma/walletkurs/additional/Autogenerateid.java
		String tid= current.substring(le-this.length); 
		String newcode=String.format("%s|p%s%d|d", this.code,this.pad,this.length+1);
				return String.format(newcode.replace("|p", "%").replace("|d", "d"), Integer.parseInt(tid) +1);
=======
		String tid= current.substring(le-this.length);
		String newcode=this.code+String.format("%"+this.pad+""+(this.length+1)+"d", Integer.parseInt(tid) +1);
		return newcode;
>>>>>>> src/main/java/com/enigma/walletkurs/additional/Autogenerateid.java
>>>>>>> src/main/java/com/enigma/walletkurs/additional/Autogenerateid.java
	}
}
