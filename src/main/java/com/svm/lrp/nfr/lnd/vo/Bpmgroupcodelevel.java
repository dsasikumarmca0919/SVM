package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Bpmgroupcodelevel implements Serializable {
  @SerializedName("groupcode")
  @Expose
  private String groupcode;
  
  private String usercode;
  
  @SerializedName("level")
  @Expose
  private int level;
  
  public String getGroupcode() {
    return this.groupcode;
  }
  
  public void setGroupcode(String groupcode) {
    this.groupcode = groupcode;
  }
  
  public int getLevel() {
    return this.level;
  }
  
  public void setLevel(int level) {
    this.level = level;
  }
  
  public String getUsercode() {
    return this.usercode;
  }
  
  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }
  
  public String toString() {
    return getClass().getName() + "@    groupcode   @" + this.groupcode + "@   level   @" + this.level;
  }
}
