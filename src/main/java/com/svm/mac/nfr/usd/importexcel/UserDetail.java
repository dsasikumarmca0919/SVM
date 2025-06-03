/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.mac.nfr.usd.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/**
 *
 * @author d.manikandan
 */
public class UserDetail {

    @NotNull(message = "This field is required")
    @SerializedName("empcode")
    @Expose
    private String empcode;

    @NotNull(message = "This field is required")
    @SerializedName("epassword")
    @Expose
    private String epassword;

    @NotNull(message = "This field is required")
    String txtConfirmPassword;

    @NotNull(message = "This field is required")
    @SerializedName("empname")
    @Expose
    private String empname;

    @NotNull(message = "This field is required")
    @SerializedName("surname")
    @Expose
    private String surname;

    @NotNull(message = "This field is required")
    @SerializedName("cntrltype")
    @Expose
    private String cntrltype;

    @NotNull(message = "Gender is required")
    @SerializedName("gender")
    @Expose
    private String gender;

    @NotNull(message = "Employeement Date  required")
    Date txtDateOfJoining;

    @NotNull(message = "This field is required")
    @SerializedName("nationality")
    @Expose
    private String nationality;

    @NotNull(message = "This field is required")
    @SerializedName("usertype")
    @Expose
    private String usertype;

    @NotNull(message = "Date of birth is required")
    @Past
    Date txtDateOfBirth;

    @NotNull(message = "This field is required")
    @SerializedName("manningoffice")
    @Expose
    private String manningoffice;

//    @Size(min = 1, max = 15, message = "Userlocation is required")
    @NotNull(message = "This field is required")
    @SerializedName("userlocation")
    @Expose
    private String userlocation;

    @NotNull(message = "This field is required")
    @SerializedName("rankcode")
    @Expose
    private String rankcode;

    @NotNull(message = "This field is required")
    @SerializedName("companycode")
    @Expose
    private String companycode;

