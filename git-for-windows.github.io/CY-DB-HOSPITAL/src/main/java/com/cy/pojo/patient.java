package com.cy.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class patient implements Serializable {
	private static final long serialVersionUID = -8167218130369555752L;
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private Integer phone;
	private String note;
	private Date firstTime;
	private Integer parentId;
}
