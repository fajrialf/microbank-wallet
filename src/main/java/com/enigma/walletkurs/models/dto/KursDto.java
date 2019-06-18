package com.enigma.walletkurs.models.dto;

import java.util.Date;

public class KursDto {


String Error;
String bank;
String matauang;
String jual;
String beli;
String timestamp;
public String getError() {
	return Error;
}
public void setError(String error) {
	Error = error;
}
public String getBank() {
	return bank;
}
public void setBank(String bank) {
	this.bank = bank;
}
public String getMatauang() {
	return matauang;
}
public void setMatauang(String matauang) {
	this.matauang = matauang;
}
public String getJual() {
	return jual;
}
public void setJual(String jual) {
	this.jual = jual;
}
public String getBeli() {
	return beli;
}
public void setBeli(String beli) {
	this.beli = beli;
}
public String getTimestamp() {
	return timestamp;
}
public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}

}
