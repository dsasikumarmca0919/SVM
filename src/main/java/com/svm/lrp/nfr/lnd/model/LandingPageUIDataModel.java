package com.svm.lrp.nfr.lnd.model;

import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import com.svm.lrp.nfr.jsf.utils.IDataModel;
import com.svm.lrp.nfr.lnd.vo.Uvs_userdetail;
import com.svm.lrp.nfr.lnd.vo.WidgetVo;
import com.svm.mac.macs.sps.importexcel.CommunicationTab;
import com.svm.mac.macs.sps.importexcel.DimensionDetailsTab;
import com.svm.mac.macs.sps.importexcel.MachineryDetailsTab;
import com.svm.mac.macs.sps.importexcel.ManagmentResourceTab;
import com.svm.mac.nfr.usd.importexcel.BasicInformationTab;
import com.svm.mac.nfr.usd.importexcel.DetailedInformationTab;
import com.svm.nfr.component.datatable.DefaultColumnModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.json.JSONObject;

public class LandingPageUIDataModel implements Serializable, IDataModel {

    String mdlId;
    private int sm_rowcount;
    private int sm_columncount;
    private List<List> sm_rowsLst;
    private List<List> filteredList;
    private List<List> rowsLstToExport = new ArrayList<>();
    private List<List> rowsLstFilteredrows = new ArrayList<>();
    private ArrayList sm_columnsLst;
    private ArrayList reoder_columnsLst;
    private String sm_title;
    private boolean sm_editBtnRender;
    private boolean sm_newBtnRender;
    boolean sm_saveBtnRender;
    boolean saveBtnRender = true;
    boolean UserImportExcelDis;
    boolean vesselImportExcelDis;
    private List<List> selectedRow;
    List tmpSelectedRow;
    int totalRows;
    //FOR IMPORT EXCEL
    List<BasicInformationTab> userDetBasicInfoListfromXcel;
    List<DetailedInformationTab> userDetailedInfoListfromXcel;

    //FOR IMPORT EXCEL
    List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> baseInfoListfromXcel;
    List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> detailedInfoListfromXcel;
    List<DimensionDetailsTab> dimensionDetInfoListFromxcel;
    List<ManagmentResourceTab> managmentResourceListFromxcel;
    List<MachineryDetailsTab> machineryDetListFromxcel;
    List<CommunicationTab> communicationListFromxcel;

    private ArrayList sm_spancolumnsLst;
    private ArrayList sm_spansubcolumnsLst;
    private ArrayList sm_allcolumnsLst;

//    ------------for button-----------------
    private ArrayList columnhearderbuttonlist;
    private int actioncolumnwidth;
    private String displayaction;
    private String filterdate;
    private Date dfilterdate;
//    -----------------------------

//    -----for filter---------------
    public String[] selectedradiobtn;
//    HashMap selectedradiobtn = new HashMap();
    private List selectedchkbox;
    private String fieldsetval;
    private ArrayList repeatradioallitems;
    public ArrayList daterepeatlist;
    private List chkboxallitems;
//    ------------------------------
    private String rowsPerPageTemplate = "10,20,30,50,100"; //SVMINTBUG-37476
    private int rows = 10;
    private String selectedexport;
    private ArrayList exportlist = new ArrayList();
    private String diaplay = "display:block";
    private String clearfilter = "";
    private String dateFormat = "";
    private List<Uvs_userdetail> userList = new ArrayList();
    private ArrayList columnTypeHmLst = new ArrayList();
    //
    List<Map<String, Object>> dynamicEntityMap = new ArrayList<Map<String, Object>>();
    List<Map<String, Object>> unhandleddynamicEntityMap = new ArrayList<Map<String, Object>>();
    Map<String, Object> selectedRowMap = new HashMap();
    private List<WidgetVo> widgetVolist = new ArrayList();
    private String userdateformat;
    private boolean includeOpenItems;
    private String modulename = "";
    String gridid = "";
    String secondgridid = "";
    private boolean openunhandledtable = false;
    private LinkedTreeMap nBPMconfig;
    private LinkedTreeMap nBPMconfigrecall;
    private LinkedTreeMap nonBPMRevokeRecallIdentifier;
    public List<DefaultColumnModel> nonbpmcolumnlist;
    public List<String> nonbpmValuelist;
    public List<Object> nonbpmSelectionList;
    Map nonBpmValueMap = new HashMap<String, Object>();
    List<String> revokeHeaders = new ArrayList<>();
    List<String> recallHeaders = new ArrayList<>();
    List<String> revokeValues = new ArrayList<>();
    List<String> recallValues = new ArrayList<>();
    String superEditRestrictorColumn;
    List<String> superEditRestrictorValues = new ArrayList<>();
    String nbpmheader;

