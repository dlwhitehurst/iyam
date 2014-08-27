package com.dlw.model.me;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.dlw.model.BaseObject;

@Entity
@Table(name = "books")
@Indexed
@XmlRootElement
public class Book extends BaseObject implements Serializable {
	
	private Long id;
	private String title;
	private String authored;
	private String isbn;
	private int pages;
	private boolean own;
	private boolean borrowed;
	private Date read;
	private int readCounter; // how many times read
	

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

	/**
	 * @return the notes
	 */
    @Column(nullable = false, length = 255, unique = true)
    @Field
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the notes
	 */
    @Column(nullable = true, length = 255, unique = false)
    @Field
	public String getAuthored() {
		return authored;
	}

	public void setAuthored(String authored) {
		this.authored = authored;
	}

	/**
	 * @return the notes
	 */
    @Column(nullable = true, length = 80, unique = true)
    @Field
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "number_pages", nullable = true)
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Column(name = "own", nullable = false)
	public boolean isOwn() {
		return own;
	}

	public void setOwn(boolean own) {
		this.own = own;
	}

	@Column(name = "borrowed", nullable = false)	
	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	@Column(name = "date_read", nullable = true)	
	public Date getRead() {
		return read;
	}

	public void setRead(Date read) {
		this.read = read;
	}

	@Column(name = "times_read", nullable = true)
	public int getReadCounter() {
		return readCounter;
	}

	public void setReadCounter(int readCounter) {
		this.readCounter = readCounter;
	}

	/**
	 * @return the id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}
