package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author praveen s
 */
public class ManagmentResourceTab implements Serializable {

    // 1
    @SerializedName("superintendent")
    @Expose
    private String superintendent;

    // 2
    @NotNull(message = "FleetGM is required")
    @SerializedName("fleetgm")
    @Expose
    private String fleetgm;

    // 3
    @NotNull(message = "Second Backup SI is required")
    @SerializedName("second_backup_si")
    @Expose
    private String secondBackupSI;

    // 4
    @NotNull(message = "Hseq Manager is required")
    @SerializedName("hseq_manager")
    @Expose
    private String hseqManager;

    // 5
    @SerializedName("marine_operation_manager")
    @Expose
    private String marineOperationManager;

    //6
    @SerializedName("accountant")
    @Expose
    private String accountant;

    // 7
    @SerializedName("crew_incharge")
    @Expose
    private String crewInCharge;

    // 8
    @SerializedName("startdatesuperintendent")
    @Expose
    private String startdatesuperintendent;

    // 9
    @NotNull(message = "FleetManager is required")
    @SerializedName("fleetmanager")
    @Expose
    private String fleetmanager;

    // 10
    @NotNull(message = "First Backup SI is required")
    @SerializedName("first_backup_si")
    @Expose
    private String firstBackupSI;

    // 11
    @NotNull(message = "Hseq Superintendent is required")
    @SerializedName("hseq_superintendent")
    @Expose
    private String hseqSuperintendant;

    // 12
    @SerializedName("marine_operation_si")
    @Expose
    private String marineOperationSI;

    // 13
    @SerializedName("purchaseunit")
    @Expose
    private String purchaseunit;

    // 14
    @SerializedName("purchaser")
    @Expose
    private String purchaser;

    // 15
    @SerializedName("invoicername")
    @Expose
    private String invoicername;

    public String getSuperintendent() {
        return superintendent;
    }

    public void setSuperintendent(String superintendent) {
        this.superintendent = superintendent;
    }

    public String getFleetgm() {
        return fleetgm;
    }

    public void setFleetgm(String fleetgm) {
        this.fleetgm = fleetgm;
    }

    public String getSecondBackupSI() {
        return secondBackupSI;
    }

    public void setSecondBackupSI(String secondBackupSI) {
        this.secondBackupSI = secondBackupSI;
    }

    public String getHseqManager() {
        return hseqManager;
    }

    public void setHseqManager(String hseqManager) {
        this.hseqManager = hseqManager;
    }

    public String getMarineOperationManager() {
        return marineOperationManager;
    }

    public void setMarineOperationManager(String marineOperationManager) {
        this.marineOperationManager = marineOperationManager;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }

    public String getCrewInCharge() {
        return crewInCharge;
    }

    public void setCrewInCharge(String crewInCharge) {
        this.crewInCharge = crewInCharge;
    }

    public String getStartdatesuperintendent() {
        return startdatesuperintendent;
    }

    public void setStartdatesuperintendent(String startdatesuperintendent) {
        this.startdatesuperintendent = startdatesuperintendent;
    }

    public String getFleetmanager() {
        return fleetmanager;
    }

    public void setFleetmanager(String fleetmanager) {
        this.fleetmanager = fleetmanager;
    }

    public String getFirstBackupSI() {
        return firstBackupSI;
    }

    public void setFirstBackupSI(String firstBackupSI) {
        this.firstBackupSI = firstBackupSI;
    }

    public String getHseqSuperintendant() {
        return hseqSuperintendant;
    }

    public void setHseqSuperintendant(String hseqSuperintendant) {
        this.hseqSuperintendant = hseqSuperintendant;
    }

    public String getMarineOperationSI() {
        return marineOperationSI;
    }

    public void setMarineOperationSI(String marineOperationSI) {
        this.marineOperationSI = marineOperationSI;
    }

    public String getPurchaseunit() {
        return purchaseunit;
    }

    public void setPurchaseunit(String purchaseunit) {
        this.purchaseunit = purchaseunit;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getInvoicername() {
        return invoicername;
    }

    public void setInvoicername(String invoicername) {
        this.invoicername = invoicername;
    }

}
