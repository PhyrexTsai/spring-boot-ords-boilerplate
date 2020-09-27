package com.phyrextsai.boilerplate.entity;

import java.util.List;

public class CollectionItem {
  private List items;
  private Boolean hasMore;
  private Integer limit;
  private Integer offset;
  private Integer count;
  private List<Link> links;

  public List getItems() {
    return items;
  }

  public void setItems(List items) {
    this.items = items;
  }

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Boolean getHasMore() {
    return hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
  
}