    public LinkedTreeMap getNonBPMRevokeRecallIdentifier() {
        return nonBPMRevokeRecallIdentifier;
    }

    public void setNonBPMRevokeRecallIdentifier(LinkedTreeMap nonBPMRevokeRecallIdentifier) {
        this.nonBPMRevokeRecallIdentifier = nonBPMRevokeRecallIdentifier;
    }

    public LinkedTreeMap getnBPMconfigrecall() {
        return nBPMconfigrecall;
    }

    public void setnBPMconfigrecall(LinkedTreeMap nBPMconfigrecall) {
        this.nBPMconfigrecall = nBPMconfigrecall;
    }

    public boolean isOpenunhandledtable() {
        return openunhandledtable;
    }

    public void setOpenunhandledtable(boolean openunhandledtable) {
        this.openunhandledtable = openunhandledtable;
    }

    public List<Map<String, Object>> getUnhandleddynamicEntityMap() {
        return unhandleddynamicEntityMap;
    }

    public void setUnhandleddynamicEntityMap(List<Map<String, Object>> unhandleddynamicEntityMap) {
        this.unhandleddynamicEntityMap = unhandleddynamicEntityMap;
    }

    public String getSecondgridid() {
        return secondgridid;
    }

    public void setSecondgridid(String secondgridid) {
        this.secondgridid = secondgridid;
    }

    public String getGridid() {
        return gridid;
    }

