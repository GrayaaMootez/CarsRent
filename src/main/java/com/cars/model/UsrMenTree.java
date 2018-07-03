package com.cars.model;
// Generated 15 juin 2018 16:18:35 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UsrMenTree generated by hbm2java
 */
@Entity
@Table(name = "USR_MEN_TREE")
public class UsrMenTree implements java.io.Serializable {

	private UsrMenTreeId id;
	private MenuTree menuTree;
	private UsrMen usrMen;
	private boolean del;
	private boolean ins;
	private String pageTrac;
	private boolean upd;
	private String utilTrac;

	public UsrMenTree() {
	}

	public UsrMenTree(UsrMenTreeId id, MenuTree menuTree, UsrMen usrMen) {
		this.id = id;
		this.menuTree = menuTree;
		this.usrMen = usrMen;
	}

	public UsrMenTree(UsrMenTreeId id, MenuTree menuTree, UsrMen usrMen, boolean del, boolean ins, String pageTrac,
			boolean upd, String utilTrac) {
		this.id = id;
		this.menuTree = menuTree;
		this.usrMen = usrMen;
		this.del = del;
		this.ins = ins;
		this.pageTrac = pageTrac;
		this.upd = upd;
		this.utilTrac = utilTrac;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "menuId", column = @Column(name = "MENU_ID", nullable = false, scale = 0)),
			@AttributeOverride(name = "util", column = @Column(name = "UTIL", nullable = false, length = 120)) })
	public UsrMenTreeId getId() {
		return this.id;
	}

	public void setId(UsrMenTreeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", nullable = false, insertable = false, updatable = false)
	public MenuTree getMenuTree() {
		return this.menuTree;
	}

	public void setMenuTree(MenuTree menuTree) {
		this.menuTree = menuTree;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTIL", nullable = false, insertable = false, updatable = false)
	public UsrMen getUsrMen() {
		return this.usrMen;
	}

	public void setUsrMen(UsrMen usrMen) {
		this.usrMen = usrMen;
	}

	@Column(name = "DEL", precision = 1, scale = 0)
	public boolean isDel() {
		return this.del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	@Column(name = "INS", precision = 1, scale = 0)
	public boolean isIns() {
		return this.ins;
	}

	public void setIns(boolean ins) {
		this.ins = ins;
	}

	@Column(name = "PAGE_TRAC", length = 1000)
	public String getPageTrac() {
		return this.pageTrac;
	}

	public void setPageTrac(String pageTrac) {
		this.pageTrac = pageTrac;
	}

	@Column(name = "UPD", precision = 1, scale = 0)
	public boolean isUpd() {
		return this.upd;
	}

	public void setUpd(boolean upd) {
		this.upd = upd;
	}

	@Column(name = "UTIL_TRAC", length = 120)
	public String getUtilTrac() {
		return this.utilTrac;
	}

	public void setUtilTrac(String utilTrac) {
		this.utilTrac = utilTrac;
	}

}
