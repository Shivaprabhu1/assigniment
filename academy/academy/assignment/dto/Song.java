package org.academy.assignment.dto;

public class Song {
	private int id;
	private String author;
	private String description;
	private String fullLyrics;
	private String name;
	private String singer;

	public Song() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFullLyrics(String fullLyrics) {
		this.fullLyrics = fullLyrics;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Song(int id, String author, String description, String fullLyrics, String name, String singer) {
		super();
		this.id = id;
		this.author = author;
		this.description = description;
		this.fullLyrics = fullLyrics;
		this.name = name;
		this.singer = singer;
	}

	public int  getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public String getFullLyrics() {
		return fullLyrics;
	}

	public String getName() {
		return name;
	}

	public String getSinger() {
		return singer;
	}

}
