package com.svm.lrp.nfr.lnd.ctrl;

public class lndctrlDummy {

//    ILogger logger;
//    VDSInvoker serviceInvoker;
//    SMDialogUtil dUtil;
//    Gson jsonUtil;
//    SvmJsonUtil svmJsonUtil = new SvmJsonUtil();
//    LandingPageModel model;
//    LandingPageUIDataModel dataModel = new LandingPageUIDataModel();
//    String redirectMdlId = "";
//    String loginName = "";
//    QuickModuleRights quickModuleRights;
//    IMetaData mData;
//    
//    
//    List toggleList = new ArrayList();
//    ArrayList columnHeaderLst = new ArrayList();    
//    ArrayList allcolumnHeaderLst = new ArrayList();
//    ArrayList spancolumnHeaderLst = new ArrayList();
//    ArrayList spansubcolumnHeaderLst = new ArrayList();
//    ArrayList columnTypeLst = new ArrayList();
//    ArrayList columnFormatLst = new ArrayList();
//    ArrayList columnHeaderLstHide = new ArrayList();
//    ArrayList allcolumnHeaderLstHide = new ArrayList();
//
//
//    LandingPageVds service;
//    Map landingPageDatasHm;
////    Map landingPageDatasreorderHm;
//    Map landingPageDatasHmBPM;
//    ISMBPMUtil smbpmUtil;
//    Map<String, String> headerDisplayNameVarMap = new HashMap();
//    List<List> bpmAppicableRows = new ArrayList();
//    Map<String, TaskSummaryVo> refnoTaskSummaryMap = new HashMap();
//    final static String TASK_STATUS_LABEL = "Task Status";
//    final static String STATUS_APR = "Approved";
//    final static String STATUS_CLO = "Close Out";
//    static String PROJECTTYPE;
//    int refnofieldIndex = 0;
//    int statusdescindex = 0;
//    int bpmwrkflowidscriptindex = 0;
//    boolean editable = false;
//    boolean applyBPM = false;
//    IFileExport fileexp;
//    String spRefNoList = "";
//    Map<String, String> mDataMap = new HashMap<>();
//    String WFID = "";
//    String formCreationWFID = "";
//    String formCreationbpmWFID = "";
//    boolean isDynamicMdl = false;
//    String columngroup = "";
//    String bpmWFID = "";
//    List<String> bpmReflist = new ArrayList();
//    private boolean doubleboolean = false;
//    SelectEvent chkevent;
//    String value = "";
//    List bpmwrkflowlist = new ArrayList();
//    HashMap hm = new HashMap();
////    -----------for button--------------
//    HashMap buttonMap = new HashMap();
//    LinkedTreeMap groupbuttonHeaders = null;
//    LinkedTreeMap buttonsubvalue = null;
//    HashMap indexcolumnmap = new HashMap();
//    HashMap newtargetmdl = new HashMap();
//    HashMap newnavigateflag = new HashMap();
//    HashMap indexmap = new HashMap();
//    HashMap indexmapedit = new HashMap();
//    HashMap indexmapnew = new HashMap();
//    HashMap buttonsubvaluemappingedit = new HashMap();
//    HashMap buttonsubvaluemappingview = new HashMap();
//    private boolean buttonchk = false;
//    String defaultaction;
//    String doubleclickrender;
//    private boolean editactionapplybpm = false;
////    ------------------------------------------
////    -----------------for filter----------------
//    String showmoduleid;
//    HashMap selectedfieldname = new HashMap();
//    HashMap filterValuehm = new HashMap();
//    HashMap filterOptchkhm = new HashMap();
//    HashMap filterviewInputHm = new HashMap();
//    String hasfilter;
//    HashMap defaultselradio = new HashMap();
//    HashMap defaultselchk = new HashMap();
//    HashMap selradiohshmap = new HashMap();
//    HashMap datehashmap = new HashMap();
//    HashMap filtergetfieldname = new HashMap();
//    HashMap dspflddate = new HashMap();
//    boolean refresh = false;
////    -----------------------------------
////    -------------editidentifier----------
//    boolean commonidentybool = false;
//    List<List> editidentifierlistrows = new ArrayList();
//    boolean editidentybool = false;
//    List<List> viewrenidentifierlistrows = new ArrayList();
//    boolean viewrenidentybool = false;
//    List<List> editrenidentifierlistrows = new ArrayList();
//    boolean editrenidentybool = false;
//    List<List> newrenidentifierlistrows = new ArrayList();
//    boolean newrenidentybool = false;
//
////    ---------------------------
//    int indexcolumni;
//    boolean toggle = false;
//    List<List> notapplicablebpmrows;
//    String viewIdentifier = "";
//    LNDPageThirdLevelValidation trdvo = new LNDPageThirdLevelValidation();
//    List<List> thirdlevelbpmapplicablerows = new ArrayList<List>();
//
//    //--------------reorder---------
//    List dataSet = new ArrayList();
//    List<List> rows = new ArrayList();
////    ArrayList defaultrows = new ArrayList();
//
//    boolean reorederflag = false;
//    List hideInShipcollst = new ArrayList();
//    List hideInShorecollst = new ArrayList();
//    String statusdescdpname = "";
//    List spansubcolumnshoreHeaderLst = new ArrayList();
//    List spansubcolumnshipHeaderLst = new ArrayList();
//    Map<String, String> columnTypeLstreoderMap = new HashMap();
//    ArrayList refnoreoderlist = new ArrayList();
//    boolean reoderbool = false;
//    ArrayList tmpColumnNames = new ArrayList();
//    List hideInShore = null;
//    List hideInShip = null;
//    ArrayList reorderallcolumnHeaderLst = new ArrayList();
//    ArrayList reordercolumnHeaderLst = new ArrayList();
//    int refnoindx = 0;
//    boolean reorderval = false;
//    boolean loadreorderval = false;
//    List reodrtmpColHeaderNamesLst = new ArrayList();
//    boolean defal = true;
//    boolean loaddefal = true;
//    List reoderbpmscriptnewlst;
//
//    public lndctrl(ILogger logger, VDSInvoker serviceInvoker, LandingPageModel model, QuickModuleRights quickModuleRights, ISMBPMUtil smbpmUtil, SMDialogUtil dUtil, IFileExport fileexp) {
//
//        this.logger = logger;
//        this.serviceInvoker = serviceInvoker;
//        jsonUtil = new Gson();
//        this.fileexp = fileexp;
//        this.model = model;
//        mData = NFRUtils.getMetaData();
//        this.smbpmUtil = smbpmUtil;
//        this.dUtil = dUtil;
//        PROJECTTYPE = NFRUtils.getProjectType();
//        this.quickModuleRights = quickModuleRights;
//        this.service = serviceInvoker.create(LandingPageVds.class);
//        toggleList.add(true);
////        exportExcelAdded();        
//        importExcelButton();
//        checkFormsOrOthers();
//        initializeLandingPage();
//
////        -------for button-----------
//        if (buttonchk) {
//            columnheaderButton();
//        }
//        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
//        RequestContext.getCurrentInstance().update("dlg1");
////        ------------------------
//    }
//
//    private void importExcelButton() {
//        if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
//            if ((model.getDataModel().getMdlId().trim().equalsIgnoreCase("USD"))) {
//                model.getDataModel().setUserImportExcelDis(true);
//            } else if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("SPS")) {
//                model.getDataModel().setVesselImportExcelDis(true);
//            } else {
//                model.getDataModel().setVesselImportExcelDis(false);
//                model.getDataModel().setUserImportExcelDis(false);
//            }
//        } else {
//            model.getDataModel().setVesselImportExcelDis(false);
//            model.getDataModel().setUserImportExcelDis(false);
//        }
//    }
//
//    private void checkFormsOrOthers() {
//        try {
//            System.out.println("model.getDataModel().getMdlId() ??????????? " + model.getDataModel().getMdlId());
//            applyBPM = checkFormsOrOthers(model.getDataModel().getMdlId());
//            System.out.println("applyBPM ????????????????????? " + applyBPM);
//        } catch (Exception ex) {
//            Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void initializeLandingPage() {
//        List bmlist = new ArrayList();
//        HashMap bmhm = new HashMap();
//        ArrayList bmhmaddinglist = new ArrayList();
//        LinkedTreeMap<String, String> refhm = new LinkedTreeMap<String, String>();
//        LNDPageThirdLevelValidation vo = new LNDPageThirdLevelValidation();
//        try {
//            this.loginName = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
//            mDataMap.put("projecttype", PROJECTTYPE);
//            mDataMap.put("usercode", mData.getMetaData(USERINFO.USERCODE));
//            mDataMap.put("tenantid", mData.getMetaData(USERINFO.TENANT_ID));
//            mDataMap.put("subtenantid", mData.getMetaData(USERINFO.SUB_TENANT_ID));
//            mDataMap.put("empcode", mData.getMetaData(APPINFO.EMP_CODE));
//            mDataMap.put("rankcode", mData.getMetaData(APPINFO.RANK_CODE));
//            mDataMap.put("vesselcode", mData.getMetaData(APPINFO.VESSEL_CODE));
//            mDataMap.put("active_status", "A");
//            mDataMap.put("formatdate", "");
//            mDataMap.put("hasrefno", "N");
//            mDataMap.put("refnolist", "");
//            vo.setMdlid(model.getDataModel().getMdlId());
//            vo.setCntrltype(PROJECTTYPE);
//            vo.setUsercode(mData.getMetaData(USERINFO.USERCODE));
////            System.out.println("inisde tenantid====>"+mData.getMetaData(USERINFO.TENANT_ID));
////            System.out.println("inisde subtenantid====>"+mData.getMetaData(USERINFO.SUB_TENANT_ID));
//            landingPageDatasHm = getLandingPageDatas(model.getDataModel().getMdlId(), loginName, mDataMap, mData.getMetaData(APPINFO.RANK_CODE));
//            if (applyBPM && (landingPageDatasHm.get("refnofield") == null || landingPageDatasHm.get("statusdesc") == null)) {
//                System.out.println("inside  ");
//                model.getDataModel().setSm_title("");
//                model.getDataModel().setSm_editBtnRender(false);
//                model.getDataModel().setSm_newBtnRender(false);
//                model.getDataModel().setSm_saveBtnRender(false);
//                this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00001", "", null);
//            } else {
//                loadLandingPage();
////                String thrdvd = landingPageDatasHm.get("thirdlevelvalidation").toString();
//                System.out.println("thrdvd=============>" + landingPageDatasHm.get("thirdlevelvalidation"));
//                if (landingPageDatasHm.get("thirdlevelvalidation") != null && landingPageDatasHm.get("thirdlevelvalidation").toString().equalsIgnoreCase("y")) {
//                    String thrdvdsvcname = (String) landingPageDatasHm.get("thirdlevelServiceName");
//                    System.out.println("indgsh thrdvdsvcname====>" + thrdvdsvcname);
//                    for (int i = 0; i < notapplicablebpmrows.size(); i++) {
//                        bmlist = new ArrayList();
//                        bmlist = notapplicablebpmrows.get(i);
//                        bmhm = new HashMap();
//                        bmhm.put("Refno", bmlist.get(0).toString());
//                        bmhmaddinglist.add(bmhm);
//                        vo.setReflist(bmhmaddinglist);
//                    }
//
//                    this.serviceInvoker.invokeFunction(thrdvdsvcname, "MAC", new SvmJsonObject(svmJsonUtil.toString(vo)));
//                    String jsonString = this.serviceInvoker.getResult().toString();
//                    LNDPageThirdLevelValidation trdvo = (LNDPageThirdLevelValidation) this.svmJsonUtil.toObject(jsonString, LNDPageThirdLevelValidation.class);
//                    if (!reorederflag) {
//                        rows = (List<List>) landingPageDatasHm.get("rowValues");
//                    }
//                    for (int rw = 0; rw < rows.size(); rw++) {
//                        List l = rows.get(rw);
//                        for (int m = 0; m < trdvo.getAccesslist().size(); m++) {
//                            refhm = (LinkedTreeMap<String, String>) trdvo.getAccesslist().get(0);
//                            if (refhm.get("Refno").equalsIgnoreCase(l.get(refnofieldIndex).toString())) {
//                                if (refhm.get("Access").equalsIgnoreCase("true")) {
//                                    thirdlevelbpmapplicablerows.add(rows.get(rw));
//                                }
//                            }
//                        }
//                    }
////                    ---------Action Required Edit Button---------------
////                    if (thirdlevelbpmapplicablerows != null) {
////                        for (int t = 0; t < thirdlevelbpmapplicablerows.size(); t++) {
////                            thirdlevelbpmapplicablerows.get(t).set(statusdescindex, "Action Required");
////                        }
////                    }
////                            -----------------------------
//                    System.out.println("inisde thirdlevelbpmapplicablerows===>" + thirdlevelbpmapplicablerows);
//                }
//            }
//        } catch (Exception e) {
//            Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    public String actionDisplay() {
//        String value = "";
//        if (defaultaction.equalsIgnoreCase("N")) {
////            System.out.println("inid N actionDisplay***********");
//            value = "display: none";
//            model.getStateModel().setDefaultactionrender(false);
//            model.getStateModel().setDefaultcolumrender(true);
//            model.getDataModel().setActioncolumnwidth(0);
//            editable = false;
//            RequestContext.getCurrentInstance().update("landingPageForm");
//        } else {
////            System.out.println("inid Y actionDisplay***********" + model.getStateModel().isDefaultactionrender());
//            model.getStateModel().setDefaultactionrender(true);
//            model.getStateModel().setDefaultcolumrender(false);
//            value = "display: false";
//            RequestContext.getCurrentInstance().update("landingPageForm");
//        }
//        return value;
//    }
//
//    public String applyStatusColorsForHeader(int colIndex, String statusDesc) {
//        String style = "";
//        try {
//            if (spansubcolumnshipHeaderLst.contains(statusDesc)) {
//                style = "statusclassship";
//            } else if (spansubcolumnshoreHeaderLst.contains(statusDesc)) {
//                style = "statusclassshore";
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return style;
//    }
//
//    public String applyStatusColorsForRows(int colIndex, String statusDesc, String column) {
//        String value = "";
//        int index = 0;
//        try {
////            System.out.println("inisde applyStatusColorsForRows>>>>>>>" + statusDesc + ">>>column>>" + column);
//            HashMap hm = new HashMap();
////            if (colIndex == this.statusdescindex) {
//            if (column.equalsIgnoreCase(statusdescdpname)) {
//                value = "<span class=\"label-" + statusDesc + "\" >" + statusDesc + "</span>";
//            } else {
//                value = statusDesc;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return value;
//    }
//
//    public String getHashmapViewvalue(int colIndex) {
////        System.out.println("inisde colIndex===>" + colIndex);
////        System.out.println("insdie columnNameship getHashmapvalue==>" + indexmap);
//        return indexmap.get(colIndex).toString();
//    }
//
//    public boolean getHashmapNewvalue(int colIndex, List row) {
//        boolean newbool;
////        System.out.println("inisde getHashmapNewvalue colIndex===>" + colIndex);
////        System.out.println("insdie columnNameship getHashmapNewvalue==>" + indexmapnew);
//        boolean bl = (boolean) indexmapnew.get(colIndex);
//        if (bl) {
//            if (newrenidentybool) {
//                newbool = newrenidentifierlistrows.contains(row);
//                if (newbool) {
//                    bl = false;
//                    System.out.println("inide elsefalse editable====>" + newbool);
//                }
//            }
//        }
//        return bl;
//    }
//
//    public boolean getHashmapEditvalue(int colIndex, List row) {
////        System.out.println("inid Y* outer**********" + model.getStateModel().isDefaultactionrender());
//        boolean bl = (boolean) indexmapedit.get(colIndex);
//        if (bl) {
//            if (applyBPM && editactionapplybpm) {
////                System.out.println("### bpmAppicableRows=>" + bpmAppicableRows);
////                System.out.println("### row==>" + row);
//                editable = bpmAppicableRows.contains(row);
////                System.out.println("### editable==>" + editable);
//                if (editable) {
//                    editable = model.getDataModel().isSm_editBtnRender();
////                    System.out.println("inide if editable====>" + editable);
//                }
//            } else {
////                System.out.println("iudk else===>");
//                if (editrenidentybool) {
//                    editable = editrenidentifierlistrows.contains(row);
//                    if (editable) {
//                        editable = false;
//                    } else {
//                        editable = model.getDataModel().isSm_editBtnRender();
//                    }
//                } else {
//                    editable = model.getDataModel().isSm_editBtnRender();
//                }
//            }
//            RequestContext.getCurrentInstance().update("datatableajax");
//        } else {
//            editable = bl;
//        }
////        System.out.println("idsnfjsdn colIndex===>" + colIndex + "====>" + editable);
//        return editable;
//
//    }
//
//    private void loadLandingPage() {
//        int indexcolumn = 0;
//        String WFIDnew = "";
//        String statuscolname = "";
//
//        ArrayList tmpColumnNamesbpmwrkid = new ArrayList();
//
////        List handlelist=new ArrayList();
//        try {
//            model.getDataModel().setSm_saveBtnRender(true);
//            CompleteModel completeModel = new CompleteModel();
//            completeModel = service.getusertablepreferences(mData.getMetaData(USERINFO.USERCODE), model.getDataModel().getMdlId());
//            if (!completeModel.getUserTablePreferences().isEmpty() && completeModel.getUserTablePreferences().get(0).getRowscount() != 0) {
//                model.getDataModel().setRows(completeModel.getUserTablePreferences().get(0).getRowscount());
//            } else {
//                model.getDataModel().setRows(10);
//            }
//            allcolumnHeaderLst = (ArrayList) landingPageDatasHm.get("allheaderNames");
//            System.out.println("oidfj allcolumnHeaderLst>>" + allcolumnHeaderLst);
//            if (!completeModel.getUserTablePreferences().isEmpty() && completeModel.getUserTablePreferences().get(0).getPreferredcolumn() != null) {
//                String[] column = completeModel.getUserTablePreferences().get(0).getPreferredcolumn().split(",");
//                allcolumnHeaderLst = (ArrayList) landingPageDatasHm.get("allheaderNames");
//                if (!allcolumnHeaderLst.isEmpty()) {
//                    for (int i = 0; i < column.length; i++) {
//                        allcolumnHeaderLstHide.add(column[i]);
//                    }
//                } else {
//                    for (int i = 0; i < column.length; i++) {
//                        columnHeaderLstHide.add(column[i]);
//                    }
//                }
//            }
//            columnHeaderLst = (ArrayList) landingPageDatasHm.get("headerNames");
//            spancolumnHeaderLst = (ArrayList) landingPageDatasHm.get("spanheaderNames");
//            spansubcolumnHeaderLst = (ArrayList) landingPageDatasHm.get("spansubheaderNames");
//            columnTypeLst = (ArrayList) landingPageDatasHm.get("columnTypeLst");
//            columnFormatLst = (ArrayList) landingPageDatasHm.get("columnFormatLst");
//            ArrayList columnHeader = (ArrayList) landingPageDatasHm.get("headerNames");
//
//            ArrayList dataLst = (ArrayList) landingPageDatasHm.get("dataSets");
//            String landingPageTitleName = (String) landingPageDatasHm.get("landingPageTitleName");
//            rows = (List<List>) landingPageDatasHm.get("rowValues");
//            this.redirectMdlId = (String) landingPageDatasHm.get("redirectMdlId");
//            int rowCount = (int) landingPageDatasHm.get("dataSetSize");
//            boolean isAllowEdit = (boolean) landingPageDatasHm.get("isAllowEdit");
//            boolean isAllowCreate = (boolean) landingPageDatasHm.get("isAllowCreate");
//            headerDisplayNameVarMap = (Map) landingPageDatasHm.get("headerDisplayNameVarMap");
//            statusdescindex = tmpColumnNames.indexOf(landingPageDatasHm.get("statusdesc"));
//            statuscolname = landingPageDatasHm.get("statusdesc").toString();
//            Iterator itr = headerDisplayNameVarMap.keySet().iterator();
//
//            if (!completeModel.getUserTablePreferences().isEmpty() && (!completeModel.getUserTablePreferences().get(0).getReodercolumns().isEmpty())) {
//                System.out.println("inisde trrdyt>>>>>>>>>>" + completeModel.getUserTablePreferences().get(0).getReodercolumns());
//                getReoderdata(completeModel.getUserTablePreferences().get(0).getReodercolumns());
//                if (!allcolumnHeaderLst.isEmpty()) {
//                    allcolumnHeaderLst = model.getDataModel().getSm_allcolumnsLst();
//                } else {
//                    columnHeaderLst = model.getDataModel().getSm_allcolumnsLst();
//                }
//                reorderval = true;
//                reoderbool = true;
//                System.out.println("inju recolumnHeaderLst>>" + allcolumnHeaderLst);
//                System.out.println("inju columnHeaderLst>>" + columnHeaderLst);
//                System.out.println("inju reodet reoderbpmscriptnewlst>>" + reoderbpmscriptnewlst);
//            } else {
//                tmpColumnNames = (ArrayList) landingPageDatasHm.get("tmpColHeaderNames");
//            }
//            while (itr.hasNext()) {
//                String columnName = itr.next().toString();
//                if (headerDisplayNameVarMap.get(columnName).toString().equalsIgnoreCase(statuscolname)) {
//                    statusdescdpname = columnName;
//                    System.out.println("inisde statusdescdpname>>>>>>>" + statusdescdpname);
//                }
//            }
//
//            if (buttonMap != null) {
//                Iterator itrbutton = buttonMap.keySet().iterator();
//                while (itrbutton.hasNext()) {
//                    String groupcolumnName = itrbutton.next().toString();
//                    indexcolumn = tmpColumnNames.indexOf(groupcolumnName);
//                    System.out.println("inisde indexcolumn===>" + indexcolumn);
//                    indexcolumnmap.put(groupcolumnName, indexcolumn);
//                }
//            }
//
//            System.out.println("===columnHeaderLst is=======>" + columnHeaderLst);
//            System.out.println("===allcolumnHeaderLst is=======>" + allcolumnHeaderLst);
//            System.out.println("===spancolumnHeaderLst is=======>" + spancolumnHeaderLst);
//            System.out.println("===spansubcolumnHeaderLst is=======>" + spansubcolumnHeaderLst);
//            System.out.println("===columnFormatLst is=======>" + columnFormatLst);
//            System.out.println("===columnHeader is=======>" + columnHeader);
//            System.out.println("===tmpColumnNames is=======>" + tmpColumnNames);
//            System.out.println("===rows is============>" + rows);
//            System.out.println("===dataLst ==========>" + dataLst);
//            System.out.println("===isAllowEdit ==========>" + isAllowEdit);
//            System.out.println("===isAllowCreate ==========>" + isAllowCreate);
//            System.out.println("===redirectMdlId ==========>" + redirectMdlId);
//
//            this.quickModuleRights.getModuleRights(model.getDataModel().getMdlId());
//            if (reorderval == true) {
//                reorderval = false;
//                loadreorderval = true;
//                reorederflag = true;
//                reorderClicked();
////                submitClicked();
//            }
//            if (landingPageDatasHm.get("applyhandlybyuserlogic") != null && landingPageDatasHm.get("applyhandlybyuserlogic").toString().equalsIgnoreCase("y")) {
//                List applylist = (List) landingPageDatasHm.get("statusntchkhl");
//                List handlelist = smbpmUtil.getRefnoHandledByUserOrGroup(mData.getMetaData(USERINFO.USERCODE));
//                System.out.println("inds refnofieldIndex loadLandingPage==> " + refnofieldIndex);
//                System.out.println("inds statusdescindex loadLandingPage==> " + statusdescindex);
//                System.out.println("inds handlelist loadLandingPage==> " + handlelist);
//                System.out.println("inds applylist loadLandingPage==> " + applylist);
//                List jk = new ArrayList();
//                List alllist = new ArrayList();
//                for (int y = 0; y < rows.size(); y++) {
//                    jk = new ArrayList();
//                    jk = rows.get(y);
//                    if (handlelist.contains(jk.get(refnofieldIndex).toString())) {
//                        alllist.add(rows.get(y));
//                    } else if (!applylist.isEmpty() && applylist.contains(jk.get(statusdescindex).toString())) {
//                        alllist.add(rows.get(y));
//                    }
//                }
//                model.getDataModel().setSm_rowsLst(alllist);
////                model.getDataModel().setSm_defaultallcolumnsLst(alllist);
//            } else {
//                model.getDataModel().setSm_rowsLst((ArrayList) rows);
////                model.getDataModel().setSm_defaultallcolumnsLst(rows);
//            }
//
//            if (!allcolumnHeaderLst.isEmpty()) {
//                model.getDataModel().setSm_allcolumnsLst(allcolumnHeaderLst);
//                model.getDataModel().setReoder_columnsLst(allcolumnHeaderLst);
//
//            } else {
//                model.getDataModel().setSm_allcolumnsLst(columnHeaderLst);
//                model.getDataModel().setReoder_columnsLst(columnHeaderLst);
//            }
////            model.getDataModel().setSm_columnsLst(columnHeaderLst);
//
////            if (!completeModel.getUserTablePreferences().isEmpty() && (completeModel.getUserTablePreferences().get(0).getReodercolumns() != null || !completeModel.getUserTablePreferences().get(0).getReodercolumns().isEmpty())) {
////                System.out.println("inisde trrdyt>>>>>>>>>>");
////                getReoderdata(completeModel.getUserTablePreferences().get(0).getReodercolumns());
////                columnHeaderLst = model.getDataModel().getSm_allcolumnsLst();
////            }
//            model.getDataModel().setSm_spancolumnsLst(spancolumnHeaderLst);
//            model.getDataModel().setSm_spansubcolumnsLst(spansubcolumnHeaderLst);
//            model.getDataModel().setSm_title(landingPageTitleName);
////            model.getDataModel().setSm_title(redirectMdlId);
//            System.out.println("WRITE RIGHT IN LANDIN PAGE ??????????????? " + this.quickModuleRights.getWriteRights());
//            model.getDataModel().setSm_editBtnRender(this.quickModuleRights.getWriteRights());
//            model.getDataModel().setSm_newBtnRender(this.quickModuleRights.getWriteRights());
//            if (isAllowCreate == false) {
//                model.getDataModel().setSm_newBtnRender(isAllowCreate);
//            }
//            System.out.println("inisde inisetoggleList if===>" + toggleList);
//            System.out.println("inisde applyBPM if===>" + applyBPM);
//
//            // bpm starts             
//            if (applyBPM) {
//                rows = includeBPMStatus(rows);
//                System.out.println("inisde tmpColumnNames>>>@@@" + tmpColumnNames);
//                System.out.println("inisde refnofield>>>>>" + landingPageDatasHm.get("refnofield"));
//                System.out.println("inide index********" + tmpColumnNames.indexOf(landingPageDatasHm.get("refnofield")));
//                refnofieldIndex = tmpColumnNames.indexOf(landingPageDatasHm.get("refnofield"));
//                statusdescindex = tmpColumnNames.indexOf(landingPageDatasHm.get("statusdesc"));
//                System.out.println("iniede landingPageDatasHm.get(\"bpmwrkflowidscript\")===>" + landingPageDatasHm.get("bpmwrkflowidscript"));
//                if (landingPageDatasHm.get("bpmwrkflowidscript") != null) {
//                    System.out.println("inisdebpmwrkflowidscript nu>>>>>>> " + landingPageDatasHm.get("bpmwrkflowidscript"));
//                    tmpColumnNamesbpmwrkid = (ArrayList) landingPageDatasHm.get("tmpColHeaderNames");
//                    if (reoderbool == true) {
//                        System.out.println("iddjdlkan>>>" + reoderbpmscriptnewlst);
//                        bpmwrkflowidscriptindex = reoderbpmscriptnewlst.indexOf(landingPageDatasHm.get("bpmwrkflowidscript"));
//                        System.out.println("iddjdlkan bpmwrkflowidscriptindex>>>" + bpmwrkflowidscriptindex);
//                    } else {
//                        bpmwrkflowidscriptindex = tmpColumnNamesbpmwrkid.indexOf(landingPageDatasHm.get("bpmwrkflowidscript"));
//                    }
//                    System.out.println("injsd nu bpmwrkflowidscriptindex>>>>>" + bpmwrkflowidscriptindex);
//
//                }
//                if (bpmwrkflowidscriptindex != 0) {
//                    System.out.println("inisdebpmwrkflowidscript nu for>>>>>>> ");
//                    for (int i = 0; i < rows.size(); i++) {
//                        List al = rows.get(i);
//                        System.out.println("insjs al>>>>>" + al + ">>>>>>" + bpmwrkflowidscriptindex);
//                        for (int j = 0; j < al.size(); j++) {
//                            System.out.println("injsds al.get(bpmwrkflowidscriptindex)>>>" + al.get(bpmwrkflowidscriptindex));
//                            bpmwrkflowlist.add(al.get(bpmwrkflowidscriptindex));
//                        }
//                    }
//                }
//                if (bpmwrkflowlist != null) {
//                    Set<String> hs = new HashSet<>();
//                    hs.addAll(bpmwrkflowlist);
//                    bpmwrkflowlist.clear();
//                    bpmwrkflowlist.addAll(hs);
//                    System.out.println("inside editclicked bpmwrkflowlist!= null=====>" + bpmwrkflowlist);
//                    for (int bm = 0; bm < bpmwrkflowlist.size(); bm++) {
//                        if (!bpmwrkflowlist.get(bm).toString().equalsIgnoreCase("1")) {
//                            CompleteModel wrkFlowIdrsk = service.getworkflowmappingidrsk(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), bpmwrkflowlist.get(bm).toString());
//                            System.out.println("iniwde wrkFlowIdrsk===>" + wrkFlowIdrsk);
//                            if (wrkFlowIdrsk != null) {
//                                WFIDnew = wrkFlowIdrsk.getWorkflowmapping().get(0).getWorkflowid().trim();
////                        bpmWFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getBpmwrkflowid().trim();
//                                hm.put(bpmwrkflowlist.get(bm).toString(), WFIDnew);
//                            }
//                        }
//                    }
//                    System.out.println("inside hm===>" + hm);
//                }
//                System.out.println("inside applyBPM> refnofieldIndex>>>" + refnofieldIndex);
//                applyBPMRights(refnofieldIndex);
//            }
//            setDateFormatForList(model.getDataModel().getSm_rowsLst());
//            model.getDataModel().getRowsLstToExport().addAll(model.getDataModel().getSm_rowsLst());
//            model.getDataModel().setTotalRows(model.getDataModel().getSm_rowsLst().size());
//            if (bpmAppicableRows != null) {
//                List chk = new ArrayList();
//                List fulllist = new ArrayList();
//                for (int y = 0; y < model.getDataModel().getSm_rowsLst().size(); y++) {
//                    chk = new ArrayList();
//                    chk = model.getDataModel().getSm_rowsLst().get(y);
////                    System.out.println("inh chk====>" + chk);
////                    System.out.println("inh chk bpmAppicableRows====>" + bpmAppicableRows);
//                    System.out.println("inh chk thirdlevelbpmapplicablerows====>" + thirdlevelbpmapplicablerows + "===thirdlevelbpmapplicablerows.contains(chk)===>" + thirdlevelbpmapplicablerows.contains(chk));
//                    System.out.println("inh chk ====>" + chk);
////                    ------------"Action Required"===================
////                    if (bpmAppicableRows.contains(chk)) {
////                        chk.set(statusdescindex, "Action Required");
////                    }
////                    ----------------------Action Required End--------
//                    fulllist.add(chk);
//                }
//                System.out.println("insdj fulllist===>" + fulllist);
//                model.getDataModel().setSm_rowsLst((ArrayList) fulllist);
//            }
//
//            if (!allcolumnHeaderLst.isEmpty()) {
//                for (int i = 0; i < allcolumnHeaderLst.size(); i++) {
//                    if (!completeModel.getUserTablePreferences().isEmpty()) {
//                        toggle = false;
//                        if (completeModel.getUserTablePreferences().get(0).getPreferredcolumn() != null) {
//                            String[] column = completeModel.getUserTablePreferences().get(0).getPreferredcolumn().split(",");
////                        toggleList.add(true);
//                            for (int j = 0; j < column.length; j++) {
//                                System.out.println("inide&&&&&&&" + j + "===column[i]===>" + column[j] + "===allcolumnHeaderLst.get(i)==>" + allcolumnHeaderLst.get(i));
//                                if (column[j].equalsIgnoreCase(allcolumnHeaderLst.get(i).toString())) {
//                                    toggleList.add(false);
//                                    toggle = true;
//                                    System.out.println("inise if===>" + toggleList);
//                                }
//                            }
//                        }
//                        if (!toggle) {
//                            toggleList.add(true);
//                        }
//                    } else {
//                        toggleList.add(true);
//                    }
//                }
//            } else {
//                for (int i = 0; i < columnHeaderLst.size(); i++) {
//                    if (!completeModel.getUserTablePreferences().isEmpty() && completeModel.getUserTablePreferences().get(0).getPreferredcolumn() != null) {
//                        toggle = false;
//                        String[] column = completeModel.getUserTablePreferences().get(0).getPreferredcolumn().split(",");
//                        System.out.println("inside ctrl columnHeaderLst====>" + columnHeaderLst);
//                        for (int j = 0; j < column.length; j++) {
//                            System.out.println("inide&&&&&&&" + j + "===column[i]===>" + column[j] + "===columnHeaderLst.get(i)==>" + columnHeaderLst.get(i));
//                            if (column[j].equalsIgnoreCase(columnHeaderLst.get(i).toString())) {
//                                toggleList.add(false);
//                                toggle = true;
//                                System.out.println("inise if===>" + toggleList);
//                            }
//                        }
//                        if (!toggle) {
//                            toggleList.add(true);
//                        }
//                    } else {
//                        toggleList.add(true);
//                    }
//                }
//            }
//            System.out.println("inide ctrl toggleList==>" + toggleList);
//            System.out.println("FINAL LIST OF ALL ROWS ??????????? " + model.getDataModel().getSm_rowsLst());
//            System.out.println("FINAL COLUMN LIST ???????????????? " + model.getDataModel().getSm_allcolumnsLst());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void loadLandingPageForBPMRefNo(int statusindex) {
//        try {
//            System.out.println("@@@@@@@@@@@@@@ loadLandingPageForBPMRefNo @@@@@@@@@@@@@@@@@@@ ");
//            rows = (List<List>) landingPageDatasHmBPM.get("rowValues");
//            int size = rows.size();
//            for (int i = 0; i < size; i++) {
//                rows.get(i).add("-");
//            }
//            List<List> finalrowList = model.getDataModel().getSm_rowsLst();
//            rows.stream().forEach(row -> {
//                finalrowList.add(row);
//            });
//            model.getDataModel().setSm_rowsLst(finalrowList);
//            Predicate<List> reffieldcheck = col -> bpmReflist.contains(((String) col.get(refnofieldIndex)).toLowerCase());
//            List<List> tmpbpmAppicableRows;
//            tmpbpmAppicableRows = model.getDataModel().getSm_rowsLst().stream().filter(reffieldcheck).collect(Collectors.toList());
//            tmpbpmAppicableRows.stream().forEach(bpmrow -> {
//                int bpmrowindex = model.getDataModel().getSm_rowsLst().indexOf(bpmrow);
//                model.getDataModel().getSm_rowsLst().get(bpmrowindex).set(statusindex, WFID);
//
//            });
//            tmpbpmAppicableRows.stream().forEach(tmpbpmrow -> {
//                if (!bpmAppicableRows.contains(tmpbpmrow)) {
//                    bpmAppicableRows.addAll(tmpbpmAppicableRows);
//                }
//            });
//            System.out.println("inisee loadLandingPageForBPMRefNo WFID===>" + WFID);
//
////            applyBPMRights(refnofieldIndex);
//        } catch (Exception e) {
//            Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    private List<List> includeBPMStatus(List<List> rows) {
//        System.out.println("inside includeBPMStatus====>" + rows);
//        int size = rows.size();
//        for (int i = 0; i < size; i++) {
//            rows.get(i).add("-");
//        }
//        System.out.println("inside includeBPMStatus=>>>>>" + rows);
//        return rows;
//    }
//
//    private void applyBPMRights(int refnofieldIndex) throws Exception {
//        System.out.println("inide pplyBPMRights(int refnofieldIndex)>>>>>>>>>>>>");
//        try {
//            int statusindex;
//            System.out.println("************* applyBPMRights Called ***************** " + PROJECTTYPE);
//            this.spRefNoList = "";
//            if (!allcolumnHeaderLst.isEmpty()) {
//                statusindex = allcolumnHeaderLst.size();
//                System.out.println("**Inside allcolumnHeaderLst statusindex*****" + statusindex + "*****>>>" + allcolumnHeaderLst);
//            } else {
//                statusindex = columnHeaderLst.size();
//                System.out.println("**Inside columnHeaderLst statusindex*****" + statusindex + "******>>>>" + columnHeaderLst);
//            }
//
//            CompleteModel wrkFlowIdCreate = service.getworkflowmappingid(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), PROJECTTYPE.trim(), "A");
//            if (!wrkFlowIdCreate.getWorkflowmapping().isEmpty()) {
//                formCreationWFID = wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid().trim();
//                formCreationbpmWFID = wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid().trim();
//            }
//            System.out.println("formCreationWFID ????????????????? " + formCreationWFID);
//
////            CompleteModel wrkFlowId = service.getworkflowmappingid(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), "A");
//            CompleteModel wrkFlowId = service.getworkflowmappingid(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), "V");
//            System.out.println("SIZE OF WK_MAPPING TEMP ????????????????? " + wrkFlowId.getWorkflowmapping().size());
//            wrkFlowId.getWorkflowmapping().stream().forEach(row -> {
//                System.out.println("wfid IN STREEEEEMMMMMMMMMM " + row.getWorkflowid());
//            });
//
//            for (int i = 0; i < wrkFlowId.getWorkflowmapping().size(); i++) {
//                WFID = wrkFlowId.getWorkflowmapping().get(i).getWorkflowid().trim();
//                bpmWFID = wrkFlowId.getWorkflowmapping().get(i).getBpmwrkflowid().trim();
//                System.out.println("WFID IN LANDING PAGE &&&&&&&&&&&&&&&&& " + WFID);
//                System.out.println("bpmWFID IN LANDING PAGE &&&&&&&&&&&&&& " + bpmWFID);
//                List<TaskSummaryVo> taskvolist = smbpmUtil.getPendingTaskByUser(WFID, mData.getMetaData(USERINFO.USERCODE));
//                System.out.println("Inside taskvolist size===>" + taskvolist.size());
//
//                if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("ART")) {
//                    CompleteModel wrkFlowId_rar = service.getworkflowmappingid("RAR", PROJECTTYPE.trim(), "V");
//                    if (!wrkFlowId_rar.getWorkflowmapping().isEmpty()) {
//                        List<TaskSummaryVo> taskvolist_rar = smbpmUtil.getPendingTaskByUser(wrkFlowId_rar.getWorkflowmapping().get(0).getWorkflowid().trim(), mData.getMetaData(USERINFO.USERCODE));
//                        taskvolist.addAll(taskvolist_rar);
//                    }
//                }
//
//                taskvolist.stream().forEach(taskvo -> {
//                    System.out.println("BPM ERF NO ??????????????? " + taskvo.getRefno());
//                });
//                List<String> bpmExtraReflist = new ArrayList();
//                taskvolist.stream().forEach(taskvo -> {
//                    bpmReflist.add(taskvo.getRefno().trim().toLowerCase());
//                    bpmExtraReflist.add(taskvo.getRefno().trim().toLowerCase() + "-" + model.getDataModel().getMdlId().toLowerCase());
//                    refnoTaskSummaryMap.put(taskvo.getRefno().trim().toLowerCase(), taskvo);
//                });
//                System.out.println("Inside refnofieldIndex*************>" + refnofieldIndex);
//                System.out.println("Inside bpmReflist*************>" + bpmReflist);
//                Predicate<List> reffieldcheck = col -> bpmReflist.contains(((String) col.get(refnofieldIndex)).toLowerCase());
//                List<List> tmpbpmAppicableRows;
//                tmpbpmAppicableRows = model.getDataModel().getSm_rowsLst().stream().filter(reffieldcheck).collect(Collectors.toList());
////                System.out.println("inide reffieldcheck>>>>>"+reffieldcheck+">>>>rowlst>>>"+model.getDataModel().getSm_rowsLst());
//
////                taskvolist.stream().forEach(taskvo -> {
////                    bpmReflist.add(taskvo.getRefno().trim().toUpperCase());                   
////                });
////                
////                Predicate<List> reffieldchecknot = col -> bpmReflist.contains(((String) col.get(refnofieldIndex)));
////                notapplicablebpmrows = model.getDataModel().getSm_rowsLst().stream().filter(reffieldchecknot).collect(Collectors.toList());     
//                notapplicablebpmrows = model.getDataModel().getSm_rowsLst().stream().filter(line -> !reffieldcheck.equals(model.getDataModel().getSm_rowsLst())).collect(Collectors.toList());
//
////                notapplicablebpmrows = model.getDataModel().getSm_rowsLst().stream().filter(line -> !reffieldcheck.equals(model.getDataModel().getSm_rowsLst())).collect(Collectors.toList());       
//                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//                System.out.println("inisde notapplicablebpmrows$$$$$$$===>" + notapplicablebpmrows);
//                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//
//                tmpbpmAppicableRows.stream().forEach(bpmrow -> {
//                    int bpmrowindex = model.getDataModel().getSm_rowsLst().indexOf(bpmrow);
//                    System.out.println("insdie bpmrowindex>>>>>>" + bpmrowindex);
//                    String refno = (String) model.getDataModel().getSm_rowsLst().get(bpmrowindex).get(refnofieldIndex);
//                    refno = refno.trim().toLowerCase();
//                    System.out.println("inside refno>>>>>>>tmp>>>" + refno);
//                    if (!refnoreoderlist.contains(refno)) {
//                        refnoreoderlist.add(refno);
//                    }
//                    //model.getDataModel().getSm_rowsLst().get(bpmrowindex).set(statusindex, WFID + "~" + bpmWFID);
//                    String statusIndexValue = (String) model.getDataModel().getSm_rowsLst().get(bpmrowindex).get(statusindex);
//                    System.out.println("statusIndexValue ?????????????? " + statusIndexValue);
//                    System.out.println("WFID + bpmWFID ????????????????? in  ???????? " + WFID + "~" + bpmWFID);
//                    if (statusIndexValue != null && statusIndexValue.contains("~")) {
//                        System.out.println("inside if bloeck ???????????????? ");
//                        System.out.println("already handled >>already handled >> " + statusIndexValue);
//                    } else {
//                        System.out.println("inside else bloeck ???????????????? ");
//                        model.getDataModel().getSm_rowsLst().get(bpmrowindex).set(statusindex, WFID + "~" + bpmWFID);
//                    }
//                });
//
//                System.out.println("inisde refnoreoderlist>>>" + refnoreoderlist);
//                bpmAppicableRows.addAll(tmpbpmAppicableRows);
//                System.out.println("END OF FOR LOOOOOOOOOOOOOOOOOOOOOOOOOOPPPPPPPPPPPPPPPPPPPPPPP ");
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR IN APPLY BPM METHODDDDDD " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    List<String> getExcessRefNoFromBPM(int refnofieldIndex) {
//        List<String> spRefList = new ArrayList<>();
//        model.getDataModel().getSm_rowsLst().stream().forEach(row -> {
//            spRefList.add(row.get(refnofieldIndex).toString().trim().toLowerCase());
//        });
//        return spRefList;
//    }
//
//    private void applyStatusColors() {
//        model.getDataModel().getSm_rowsLst().stream().forEach(row -> {
//            String statusDesc = (String) row.get(this.statusdescindex);
//            row.set(this.statusdescindex, "<span class=\"label-" + statusDesc + "\" >" + statusDesc + "</span>"
//            );
//        }
//        );
//    }
//
//    private void removeDisAllowedRows(int statusdescindex) {
//        int bpmstatusindex = columnHeaderLst.size();
//        List removeList = new ArrayList();
//        model.getDataModel().getSm_rowsLst().stream().forEach(row -> {
//            String statusDesc = (String) row.get(statusdescindex);
//            String bpmStatusDesc = row.get(bpmstatusindex).toString();
//            if (PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHIP)) {
//                if ((bpmStatusDesc.trim().equalsIgnoreCase("-"))
//                        && (!statusDesc.trim().toLowerCase().equalsIgnoreCase(STATUS_APR.trim().toLowerCase())
//                        && !statusDesc.trim().toLowerCase().equalsIgnoreCase(STATUS_CLO.trim().toLowerCase()))) {
//                    removeList.add(row);
//                }
//            } else if (PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHORE)) {
//                if ((statusDesc.trim().equalsIgnoreCase("-"))
//                        && (!statusDesc.trim().toLowerCase().equalsIgnoreCase(STATUS_CLO.trim().toLowerCase()))) {
//                    removeList.add(row);
//                }
//            }
//        });
////        System.out.println("removeList ??????????? " + removeList);
//        removeList.stream().forEach(row -> {
//            model.getDataModel().getSm_rowsLst().remove(row);
//        });
//    }
//
//    public boolean checkEditable(List row) {
////        System.out.println("inid Y* outer**********" + model.getStateModel().isDefaultactionrender());
//        System.out.println("inside checkEditable editidentifierlistrows===>");
////        System.out.println("insdjs checkEditable refnoreoderlist>>>" + refnoreoderlist);
//        if (applyBPM) {
//            if (reoderbool == true && bpmAppicableRows != null) {
//                System.out.println("inside chk reoderbool>>>" + reoderbool);
//                for (int i = 0; i < row.size(); i++) {
//                    System.out.println("insid chk drefnoreoderlist>>>" + refnoreoderlist + ">>>row.get(i)>>>" + row.get(i).toString().toLowerCase());
//                    if (refnoreoderlist.contains(row.get(i).toString().toLowerCase())) {
//                        System.out.println("inside chk contains>>>>>");
//                        for (int m = 0; m < bpmAppicableRows.size(); m++) {
//                            if (bpmAppicableRows.get(m).contains(row.get(i))) {
//                                row = bpmAppicableRows.get(m);
//                                System.out.println("inside contains rw>>>>>" + row);
//                            }
//                        }
//                    }
//                }
//            } else if (reoderbool == true && editidentifierlistrows != null) {
//                for (int i = 0; i < row.size(); i++) {
////                    System.out.println("insid editidentifierlistrows drefnoreoderlist>>>" + refnoreoderlist + ">>>row.get(i)>>>" + row.get(i));
//                    if (refnoreoderlist.contains(row.get(i).toString().toLowerCase())) {
////                        System.out.println("inside editidentifierlistrows contains>>>>>");
//                        for (int m = 0; m < editidentifierlistrows.size(); m++) {
//                            if (editidentifierlistrows.get(m).contains(row.get(i))) {
//                                row = editidentifierlistrows.get(m);
//                            }
//                        }
//                    }
//                }
//            }
////            System.out.println("insjdn checkEditable row>>>>" + row);
//            if (editidentifierlistrows.contains(row)) {
////                System.out.println("inside editidentifierlistrows===>");
//                editable = false;
//            } else {
////                System.out.println("### bpmAppicableRows=>" + bpmAppicableRows);
//                editable = bpmAppicableRows.contains(row);
////                System.out.println("### editable==>" + editable);
//                if (editable) {
//                    editable = model.getDataModel().isSm_editBtnRender();
////                    System.out.println("inide if editable====>" + editable);
//                }
//                if (editable == false && thirdlevelbpmapplicablerows != null && thirdlevelbpmapplicablerows.contains(row)) {
//                    editable = model.getDataModel().isSm_editBtnRender();
//                }
//            }
//        } else {
////            System.out.println("iudk else===>");
//            if (editidentybool) {
//                editable = editidentifierlistrows.contains(row);
//                if (editable) {
//                    editable = false;
////                    System.out.println("inide elsefalse editable====>" + editable);
//                } else {
//                    editable = model.getDataModel().isSm_editBtnRender();
////                    System.out.println("inide elsetrue editable====>" + editable);
//                }
//            } else {
//                editable = model.getDataModel().isSm_editBtnRender();
////                System.out.println("inide else editable====>" + editable);
//            }
//        }
//        System.out.println("inide elsefalse outer editable====>" + editable);
//        RequestContext.getCurrentInstance().update("datatableajax");
//        return editable;
//    }
//
//    /* public boolean checkEditable(List row) {
//     //        System.out.println("inid Y* outer**********" + model.getStateModel().isDefaultactionrender());
//     if (applyBPM) {
//     System.out.println("### bpmAppicableRows=>" + bpmAppicableRows);
//     //            System.out.println("### row==>" + row);
//     editable = bpmAppicableRows.contains(row);
//     //            System.out.println("### editable==>" + editable);
//     if (editable) {
//     editable = model.getDataModel().isSm_editBtnRender();
//     //                System.out.println("inide if editable====>" + editable);
//     }
//     } else {
//     System.out.println("Inside else===>");
//     if (editidentybool) {
//     editable = editidentifierlistrows.contains(row);
//     if (editable) {
//     editable = false;
//     //                    System.out.println("inide elsefalse editable====>" + editable);
//     } else {
//     editable = model.getDataModel().isSm_editBtnRender();
//     //                    System.out.println("inide elsetrue editable====>" + editable);
//     }
//     } else {
//     editable = model.getDataModel().isSm_editBtnRender();
//     //                System.out.println("inide else editable====>" + editable);
//     }
//     }
//     RequestContext.getCurrentInstance().update("datatableajax");
//     return editable;
//     }*/
//    public void viewClicked() {
//        ArrayList lstToView = null;
//        ArrayList oldlstToView = null;
//        LandingDataVo landingdata = new LandingDataVo();
//        String rskid = "";
//        String bpmwrkid = "";
//        try {
//            if (reoderbool) {
//                oldlstToView = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRow");
//                System.out.println("inisde oldlstToEdit>>>>>>>>>>>" + oldlstToView + ">>refnoindx>>>" + refnoindx);
////                for (int h = 0; h < model.getDataModel().getSm_defaultallcolumnsLst().size(); h++) {
////                    System.out.println("inisde oldlstToEdit>>>>>>>>>>>" + model.getDataModel().getSm_defaultallcolumnsLst().get(h));
////                    for (int k = 0; k < oldlstToView.size(); k++) {
////                        if (model.getDataModel().getSm_defaultallcolumnsLst().get(h).contains(oldlstToView.get(refnoindx))) {
////                            lstToView = (ArrayList) model.getDataModel().getSm_defaultallcolumnsLst().get(h);
////                        }
////                    }
////                }
//            } else {
//                lstToView = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRow");
//            }
//
////            for (int h = 0; h < rows.size(); h++) {
////                for (int k = 0; k < oldlstToView.size(); k++) {
////                    if (rows.get(h).contains(oldlstToView.get(k))) {
////                        lstToView = (ArrayList) rows.get(h);
////                    }
////                }
////            }
//            landingdata.setData(lstToView);
//            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
//            landingdata.setIsDynamicMdl(isDynamicMdl);
//
//            if (applyBPM) {
//                System.out.println("last index ?????????? " + lstToView.get(lstToView.size() - 1).toString());
//                String lastIndexVal = lstToView.get(lstToView.size() - 1).toString();
//
////                if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("RSK")) {
////                    rskid = lstToView.get(refnofieldIndex).toString();
////                    System.out.println("inside RSK lstToView rskid==>" + rskid);
////                    CompleteModel bpmwrkidrsk = service.getrskmasterlanding(rskid);
////                    bpmwrkid = bpmwrkidrsk.getRskmaster().get(0).getWrkflowid().trim();
////                    CompleteModel wrkFlowIdrsk = service.getworkflowmappingidrsk(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), bpmwrkid);
////                    WFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getWorkflowid().trim();
////                    bpmWFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getBpmwrkflowid().trim();
//////                    System.out.println("bpmWFID VIEW IN LANDING PAGE=====" + WFID + "====RSK&&&&&&&&&&&&&& " + bpmWFID);
////                } else {
//                if (bpmwrkflowidscriptindex != 0) {
//                    bpmWFID = lstToView.get(bpmwrkflowidscriptindex).toString();
//                    if (hm.containsKey(bpmWFID)) {
//                        WFID = hm.get(bpmWFID).toString();
//                    }
//                    System.out.println("indisd wfid viewClickeddkakhi====<>" + WFID);
//                } else {
//                    if (lastIndexVal.trim().contains("~")) {
//                        String[] latColVal = lastIndexVal.trim().split("~");
//                        System.out.println("latColVal ??????????? in view clicked ?????? " + latColVal);
//                        WFID = latColVal[0].trim();
//                        bpmWFID = latColVal[1].trim();
//                    } else {
//                        WFID = "-";
//                        bpmWFID = "";
//                    }
//                }
////                }
//                landingdata.setBpmwfid(bpmWFID);
//                landingdata.setWfid(WFID);
//                if (refnoTaskSummaryMap.get(((String) lstToView.get(refnofieldIndex)).trim().toLowerCase()) != null) {
//                    TaskSummaryVo taskSummary = refnoTaskSummaryMap.get(((String) lstToView.get(refnofieldIndex)).trim().toLowerCase());
//                    landingdata.setTasksummary(taskSummary);
//                }
//                landingdata.setIsBPMEnabled(true);
//
//            } else {
//                landingdata.setTasksummary(null);
//            }
//            System.out.println("bpmWFID VIEW IN LANDING PAGE=====" + WFID + "====outer&&&&&&&&&&&&&& " + bpmWFID);
//            landingdata.getData().add(0, lstToView.get(refnofieldIndex));
//            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void doubleClicked(SelectEvent event) {
//        doubleboolean = true;
//        chkevent = event;
//        boolean doubleselectedrow;
//        model.getDataModel().setTmpSelectedRow((List) event.getObject());
//        doubleselectedrow = bpmAppicableRows.contains(model.getDataModel().getTmpSelectedRow());
//        System.out.println("inide doubleselectedrow=====>" + doubleselectedrow);
//        if (doubleselectedrow) {
//            doubleboolean = false;
//        }
//        RequestContext.getCurrentInstance().execute("lnd_navigate_rc()");
//    }
//
//    public void navigateToModule() {
//        LandingDataVo landingdata = new LandingDataVo();
//        try {
//            System.out.println("inifrf navigateToModule==>" + model.getDataModel().getTmpSelectedRow().get(0));
//            landingdata.setData(model.getDataModel().getTmpSelectedRow());
//            if (doubleboolean) {
//                landingdata.setAction(LandingDataVo.LandingAction.VIEW);
//            } else {
//                landingdata.setAction(LandingDataVo.LandingAction.EDIT);
//                doubleboolean = true;
//            }
//            if (applyBPM) {
//                String[] latColVal = model.getDataModel().getTmpSelectedRow().get(model.getDataModel().getTmpSelectedRow().size() - 1).toString().split("~");
//                if (latColVal[0].trim().contains("~")) {
//                    WFID = latColVal[0].trim();
//                    bpmWFID = latColVal[1].trim();
//                } else {
//                    WFID = "-";
//                    bpmWFID = "";
//                }
//                landingdata.setBpmwfid(bpmWFID);
//                if (refnoTaskSummaryMap.get(((String) model.getDataModel().getTmpSelectedRow().get(refnofieldIndex)).trim().toLowerCase()) != null) {
//                    TaskSummaryVo taskSummary = refnoTaskSummaryMap.get(((String) model.getDataModel().getTmpSelectedRow().get(refnofieldIndex)).trim().toLowerCase());
//                    landingdata.setTasksummary(taskSummary);
//                    landingdata.setIsBPMEnabled(true);
//                    landingdata.setWfid(WFID);
//                }
//            } else {
//                landingdata.setTasksummary(null);
//            }
//            landingdata.getData().add(0, model.getDataModel().getTmpSelectedRow().get(refnofieldIndex));
//            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void editClicked() {
//        ArrayList lstToEdit = null;
//        ArrayList oldlstToEdit = null;
//        LandingDataVo landingdata = new LandingDataVo();
//        String syncstatus = "";
//        String rskid = "";
//        boolean rarEditRights = false;
//        List<List> newrow;
////        String bpmwrkid = "";
//        try {
////            setSm_defaultallcolumnsLst
////            newrow=(List<List>) landingPageDatasHm.get("rowValues");
//            if (reoderbool) {
//                oldlstToEdit = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRow");
//                System.out.println("inisde oldlstToEdit>>>>>>>>>>>" + oldlstToEdit + ">>refnoindx>>>" + refnoindx + ">>ij.." + oldlstToEdit.get(refnoindx));
////                for (int h = 0; h < model.getDataModel().getSm_defaultallcolumnsLst().size(); h++) {
////                    System.out.println("inisde df oldlstToEdit>>>>>>>>>>>" + model.getDataModel().getSm_defaultallcolumnsLst().get(h));
////                    if (model.getDataModel().getSm_defaultallcolumnsLst().get(h).contains(oldlstToEdit.get(refnoindx))) {
////                        lstToEdit = (ArrayList) model.getDataModel().getSm_defaultallcolumnsLst().get(h);
////                    }
////
////                }
//            } else {
//                lstToEdit = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRow");
//            }
//
//            syncstatus = lstToEdit.get(indexcolumni).toString();
//            System.out.println("indif syncstatus===>" + syncstatus);
////            if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("RSK")) {
////                rskid = lstToEdit.get(refnofieldIndex).toString();
////                System.out.println("inside RSK rskid==>" + rskid);
////                CompleteModel bpmwrkidrsk = service.getrskmasterlanding(rskid);
////                bpmwrkid = bpmwrkidrsk.getRskmaster().get(0).getWrkflowid().trim();
////                CompleteModel wrkFlowIdrsk = service.getworkflowmappingidrsk(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), bpmwrkid);
////                WFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getWorkflowid().trim();
////                bpmWFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getBpmwrkflowid().trim();
////                System.out.println("bpmWFID IN LANDING PAGE=====" + WFID + "====RSK&&&&&&&&&&&&&& " + bpmWFID);
////            }
////            System.out.println("inside editclicked bpmwrkflowlist=====>" + bpmwrkflowlist);
//
//            /*if (bpmwrkflowidscriptindex != 0) {
//             bpmWFID = lstToEdit.get(bpmwrkflowidscriptindex).toString();
//             if (hm.containsKey(bpmWFID)) {
//             WFID = hm.get(bpmWFID).toString();
//             }
//             System.out.println("indisd wfid editcidkdkakhi====<>" + WFID);
//             //                CompleteModel wrkFlowIdrsk = service.getworkflowmappingidrsk(model.getDataModel().getMdlId(), PROJECTTYPE.trim(), bpmwrkid);
//             //                WFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getWorkflowid().trim();
//             //                bpmWFID = wrkFlowIdrsk.getWorkflowmapping().get(0).getBpmwrkflowid().trim();
//
//             }*/
//            System.out.println("inisedelstToEdit>>>>>> " + lstToEdit);
//            TaskSummaryVo taskSummary = new TaskSummaryVo();
//            landingdata.setData(lstToEdit);
//            landingdata.setAction(LandingDataVo.LandingAction.EDIT);
//            landingdata.setIsDynamicMdl(isDynamicMdl);
//            landingdata.setSyncstatus(syncstatus);
//            landingdata.setThirdvalidationstatus(false);
//            if (applyBPM) {
////                System.out.println("inii refnoTaskSummaryMap==>" + refnoTaskSummaryMap);
////                System.out.println("infifr ujio===>" + refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase()));
//                if (thirdlevelbpmapplicablerows != null && thirdlevelbpmapplicablerows.contains(lstToEdit)) {
//                    landingdata.setTasksummary(null);
//                    landingdata.setWfid(null);
//                    landingdata.setThirdvalidationstatus(true);
//                    landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
//                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                } else {
//                    if (refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase()) != null) {
//                        taskSummary = refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase());
//                    }
//                    String[] latColVal = lstToEdit.get(lstToEdit.size() - 1).toString().split("~");
//
//                    if (bpmwrkflowidscriptindex != 0) {
//                        bpmWFID = lstToEdit.get(bpmwrkflowidscriptindex).toString();
//                        if (hm.containsKey(bpmWFID)) {
//                            WFID = hm.get(bpmWFID).toString();
//                        }
//                        System.out.println("indisd wfid editcidkdkakhi====<>" + WFID);
//                        rarEditRights = smbpmUtil.hasClaimRights(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim());
//                    } else {
////                if (!model.getDataModel().getMdlId().trim().equalsIgnoreCase("RSK")) {
//                        WFID = latColVal[0].trim();
//                        bpmWFID = latColVal[1].trim();
////                }
//                    }
//
//                    System.out.println("bpmWFID ??? in EDIT CLICKED ??????????? " + bpmWFID);
//                    landingdata.setBpmwfid(bpmWFID);
//                    landingdata.setWfid(WFID);
//                    landingdata.setIsBPMEnabled(true);
//
////                System.out.println("inief model.getDataModel().getMdlId().trim().equalsIgnoreCase(\"ART\")===>" + model.getDataModel().getMdlId().trim().equalsIgnoreCase("ART"));
////                System.out.println("inside edit PROJECTTYPE.trim()===>" + PROJECTTYPE.trim());
//                    if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("ART")) {
//                        CompleteModel wrkFlowId = service.getworkflowmappingid("RAR", PROJECTTYPE.trim(), "V");
//                        if (!wrkFlowId.getWorkflowmapping().isEmpty()) {
//                            rarEditRights = smbpmUtil.hasClaimRights(wrkFlowId.getWorkflowmapping().get(0).getWorkflowid().trim(),
//                                    taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim());
//
//                        }
//                    }
////                } else if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("RSK")) {
////                    CompleteModel wrkFlowId = service.getworkflowmappingidrsk("RSK", PROJECTTYPE.trim(), bpmWFID);
////                    if (!wrkFlowId.getWorkflowmapping().isEmpty()) {
////                        rarEditRights = smbpmUtil.hasClaimRights(wrkFlowId.getWorkflowmapping().get(0).getWorkflowid().trim(),
////                                taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim());
////                    }
////                }
//                    System.out.println("Inside rarEditRights===>" + rarEditRights + "===has==" + smbpmUtil.hasClaimRights(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim())
//                            + "====tasksumm===" + smbpmUtil.hasClaimRightsDynamic(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim()));
//                    if (rarEditRights || smbpmUtil.hasClaimRights(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim()) || smbpmUtil.hasClaimRightsDynamic(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim())) {
//                        StatusVo claimStatus = smbpmUtil.claimTask(taskSummary, mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());
//
//                        System.out.println("BPM Edit call result status ========>" + claimStatus.getStatus());
//                        landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
//                        landingdata.setStatus(claimStatus.getStatus());
//
//                        if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED) {
//                            taskSummary = claimStatus.getTaskSummaryVo();
//                            landingdata.setTasksummary(taskSummary);
//                            landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
//                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                        } else {
//                            dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
//                        }
//                    } else {
//                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
//                    }
//                }
//            } else {
//                landingdata.setTasksummary(null);
//                landingdata.setWfid(null);
//                landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
//                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//            }
//            doubleboolean = false;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String getWorkFlowGroupCode() {
//        String sGrpCode = null;
//        VDSWorkflowGroupMappingModel vDSWorkflowGroupMappingModel = service.getworkflowgrpmapping(mData.getMetaData(APPINFO.RANK_CODE));
//        if (!vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().isEmpty()) {
//            sGrpCode = vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().get(0).getGrpcode();
//        }
//        return sGrpCode;
//    }
//
//    public void newClicked() {
//        try {
//            if (applyBPM) {
//                System.out.println(bpmWFID + "===isDynamicMdl ??????????????? IN NEW CICKED ????????? " + isDynamicMdl + "==formCreationbpmWFID==>" + formCreationbpmWFID);
//                StatusVo initStatus = new StatusVo();
//                LandingDataVo landingdata = new LandingDataVo();
//                landingdata.setData(null);
//                landingdata.setIsBPMEnabled(true);
//                landingdata.setAction(LandingDataVo.LandingAction.NEW);
//                landingdata.setTasksummary(new TaskSummaryVo());
//                landingdata.setWfid(formCreationWFID);
//                landingdata.setBpmwfid(formCreationbpmWFID);
//                landingdata.setIsDynamicMdl(isDynamicMdl);
//                if (!isDynamicMdl) {
//                    initStatus = smbpmUtil.hasRightsToIntiateProcess(formCreationWFID, mData.getMetaData(USERINFO.USERCODE).trim());
//                    System.out.println("initStatus.STSTUS ?????????????????????????????? " + initStatus.getStatus());
//                    if (initStatus.getStatus() == StatusVo.STATUS.SUCCESS) {
//                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                    } else {
//                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
//                    }
//                } else {
//                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                }
//
//            } else {
//                System.out.println("### Master New Action ==>" + redirectMdlId);
//                LandingDataVo landingdata = new LandingDataVo();
//                landingdata.setData(null);
//                landingdata.setAction(LandingDataVo.LandingAction.NEW);
//                landingdata.setTasksummary(null);
//                landingdata.setWfid(null);
//                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUserTablePreferences() {
//        try {
//            List columnList = new ArrayList();
//            String validate = "";
//            boolean prefer = false;
//            UserTablePreferences userPre = new UserTablePreferences();
//            userPre.setUsercode(mData.getMetaData(USERINFO.USERCODE));
//            userPre.setModuleid(model.getDataModel().getMdlId());
//            userPre.setCruser(mData.getMetaData(USERINFO.USERCODE));
//            userPre.setUpduser(mData.getMetaData(USERINFO.USERCODE));
//            userPre.setPreferredcolumn("");
//            userPre.setRowscount(model.getDataModel().getRows());
//            if (userPre.getRowscount() == 0) {
//                userPre.setRowscount(10);
//            }
//            System.out.println("inside toggleList size====>" + toggleList.size());
//            System.out.println("inside toggleList====>" + toggleList);
//            for (int i = 0; i < toggleList.size(); i++) {
//                if (i != 0 && !(boolean) toggleList.get(i)) {
//                    prefer = true;
//                    if (!allcolumnHeaderLst.isEmpty()) {
////                        System.out.println("inisde outer columnList>>>>" + columnList + ">>>>>>" + allcolumnHeaderLst.get(i - 1));
//                        if (!columnList.contains(allcolumnHeaderLst.get(i - 1))) {
//                            columnList.add(allcolumnHeaderLst.get(i - 1).toString());
////                            System.out.println("inisde inner columnList>>>>" + columnList);
//                            if (userPre.getPreferredcolumn().trim().length() == 0) {
////                                System.out.println("inisde inner columnList i===>>>>" + allcolumnHeaderLst.get(i - 1).toString());
//                                userPre.setPreferredcolumn(allcolumnHeaderLst.get(i - 1).toString());
//                                System.out.println("inided if allcolumnHeaderLst getPreferredcolumn===>" + userPre.getPreferredcolumn());
//                            } else {
//                                userPre.setPreferredcolumn(userPre.getPreferredcolumn() + "," + allcolumnHeaderLst.get(i - 1).toString());
//                                System.out.println("inided else allcolumnHeaderLst getPreferredcolumn===>" + userPre.getPreferredcolumn());
//                            }
//                        }
//                    } else {
//                        if (!columnList.contains(columnHeaderLst.get(i - 1))) {
//                            columnList.add(columnHeaderLst.get(i - 1).toString());
//                            if (userPre.getPreferredcolumn().trim().length() == 0) {
//                                userPre.setPreferredcolumn(columnHeaderLst.get(i - 1).toString());
//                                System.out.println("inided if getPreferredcolumn===>" + userPre.getPreferredcolumn());
//                            } else {
//                                userPre.setPreferredcolumn(userPre.getPreferredcolumn() + "," + columnHeaderLst.get(i - 1).toString());
//                                System.out.println("inided else getPreferredcolumn===>" + userPre.getPreferredcolumn());
//                            }
//                        }
//                    }
//
//                }
//            }
//            CompleteModel completeModel = new CompleteModel();
//            completeModel.getUserTablePreferences().add(userPre);
//            CompleteModel userPreference = service.getusertablepreferences(completeModel.getUserTablePreferences().get(0).getUsercode(), completeModel.getUserTablePreferences().get(0).getModuleid());
////            System.out.println("Result List Size is------------->" + completeModel.getUserTablePreferences().get(0).getPreferredcolumn());
//            System.out.println("inisd prefer=?>>>>" + prefer);
//            if (!userPreference.getUserTablePreferences().isEmpty()) {
//                if (userPreference.getUserTablePreferences().get(0).getReodercolumns() == null) {
//                    userPre.setReodercolumns("");
//                } else {
//                    userPre.setReodercolumns(userPreference.getUserTablePreferences().get(0).getReodercolumns());
//                }
//            }
//
//            if (userPre.getPreferredcolumn().isEmpty() && !userPreference.getUserTablePreferences().isEmpty() && !userPreference.getUserTablePreferences().get(0).getPreferredcolumn().isEmpty() && prefer == true) {
//                userPre.setPreferredcolumn(userPreference.getUserTablePreferences().get(0).getPreferredcolumn());
//            }
//            if (!userPreference.getUserTablePreferences().isEmpty()) {
//                if (userPreference.getUserTablePreferences().get(0).getRowscount() != 0) {
//                    userPre.setRowscount(userPreference.getUserTablePreferences().get(0).getRowscount());
//                }
//            }
//
//            if (userPreference.getUserTablePreferences().isEmpty()) {
//                validate = "save";
//            } else {
//                validate = "update";
//            }
////                        System.out.println("insd vali==>" + validate);
//            System.out.println("insd userPre.getPreferredcolumn()==>" + userPre.getPreferredcolumn());
//
//            Map saveMap = saveUserTablePreferences(completeModel, validate, userPreference);
//            if (saveMap.get("status").toString().trim().equalsIgnoreCase("200.0")) {
//                model.getDataModel().setSaveBtnRender(false);
//                this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00002", "", null);
//                RequestContext.getCurrentInstance().update("landingPageForm-saveUserPreferences");
//            }
//            RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
//            RequestContext.getCurrentInstance().update("dlg1");
//        } catch (Exception ex) {
//            Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void togglerCliked() {
//        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
//        RequestContext.getCurrentInstance().update("dlg1");
//    }
////    public void dataGridColumnSelection(ToggleEvent e) {
////        model.getDataModel().setSaveBtnRender(true);
////        int c = 0;
////        System.out.println("inisde dataGridColumnSelection toggleList===>" + toggleList);
////        System.out.println("inided e.getData()===>" + e.getPhaseId() + "===hashcode===" + e.hashCode() + "=======fds===>" + e.getSource() + "======>" + e.getData() + "===" + e.getVisibility());
////        if (!allcolumnHeaderLst.isEmpty()) {
////            for (int i = 0; i < allcolumnHeaderLst.size(); i++) {
////                System.out.println("inde allcolumn===>" + allcolumnHeaderLst);
////
////                if (i == (Integer.parseInt(e.getData().toString()) - 1)) {
////                    if (e.getVisibility().toString().equalsIgnoreCase("VISIBLE")) {
////                        System.out.println("inassjd  allcolumnHeaderLstHide e.getVisibility()===>");
////                        allcolumnHeaderLstHide.remove(allcolumnHeaderLst.get(i));
////                        c = i + 1;
////                        toggleList.set(c, true);
////                    } else {
////                        System.out.println("inassjd else allcolumnHeaderLstHide e.getVisibility()===>");
////                        allcolumnHeaderLstHide.add(allcolumnHeaderLst.get(i));
////                        c = i + 1;
////                        toggleList.set(c, false);
////                    }
////                    c = 0;
////                }
////
////            }
////        } else {
////            System.out.println("iniwd columnHeaderLst.size()===>" + columnHeaderLst.size());
////            for (int i = 0; i < columnHeaderLst.size(); i++) {
////                int lm = Integer.parseInt(e.getData().toString()) - 1;
////                if (i == (Integer.parseInt(e.getData().toString()) - 1)) {
////                    if (e.getVisibility().toString().equalsIgnoreCase("VISIBLE")) {
////                        System.out.println("inassjd  columnHeaderLstHide e.getVisibility()===>");
////                        columnHeaderLstHide.remove(columnHeaderLst.get(i));
////                        c = i + 1;
////                        toggleList.set(c, true);
////                    } else {
////                        System.out.println("inassjd  else columnHeaderLstHide e.getVisibility()===>");
////                        columnHeaderLstHide.add(columnHeaderLst.get(i));
////                        c = i + 1;
////                        toggleList.set(c, false);
////                    }
////                    c = 0;
////                }
////
////            }
////        }
////        System.out.println("inisde columnHeaderLstHide toggleList==>***" + toggleList);
////        System.out.println("inisde columnHeaderLstHide==>***" + columnHeaderLstHide);
////        System.out.println("inisde allcolumnHeaderLstHide==>***" + allcolumnHeaderLstHide);
////        RequestContext.getCurrentInstance().update("landingPageForm-saveUserPreferences");
////    }
//
//    public void dataGridColumnSelection(ToggleEvent e) {
//        model.getDataModel().setSaveBtnRender(true);
//        List newcollst = new ArrayList();
//        List newcolhderlst = new ArrayList();
//        if (reoderbool == true) {
//            if (!allcolumnHeaderLst.isEmpty()) {
//                newcollst = reorderallcolumnHeaderLst;
//                System.out.println("ind reorderallcolumnHeaderLst***");
//            } else {
//                newcolhderlst = reordercolumnHeaderLst;
//                System.out.println("ind reordercolumnHeaderLst***");
//            }
//        } else {
//            if (!allcolumnHeaderLst.isEmpty()) {
//                newcollst = allcolumnHeaderLst;
//                System.out.println("ind allcolumnHeaderLst***");
//            } else {
//                newcolhderlst = columnHeaderLst;
//                System.out.println("ind columnHeaderLst***");
//            }
//        }
//        int c = 0;
//        System.out.println("insid >>>>>" + newcollst + ">reorderallcolumnHeaderLst>" + reorderallcolumnHeaderLst + ">>" + ">>reordercolumnHeaderLst>>"
//                + allcolumnHeaderLst + ">>columnHeaderLst>>" + columnHeaderLst);
//        System.out.println("inisde dataGridColumnSelection toggleList===>" + toggleList);
//        System.out.println("inided e.getData()===>" + e.getPhaseId() + "===hashcode===" + e.hashCode() + "=======fds===>" + e.getSource() + "======>" + e.getData() + "===" + e.getVisibility());
//        System.out.println("insid hideInShip>>>>>>>>>" + hideInShipcollst);
//        newcollst.removeAll(hideInShipcollst);
//        System.out.println("insid newcollst>>>>>>>>>" + newcollst.size());
//
//        if (!newcollst.isEmpty()) {
//            for (int i = 0; i < newcollst.size(); i++) {
//                System.out.println("inde allcolumn===>" + newcollst);
//
//                if (i == (Integer.parseInt(e.getData().toString()) - 1)) {
//                    if (e.getVisibility().toString().equalsIgnoreCase("VISIBLE")) {
//                        System.out.println("inassjd  allcolumnHeaderLstHide e.getVisibility()===>");
//                        allcolumnHeaderLstHide.remove(newcollst.get(i));
//                        c = i + 1;
//                        toggleList.set(c, true);
//                    } else {
//                        System.out.println("inassjd else allcolumnHeaderLstHide e.getVisibility()===>" + i + ">>>" + newcollst.get(i));
//                        allcolumnHeaderLstHide.add(newcollst.get(i));
//                        c = i + 1;
//                        toggleList.set(c, false);
//                    }
//                    c = 0;
//                }
//
//            }
//        } else {
//            System.out.println("iniwd columnHeaderLst.size()===>" + newcolhderlst.size());
//            for (int i = 0; i < newcolhderlst.size(); i++) {
//                System.out.println("inde allcolumn===>" + newcolhderlst);
//                int lm = Integer.parseInt(e.getData().toString()) - 1;
//                if (i == (Integer.parseInt(e.getData().toString()) - 1)) {
//                    if (e.getVisibility().toString().equalsIgnoreCase("VISIBLE")) {
//                        System.out.println("inassjd  columnHeaderLstHide e.getVisibility()===>");
//                        columnHeaderLstHide.remove(newcolhderlst.get(i));
//                        c = i + 1;
//                        toggleList.set(c, true);
//                    } else {
//                        System.out.println("inassjd  else columnHeaderLstHide e.getVisibility()===>");
//                        columnHeaderLstHide.add(newcolhderlst.get(i));
//                        c = i + 1;
//                        toggleList.set(c, false);
//                    }
//                    c = 0;
//                }
//
//            }
//        }
//
//        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
//
//        System.out.println("inisde columnHeaderLstHide toggleList==>***" + toggleList);
//        System.out.println("inisde columnHeaderLstHide==>***" + columnHeaderLstHide);
//        System.out.println("inisde allcolumnHeaderLstHide==>***" + allcolumnHeaderLstHide);
//        RequestContext.getCurrentInstance().update("landingPageForm-saveUserPreferences");
//    }
//
//    public boolean isColumnVisible(String columnHeader) {
//        boolean showColumn = true;
//        try {
//            if (!allcolumnHeaderLstHide.isEmpty()) {
//                for (Object columnHeaderLstHide1 : allcolumnHeaderLstHide) {
//                    if (columnHeaderLstHide1.toString().trim().equalsIgnoreCase(columnHeader.trim())) {
//                        showColumn = false;
//                    }
//                }
//            } else {
//                for (Object columnHeaderLstHide1 : columnHeaderLstHide) {
//                    if (columnHeaderLstHide1.toString().trim().equalsIgnoreCase(columnHeader.trim())) {
//                        showColumn = false;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return showColumn;
//    }
//
//    void setDateFormatForList(List<List> list) {
//        if (!columnTypeLst.isEmpty()) {
//            for (int i = 0; i < columnTypeLst.size(); i++) {
//                String type = (String) columnTypeLst.get(i);
//                if (type != null && type.trim().length() > 0 && (type.trim().toLowerCase().equalsIgnoreCase("date") || type.trim().toLowerCase().equalsIgnoreCase("datetime"))) {
//                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    int colIndex = i;
//                    for (int j = 0; j < list.size(); j++) {
//                        List row = list.get(j);
//                        try {
//                            if (type.trim().equalsIgnoreCase("date")) {
//                                SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATEFORMAT).trim());
//                                if (row.get(i) != null && !row.get(i).toString().trim().equalsIgnoreCase("")) {
//                                    row.set(colIndex, sdf.format(df.parse((String) row.get(colIndex))));
//                                }
//                            } else if (type.trim().equalsIgnoreCase("datetime")) {
//                                SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATETIMEFORMAT).trim());
//                                if (row.get(i) != null && !row.get(i).toString().trim().equalsIgnoreCase("")) {
//                                    row.set(colIndex, sdf.format(df.parse((String) row.get(colIndex))));
//
//                                }
//                            }
//                        } catch (ParseException ex) {
//                            Logger.getLogger(LandingPageCtrl.class
//                                    .getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public boolean isColumnRederable(String columnHeader) {
//        boolean status = true;
//        String columnHeaderVar = headerDisplayNameVarMap.get(columnHeader);
//        if (columnHeaderVar != null && PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHORE)) {
//            status = !((ArrayList) landingPageDatasHm.get("hideInShore")).contains(columnHeaderVar);
//        } else if (columnHeaderVar != null && PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHIP)) {
//            status = !((ArrayList) landingPageDatasHm.get("hideInShip")).contains(columnHeaderVar);
//        }
//        return status;
//    }
//
//    public void exportClicked() {
//        model.getDataModel().setDiaplay("display:none");
//        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
//        RequestContext.getCurrentInstance().update("dlg1");
//
//    }
//
//    public void exporttoExcelClicked() {
//        exportExcelClicked("Export to excel");
//    }
//
//    public void exporttoExcelallClicked() {
//        exportExcelClicked("Export to excel all");
//    }
//
//    public void exporttoPdfClicked() {
//        exportExcelClicked("Export to pdf");
//    }
//
//    public void exporttoPdfallClicked() {
//        exportExcelClicked("Export to pdf all");
//    }
//
//    public void exporttoCsvClicked() {
//        exportExcelClicked("Export to csv");
//    }
//
//    public void exporttoCsvallClicked() {
//        exportExcelClicked("Export to csv all");
//    }
//
//    public void exportExcelClicked(String selectedexport) {
//        List itlist = new ArrayList();
//        List allitlist = new ArrayList();
//        List grpitlist = new ArrayList();
//        List newitlist = new ArrayList();
//        List countlist = new ArrayList();
//        List expcolumnHeaderLst = new ArrayList();
//        List expcolumnTypeLst = new ArrayList();
//        List expcolumnFormatLst = new ArrayList();
//        int lesscnt = 0;
////        String selectedexport = model.getDataModel().getSelectedexport();
//        List hiddenValueList = new ArrayList();
//        Map<String, Map> columnMap = new LinkedHashMap<>();
//        Map<String, String> propertiesMap = new HashMap<>();
//        System.out.println("insddjh exportExcelClicked==>" + selectedexport);
//        model.getDataModel().getRowsLstToExport().clear();
//        model.getDataModel().getRowsLstToExport().addAll(model.getDataModel().getSm_rowsLst());
//
//        if (selectedexport.equalsIgnoreCase("Export to excel") || selectedexport.equalsIgnoreCase("Export to pdf") || selectedexport.equalsIgnoreCase("Export to csv")) {
//
//            for (int y = 0; y < toggleList.size(); y++) {
//                if (toggleList.get(y).toString().equalsIgnoreCase("false")) {
//                    lesscnt = y - 1;
//                    countlist.add(lesscnt);
//                }
//            }
//            System.out.println("oasdn countlist==>" + countlist);
//            for (int b = 0; b < columnHeaderLst.size(); b++) {
//                if (!countlist.contains(b)) {
//                    expcolumnHeaderLst.add(columnHeaderLst.get(b));
//                    expcolumnTypeLst.add(columnTypeLst.get(b));
//                    expcolumnFormatLst.add(columnFormatLst.get(b));
//                }
//            }
//            expcolumnHeaderLst.stream().forEach(col -> {
//                propertiesMap.put("type", (String) expcolumnTypeLst.get(expcolumnHeaderLst.indexOf(col)));
//                propertiesMap.put("format", (String) expcolumnFormatLst.get(expcolumnHeaderLst.indexOf(col)));
//                columnMap.put((String) col, propertiesMap);
//            });
//            if (!countlist.isEmpty()) {
//                for (int m = 0; m < model.getDataModel().getRowsLstToExport().size(); m++) {
//                    itlist = new ArrayList();
//                    itlist = model.getDataModel().getRowsLstToExport().get(m);
//                    newitlist = new ArrayList();
//                    for (int k = 0; k < itlist.size(); k++) {
//                        if (!countlist.contains(k)) {
//                            newitlist.add(itlist.get(k));
//                        }
//                    }
//                    grpitlist.add(newitlist);
//                }
//                allitlist.addAll(grpitlist);
//            }
//            if (!allitlist.isEmpty()) {
//                model.getDataModel().getRowsLstToExport().clear();
//                model.getDataModel().getRowsLstToExport().addAll(allitlist);
//            }
//            System.out.println("oiasn allitlist===>" + allitlist);
//            System.out.println("inside export====>" + model.getDataModel().getMdlId() + "==sm_title=" + model.getDataModel().getSm_title() + "====exce===" + IFileExport.FileType.EXCEL + "==columnMap==>" + columnMap + "==uhfueu7777===>" + model.getDataModel().getRowsLstToExport() + "====jdddh0090===>" + hiddenValueList);
//            if (selectedexport.equalsIgnoreCase("Export to excel")) {
////        System.out.println("EXPORT BUTTON CLICKED ??????????????? " + model.getDataModel().getRowsLstToExport());            
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.EXCEL, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            } else if (selectedexport.equalsIgnoreCase("Export to pdf")) {
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.PDF, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            } else if (selectedexport.equalsIgnoreCase("Export to csv")) {
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.CSV, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            }
//        } else if (selectedexport.equalsIgnoreCase("Export to excel all") || selectedexport.equalsIgnoreCase("Export to pdf all") || selectedexport.equalsIgnoreCase("Export to csv all")) {
////            model.getDataModel().getRowsLstToExport().addAll(model.getDataModel().getSm_rowsLst());
//
//            columnHeaderLst.stream().forEach(col -> {
//                propertiesMap.put("type", (String) columnTypeLst.get(columnHeaderLst.indexOf(col)));
//                propertiesMap.put("format", (String) columnFormatLst.get(columnHeaderLst.indexOf(col)));
//                columnMap.put((String) col, propertiesMap);
//            });
//            System.out.println("inside export====>" + model.getDataModel().getMdlId() + "==sm_title=" + model.getDataModel().getSm_title() + "====exce===" + IFileExport.FileType.EXCEL + "==columnMap==>" + columnMap + "==uhfueu7777===>" + model.getDataModel().getRowsLstToExport() + "====jdddh0090===>" + hiddenValueList);
//            if (selectedexport.equalsIgnoreCase("Export to excel all")) {
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.EXCEL, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            } else if (selectedexport.equalsIgnoreCase("Export to pdf all")) {
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.PDF, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            } else if (selectedexport.equalsIgnoreCase("Export to csv all")) {
//                fileexp.exportToFile(model.getDataModel().getMdlId(), model.getDataModel().getSm_title(), IFileExport.FileType.CSV, (Map) columnMap, model.getDataModel().getRowsLstToExport(), hiddenValueList);
//            }
//        }
//    }
//
//    // VDS Logics starts    
//    private <T> T invokeGetterService(String strServiceName, String tablealias, HashMap whereFields, Class<T> resultType, String serviceType, Map<String, String> mDataMap) {
//        T result = null;
//        SvmJsonUtil jsonUtil;
//        SvmJsonList spParam = new SvmJsonList();
//        String vdstenant = "MAC";
//        try {
//            jsonUtil = new SvmJsonUtil();
////            if (serviceType.equalsIgnoreCase("TLV")) {
//
////            } else {
//            System.out.println("inisde invokeGetterService without thirdlevel====>");
//            if (serviceType != null && serviceType.equalsIgnoreCase("DS")) {
////                this.serviceInvoker.setService(strServiceName, NFRUtils.getUserData().getCarrierCode());
//                this.serviceInvoker.setService(strServiceName, vdstenant);
//            }
//
//            LinkedTreeMap mainLTM = (LinkedTreeMap) whereFields.get("viewinput");
//            if (mainLTM != null) {
//                Iterator itr = mainLTM.keySet().iterator();
//                while (itr.hasNext()) {
//                    String key = itr.next().toString();
//                    LinkedTreeMap whereFieldsFinalHm = (LinkedTreeMap) mainLTM.get(key);
//                    System.out.println("inisde whereFieldsFinalHm===>" + whereFieldsFinalHm + "===spParam===>" + spParam + "==mDataMap===>" + mDataMap);
//                    addWhereFieldToServiceInvoker(this.serviceInvoker, whereFieldsFinalHm, spParam, mDataMap);
//                }
//                if (serviceType != null && serviceType.equalsIgnoreCase("DS")) {
//                    System.out.println("in side DS !@#$%&^*(((((((((((((((((((((((((((((^&^&^&^&^ ");
//                    this.serviceInvoker.execute();
//                } else {
//                    System.out.println("in side SP !@#$%&^*(((((((((((((((((((((((((((((^&^&^&^&^ ");
//                    this.serviceInvoker.invokeFunction(strServiceName, vdstenant, spParam);
//                }
//                if (this.serviceInvoker.getStatus() == 200) {
//                    if (this.serviceInvoker.getResultSet(tablealias) != null) {
//                        String jsonString = this.serviceInvoker.getResultSet(tablealias).toString();
//                        result = (T) jsonUtil.toObject(jsonString, resultType);
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    private void addWhereFieldToServiceInvoker(VDSInvoker vds, LinkedTreeMap whereFields, SvmJsonList spParam, Map<String, String> mDataMap) {
//        String columnName = "";
//        String columnValue = "";
//        String dpname = "";
//        if (vds != null && whereFields != null) {
//            Iterator itr = whereFields.keySet().iterator();
//            while (itr.hasNext()) {
//                String key = itr.next().toString();
//                if (key != null && key.equalsIgnoreCase("fieldname")) {
//                    String fieldName = whereFields.get(key).toString();
//                    //                    -------for filter---------------- 
////                    System.out.println("hiiu  fieldName==>" + fieldName);
//                    if (defaultselradio.containsKey(fieldName)) {
//                        dpname = defaultselradio.get(fieldName).toString();
//                        columnName = fieldName.trim();
//                        columnValue = filterValuehm.get(dpname.trim()).toString();
////                        System.out.println("nnd dpname====> " + dpname);
//                        spParam.add(filterValuehm.get(dpname));
//                    } else if (defaultselchk.containsKey(fieldName)) {
//                        dpname = defaultselchk.get(fieldName).toString();
//                        columnName = dpname.trim();
//                        columnValue = dpname.trim();
//                        spParam.add(dpname);
//                    } //                    -------------------------                    
//                    else if (datehashmap.containsKey(fieldName)) {
//                        dpname = datehashmap.get(fieldName).toString();
//                        columnName = fieldName.trim();
//                        columnValue = dpname;
//                        spParam.add(dpname);
//
//                    } else {
//                        if (fieldName.trim().length() > 0) {
//                            columnName = fieldName.trim();
//                            columnValue = mDataMap.get(fieldName.trim());
//                            spParam.add(mDataMap.get(fieldName));
//                        }
//                    }
//
//                }
//            }
//            System.out.println("spParam ?????????????????? " + spParam);
//            vds.setWhere(columnName, columnValue);
//        }
//    }
//
//    public String deleteRow(String moduleId, ArrayList condToDel) throws Exception {
//        String rstString = "";
//        String deleteServiceName = "";
//        try {
//            CompleteModel compModelObj = service.getdynamiclandingpage(moduleId); // From dynamiclandingpage table
//            for (Dynamiclandingpage dynamicPageObj : compModelObj.getDynamiclandingpage()) {
//                deleteServiceName = dynamicPageObj.getDeleteservice();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rstString;
//    }
//
//    public Map saveUserTablePreferences(CompleteModel completeModel, String validate, CompleteModel userPreference) {
//        Map userPref;
//        System.out.println("indhs validate===>" + validate);
//        if (validate.equalsIgnoreCase("save")) {
//            System.out.println("inside setusertablepreferences====>");
//            userPref = service.setusertablepreferences(completeModel);
//        } else {
//            System.out.println("inside putusertablepreferences====>");
//            completeModel.getUserTablePreferences().get(0).setId(userPreference.getUserTablePreferences().get(0).getId());
//            userPref = service.putusertablepreferences(completeModel);
//        }
//        return userPref;
//    }
//
//    public boolean checkFormsOrOthers(String mdlId) {
//        boolean formsPage = true;
//        CompleteModel userPreference = service.getworkflowmappingid(mdlId.trim(), "A");
//        if (userPreference.getWorkflowmapping().isEmpty()) {
//            formsPage = false;
//        } else {
//            formsPage = true;
//        }
//        CompleteModel wrkFlowIdCreate = service.getworkflowmappingid(model.getDataModel().getMdlId().trim(), PROJECTTYPE.trim(), PROJECTTYPE.trim(), "A");
//        System.out.println("wrkFlowIdCreate SIZEEEEEEEEE " + wrkFlowIdCreate.getWorkflowmapping().size());
//        if (!wrkFlowIdCreate.getWorkflowmapping().isEmpty()) {
//            formCreationWFID = wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid().trim();
//            if (wrkFlowIdCreate.getWorkflowmapping().get(0).getIsdynamicmdl() != null && wrkFlowIdCreate.getWorkflowmapping().get(0).getIsdynamicmdl().trim().equalsIgnoreCase("Y")) {
//                isDynamicMdl = true;
//            } else {
//                isDynamicMdl = false;
//            }
//        }
//        System.out.println("isDynamicMdl ??????????????? IN checkFormsOrOthers ????????? " + isDynamicMdl);
//        System.out.println("formsPage ???????????????? " + formsPage);
//        return formsPage;
//    }
//
//    public void setStatusdescindex(int statusdescindex) {
//        this.statusdescindex = statusdescindex;
//    }
//
//    //    ----------------------for button-------------
//    public void columnheaderButton() {
//        ArrayList list = new ArrayList();
//        ArrayList columnvaluelist = new ArrayList();
//        ArrayList groupbuttonlist = new ArrayList();
//        ButtonActionColumn vo = new ButtonActionColumn();
//        String displayname = "";
//        System.out.println("inside button map===>" + buttonMap);
//        Iterator itrbutton = buttonMap.keySet().iterator();
//        while (itrbutton.hasNext()) {
//            String groupcolumnName = itrbutton.next().toString();
////            System.out.println("inisde groupcolumnName===>" + groupcolumnName);
//            groupbuttonlist.add(groupcolumnName);
//        }
//        if (groupbuttonlist != null) {
//            for (int m = 0; m < groupbuttonlist.size(); m++) {
//                Iterator itr = groupbuttonHeaders.keySet().iterator();
//                while (itr.hasNext()) {
//                    String columnName = itr.next().toString();
////                    System.out.println("onode groupbuttonlist columnName==>" + columnName);
//                    if (groupbuttonlist.get(m).toString().equalsIgnoreCase(columnName)) {
//                        displayname = (String) buttonMap.get(columnName);
////                        System.out.println("inide buttonMap displayname==>" + displayname);
//                        columnvaluelist.add(displayname);
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < columnvaluelist.size(); i++) {
//            vo = new ButtonActionColumn();
//            vo.setColumnheader(columnvaluelist.get(i).toString());
//            list.add(vo);
//            model.getDataModel().setColumnhearderbuttonlist(list);
//            RequestContext.getCurrentInstance().update("landingPageForm");
//        }
//    }
//
//    public void navigateNewColumnClicked(int colIndex, String statusDesc) {
//        try {
//            boolean navigatefalgbool;
////            System.out.println("inide indexcolumnmap navigateNewColumnClicked====>" + colIndex + "====statusDesc==>" + statusDesc);
//            ArrayList lstToNew = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRowButton");
//            navigatefalgbool = (boolean) newnavigateflag.get(colIndex);
////            System.out.println("iod applyBPM===>" + applyBPM + "===lstToNew====>" + lstToNew.size());
//            if (applyBPM) {
////                System.out.println(bpmWFID + "isDynamicMdl navigateNewColumnClicked??????????????? IN NEW CICKED ????????? " + isDynamicMdl);
//                StatusVo initStatus = new StatusVo();
//                LandingDataVo landingdata = new LandingDataVo();
//                landingdata.setData(lstToNew);
//                landingdata.setIsBPMEnabled(true);
//                landingdata.setAction(LandingDataVo.LandingAction.NEW);
//                landingdata.setTasksummary(new TaskSummaryVo());
//                landingdata.setWfid(formCreationWFID);
//                landingdata.setBpmwfid(bpmWFID);
//                landingdata.setIsDynamicMdl(isDynamicMdl);
//                if (!isDynamicMdl) {
//                    initStatus = smbpmUtil.hasRightsToIntiateProcess(formCreationWFID, mData.getMetaData(USERINFO.USERCODE).trim());
//                    System.out.println("initStatus.STSTUS ?????????????????????????????? " + initStatus.getStatus());
//                    if (initStatus.getStatus() == StatusVo.STATUS.SUCCESS) {
//                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl.get(colIndex).toString(), landingdata, navigatefalgbool);
////                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                    } else {
//                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
//                    }
//                } else {
//                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl.get(colIndex).toString(), landingdata, navigatefalgbool);
//                }
//
//            } else {
//                System.out.println("### Master New Action ==>" + redirectMdlId);
//                LandingDataVo landingdata = new LandingDataVo();
//                landingdata.setData(lstToNew);
//                landingdata.setAction(LandingDataVo.LandingAction.NEW);
//                landingdata.setTasksummary(null);
//                landingdata.setWfid(null);
//                NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl.get(colIndex).toString(), landingdata, navigatefalgbool);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void navigateViewColumnClicked(int colIndex, String statusDesc) {
//        System.out.println("inisde navigateViewColumnClicked====>");
//        try {
////            System.out.println("inide indexcolumnmap navigateViewColumnClicked====>" + colIndex + "====statusDesc==>" + statusDesc);
//            int index = 0;
//            String mdlcode = "";
//            LinkedTreeMap allvalue = null;
//            LinkedTreeMap viewallvalue = null;
//            ArrayList lstToView = null;
//            LandingDataVo landingdata = new LandingDataVo();
//            boolean navigateflag;
//            Iterator itr = indexcolumnmap.keySet().iterator();
//            while (itr.hasNext()) {
//                String key = itr.next().toString();
//                index = (int) indexcolumnmap.get(key);
//                if (colIndex == index) {
//                    model.getStateModel().setCommandlinkrender(true);
//                    if (groupbuttonHeaders.containsKey(key)) {
//                        allvalue = (LinkedTreeMap) groupbuttonHeaders.get(key);
////                        System.out.println("insde allvalue===>" + allvalue);
//                        if (allvalue.containsKey("view")) {
//                            viewallvalue = (LinkedTreeMap) allvalue.get("view");
//                            mdlcode = (String) viewallvalue.get("targetmdl");
////                            System.out.println("inide mdlcode  viwewe====>" + mdlcode);
//                            lstToView = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRowButton");
//                            landingdata.setData(lstToView);
//                            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
//                            landingdata.setIsDynamicMdl(isDynamicMdl);
//                            if (applyBPM) {
//                                System.out.println("last index ?????????? " + lstToView.get(lstToView.size() - 1).toString());
//                                String lastIndexVal = lstToView.get(lstToView.size() - 1).toString();
//                                if (lastIndexVal.trim().contains("~")) {
//                                    String[] latColVal = lastIndexVal.trim().split("~");
//                                    System.out.println("latColVal ??????????? in view clicked ?????? " + latColVal);
//                                    WFID = latColVal[0].trim();
//                                    bpmWFID = latColVal[1].trim();
//                                } else {
//                                    WFID = "-";
//                                    bpmWFID = "";
//                                }
//                                landingdata.setBpmwfid(bpmWFID);
//                                landingdata.setWfid(WFID);
//                                if (refnoTaskSummaryMap.get(((String) lstToView.get(refnofieldIndex)).trim().toLowerCase()) != null) {
//                                    TaskSummaryVo taskSummary = refnoTaskSummaryMap.get(((String) lstToView.get(refnofieldIndex)).trim().toLowerCase());
//                                    landingdata.setTasksummary(taskSummary);
//                                }
//                                landingdata.setIsBPMEnabled(true);
//                            } else {
//                                landingdata.setTasksummary(null);
//                            }
//                            landingdata.getData().add(0, lstToView.get(refnofieldIndex));
//                            if (viewallvalue.containsKey("navigateflag")) {
//                                navigateflag = (boolean) viewallvalue.get("navigateflag");
////                                System.out.println("insdk view navigateflag===>" + navigateflag);
//                            } else {
//                                navigateflag = false;
//                            }
////                            System.out.println("insdk ouetr view navigateflag===>" + navigateflag);
//                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata, navigateflag);
//                            RequestContext.getCurrentInstance().update("landingPageForm");
//                        }
//                    }
//                }
//            }
//            RequestContext.getCurrentInstance().update("landingPageForm");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void navigateEditColumnClicked(int colIndex, String statusDesc) {
//        System.out.println("inisde navigateEditColumnClicked====>");
//        try {
//            int index = 0;
//            String mdlcode = "";
//            LinkedTreeMap allvalue = null;
//            LinkedTreeMap editallvalue = null;
//            ArrayList lstToEdit = null;
//            TaskSummaryVo taskSummary = new TaskSummaryVo();
//            LandingDataVo landingdata = new LandingDataVo();
//            boolean navigateflag;
//            Iterator itr = indexcolumnmap.keySet().iterator();
//            while (itr.hasNext()) {
//                String key = itr.next().toString();
//                index = (int) indexcolumnmap.get(key);
////                System.out.println("inide indexcolumnmap key index====>" + index);
//                if (colIndex == index) {
//                    if (groupbuttonHeaders.containsKey(key)) {
//                        allvalue = (LinkedTreeMap) groupbuttonHeaders.get(key);
////                        System.out.println("insde allvalue===>" + allvalue);
//                        if (allvalue.containsKey("edit")) {
//                            editallvalue = (LinkedTreeMap) allvalue.get("edit");
//                            model.getStateModel().setCommandlinkrender(true);
//                            mdlcode = (String) editallvalue.get("targetmdl");
////                            System.out.println("inide mdlcode  edittargetmdl====>" + mdlcode);
//                            lstToEdit = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRowButton");
//                            landingdata.setData(lstToEdit);
//                            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
//                            landingdata.setIsDynamicMdl(isDynamicMdl);
//                            if (applyBPM) {
////                                System.out.println("inii refnoTaskSummaryMap==>" + refnoTaskSummaryMap);
////                                System.out.println("infifr ujio===>" + refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase()));
//                                if (refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase()) != null) {
//                                    taskSummary = refnoTaskSummaryMap.get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase());
//
//                                }
//                                String[] latColVal = lstToEdit.get(lstToEdit.size() - 1).toString().split("~");
//                                WFID = latColVal[0].trim();
//                                bpmWFID = latColVal[1].trim();
//                                System.out.println("bpmWFID ??? in EDIT CLICKED ??????????? " + bpmWFID);
//                                landingdata.setBpmwfid(bpmWFID);
//                                landingdata.setWfid(WFID);
//                                landingdata.setIsBPMEnabled(true);
//                                boolean rarEditRights = false;
//                                if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("ART")) {
//                                    CompleteModel wrkFlowId = service.getworkflowmappingid("RAR", PROJECTTYPE.trim(), "V");
//                                    if (!wrkFlowId.getWorkflowmapping().isEmpty()) {
//                                        System.out.println("unj wrkFlowId===>");
//                                        rarEditRights = smbpmUtil.hasClaimRights(wrkFlowId.getWorkflowmapping().get(0).getWorkflowid().trim(),
//                                                taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim());
//                                    }
//                                }
//                                System.out.println("inif rarEditRights===>" + rarEditRights + "===has==" + smbpmUtil.hasClaimRights(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim())
//                                        + "====tasksumm===" + smbpmUtil.hasClaimRightsDynamic(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim()));
//
//                                if (rarEditRights || smbpmUtil.hasClaimRights(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim()) || smbpmUtil.hasClaimRightsDynamic(WFID, taskSummary.getNodeid(), mData.getMetaData(USERINFO.USERCODE).trim())) {
//                                    StatusVo claimStatus = smbpmUtil.claimTask(taskSummary, mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());
//                                    System.out.println("BPM Edit call result status ========>" + claimStatus.getStatus());
//                                    landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
//                                    landingdata.setStatus(claimStatus.getStatus());
//                                    if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED) {
//                                        System.out.println("BPM Edit iif ========>" + claimStatus.getStatus());
//                                        taskSummary = claimStatus.getTaskSummaryVo();
//                                        landingdata.setTasksummary(taskSummary);
//                                        landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
//                                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                                    } else {
//                                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
//
//                                    }
//                                } else {
//                                    dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
//                                }
//                            } else {
//                                landingdata.setTasksummary(null);
//                                landingdata.setWfid(null);
//                                landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
//                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
//                            }
//                            if (editallvalue.containsKey("navigateflag")) {
//                                navigateflag = (boolean) editallvalue.get("navigateflag");
//                            } else {
//                                navigateflag = false;
//                            }
//                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata, navigateflag);
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
////    ---------------------------------------------
////    --------------------------for filter---------------------
//
//    public void selectedRadioBtn() {
//        System.out.println("inside selectedRadioBtn()*************");
//        try {
//            SingleChoiceRadioVo vo = new SingleChoiceRadioVo();
//            ArrayList all = model.getDataModel().getRepeatradioallitems();
//            for (int i = 0; i < all.size(); i++) {
//                vo = (SingleChoiceRadioVo) all.get(i);
//                System.out.println("Inside inner vo.getFieldsetval();===>" + vo.getSelectedradiobtn());
//                filtergetfieldname.get(vo.getSelectedradiobtn());
//                defaultselradio.put(filtergetfieldname.get(vo.getSelectedradiobtn()), vo.getSelectedradiobtn());
//
//            }
//            System.out.println("Inside defaultselradio===>" + defaultselradio);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void selectedCheckBox() {
//        defaultselchk.clear();
//        System.out.println("inisde chkbox===>" + model.getDataModel().getSelectedchkbox());
//        String fldname = "";
//        String dspname = "";
//        for (int k = 0; k < model.getDataModel().getSelectedchkbox().size(); k++) {
//            System.out.println("inide model.getDataModel().getSelectedchkbox()==>" + model.getDataModel().getSelectedchkbox().get(k));
//            fldname = filtergetfieldname.get(model.getDataModel().getSelectedchkbox().get(k)).toString();
//            dspname = model.getDataModel().getSelectedchkbox().get(k).toString();
//            System.out.println("jksdv selectedCheckBox==>" + fldname + "=-=ndspname" + dspname);
//            defaultselchk.put(fldname, dspname);
//        }
//        System.out.println("hiudsfn chk radio===>" + defaultselchk);
//    }
//
//    public void selectedCalendar() {
//        System.out.println("inisde selectedCalendar==>");
//        try {
//            SingleChoiceRadioVo vo = new SingleChoiceRadioVo();
//            ArrayList all = model.getDataModel().getDaterepeatlist();
//            for (int i = 0; i < all.size(); i++) {
//                vo = (SingleChoiceRadioVo) all.get(i);
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                String m = formatter.format(vo.getFromdate());
//                System.out.println("idjkss formatter SimpleDateFormat====&&&&>" + m);
//                String fieldname = dspflddate.get(vo.getOpvaluedate()).toString();
//                datehashmap.put(fieldname, m);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showFilterSession() {
//        try {
//            showFilterClicked(model.getDataModel().getMdlId(), loginName, mDataMap, mData.getMetaData(APPINFO.RANK_CODE));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showFilterClicked(String moduleId, String loginName, Map<String, String> mDataMap, String rankCode) throws Exception {
//        System.out.println("===showFilterClicked========>");
//        showmoduleid = moduleId;
//        Map resultHm = new HashMap();
//        Map columnDataHMfilter = null;
//        HashMap viewInputHm = null;
//        LinkedTreeMap filtercolumnHeaders = null;
//        ArrayList filterradioallcolumnHeaderLst = new ArrayList();
//        List filterradioinputfieldnameLst = new ArrayList();
//        List filterchkallcolumnHeaderLst = new ArrayList();
//        List filterchkinputfieldnameLst = new ArrayList();
//        List filteripfieldallcolumnHeaderLst = new ArrayList();
//        List filteripfieldinputfieldnameLst = new ArrayList();
//        List columnTypeLst = new ArrayList();
//        List columnFormatLst = new ArrayList();
//        Map headerDisplayNameVarMap = new HashMap();
//        SvmJsonUtil jsonUtil = new SvmJsonUtil();
//        String viewServiceName = "";
//        String viewIdentifier = "";
//        String landingPageTitleName = "";
//        String redirectMdlId = "";
//        Boolean isAllowEdit = false;
//        Boolean isAllowCreate = false;
//        String serviceType = "";
//        String grpCode = "";
////        --------Durga-----------------
//        List spancolumnHeaderLst = new ArrayList();
//        ArrayList defaultchklst = new ArrayList();
//        List spansubcolumnHeaderLst = new ArrayList();
//        String groupid = "";
//        List al = new ArrayList();
//        String filteroptiontype1;
//        String fieldsetgroupid;
//        SingleChoiceRadioVo singleChoiceRadioVo = new SingleChoiceRadioVo();
//        ArrayList repeatList = new ArrayList();
//        ArrayList dateList = new ArrayList();
//        String lnkhmkey = "";
//        String lnkhmval = "";
//        String dispnameradio = "";
//        String dispnamedate = "";
//        ArrayList gropidlist = new ArrayList();
//        try {
//            CompleteModel compModelObj = service.getdynamiclandingpage(moduleId); // From dynamiclandingpage table
//            CompleteModel moduleRightsCompModeObj = service.gemodulerights(moduleId, loginName);
//            VDSWorkflowGroupMappingModel vDSWorkflowGroupMappingModel = service.getworkflowgrpmapping(rankCode);
//            if (!vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().isEmpty()) {
//                grpCode = vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().get(0).getGrpcode();
//
//            }
//            for (Dynamiclandingpage dynamicPageObj : compModelObj.getDynamiclandingpage()) {
//                columnDataHMfilter = (HashMap) jsonUtil.toObject(dynamicPageObj.getFilterdefinition(), HashMap.class
//                );
//                viewServiceName = dynamicPageObj.getViewservicename();
//                viewInputHm = (HashMap) jsonUtil.toObject(dynamicPageObj.getViewinput(), HashMap.class);
//                viewIdentifier = dynamicPageObj.getViewidentifier();
//                landingPageTitleName = dynamicPageObj.getTitle();
//                redirectMdlId = dynamicPageObj.getMdlid();
//                serviceType = dynamicPageObj.getViewtype();
//            }
//            for (Dynamiclandingpage dynamicPageObj : moduleRightsCompModeObj.getDynamiclandingpage()) {
//                if (dynamicPageObj.getWriterights() != null && dynamicPageObj.getWriterights().equalsIgnoreCase("Y")) {
//                    if (dynamicPageObj.getAllowedit() != null && dynamicPageObj.getAllowedit().equalsIgnoreCase("Y")) {
//                        isAllowEdit = true;
//                    }
//                    if (dynamicPageObj.getAllowcreate() != null && dynamicPageObj.getAllowcreate().equalsIgnoreCase("Y")) {
//                        isAllowCreate = true;
//                    }
//                }
//            }
//            if (columnDataHMfilter != null) {
//                filtercolumnHeaders = (LinkedTreeMap) columnDataHMfilter.get("filterdetail");
//                Iterator itr = filtercolumnHeaders.keySet().iterator();
//                while (itr.hasNext()) {
//                    String columnName1 = itr.next().toString();
//                    LinkedTreeMap filtercolumnPropHm1 = (LinkedTreeMap) filtercolumnHeaders.get(columnName1);
//                    System.out.println("inide filtercolumnPropHm1==>" + filtercolumnPropHm1);
//                    filteroptiontype1 = (String) filtercolumnPropHm1.get("optiontype");
//                    if (filteroptiontype1.equalsIgnoreCase("singlechoice")) {
//                        groupid = (String) filtercolumnPropHm1.get("groupid");
//                        lnkhmkey = (String) filtercolumnPropHm1.get("inputfieldname");
//                        System.out.println("lnkhmkey==>" + lnkhmkey);
//                        lnkhmval = (String) filtercolumnPropHm1.get("inputfieldvalue");
//                        dispnameradio = (String) filtercolumnPropHm1.get("displayname");
//                        System.out.println("lnkhmkey==>" + lnkhmval);
//                        filterValuehm.put(dispnameradio, lnkhmval);
//                        filterOptchkhm.put(lnkhmkey, filteroptiontype1);
//                        filtergetfieldname.put(dispnameradio, lnkhmkey);
//                        if (!al.contains(groupid)) {
//                            al.add(groupid);
//                        }
//                    } else if (filteroptiontype1.equalsIgnoreCase("checkbox")) {
//                        filterchkallcolumnHeaderLst.add(filtercolumnPropHm1.get("displayname"));
//                        lnkhmkey = (String) filtercolumnPropHm1.get("inputfieldname");
//                        System.out.println("lnkhmkey==>" + lnkhmkey);
//                        lnkhmval = (String) filtercolumnPropHm1.get("inputfieldvalue");
//                        System.out.println("lnkhmkey==>" + lnkhmval);
//                        String defaultchkselection = (String) filtercolumnPropHm1.get("defaultselection");
//                        dispnameradio = (String) filtercolumnPropHm1.get("displayname");
//                        filterValuehm.put(dispnameradio, lnkhmval);
//                        filterOptchkhm.put(lnkhmkey, filteroptiontype1);
//                        filtergetfieldname.put(dispnameradio, lnkhmkey);
//                        if (defaultchkselection.equalsIgnoreCase("Y")) {
//                            defaultchklst.add(filtercolumnPropHm1.get("displayname"));
//                            defaultselchk.put(lnkhmkey, filtercolumnPropHm1.get("displayname").toString());
//                        }
//                    } else if (filteroptiontype1.equalsIgnoreCase("date") || filteroptiontype1.equalsIgnoreCase("datetime")) {
//                        filteripfieldallcolumnHeaderLst.add(filtercolumnPropHm1.get("displayname"));
//                        dispnamedate = (String) filtercolumnPropHm1.get("displayname");
//                        lnkhmkey = (String) filtercolumnPropHm1.get("inputfieldname");
//                        String defaultdateselection = (String) filtercolumnPropHm1.get("defaultselection");
//                        dspflddate.put(dispnamedate, lnkhmkey);
//                        if (defaultdateselection.equalsIgnoreCase("Y")) {
//                            SingleChoiceRadioVo vo = new SingleChoiceRadioVo();
//                            vo.setFromdate(new Date());
//                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                            String mdate = formatter.format(new Date());
//                            System.out.println("idjkss formatter mdate ===" + dispnamedate + "===SimpleDateFormat====&&&&>" + mdate);
//                            filterValuehm.put(lnkhmkey, mdate);
//                            datehashmap.put(lnkhmkey, mdate);
//                        }
//                    }
//                }
//            }
//            System.out.println("nkjkl al.size()==>" + al.size());
//            if (al != null) {
//                for (int i = 0; i < al.size(); i++) {
//                    fieldsetgroupid = al.get(i).toString();
//                    System.out.println("inide fieldsetgroupid===>" + fieldsetgroupid);
//                    model.getDataModel().setFieldsetval(fieldsetgroupid);
//                    filtercolumnHeaders = (LinkedTreeMap) columnDataHMfilter.get("filterdetail");
//                    Iterator itr1 = filtercolumnHeaders.keySet().iterator();
//                    filterradioallcolumnHeaderLst = new ArrayList();
//                    while (itr1.hasNext()) {
//                        singleChoiceRadioVo = new SingleChoiceRadioVo();
//                        String columnName2 = itr1.next().toString();
//                        System.out.println("inide while===>" + columnName2);
//                        LinkedTreeMap filtercolumnPropHm2 = (LinkedTreeMap) filtercolumnHeaders.get(columnName2);
//                        if (filtercolumnPropHm2.containsKey("groupid")) {
//                            groupid = (String) filtercolumnPropHm2.get("groupid");
//                            System.out.println("indie while groupid==>" + groupid);
//                            if (groupid.equalsIgnoreCase(al.get(i).toString())) {
//                                System.out.println("indie groupid===>" + groupid + "if===>" + filtercolumnPropHm2.get("displayname"));
//                                filterradioallcolumnHeaderLst.add(filtercolumnPropHm2.get("displayname"));
//                                String defaultradioselection = (String) filtercolumnPropHm2.get("defaultselection");
//                                if (defaultradioselection.equalsIgnoreCase("Y")) {
//                                    System.out.println("nnkjvnk ----->" + filtercolumnPropHm2.get("displayname").toString());
//                                    String val = filtercolumnPropHm2.get("displayname").toString();
//                                    singleChoiceRadioVo.setSelectedradiobtn(val);
//                                    selradiohshmap.put(groupid, val);
//                                    defaultselradio.put(filtercolumnPropHm2.get("inputfieldname").toString(), val);
//                                    gropidlist.add(groupid);
//                                    if (!fieldsetgroupid.equalsIgnoreCase("")) {
//                                        System.out.println("idhiujxbcjk 90909009090");
//                                        singleChoiceRadioVo.setFieldsetval(fieldsetgroupid);
//                                    }
//                                    singleChoiceRadioVo.setRadioallitems(filterradioallcolumnHeaderLst);
//                                    repeatList.add(singleChoiceRadioVo);
//                                }
//                            }
//                        }
//                    }
//                    if (singleChoiceRadioVo.getFieldsetval() != null) {
//                        System.out.println("insidn ingleChoiceRadioVo.getFieldsetval()%%%%%%%%%%%%");
//                        model.getStateModel().setRadiobtnrender(false);
//                        model.getStateModel().setRadiofieldesetrender(true);
//                    } else {
//                        System.out.println("insidn else ingleChoiceRadioVo.getFieldsetval()%%%%%%%%%%%%");
//                        model.getStateModel().setRadiobtnrender(true);
//                        model.getStateModel().setRadiofieldesetrender(false);
//                    }
//                    model.getStateModel().setRadiobtnrender(true);
//                    model.getDataModel().setRepeatradioallitems(repeatList);
//                    RequestContext.getCurrentInstance().update("landingPageForm");
//                }
//            }
//            System.out.println("kkj filterValuehm===>" + filterValuehm);
//            System.out.println("kkj defaultselradio===>" + defaultselradio);
//            System.out.println("kkj defaultselchk===>" + defaultselchk);
//            System.out.println("kjoi datehashmap&&&&&&===>" + datehashmap);
//            if (filteripfieldallcolumnHeaderLst != null) {
//                for (int j = 0; j < filteripfieldallcolumnHeaderLst.size(); j++) {
//                    singleChoiceRadioVo = new SingleChoiceRadioVo();
//                    singleChoiceRadioVo.setOpvaluedate("");
//                    System.out.println("filteripfieldallcolumnHeaderLst.get(j).toString()==>" + filteripfieldallcolumnHeaderLst.get(j).toString());
//                    singleChoiceRadioVo.setOpvaluedate(filteripfieldallcolumnHeaderLst.get(j).toString());
//
//                    singleChoiceRadioVo.setFromdate(new Date());
//                    model.getStateModel().setInputfieldrender(true);
//                    dateList.add(singleChoiceRadioVo);
//                    model.getDataModel().setDaterepeatlist(dateList);
//                    RequestContext.getCurrentInstance().update("landingPageForm");
//                }
//            }
//            resultHm.put("radioallheaderNames", filterradioallcolumnHeaderLst);
//            resultHm.put("radioallinputfieldnames", filterradioinputfieldnameLst);
//            resultHm.put("radioallinputfieldvalue", filterradioallcolumnHeaderLst);
//            resultHm.put("radioalldefaultselection", filterradioallcolumnHeaderLst);
//
//            resultHm.put("chkallheaderNames", filterchkallcolumnHeaderLst);
//            resultHm.put("chkallinputfieldnames", filterchkinputfieldnameLst);
//            resultHm.put("chkallinputfieldvalue", filterradioallcolumnHeaderLst);
//            resultHm.put("chkalldefaultselection", filterradioallcolumnHeaderLst);
//
//            resultHm.put("ipfieldallheaderNames", filteripfieldallcolumnHeaderLst);
//            resultHm.put("ipfieldallinputfieldnames", filteripfieldinputfieldnameLst);
//            resultHm.put("ipfieldallinputfieldvalue", filterradioallcolumnHeaderLst);
//            resultHm.put("ipfieldalldefaultselection", filterradioallcolumnHeaderLst);
//            if (filterradioinputfieldnameLst != null) {
//                model.getStateModel().setRadiobtnrender(true);
//            } else {
//                model.getStateModel().setRadiobtnrender(false);
//            }
//            if (filterchkinputfieldnameLst != null) {
//                model.getDataModel().setSelectedchkbox(defaultchklst);
//                model.getDataModel().setChkboxallitems(filterchkallcolumnHeaderLst);
//                model.getStateModel().setChkboxrender(true);
//            } else {
//                model.getStateModel().setChkboxrender(true);
//            }
//            if (filteripfieldinputfieldnameLst != null) {
//                model.getStateModel().setInputfieldrender(true);
//            } else {
//                model.getStateModel().setInputfieldrender(true);
//            }
//            model.getStateModel().setFiltersessionrender(true);
//            model.getStateModel().setRefreshbtnrender(true);
//            model.getStateModel().setClosebtnrender(true);
//            RequestContext.getCurrentInstance().update("landingPageForm");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void refreshbtnClicked() {
//        System.out.println("inisde refreshbtnClicked===>");
//        refresh = true;
//        try {
//            importExcelButton();
//            checkFormsOrOthers();
//            initializeLandingPage();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        RequestContext.getCurrentInstance().update("landingPageForm");
//    }
//
//    public String selecradiohashmap(String fieldval) {
//        System.out.println("injfn fieldval===$$$$>" + fieldval);
//        System.out.println("ijn selradiohshmap===>" + selradiohshmap);
//        return selradiohshmap.get(fieldval).toString();
//    }
//
////    -------------------------for filter end---------------------------
//    public Map getLandingPageDatas(String moduleId, String loginName, Map<String, String> mDataMap, String rankCode) throws Exception {
//        Map resultHm = new HashMap();
//        Map columnDataHM = null;
//        Map columnDataHMaction = null;
//        HashMap viewInputHm = null;
//        LinkedTreeMap columnHeaders = null;
//        List columnOrderLst = null;
//        List columnHeaderLst = new ArrayList();
//        List columnTypeLst = new ArrayList();
//        List columnFormatLst = new ArrayList();
//        List tmpColHeaderNamesLst = new ArrayList();
////        Map headerDisplayNameVarMap = new HashMap();
//        List dataLst = null;
//        SvmJsonUtil jsonUtil = new SvmJsonUtil();
//        String viewServiceName = "";
////        String viewIdentifier = "";
//        String landingPageTitleName = "";
//        String redirectMdlId = "";
//        Boolean isAllowEdit = false;
//        Boolean isAllowCreate = false;
//        String serviceType = "";
//        String displayname;
//        String viewbutton;
//        String editbutton;
//        String refnofield = "";
//        String statusdesc = "";
//        String bpmwrkflowidscript = "";
//        String grpCode = "";
//        String thirdlevelServiceName = "";
//        String thirdlevelvalidation = "";
//        String applyhandlybyuserlogic = "";
//        HashMap statusntchkhl = null;
//
////        --------Durga-----------------
//        LinkedTreeMap spancolumnHeaders = null;
//        LinkedTreeMap spansubshipcolumnHeaders = null;
//        LinkedTreeMap spansubshorecolumnHeaders = null;
//        List spancolumnHeaderLst = new ArrayList();
//        List allcolumnHeaderLst = new ArrayList();
//        List spansubcolumnHeaderLst = new ArrayList();
//        int indexmapi = 0;
////        ---------editidenty---------------
//        LinkedTreeMap editidentifierHeaders = null;
//        String editidentifiercolumn = "";
//        String viewrenidentifiercolumn = "";
//        String editrenidentifiercolumn = "";
//        String newrenidentifiercolumn = "";
//        List editidentifiervalues = new ArrayList();
//        int indexcolumni = 0;
//
//        LinkedTreeMap viewrenidentifierHeaders = null;
//        List viewrenidentifiervalues = new ArrayList();
//        int viewrenindexcolumni = 0;
//
//        LinkedTreeMap editrenidentifierHeaders = null;
//        List editrenidentifiervalues = new ArrayList();
//        int editrenindexcolumni = 0;
//
//        LinkedTreeMap newrenidentifierHeaders = null;
//        List newrenidentifiervalues = new ArrayList();
//        int newrenindexcolumni = 0;
//        List statusntchkhllist = new ArrayList();
//
////        -----------------------
////        -------------------
//        try {
//            CompleteModel compModelObj = service.getdynamiclandingpage(moduleId); // From dynamiclandingpage table
////            CompleteModel moduleRightsCompModeObj = service.gemodulerights(moduleId, loginName);
//            VDSWorkflowGroupMappingModel vDSWorkflowGroupMappingModel = service.getworkflowgrpmapping(rankCode);
//            if (!vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().isEmpty()) {
//                grpCode = vDSWorkflowGroupMappingModel.getWrkflowgrpmapping().get(0).getGrpcode();
//            }
//            for (Dynamiclandingpage dynamicPageObj : compModelObj.getDynamiclandingpage()) {
//                System.out.println("inisde dynamicPageObj===>");
//                columnDataHM = (HashMap) jsonUtil.toObject(dynamicPageObj.getColumnmetadata(), HashMap.class);
//                columnDataHMaction = (HashMap) jsonUtil.toObject(dynamicPageObj.getActiondefinition(), HashMap.class);
//                viewServiceName = dynamicPageObj.getViewservicename();
//                viewInputHm = (HashMap) jsonUtil.toObject(dynamicPageObj.getViewinput(), HashMap.class);
//                filterviewInputHm = viewInputHm;
//                viewIdentifier = dynamicPageObj.getViewidentifier();
//                landingPageTitleName = dynamicPageObj.getTitle();
//                redirectMdlId = dynamicPageObj.getMdlid();
//                serviceType = dynamicPageObj.getViewtype();
//                thirdlevelServiceName = dynamicPageObj.getThirdlevelservicename();
//                thirdlevelvalidation = dynamicPageObj.getThirdlevelvalidation();
//                applyhandlybyuserlogic = dynamicPageObj.getApplyhandlebyuserlogic();
//
//                System.out.println("insidn applyhandlybyuserlogic===>" + applyhandlybyuserlogic);
//                statusntchkhl = (HashMap) jsonUtil.toObject(dynamicPageObj.getStatusnottocheckhandlelogic(), HashMap.class);
//                if (statusntchkhl != null) {
//                    statusntchkhllist = (List) statusntchkhl.get("status");
//                }
//
//                if (dynamicPageObj.getAllowcreate()
//                        != null && dynamicPageObj.getAllowcreate().equalsIgnoreCase("Y")) {
//                    System.out.println("inidede dynamicPageObj isAllowCreate===>");
//                    isAllowCreate = true;
//                }
//            }
//            System.out.println("inisde thirdlevelServiceName===>" + thirdlevelServiceName);
//            System.out.println("inisde thirdlevelvalidation===>" + thirdlevelvalidation);
//
////            -------------Durga-----------------------
//            if (columnDataHM != null) {
//                if (columnDataHM.containsKey("columngroup")) {
//                    columngroup = (String) columnDataHM.get("columngroup");
////                System.out.println("inside columngroup====>" + columngroup);
//                } else {
//                    columngroup = "N";
//                }
//                if (refresh == false) {
//                    System.out.println("kdsn inhnhjh refresh===>");
//                    if (columnDataHM.containsKey("hasfilter")) {
//                        hasfilter = (String) columnDataHM.get("hasfilter");
//                        if (hasfilter.equalsIgnoreCase("Y")) {
//                            model.getStateModel().setRefreshbtnrender(true);
//                            showFilterSession();
//                        } else {
//                            model.getStateModel().setFiltersessionrender(false);
//                        }
//                    } else {
//                        hasfilter = "N";
//                        model.getStateModel().setFiltersessionrender(false);
//                    }
//                }
//            }
//            if (columngroup.equalsIgnoreCase("Y")) {
//                model.getStateModel().setColumngrouprender(true);
//                System.out.println("insidde if===>");
//                
//                if (columnDataHM != null) {
//                    columnHeaders = (LinkedTreeMap) columnDataHM.get("prop");
//                    spancolumnHeaders = (LinkedTreeMap) columnDataHM.get("groupprop");
//
//                    spansubshipcolumnHeaders = (LinkedTreeMap) spancolumnHeaders.get("Ship Status");
//                    spansubshorecolumnHeaders = (LinkedTreeMap) spancolumnHeaders.get("Shore Status");
//                    System.out.println("indgs spansubshipcolumnHeaders===>" + spansubshipcolumnHeaders + "====spansubshorecolumnHeaders==>" + spansubshorecolumnHeaders);
//
//                    Iterator itrspanhead = spancolumnHeaders.keySet().iterator();
//                    while (itrspanhead.hasNext()) {
//                        String spncolumnName = itrspanhead.next().toString();
////                        System.out.println("inside spancolumnHeaders spncolumnName===>" + spncolumnName);
//                        spancolumnHeaderLst.add(spncolumnName);
//                    }
//
//                    if (columnDataHM.get("spancolumnorder") == null) {
//                        columnOrderLst.add("");
//                    } else {
//                        columnOrderLst = (ArrayList) columnDataHM.get("spancolumnorder");
//                    }
//                    if (columnDataHM.containsKey("editidentifier")) {
//                        editidentifierHeaders = (LinkedTreeMap) columnDataHM.get("editidentifier");
//                        editidentifiercolumn = (String) editidentifierHeaders.get("column");
//                        editidentifiervalues = (List) (editidentifierHeaders.get("values"));
//                        editidentybool = true;
//                        commonidentybool = true;
//                    }
//                    hideInShore = columnDataHM.containsKey("hideinshore") ? (List) columnDataHM.get("hideinshore") : new ArrayList();
//                    hideInShip = columnDataHM.containsKey("hideinship") ? (List) columnDataHM.get("hideinship") : new ArrayList();
//                    refnofield = columnDataHM.containsKey("refnofield") ? (String) columnDataHM.get("refnofield") : null;
//                    statusdesc = columnDataHM.containsKey("statusdesc") ? (String) columnDataHM.get("statusdesc") : null;
//                    bpmwrkflowidscript = columnDataHM.containsKey("bpmwrkflowid") ? (String) columnDataHM.get("bpmwrkflowid") : null;
//                    defaultaction = columnDataHM.containsKey("defaultaction") ? (String) columnDataHM.get("defaultaction") : "Y";
//                    doubleclickrender = columnDataHM.containsKey("doubleclickrender") ? (String) columnDataHM.get("doubleclickrender") : "Y";
//                }
//                System.out.println("idsj hideInShore>>>" + hideInShore + ">>KK>>>" + hideInShip);
//                if (columnDataHMaction != null && columnDataHMaction.containsKey("groupbutton")) {
//                    System.out.println("inisde groupbutton===>");
//                    groupbuttonHeaders = (LinkedTreeMap) columnDataHMaction.get("groupbutton");
//                }
//
//                if (doubleclickrender.equalsIgnoreCase("N")) {
//                    model.getStateModel().setDoubleclickdisbled(true);
//                } else {
//                    model.getStateModel().setDoubleclickdisbled(false);
//
//                }
//
//                if (columnHeaders != null && spansubshipcolumnHeaders != null && spansubshorecolumnHeaders != null) {
//                    dataSet = invokeGetterService(viewServiceName, viewIdentifier, viewInputHm, List.class, serviceType, mDataMap);
//                    List rowHm = new ArrayList();
//                    if (columnOrderLst != null) {
//                        for (int m = 0; m < columnOrderLst.size(); m++) {
//                            Iterator itr = columnHeaders.keySet().iterator();
//
//                            Iterator shipitr = spansubshipcolumnHeaders.keySet().iterator();
//                            Iterator shoreitr = spansubshorecolumnHeaders.keySet().iterator();
//
//                            while (itr.hasNext()) {
//                                String columnName = itr.next().toString();
//                                if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnName)) {
//                                    LinkedTreeMap columnPropHm = (LinkedTreeMap) columnHeaders.get(columnName);
//                                    displayname = (String) columnPropHm.get("displayname");
//                                    columnHeaderLst.add(displayname);
//                                    allcolumnHeaderLst.add(displayname);
//                                    columnTypeLst.add(columnPropHm.get("type"));
//                                    columnFormatLst.add(columnPropHm.get("format"));
//                                    reodrtmpColHeaderNamesLst.add(displayname);
////                                    reodrtmpColHeaderNamesLst.add(columnName);
//                                    tmpColHeaderNamesLst.add(columnName);
//                                    headerDisplayNameVarMap.put(displayname, columnName);
//                                    columnTypeLstreoderMap.put(displayname, (String) columnPropHm.get("type").toString());
//                                    System.out.println("inisde hideInShip.contains(columnName)-===>" + hideInShip + ">>>>>" + columnName);
//                                    if (hideInShip.contains(columnName)) {
//                                        hideInShipcollst.add(displayname);
//                                    }
//                                    if (hideInShore.contains(columnName)) {
//                                        hideInShorecollst.add(displayname);
//                                    }
//
////                                    -------------for button----------------
//                                    if (columnPropHm.containsKey("action")) {
//                                        System.out.println("inisde columnPropHm if====>");
//                                        String buttonval = columnPropHm.get("action").toString();
////                                        System.out.println("inide button===>" + buttonval);
//                                        if (buttonval.equalsIgnoreCase("Y")) {
//                                            buttonMap.put(columnName, displayname);
//                                            Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
//                                            while (itrgrpbtn.hasNext()) {
//                                                String chkcolumn = itrgrpbtn.next().toString();
////                                                System.out.println("injk itrgrpbtn==****>" + columnName + "=itrgrpbtn.next().toString()==" + chkcolumn);
//
//                                                if (columnName.equalsIgnoreCase(chkcolumn)) {
//                                                    LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumn);
//
//                                                    if (columnPropHmgrpbtn.containsKey("view")) {
//                                                        indexmap.put(indexmapi, "true");
//                                                        LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
//                                                        if (columnPropHmview.containsKey("renderidentifier")) {
//                                                            viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
//                                                            viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
//                                                            viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
//                                                            viewrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                    } else {
//                                                        indexmap.put(indexmapi, "false");
//                                                    }
//                                                    if (columnPropHmgrpbtn.containsKey("edit")) {
//                                                        indexmapedit.put(indexmapi, true);
//                                                        LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
//                                                        if (columnPropHmedit.containsKey("renderidentifier")) {
//                                                            editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
//                                                            editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
//                                                            editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
//                                                            editrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                        if (columnPropHmedit.containsKey("applybpm")) {
//                                                            editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
//                                                        }
//                                                    } else {
//                                                        indexmapedit.put(indexmapi, false);
//                                                    }
//                                                    if (columnPropHmgrpbtn.containsKey("new")) {
//                                                        LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
//                                                        indexmapnew.put(indexmapi, true);
//                                                        newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
//                                                        newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
//                                                        if (columnPropHmnew.containsKey("renderidentifier")) {
//                                                            newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
//                                                            newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
//                                                            newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
//                                                            newrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                    } else {
//                                                        indexmapnew.put(indexmapi, false);
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    } else {
//                                        indexmap.put(indexmapi, "false");
//                                        indexmapedit.put(indexmapi, false);
//                                        indexmapnew.put(indexmapi, false);
//                                    }
//                                    indexmapi++;
////                                    -------------------------------------------
//                                }
//                            }
//                            if (spansubshipcolumnHeaders != null) {
//                                while (shipitr.hasNext()) {
//                                    String columnNameship = shipitr.next().toString();
//                                    if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnNameship)) {
//                                        LinkedTreeMap columnPropHm = (LinkedTreeMap) spansubshipcolumnHeaders.get(columnNameship);
//                                        displayname = (String) columnPropHm.get("displayname");
//                                        spansubcolumnHeaderLst.add(displayname);
//                                        spansubcolumnshipHeaderLst.add(displayname);
//                                        allcolumnHeaderLst.add(displayname);
//                                        columnTypeLst.add(columnPropHm.get("type"));
//                                        columnFormatLst.add(columnPropHm.get("format"));
//                                        tmpColHeaderNamesLst.add(columnNameship);
//                                        headerDisplayNameVarMap.put(displayname, columnNameship);
//                                        columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());
//
////                                    --------------------for button---------------
//                                        if (columnPropHm.containsKey("action")) {
//                                            System.out.println("inisde columnPropHm if====>");
//                                            String buttonval = columnPropHm.get("action").toString();
////                                        System.out.println("inide button===>" + buttonval);
//                                            if (buttonval.equalsIgnoreCase("Y")) {
//                                                buttonMap.put(columnNameship, displayname);
//                                                Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
//                                                while (itrgrpbtn.hasNext()) {
//                                                    String chkcolumnship = itrgrpbtn.next().toString();
////                                                System.out.println("injk itrgrpbtn==****>" + columnNameship + "=itrgrpbtn.next().toString()==" + chkcolumnship);
//                                                    if (columnNameship.equalsIgnoreCase(chkcolumnship)) {
//                                                        LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumnship);
//                                                        if (columnPropHmgrpbtn.containsKey("view")) {
//                                                            indexmap.put(indexmapi, "true");
//                                                            LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
//                                                            if (columnPropHmview.containsKey("renderidentifier")) {
//                                                                viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
//                                                                viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
//                                                                viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
//                                                                viewrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//
//                                                        } else {
//                                                            indexmap.put(indexmapi, "false");
//                                                        }
//                                                        if (columnPropHmgrpbtn.containsKey("edit")) {
//                                                            indexmapedit.put(indexmapi, true);
//                                                            LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
//                                                            if (columnPropHmedit.containsKey("renderidentifier")) {
//                                                                editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
//                                                                editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
//                                                                editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
//                                                                editrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//                                                            if (columnPropHmedit.containsKey("applybpm")) {
//                                                                editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
//                                                            }
//                                                        } else {
//                                                            indexmapedit.put(indexmapi, false);
//                                                        }
//                                                        if (columnPropHmgrpbtn.containsKey("new")) {
//                                                            indexmapnew.put(indexmapi, true);
//                                                            LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
//                                                            newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
//                                                            newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
//                                                            if (columnPropHmnew.containsKey("renderidentifier")) {
//                                                                newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
//                                                                newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
//                                                                newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
//                                                                newrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//                                                        } else {
//                                                            indexmapnew.put(indexmapi, false);
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        } else {
//                                            indexmap.put(indexmapi, "false");
//                                            indexmapedit.put(indexmapi, false);
//                                            indexmapnew.put(indexmapi, false);
//                                        }
//                                        indexmapi++;
////                                    System.out.println("insdie columnNameship indexmapi==>" + indexmapi);
////                                    ----------------------------------
//                                    }
//                                }
//                            }
//                            if (spansubshorecolumnHeaders != null) {
//                                while (shoreitr.hasNext()) {
//                                    String columnNameshore = shoreitr.next().toString();
//                                    if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnNameshore)) {
//                                        LinkedTreeMap columnPropHm = (LinkedTreeMap) spansubshorecolumnHeaders.get(columnNameshore);
//                                        displayname = (String) columnPropHm.get("displayname");
//                                        spansubcolumnHeaderLst.add(displayname);
//                                        spansubcolumnshoreHeaderLst.add(displayname);
//                                        allcolumnHeaderLst.add(displayname);
//                                        columnTypeLst.add(columnPropHm.get("type"));
//                                        columnFormatLst.add(columnPropHm.get("format"));
//                                        tmpColHeaderNamesLst.add(columnNameshore);
//                                        headerDisplayNameVarMap.put(displayname, columnNameshore);
//                                        columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());
//
////                                    -------------------for button----------------
//                                        if (columnPropHm.containsKey("action")) {
//                                            System.out.println("inisde columnPropHm if====>");
//                                            String buttonval = columnPropHm.get("action").toString();
////                                        System.out.println("inide button===>" + buttonval);
//                                            if (buttonval.equalsIgnoreCase("Y")) {
//                                                buttonMap.put(columnNameshore, displayname);
//                                                Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
//                                                while (itrgrpbtn.hasNext()) {
//                                                    String chkcolumnshore = itrgrpbtn.next().toString();
////                                                System.out.println("injk itrgrpbtn==****>" + columnNameshore + "=itrgrpbtn.next().toString()==" + chkcolumnshore);
//                                                    if (columnNameshore.equalsIgnoreCase(chkcolumnshore)) {
//                                                        LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumnshore);
//                                                        if (columnPropHmgrpbtn.containsKey("view")) {
//                                                            indexmap.put(indexmapi, "true");
//                                                            LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
//                                                            if (columnPropHmview.containsKey("renderidentifier")) {
//                                                                viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
//                                                                viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
//                                                                viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
//                                                                viewrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//                                                        } else {
//                                                            indexmap.put(indexmapi, "false");
//                                                        }
//                                                        if (columnPropHmgrpbtn.containsKey("edit")) {
//                                                            indexmapedit.put(indexmapi, true);
//                                                            LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
//                                                            if (columnPropHmedit.containsKey("renderidentifier")) {
//                                                                editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
//                                                                editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
//                                                                editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
//                                                                editrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//                                                            if (columnPropHmedit.containsKey("applybpm")) {
//                                                                editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
//                                                            }
//                                                        } else {
//                                                            indexmapedit.put(indexmapi, false);
//                                                        }
//                                                        if (columnPropHmgrpbtn.containsKey("new")) {
//                                                            indexmapnew.put(indexmapi, true);
//                                                            LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
//                                                            newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
//                                                            newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
//                                                            if (columnPropHmnew.containsKey("renderidentifier")) {
//                                                                newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
//                                                                newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
//                                                                newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
//                                                                newrenidentybool = true;
//                                                                commonidentybool = true;
//                                                            }
//                                                        } else {
//                                                            indexmapnew.put(indexmapi, false);
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        } else {
//                                            indexmap.put(indexmapi, "false");
//                                            indexmapedit.put(indexmapi, false);
//                                            indexmapnew.put(indexmapi, false);
//                                        }
//                                        indexmapi++;
////                                    System.out.println("insdie columnNameshore indexmapi==>" + indexmapi);
////                                    -------------------------
//                                    }
//                                }
//                            }
//                            if (columnOrderLst.get(m).equals(editidentifiercolumn)) {
//                                indexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(viewrenidentifiercolumn)) {
//                                viewrenindexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(editrenidentifiercolumn)) {
//                                editrenindexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(newrenidentifiercolumn)) {
//                                newrenindexcolumni = m;
//                            }
//                        }
//                    }
//
//                    System.out.println(
//                            "inside tmpColHeaderNamesLst===>" + tmpColHeaderNamesLst.size() + ">>>>>>>>>>>>>"
//                            + tmpColHeaderNamesLst);
//                    System.out.println(
//                            "injsd dataSet===>" + dataSet);
//                    int rstZise = 0;
//                    if (dataSet
//                            != null) {
//                        rstZise = dataSet.size();
//                        for (int i = 0; i < dataSet.size(); i++) {
//                            ArrayList lst = new ArrayList();
//                            for (int p = 0; p < tmpColHeaderNamesLst.size(); p++) {
//                                LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
//                                Boolean bColnMatched = false;
//                                Iterator it = tm.keySet().iterator();
//                                while (it.hasNext()) {
//                                    String key = it.next().toString();
//                                    if (key != null && key.equalsIgnoreCase((String) tmpColHeaderNamesLst.get(p))) {
//                                        lst.add(tm.get(key).toString());
//                                        bColnMatched = true;
//                                    }
//                                }
//                                if (!bColnMatched) {
//                                    lst.add("");
//                                }
//                            }
//                            rowHm.add(lst);
//                        }
//                    }
//                    if (commonidentybool) {
//                        List editlst = new ArrayList();
//                        for (int j = 0; j < rowHm.size(); j++) {
//                            editlst = (List) rowHm.get(j);
//                            for (int k = 0; k < editlst.size(); k++) {
////                                System.out.println("uhdfhjks inh if editlst====>" + editlst.get(k));
//                                if (editidentybool) {
//                                    if (k == indexcolumni) {
//                                        for (int b = 0; b < editidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh ifeditident====>" + editlst.get(k) + "====ifiervalues editlst====>" + editidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(editidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if editlst====>" + editlst.get(k));
//                                                editidentifierlistrows.add(editlst);
//                                                refnoreoderlist.add(editlst.get(refnofieldIndex));
//                                            }
//                                        }
//                                    }
//                                }
//                                if (viewrenidentybool) {
//                                    if (k == viewrenindexcolumni) {
//                                        for (int b = 0; b < viewrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh viewrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + viewrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(viewrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if viewrenidentifiervalues====>" + editlst.get(k));
//                                                viewrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                                if (editrenidentybool) {
//                                    if (k == editrenindexcolumni) {
//                                        for (int b = 0; b < editrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh editrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + editrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(editrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if editrenidentifiervalues====>" + editlst.get(k));
//                                                editrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                                if (newrenidentybool) {
//                                    if (k == newrenindexcolumni) {
//                                        for (int b = 0; b < newrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh newrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + newrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(newrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if newrenidentifiervalues====>" + editlst.get(k));
//                                                newrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
////                    System.out.println("===rowHm is=========>" + rowHm);
//                    resultHm.put("allheaderNames", allcolumnHeaderLst);
//                    resultHm.put(
//                            "headerNames", columnHeaderLst);
//                    resultHm.put(
//                            "spanheaderNames", spancolumnHeaderLst);
//                    resultHm.put(
//                            "spansubheaderNames", spansubcolumnHeaderLst);
//                    resultHm.put(
//                            "columnTypeLst", columnTypeLst);
//                    resultHm.put(
//                            "columnFormatLst", columnFormatLst);
//                    resultHm.put(
//                            "dataSets", dataLst);
//                    resultHm.put(
//                            "dataSetSize", rstZise);
//                    resultHm.put(
//                            "wrkFlowGrpCode", grpCode);
//                    resultHm.put(
//                            "landingPageTitleName", landingPageTitleName);
//                    resultHm.put(
//                            "rowValues", rowHm);
//                    resultHm.put(
//                            "tmpColHeaderNames", tmpColHeaderNamesLst);
//                    resultHm.put(
//                            "redirectMdlId", redirectMdlId);
//                    resultHm.put(
//                            "isAllowEdit", isAllowEdit);
//                    resultHm.put(
//                            "isAllowCreate", isAllowCreate);
//                    resultHm.put("hideInShore", hideInShore);
//                    resultHm.put(
//                            "hideInShip", hideInShip);
//                    resultHm.put(
//                            "refnofield", refnofield);
//                    resultHm.put(
//                            "statusdesc", statusdesc);
//                    resultHm.put(
//                            "bpmwrkflowidscript", bpmwrkflowidscript);
//                    resultHm.put(
//                            "headerDisplayNameVarMap", headerDisplayNameVarMap);
//                    resultHm.put(
//                            "thirdlevelServiceName", thirdlevelServiceName);
//                    resultHm.put(
//                            "thirdlevelvalidation", thirdlevelvalidation);
//                    resultHm.put(
//                            "applyhandlybyuserlogic", applyhandlybyuserlogic);
//                    resultHm.put(
//                            "statusntchkhl", statusntchkhllist);
//
//                }
//                RequestContext.getCurrentInstance().update("landingPageForm");
//            } else {
//                System.out.println("inside else==>");
//                model.getStateModel().setColumngrouprender(false);
//                model.getStateModel().setFacetrender(true);
//                if (columnDataHM != null) {
//                    columnHeaders = (LinkedTreeMap) columnDataHM.get("prop");
//                    if (columnDataHM.get("columnorder") == null) {
//                        columnOrderLst.add("");
//                    } else {
//                        columnOrderLst = (ArrayList) columnDataHM.get("columnorder");
//                    }
//                    if (columnDataHM.containsKey("editidentifier")) {
//                        editidentifierHeaders = (LinkedTreeMap) columnDataHM.get("editidentifier");
//                        editidentifiercolumn = (String) editidentifierHeaders.get("column");
//                        editidentifiervalues = (List) (editidentifierHeaders.get("values"));
//                        editidentybool = true;
//                        commonidentybool = true;
//                    }
//                    hideInShore = columnDataHM.containsKey("hideinshore") ? (List) columnDataHM.get("hideinshore") : new ArrayList();
//                    hideInShip = columnDataHM.containsKey("hideinship") ? (List) columnDataHM.get("hideinship") : new ArrayList();
//                    refnofield = columnDataHM.containsKey("refnofield") ? (String) columnDataHM.get("refnofield") : null;
//                    bpmwrkflowidscript = columnDataHM.containsKey("bpmwrkflowid") ? (String) columnDataHM.get("bpmwrkflowid") : null;
//                    statusdesc = columnDataHM.containsKey("statusdesc") ? (String) columnDataHM.get("statusdesc") : null;
//                    defaultaction = columnDataHM.containsKey("defaultaction") ? (String) columnDataHM.get("defaultaction") : "Y";
//                    doubleclickrender = columnDataHM.containsKey("doubleclickrender") ? (String) columnDataHM.get("doubleclickrender") : "Y";
//                }
//                System.out.println("ins columnDataHMaction==>" + columnDataHMaction);
//                if (columnDataHMaction != null && columnDataHMaction.containsKey("groupbutton")) {
////                        System.out.println("inisde groupbutton===>");
//                    groupbuttonHeaders = (LinkedTreeMap) columnDataHMaction.get("groupbutton");
//                }
//
//                if (doubleclickrender.equalsIgnoreCase("N")) {
//                    model.getStateModel().setDoubleclickdisbled(true);
//                } else {
//                    model.getStateModel().setDoubleclickdisbled(false);
//                }
//                if (columnHeaders != null) {
//                    dataSet = invokeGetterService(viewServiceName, viewIdentifier, viewInputHm, List.class, serviceType, mDataMap);
//                    List rowHm = new ArrayList();
//                    if (columnOrderLst
//                            != null) {
//                        for (int m = 0; m < columnOrderLst.size(); m++) {
//                            Iterator itr = columnHeaders.keySet().iterator();
//                            while (itr.hasNext()) {
//                                String columnName = itr.next().toString();
//                                if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnName)) {
//                                    LinkedTreeMap columnPropHm = (LinkedTreeMap) columnHeaders.get(columnName);
//                                    displayname = (String) columnPropHm.get("displayname");
//                                    columnHeaderLst.add(displayname);
//                                    columnTypeLst.add(columnPropHm.get("type"));
//                                    columnFormatLst.add(columnPropHm.get("format"));
//                                    tmpColHeaderNamesLst.add(columnName);
//                                    headerDisplayNameVarMap.put(displayname, columnName);
//                                    columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());
//
////                                    -----------------for button---------------
//                                    if (columnPropHm.containsKey("action")) {
////                                        System.out.println("inisde columnPropHm if====>");
//                                        String buttonval = columnPropHm.get("action").toString();
////                                        System.out.println("inide button===>" + buttonval);
//                                        buttonchk = buttonval.equalsIgnoreCase("Y");
//                                        if (buttonval.equalsIgnoreCase("Y")) {
//                                            buttonMap.put(columnName, displayname);
//                                            Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
//                                            while (itrgrpbtn.hasNext()) {
//                                                String chkcolumn = itrgrpbtn.next().toString();
////                                                System.out.println("injk itrgrpbtn==****>" + columnName + "=itrgrpbtn.next().toString()==" + chkcolumn);
//
//                                                if (columnName.equalsIgnoreCase(chkcolumn)) {
//                                                    LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumn);
//
//                                                    if (columnPropHmgrpbtn.containsKey("view")) {
//                                                        indexmap.put(indexmapi, "true");
//                                                        LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
//                                                        if (columnPropHmview.containsKey("renderidentifier")) {
//                                                            viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
//                                                            viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
//                                                            viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
//                                                            viewrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                    } else {
//                                                        indexmap.put(indexmapi, "false");
//                                                    }
//                                                    if (columnPropHmgrpbtn.containsKey("edit")) {
//                                                        indexmapedit.put(indexmapi, true);
//                                                        LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
//                                                        if (columnPropHmedit.containsKey("renderidentifier")) {
//                                                            editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
//                                                            editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
//                                                            editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
//                                                            editrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                        if (columnPropHmedit.containsKey("applybpm")) {
//                                                            editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
//                                                        }
//                                                    } else {
//                                                        indexmapedit.put(indexmapi, false);
//                                                    }
//                                                    if (columnPropHmgrpbtn.containsKey("new")) {
//                                                        indexmapnew.put(indexmapi, true);
//                                                        LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
//                                                        newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
//                                                        newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
//                                                        if (columnPropHmnew.containsKey("renderidentifier")) {
//                                                            newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
//                                                            newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
//                                                            newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
//                                                            newrenidentybool = true;
//                                                            commonidentybool = true;
//                                                        }
//                                                    } else {
//                                                        indexmapnew.put(indexmapi, false);
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        indexmapi++;
//                                    } else {
//                                        indexmap.put(indexmapi, "false");
//                                        indexmapedit.put(indexmapi, false);
//                                        indexmapnew.put(indexmapi, false);
//                                        indexmapi++;
//                                    }
////                                    System.out.println("insdie columnNameship indexmapi==>" + indexmapi);
////                                    ----------------------------------------------
//                                }
//                            }
//                            if (columnOrderLst.get(m).equals(editidentifiercolumn)) {
////                                System.out.println("idnksdj else editidentifiercolumn===>" + columnOrderLst.get(m) + "====indaj===>" + m);
//                                indexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(viewrenidentifiercolumn)) {
////                                System.out.println("idnksdj viewrenidentifiercolumn===>" + columnOrderLst.get(m) + "====indaj===>" + m);
//                                viewrenindexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(editrenidentifiercolumn)) {//                                
//                                editrenindexcolumni = m;
//                            }
//                            if (columnOrderLst.get(m).equals(newrenidentifiercolumn)) {
//                                newrenindexcolumni = m;
//                            }
//                        }
//                    }
//                    int rstZise = 0;
//
//                    System.out.println(
//                            "injsd nts dataSet===>" + dataSet);
//                    if (dataSet
//                            != null) {
//                        rstZise = dataSet.size();
//                        for (int i = 0; i < dataSet.size(); i++) {
//                            ArrayList lst = new ArrayList();
//                            for (int p = 0; p < tmpColHeaderNamesLst.size(); p++) {
//                                LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
//                                Boolean bColnMatched = false;
//                                Iterator it = tm.keySet().iterator();
//                                while (it.hasNext()) {
//                                    String key = it.next().toString();
//                                    if (key != null && key.equals((String) tmpColHeaderNamesLst.get(p))) {
//                                        lst.add(tm.get(key).toString());
//                                        bColnMatched = true;
//                                    }
//                                }
//                                if (!bColnMatched) {
//                                    lst.add("");
//                                }
//                            }
//                            rowHm.add(lst);
//                        }
//                    }
//
//                    if (commonidentybool) {
//                        List editlst = new ArrayList();
//                        for (int j = 0; j < rowHm.size(); j++) {
//                            editlst = (List) rowHm.get(j);
//                            for (int k = 0; k < editlst.size(); k++) {
////                                System.out.println("uhdfhjks inh if editlst====>" + editlst.get(k));
//                                if (editidentybool) {
//                                    if (k == indexcolumni) {
//                                        for (int b = 0; b < editidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh ifeditident====>" + editlst.get(k) + "====ifiervalues editlst====>" + editidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(editidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if editlst====>" + editlst.get(k));
//                                                editidentifierlistrows.add(editlst);
//                                                refnoreoderlist.add(editlst.get(refnofieldIndex));
//                                            }
//                                        }
//                                    }
//                                }
//                                if (viewrenidentybool) {
//                                    if (k == viewrenindexcolumni) {
//                                        for (int b = 0; b < viewrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh viewrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + viewrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(viewrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if viewrenidentifiervalues====>" + editlst.get(k));
//                                                viewrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                                if (editrenidentybool) {
//                                    if (k == editrenindexcolumni) {
//                                        for (int b = 0; b < editrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh editrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + editrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(editrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if editrenidentifiervalues====>" + editlst.get(k));
//                                                editrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                                if (newrenidentybool) {
//                                    if (k == newrenindexcolumni) {
//                                        for (int b = 0; b < newrenidentifiervalues.size(); b++) {
////                                            System.out.println("uhdfhjks inh newrenidentifiervalues====>" + editlst.get(k) + "====ifiervalues editlst====>" + newrenidentifiervalues.get(b));
//                                            if (editlst.get(k).toString().equalsIgnoreCase(newrenidentifiervalues.get(b).toString())) {
////                                                System.out.println("uhdfhjks inhinner  if newrenidentifiervalues====>" + editlst.get(k));
//                                                newrenidentifierlistrows.add(editlst);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
////                    System.out.println("===rowHm is=========>" + rowHm);
//
//                    resultHm.put("allheaderNames", allcolumnHeaderLst);
//                    resultHm.put("spanheaderNames", spancolumnHeaderLst);
//                    resultHm.put("spansubheaderNames", spansubcolumnHeaderLst);
//                    resultHm.put("headerNames", columnHeaderLst);
//                    resultHm.put("columnTypeLst", columnTypeLst);
//                    resultHm.put("columnFormatLst", columnFormatLst);
//                    resultHm.put("dataSets", dataLst);
//                    resultHm.put("dataSetSize", rstZise);
//                    resultHm.put("wrkFlowGrpCode", grpCode);
//                    resultHm.put("landingPageTitleName", landingPageTitleName);
//                    resultHm.put("rowValues", rowHm);
//                    resultHm.put("tmpColHeaderNames", tmpColHeaderNamesLst);
//                    resultHm.put("redirectMdlId", redirectMdlId);
//                    resultHm.put("isAllowEdit", isAllowEdit);
//                    resultHm.put("isAllowCreate", isAllowCreate);
//                    resultHm.put("hideInShore", hideInShore);
//                    resultHm.put("hideInShip", hideInShip);
//                    resultHm.put("refnofield", refnofield);
//                    resultHm.put("statusdesc", statusdesc);
//                    resultHm.put("bpmwrkflowidscript", bpmwrkflowidscript);
//                    resultHm.put("headerDisplayNameVarMap", headerDisplayNameVarMap);
//                    resultHm.put("thirdlevelServiceName", thirdlevelServiceName);
//                    resultHm.put("thirdlevelvalidation", thirdlevelvalidation);
//                    resultHm.put("applyhandlybyuserlogic", applyhandlybyuserlogic);
//                    resultHm.put("statusntchkhl", statusntchkhllist);
//                }
////                RequestContext.getCurrentInstance().update("landingPageForm");
//            }
////            -------------for button----------------------
////            System.out.println("inid fdefaultaction==>" + defaultaction);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultHm;
//    }
//
////    public void exportExcelAdded() {
////        ArrayList exportlst = new ArrayList();
////        exportlst.add("Export to Excel");
////        exportlst.add("Export to pdf");
////        exportlst.add("Export to csv");
////        exportlst.add("Export to excel all");
////        exportlst.add("Export to pdf all");
////        exportlst.add("Export to csv all");
////
////        model.getDataModel().setExportlist(exportlst);
////    }
//    public void reorderClicked() {
//        ArrayList alllist = new ArrayList();
//        for (int i = 0; i < model.getDataModel().getSm_allcolumnsLst().size(); i++) {
//            if (!spansubcolumnHeaderLst.contains(model.getDataModel().getSm_allcolumnsLst().get(i)) && !hideInShipcollst.contains(model.getDataModel().getSm_allcolumnsLst().get(i))) {
//                alllist.add(model.getDataModel().getSm_allcolumnsLst().get(i));
//            }
//
//            System.out.println("inisde inisetoggleList if===>" + toggleList);
//            System.out.println("iodjd submitClicked====>" + model.getDataModel().getSm_allcolumnsLst().get(i));
//        }
//        System.out.println("inside allcolumnHeaderLst>>>>>>" + allcolumnHeaderLst);
//        if (!allcolumnHeaderLst.isEmpty()) {
//            alllist.add("Ship");
//            alllist.add("Shore");
//        }
////        model.getDataModel().setReoder_columnsLst(model.getDataModel().getSm_allcolumnsLst());
//        model.getDataModel().setReoder_columnsLst(alllist);
////        model.getDataModel().getReoder_columnsLst().removeAll(spansubcolumnHeaderLst);
//
//        model.getStateModel().setReorderlistrender(true);
//        RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
//        RequestContext.getCurrentInstance().update("dlg1");
//        //   RequestContext.getCurrentInstance().update("landingPageForm");
//    }
//
//    public void getReoderdata(String reorderstr) {
//        System.out.println("insidnde getReoderdata>>>>>>>>>>>>");
//        reorederflag = true;
//        List reorderrowHm = new ArrayList();
//        List datareorderlist = new ArrayList();
//        int spansize = spansubcolumnshoreHeaderLst.size() + spansubcolumnshipHeaderLst.size();
//        int sizebfrspan = 0;
//
//        List newlst = new ArrayList();
//        ArrayList newheaderlst = new ArrayList();
//        String[] column = reorderstr.split(",");
//        columnTypeLst.clear();
//        System.out.println("inasj ?>>>>" + column.length + ">>>>>" + reorderstr);
//
//        for (int i = 0; i < column.length; i++) {
////            if (reodrtmpColHeaderNamesLst.contains(column[i])) {
//            newlst.add(column[i]);
////            } 
//        }
//        if (!allcolumnHeaderLst.isEmpty()) {
//            reorderallcolumnHeaderLst = (ArrayList) newlst;
//        } else {
//            reordercolumnHeaderLst = (ArrayList) newlst;
//        }
//
//        if (model.getDataModel().getSm_allcolumnsLst() != null) {
//            model.getDataModel().getSm_allcolumnsLst().clear();
//        }
//        if (model.getDataModel().getSm_columnsLst() != null) {
//            model.getDataModel().getSm_columnsLst().clear();
//        }
//
//        System.out.println("inddsdisn getReoderdata>>>>>" + newlst);
//        for (int i = 0; i < newlst.size(); i++) {
//            System.out.println("inside >>>>>>" + newlst.get(i));
//            newheaderlst.add(newlst.get(i));
//            datareorderlist.add(headerDisplayNameVarMap.get(newlst.get(i).toString()));
//            columnTypeLst.add(columnTypeLstreoderMap.get(newlst.get(i)).toString());
//            tmpColumnNames.add(headerDisplayNameVarMap.get(newlst.get(i).toString()));
//        }
//        System.out.println("inisde getReoderdata tmpColumnNames>>>>>" + tmpColumnNames);
//        model.getDataModel().setSm_allcolumnsLst(newheaderlst);
//        model.getDataModel().setSm_columnsLst(newheaderlst);
//        reoderbpmscriptnewlst = datareorderlist;
//        System.out.println("iddjdlkan sb>>>" + reoderbpmscriptnewlst);
//
//        if (dataSet != null) {
//            for (int i = 0; i < dataSet.size(); i++) {
//                ArrayList lst = new ArrayList();
//                for (int p = 0; p < datareorderlist.size(); p++) {
//                    LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
//                    Boolean bColnMatched = false;
//                    Iterator it = tm.keySet().iterator();
//                    while (it.hasNext()) {
//                        String key = it.next().toString();
//                        if (key != null && key.equalsIgnoreCase((String) datareorderlist.get(p))) {
//                            lst.add(tm.get(key).toString());
//                            bColnMatched = true;
//                        }
//                    }
//                    if (!bColnMatched) {
//                        lst.add("");
//                    }
//                }
//                reorderrowHm.add(lst);
//            }
//        }
//
//        rows = reorderrowHm;
//        if (model.getDataModel().getSm_rowsLst() != null) {
//            model.getDataModel().getSm_rowsLst().clear();
//        }
//        System.out.println("iijhsm >>>" + rows);
//        model.getDataModel().setSm_rowsLst(rows);
//        RequestContext.getCurrentInstance().update("datagrid");
////        RequestContext.getCurrentInstance().update("landingPageForm");
//    }
//
//    public void submitClicked() {
//        reoderbool = false;
//        reorderval = true;
////        sm_rowsLst
//        System.out.println("inside submitClicked>>>>>>>");
//        List reorderrowHm = new ArrayList();
//        List datareorderlist = new ArrayList();
//        UserTablePreferences userPre = new UserTablePreferences();
//        CompleteModel completeModel = new CompleteModel();
//        String str = "";
//        int size = model.getDataModel().getReoder_columnsLst().size() - 1;
//        List newlst = new ArrayList();
//        int sizebfrspan = 0;
////        if (landingPageDatasHm.get("refnofield") != null) {
////            applyBPM = true;
////        }
//        String refnofield = landingPageDatasHm.containsKey("refnofield") ? (String) landingPageDatasHm.get("refnofield") : null;
//        model.getDataModel().getSm_allcolumnsLst().clear();
//        columnTypeLst.clear();
////        model.getDataModel().getSm_columnsLst().clear();
//        System.out.println("indjsaj size>>>>>" + model.getDataModel().getReoder_columnsLst());
//        System.out.println("indjsaj size>>>>>" + model.getDataModel().getReoder_columnsLst().size());
//        System.out.println("indjsaj size sm>>>>>" + model.getDataModel().getSm_allcolumnsLst());
//        System.out.println("inisde ********>>>>" + model.getDataModel().getReoder_columnsLst().get(size).toString() + ">>>>"
//                + model.getDataModel().getReoder_columnsLst().get(size - 1).toString());
//        completeModel = service.getusertablepreferences(mData.getMetaData(USERINFO.USERCODE), model.getDataModel().getMdlId());
//
//        if (model.getDataModel().getReoder_columnsLst().get(size).toString().equalsIgnoreCase("Shore") && model.getDataModel().getReoder_columnsLst().get(size - 1).toString().equalsIgnoreCase("Ship")) {
//            for (int i = 0; i < model.getDataModel().getReoder_columnsLst().size(); i++) {
//                if (reodrtmpColHeaderNamesLst.contains(model.getDataModel().getReoder_columnsLst().get(i))) {
//                    newlst.add(model.getDataModel().getReoder_columnsLst().get(i));
//                }
//            }
//            System.out.println("sb nek>>>" + newlst + ">>sz>>" + newlst.size() + ">>" + model.getDataModel().getReoder_columnsLst().size());
//            sizebfrspan = newlst.size();
//            for (int i = sizebfrspan; i < model.getDataModel().getReoder_columnsLst().size(); i++) {
//                if (sizebfrspan == i) {
//                    System.out.println("ish sb>>>???" + hideInShorecollst + ">>???>>>" + hideInShipcollst);
//                    if (defal == true) {
//                        if (PROJECTTYPE.equalsIgnoreCase("CNT001") && hideInShore != null) {//shore
//                            for (int s = 0; s < hideInShorecollst.size(); s++) {
//                                newlst.add(hideInShorecollst.get(s));
//                            }
//                        } else if (PROJECTTYPE.equalsIgnoreCase("CNT002") && hideInShip != null) {//ship
//                            for (int s = 0; s < hideInShipcollst.size(); s++) {
//                                newlst.add(hideInShipcollst.get(s));
//                            }
//                        }
//                    }
//                    System.out.println("ia>>" + model.getDataModel().getReoder_columnsLst().get(i));
//                    newlst.add(model.getDataModel().getReoder_columnsLst().get(i));
//                    System.out.println("ia>>l;k>>" + newlst);
//                } else {
//                    System.out.println("ia else>>" + model.getDataModel().getReoder_columnsLst().get(i));
//                    newlst.add(model.getDataModel().getReoder_columnsLst().get(i));
//                    System.out.println("ia>>l;k>else>" + newlst);
//                }
//            }
//        } else {
//            System.out.println("ijk>>>>>else>>>>" + model.getDataModel().getReoder_columnsLst());
//            for (int i = 0; i < model.getDataModel().getReoder_columnsLst().size(); i++) {
//                newlst.add(model.getDataModel().getReoder_columnsLst().get(i));
//            }
//            if (PROJECTTYPE.equalsIgnoreCase("CNT001") && hideInShore != null) {//shore
//                for (int s = 0; s < hideInShorecollst.size(); s++) {
//                    newlst.add(hideInShorecollst.get(s));
//                }
//            } else if (PROJECTTYPE.equalsIgnoreCase("CNT002") && hideInShip != null) {//ship
//                for (int s = 0; s < hideInShipcollst.size(); s++) {
//                    newlst.add(hideInShipcollst.get(s));
//                }
//            }
//        }
//
//        System.out.println("sb after nek>>>" + newlst + ">>sz>>" + newlst.size());
//
//        if (newlst.get(size).toString().equalsIgnoreCase("Shore") && newlst.get(size - 1).toString().equalsIgnoreCase("Ship")) {
//            System.out.println("inisde reoder submit if>>>>>>>>>>>>>");
//            for (int i = 0; i < newlst.size(); i++) {
//                System.out.println("inside >>>>>>" + newlst.get(i));
//                if (newlst.get(i).toString().equalsIgnoreCase("Shore")) {
//                    System.out.println("insidd shore>>>>>" + spansubcolumnshoreHeaderLst.size());
//                    for (int c = 0; c < spansubcolumnshoreHeaderLst.size(); c++) {
//                        model.getDataModel().getSm_allcolumnsLst().add(spansubcolumnshoreHeaderLst.get(c).toString());
//                        datareorderlist.add(headerDisplayNameVarMap.get(spansubcolumnshoreHeaderLst.get(c).toString()));
//                        str += spansubcolumnshoreHeaderLst.get(c).toString() + ",";
//                        System.out.println("inisde str>>>" + str);
//                        userPre.setReodercolumns(str);
//                    }
////                    datareorderlist.addAll(spansubcolumnshoreHeaderLst);
//                } else if (newlst.get(i).toString().equalsIgnoreCase("Ship")) {
//                    System.out.println("insidd ship>>>>>");
//                    for (int c = 0; c < spansubcolumnshipHeaderLst.size(); c++) {
//                        System.out.println("insidd ship>>>>>" + spansubcolumnshoreHeaderLst.size());
//                        model.getDataModel().getSm_allcolumnsLst().add(spansubcolumnshipHeaderLst.get(c).toString());
//                        datareorderlist.add(headerDisplayNameVarMap.get(spansubcolumnshipHeaderLst.get(c).toString()));
//                        str += spansubcolumnshipHeaderLst.get(c).toString() + ",";
//                        System.out.println("inisde ship str>>>" + str);
//                        userPre.setReodercolumns(str);
//                    }
////                    datareorderlist.addAll(spansubcolumnshipHeaderLst);
//                } else {
//                    model.getDataModel().getSm_allcolumnsLst().add(newlst.get(i));
//                    datareorderlist.add(headerDisplayNameVarMap.get(newlst.get(i).toString()));
//                    str += newlst.get(i).toString() + ",";
//                    userPre.setReodercolumns(str);
//                    columnTypeLst.add(columnTypeLstreoderMap.get(newlst.get(i)).toString());
//                }
//
//            }
////            System.out.println("inised hideInShipcollst>>> if>>>>"+hideInShipcollst);
////            for (int j = 0; j < hideInShipcollst.size(); j++) {
////                if(j==0){
////                System.out.println("isnjdka,mn>>if>>>>"+headerDisplayNameVarMap.get(hideInShipcollst.get(j).toString()));
////                datareorderlist.add(headerDisplayNameVarMap.get(hideInShipcollst.get(j).toString()));
////                System.out.println("iasiuhasui>>>>>>>>>>if>>>"+datareorderlist);
////                }else{
////                    datareorderlist.add("tempfinalall.bpmwrkflowid");
////                }
////                str += headerDisplayNameVarMap.get(hideInShipcollst.get(j).toString()) + ",";
////                userPre.setReodercolumns(str);
////            }
//        } else {
//            System.out.println("inisde reoder submit else>>>>>>>>>>>>>");
//            System.out.println("inisde reoder ^^^>>>" + reorderval + ">>refnofield>>" + refnofield);
//            for (int i = 0; i < newlst.size(); i++) {
//                if (newlst.get(i).toString().equalsIgnoreCase("Shore")) {
//                    for (int c = 0; c < spansubcolumnshoreHeaderLst.size(); c++) {
//                        model.getDataModel().getSm_allcolumnsLst().add(spansubcolumnshoreHeaderLst.get(c));
//                        datareorderlist.add(headerDisplayNameVarMap.get(spansubcolumnshoreHeaderLst.get(c).toString()));
//                        str += spansubcolumnshoreHeaderLst.get(c).toString() + ",";
//                        userPre.setReodercolumns(str);
//                    }
////                    datareorderlist.addAll(spansubcolumnshoreHeaderLst);
//                } else if (newlst.get(i).toString().equalsIgnoreCase("Ship")) {
//                    for (int c = 0; c < spansubcolumnshipHeaderLst.size(); c++) {
//                        model.getDataModel().getSm_allcolumnsLst().add(spansubcolumnshipHeaderLst.get(c));
//                        datareorderlist.add(headerDisplayNameVarMap.get(spansubcolumnshipHeaderLst.get(c).toString()));
//                        str += spansubcolumnshipHeaderLst.get(c).toString() + ",";
//                        userPre.setReodercolumns(str);
//                    }
////                    datareorderlist.addAll(spansubcolumnshipHeaderLst);
//                } else {
//                    if (!datareorderlist.contains(newlst.get(i).toString())) {
//                        model.getDataModel().getSm_allcolumnsLst().add(newlst.get(i).toString());
//                        datareorderlist.add(headerDisplayNameVarMap.get(newlst.get(i).toString()));
//                        str += newlst.get(i).toString() + ",";
//                        userPre.setReodercolumns(str);
//                    }
//                    columnTypeLst.add(columnTypeLstreoderMap.get(newlst.get(i)).toString());
//                }
//            }
//
//            refnoindx = datareorderlist.indexOf(refnofield);
//            System.out.println("idh refin>>>" + refnoindx);
//
////            System.out.println("inised hideInShipcollst>>> else>>>>"+hideInShipcollst);
////            for (int j = 0; j < hideInShipcollst.size(); j++) {
////                System.out.println("isnjdka,mn>>>>>>"+headerDisplayNameVarMap.get(spansubcolumnshipHeaderLst.get(j).toString()));
////                datareorderlist.add(headerDisplayNameVarMap.get(hideInShipcollst.get(j).toString()));
////                System.out.println("iasiuhasui>>>>>>>>>>>>>"+datareorderlist);
////                str += headerDisplayNameVarMap.get(hideInShipcollst.get(j).toString()) + ",";
////                userPre.setReodercolumns(str);
////            }
//        }
//
////        }
//        System.out.println(
//                "inisde setReodercolumns>>>>>>" + userPre.getReodercolumns());
//        System.out.println(
//                "insdide submitclk datareorderlist>>>>>" + datareorderlist);
//
////        for (int i = 0; i < model.getDataModel().getReoder_columnsLst().size(); i++) {
////            System.out.println("inside >>>>>>" + model.getDataModel().getReoder_columnsLst().get(i));
////            model.getDataModel().getSm_allcolumnsLst().add(model.getDataModel().getReoder_columnsLst().get(i));           
////            datareorderlist.add(headerDisplayNameVarMap.get(model.getDataModel().getReoder_columnsLst().get(i).toString()));
////            str += model.getDataModel().getReoder_columnsLst().get(i).toString() + ",";
////            userPre.setReodercolumns(str);
////        }
//        if (dataSet
//                != null) {
//            for (int i = 0; i < dataSet.size(); i++) {
//                ArrayList lst = new ArrayList();
//                for (int p = 0; p < datareorderlist.size(); p++) {
//                    LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
//                    Boolean bColnMatched = false;
//                    Iterator it = tm.keySet().iterator();
//                    while (it.hasNext()) {
//                        String key = it.next().toString();
//                        if (key != null && key.equalsIgnoreCase((String) datareorderlist.get(p))) {
//                            lst.add(tm.get(key).toString());
//                            bColnMatched = true;
//                        }
//                    }
//                    if (!bColnMatched) {
//                        lst.add("");
//                    }
//                }
//                reorderrowHm.add(lst);
//            }
//        }
//
//        System.out.println(
//                "insdide submitclk>>>>>" + reorderrowHm);
//        System.out.println(
//                "indjsaj siz outere>>>>>" + model.getDataModel().getReoder_columnsLst().size());
//        rows = reorderrowHm;
//
//        model.getDataModel().getSm_rowsLst().clear();
//        model.getDataModel().setSm_rowsLst(rows);
//
//        if (!allcolumnHeaderLst.isEmpty()) {
//            reorderallcolumnHeaderLst = (ArrayList) newlst;
//        } else {
//            reordercolumnHeaderLst = (ArrayList) newlst;
//        }
//
//        setDateFormatForList(model.getDataModel().getSm_rowsLst());
//
//        if (!completeModel.getUserTablePreferences()
//                .isEmpty()) {
//            if (completeModel.getUserTablePreferences().get(0).getPreferredcolumn() != null) {
//                userPre.setPreferredcolumn(completeModel.getUserTablePreferences().get(0).getPreferredcolumn());
//            } else {
//                userPre.setPreferredcolumn("");
//            }
//        } else {
//            userPre.setPreferredcolumn("");
//        }
//
//        if (!completeModel.getUserTablePreferences()
//                .isEmpty()) {
//            completeModel.getUserTablePreferences().add(userPre);
//            userPre.setId(completeModel.getUserTablePreferences().get(0).getId());
//            service.putreoderusertblprefer(completeModel);
//
//        } else {
//            userPre.setUsercode(mData.getMetaData(USERINFO.USERCODE));
//            userPre.setModuleid(model.getDataModel().getMdlId());
//            completeModel.getUserTablePreferences().add(userPre);
//            service.setreoderusertblprefer(completeModel);
//        }
//
//        System.out.println(
//                "indas >>>>>" + model.getDataModel().getReoder_columnsLst());
////        RequestContext.getCurrentInstance()
////                .execute("PF('dlg1').hide();");
////        RequestContext.getCurrentInstance().update("datagrid");
//        RequestContext.getCurrentInstance().execute("lnd_columntoggle_rc()");
//    }
//
//    public void cancelClicked() {
//        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
////        RequestContext.getCurrentInstance().update("landingPageForm");
//    }
//
//    public void defaultorderClicked() {
//        System.out.println("inside defaultorderClicked>>>>>>>>>>>>>");
//        Map landingPageDatasreoderHm;
//        List tmpColHeaderNamesLst = new ArrayList();
//        List reorderrowHm = new ArrayList();
//        UserTablePreferences userPre = new UserTablePreferences();
//        CompleteModel completeModel = new CompleteModel();
//        reorderval = false;
//        defal = false;
//        loaddefal = false;
//        try {
//            spansubcolumnshoreHeaderLst.clear();
//            spansubcolumnshipHeaderLst.clear();
//            completeModel = service.getusertablepreferences(mData.getMetaData(USERINFO.USERCODE), model.getDataModel().getMdlId());
//            completeModel.getUserTablePreferences().add(userPre);
//            userPre.setId(completeModel.getUserTablePreferences().get(0).getId());
//            userPre.setReodercolumns("");
//            service.putreoderusertblprefer(completeModel);
//            initializeLandingPage();
////            RequestContext.getCurrentInstance().update("landingPageForm");
////            landingPageDatasreoderHm = getLandingPageDatas(model.getDataModel().getMdlId(), loginName, mDataMap, mData.getMetaData(APPINFO.RANK_CODE));
//
////            ArrayList columnHeader = (ArrayList) landingPageDatasreoderHm.get("allheaderNames");
////            columnTypeLst = (ArrayList) landingPageDatasHm.get("columnTypeLst");
////            System.out.println("insd defaultorderClicked columnHeader>>>>" + columnHeader);
////            for (int c = 0; c < columnHeader.size(); c++) {
////                tmpColHeaderNamesLst.add(headerDisplayNameVarMap.get(columnHeader.get(c).toString()));
////                System.out.println("insdied >>>>>>>defaultrows>>>>" + columnHeader.get(c).toString());
////            }
////            System.out.println("inisde sbclk dataSet>>>>>" + dataSet + ">>>>>>" + tmpColHeaderNamesLst);
////            if (dataSet != null) {
////                for (int i = 0; i < dataSet.size(); i++) {
////                    ArrayList lst = new ArrayList();
////                    for (int p = 0; p < tmpColHeaderNamesLst.size(); p++) {
////                        LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
////                        Boolean bColnMatched = false;
////                        Iterator it = tm.keySet().iterator();
////                        while (it.hasNext()) {
////                            String key = it.next().toString();
////                            System.out.println("inside sbcl defaultorderClicked>>>" + key + ">>>>datareorderlist>>>>" + tmpColHeaderNamesLst.get(p));
////                            if (key != null && key.equalsIgnoreCase((String) tmpColHeaderNamesLst.get(p))) {
////                                lst.add(tm.get(key).toString());
////                                System.out.println("inisde lst sbl defaultorderClicked>>>>>" + lst);
////                                bColnMatched = true;
////                            }
////                        }
////                        if (!bColnMatched) {
////                            lst.add("");
////                        }
////                    }
////                    reorderrowHm.add(lst);
////                }
////            }
////            rows = reorderrowHm;
////            model.getDataModel().getSm_rowsLst().clear();
////            model.getDataModel().getSm_allcolumnsLst().clear();
////            model.getDataModel().getSm_allcolumnsLst().addAll(columnHeader);
////            model.getDataModel().setSm_rowsLst(rows);
////            setDateFormatForList(model.getDataModel().getSm_rowsLst());
////            model.getDataModel().setReoder_columnsLst(columnHeader);
////            RequestContext.getCurrentInstance().update("order");
////            RequestContext.getCurrentInstance().update("datagrid");
////            RequestContext.getCurrentInstance().update("landingPageForm");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void clearFilter() {
//        RequestContext.getCurrentInstance().execute("PF('datagrid').clearFilters()");
//    }
}
