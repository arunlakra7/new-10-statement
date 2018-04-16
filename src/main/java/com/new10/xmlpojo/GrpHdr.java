package com.new10.xmlpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GrpHdr{

	@JsonProperty("CreDtTm")
	private String creDtTm;

	@JsonProperty("MsgId")
	private String msgId;

	public void setCreDtTm(String creDtTm){
		this.creDtTm = creDtTm;
	}

	public String getCreDtTm(){
		return creDtTm;
	}

	public void setMsgId(String msgId){
		this.msgId = msgId;
	}

	public String getMsgId(){
		return msgId;
	}
}