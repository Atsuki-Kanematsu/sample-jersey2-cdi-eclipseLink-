package org.sample.jersey2.response;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

public class SampleParent {

	@QueryParam("field1")
	@NotNull(message = "{error.notnull}")
	private String field1;
	private int field2;
	private Integer field3;
	private Integer field4;

	private List<SampleChild> children;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public Integer getField3() {
		return field3;
	}

	public void setField3(Integer field3) {
		this.field3 = field3;
	}

	public Integer getField4() {
		return field4;
	}

	public void setField4(Integer field4) {
		this.field4 = field4;
	}

	public List<SampleChild> getChildren() {
		return children;
	}

	public void setChildren(List<SampleChild> children) {
		this.children = children;
	}


}
