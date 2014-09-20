package com.walmart.delivery.rest.api.to;

/**
 * Class with default behavior of an output
 * 
 * @author josemanzoli
 * @since 2014-09-18
 * 
 */

public class BaseOutputTO implements TransferObject {

	private static final long serialVersionUID = 1L;

	public static final int SUCCESS = 200;
	
	public static final int ERROR = 400;
	
	public static final String MSG_SUCCESS = "success";
	
	public static final String MSG_ERROR = "Ops, something went wrong";
	
	private Integer code;
	
	private String message;
	
	public BaseOutputTO(){
		super();
	}
	
	public BaseOutputTO(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Returns successful output 
	 */
	public void success(){
		setCode(SUCCESS);
		setMessage(MSG_SUCCESS);
	}
	
	/**
	 * Returns errors output
	 */
	public void error(){
		setCode(ERROR);
		setMessage(MSG_ERROR);
	}
}