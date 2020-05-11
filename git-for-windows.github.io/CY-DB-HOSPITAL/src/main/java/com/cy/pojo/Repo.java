package com.cy.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repo {
private Integer id;
private String name;
private String ending;
private Date startTime;
private Date endTime;
private String note;
private String docname;
private Integer parentId;
}
