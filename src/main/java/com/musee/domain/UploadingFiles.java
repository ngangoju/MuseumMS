package com.musee.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UploadingFiles")
@NamedQuery(name = "UploadingFiles.findAll", query = "SELECT r FROM UploadingFiles r order by v desc")
public class UploadingFiles extends CommonDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "upLoadId")
	private long upLoadId;
	@OneToOne
	@JoinColumn(name = "documents")
	private Documents documents;
	@ManyToOne
	@JoinColumn(name = "user")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "artifact")
	private Artifact artifact;
	@ManyToOne
	@JoinColumn(name = "artifactCategory")
	private ArtifactCategory artifactCategory;
	
	
	public long getUpLoadId() {
		return upLoadId;
	}

	public void setUpLoadId(long upLoadId) {
		this.upLoadId = upLoadId;
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

	public ArtifactCategory getArtifactCategory() {
		return artifactCategory;
	}

	public void setArtifactCategory(ArtifactCategory artifactCategory) {
		this.artifactCategory = artifactCategory;
	}

}