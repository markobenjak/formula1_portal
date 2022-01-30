package com.protal.portal.Responses;

import java.util.List;

public class SocialMediaResponse {
  private List<String> urls;


  public SocialMediaResponse(List<String> urls) {
    this.urls = urls;
  }

  public List<String> getUrls() {
    return urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = urls;
  }
}
