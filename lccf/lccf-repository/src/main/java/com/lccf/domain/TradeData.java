package com.lccf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 比特币交易实体
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/17 13:59
 * @see
 */
@Entity
@Table(name = "trade")
public class TradeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;

    @NotNull
    @Column(name = "cny")
    private String cny;
    @NotNull
    @Column(name = "type")
    private String type;

    @Column(name = "time_long")
    private Long   timeLong;

    @Column(name = "time_date")
    private Date   timeDate;

    @Column(name = "create_time")
    private Date   createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }

    public Long getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(Long timeLong) {
        this.timeLong = timeLong;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
