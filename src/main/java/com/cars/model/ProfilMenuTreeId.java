package com.cars.model;
// Generated 15 juin 2018 16:18:35 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProfilMenuTreeId generated by hbm2java
 */
@Embeddable
public class ProfilMenuTreeId implements java.io.Serializable {

	private long codeProfil;
	private long menuId;

	public ProfilMenuTreeId() {
	}

	public ProfilMenuTreeId(long codeProfil, long menuId) {
		this.codeProfil = codeProfil;
		this.menuId = menuId;
	}

	@Column(name = "CODE_PROFIL", nullable = false, scale = 0)
	public long getCodeProfil() {
		return this.codeProfil;
	}

	public void setCodeProfil(long codeProfil) {
		this.codeProfil = codeProfil;
	}

	@Column(name = "MENU_ID", nullable = false, scale = 0)
	public long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProfilMenuTreeId))
			return false;
		ProfilMenuTreeId castOther = (ProfilMenuTreeId) other;

		return (this.getCodeProfil() == castOther.getCodeProfil()) && (this.getMenuId() == castOther.getMenuId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getCodeProfil();
		result = 37 * result + (int) this.getMenuId();
		return result;
	}

}
