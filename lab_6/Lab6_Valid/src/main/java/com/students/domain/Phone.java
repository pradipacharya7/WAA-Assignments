/**
 * 
 */
package com.students.domain;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@NotNull
//	@Digits(integer = 3,fraction = 0,message = "{Size.area.validation}")
	@NotNull
	@Min(value = 100,message = "{Size.area.validation}")
	@Max(value = 999,message = "{Size.area.validation}")
 	private Integer area;
//	@NotNull
//	@Digits(integer = 3,fraction = 0,message = "{Size.prefix.validation}")
	@NotNull
	@Min(value = 100,message = "{Size.prefix.validation}")
	@Max(value = 999,message = "{Size.prefix.validation}")
	private Integer prefix;
//	@NotNull
//	@Digits(integer = 4,fraction = 0,message = "{Size.number.validation}")
	@NotNull
	@Min(value = 1000,message = "{Size.number.validation}")
	@Max(value = 9999,message = "{Size.number.validation}")
	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