    @NotNull(message = "This field is required")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "This is not a valid email")
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("passportexpiry")
    @Expose
    private String passportexpiry;

    @SerializedName("telephonenumber")
    @Expose
    private String telephonenumber;

    @SerializedName("us_visa_expiry")
    @Expose
    private String us_visa_expiry;

    @SerializedName("flag_lic_expiry")
    @Expose
    private String flag_lic_expiry;

    @SerializedName("loginexpiry")
    @Expose
    private String loginexpiry;

    @SerializedName("gmdss_goc_number")
    @Expose
    private String gmdss_goc_number;

    @SerializedName("contract_expiry")
    @Expose
    private String contract_expiry;

    @SerializedName("gmdss_goc_expiry")
    @Expose
    private String gmdss_goc_expiry;

    @SerializedName("half_appraisal")
    @Expose
    private String half_appraisal;

    @SerializedName("usercode")
    @Expose
    private String usercode;

    @SerializedName("tenant")
    @Expose
    private String tenant;

    @SerializedName("dateofbirth")
    @Expose
    private String dateofbirth;

    @SerializedName("final_appraisal")
    @Expose
    private String final_appraisal;

    @SerializedName("half_appraisal_comp")
    @Expose
    private String half_appraisal_comp;

    @SerializedName("placeofbirth")
    @Expose
    private String placeofbirth;

    @SerializedName("passportnumber")
    @Expose
    private String passportnumber;

    @SerializedName("zipcode")
    @Expose
    private String zipcode;

    @SerializedName("flag_lic_number")
    @Expose
    private String flag_lic_number;

    @SerializedName("preferredtimezone")
    @Expose
    private String preferredtimezone;

    @SerializedName("doj")
    @Expose
    private String doj;

    @SerializedName("mobilenumber")
    @Expose
    private String mobilenumber;

    @SerializedName("mediccert_expiry")
    @Expose
    private String mediccert_expiry;

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("mediccert_issued")
    @Expose
    private String mediccert_issued;

    @SerializedName("seamans_expiry")
    @Expose
    private String seamans_expiry;

    @SerializedName("isadmin")
    @Expose
    private String isadmin;

    @SerializedName("cruser")
    @Expose
    private String cruser;

    @SerializedName("final_appraisal_comp")
    @Expose
    private String final_appraisal_comp;

    @SerializedName("emergencycontactnumber")
    @Expose
    private String emergencycontactnumber;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("seamans_number")
    @Expose
    private String seamans_number;

    @SerializedName("flag_dce_expiry")
    @Expose
    private String flag_dce_expiry;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("application")
    @Expose
    private String application;

    @SerializedName("crdate")
    @Expose
    private String crdate;

    @SerializedName("upduser")
    @Expose
    private String upduser;

    @NotNull(message = "This field is required")
    @SerializedName("dateformat")
    @Expose
    private String dateformat;

    @SerializedName("remarks")
    @Expose
    private String remarks;

    private int srNo = 0;
    private String vesselcode;
    private String rankname;
    private String deptname;
    private String countryname;
    private String vesselname;
    private String portname;
    private String portcode;
    private String singn_on_date;
    private String singn_off_date;

    Date txtPassportExpiry;
    Date txtMedCerIssued;
    Date txtMedCerExpiry;
    Date txtFlagLicExpiry;
    Date txtUSVisaExpiry;
    Date txtFlagDCEExpiry;
    Date txtFlagSeaBookExpiry;
    Date txtFlagGMDSSExpiry;
    Date txtFinalApp;
    Date txtHalfApp;
    Date txtEmpContractExpiry;
    Date txtCrDate;
    Date updDate;
    boolean txtFinalAppCom;
    boolean txtHalfAppCom;

    public String getVesselname() {
        return vesselname;
    }

    public void setVesselname(String vesselname) {
        this.vesselname = vesselname;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public String getSingn_on_date() {
        return singn_on_date;
    }

    public void setSingn_on_date(String singn_on_date) {
        this.singn_on_date = singn_on_date;
    }

    public String getSingn_off_date() {
        return singn_off_date;
    }

    public void setSingn_off_date(String singn_off_date) {
        this.singn_off_date = singn_off_date;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public boolean isTxtFinalAppCom() {
        return txtFinalAppCom;
    }

    public void setTxtFinalAppCom(boolean txtFinalAppCom) {
        this.txtFinalAppCom = txtFinalAppCom;
    }

    public boolean isTxtHalfAppCom() {
        return txtHalfAppCom;
    }

    public void setTxtHalfAppCom(boolean txtHalfAppCom) {
        this.txtHalfAppCom = txtHalfAppCom;
    }

    public Date getTxtDateOfJoining() {
        return txtDateOfJoining;
    }

    public void setTxtDateOfJoining(Date txtDateOfJoining) {
        this.txtDateOfJoining = txtDateOfJoining;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public Date getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public void setTxtDateOfBirth(Date txtDateOfBirth) {
        this.txtDateOfBirth = txtDateOfBirth;
    }

    public Date getTxtPassportExpiry() {
        return txtPassportExpiry;
    }

    public void setTxtPassportExpiry(Date txtPassportExpiry) {
        this.txtPassportExpiry = txtPassportExpiry;
    }

    public Date getTxtMedCerIssued() {
        return txtMedCerIssued;
    }

    public void setTxtMedCerIssued(Date txtMedCerIssued) {
        this.txtMedCerIssued = txtMedCerIssued;
    }

    public Date getTxtMedCerExpiry() {
        return txtMedCerExpiry;
    }

    public void setTxtMedCerExpiry(Date txtMedCerExpiry) {
        this.txtMedCerExpiry = txtMedCerExpiry;
    }

    public Date getTxtFlagLicExpiry() {
        return txtFlagLicExpiry;
    }

    public void setTxtFlagLicExpiry(Date txtFlagLicExpiry) {
        this.txtFlagLicExpiry = txtFlagLicExpiry;
    }

    public Date getTxtUSVisaExpiry() {
        return txtUSVisaExpiry;
    }

    public void setTxtUSVisaExpiry(Date txtUSVisaExpiry) {
        this.txtUSVisaExpiry = txtUSVisaExpiry;
    }

    public Date getTxtFlagDCEExpiry() {
        return txtFlagDCEExpiry;
    }

    public void setTxtFlagDCEExpiry(Date txtFlagDCEExpiry) {
        this.txtFlagDCEExpiry = txtFlagDCEExpiry;
    }

    public Date getTxtFlagSeaBookExpiry() {
        return txtFlagSeaBookExpiry;
    }

    public void setTxtFlagSeaBookExpiry(Date txtFlagSeaBookExpiry) {
        this.txtFlagSeaBookExpiry = txtFlagSeaBookExpiry;
    }

    public Date getTxtFlagGMDSSExpiry() {
        return txtFlagGMDSSExpiry;
    }

    public void setTxtFlagGMDSSExpiry(Date txtFlagGMDSSExpiry) {
        this.txtFlagGMDSSExpiry = txtFlagGMDSSExpiry;
    }

    public Date getTxtFinalApp() {
        return txtFinalApp;
    }

    public void setTxtFinalApp(Date txtFinalApp) {
        this.txtFinalApp = txtFinalApp;
    }

    public Date getTxtHalfApp() {
        return txtHalfApp;
    }

    public void setTxtHalfApp(Date txtHalfApp) {
        this.txtHalfApp = txtHalfApp;
    }

    public Date getTxtEmpContractExpiry() {
        return txtEmpContractExpiry;
    }

    public void setTxtEmpContractExpiry(Date txtEmpContractExpiry) {
        this.txtEmpContractExpiry = txtEmpContractExpiry;
    }

    public Date getTxtCrDate() {
        return txtCrDate;
    }

    public void setTxtCrDate(Date txtCrDate) {
        this.txtCrDate = txtCrDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getVesselcode() {
        return vesselcode;
    }

    public void setVesselcode(String vesselcode) {
        this.vesselcode = vesselcode;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getPassportexpiry() {
        return passportexpiry;
    }

    public void setPassportexpiry(String passportexpiry) {
        this.passportexpiry = passportexpiry;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getUs_visa_expiry() {
        return us_visa_expiry;
    }

    public void setUs_visa_expiry(String us_visa_expiry) {
        this.us_visa_expiry = us_visa_expiry;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getFlag_lic_expiry() {
        return flag_lic_expiry;
    }

    public void setFlag_lic_expiry(String flag_lic_expiry) {
        this.flag_lic_expiry = flag_lic_expiry;
    }

    public String getMediccert_expiry() {
        return mediccert_expiry;
    }

    public void setMediccert_expiry(String mediccert_expiry) {
        this.mediccert_expiry = mediccert_expiry;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getLoginexpiry() {
        return loginexpiry;
    }

    public void setLoginexpiry(String loginexpiry) {
        this.loginexpiry = loginexpiry;
    }

    public String getGmdss_goc_number() {
        return gmdss_goc_number;
    }

    public void setGmdss_goc_number(String gmdss_goc_number) {
        this.gmdss_goc_number = gmdss_goc_number;
    }

    public String getRankcode() {
        return rankcode;
    }

    public void setRankcode(String rankcode) {
        this.rankcode = rankcode;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getMediccert_issued() {
        return mediccert_issued;
    }

    public void setMediccert_issued(String mediccert_issued) {
        this.mediccert_issued = mediccert_issued;
    }

    public String getContract_expiry() {
        return contract_expiry;
    }

    public void setContract_expiry(String contract_expiry) {
        this.contract_expiry = contract_expiry;
    }

    public String getGmdss_goc_expiry() {
        return gmdss_goc_expiry;
    }

    public void setGmdss_goc_expiry(String gmdss_goc_expiry) {
        this.gmdss_goc_expiry = gmdss_goc_expiry;
    }

    public String getSeamans_expiry() {
        return seamans_expiry;
    }

    public void setSeamans_expiry(String seamans_expiry) {
        this.seamans_expiry = seamans_expiry;
    }

    public String getHalf_appraisal() {
        return half_appraisal;
    }

    public void setHalf_appraisal(String half_appraisal) {
        this.half_appraisal = half_appraisal;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getFinal_appraisal_comp() {
        return final_appraisal_comp;
    }

    public void setFinal_appraisal_comp(String final_appraisal_comp) {
        this.final_appraisal_comp = final_appraisal_comp;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getStringofbirth() {
        return dateofbirth;
    }

    public void setStringofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmergencycontactnumber() {
        return emergencycontactnumber;
    }

    public void setEmergencycontactnumber(String emergencycontactnumber) {
        this.emergencycontactnumber = emergencycontactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFinal_appraisal() {
        return final_appraisal;
    }

    public void setFinal_appraisal(String final_appraisal) {
        this.final_appraisal = final_appraisal;
    }

    public String getCntrltype() {
        return cntrltype;
    }

    public void setCntrltype(String cntrltype) {
        this.cntrltype = cntrltype;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getHalf_appraisal_comp() {
        return half_appraisal_comp;
    }

    public void setHalf_appraisal_comp(String half_appraisal_comp) {
        this.half_appraisal_comp = half_appraisal_comp;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getSeamans_number() {
        return seamans_number;
    }

    public void setSeamans_number(String seamans_number) {
        this.seamans_number = seamans_number;
    }

    public String getFlag_dce_expiry() {
        return flag_dce_expiry;
    }

    public void setFlag_dce_expiry(String flag_dce_expiry) {
        this.flag_dce_expiry = flag_dce_expiry;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFlag_lic_number() {
        return flag_lic_number;
    }

    public void setFlag_lic_number(String flag_lic_number) {
        this.flag_lic_number = flag_lic_number;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getPreferredtimezone() {
        return preferredtimezone;
    }

    public void setPreferredtimezone(String preferredtimezone) {
        this.preferredtimezone = preferredtimezone;
    }

    public String getCrdate() {
        return crdate;
    }

    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getStringformat() {
        return dateformat;
    }

    public void setStringformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getManningoffice() {
        return manningoffice;
    }

    public void setManningoffice(String manningoffice) {
        this.manningoffice = manningoffice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