    public void setGridid(String gridid) {
        this.gridid = gridid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public boolean isIncludeOpenItems() {
        return includeOpenItems;
    }

    public void setIncludeOpenItems(boolean includeOpenItems) {
        this.includeOpenItems = includeOpenItems;
    }

    public String getUserdateformat() {
        return userdateformat;
    }

    public void setUserdateformat(String userdateformat) {
        this.userdateformat = userdateformat;
    }

    public String getFilterdate() {
        return filterdate;
    }

    public void setFilterdate(String filterdate) {
        this.filterdate = filterdate;
    }

    public Date getDfilterdate() {
        return dfilterdate;
    }

    public void setDfilterdate(Date dfilterdate) {
        this.dfilterdate = dfilterdate;
    }

    public List<WidgetVo> getWidgetVolist() {
        return widgetVolist;
    }

    public void setWidgetVolist(List<WidgetVo> widgetVolist) {
        this.widgetVolist = widgetVolist;
    }

//    public List<HashMap> getDynamicEntityMap() {
//        return dynamicEntityMap;
//    }
//
//    public void setDynamicEntityMap(List<HashMap> dynamicEntityMap) {
//        this.dynamicEntityMap = dynamicEntityMap;
//    }
    public List<Map<String, Object>> getDynamicEntityMap() {
        return dynamicEntityMap;
    }

    public void setDynamicEntityMap(List<Map<String, Object>> dynamicEntityMap) {
        this.dynamicEntityMap = dynamicEntityMap;
    }

    //  
    public List<List> getRowsLstFilteredrows() {
        return rowsLstFilteredrows;
    }

    public void setRowsLstFilteredrows(List<List> rowsLstFilteredrows) {
        this.rowsLstFilteredrows = rowsLstFilteredrows;
    }

    public Map<String, Object> getSelectedRowMap() {
        return selectedRowMap;
    }

    public void setSelectedRowMap(Map<String, Object> selectedRowMap) {
        this.selectedRowMap = selectedRowMap;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public boolean isSaveBtnRender() {
        return saveBtnRender;
    }

    public void setSaveBtnRender(boolean saveBtnRender) {
        this.saveBtnRender = saveBtnRender;
    }

    public boolean isUserImportExcelDis() {
        return UserImportExcelDis;
    }

    public void setUserImportExcelDis(boolean UserImportExcelDis) {
        this.UserImportExcelDis = UserImportExcelDis;
    }

    public boolean isVesselImportExcelDis() {
        return vesselImportExcelDis;
    }

    public void setVesselImportExcelDis(boolean vesselImportExcelDis) {
        this.vesselImportExcelDis = vesselImportExcelDis;
    }

    public List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> getBaseInfoListfromXcel() {
        return baseInfoListfromXcel;
    }

    public void setBaseInfoListfromXcel(List<com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS> baseInfoListfromXcel) {
        this.baseInfoListfromXcel = baseInfoListfromXcel;
    }

    public List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> getDetailedInfoListfromXcel() {
        return detailedInfoListfromXcel;
    }

    public void setDetailedInfoListfromXcel(List<com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS> detailedInfoListfromXcel) {
        this.detailedInfoListfromXcel = detailedInfoListfromXcel;
    }

    public List<DimensionDetailsTab> getDimensionDetInfoListFromxcel() {
        return dimensionDetInfoListFromxcel;
    }

    public void setDimensionDetInfoListFromxcel(List<DimensionDetailsTab> dimensionDetInfoListFromxcel) {
        this.dimensionDetInfoListFromxcel = dimensionDetInfoListFromxcel;
    }

    public List<ManagmentResourceTab> getManagmentResourceListFromxcel() {
        return managmentResourceListFromxcel;
    }

    public void setManagmentResourceListFromxcel(List<ManagmentResourceTab> managmentResourceListFromxcel) {
        this.managmentResourceListFromxcel = managmentResourceListFromxcel;
    }

    public List<MachineryDetailsTab> getMachineryDetListFromxcel() {
        return machineryDetListFromxcel;
    }

    public void setMachineryDetListFromxcel(List<MachineryDetailsTab> machineryDetListFromxcel) {
        this.machineryDetListFromxcel = machineryDetListFromxcel;
    }

    public List<CommunicationTab> getCommunicationListFromxcel() {
        return communicationListFromxcel;
    }

    public void setCommunicationListFromxcel(List<CommunicationTab> communicationListFromxcel) {
        this.communicationListFromxcel = communicationListFromxcel;
    }

    public List<List> getRowsLstToExport() {
        return rowsLstToExport;
    }

    public void setRowsLstToExport(List<List> rowsLstToExport) {
        this.rowsLstToExport = rowsLstToExport;
    }

    public List<BasicInformationTab> getUserDetBasicInfoListfromXcel() {
        return userDetBasicInfoListfromXcel;
    }

    public void setUserDetBasicInfoListfromXcel(List<BasicInformationTab> userDetBasicInfoListfromXcel) {
        this.userDetBasicInfoListfromXcel = userDetBasicInfoListfromXcel;
    }

    public List<DetailedInformationTab> getUserDetailedInfoListfromXcel() {
        return userDetailedInfoListfromXcel;
    }

    public void setUserDetailedInfoListfromXcel(List<DetailedInformationTab> userDetailedInfoListfromXcel) {
        this.userDetailedInfoListfromXcel = userDetailedInfoListfromXcel;
    }

    public List<List> getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(List<List> selectedRow) {
        this.selectedRow = selectedRow;
    }

    public boolean isSm_saveBtnRender() {
        return sm_saveBtnRender;
    }

    public void setSm_saveBtnRender(boolean sm_saveBtnRender) {
        this.sm_saveBtnRender = sm_saveBtnRender;
    }

    public int getSm_rowcount() {
        return sm_rowcount;
    }

    public void setSm_rowcount(int sm_rowcount) {
        this.sm_rowcount = sm_rowcount;
    }

    public int getSm_columncount() {
        return sm_columncount;
    }

    public void setSm_columncount(int sm_columncount) {
        this.sm_columncount = sm_columncount;
    }

    public ArrayList getSm_columnsLst() {
        return sm_columnsLst;
    }

    public void setSm_columnsLst(ArrayList sm_columnsLst) {
        this.sm_columnsLst = sm_columnsLst;
    }

    public String getSm_title() {
        return sm_title;
    }

    public void setSm_title(String sm_title) {
        this.sm_title = sm_title;
    }

    public boolean isSm_editBtnRender() {
        return sm_editBtnRender;
    }

    public void setSm_editBtnRender(boolean sm_editBtnRender) {
        this.sm_editBtnRender = sm_editBtnRender;
    }

    public boolean isSm_newBtnRender() {
        return sm_newBtnRender;
    }

    public void setSm_newBtnRender(boolean sm_newBtnRender) {
        this.sm_newBtnRender = sm_newBtnRender;
    }

    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
    }

    public List<List> getSm_rowsLst() {
        return sm_rowsLst;
    }

    public void setSm_rowsLst(List<List> sm_rowsLst) {
        this.sm_rowsLst = sm_rowsLst;
    }

    public List getTmpSelectedRow() {
        return tmpSelectedRow;
    }

    public void setTmpSelectedRow(List tmpSelectedRow) {
        this.tmpSelectedRow = tmpSelectedRow;
    }

    public ArrayList getSm_spancolumnsLst() {
        return sm_spancolumnsLst;
    }

    public void setSm_spancolumnsLst(ArrayList sm_spancolumnsLst) {
        this.sm_spancolumnsLst = sm_spancolumnsLst;
    }

    public ArrayList getSm_spansubcolumnsLst() {
        return sm_spansubcolumnsLst;
    }

    public void setSm_spansubcolumnsLst(ArrayList sm_spansubcolumnsLst) {
        this.sm_spansubcolumnsLst = sm_spansubcolumnsLst;
    }

    public ArrayList getSm_allcolumnsLst() {
        return sm_allcolumnsLst;
    }

    public void setSm_allcolumnsLst(ArrayList sm_allcolumnsLst) {
        this.sm_allcolumnsLst = sm_allcolumnsLst;
    }

    public ArrayList getColumnhearderbuttonlist() {
        return columnhearderbuttonlist;
    }

    public void setColumnhearderbuttonlist(ArrayList columnhearderbuttonlist) {
        this.columnhearderbuttonlist = columnhearderbuttonlist;
    }

    public int getActioncolumnwidth() {
        return actioncolumnwidth;
    }

    public void setActioncolumnwidth(int actioncolumnwidth) {
        this.actioncolumnwidth = actioncolumnwidth;
    }

    public String[] getSelectedradiobtn() {
        return selectedradiobtn;
    }

    public void setSelectedradiobtn(String[] selectedradiobtn) {
        this.selectedradiobtn = selectedradiobtn;
    }

//    public String getSelectedradiobtn() {
//        return selectedradiobtn;
//    }
//
//    public void setSelectedradiobtn(String selectedradiobtn) {
//        this.selectedradiobtn = selectedradiobtn;
//    }
//    public HashMap getSelectedradiobtn() {
//        return selectedradiobtn;
//    }
//
//    public void setSelectedradiobtn(HashMap selectedradiobtn) {
//        this.selectedradiobtn = selectedradiobtn;
//    }
    public List getSelectedchkbox() {
        return selectedchkbox;
    }

    public void setSelectedchkbox(List selectedchkbox) {
        this.selectedchkbox = selectedchkbox;
    }

    public String getFieldsetval() {
        return fieldsetval;
    }

    public void setFieldsetval(String fieldsetval) {
        this.fieldsetval = fieldsetval;
    }

    public ArrayList getRepeatradioallitems() {
        return repeatradioallitems;
    }

    public void setRepeatradioallitems(ArrayList repeatradioallitems) {
        this.repeatradioallitems = repeatradioallitems;
    }

    public ArrayList getDaterepeatlist() {
        return daterepeatlist;
    }

    public void setDaterepeatlist(ArrayList daterepeatlist) {
        this.daterepeatlist = daterepeatlist;
    }

    public List getChkboxallitems() {
        return chkboxallitems;
    }

    public void setChkboxallitems(List chkboxallitems) {
        this.chkboxallitems = chkboxallitems;
    }

    public String getDisplayaction() {
        return displayaction;
    }

    public void setDisplayaction(String displayaction) {
        this.displayaction = displayaction;
    }

    public String getRowsPerPageTemplate() {
        return rowsPerPageTemplate;
    }

    public void setRowsPerPageTemplate(String rowsPerPageTemplate) {
        this.rowsPerPageTemplate = rowsPerPageTemplate;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSelectedexport() {
        return selectedexport;
    }

    public void setSelectedexport(String selectedexport) {
        this.selectedexport = selectedexport;
    }

    public ArrayList getExportlist() {
        return exportlist;
    }

    public void setExportlist(ArrayList exportlist) {
        this.exportlist = exportlist;
    }

    public ArrayList getReoder_columnsLst() {
        return reoder_columnsLst;
    }

    public void setReoder_columnsLst(ArrayList reoder_columnsLst) {
        this.reoder_columnsLst = reoder_columnsLst;
    }

    public String getDiaplay() {
        return diaplay;
    }

    public void setDiaplay(String diaplay) {
        this.diaplay = diaplay;
    }

    public String getClearfilter() {
        return clearfilter;
    }

    public void setClearfilter(String clearfilter) {
        this.clearfilter = clearfilter;
    }

    HashMap sortByHm = new HashMap();

    public HashMap getSortByHm() {
        return sortByHm;
    }

    public void setSortByHm(HashMap sortByHm) {
        this.sortByHm = sortByHm;
    }

    public ArrayList getColumnTypeHmLst() {
        return columnTypeHmLst;
    }

    public void setColumnTypeHmLst(ArrayList columnTypeHmLst) {
        this.columnTypeHmLst = columnTypeHmLst;
    }

    private HashMap columnValuesHm = new HashMap();

    public HashMap getColumnValuesHm() {
        return columnValuesHm;
    }

    public void setColumnValuesHm(HashMap columnValuesHm) {
        this.columnValuesHm = columnValuesHm;
    }

    public List<List> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<List> filteredList) {
        this.filteredList = filteredList;
    }

    private HashMap dateConverterHm = new HashMap();

    public HashMap getDateConverterHm() {
        return dateConverterHm;
    }

    public void setDateConverterHm(HashMap dateConverterHm) {
        this.dateConverterHm = dateConverterHm;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public List<Uvs_userdetail> getUserList() {
        return userList;
    }

    public void setUserList(List<Uvs_userdetail> userList) {
        this.userList = userList;
    }

    public LinkedTreeMap getnBPMconfig() {
        return nBPMconfig;
    }

    public void setnBPMconfig(LinkedTreeMap nBPMconfig) {
        this.nBPMconfig = nBPMconfig;
    }

    public List<DefaultColumnModel> getNonbpmcolumnlist() {
        return nonbpmcolumnlist;
    }

    public void setNonbpmcolumnlist(List<DefaultColumnModel> nonbpmcolumnlist) {
        this.nonbpmcolumnlist = nonbpmcolumnlist;
    }

    public List<String> getNonbpmValuelist() {
        return nonbpmValuelist;
    }

    public void setNonbpmValuelist(List<String> nonbpmValuelist) {
        this.nonbpmValuelist = nonbpmValuelist;
    }

    public Map getNonBpmValueMap() {
        return nonBpmValueMap;
    }

    public void setNonBpmValueMap(Map nonBpmValueMap) {
        this.nonBpmValueMap = nonBpmValueMap;
    }

    public List<Object> getNonbpmSelectionList() {
        return nonbpmSelectionList;
    }

    public void setNonbpmSelectionList(List<Object> nonbpmSelectionList) {
        this.nonbpmSelectionList = nonbpmSelectionList;
    }

    public List<String> getRevokeHeaders() {
        return revokeHeaders;
    }

    public void setRevokeHeaders(List<String> revokeHeaders) {
        this.revokeHeaders = revokeHeaders;
    }

    public List<String> getRecallHeaders() {
        return recallHeaders;
    }

    public void setRecallHeaders(List<String> recallHeaders) {
        this.recallHeaders = recallHeaders;
    }

    public List<String> getRevokeValues() {
        return revokeValues;
    }

    public void setRevokeValues(List<String> revokeValues) {
        this.revokeValues = revokeValues;
    }

    public List<String> getRecallValues() {
        return recallValues;
    }

    public void setRecallValues(List<String> recallValues) {
        this.recallValues = recallValues;
    }

    public String getSuperEditRestrictorColumn() {
        return superEditRestrictorColumn;
    }

    public void setSuperEditRestrictorColumn(String superEditRestrictorColumn) {
        this.superEditRestrictorColumn = superEditRestrictorColumn;
    }

    public List<String> getSuperEditRestrictorValues() {
        return superEditRestrictorValues;
    }

    public void setSuperEditRestrictorValues(List<String> superEditRestrictorValues) {
        this.superEditRestrictorValues = superEditRestrictorValues;
    }
    
    public String getNbpmheader() {
        return nbpmheader;
    }

    public void setNbpmheader(String nbpmheader) {
        this.nbpmheader = nbpmheader;
    }
    
}
