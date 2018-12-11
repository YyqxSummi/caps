package sg.iss.caps.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lecturercourse database table.
 * 
 */
@Embeddable
public class LecturercoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String lecturerID;

	@Column(insertable=false, updatable=false)
	private String courseIndex;

	public LecturercoursePK() {
	}
	public String getLecturerID() {
		return this.lecturerID;
	}
	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}
	public String getCourseIndex() {
		return this.courseIndex;
	}
	public void setCourseIndex(String courseIndex) {
		this.courseIndex = courseIndex;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LecturercoursePK)) {
			return false;
		}
		LecturercoursePK castOther = (LecturercoursePK)other;
		return 
			this.lecturerID.equals(castOther.lecturerID)
			&& this.courseIndex.equals(castOther.courseIndex);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.lecturerID.hashCode();
		hash = hash * prime + this.courseIndex.hashCode();
		
		return hash;
	}
}