package com.svm.mac.nfr.usd.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.mac.macs.sps.importexcel.CommunicationTab;
import com.svm.mac.macs.sps.importexcel.DimensionDetailsTab;
import com.svm.mac.macs.sps.importexcel.MachineryDetailsTab;
import com.svm.mac.macs.sps.importexcel.ManagmentResourceTab;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praveen s
 */
public class FinalModel implements java.io.Serializable {

    @SerializedName("BasicInformationTab")
    @Expose
    List<BasicInformationTab> userDetsilBasicInfoImptList = new ArrayList();

    @SerializedName("DetailedInformationTab")
    @Expose
    List<DetailedInformationTab> userDetailInfoImptList = new ArrayList();

    @SerializedName("BasicInformationTabSPS")
    @Expose
    List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> vslMstrBasInfoImptList = new ArrayList();

    @SerializedName("DetailedInformationTabSPS")
    @Expose
    List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> vslMstrDetInfoImptList = new ArrayList();

    @SerializedName("DimensionDetailsTab")
    @Expose
    List<DimensionDetailsTab> vslMstrDimDetImptList = new ArrayList();

    @SerializedName("ManagmentResourceTab")
    @Expose
    List<ManagmentResourceTab> vslMstrMngtRsImptList = new ArrayList();

    @SerializedName("MachineryDetailsTab")
    @Expose
    List<MachineryDetailsTab> vslMstrMcDetImptList = new ArrayList();

    @SerializedName("CommunicationTab")
    @Expose
    List<CommunicationTab> vslMstrCommImptList = new ArrayList();

    public List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> getVslMstrBasInfoImptList() {
        return vslMstrBasInfoImptList;
    }

    public void setVslMstrBasInfoImptList(List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> vslMstrBasInfoImptList) {
        this.vslMstrBasInfoImptList = vslMstrBasInfoImptList;
    }

    public List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> getVslMstrDetInfoImptList() {
        return vslMstrDetInfoImptList;
    }

    public void setVslMstrDetInfoImptList(List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> vslMstrDetInfoImptList) {
        this.vslMstrDetInfoImptList = vslMstrDetInfoImptList;
    }

    public List<DimensionDetailsTab> getVslMstrDimDetImptList() {
        return vslMstrDimDetImptList;
    }

    public void setVslMstrDimDetImptList(List<DimensionDetailsTab> vslMstrDimDetImptList) {
        this.vslMstrDimDetImptList = vslMstrDimDetImptList;
    }

    public List<ManagmentResourceTab> getVslMstrMngtRsImptList() {
        return vslMstrMngtRsImptList;
    }

    public void setVslMstrMngtRsImptList(List<ManagmentResourceTab> vslMstrMngtRsImptList) {
        this.vslMstrMngtRsImptList = vslMstrMngtRsImptList;
    }

    public List<MachineryDetailsTab> getVslMstrMcDetImptList() {
        return vslMstrMcDetImptList;
    }

    public void setVslMstrMcDetImptList(List<MachineryDetailsTab> vslMstrMcDetImptList) {
        this.vslMstrMcDetImptList = vslMstrMcDetImptList;
    }

    public List<CommunicationTab> getVslMstrCommImptList() {
        return vslMstrCommImptList;
    }

    public void setVslMstrCommImptList(List<CommunicationTab> vslMstrCommImptList) {
        this.vslMstrCommImptList = vslMstrCommImptList;
    }

    public List<BasicInformationTab> getUserDetsilBasicInfoImptList() {
        return userDetsilBasicInfoImptList;
    }

    public void setUserDetsilBasicInfoImptList(List<BasicInformationTab> userDetsilBasicInfoImptList) {
        this.userDetsilBasicInfoImptList = userDetsilBasicInfoImptList;
    }

    public List<DetailedInformationTab> getUserDetailInfoImptList() {
        return userDetailInfoImptList;
    }

    public void setUserDetailInfoImptList(List<DetailedInformationTab> userDetailInfoImptList) {
        this.userDetailInfoImptList = userDetailInfoImptList;
    }

}
