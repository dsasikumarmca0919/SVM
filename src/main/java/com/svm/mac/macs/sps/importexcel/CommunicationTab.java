package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;
import javax.validation.constraints.Pattern;

/**
 *
 * @author praveen s
 */
public class CommunicationTab implements Serializable {

    // 1
    @SerializedName("mmsino")
    @Expose
    private Integer mmsino;

    // 2
    @SerializedName("aatdhldigits")
    @Expose
    private String aatdhldigits;

    // 3
    @SerializedName("sat_cid")
    @Expose
    private String satCID;

    // 4
    @SerializedName("cellphone")
    @Expose
    private String cellphone;

    // 5
    @SerializedName("iridiumphone")
    @Expose
    private String iridiumphone;

    // 6
    @NotNull(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "This is not a valid email")
    @SerializedName("sat_email")
    @Expose
    private String satEmail;

    // 7
    @SerializedName("sat_telex")
    @Expose
    private String satTelex;
    
    @SerializedName("sat_voice")
    @Expose
    private String satVoice;

    // 88
    @SerializedName("sat_fax")
    @Expose
    private String satFax;

    // 89
    @SerializedName("sat_data")
    @Expose
    private String satData;

    // 90
    @SerializedName("sat_hsd")
    @Expose
    private String satHSD;

    public String getSatVoice() {
        return satVoice;
    }

    public void setSatVoice(String satVoice) {
        this.satVoice = satVoice;
    }

    public String getSatFax() {
        return satFax;
    }

    public void setSatFax(String satFax) {
        this.satFax = satFax;
    }

    public String getSatData() {
        return satData;
    }

    public void setSatData(String satData) {
        this.satData = satData;
    }

    public String getSatHSD() {
        return satHSD;
    }

    public void setSatHSD(String satHSD) {
        this.satHSD = satHSD;
    }
    
    

    public Integer getMmsino() {
        return mmsino;
    }

    public void setMmsino(Integer mmsino) {
        this.mmsino = mmsino;
    }

    public String getAatdhldigits() {
        return aatdhldigits;
    }

    public void setAatdhldigits(String aatdhldigits) {
        this.aatdhldigits = aatdhldigits;
    }

    public String getSatCID() {
        return satCID;
    }

    public void setSatCID(String satCID) {
        this.satCID = satCID;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIridiumphone() {
        return iridiumphone;
    }

    public void setIridiumphone(String iridiumphone) {
        this.iridiumphone = iridiumphone;
    }

    public String getSatEmail() {
        return satEmail;
    }

    public void setSatEmail(String satEmail) {
        this.satEmail = satEmail;
    }

    public String getSatTelex() {
        return satTelex;
    }

    public void setSatTelex(String satTelex) {
        this.satTelex = satTelex;
    }

}
