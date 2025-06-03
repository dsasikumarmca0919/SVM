package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author praveen s
 */
public class DetailedInformationTabSPS implements Serializable {

    // 1
    @NotNull(message = "Insurence Hull Machineries is required")
    @SerializedName("insurance_hull")
    @Expose
    private String insurancehullmachineries;

    // 2
    @NotNull(message = "Insurence PI is required")
    @SerializedName("insurance_pi")
    @Expose
    private String insurancepi;

    // 3
    @SerializedName("startdatemanagement")
    @Expose
    private String startdatemanagement;

    //4
    @SerializedName("startdatetechmgmt")
    @Expose
    private String startdatetechmgmt;

    // 5
    @SerializedName("nextdrydockdate")
    @Expose
    private String nextdrydockdate;

    // 6
    @SerializedName("lastdrydockdate")
    @Expose
    private String lastdrydockdate;

    // 7
    @SerializedName("deliverydate")
    @Expose
    private String deliverydate;

    // 8
    @NotNull(message = "NameOfOwnerPrincipal is required")
    @SerializedName("name_owner")
    @Expose
    private String nameofownerprincipal;

    // 9
    @NotNull(message = "Owner IMO is required")
    @SerializedName("owner_imo")
    @Expose
    private String ownerIMO;

    // 10
    @NotNull(message = "Owner Address is required")
    @SerializedName("owner_address")
    @Expose
    private String ownerAddress;

    // 11
    @NotNull(message = "OwnerEmergencyName is required")
    @SerializedName("owner_emgname")
    @Expose
    private String ownerEmergencyName;

    // 12
    @NotNull(message = "OwnerEmergencyCantactNo is required")
    @SerializedName("owner_emgcontact")
    @Expose
    private String ownerEmergencyContactNumber;

    // 13
    @NotNull(message = "NameOfRegisteredOwner is required")
    @SerializedName("name_reg_owner")
    @Expose
    private String nameofregisteredowner;

    // 14
    @NotNull(message = "RegisteredOwnerIMO is required")
    @SerializedName("reg_owner_imo")
    @Expose
    private String registeredOwnerIMO;

    // 15
    @NotNull(message = "RegisteredOwnerAddress is required")
    @SerializedName("reg_owner_address")
    @Expose
    private String registeredOwnerAddress;

    // 16
    @NotNull(message = "RegisteredOwnerEmergencyName is required")
    @SerializedName("reg_owner_emgname")
    @Expose
    private String registeredOwnerEmergencyName;

    // 17
    @NotNull(message = "RegisteredOwnerEmergencyContactNo is required")
    @SerializedName("reg_owner_emgcontact")
    @Expose
    private String registeredOwnerEmergencyContactNumber;

    // 18
    @NotNull(message = "ActualOwner is required")
    @SerializedName("name_act_owner")
    @Expose
    private String actualprincipal;

    // 19
    @NotNull(message = "ActualOwnerIMO is required")
    @SerializedName("act_owner_imo")
    @Expose
    private String actualOwnerIMO;

    // 20
    @NotNull(message = "ActualOwnerAddress is required")
    @SerializedName("act_owner_address")
    @Expose
    private String actualOwnerAddress;

    // 21
    @NotNull(message = "ActualOwnerEmgName is required")
    @SerializedName("act_owner_emgname")
    @Expose
    private String actualOwnerEmergencyName;

    // 22
    @NotNull(message = "ActualOwnerEmgContactNo is required")
    @SerializedName("act_owner_emgcontact")
    @Expose
    private String actualOwnerEmergencyContactNumber;

    public String getInsurancehullmachineries() {
        return insurancehullmachineries;
    }

    public void setInsurancehullmachineries(String insurancehullmachineries) {
        this.insurancehullmachineries = insurancehullmachineries;
    }

    public String getInsurancepi() {
        return insurancepi;
    }

    public void setInsurancepi(String insurancepi) {
        this.insurancepi = insurancepi;
    }

    public String getStartdatemanagement() {
        return startdatemanagement;
    }

