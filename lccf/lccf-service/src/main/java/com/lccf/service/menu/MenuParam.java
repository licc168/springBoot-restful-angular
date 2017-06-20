package com.lccf.service.menu;

import com.lccf.service.base.PageParam;
import javax.persistence.Column;

/**
 * @author lichangchao
 * @date 2017 -05-02 20:47:49
 */
public class MenuParam extends PageParam{
  private String path;
  private String title;
  private String icon;
  private Boolean selected = false;
  private Boolean expanded = false;
  private Boolean deleteFlag = false;;
  private Long parentId;
  private Integer orderNum;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

  public Boolean getExpanded() {
    return expanded;
  }

  public void setExpanded(Boolean expanded) {
    this.expanded = expanded;
  }

  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Integer getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(Integer orderNum) {
    this.orderNum = orderNum;
  }
}
