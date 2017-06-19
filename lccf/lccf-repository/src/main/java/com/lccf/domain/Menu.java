package com.lccf.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author lichangchao
 * @Time 2017 -04-24 15:05:56
 */
@Entity
@Table(name = "menu")
public class Menu  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "path")
    private String path;
    @Column(name = "title", nullable = true)
    private String title;
    @Column(name = "icon", nullable = true)
    private String icon;
    @Column(name = "selected")
    private Boolean selected;
    @Column(name = "expanded")
    private Boolean expanded;
    @Column(name = "delete_flag")
    private Boolean deleteFlag;
    @Column(name="parent_id")
    private Long parentId;
    @Column(name="order_num")
    private Integer orderNum;
    
   /* @OneToMany(mappedBy = "menu",cascade = CascadeType.ALL)
    @JoinTable(
            name = "menu",
            joinColumns = {@JoinColumn(name = "parent_id", referencedColumnName = "id")})
    
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(referencedColumnName = "id", name = "parent_id", insertable = false, updatable = false)*/

    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="parent_id")
    
    private Set<Menu> children;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
