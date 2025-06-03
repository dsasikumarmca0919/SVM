/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Rahul.Thennarasu
 */
public class Rs4 {

   
   @SerializedName("temp_bpmusergroupmapping_vessel_mbutil.groupcode")
   @Expose
   private String groupcode;
   @SerializedName("temp_bpmusergroupmapping_vessel_mbutil.usercode")
   @Expose
   private String usercode;
   @SerializedName("temp_bpmusergroupmapping_vessel_mbutil.vslcompcode")
   @Expose
   private String vslcompcode;
   @SerializedName("temp_bpmusergroupmapping_vessel_mbutil.roltype")
   @Expose
   private String roltype;


   public String getGroupcode() {
      return this.groupcode;
   }

   public void setGroupcode(String groupcode) {
      this.groupcode = groupcode;
   }

   public String getUsercode() {
      return this.usercode;
   }

   public void setUsercode(String usercode) {
      this.usercode = usercode;
   }

   public String getVslcompcode() {
      return this.vslcompcode;
   }

   public void setVslcompcode(String vslcompcode) {
      this.vslcompcode = vslcompcode;
   }

   public String getRoltype() {
      return this.roltype;
   }

   public void setRoltype(String roltype) {
      this.roltype = roltype;
   }


}
