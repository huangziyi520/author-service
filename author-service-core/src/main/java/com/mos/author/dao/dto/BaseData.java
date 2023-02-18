package com.mos.author.dao.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class BaseData {

    private long id;
    private Date gmtCreate;
    private Date gmtModify;
}