    public void setStartdatemanagement(String startdatemanagement) {
        this.startdatemanagement = startdatemanagement;
    }

    public String getStartdatetechmgmt() {
        return startdatetechmgmt;
    }

    public void setStartdatetechmgmt(String startdatetechmgmt) {
        this.startdatetechmgmt = startdatetechmgmt;
    }

    public String getNextdrydockdate() {
        return nextdrydockdate;
    }

    public void setNextdrydockdate(String nextdrydockdate) {
        this.nextdrydockdate = nextdrydockdate;
    }

    public String getLastdrydockdate() {
        return lastdrydockdate;
    }

    public void setLastdrydockdate(String lastdrydockdate) {
        this.lastdrydockdate = lastdrydockdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getNameofownerprincipal() {
        return nameofownerprincipal;
    }

    public void setNameofownerprincipal(String nameofownerprincipal) {
        this.nameofownerprincipal = nameofownerprincipal;
    }

    public String getOwnerIMO() {
        return ownerIMO;
    }

    public void setOwnerIMO(String ownerIMO) {
        this.ownerIMO = ownerIMO;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerEmergencyName() {
        return ownerEmergencyName;
    }

    public void setOwnerEmergencyName(String ownerEmergencyName) {
        this.ownerEmergencyName = ownerEmergencyName;
    }

    public String getOwnerEmergencyContactNumber() {
        return ownerEmergencyContactNumber;
    }

    public void setOwnerEmergencyContactNumber(String ownerEmergencyContactNumber) {
        this.ownerEmergencyContactNumber = ownerEmergencyContactNumber;
    }

    public String getNameofregisteredowner() {
        return nameofregisteredowner;
    }

    public void setNameofregisteredowner(String nameofregisteredowner) {
        this.nameofregisteredowner = nameofregisteredowner;
    }

    public String getRegisteredOwnerIMO() {
        return registeredOwnerIMO;
    }

    public void setRegisteredOwnerIMO(String registeredOwnerIMO) {
        this.registeredOwnerIMO = registeredOwnerIMO;
    }

    public String getRegisteredOwnerAddress() {
        return registeredOwnerAddress;
    }

    public void setRegisteredOwnerAddress(String registeredOwnerAddress) {
        this.registeredOwnerAddress = registeredOwnerAddress;
    }

    public String getRegisteredOwnerEmergencyName() {
        return registeredOwnerEmergencyName;
    }

    public void setRegisteredOwnerEmergencyName(String registeredOwnerEmergencyName) {
        this.registeredOwnerEmergencyName = registeredOwnerEmergencyName;
    }

    public String getRegisteredOwnerEmergencyContactNumber() {
        return registeredOwnerEmergencyContactNumber;
    }

    public void setRegisteredOwnerEmergencyContactNumber(String registeredOwnerEmergencyContactNumber) {
        this.registeredOwnerEmergencyContactNumber = registeredOwnerEmergencyContactNumber;
    }

    public String getActualprincipal() {
        return actualprincipal;
    }

    public void setActualprincipal(String actualprincipal) {
        this.actualprincipal = actualprincipal;
    }

    public String getActualOwnerIMO() {
        return actualOwnerIMO;
    }

    public void setActualOwnerIMO(String actualOwnerIMO) {
        this.actualOwnerIMO = actualOwnerIMO;
    }

    public String getActualOwnerAddress() {
        return actualOwnerAddress;
    }

    public void setActualOwnerAddress(String actualOwnerAddress) {
        this.actualOwnerAddress = actualOwnerAddress;
    }

    public String getActualOwnerEmergencyName() {
        return actualOwnerEmergencyName;
    }

    public void setActualOwnerEmergencyName(String actualOwnerEmergencyName) {
        this.actualOwnerEmergencyName = actualOwnerEmergencyName;
    }

    public String getActualOwnerEmergencyContactNumber() {
        return actualOwnerEmergencyContactNumber;
    }

    public void setActualOwnerEmergencyContactNumber(String actualOwnerEmergencyContactNumber) {
        this.actualOwnerEmergencyContactNumber = actualOwnerEmergencyContactNumber;
    }

}
