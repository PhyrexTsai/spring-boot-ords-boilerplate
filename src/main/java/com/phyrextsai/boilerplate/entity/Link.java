package com.phyrextsai.boilerplate.entity;

public class Link {
  private String rel;
  private String href;

  public String getRel() {
    return rel;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }
  
}
