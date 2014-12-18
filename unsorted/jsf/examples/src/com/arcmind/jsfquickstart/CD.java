/*
 * Created on May 16, 2004
 *
 */
package com.arcmind.jsfquickstart;

/**
 * @author Richard Hightower
 *
 */
public class CD implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String artist;
	private float price;
	
	public CD(){
		
	}
	
	public CD(String title, String artist, float price){
		this.title=title;
		this.artist=artist;
		this.price=price;
	}
	
	/**
	 * @return Returns the artist.
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist The artist to set.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return Returns the price.
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price The price to set.
	 */
	public void setPrice(float aPrice) {
		this.price = aPrice;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}