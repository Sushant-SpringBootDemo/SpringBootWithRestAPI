package com.zensar.model;
public class User {
  private int UserId;
  private int Id;
  private String Title;
  private String Body;


 // Getter Methods 

  public float getUserId() {
    return UserId;
  }

  public float getId() {
    return Id;
  }

  public String getTitle() {
    return Title;
  }

  public String getBody() {
    return Body;
  }

 // Setter Methods 

  public void setUserId(int UserId ) {
    this.UserId = UserId;
  }

  public void setId(int Id ) {
    this.Id = Id;
  }

  public void setTitle( String Title ) {
    this.Title = Title;
  }

  public void setBody( String Body ) {
    this.Body = Body;
  }
}