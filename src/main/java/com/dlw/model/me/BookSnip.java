package com.dlw.model.me;

import com.dlw.model.BaseObject;

public class BookSnip extends BaseObject {

	private int referenceNo;
	private Book parent;
	private String notes;
	private int pageReference;
	private String projectReference;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Book getParent() {
		return parent;
	}

	public void setParent(Book parent) {
		this.parent = parent;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPageReference() {
		return pageReference;
	}

	public void setPageReference(int pageReference) {
		this.pageReference = pageReference;
	}

	public String getProjectReference() {
		return projectReference;
	}

	public void setProjectReference(String projectReference) {
		this.projectReference = projectReference;
	}
	

}
