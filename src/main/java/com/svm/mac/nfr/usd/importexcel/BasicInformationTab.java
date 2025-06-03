package com.svm.mac.nfr.usd.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author praveen s
 */
public class BasicInformationTab implements java.io.Serializable {

    //1
    @NotNull(message = "This field is required")
    @SerializedName("empcode")
    @Expose
    private String empcode;
    //2
    @NotNull(message = "This field is required")
    @SerializedName("epassword")
    @Expose
    private String epassword;

    //3
    @NotNull(message = "This field is required")
    String txtConfirmPassword;

    //4
    @NotNull(message = "This field is required")
    @SerializedName("empname")
    @Expose
    private String empname;

    //5
    @NotNull(message = "This field is required")
    @SerializedName("surname")
    @Expose
    private String surname;

    //6
    @NotNull(message = "This field is required")
    @SerializedName("cntrltype")
    @Expose
    private String cntrltype;

    //7
    @SerializedName("doj")
    @Expose
    private String txtDateOfJoining;

    //8
    @NotNull(message = "Gender is required")
    @SerializedName("gender")
    @Expose
    private String gender;

    //9
    @NotNull(message = "This field is required")
    @SerializedName("nationality")
    @Expose
    private String nationality;

    //10
    @NotNull(message = "This field is required")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "This is not a valid email")
    @SerializedName("email")
    @Expose
    private String email;

    //11
    @NotNull(message = "This field is required")
    @SerializedName("dateofbirth")
    @Expose
    private String txtDateOfBirth;

    //12
    @NotNull(message = "This field is required")
    @SerializedName("usertype")
    @Expose
    private String usertype;

    //13
    @NotNull(message = "This field is required")
    @SerializedName("companycode")
    @Expose
    private String companycode;

    //14
    @NotNull(message = "This field is required")
    @SerializedName("rankcode")
    @Expose
    private String rankcode;

    //15
    @SerializedName("dateformat")
    @Expose
    private String dateformat;

    //16
    @NotNull(message = "This field is required")
    @SerializedName("manningoffice")
    @Expose
    private String manningoffice;

    //17
    @SerializedName("userlocation")
    @Expose
    private String userlocation;

    //18
    @SerializedName("application")
    @Expose
    private String application;

    //19
    @SerializedName("isadmin")
    @Expose
    private String isadmin;

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCntrltype() {
        return cntrltype;
    }

    public void setCntrltype(String cntrltype) {
        this.cntrltype = cntrltype;
    }

    public String getTxtDateOfJoining() {
        return txtDateOfJoining;
    }

    public void setTxtDateOfJoining(String txtDateOfJoining) {
        this.txtDateOfJoining = txtDateOfJoining;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public void setTxtDateOfBirth(String txtDateOfBirth) {
        this.txtDateOfBirth = txtDateOfBirth;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getRankcode() {
        return rankcode;
    }

    public void setRankcode(String rankcode) {
        this.rankcode = rankcode;
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getManningoffice() {
        return manningoffice;
    }

    public void setManningoffice(String manningoffice) {
        this.manningoffice = manningoffice;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

}
