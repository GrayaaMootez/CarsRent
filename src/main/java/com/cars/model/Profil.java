package com.cars.model;
// Generated 15 juin 2018 16:18:35 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profil generated by hbm2java
 */
@Entity
@Table(name = "PROFIL")
public class Profil implements java.io.Serializable {

	private long codeProfil;
	private String libProfil;
	private String pageTrac;
	private String utilTrac;
	private Set<ProfilMenuTree> profilMenuTrees = new HashSet<ProfilMenuTree>(0);
	private Set<UsrProfilUtil> usrProfilUtils = new HashSet<UsrProfilUtil>(0);

	public Profil() {
	}

	public Profil(long codeProfil) {
		this.codeProfil = codeProfil;
	}

	public Profil(long codeProfil, String libProfil, String pageTrac, String utilTrac,
			Set<ProfilMenuTree> profilMenuTrees, Set<UsrProfilUtil> usrProfilUtils) {
		this.codeProfil = codeProfil;
		this.libProfil = libProfil;
		this.pageTrac = pageTrac;
		this.utilTrac = utilTrac;
		this.profilMenuTrees = profilMenuTrees;
		this.usrProfilUtils = usrProfilUtils;
	}

	@Id

	@Column(name = "CODE_PROFIL", unique = true, nullable = false, scale = 0)
	public long getCodeProfil() {
		return this.codeProfil;
	}

	public void setCodeProfil(long codeProfil) {
		this.codeProfil = codeProfil;
	}

	@Column(name = "LIB_PROFIL", length = 800)
	public String getLibProfil() {
		return this.libProfil;
	}

	public void setLibProfil(String libProfil) {
		this.libProfil = libProfil;
	}

	@Column(name = "PAGE_TRAC", length = 1000)
	public String getPageTrac() {
		return this.pageTrac;
	}

	public void setPageTrac(String pageTrac) {
		this.pageTrac = pageTrac;
	}

	@Column(name = "UTIL_TRAC", length = 120)
	public String getUtilTrac() {
		return this.utilTrac;
	}

	public void setUtilTrac(String utilTrac) {
		this.utilTrac = utilTrac;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<ProfilMenuTree> getProfilMenuTrees() {
		return this.profilMenuTrees;
	}

	public void setProfilMenuTrees(Set<ProfilMenuTree> profilMenuTrees) {
		this.profilMenuTrees = profilMenuTrees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<UsrProfilUtil> getUsrProfilUtils() {
		return this.usrProfilUtils;
	}

	public void setUsrProfilUtils(Set<UsrProfilUtil> usrProfilUtils) {
		this.usrProfilUtils = usrProfilUtils;
	}

}
