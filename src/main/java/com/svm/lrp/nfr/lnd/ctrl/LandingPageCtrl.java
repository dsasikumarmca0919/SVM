package com.svm.lrp.nfr.lnd.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.svm.json.SvmJsonList;
import com.svm.json.SvmJsonObject;
import com.svm.json.SvmJsonUtil;
import com.svm.lrp.bpm.nfr.bpm.vo.TaskSummaryVo;
import com.svm.lrp.bpm.util.vo.ClaimRights;
import com.svm.lrp.bpm.util.vo.StatusVo;
import com.svm.lrp.nfr.jsf.exp.IFileExport;
import com.svm.lrp.nfr.jsf.utils.APPINFO;
import com.svm.lrp.nfr.jsf.utils.ILogger;
import com.svm.lrp.nfr.jsf.utils.IMetaData;
import com.svm.lrp.nfr.jsf.utils.NFRUtils;
import com.svm.lrp.nfr.jsf.utils.SMDialogUtil;
import com.svm.lrp.nfr.jsf.utils.USERINFO;
import com.svm.lrp.nfr.lnd.model.LandingDataVo;
import com.svm.lrp.nfr.lnd.model.LandingPageModel;
import com.svm.lrp.nfr.lnd.model.LandingPageUIDataModel;
import com.svm.lrp.nfr.lnd.vds.LandingPageVds;
import com.svm.lrp.nfr.lnd.vo.Bpmgroupmaster;
import com.svm.lrp.nfr.lnd.vo.ButtonActionColumn;
import com.svm.lrp.nfr.lnd.vo.CompleteModel;
import com.svm.lrp.nfr.lnd.vo.Deleterequest;
import com.svm.mac.atc.model.entity.Dynamiclandingpage;
import com.svm.mac.nfr.util.cacheinformation.IMDMCacheUtil;
import com.svm.mac.nfr.util.powerEdit.vds.IPowerEditChecker;
import com.svm.lrp.nfr.lnd.vo.LNDPageThirdLevelValidation;
import com.svm.lrp.nfr.lnd.vo.Mdl_super_user;
import com.svm.lrp.nfr.lnd.vo.Modulestructure;
import com.svm.lrp.nfr.lnd.vo.Pictask;
import com.svm.lrp.nfr.lnd.vo.Processinstancemaster;
import com.svm.lrp.nfr.lnd.vo.Rs0;
import com.svm.lrp.nfr.lnd.vo.Rs1;
import com.svm.lrp.nfr.lnd.vo.Rs2;
import com.svm.lrp.nfr.lnd.vo.Rs3;
import com.svm.lrp.nfr.lnd.vo.Rs4;
import com.svm.lrp.nfr.lnd.vo.SingleChoiceRadioVo;
import com.svm.lrp.nfr.lnd.vo.Uvs_userdetail;
import com.svm.lrp.nfr.lnd.vo.Vesselmapping;
import com.svm.lrp.nfr.lnd.vo.Vesselmaster;
import com.svm.lrp.nfr.lnd.vo.WidgetVo;
import com.svm.lrp.nfr.lnd.vo.Workflowmapping;
import com.svm.lrp.nfr.mack.QuickModuleRights;
import com.svm.lrp.nfr.main.bean.ToolbarCBean;
import com.svm.lrp.nfr.main.vo.MenuVo;
import com.svm.lrp.nfr.query.cbean.VDSInvoker;
import com.svm.lrp.nfr.search.utils.SearchUtils;
import com.svm.mac.entity.Bpmgroupcodelevel;
import com.svm.mac.entity.Bpmusergroupmapping_vessel;
import com.svm.mac.entity.Usergroupvo;
import com.svm.mac.macs.multitenanacy.INFRMultiTenanacyUtil;
import com.svm.mac.mas.syc.model.entity.Systemconfig;
import com.svm.mac.nfr.usd.importexcel.Shoremaster;
import com.svm.mac.util.MackUtil_IF;
import com.svm.mac.util.MackUtility;
import com.svm.mac.wfa.bean.WFHistoryUtil;
import com.svm.mac.atc.model.entity.Ex_vesselname;
import com.svm.mac.atc.model.entity.Vesselmastercache;
import com.svm.mack.model.vds.VDSMackBpmUtil;
import com.svm.mack.util.MBmainComparator;
import com.svm.mack.util.MackBpmUtil;
import com.svm.mack.util.constants.Keyconstants;
import com.svm.mack.vds.cntr.ImackBpmUtil;
import com.svm.nfr.component.datatable.ContextMenuModel;
import com.svm.nfr.component.datatable.DataTableEvent;
import com.svm.nfr.component.datatable.DefaultColumnModel;
//import com.svm.mack.util.MackBpmUtil;
//import com.svm.mack.util.constants.Keyconstants;
import com.svm.nfr.notify.smbpmutil.ISMBPMUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.faces.application.FacesMessage;
//import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.script.ScriptException;
import javax.sql.DataSource;

import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

public class LandingPageCtrl {

    // public Cache<String, List<Ex_vesselname>> Ex_VesselLogCache;
    // public Cache<String, List<Vesselmastercache>> VesselmasterCache;
    
    static String PROJECTTYPE;
    HashMap dateConverterHm = new HashMap();
    MackUtility mackUtility;
    ILogger logger;
    VDSInvoker serviceInvoker;
    SMDialogUtil dUtil;
    Gson jsonUtil;
    SvmJsonUtil svmJsonUtil = new SvmJsonUtil();
    LandingPageModel model;
    LandingPageUIDataModel dataModel = new LandingPageUIDataModel();
    String redirectMdlId = "";
    String loginName = "";
    QuickModuleRights quickModuleRights;
    IMetaData mData;
    LandingPageVds service;
    ISMBPMUtil smbpmUtil;
    IFileExport fileexp;
    List toggleList = new ArrayList();
    boolean applyBPM = false;
    String formCreationWFID = "";
    String WFType = "";
    String vslcompcode = "";
    boolean isDynamicMdl = false;
    Map<String, String> mDataMap = new HashMap<>();
    Map landingPageDatasHm;
    Map reorderlandingPageDatasHm;
    List<List> rows = new ArrayList();
    String viewIdentifier = "";
    List hideInShore = null;
    List hideInShip = null;
    String defaultaction;
    String doubleclickrender;
    LinkedTreeMap groupbuttonHeaders = null;
    LinkedTreeMap widgetToolTipConfig = null;
    LinkedTreeMap groupbuttonHeadersdotreplaced = null;
    String showmoduleid; // Filter started
    HashMap selectedfieldname = new HashMap();
    HashMap filterValuehm = new HashMap();
    HashMap filterOptchkhm = new HashMap();
    HashMap filterviewInputHm = new HashMap();
    String hasfilter;
    HashMap defaultselradio = new HashMap();
    HashMap defaultselchk = new HashMap();
    HashMap selradiohshmap = new HashMap();
    HashMap datehashmap = new HashMap();
    HashMap filtergetfieldname = new HashMap();
    HashMap dspflddate = new HashMap();
    boolean refresh = false; // Filter End
    private boolean buttonchk = false;
    HashMap buttonMap = new HashMap();
    HashMap indexmap = new HashMap();
    HashMap indexmapedit = new HashMap();
    HashMap indexmapnew = new HashMap();
    List<List> statustoshowallusersrows = new ArrayList();
    boolean statustoshowallusersbool = false;
    boolean controltypebasedstatusbool = false;
    // -------------editidentifier----------
    boolean commonidentybool = false;
    List<List> editidentifierlistrows = new ArrayList();
    boolean editidentybool = false;
    List<List> viewrenidentifierlistrows = new ArrayList();
    boolean viewrenidentybool = false;
    List<List> editrenidentifierlistrows = new ArrayList();
    boolean editrenidentybool = false;
    List<List> newrenidentifierlistrows = new ArrayList();
    boolean newrenidentybool = false;
    HashMap dateColumHashMap = new HashMap();
    HashMap datetimeColumHashMap = new HashMap();
    List<String> datecolumninfo;
    // ---------------------------
    private boolean editactionapplybpm = false;
    HashMap newtargetmdl = new HashMap();
    HashMap newnavigateflag = new HashMap();
    Map<String, String> headerDisplayNameVarMap = new HashMap();
    Map<String, String> ColumnDisplayNameVarMap = new HashMap();
    ArrayList columnHeaderLstHide = new ArrayList();
    ArrayList columnHeaderLst = new ArrayList();
    ArrayList tmpColumnHeaderLst = new ArrayList();
    HashMap sortByHm = new HashMap();
    ArrayList columnTypeLst = new ArrayList();
    ArrayList columnTypeHmLst = new ArrayList();
    ArrayList isTimeZoneHmLst = new ArrayList();
    ArrayList columnFormatLst = new ArrayList();
    ArrayList tmpColumnNames = new ArrayList();
    String statusdescdpname = "";
    String backuptypecolname = "";
    String statusdescdpname_ship = "";
    String statusdescdpname_shore = "";
    int statusdescindex = 0;
    HashMap indexcolumnmap = new HashMap();
    int refnofieldIndex = 0;
    int backuptypeIndex = 0;
    int bpmwrkflowidscriptindex = 0;
    List bpmwrkflowlist = new ArrayList();
    HashMap hm = new HashMap();
    String formCreationbpmWFID = "";
    String WFID = "";
    String bpmWFID = "";
    List<String> bpmReflist = new ArrayList();
    List<String> revokableReflist = new ArrayList();
    Map<String, TaskSummaryVo> revokableRefMap = new HashMap();
    Map<String, TaskSummaryVo> refnoTaskSummaryMap = new HashMap();
    List<List> tmprevokeApplicableRows;
    List<List> notapplicablebpmrows;
    List revokeRenderRows = new ArrayList();
    List<List> bpmAppicableRows = new ArrayList();
    List<List> thirdlevelbpmapplicablerows = new ArrayList<List>();
    List<List> thirdlevelbpmnonapplicablerows = new ArrayList<List>();
    boolean toggle = false;
    boolean editable = false;
    private boolean doubleboolean = false;
    // SelectEvent chkevent;
    //
    DataTableEvent chkevent;
    //

    HashMap headerstlehm = new HashMap();
    List spansubcolumnshoreHeaderLst = new ArrayList();
    List spansubcolumnshipHeaderLst = new ArrayList();
    Map<String, String> columnTypeLstreoderMap = new HashMap();
    List backgroundtobeaddedList1 = new ArrayList();
    List customFieldBackGroundColourList = new ArrayList();
    ArrayList spansubcolumnHeaderLst = new ArrayList();
    List hideInShipcollst = new ArrayList();
    List hideList = new ArrayList();
    List hideInShorecollst = new ArrayList();
    List dataSet = new ArrayList();
    HashMap togglehm = new HashMap();
    boolean reodersubmit = false;
    boolean loadingreorderbool = false;
    String syncstatuscn = "";
    int syncstatuscnindex = 0;
    ArrayList newbtnlist = new ArrayList();
    ArrayList viewbtnlist = new ArrayList();
    ArrayList editbtnlist = new ArrayList();
    public List<Bpmgroupcodelevel> Bpmgroupcodelevellist = new ArrayList<>();
    Map BPMcodelevelmap = new HashMap();
    // VesselMstrUtil vesselMstrUtil;

    // int backUpTypeIndex = -1;
    String sortByColumn = "";
    String sControlTypeCode = "";
    String wfCode;
    String choosevessel = "";
    String selectedvesselcode = "";
    List<Vesselmaster> vesselList = new ArrayList();
    MackBpmUtil mbutil;
    String dateformat;
    String datetimeformat;
    String referenceNumber;
    // FOR PRAVEEN.S
    List<DefaultColumnModel> columnModelList;
    List<DefaultColumnModel> columnModelListunhandled;
    List<ContextMenuModel> contextMenuModelList;
    String strViewType = "";
    private String claimedusername;
    private String claimeduserdepname;
    private String claimedusergroupname;
    private String claimeduserrankname;
    private Date todate;
    private Date fromdate;
    boolean isCompleteThirdLevel = false;
    int btnEditRenderInHmcount = 0;
    HashMap groupMap = new HashMap();
    String refnofield = "";
    String statusdesc = "", statusdescwithoutdot = "", refnofieldwithoutdot = "", backuptypewithoutdot = "";
    ArrayList TimeZoneColList = new ArrayList();
    HashMap colNameMap = new HashMap();
    List<String> tmpColHeaderNamesLst = null;
    List tmpColHeaderNamesLstwithoutdot = null;
    List controltypebasedstatus = new ArrayList();
    String viewrenidentifiercolumn = "";
    List viewrenidentifiervalues = new ArrayList();
    LinkedTreeMap editrenidentifierHeaders = null;
    String editrenidentifiercolumn = "";
    List editrenidentifiervalues = new ArrayList();
    List editidentifiervalues = new ArrayList();
    List statustoshowallusersvalues = new ArrayList();
    String newrenidentifiercolumn = "";
    String editidentifiercolumn = "";
    List newrenidentifiervalues = new ArrayList();
    String viewServiceName = "";
    String serviceType = "";
    HashMap viewInputHm = null;
    List statusntchkhllist = new ArrayList();
    String applyhandlybyuserlogic = "";
    String thirdlevelvalidation = "";
    String additionalreviewervalidation = "";
    String thirdlevelServiceName = "";
    Boolean isAllowCreate = false;
    Boolean isAllowEdit = false;
    List HmapList = new ArrayList();
    String landingPageTitleName = "";
    HashMap statusntchkhl = null;
    LinkedTreeMap columnHeaders = null;
    String backuptype = "";
    String enabledatewisesearch = "N";
    String includeOpenItems = "N";
    String includeopenitemsonload = "N";
    String defaultsearchid = "";
    int defaultrange = 60;
    String widgetcolumn = "";
    List<String> widgetListconfigured = new ArrayList();
    List<String> widgetList = new ArrayList();
    HashMap<String, Integer> widgetMap = new HashMap();
    Modulestructure mdlvo = new Modulestructure();
    boolean isNewTabEnable = false;
    List<String> wrkflowIdList = new ArrayList<>();
    boolean rendergrid = false;
    HashMap refnotaskMap = new HashMap();
    HashMap refnoBPMMap = new HashMap();
    List<TaskSummaryVo> refnoList = new ArrayList();
    int widgetvolistSize = 0;
    String myactiontooltip = "";
    boolean disMyactions = false;
    List<String> backgroundtobeaddedList = new ArrayList();
    List<Pictask> adrList = new ArrayList();
    WFHistoryUtil wFHistoryUtil;
    ArrayList<String> companynamelist = new ArrayList();
    List<String> delreqlist = new ArrayList();
    List<String> recallList = new ArrayList();
    List<String> AdditionalrevAddedList = new ArrayList();
    Map<String, Object> recallMap = new HashMap();
    String dynamicstyle = "singlegrid";
    String name = "parent";
    String checkInprogress = "Yes";
    INFRMultiTenanacyUtil multitenency;
    String tenantIdentifier = "";
    ToolbarCBean toolbar;
    public List<DefaultColumnModel> nonbpmcolumnlistCtrl;
    List<Mdl_super_user> superEditorList = new ArrayList<>();
    int onDemandRowIndex;
    String dynamicLandingVesselnamePropertyCode;
    String dynamicLandingCompanynamePropertyCode;
    String dynamicLandingCreatedDatePropertyCode;
    String dynamicLandingVesselcodePropertyCode;
    String dynamicLandingReferenceCode;
    String previousHistoryCompanyName;
    String previousHistoryVesselName;
    List<Ex_vesselname> Ex_vesselnameHistoryList = new ArrayList<Ex_vesselname>();
    List<Vesselmastercache> vesselMasterDetailList = new ArrayList();
    boolean isSuperEditorRowIndex = false;
    List<String> powerEditorWorkflowGroup = new ArrayList<>();
    List<String> powerEditorUsercode = new ArrayList<>();
    List<MenuVo> viewlist = new ArrayList<>();
    List <Bpmusergroupmapping_vessel> userWiseGroupsMapResultList = new ArrayList();
    List <Bpmusergroupmapping_vessel> Bpmusergroupmapping_vesselR3 = new ArrayList();
    List<String> Refidhdata = new ArrayList<>();
    IMDMCacheUtil Cacheintr;
    public List<Dynamiclandingpage> dynamiclandingpageCacheList = new ArrayList<>();
    public List<com.svm.mac.atc.model.entity.Modulestructure> ModuleStructureList = new ArrayList<>();
    public List<com.svm.mac.atc.model.entity.Shoremaster> ShoremasterList = new ArrayList<>();
    public List<com.svm.mac.atc.model.entity.Bpmgroupcodelevel> BPMcodelevellist = new ArrayList<>();
    private CacheContainer BpmgroupcodelevelContainer;
  
    public Cache<String, List<Bpmgroupcodelevel>> Bpmgroupcodelevelcache;
    List<String> handlelist = new ArrayList<>();
    IPowerEditChecker iPowerEditChecker;


    

    public LandingPageCtrl(ILogger logger, VDSInvoker serviceInvoker, LandingPageModel model,
            QuickModuleRights quickModuleRights,
            ISMBPMUtil smbpmUtil, SMDialogUtil dUtil, IFileExport fileexp, MackUtility mackUtility,
            MackBpmUtil mbutil, WFHistoryUtil wFHistoryUtil, INFRMultiTenanacyUtil multitenency,IMDMCacheUtil Cacheintr, IPowerEditChecker IPowerEditChecker) {
        try {
            // this.vesselMstrUtil = vesselMstrUtil;
            //ln("LND PROJECTTYPE==" + PROJECTTYPE);
            long startTime = System.currentTimeMillis();
            mData = NFRUtils.getMetaData();
            PROJECTTYPE = NFRUtils.getProjectType(mData);
            //System.out.println("LND PROJECTTYPE==" + PROJECTTYPE);
            if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
                wfCode = mData.getMetaData(APPINFO.COMPANY_CODE);
            } else {
                wfCode = mData.getMetaData(APPINFO.VESSEL_CODE);
            }
            this.Cacheintr = Cacheintr;
            // ex_VesselnameCacheLoader();
            this.multitenency = multitenency;
            this.tenantIdentifier = multitenency.getApplicationContextProperty();
            this.mackUtility = mackUtility;
            this.mbutil = mbutil;
            this.logger = logger;
            this.serviceInvoker = serviceInvoker;
            jsonUtil = new Gson();
            this.fileexp = fileexp;
            this.model = model;
            this.wFHistoryUtil = wFHistoryUtil;
            this.smbpmUtil = smbpmUtil;
            this.dUtil = dUtil;
            dateformat = mData.getMetaData(USERINFO.DATEFORMAT).trim();
            datetimeformat = mData.getMetaData(USERINFO.DATETIMEFORMAT).trim();
            sControlTypeCode = mData.getMetaData(APPINFO.CONTROL_TYPE_CODE);
            this.quickModuleRights = quickModuleRights;
            this.service = serviceInvoker.create(LandingPageVds.class);
            iPowerEditChecker = IPowerEditChecker;
            toggleList.add(true);
            getSuperEditor();
            importExcelButton();
            checkFormsOrOthers();
            getDelReqRefnos();
            Systemconfig syscconvo = this.mackUtility.getSystemconfig("LND_CheckInprogress");
            if (syscconvo.getSysvalue() != null && syscconvo.getSysvalue().length() > 0) {
                checkInprogress = syscconvo.getSysvalue();
            }
            logger.info("lndcbean","//==//==|company code in landing page======before==================>"
                    + mData.getMetaData(APPINFO.COMPANY_CODE));
            landingpageCache();
            initializeLandingPage();
            // addQuestionClicked();
            myactiontooltip = getDefaultWidgetTitle("MyActions");
            if (WFType != null && WFType.equalsIgnoreCase("V")) {
                vslcompcode = mData.getMetaData(APPINFO.VESSEL_CODE);
            } else {
                vslcompcode = mData.getMetaData(APPINFO.COMPANY_CODE);
            }

            createDataTableColumnModel();
            // RequestContext.getCurrentInstance().execute("Widgetfilter('myactionfilterSymbl',
            // 'btnEditRenderInHm', 'Yes','" + this.model.getDataModel().getMdlId() +
            // "_LND_datagrid');");
            logger.info("lndcbean","Grid ID======" + model.getDataModel().getGridid());

            // RequestContext.getCurrentInstance().update("LND_dataTableNewPanel");
            RequestContext.getCurrentInstance().execute("openfilter('" + this.model.getDataModel().getGridid() + "');");

            RequestContext.getCurrentInstance().update("landingPageForm");
            RequestContext.getCurrentInstance().execute("windowOpenedName()");
            if (model.getDataModel().getnBPMconfig() != null && !model.getDataModel().getnBPMconfig().isEmpty()) {
                userlistGetterDefaultColumnModel();
            }
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            if(model.getDataModel().getMdlId()!=null && !model.getDataModel().getMdlId().isEmpty()){
                logger.info("lndcbean", model.getDataModel().getMdlId() + " >>> Landing page Execution time: " + executionTime + " ms"); 
            }else{
                logger.info("lndcbean", " >>> Landing page Execution time: " + executionTime + " ms");
            }
            
        } catch (Exception e) {
            logger.info("lndcbean","---lnd---Eception " + e);
            e.printStackTrace();
        }

    }

    public void landingpageCache() {
        try {
           
            if (this.dynamiclandingpageCacheList != null) {
                this.dynamiclandingpageCacheList.clear();
            }

    
            if (this.ModuleStructureList != null) {
                this.ModuleStructureList.clear();
            }

          
            if (this.ShoremasterList != null) {
                this.ShoremasterList.clear();
            }

            if (this.BPMcodelevellist != null) {
                this.BPMcodelevellist.clear();
            }
            // System.out.println("---LND---tenantIdentifier " + this.tenantIdentifier);
            
                this.dynamiclandingpageCacheList=Cacheintr.cacheDynamiclandingpage(tenantIdentifier);
                this.ShoremasterList = Cacheintr.cacheShoremaster(tenantIdentifier);
                this.ModuleStructureList = Cacheintr.cacheModulestructure(tenantIdentifier);
                this.BPMcodelevellist = Cacheintr.cacheBpmgroupcodelevel(tenantIdentifier);
                bpmGroupCodeLevelList();
               
               
            logger.info("lndcbean","---LND---size dynamiclandingpageCacheList " + this.dynamiclandingpageCacheList.size());
        } catch (Exception e) {
            logger.info("lndcbean","---LND---atcCache Exception " + e);
            e.printStackTrace();
        }
    }

    public void bpmGroupCodeLevelList() {

        try {
      int grpLevel = 0;
        String grpCode = "";
        if (this.BPMcodelevellist.size() > 0) {
          com.svm.mac.atc.model.entity.Bpmgroupcodelevel  gropcodelevel = new com.svm.mac.atc.model.entity.Bpmgroupcodelevel();
          for (int i = 0; i < this.BPMcodelevellist.size(); i++) {
            gropcodelevel = this.BPMcodelevellist.get(i);
            grpCode = gropcodelevel.getGroupcode();
            grpLevel = gropcodelevel.getLevel();
            if (grpCode != null && !grpCode.isEmpty() && grpLevel > 0) {     
                 BPMcodelevelmap.put(grpCode, grpLevel); 
          } 
          this.logger.info("lndcbean"," Inside BPMcodelevelmap Map Size :: " + BPMcodelevelmap.size());
         } 
       }
       } catch (Exception ex) {
        this.logger.info("lndcbean","Exception in BPMcodelevelmap :: INIT :: " + ex.getMessage());
        ex.printStackTrace();
      } 
      }

    public void Show() {
        try {
            logger.info("lndcbean","Show method called");
            this.model.getDataModel().setIncludeOpenItems(false);
            Load();
            RequestContext.getCurrentInstance().update("includeopenitems");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void submitClicked() {
        // System.out.println("submitClicked====called");
    }

    public void updateGrid() {
        // // System.out.println("updateGrid called====");
        rendergrid = true;
        RequestContext.getCurrentInstance().update(this.model.getDataModel().getMdlId() + "_LND_datagrid");
        RequestContext.getCurrentInstance().update("landingPageForm");
    }

    public void Load() {
        logger.info("lndcbean","filterdate====" + this.model.getDataModel().getFilterdate());
        String strArr[] = this.model.getDataModel().getFilterdate().split("~~~");
        btnEditRenderInHmcount = 0;
        String fdate = strArr[0] + " 00:00:00";
        String tdate = strArr[1] + " 23:59:00";
        mDataMap.put("isdatewise", "Y");
        mDataMap.put("fromdate", fdate);
        mDataMap.put("todate", tdate);
        if (this.model.getDataModel().isIncludeOpenItems()) {
            mDataMap.put("includeOpenItems", "Y");
        } else {
            mDataMap.put("includeOpenItems", "N");
        }
        logger.info("lndcbean","fromdate======" + fdate);
        logger.info("lndcbean","todate======" + tdate);
        if (widgetList != null && widgetList.size() > 0) {
            for (int i = 0; i < widgetList.size(); i++) {
                widgetMap.put(widgetList.get(i), 0);
            }
        }
        // ex_VesselnameCacheLoader();
        processDataset();
        makeWidgetCountMap(HmapList);
        LNDPageThirdLevelValidation vo = new LNDPageThirdLevelValidation();
        vo.setMdlid(model.getDataModel().getMdlId());
        vo.setCntrltype(PROJECTTYPE);
        vo.setUsercode(mData.getMetaData(USERINFO.USERCODE));
        loadLandingPage(vo);
        createDataTableColumnModel();
        // RequestContext.getCurrentInstance().update(this.model.getDataModel().getMdlId()
        // + "_LND_datagrid");
        RequestContext.getCurrentInstance().update(this.model.getDataModel().getGridid());
        RequestContext.getCurrentInstance().update(this.model.getDataModel().getSecondgridid());
        RequestContext.getCurrentInstance().update("lndsidebar");

        // RequestContext.getCurrentInstance().execute("openfilter('" +
        // this.model.getDataModel().getMdlId() + "_LND_datagrid');");
        RequestContext.getCurrentInstance().execute("openfilter('" + this.model.getDataModel().getGridid() + "');");

    }

    private void importExcelButton() {
        if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
            if ((model.getDataModel().getMdlId().trim().equalsIgnoreCase("USD"))) {
                model.getDataModel().setUserImportExcelDis(true);
            } else if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("SPS")) {
                model.getDataModel().setVesselImportExcelDis(true);
            } else {
                model.getDataModel().setVesselImportExcelDis(false);
                model.getDataModel().setUserImportExcelDis(false);
            }
        } else {
            model.getDataModel().setVesselImportExcelDis(false);
            model.getDataModel().setUserImportExcelDis(false);
        }
    }

    private void checkFormsOrOthers() {
        try {
          
            logger.info("lndcbean","//==//==|model.getDataModel().getMdlId()|==>" + model.getDataModel().getMdlId());
            applyBPM = checkFormsOrOthers(model.getDataModel().getMdlId());
            logger.info("lndcbean","//==//==|applyBPM|==>" + applyBPM);
           
        } catch (Exception ex) {
            logger.info("lndcbean","//==//==|exception in checkFormsOrOthers|==>" + ex.getMessage());
            logger.fatal(ex);
        }
    }

    public HashMap getDateColumHashMap() {
        return dateColumHashMap;
    }

    public void setDateColumHashMap(HashMap dateColumHashMap) {
        this.dateColumHashMap = dateColumHashMap;
    }

    public boolean checkFormsOrOthers(String mdlId) {
        boolean formsPage = true;
        try {

            CompleteModel userPreference = service.getworkflowmappingid(mdlId.trim(), "A");
            if (userPreference.getWorkflowmapping().isEmpty()) {
                formsPage = false;
            } else {
                formsPage = true;
            }
            List<Workflowmapping> wrkFlowIdCreateList = userPreference.getWorkflowmapping().stream()
                    .filter(obj -> (PROJECTTYPE.trim()).equalsIgnoreCase(obj.getFromcnttypecode())
                            && (PROJECTTYPE.trim()).equalsIgnoreCase(obj.getCnttypecode()))
                    .collect(Collectors.toList());

            if (wrkFlowIdCreateList != null && !wrkFlowIdCreateList.isEmpty()) {
                formCreationWFID = wrkFlowIdCreateList.get(0).getWorkflowid().trim();
                WFType = wrkFlowIdCreateList.get(0).getType().trim();
                if (wrkFlowIdCreateList.get(0).getIsdynamicmdl() != null
                        && wrkFlowIdCreateList.get(0).getIsdynamicmdl().trim().equalsIgnoreCase("Y")) {
                    isDynamicMdl = true;
                } else {
                    isDynamicMdl = false;
                }
            }
            logger.info("lndcbean","//==//==|isDynamicMdl  IN checkFormsOrOthers|==> " + isDynamicMdl + "||==>|formsPage|==>"
                    + formsPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formsPage;
    }

    private void getandLoadVessels_FunctionalRole() {
        try {
           
            CompleteModel completeModel = new CompleteModel();
            logger.info("lndcbean","getCompanyMappedvessels=====called");
            completeModel = service.getCompanyMappedvessels(mData.getMetaData(APPINFO.COMPANY_CODE));
            vesselList = completeModel.getVesselmaster();
           
        } catch (Exception e) {
            logger.fatal(e);
            // explog.setExceptionlog("LND", model.getDataModel().getMdlId(),
            // mData.getMetaData(APPINFO.COMPANY_CODE), PROJECTTYPE, e);
            // logger.info("lndcbean","exception in getandLoadVessels ==>" + e.getMessage());
            // logger.fatal(e);
        }
    }

    private void initializeLandingPage() {
         
        LNDPageThirdLevelValidation vo = new LNDPageThirdLevelValidation();
        try {
            logger.info("lndcbean","//==//==|INSIDE initializeLandingPage|==>");
            userCompanyList();
            this.loginName = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .get("username");
            mDataMap.put("projecttype", PROJECTTYPE);
            mDataMap.put("usercode", mData.getMetaData(USERINFO.USERCODE));
            mDataMap.put("tenantid", mData.getMetaData(USERINFO.TENANT_ID));
            mDataMap.put("subtenantid", mData.getMetaData(USERINFO.SUB_TENANT_ID));
            mDataMap.put("empcode", mData.getMetaData(APPINFO.EMP_CODE));
            mDataMap.put("rankcode", mData.getMetaData(APPINFO.RANK_CODE));
            mDataMap.put("vesselcode", mData.getMetaData(APPINFO.VESSEL_CODE));
            mDataMap.put("active_status", "A");
            mDataMap.put("formatdate", "");
            mDataMap.put("hasrefno", "N");
            mDataMap.put("mdlid", model.getDataModel().getMdlId());
            mDataMap.put("refnolist", "");
            mDataMap.put("isdatewise", "N");
            mDataMap.put("fromdate", getDateToString(new Date()));
            mDataMap.put("todate", getDateToString(new Date()));
            if (includeopenitemsonload != null && includeopenitemsonload.trim().equalsIgnoreCase("Y")) {
                this.model.getDataModel().setIncludeOpenItems(true);
                mDataMap.put("includeOpenItems", "Z"); // by default No
            } else {
                mDataMap.put("includeOpenItems", "N"); // by default No
            }

            vo.setMdlid(model.getDataModel().getMdlId());
            vo.setCntrltype(PROJECTTYPE);
            vo.setUsercode(mData.getMetaData(USERINFO.USERCODE));
            long startTime1 = System.currentTimeMillis();
            landingPageDatasHm = getLandingPageDatas(model.getDataModel().getMdlId(), loginName, mDataMap,
            mData.getMetaData(APPINFO.RANK_CODE));
            long endTime1 = System.currentTimeMillis();
            long executionTime1 = endTime1 - startTime1;
            logger.info("lndcbean", " >>> Landing page Execution time LandingPageDatas: " + executionTime1 + " ms");
            if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001") && choosevessel != null
                    && choosevessel.trim().equalsIgnoreCase("Y")) {
                getandLoadVessels(); // added by vinothini.R //for vessel code selection dialog in shore side
            } else if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001") && choosevessel != null
                    && choosevessel.trim().equalsIgnoreCase("F")) {
                getandLoadVessels_FunctionalRole();
            }
            reorderlandingPageDatasHm = new HashMap(landingPageDatasHm);
            if (applyBPM && (refnofield == null || statusdesc == null)) {
                model.getDataModel().setSm_title("");
                model.getDataModel().setSm_editBtnRender(false);
                model.getDataModel().setSm_newBtnRender(false);
                model.getDataModel().setSm_saveBtnRender(false);
                this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00001", "", null);
            } else {
                loadLandingPage(vo);
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in initializeLandingPage ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public Modulestructure getMdlvo() {
        return mdlvo;
    }

    public void setMdlvo(Modulestructure mdlvo) {
        this.mdlvo = mdlvo;
    }

    private void getmodulename(String mdlid) {
        try {
            // CompleteModel modulenameobj = service.getModuleName(mdlid);

            if (ModuleStructureList != null && ModuleStructureList.size() > 0) {
                List<com.svm.mac.atc.model.entity.Modulestructure> valuelist = ModuleStructureList.stream()
                        .filter(e -> e.getModuleid().equalsIgnoreCase(mdlid))
                        .collect(Collectors.toList());
                if (valuelist != null && !valuelist.isEmpty()) {
                    // System.out.println("modulestructure list>>"+valuelist.get(0).getMenuname());
                    mdlvo = modulestructuremapper(valuelist.get(0));
                    if (mdlvo.getNewtabenb() != null && mdlvo.getNewtabenb().trim().equalsIgnoreCase("y")) {
                        isNewTabEnable = true;
                    }
                }

            }
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    public Modulestructure modulestructuremapper(com.svm.mac.atc.model.entity.Modulestructure obj) {
        Modulestructure moduledata = new Modulestructure();
        moduledata.setMenuname(obj.getMenuname());
        moduledata.setNewtabenb(obj.getNewtabenb());
        moduledata.setLandingpagetitle(obj.getLandingpagetitle());
        return moduledata;
    }

    String newtargetmdl1 = "";
    boolean newnavigateflag1 = false;
    Map WidgetconfigMap = null;
    Map WidgetconfigMapwithoutdot = null;
    ArrayList wcolumnlist = null;
    List controltypebasedstatusshipstatus = new ArrayList();
    List controltypebasedstatusshorestatus = new ArrayList();

    public Map getLandingPageDatas(String moduleId, String loginName, Map<String, String> mDataMap, String rankCode)
            throws Exception {

               
        Map resultHm = new HashMap();
        Map columnDataHM = null;
        Map statustoshowallusersHM = null;
        Map controltypebasedstatusHM = null;
        Map columnDataHMaction = null;

        SvmJsonUtil jsonUtil = new SvmJsonUtil();
        LinkedTreeMap spancolumnHeaders = null;
        LinkedTreeMap spansubcolumnHeaders = null;
        List columnOrderLst = null;
        // **************Edit Identifier Initialize Strated*********
        LinkedTreeMap editidentifierHeaders = null;

        LinkedTreeMap statustoshowallusersHeaders = null;
        String statustoshowalluserscolumn = "";
        String controltypebasedstatuscolumn = "";

        // *************Edit Identifier Initialize End**************

        String displayname;

        HashMap isTimeZoneHm = null;
        HashMap columnTypeHm = null;

        ArrayList columnTypeHmLst = new ArrayList();
        ArrayList isTimeZoneHmLst = new ArrayList();
        List columnFormatLst = new ArrayList();
        tmpColHeaderNamesLst = new ArrayList();
        LinkedTreeMap viewrenidentifierHeaders = null;

        LinkedTreeMap spansubshipcolumnHeaders = null;
        LinkedTreeMap spansubshorecolumnHeaders = null;
        // List spansubcolumnHeaderLst = new ArrayList();
        int indexmapi = 0;
        LinkedTreeMap newrenidentifierHeaders = null;

        String columngroup = "";
        List spancolumnlist = new ArrayList();
        boolean testcolumn = false;
        LinkedTreeMap nBpmVds = null;

        try {
            logger.info("lndcbean","==========loding started here=========");
            // CompleteModel compModelObj = service.getdynamiclandingpage(moduleId); // From
            // dynamiclandingpage table
            CompleteModel vdsModel = new CompleteModel();
            List<Dynamiclandingpage> mdlList = (List<Dynamiclandingpage>) this.dynamiclandingpageCacheList.stream()
                    .filter(mdl -> mdl.getMdlid().equalsIgnoreCase(moduleId)).collect(Collectors.toList());
            vdsModel.setDynamiclandingpage(mdlList);
            this.logger.info("lndcbean","===========DynamiclandingpagemoduleId=========" + moduleId);
            getmodulename(moduleId);
            for (Dynamiclandingpage dynamicPageObj : vdsModel.getDynamiclandingpage()) {

                columnDataHM = (HashMap) jsonUtil.toObject(dynamicPageObj.getColumnmetadata(), HashMap.class);
                if (dynamicPageObj.getStatustoshowallusers() != null
                        && dynamicPageObj.getStatustoshowallusers().trim().length() > 0) {
                    statustoshowallusersHM = (HashMap) jsonUtil.toObject(dynamicPageObj.getStatustoshowallusers(),
                            HashMap.class);
                }
                if (dynamicPageObj.getControltypebasedstatus() != null
                        && dynamicPageObj.getControltypebasedstatus().trim().length() > 0) {
                    controltypebasedstatusHM = (HashMap) jsonUtil.toObject(dynamicPageObj.getControltypebasedstatus(),
                            HashMap.class);
                }
                this.logger
                        .info("===========Dynamiclandingpagesize=========" + vdsModel.getDynamiclandingpage().size());
                columnDataHMaction = (HashMap) jsonUtil.toObject(dynamicPageObj.getActiondefinition(), HashMap.class);
                viewServiceName = dynamicPageObj.getViewservicename();
                viewInputHm = (HashMap) jsonUtil.toObject(dynamicPageObj.getViewinput(), HashMap.class);
                filterviewInputHm = viewInputHm;
                viewIdentifier = dynamicPageObj.getViewidentifier();
                landingPageTitleName = dynamicPageObj.getTitle();
                redirectMdlId = dynamicPageObj.getMdlid();
                serviceType = dynamicPageObj.getViewtype();
                //
                strViewType = dynamicPageObj.getViewtype();
                //
                thirdlevelServiceName = dynamicPageObj.getThirdlevelservicename();
                thirdlevelvalidation = dynamicPageObj.getThirdlevelvalidation();
                applyhandlybyuserlogic = dynamicPageObj.getApplyhandlebyuserlogic();
                statusntchkhl = (HashMap) jsonUtil.toObject(dynamicPageObj.getStatusnottocheckhandlelogic(),
                        HashMap.class);
                if (statusntchkhl != null) {
                    statusntchkhllist = (List) statusntchkhl.get("status");
                }
                if (dynamicPageObj.getAllowcreate() != null && dynamicPageObj.getAllowcreate().equalsIgnoreCase("Y")) {
                    isAllowCreate = true;
                }

                if (dynamicPageObj.getAllowedit() != null && dynamicPageObj.getAllowedit().equalsIgnoreCase("Y")) {
                    isAllowEdit = true;
                }

                logger.info("lndcbean","//==//==|ThirdLevelServiceName in getLandingPageDatas|==>" + thirdlevelServiceName
                        + "||==//==//==| ThirdLevelValidation|==>" + thirdlevelvalidation + "//==//==|columnDataHM|==>"
                        + columnDataHM);

                if (columnDataHM != null) {
                    superEditRestrictor(columnDataHM);
                    initialColumnMetaData(columnDataHM, dynamicPageObj);
                    // logger.info("lndcbean","//==//==|bktypecolname|==>" + bktypecolname);

                    // logger.info("lndcbean","==defaultaction 1====>"+(String)
                    // columnDataHM.get("defaultaction"));
                    // logger.info("lndcbean","//==//==|defaultaction |==>" + defaultaction);
                    doubleclickrender = columnDataHM.containsKey("doubleclickrender")
                            ? (String) columnDataHM.get("doubleclickrender")
                            : "Y";
                    columngroup = columnDataHM.containsKey("columngroup") ? (String) columnDataHM.get("columngroup")
                            : "N";
                    hasfilter = columnDataHM.containsKey("hasfilter") ? (String) columnDataHM.get("hasfilter") : "N";
                    syncstatuscn = columnDataHM.containsKey("syncstatus") ? (String) columnDataHM.get("syncstatus")
                            : null;
                    columnHeaders = (LinkedTreeMap) columnDataHM.get("prop");
                    // logger.info("lndcbean","//==//==|columngroup|==>" + columngroup);
                    // logger.info("lndcbean","//==//==|columnHeaders|==>" + columnHeaders);
                    if (PROJECTTYPE.trim().equalsIgnoreCase("CNT002") && defaultsearchid != null) { // need to enable
                                                                                                    // only on ship side
                        model.getStateModel().setDefaultsearch(true);
                    } else {
                        model.getStateModel().setDefaultsearch(false);
                    }

                    if (enabledatewisesearch != null && enabledatewisesearch.trim().equalsIgnoreCase("Y")) {
                        model.getStateModel().setDatewisesearch(true);
                    } else {
                        model.getStateModel().setDatewisesearch(false);
                    }
                    if (includeOpenItems != null && includeOpenItems.trim().equalsIgnoreCase("Y")) {
                        model.getStateModel().setEnableIncludeOpenItems(true);
                    } else {
                        model.getStateModel().setEnableIncludeOpenItems(false);
                    }

                    if (columngroup.equalsIgnoreCase("Y")) {
                        spancolumnHeaders = (LinkedTreeMap) columnDataHM.get("groupprop");
                        columnOrderLst = (ArrayList) columnDataHM.get("spancolumnorder");
                        if (spancolumnHeaders != null) {
                            Iterator spitr = spancolumnHeaders.keySet().iterator();
                            while (spitr.hasNext()) {
                                String spcolumnName = spitr.next().toString();
                                spansubcolumnHeaders = new LinkedTreeMap();
                                spansubcolumnHeaders = (LinkedTreeMap) spancolumnHeaders.get(spcolumnName);
                                spancolumnlist.add(spcolumnName);
                                Iterator spsubitr = spansubcolumnHeaders.keySet().iterator();
                                while (spsubitr.hasNext()) {
                                    LinkedTreeMap columnPropHm = (LinkedTreeMap) spansubcolumnHeaders
                                            .get(spsubitr.next().toString());
                                    displayname = (String) columnPropHm.get("displayname");
                                    if (spcolumnName.equalsIgnoreCase("Ship Status")) {
                                        headerstlehm.put(displayname, "statusclassship");
                                    } else if (spcolumnName.equalsIgnoreCase("Shore Status")) {
                                        headerstlehm.put(displayname, "statusclassshore");
                                    }
                                }
                            }
                        }
                        spansubshipcolumnHeaders = (LinkedTreeMap) spancolumnHeaders.get("Ship Status");
                        spansubshorecolumnHeaders = (LinkedTreeMap) spancolumnHeaders.get("Shore Status");
                    } else {
                        if (columnDataHM.get("columnorder") == null) {
                            columnOrderLst.add("");
                        } else {
                            columnOrderLst = (ArrayList) columnDataHM.get("columnorder");
                        }
                    }
                    if (columnDataHM.containsKey("editidentifier")) {
                        editidentifierHeaders = (LinkedTreeMap) columnDataHM.get("editidentifier");
                        editidentifiercolumn = (String) editidentifierHeaders.get("column");
                        List tmpvalues = (List) editidentifierHeaders.get("values");
                        // for (int i = 0; i < tmpvalues.size(); i++) {
                        // editidentifiervalues.add(tmpvalues.get(i).toString().toLowerCase());
                        // }
                        if (tmpvalues != null) {
                            editidentifiervalues.addAll(
                                    (Collection) tmpvalues.stream()
                                            .map(value -> value.toString().toLowerCase()) // Convert each element to
                                                                                          // string
                                                                                          // and lowercase
                                            .collect(Collectors.toList()) // Collect the results into a list
                            );
                        }

                        // editidentifiervalues = (List) (editidentifierHeaders.get("values"));
                        // for (int i = 0; i < editidentifiervalues.size(); i++) {
                        // editidentifiervalues.get(i).toString().toLowerCase();
                        // }
                        editidentybool = true;
                        commonidentybool = true;
                    }
                    // logger.info("lndcbean","==statustoshowallusersHM===>" + statustoshowallusersHM);

                    if (statustoshowallusersHM != null && statustoshowallusersHM.containsKey("column")) {
                        statustoshowalluserscolumn = (String) statustoshowallusersHM.get("column");
                        statustoshowallusersvalues = (List) (statustoshowallusersHM.get("values"));
                        if (statustoshowallusersvalues != null) {
                            statustoshowallusersvalues = (List) statustoshowallusersvalues.stream()
                                    .map(value -> value.toString().toLowerCase())
                                    .collect(Collectors.toList());
                        }

                        statustoshowallusersbool = true;
                        commonidentybool = true;

                    }

                    // logger.info("lndcbean","==controltypebasedstatusHM===>" + controltypebasedstatusHM);
                    if (controltypebasedstatusHM != null && controltypebasedstatusHM.containsKey("column")) {
                        controltypebasedstatuscolumn = (String) controltypebasedstatusHM.get("column");
                        controltypebasedstatusshipstatus = (List) (controltypebasedstatusHM.get("shipvalues"));
                        controltypebasedstatusshorestatus = (List) (controltypebasedstatusHM.get("shorevalues"));
                        if (sControlTypeCode != null && sControlTypeCode.equalsIgnoreCase("CNT002")) {
                            // for (int i = 0; i < controltypebasedstatusshipstatus.size(); i++) {
                            // controltypebasedstatus
                            // .add(controltypebasedstatusshipstatus.get(i).toString().toLowerCase());
                            // }
                            if (controltypebasedstatusshipstatus != null) {
                                controltypebasedstatus = (List) controltypebasedstatusshipstatus.stream()
                                        .map(value -> value.toString().toLowerCase())
                                        .collect(Collectors.toList());
                            }

                        } else {
                            // for (int i = 0; i < controltypebasedstatusshorestatus.size(); i++) {
                            // controltypebasedstatus
                            // .add(controltypebasedstatusshorestatus.get(i).toString().toLowerCase());
                            // }
                            if (controltypebasedstatusshorestatus != null) {
                                controltypebasedstatus = (List) controltypebasedstatusshorestatus.stream()
                                        .map(value -> value.toString().toLowerCase())
                                        .collect(Collectors.toList());
                            }

                        }
                        controltypebasedstatusbool = true;
                        commonidentybool = true;

                    }

                }

                // logger.info("lndcbean","getActiondefinition in getLandingPageDatas ??" +
                // columnDataHMaction);
                if (columnDataHMaction != null && columnDataHMaction.containsKey("groupbutton")) {
                    groupbuttonHeaders = (LinkedTreeMap) columnDataHMaction.get("groupbutton");
                }

                if (doubleclickrender.equalsIgnoreCase("N")) {
                    model.getStateModel().setDoubleclickdisbled(true);
                } else {
                    model.getStateModel().setDoubleclickdisbled(false);
                }
                // logger.info("lndcbean","===columnOrderLst====>" + columnOrderLst);

                if (columnHeaders != null) { 
                    List rowHm = new ArrayList();
                  List rowHmDummy = new ArrayList();
                if (columnOrderLst != null) {
                    for (int m = 0; m < columnOrderLst.size(); m++) {
                        Iterator itr = columnHeaders.keySet().iterator();
                        while (itr.hasNext()) {
                            String columnName = itr.next().toString();
                            if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnName)) {
                                columnTypeHm = new HashMap();
                                isTimeZoneHm = new HashMap();
                                LinkedTreeMap columnPropHm = (LinkedTreeMap) columnHeaders.get(columnName);
                                displayname = (String) columnPropHm.get("displayname");
                                columnHeaderLst.add(displayname);
                                if (displayname != null && displayname.equalsIgnoreCase(sortByColumn)) {
                                    sortByHm.put(displayname, "sort");
                                } else {
                                    sortByHm.put(displayname, "");
                                }

                                columnTypeLst.add(columnPropHm.get("type"));
                                columnTypeHm.put(displayname, columnPropHm.get("type"));
                                isTimeZoneHm.put(displayname, columnPropHm.get("isTimeZone"));
                               //                 
                                columnFormatLst.add(columnPropHm.get("format"));
                                tmpColHeaderNamesLst.add(columnName);
                                headerDisplayNameVarMap.put(displayname, columnName);
                                ColumnDisplayNameVarMap.put(columnName, displayname);
                                columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());

                                if (hideInShip.contains(columnName) && PROJECTTYPE.trim().equalsIgnoreCase("CNT002")) {
                                    hideInShipcollst.add(displayname);
                                    hideList.add(columnName.replaceAll("\\.", ""));
                                }
                                if (hideInShore.contains(columnName) && PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
                                    hideInShorecollst.add(displayname);
                                    hideList.add(columnName.replaceAll("\\.", ""));
                                }
                                if (statusdesc != null && statusdesc.equalsIgnoreCase(columnName)) {
                                    statusdescdpname = displayname;
                                }

                                if (backuptype != null && backuptype.equalsIgnoreCase(columnName)) {
                                    backuptypecolname = displayname;
                                }

                             //                                   ************** button *****************
                                if (columnPropHm.containsKey("action")) {
                                    String buttonval = columnPropHm.get("action").toString();
                                    buttonchk = buttonval.equalsIgnoreCase("Y");
                                    if (buttonval.equalsIgnoreCase("Y")) {
                                        buttonMap.put(columnName, displayname);
                                        Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
                                        while (itrgrpbtn.hasNext()) {
                                            String chkcolumn = itrgrpbtn.next().toString();
                                            if (columnName.equalsIgnoreCase(chkcolumn)) {
                                                LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumn);
                                                if (columnPropHmgrpbtn.containsKey("view")) {
                                                    indexmap.put(indexmapi, "true");
                                                    LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
                                                    //vvv  viewbtnlist.add(displayname);
                                                    viewbtnlist.add(columnName.replaceAll("\\.", ""));
                                                    if (columnPropHmview.containsKey("renderidentifier")) {
                                                        viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
                                                        viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
                                                        viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
                                                        viewrenidentybool = true;
                                                        commonidentybool = true;
                                                    }
                                                } else {
                                                    indexmap.put(indexmapi, "false");
                                                }
                                                if (columnPropHmgrpbtn.containsKey("edit")) {
                                                    indexmapedit.put(indexmapi, true);
                                                    LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
                                                    //  editbtnlist.add(displayname);
                                                    editbtnlist.add(columnName.replaceAll("\\.", ""));
                                                    if (columnPropHmedit.containsKey("renderidentifier")) {
                                                        editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
                                                        editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
                                                        editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
                                                        editrenidentybool = true;
                                                        commonidentybool = true;
                                                    }
                                                    if (columnPropHmedit.containsKey("applybpm")) {
                                                        editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
                                                    }
                                                } else {
                                                    indexmapedit.put(indexmapi, false);
                                                }
                                                if (columnPropHmgrpbtn.containsKey("new")) {
                                                    indexmapnew.put(indexmapi, true);
                                                    LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
                                                    newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
                                                    newtargetmdl1 = columnPropHmnew.get("targetmdl").toString();
                                                    newnavigateflag1 = (boolean) columnPropHmnew.get("navigateflag");
                                                    newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));

                                                    //  newbtnlist.add(displayname);
                                                    newbtnlist.add(columnName.replaceAll("\\.", ""));
                                                    if (columnPropHmnew.containsKey("renderidentifier")) {
                                                        newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
                                                        newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
                                                        newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
                                                        newrenidentybool = true;
                                                        commonidentybool = true;
                                                    }
                                                } else {
                                                    indexmapnew.put(indexmapi, false);
                                                }
                                            }
                                        }
                                    }
                                    indexmapi++;
                                } else {
                                    indexmap.put(indexmapi, "false");
                                    indexmapedit.put(indexmapi, false);
                                    indexmapnew.put(indexmapi, false);
                                    indexmapi++;
                                }
                                columnTypeHmLst.add(columnTypeHm);
                                isTimeZoneHmLst.add(isTimeZoneHm);
                            }
                        }
                        if (columngroup.equalsIgnoreCase("Y")) {
                            Iterator shipitr = spansubshipcolumnHeaders.keySet().iterator();
                            Iterator shoreitr = spansubshorecolumnHeaders.keySet().iterator();
                            if (spansubshipcolumnHeaders != null) {
                                while (shipitr.hasNext()) {
                                    String columnNameship = shipitr.next().toString();
                                    if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnNameship)) {
                                        columnTypeHm = new HashMap();
                                        isTimeZoneHm = new HashMap();
                                        LinkedTreeMap columnPropHm = (LinkedTreeMap) spansubshipcolumnHeaders.get(columnNameship);
                                        displayname = (String) columnPropHm.get("displayname");
                                        spansubcolumnHeaderLst.add(displayname);
                                        spansubcolumnshipHeaderLst.add(displayname);
                                        columnHeaderLst.add(displayname);
                                        if (displayname != null && displayname.equalsIgnoreCase(sortByColumn)) {
                                            sortByHm.put(displayname, "sort");
                                        } else {
                                            sortByHm.put(displayname, "");
                                        }
                                        columnTypeLst.add(columnPropHm.get("type"));
                                        columnTypeHm.put(displayname, columnPropHm.get("type"));
                                        isTimeZoneHm.put(displayname, columnPropHm.get("isTimeZone"));
                                        columnFormatLst.add(columnPropHm.get("format"));
                                        tmpColHeaderNamesLst.add(columnNameship);
                                        headerDisplayNameVarMap.put(displayname, columnNameship);
                                        ColumnDisplayNameVarMap.put(columnNameship, displayname);
                                        columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());

                           //                                    --------------------for button---------------
                                        if (columnPropHm.containsKey("action")) {
                                            String buttonval = columnPropHm.get("action").toString();
                                            if (buttonval.equalsIgnoreCase("Y")) {
                                                buttonMap.put(columnNameship, displayname);
                                                Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
                                                while (itrgrpbtn.hasNext()) {
                                                    String chkcolumnship = itrgrpbtn.next().toString();

                                                    if (columnNameship.equalsIgnoreCase(chkcolumnship)) {
                                                        LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumnship);
                                                        if (columnPropHmgrpbtn.containsKey("view")) {
                                                            indexmap.put(indexmapi, "true");
                                                            LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
                                                            if (columnPropHmview.containsKey("renderidentifier")) {
                                                                viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
                                                                viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
                                                                viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < viewrenidentifiervalues.size(); i++) {
                                                                    viewrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }
                                                                viewrenidentybool = true;
                                                                commonidentybool = true;
                                                            }

                                                        } else {
                                                            indexmap.put(indexmapi, "false");
                                                        }
                                                        if (columnPropHmgrpbtn.containsKey("edit")) {
                                                            indexmapedit.put(indexmapi, true);
                                                            LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
                                                            if (columnPropHmedit.containsKey("renderidentifier")) {
                                                                editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
                                                                editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
                                                                editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < editrenidentifiervalues.size(); i++) {
                                                                    editrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }
                                                                editrenidentybool = true;
                                                                commonidentybool = true;
                                                            }
                                                            if (columnPropHmedit.containsKey("applybpm")) {
                                                                editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
                                                            }
                                                        } else {
                                                            indexmapedit.put(indexmapi, false);
                                                        }
                                                        if (columnPropHmgrpbtn.containsKey("new")) {
                                                            indexmapnew.put(indexmapi, true);
                                                            LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
                                                            newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
                                                            newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
                                                            newtargetmdl1 = columnPropHmnew.get("targetmdl").toString();
                                                            newnavigateflag1 = (boolean) columnPropHmnew.get("navigateflag");
                                                            if (columnPropHmnew.containsKey("renderidentifier")) {
                                                                newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
                                                                newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
                                                                newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < newrenidentifiervalues.size(); i++) {
                                                                    newrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }
                                                                newrenidentybool = true;
                                                                commonidentybool = true;
                                                            }
                                                        } else {
                                                            indexmapnew.put(indexmapi, false);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            indexmap.put(indexmapi, "false");
                                            indexmapedit.put(indexmapi, false);
                                            indexmapnew.put(indexmapi, false);
                                        }
                                        indexmapi++;

                                        columnTypeHmLst.add(columnTypeHm);
                                        isTimeZoneHmLst.add(isTimeZoneHm);
                                    }
                                }
                            }
                            if (spansubshorecolumnHeaders != null) {
                                while (shoreitr.hasNext()) {
                                    String columnNameshore = shoreitr.next().toString();
                                    if (columnOrderLst.get(m).toString().equalsIgnoreCase(columnNameshore)) {
                                        columnTypeHm = new HashMap();
                                        isTimeZoneHm = new HashMap();
                                        LinkedTreeMap columnPropHm = (LinkedTreeMap) spansubshorecolumnHeaders.get(columnNameshore);
                                        displayname = (String) columnPropHm.get("displayname");
                                        spansubcolumnHeaderLst.add(displayname);
                                        spansubcolumnshoreHeaderLst.add(displayname);
                                        columnHeaderLst.add(displayname);
                                        if (displayname != null && displayname.equalsIgnoreCase(sortByColumn)) {
                                            sortByHm.put(displayname, "sort");
                                        } else {
                                            sortByHm.put(displayname, "");
                                        }
                                        columnTypeLst.add(columnPropHm.get("type"));
                                        columnTypeHm.put(displayname, columnPropHm.get("type"));
                                        isTimeZoneHm.put(displayname, columnPropHm.get("isTimeZone"));
                                        columnFormatLst.add(columnPropHm.get("format"));
                                        tmpColHeaderNamesLst.add(columnNameshore);
                                        headerDisplayNameVarMap.put(displayname, columnNameshore);
                                        ColumnDisplayNameVarMap.put(columnNameshore, displayname);
                                        columnTypeLstreoderMap.put(displayname, columnPropHm.get("type").toString());

//                                    -------------------for button----------------
                                        if (columnPropHm.containsKey("action")) {
                                            String buttonval = columnPropHm.get("action").toString();
                                            if (buttonval.equalsIgnoreCase("Y")) {
                                                buttonMap.put(columnNameshore, displayname);
                                                Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();
                                                while (itrgrpbtn.hasNext()) {
                                                    String chkcolumnshore = itrgrpbtn.next().toString();
//                                                logger.info("lndcbean","injk itrgrpbtn==****>" + columnNameshore + "=itrgrpbtn.next().toString()==" + chkcolumnshore);
                                                    if (columnNameshore.equalsIgnoreCase(chkcolumnshore)) {
                                                        LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(chkcolumnshore);
                                                        if (columnPropHmgrpbtn.containsKey("view")) {
                                                            indexmap.put(indexmapi, "true");
                                                            LinkedTreeMap columnPropHmview = (LinkedTreeMap) columnPropHmgrpbtn.get("view");
                                                            if (columnPropHmview.containsKey("renderidentifier")) {
                                                                viewrenidentifierHeaders = (LinkedTreeMap) columnPropHmview.get("renderidentifier");
                                                                viewrenidentifiercolumn = (String) viewrenidentifierHeaders.get("column");
                                                                viewrenidentifiervalues = (List) (viewrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < viewrenidentifiervalues.size(); i++) {
                                                                    viewrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }
                                                                viewrenidentybool = true;
                                                                commonidentybool = true;
                                                            }
                                                        } else {
                                                            indexmap.put(indexmapi, "false");
                                                        }
                                                        if (columnPropHmgrpbtn.containsKey("edit")) {
                                                            indexmapedit.put(indexmapi, true);
                                                            LinkedTreeMap columnPropHmedit = (LinkedTreeMap) columnPropHmgrpbtn.get("edit");
                                                            if (columnPropHmedit.containsKey("renderidentifier")) {
                                                                editrenidentifierHeaders = (LinkedTreeMap) columnPropHmedit.get("renderidentifier");
                                                                editrenidentifiercolumn = (String) editrenidentifierHeaders.get("column");
                                                                editrenidentifiervalues = (List) (editrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < editrenidentifiervalues.size(); i++) {
                                                                    editrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }

                                                                editrenidentybool = true;
                                                                commonidentybool = true;
                                                            }
                                                            if (columnPropHmedit.containsKey("applybpm")) {
                                                                editactionapplybpm = (boolean) columnPropHmedit.get("applybpm");
                                                            }
                                                        } else {
                                                            indexmapedit.put(indexmapi, false);
                                                        }
                                                        if (columnPropHmgrpbtn.containsKey("new")) {
                                                            indexmapnew.put(indexmapi, true);
                                                            LinkedTreeMap columnPropHmnew = (LinkedTreeMap) columnPropHmgrpbtn.get("new");
                                                            newtargetmdl.put(indexmapi, columnPropHmnew.get("targetmdl").toString());
                                                            newtargetmdl1 = columnPropHmnew.get("targetmdl").toString();
                                                            newnavigateflag1 = (boolean) columnPropHmnew.get("navigateflag");
                                                            newnavigateflag.put(indexmapi, (boolean) columnPropHmnew.get("navigateflag"));
                                                            if (columnPropHmnew.containsKey("renderidentifier")) {
                                                                newrenidentifierHeaders = (LinkedTreeMap) columnPropHmnew.get("renderidentifier");
                                                                newrenidentifiercolumn = (String) newrenidentifierHeaders.get("column");
                                                                newrenidentifiervalues = (List) (newrenidentifierHeaders.get("values"));
                                                                for (int i = 0; i < newrenidentifiervalues.size(); i++) {
                                                                    newrenidentifiervalues.get(i).toString().toLowerCase();
                                                                }
                                                                newrenidentybool = true;
                                                                commonidentybool = true;
                                                            }
                                                        } else {
                                                            indexmapnew.put(indexmapi, false);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            indexmap.put(indexmapi, "false");
                                            indexmapedit.put(indexmapi, false);
                                            indexmapnew.put(indexmapi, false);
                                        }
                                        indexmapi++;
//                                    -------------------------
                                        columnTypeHmLst.add(columnTypeHm);
                                        isTimeZoneHmLst.add(isTimeZoneHm);
                                    }
                                }
                            }
                        }

                    }

                }
                logger.info("lndcbean","before processing sp dataset%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                int rstZise = 0;

                colNameMap = replaceDot(tmpColHeaderNamesLst);
                setConfigDates();
//                    ex_VesselnameCacheLoader();
                processDataset();

                // getPendingTaskdetails(); // added for testing
                logger.info("lndcbean","end===================%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }

            }
                
        } catch (Exception e) {
            logger.info("lndcbean","exception in getLandingPageDatas ==>" + e.getMessage());
            logger.fatal(e);
        }
        return resultHm;
    }

    public void initialColumnMetaData(Map columnDataHM, Dynamiclandingpage dynamicPageObj) {
        String bpmwrkflowidscript = "";
        model.getDataModel()
                .setnBPMconfigrecall(columnDataHM.containsKey("recallAPIServicedetails")
                        ? (LinkedTreeMap) columnDataHM.get("recallAPIServicedetails")
                        : null);
        choosevessel = columnDataHM.containsKey("choosevessel") ? (String) columnDataHM.get("choosevessel")
                : null;
        // backUpTypeIndex = columnDataHM.containsKey("backuptypeindex") ?
        // Integer.parseInt((String) columnDataHM.get("backuptypeindex")) : -1;
        sortByColumn = columnDataHM.containsKey("sortby") ? columnDataHM.get("sortby").toString() : "";
        hideInShore = columnDataHM.containsKey("hideinshore") ? (List) columnDataHM.get("hideinshore")
                : new ArrayList();
        hideInShip = columnDataHM.containsKey("hideinship") ? (List) columnDataHM.get("hideinship")
                : new ArrayList();
        refnofield = columnDataHM.containsKey("refnofield") ? (String) columnDataHM.get("refnofield")
                : null;
        refnofieldwithoutdot = refnofield != null ? refnofield.replaceAll("\\.", "") : null;
        dynamicLandingVesselnamePropertyCode = columnDataHM.containsKey("lndvesselcolname")
                ? columnDataHM.get("lndvesselcolname").toString().toLowerCase()
                : "";
        dynamicLandingCreatedDatePropertyCode = columnDataHM.containsKey("lndcrdatecolname")
                ? columnDataHM.get("lndcrdatecolname").toString().toLowerCase()
                : "";
        dynamicLandingCompanynamePropertyCode = columnDataHM.containsKey("lndcompanycolname")
                ? columnDataHM.get("lndcompanycolname").toString().toLowerCase()
                : "";
        dynamicLandingReferenceCode = columnDataHM.containsKey("refnofield")
                ? (String) columnDataHM.get("refnofield").toString().toLowerCase()
                : "";
        dynamicLandingVesselcodePropertyCode = columnDataHM.containsKey("lndvesselcodename")
                ? columnDataHM.get("lndvesselcodename").toString().toLowerCase()
                : "";
        additionalreviewervalidation = columnDataHM.containsKey("additionalreviewervalidation")
                ? (String) columnDataHM.get("additionalreviewervalidation")
                : null;
        logger.info("lndcbean","//==//==|refnofield|==>" + refnofield);
        // feb
        WidgetconfigMap = columnDataHM.containsKey("otherwidgetmap")
                ? (Map) columnDataHM.get("otherwidgetmap")
                : new HashMap();
        WidgetconfigMapwithoutdot = new HashMap();
        // System.out.println("WidgetconfigMap===================" + WidgetconfigMap);
        ArrayList wlist = new ArrayList();
        wcolumnlist = new ArrayList();
        if (WidgetconfigMap != null && WidgetconfigMap.size() > 0) {
            Iterator itr1 = WidgetconfigMap.keySet().iterator();
            while (itr1.hasNext()) {
                String wcolumnName = itr1.next().toString();
                wcolumnlist.add(wcolumnName.replaceAll("\\.", ""));
                wlist.addAll((ArrayList) WidgetconfigMap.get(wcolumnName));

                WidgetconfigMapwithoutdot.put(wcolumnName.replaceAll("\\.", ""),
                        (ArrayList) WidgetconfigMap.get(wcolumnName));
            }
        }

        // feb
        // System.out.println("wcolumnlist=====" + wcolumnlist);
        String bktypecolname = "backuptype";
        if (refnofield != null && refnofield.contains(".")) {
            String[] arr = refnofield.split("\\.");
            bktypecolname = arr[0] + ".backuptype";
        }
        bpmwrkflowidscript = columnDataHM.containsKey("bpmwrkflowid")
                ? (String) columnDataHM.get("bpmwrkflowid")
                : null;
        statusdesc = columnDataHM.containsKey("statusdesc") ? (String) columnDataHM.get("statusdesc")
                : null;
        backuptype = columnDataHM.containsKey("backuptype") ? (String) columnDataHM.get("backuptype")
                : bktypecolname;
        defaultsearchid = columnDataHM.containsKey("defaultsearch")
                ? (String) columnDataHM.get("defaultsearch")
                : null;
        getAssignDefaultRange(); // global config

        int defaultrangeindays = dynamicPageObj.getDaterangeindays(); // provided in new column
        // System.out.println("defaultrange====" + defaultrange);
        if (defaultrangeindays == 0) {
            // if its 0, then columnmetadataconfig or else global
            defaultrange = columnDataHM.containsKey("defaultrange")
                    ? Integer.parseInt(columnDataHM.get("defaultrange").toString())
                    : defaultrange; // provided in column metadata

        } else {
            defaultrange = defaultrangeindays;
        }
        // defaultrange = columnDataHM.containsKey("defaultrange") ?
        // Integer.parseInt(columnDataHM.get("defaultrange").toString()) : defaultrange;
        disMyactions = columnDataHM.containsKey("hidemyaction")
                && columnDataHM.get("hidemyaction").toString().trim().equalsIgnoreCase("Y") ? true : false;
        statusdescwithoutdot = statusdesc != null ? statusdesc.replaceAll("\\.", "") : null;
        backgroundtobeaddedList1 = columnDataHM.containsKey("enablecolumnbackground")
                ? (List) columnDataHM.get("enablecolumnbackground")
                : null;
        if (backgroundtobeaddedList1 != null) {
            for (int i = 0; i < backgroundtobeaddedList1.size(); i++) {
                backgroundtobeaddedList
                        .add(backgroundtobeaddedList1.get(i).toString().replaceAll("\\.", ""));
            }
        }
        List backgroundcolorlist = columnDataHM.containsKey("custombackgroundColorField")
                ? (List) columnDataHM.get("custombackgroundColorField")
                : null;
        if (backgroundcolorlist != null) {
            for (int i = 0; i < backgroundcolorlist.size(); i++) {
                customFieldBackGroundColourList
                        .add(backgroundcolorlist.get(i).toString().replaceAll("\\.", ""));
            }
        }
        // System.out.println("backgroundtobeaddedList===" + backgroundtobeaddedList);
        backuptypewithoutdot = backuptype != null ? backuptype.replaceAll("\\.", "")
                : bktypecolname + "backuptype";
        widgetcolumn = columnDataHM.containsKey("widgetcolumn") ? (String) columnDataHM.get("widgetcolumn")
                : null;
        if (widgetcolumn != null) {
            widgetcolumn = widgetcolumn.replaceAll("\\.", "");
            this.model.getStateModel().setEnablestatusbar(true);
        } else {
            this.model.getStateModel().setEnablestatusbar(false);
        }

        for (int w = 0; w < wcolumnlist.size(); w++) {

            wcolumnlist.get(w).toString().replaceAll("\\.", "");
        }
        wcolumnlist.add(widgetcolumn);
        // System.out.println("wcolumnlist====2=====" + wcolumnlist);
        widgetListconfigured = columnDataHM.containsKey("widgetvalues")
                ? (List) columnDataHM.get("widgetvalues")
                : new ArrayList();
        if (columnDataHM.containsKey("widgettooltip")) {
            widgetToolTipConfig = (LinkedTreeMap) columnDataHM.get("widgettooltip");
        }
        // System.out.println("widgetToolTipConfig=====" + widgetToolTipConfig);

        WidgetconfigMap.put(widgetcolumn, widgetListconfigured);
        WidgetconfigMapwithoutdot.put(widgetcolumn, widgetListconfigured);
        // if (widgetListconfigured != null && widgetListconfigured.size() > 0 ||
        // WidgetconfigMap != null) {
        // widgetList.add("chatapplicable");
        // widgetList.add("notificationapplicable");
        // for (int i = 0; i < widgetListconfigured.size(); i++) {
        // widgetList.add(widgetListconfigured.get(i));
        // }

        // for (int i = 0; i < wlist.size(); i++) {
        // widgetList.add(wlist.get(i).toString());
        // }
        // // widgetList.add("Taskapplicable");
        // // widgetList.add("alerts");
        // for (int i = 0; i < widgetList.size(); i++) {
        // widgetMap.put(widgetList.get(i).trim(), 0);
        // }

        // }

        if ((widgetListconfigured != null && !widgetListconfigured.isEmpty()) || WidgetconfigMap != null) {
            widgetList.addAll(Stream.of("chatapplicable", "notificationapplicable")
                    .collect(Collectors.toList()));

            if (widgetListconfigured != null) {
                widgetList.addAll(widgetListconfigured); // Add all elements from widgetListconfigured
            }

            widgetList.addAll((Collection<? extends String>) wlist.stream()
                    .map(Object::toString) // Convert each element in wlist to String
                    .collect(Collectors.toList()));

            // Populate widgetMap with widgetList elements, trimming the keys
            widgetList.forEach(item -> widgetMap.put(item.trim(), 0));
        }

        // System.out.println("widgetList====333======" + widgetList.toString());
        enabledatewisesearch = columnDataHM.containsKey("enabledatewisesearch")
                ? (String) columnDataHM.get("enabledatewisesearch")
                : null;
        includeOpenItems = columnDataHM.containsKey("includeopenitems")
                ? (String) columnDataHM.get("includeopenitems")
                : null;
        includeopenitemsonload = columnDataHM.containsKey("includeopenitemsonload")
                ? (String) columnDataHM.get("includeopenitemsonload")
                : null;
        if (includeopenitemsonload != null && includeopenitemsonload.trim().equalsIgnoreCase("Y")) {
            this.model.getDataModel().setIncludeOpenItems(true);
            mDataMap.put("includeOpenItems", "Z");
        } else {
            mDataMap.put("includeOpenItems", "N"); // by default No
        }
        defaultaction = columnDataHM.containsKey("defaultaction")
                ? (String) columnDataHM.get("defaultaction")
                : "Y";
    }

    public void superEditRestrictor(Map columnDataHM) {
        if (columnDataHM.containsKey("superEditRestrictor")) {
            Map<Object, Object> superEditRestrictor = new LinkedTreeMap<>();
            superEditRestrictor = (LinkedTreeMap<Object, Object>) columnDataHM.get("superEditRestrictor");
            if (superEditRestrictor.containsKey("columnName")
                    && superEditRestrictor.get("columnName").toString() != null
                    && superEditRestrictor.containsKey("values")
                    && superEditRestrictor.get("values").toString() != null) {
                String values = superEditRestrictor.get("values").toString().replace("[", "").replace("]",
                        "");
                model.getDataModel().setSuperEditRestrictorColumn(
                        superEditRestrictor.get("columnName").toString().replace(".", ""));
                model.getDataModel().setSuperEditRestrictorValues(Arrays.asList(values.split(",")));
            }
        }
    }

    private <T> T invokeGetterService(String strServiceName, String tablealias, HashMap whereFields,
            Class<T> resultType, String serviceType, Map<String, String> mDataMap) {
        T result = null;
        SvmJsonUtil jsonUtil;
        SvmJsonList spParam = new SvmJsonList();
        String vdstenant = "MAC";
        try {
            jsonUtil = new SvmJsonUtil();
            if (serviceType != null && serviceType.equalsIgnoreCase("DS")) {
                this.serviceInvoker.setService(strServiceName, vdstenant);
            }

            LinkedTreeMap mainLTM = (LinkedTreeMap) whereFields.get("viewinput");
            if (mainLTM != null) {
                Iterator itr = mainLTM.keySet().iterator();
                while (itr.hasNext()) {
                    String key = itr.next().toString();
                    LinkedTreeMap whereFieldsFinalHm = (LinkedTreeMap) mainLTM.get(key);
                    addWhereFieldToServiceInvoker(this.serviceInvoker, whereFieldsFinalHm, spParam, mDataMap);
                }
                if (serviceType != null && (serviceType.equalsIgnoreCase("DS"))) {
                    this.serviceInvoker.execute();
                } else {
                    this.serviceInvoker.invokeMTPFunction(strServiceName, vdstenant, spParam, tenantIdentifier);
                }
                if (serviceType.equalsIgnoreCase("DS") || serviceType.equalsIgnoreCase("SP")) {
                    if (this.serviceInvoker.getStatus() == 200) {
                        if (this.serviceInvoker.getResultSet(tablealias) != null) {
                            String jsonString = this.serviceInvoker.getResultSet(tablealias).toString();
                            result = (T) jsonUtil.toObject(jsonString, resultType);
                        }
                    }
                } else {
                    if (this.serviceInvoker.getStatus() == 200) {
                        if (this.serviceInvoker.getResult() != null) {
                            String jsonString = this.serviceInvoker.getResult().toString();
                            result = (T) jsonUtil.toObject(jsonString, resultType);
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.info("lndcbean","exception in invokeGetterService ==>" + e.getMessage());
            logger.fatal(e);
        }
        return result;
    }

    private void addWhereFieldToServiceInvoker(VDSInvoker vds, LinkedTreeMap whereFields, SvmJsonList spParam,
            Map<String, String> mDataMap) {
        String columnName = "";
        String columnValue = "";
        String dpname = "";
        if (vds != null && whereFields != null) {
            Iterator itr = whereFields.keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next().toString();
                if (key != null && key.equalsIgnoreCase("fieldname")) {
                    String fieldName = whereFields.get(key).toString();
                    // ************ Filter *******************
                    if (defaultselradio.containsKey(fieldName)) {
                        dpname = defaultselradio.get(fieldName).toString();
                        columnName = fieldName.trim();
                        columnValue = filterValuehm.get(dpname.trim()).toString();
                        spParam.add(filterValuehm.get(dpname));
                    } else if (defaultselchk.containsKey(fieldName)) {
                        dpname = defaultselchk.get(fieldName).toString();
                        columnName = dpname.trim();
                        columnValue = dpname.trim();
                        spParam.add(dpname);
                    } else if (datehashmap.containsKey(fieldName)) {
                        dpname = datehashmap.get(fieldName).toString();
                        columnName = fieldName.trim();
                        columnValue = dpname;
                        spParam.add(dpname); // ************ Filter End*******************
                    } else {
                        if (fieldName.trim().length() > 0) {
                            columnName = fieldName.trim();
                            logger.info("lndcbean","fieldName.trim()>>" + fieldName.trim());
                            logger.info("lndcbean","fieldName.trim()>>" + mDataMap.get(fieldName.trim()));
                            columnValue = mDataMap.get(fieldName.trim());
                            spParam.add(mDataMap.get(fieldName));
                        }
                    }

                }
            }

            vds.setWhere(columnName, columnValue);
        }
        logger.info("lndcbean","spParam ?????????????????? " + spParam);
    }

    private void loadLandingPage(LNDPageThirdLevelValidation vo) {
       
        int indexcolumn = 0;

        String statuscolname = "";

        ArrayList bmhmaddinglist = new ArrayList();
        LinkedTreeMap<String, String> refhm1 = new LinkedTreeMap<String, String>();
        // List handlelist=new ArrayList();
        try {
            model.getDataModel().setSm_saveBtnRender(true);
            CompleteModel completeModel = new CompleteModel();
            // logger.info("lndcbean","reodersubmit>>>" + reodersubmit);
            // logger.info("lndcbean","==columnHeaderLstHide===>" + columnHeaderLstHide);
            if (columnHeaderLstHide != null && columnHeaderLstHide.contains("Action")) {
                model.getStateModel().setActionColumnRender(false);
            } else {
                model.getStateModel().setActionColumnRender(true);
            }

            Hmrows = HmapList;

            statusdescindex = tmpColumnNames.indexOf(statusdesc);
            syncstatuscnindex = tmpColumnNames.indexOf(syncstatuscn);
            refnofieldIndex = tmpColumnNames.indexOf(refnofield);
            statuscolname = statusdesc;

            if (buttonMap != null) {
                Iterator itrbutton = buttonMap.keySet().iterator();
                while (itrbutton.hasNext()) {
                    String groupcolumnName = itrbutton.next().toString();
                    indexcolumn = tmpColumnNames.indexOf(groupcolumnName);
                    indexcolumnmap.put(groupcolumnName, indexcolumn);
                }
            }

            this.quickModuleRights.getModuleRights(model.getDataModel().getMdlId());
            // logger.info("lndcbean","==sortByHm===>" + sortByHm);
            model.getDataModel().setSortByHm(sortByHm);
            model.getDataModel().setSm_allcolumnsLst(columnHeaderLst);
            model.getDataModel().setSm_title(landingPageTitleName);
            model.getDataModel().setSm_editBtnRender(this.quickModuleRights.getWriteRights());
            model.getDataModel().setSm_newBtnRender(this.quickModuleRights.getWriteRights());
            model.getDataModel().setColumnTypeHmLst(columnTypeHmLst);
            // System.out.println("this.quickModuleRights.getWriteRights()=====>>>>" +
            // this.quickModuleRights.getWriteRights());
            logger.info("lndcbean","==columnTypeHmList.size()====>" + model.getDataModel().getColumnTypeHmLst().size());
            if (isAllowCreate == false) {
                model.getDataModel().setSm_newBtnRender(isAllowCreate);
            }
            // if (isAllowEdit == false) {
            // model.getDataModel().setSm_editBtnRender(isAllowEdit);
            // }

            // bpm starts
           
            if (applyBPM) {
                long startTime2 = System.currentTimeMillis();
                isEnableOtherlistToggle();
                refnofieldIndex = tmpColumnNames.indexOf(refnofield);
                // backuptypeIndex = tmpColumnNames.indexOf(backuptype);
                statusdescindex = tmpColumnNames.indexOf(landingPageDatasHm.get("statusdesc"));
                logger.info("lndcbean","refnofieldIndex in loadLandingPage ??" + refnofieldIndex + "?? statusdescindex ??"
                        + statusdescindex);
                logger.info("lndcbean","bpmwrkflowidscript in loadLandingPage ??" + landingPageDatasHm.get("bpmwrkflowidscript"));

                applyBPMRights();
                long endTime2 = System.currentTimeMillis();
                long executionTime2 = endTime2 - startTime2;
                logger.info("lndcbean", " >>> Landing page Execution time applyBPM: " + executionTime2 + " ms");
            } // else part comment removed by vinothini for ilamathi's rof module
            else {
                if (thirdlevelvalidation != null && thirdlevelvalidation.equalsIgnoreCase("y")) {
                    isCompleteThirdLevel = true;

                }
            }
            
            // System.out.println("Hmrows=======" + Hmrows);
            logger.info("lndcbean","Third Level Validation in initializeLandingPage ??"
                    + landingPageDatasHm.get("thirdlevelvalidation"));

            List<String> thirdlevelRefnoList = new ArrayList();
            long startTime3 = System.currentTimeMillis();
            try {
                if (Hmrows != null && Hmrows.size() > 0) {
                    // System.out.println("Hmrows.size()====12==" + Hmrows.size());
                    Hmrows.stream().forEach(
                            bmlist1 -> {
                                final HashMap bmhm1 = new HashMap();
                                if (bmlist1.containsKey("bpmnotapplicable") || isCompleteThirdLevel) {
                                    bmhm1.put("Refno", bmlist1.get(refnofieldwithoutdot).toString());
                                    bmhmaddinglist.add(bmhm1);

                                }
                                vo.setReflist(bmhmaddinglist);
                            });
                }
                if (additionalreviewervalidation != null) {
                    String vdsname = (String) additionalreviewervalidation;
                    logger.info("lndcbean","additionalreviewervalidation service name====>" + vdsname);

                   
                    // System.out.println("bmhmaddinglist====" + bmhmaddinglist);
                    this.serviceInvoker.invokeMTPFunction(additionalreviewervalidation, "MAC",
                            new SvmJsonObject(svmJsonUtil.toString(vo)), tenantIdentifier);
                    String jsonString = this.serviceInvoker.getResult().toString();
                    // System.out.println("additionalreviewervalidation Result====>>>" + jsonString);
                    LNDPageThirdLevelValidation trdvo = (LNDPageThirdLevelValidation) this.svmJsonUtil
                            .toObject(jsonString, LNDPageThirdLevelValidation.class);
                    // LinkedTreeMap<String, String> refhm = new LinkedTreeMap<>();
                    // List<String> thirdlevelRefnoList = new ArrayList();
                    String refno = "";

                    int hmrowsSize = Hmrows.size();
                    logger.info("lndcbean","Hmrows.size()===hmrowsSize=" + hmrowsSize);
                    if (trdvo.getAccesslist() != null) {
                        int trdvoAccesslistSize = trdvo.getAccesslist().size();

                        // HashMap<String, Integer> thirdLevelValidAccessMap = new HashMap<>();
                        // for (int m = 0; m < trdvoAccesslistSize; m++) {
                        // refhm = (LinkedTreeMap<String, String>) trdvo.getAccesslist().get(m);
                        // if (refhm.get("Refno") != null
                        // && refhm.get("Access").equalsIgnoreCase("true")) {
                        // thirdLevelValidAccessMap.put(String.valueOf(refhm.get("Refno")).toLowerCase(),
                        // m);
                        // }
                        // }
                        Map<String, Integer> thirdLevelValidAccessMap = IntStream.range(0, trdvoAccesslistSize)
                                .mapToObj(m -> (LinkedTreeMap<String, String>) trdvo.getAccesslist().get(m))
                                .filter(refhm -> refhm.get("Refno") != null
                                        && "true".equalsIgnoreCase(refhm.get("Access")))
                                .collect(Collectors.toMap(
                                        refhm -> refhm.get("Refno").toLowerCase(),
                                        refhm -> trdvo.getAccesslist().indexOf(refhm)));

                        Hmrows.stream().forEach(rmapObj -> {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> rmap = (HashMap<String, Object>) rmapObj;
                            String valudationrefno = String.valueOf(rmap.get(refnofieldwithoutdot)).toLowerCase();

                            if (thirdLevelValidAccessMap.containsKey(valudationrefno)) {
                                rmap.put("thirdlevelbpmapplicablerows", true);
                                rmap.put("btnaddtionalrevvalidation", "false");
                                rmap.remove("bpmnotapplicable");
                                rmap.put("btnEditRenderInHm", "Yes");
                                thirdlevelRefnoList.add(valudationrefno);
                            } else if (!thirdlevelRefnoList.contains(valudationrefno)) {
                                rmap.put("thirdlevelbpmapplicablerows", false);
                                rmap.put("thirdlevelbpmnonapplicablerows", true);
                                rmap.put("btnEditRenderInHm", "No");
                            }
                        });

                    }

                }
               } catch (Exception e) {
                logger.fatal(e);
            }
            long endTime3 = System.currentTimeMillis();
            long executionTime3 = endTime3 - startTime3;
            logger.info("lndcbean", " >>> Landing page Execution time Additionalreviewer: " + executionTime3 + " ms");
            long startTime4 = System.currentTimeMillis();
            try {
                
                if (thirdlevelvalidation != null && thirdlevelvalidation.equalsIgnoreCase("y")) {
                    String thrdvdsvcname = (String) thirdlevelServiceName;
                    logger.info("lndcbean","thrdvdsvcname====>" + thrdvdsvcname);
                    // System.out.println("VO thirdlevel size" + vo.getReflist());
                    // // System.out.println("thiredlavel Result====>>>");
                    this.serviceInvoker.invokeFunction(thrdvdsvcname, "MAC",
                            new SvmJsonObject(svmJsonUtil.toString(vo)));
                    String jsonString = this.serviceInvoker.getResult().toString();
                    logger.info("lndcbean","thiredlavel Result====>>>" + jsonString);
                    LNDPageThirdLevelValidation trdvo = (LNDPageThirdLevelValidation) this.svmJsonUtil
                            .toObject(jsonString, LNDPageThirdLevelValidation.class);
                    // LinkedTreeMap<String, String> refhm = new LinkedTreeMap<String, String>();
                    // List<String> thirdlevelRefnoList = new ArrayList();
                    String refno = "";
                    logger.info("lndcbean","Hmrows.size()====" + Hmrows.size());

                    if (trdvo.getAccesslist() != null) {
                        HashMap<String, Integer> thirdLevelValidationAccessMap = new HashMap<>();
                        int acccesslistSize = trdvo.getAccesslist().size();
                        IntStream.range(0, acccesslistSize)
                                .mapToObj(m -> (LinkedTreeMap<String, String>) trdvo.getAccesslist().get(m))
                                .filter(refhm -> refhm != null && refhm.get("Refno") != null
                                        && "true".equalsIgnoreCase(refhm.get("Access")))
                                .forEach(refhm -> thirdLevelValidationAccessMap.put(refhm.get("Refno").toLowerCase(),
                                        trdvo.getAccesslist().indexOf(refhm)));
                        int hmrowsSize = Hmrows.size();

                        Hmrows.stream().forEach(rmapObj -> {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> rmap = (HashMap<String, Object>) rmapObj;
                            String lndrefno = String.valueOf(rmap.get(refnofieldwithoutdot)).toLowerCase();

                            if (thirdLevelValidationAccessMap.containsKey(lndrefno)) {
                                rmap.put("thirdlevelbpmapplicablerows", true);
                                rmap.put("btnaddtionalrevvalidation", "false");
                                rmap.put("btnEditRenderInHm", "Yes");
                                thirdlevelRefnoList.add(lndrefno);
                            } else if (!thirdlevelRefnoList.contains(lndrefno)) {
                                rmap.put("thirdlevelbpmapplicablerows", false);
                                rmap.put("thirdlevelbpmnonapplicablerows", true);
                                rmap.put("btnEditRenderInHm", "No");
                            }
                        });
                    }

                }
            } catch (Exception e) {
                logger.fatal(e);
            }
            long endTime4 = System.currentTimeMillis();
            long executionTime4 = endTime4 - startTime4;
            logger.info("lndcbean", " >>> Landing page Execution time thirdlevelvalidation: " + executionTime4 + " ms");
          
            // try {                           // inculde in process data method
            //     String refnum = "";
            //     if (delreqlist != null) {
            //         for (int rw = 0; rw < Hmrows.size(); rw++) {
            //             HashMap rmap = (HashMap) Hmrows.get(rw);
            //             refnum = rmap.get(refnofieldwithoutdot).toString();
            //             if (delreqlist.contains(refnum.toUpperCase())) {
            //                 rmap.put("delrequest", "true");
            //             }
            //         }
            //     }
            // } catch (Exception e) {
            //     logger.fatal(e);
            // }

            // logger.info("lndcbean","=====rowsrowsrows====>"+rows);
            // need to change
            // if (landingPageDatasHm.get("applyhandlybyuserlogic") != null &&
            // landingPageDatasHm.get("applyhandlybyuserlogic").toString().equalsIgnoreCase("y"))
            // {
                long startTime5 = System.currentTimeMillis();
            if (applyhandlybyuserlogic != null && applyhandlybyuserlogic.trim().equalsIgnoreCase("Y")) {
                if (widgetList != null && widgetList.size() > 0) {
                    for (int i = 0; i < widgetList.size(); i++) {
                        widgetMap.put(widgetList.get(i).trim(), 0);
                    }
                }
                List applylist = (List) statusntchkhllist;
                logger.info("lndcbean","<<<<==========Apply handler Logic Starts==>>>>> ");
                // List handlelist =
                // smbpmUtil.getRefnoHandledByUserOrGroup(mData.getMetaData(USERINFO.USERCODE));
              handlelist = new ArrayList();
                Systemconfig syscconvo = this.mackUtility.getSystemconfig("Landing Page - BPM Old Logic");
                Set<String> workFlowIdsForSP = new HashSet<String>();
                Set<String> statuslist = new HashSet<String>();
                workFlowIdsForSP.addAll(wrkflowIdList);
                if (PROJECTTYPE.equalsIgnoreCase("CNT001")) {
                    // System.out.println("controltypebasedstatusshorestatus====" +
                    // controltypebasedstatusshorestatus);
                    statuslist.addAll(controltypebasedstatusshorestatus);
                } else {
                    // System.out.println("controltypebasedstatusshipstatus====" +
                    // controltypebasedstatusshipstatus);
                    statuslist.addAll(controltypebasedstatusshipstatus);
                }
                logger.info("lndcbean","===statuslist===>" + statuslist);
                logger.info("lndcbean","===workFlowIdsForSP===>" + workFlowIdsForSP);
               
           
                String wrkflowSPdata = workFlowIdsForSP.stream()
                .map(String::trim)
                .collect(Collectors.joining(","));
                String statuslistdata = statuslist.stream()
                .map(String::trim)
                .collect(Collectors.joining(","));


                
    // workflow id itration is done for modulid and activestatus not in "V"
    
                if (syscconvo.getSysvalue() != null && syscconvo.getSysvalue().length() > 0) {
                    if (syscconvo.getSysvalue().equalsIgnoreCase("Yes")) {
                        // System.out.println("config=== yes");
                        handlelist = smbpmUtil.getRefnoHandledByUserOrGroup(mData.getMetaData(USERINFO.USERCODE));
                    } else {
                        // handlelist = smbpmUtil.getRefnoHandledByUser(workFlowIdsForSP,
                        // mData.getMetaData(USERINFO.USERCODE)); // It's a BPM new logic which has the
                        // SP execution. SP Name : usp_refnohandledbyuser
                        handlelist = getRefnoHandledByUser(workFlowIdsForSP, mData.getMetaData(USERINFO.USERCODE),
                             statuslist, model.getDataModel().getMdlId(),multitenency.getApplicationContextProperty()); // It's a BPM new logic which has the SP
                   
                    }
                } else {
                    // handlelist = smbpmUtil.getRefnoHandledByUser(workFlowIdsForSP,
                    // mData.getMetaData(USERINFO.USERCODE)); // It's a BPM new logic which has the
                    // SP execution. SP Name : usp_refnohandledbyuser
                    // handlelist = smbpmUtil.getRefnoHandledByUser(workFlowIdsForSP, mData.getMetaData(USERINFO.USERCODE),
                    //         statuslist, model.getDataModel().getMdlId()); // It's a BPM new logic which has the SP
                    //                                                       // execution. SP Name : usp_refnohandledbyuser

                    handlelist = getRefnoHandledByUser(workFlowIdsForSP, mData.getMetaData(USERINFO.USERCODE),
                    statuslist, model.getDataModel().getMdlId(),multitenency.getApplicationContextProperty());
                     //   handlelist = taskresult.getRs().getRs0()

                }

       
              List handleListFinal = new ArrayList();
                handleListFinal.addAll(handlelist);
                
                logger.info("lndcbean","<<<<==========Apply handler Logic ends==>>>> " + handleListFinal.size() + "============="
                        + handlelist);

                // logger.info("lndcbean","handleListFinal=====" + handleListFinal);
                List alllist = new ArrayList();
                List unhandledlist = new ArrayList();
                boolean isSm_editBtnRender = this.model.getDataModel().isSm_editBtnRender();
                logger.info("lndcbean","isSm_editBtnRender=====" + isSm_editBtnRender + "===refnofieldwithoutdot==="
                        + refnofieldwithoutdot);
                // logger.info("lndcbean","Hmrows====" + Hmrows);
                Hmrows.stream().forEach(
                        rowobj -> {
                            boolean canAdd = false;
                            final HashMap row = (HashMap) rowobj;
                            String refno = row.get(refnofieldwithoutdot).toString();
                            // NFR-3304 Non BPM Revoke Recall
                            // String nonBpmRevokeRecallRender = nonbpmIdentifier(rowobj);
                            // if (nonBpmRevokeRecallRender != null &&
                            // nonBpmRevokeRecallRender.equalsIgnoreCase("revoke")) {
                            // rowobj.put("nonbpmrevoke", true);
                            // } else if (nonBpmRevokeRecallRender != null &&
                            // nonBpmRevokeRecallRender.equalsIgnoreCase("recall")) {
                            // rowobj.put("nonbpmrecall", true);
                            // }
                            if (handleListFinal.contains(refno)) {
                                canAdd = true;
                            } else {
                                if ((row.containsKey("bpmapplicable") && isSm_editBtnRender)
                                        || (row.containsKey("thirdlevelbpmapplicablerows")
                                                && (boolean) row.get("thirdlevelbpmapplicablerows") && !this.editable)
                                        || (row.containsKey("statustoshowallusersrows"))) {

                                    // (row.containsKey("thirdlevelbpmnonapplicablerows")) || //removed this
                                    // condition by including validation in usp_refnohandledbyuser SP to check and
                                    // get the user involved records
                                    // if (!alllist.contains(row)) {
                                    canAdd = true;
                                    // alllist.add(row);
                                    // }
                                }
                            }
                            if (canAdd) {
                                alllist.add(row);
                            } else {
                                if (checkInprogress.trim().equalsIgnoreCase("Yes")) {
                                    if (row.get(statusdescwithoutdot) != null
                                            && !row.get(statusdescwithoutdot).toString().equalsIgnoreCase("Deleted")
                                            && !row.get(statusdescwithoutdot).toString()
                                                    .equalsIgnoreCase("Inprogress")) {
                                        unhandledlist.add(row);
                                    }
                                } else if (row.get(statusdescwithoutdot) != null
                                        && !row.get(statusdescwithoutdot).toString().equalsIgnoreCase("Deleted")) {
                                    unhandledlist.add(row);
                                }
                            }
                        });
                logger.info("lndcbean","<<<=============Apply handler logic process ends here============>>>>");
                logger.info("lndcbean","alllist=====" + alllist.size());
                List<Map<String, Object>> FinalList = checkEditable_new(alllist);
                logger.info("lndcbean","<<<=============Check ediatble  ends here============>>>>");
                makeWidgetCountMap(FinalList);
                model.getDataModel().setDynamicEntityMap(FinalList);
                model.getDataModel().setUnhandleddynamicEntityMap(unhandledlist);
            } else {
                if (widgetList != null && widgetList.size() > 0) {
                    for (int i = 0; i < widgetList.size(); i++) {
                        widgetMap.put(widgetList.get(i).trim(), 0);
                    }
                }
                Hmrows.stream().forEach(
                        rowobj -> {
                            // NFR-3304 Non BPM Revoke Recall
                            // String nonBpmRevokeRecallRender = nonbpmIdentifier(rowobj);
                            // if (nonBpmRevokeRecallRender != null &&
                            // nonBpmRevokeRecallRender.equalsIgnoreCase("revoke")) {
                            // rowobj.put("nonbpmrevoke", true);
                            // } else if (nonBpmRevokeRecallRender != null &&
                            // nonBpmRevokeRecallRender.equalsIgnoreCase("recall")) {
                            // rowobj.put("nonbpmrecall", true);
                            // }
                        });
                List<Map<String, Object>> FinalList = checkEditable_new(Hmrows);
                makeWidgetCountMap(FinalList);
                model.getDataModel().setDynamicEntityMap(FinalList);
            }
            makeWidgets();
            long endTime5 = System.currentTimeMillis();
            long executionTime5 = endTime5 - startTime5;
            logger.info("lndcbean", " >>> Landing page Execution time Other Logic: " + executionTime5 + " ms");
          
            model.getDataModel().setTotalRows(Hmrows.size());
            logger.info("lndcbean","<<<=============Last line of loading============>>>>");
            
        } catch (Exception e) {
            logger.info("lndcbean","//==//==|exception in loadLandingPage|==>" + e.getMessage());
            logger.fatal(e);
        }
    }

     public List<String> getRefnoHandledByUser(Set<String> wfidList, String usercode, Set<String> statusdesclist, String mdlid, String tenantIdentifier) throws Exception {
    // debug("inside getRefnoHandledByUserOrGroup new ::" + usercode + " " + wfidList + " " + statusdesclist + " " + mdlid);
    long stime = System.currentTimeMillis();
    String wfidStr = String.join(",", (Iterable)wfidList);
    String statusdescstr = String.join(",", (Iterable)statusdesclist);
    Connection con = null;
    CallableStatement cs = null;
    List<String> refnoList = new ArrayList<>();
    try {
      con = getConnection("BPMNDS" + tenantIdentifier);
      cs = con.prepareCall("call usp_refnohandledbyuser(?,?,?,?)");
      cs.setString(1, usercode);
      cs.setString(2, wfidStr);
      cs.setString(3, statusdescstr);
      cs.setString(4, mdlid);
      ResultSet rs = cs.executeQuery();
      while (rs.next())
        refnoList.add(rs.getString(1)); 
    } catch (Exception exception) {
    
    } finally {
      
        try {
           con.close();
        } catch (SQLException ex) {
            logger.info("lndcbean","//==//==|exception in loadLandingPage|==>" + ex.getMessage());
        }  
    } 
    
    return refnoList;
  }

  private Connection getConnection(String ds) throws SQLException {
    if (notnull(ds)){
      try {
        // debug(ds + " >> InitialContext().lookup >>> " + (new InitialContext()).lookup("java:/" + ds));
        DataSource datasource = (DataSource)(new InitialContext()).lookup("java:/" + ds);
        return datasource.getConnection();
      } catch (NamingException ex) {
        logger.info("lndcbean","//==//==|exception in loadLandingPage|==>" + ex.getMessage());
        return null;
      }  
    }
    return null;
  }

  private boolean notnull(String str) {
    return (str != null && str.length() > 0);
  }

    private void applyBPMRights() throws Exception {
        logger.info("lndcbean","//==//==|INSIDE applyBPMRights|==>");
       
        try {
            int statusindex;
            HashMap applicableGroupMap = new HashMap();
            HashMap userWiseGroupsMap = new HashMap();
            HashMap revokeMap = new HashMap();
            HashMap refnowfidMap = new HashMap();
            HashMap GroupCodeMap = new HashMap();
            List ClaimedRefList = new ArrayList();
            
            HashMap<String,String> bpmWFIDMap = new HashMap();
            bpmReflist = new ArrayList();
            statusindex = columnHeaderLst.size();
            userWiseGroupsMapResultList = new ArrayList();
            // CompleteModel wrkFlowIdCreate = service.getworkflowmappingid(model.getDataModel().getMdlId(),
            //         PROJECTTYPE.trim(), PROJECTTYPE.trim(), "A");
            // if (!wrkFlowIdCreate.getWorkflowmapping().isEmpty()) {
            //     formCreationWFID = wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid().trim();
            //     formCreationbpmWFID = wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid().trim();

            // }
        
            // CompleteModel wrkFlowId = service.getworkflowmappingid(model.getDataModel().getMdlId(), PROJECTTYPE.trim(),
            // "V");
   
   
    List<String> notificationhistoryrefList = new ArrayList<>();
    List<String> chatrefList = new ArrayList<>();
    wrkflowIdList = new ArrayList();
    // for (int i = 0; i < wrkFlowId.getWorkflowmapping().size(); i++) {
    logger.info("lndcbean","<<<=============Pending task BPM loop Start============>>>>");
    // String wrkflowdata = wrkFlowId.getWorkflowmapping().stream()
    // .map(mapping -> mapping.getWorkflowid().trim())
    // .collect(Collectors.joining(","));
      
    // wrkFlowId.getWorkflowmapping().stream().forEach(wfid -> {
       
    //         bpmWFIDMap.put(wfid.getWorkflowid().trim(), wfid.getBpmwrkflowid().trim());
    //     }
    // );

    
    // for (int i = 0; i < Hmrows.size(); i++) {
    //     HashMap hm = (HashMap) Hmrows.get(i);
    //     if (hm.containsKey(refnofieldwithoutdot)) { //for internal audit scheduler,
    //         Refidhdata.add(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim());
    //         System.out.println("refnofieldwithoutdot"+hm.get(refnofieldwithoutdot).toString());
    //     }
    // }

  
    HashMap<String,List<Bpmusergroupmapping_vessel>> userWiseGroupsMapResult = new HashMap();
    
    HashMap applicableGroupMapResult = new HashMap();
    SvmJsonList paramSvmJsonList = new SvmJsonList();
    //System.out.println("wrkflowdata" + wrkflowdata);
   // System.out.println("mData.getMetaData(USERINFO.USERCODE)" + mData.getMetaData(USERINFO.USERCODE));
    

     paramSvmJsonList.add(model.getDataModel().getMdlId());
     paramSvmJsonList.add(mData.getMetaData(USERINFO.USERCODE));
     paramSvmJsonList.add(PROJECTTYPE.trim());
    // workflow id itration is done for modulid and activestatus not in "V"
    CompleteModel taskresult = service.getlandingpagetaskdeatils(paramSvmJsonList);
    
    if (taskresult.getRs().getRs5() != null && taskresult.getRs().getRs5().size() > 0) {
        taskresult.getRs().getRs5().forEach(wfidobj -> {
            // System.out.println("wfidobj.getActive_status()"+wfidobj.getActive_status()+">>>"+wfidobj.getWorkflowid().trim());
       if(wfidobj.getFromcnttypecode()!=null && wfidobj.getFromcnttypecode().trim().equalsIgnoreCase(PROJECTTYPE.trim())
       && wfidobj.getActive_status()!=null && wfidobj.getActive_status().trim().equalsIgnoreCase("A")){
        formCreationWFID = wfidobj.getWorkflowid().trim();
        formCreationbpmWFID = wfidobj.getBpmwrkflowid().trim();
       }
       if(wfidobj.getActive_status()!=null && !wfidobj.getActive_status().trim().equalsIgnoreCase("V")){
        bpmWFIDMap.put(wfidobj.getWorkflowid().trim(), wfidobj.getBpmwrkflowid().trim());  
        // System.out.println("wfidobjmap"+wfidobj.getWorkflowid().trim()+">>"+ wfidobj.getBpmwrkflowid().trim()); 
       }
     });
    }

    if (taskresult.getRs().getRs1() != null && taskresult.getRs().getRs1().size() > 0) {
        // taskresult.getRs().getRs1().stream().forEach(task -> {
        //     userWiseGroupsMapResult.put(task.getVslcompcode(),task);
        // });
        userWiseGroupsMapResultList= getBpmusergroupmappingMap_vesselList(taskresult.getRs().getRs1());
    }
   
    
    Bpmusergroupmapping_vesselR3 = new ArrayList();
    if (taskresult.getRs().getRs3() != null && taskresult.getRs().getRs3().size() > 0) {
       Bpmusergroupmapping_vesselR3= getBpmusergroupmappingMap_vesselList1(taskresult.getRs().getRs3());
    }
    
  
          
    if (taskresult.getRs().getRs0() != null && taskresult.getRs().getRs0().size() > 0) {
        taskresult.getRs().getRs0().forEach(taskvo -> {
           if(Refidhdata.contains(taskvo.getRefno().toLowerCase().trim())){
            TaskSummaryVo taskdata = getTaskSummaryMapper(taskvo);

            WFID = taskvo.getWfid().trim();
            wrkflowIdList.add(WFID);
            bpmWFID = bpmWFIDMap.get(WFID); 
            logger.info("lndcbean",
                "WFID IN LANDING PAGE applyBPMRights &&&&&&&&&&&&&&&&& " + WFID + "?? bpmWFID ??" + bpmWFID);
                try {

                                String curGrpcode = null;
                                String Grpcode = null;
                                List<String> usergrouplist = null;
                                try {
                                        refnotaskMap.put(taskvo.getRefno(), taskvo);   // used  in  btnrefsearchActionListener
                                        refnoBPMMap.put(taskvo.getRefno(), WFID + "~" + bpmWFID); 
                                        
                                        refnoList.add(taskdata); // used in view pending ref dlg
                                        boolean checkEditaccess = true;
                                        
                                        if (taskvo.getFlag() != null && taskvo.getFlag().equalsIgnoreCase("A")) {
                                            AdditionalrevAddedList.add(taskvo.getRefno().toLowerCase());  // additional review button is enable for this referance need to check top additional reviewr
                                            checkEditaccess = false;
                                        }
                                        if (taskvo.getFlag() != null && taskvo.getFlag().equalsIgnoreCase("L")) {
                                            recallList.add(taskvo.getRefno().toLowerCase()); // recall button is enabled
                                            recallMap.put(taskvo.getRefno().toLowerCase(), taskvo); // after clicking recall button this map is used
                                            recallMap.put("bpmdetails" + taskvo.getRefno().toLowerCase(), WFID + "~" + bpmWFID); // after clicking recall button this map is used
                                            checkEditaccess = false;
                                        }
                                        if (checkEditaccess) {
                                     if (!GroupCodeMap.containsKey(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode())) {
                                        if (!userWiseGroupsMap.containsKey(  // this condition will always be true
                                        mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode())) {
                                        if (userWiseGroupsMapResultList != null && userWiseGroupsMapResultList.size() > 0) {
                                           
                                           
                                        userWiseGroupsMap.put(
                                            mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode(),
                                            getBPMUsersGroupcode(userWiseGroupsMapResultList,taskvo.getCode()));   // vds runs in this method
                                        }
                                    }
                                
                                    
                                        if (!applicableGroupMap.containsKey(taskvo.getNodeid().trim() + "~" + WFID)) {   //used for same id should come
                                        usergrouplist = new ArrayList();
                                        if (taskresult.getRs().getRs2() != null && taskresult.getRs().getRs2().size() > 0) {
                                            usergrouplist = taskresult.getRs().getRs2().stream()
                                            .filter(taskobj -> taskobj.getWfid().equalsIgnoreCase(taskvo.getWfid()) &&
                                            taskobj.getInstanceid().equalsIgnoreCase(taskvo.getInstanceid()) &&
                                            taskobj.getNodeid().equalsIgnoreCase(taskvo.getNodeid()))
                                            .map(Rs2::getUsergroup)
                                            .collect(Collectors.toList());

                                        }
                                        applicableGroupMap.put(taskvo.getNodeid().trim() + "~" + WFID, usergrouplist);
                                        }
                                    
                                        List<Bpmusergroupmapping_vessel> bpmusrgrplist = (List<Bpmusergroupmapping_vessel>) userWiseGroupsMap
                                        .get(mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode());
                                        List<String> usergrouplistnew = (List) applicableGroupMap
                                                .get(taskvo.getNodeid().trim() + "~" + WFID);
                                        if (usergrouplistnew != null && usergrouplistnew.size() > 0) {
                                            revokeMap.put(taskvo.getRefno(), usergrouplistnew); // not used any where
                                        }
                                        Usergroupvo usergroupvo = (Usergroupvo) getBPMCurrentGroupcode(usergrouplistnew, bpmusrgrplist,Bpmusergroupmapping_vesselR3,taskresult.getRs().getRs4());     // used Mbutil has many vds
                                        Grpcode = usergroupvo.getGroupcode();
                                        logger.info("lndcbean","isIsbackup isIsbackup " + usergroupvo.isIsbackup());
                                        logger.info("lndcbean","getBackupfor getBackupfor " + usergroupvo.getBackupfor());
                                        logger.info("lndcbean",
                                                "getBackupforgroup getBackupforgroup " + usergroupvo.getBackupforgroup());

                                        groupMap.put(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode(),          //only used in this method
                                                usergroupvo);
                                        // logger.info("lndcbean","Grpcode====" + Grpcode);
                                        // if (Grpcode != null && Grpcode.trim().length() > 0) {
                                        GroupCodeMap.put(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode(),  //used same map with differnt key
                                                Grpcode);
                                        }

                                        List<String> grouplist = (List) applicableGroupMap    // list of getbpmprocessinstancegroupnodeid list size is 1
                                                .get(taskvo.getNodeid().trim() + "~" + WFID);
                                        curGrpcode = (String) GroupCodeMap
                                                .get(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode()); // current grp code if again same id then in will go inside top if condition
                                        // logger.info("lndcbean","applicableGroupMap=====" + applicableGroupMap);
                                        // logger.info("lndcbean","GroupCodeMap=====" + GroupCodeMap);
                                        logger.info("lndcbean","grouplist================" + grouplist);
                                        logger.info("lndcbean","curGrpcode===============" + curGrpcode);
                                        String strgrpList = "";
                                        if (grouplist != null) {
                                            strgrpList = grouplist.toString().toLowerCase();
                                        }

                                        // logger.info("lndcbean","BPM returened refno== editable====" +
                                        // taskvo.getRefno().trim().toLowerCase());

                                        // comparing applicableGroupMap & Group List
                                        boolean proceed = false;
                                        if (curGrpcode != null && curGrpcode.trim().length() > 0
                                                && strgrpList.contains("dyn_grp")) {
                                            proceed = true;

                                        } else if (curGrpcode != null && curGrpcode.trim().length() > 0 && grouplist != null) {
                                            for (int ii = 0; ii < grouplist.size(); ii++) { //list size will be 1
                                                String groupcode1 = grouplist.get(ii);
                                                if (groupcode1 != null && groupcode1.trim().length() > 0
                                                        && groupcode1.trim().equalsIgnoreCase(curGrpcode)) {
                                                    proceed = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (proceed) {
                                            logger.info("lndcbean","BPM returened refno== and groupcode also matched===="
                                                    + taskvo.getRefno().trim().toLowerCase() + taskvo.getIsclaimed()
                                                    + "==taskvo.getClaimuser()==" + taskvo.getClaimuser()
                                                    + "==mData.getMetaData(USERINFO.USERCODE).trim()=="
                                                    + mData.getMetaData(USERINFO.USERCODE).trim());

                                            // if the task is claimed but not claimed by the login user,those applicable for
                                            // orange color edit button (claimed status indicator)
                                            if (taskvo.getIsclaimed() != null
                                                    && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")
                                                    && taskvo.getClaimuser() != null
                                                    && !mData.getMetaData(USERINFO.USERCODE).trim()
                                                            .equalsIgnoreCase(taskvo.getClaimuser().trim())) {
                                                revokableReflist.add(taskvo.getRefno().trim().toLowerCase());
                                                revokableRefMap.put(taskvo.getRefno().trim().toLowerCase(), taskdata);
                                            } else {
                                                if (!revokableReflist.contains(taskvo.getRefno().trim().toLowerCase())) {
                                                    bpmReflist.add(taskvo.getRefno().trim().toLowerCase());
                                                    refnowfidMap.put(taskvo.getRefno().trim().toLowerCase(),
                                                            WFID + "~" + bpmWFID);
                                                    // bpmExtraReflist.add(taskvo.getRefno().trim().toLowerCase() + "-" +
                                                    // model.getDataModel().getMdlId().toLowerCase());
                                                    refnoTaskSummaryMap.put(taskvo.getRefno().trim().toLowerCase(), taskdata);
                                                    // if the task is claimed by the login user and the task contains more than
                                                    // one group,those records are applicable for revoke
                                                    // if (grouplist != null && grouplist.size() > 1 && taskvo.getIsclaimed() !=
                                                    // null && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")) {
                                                    // ClaimedRefList.add(taskvo.getRefno().trim().toLowerCase());
                                                    // }
                                                    // below line commented and above line comment reverted to fix re-assign
                                                    // ccase revoke enable issue //SVMINTBUG-46715
                                                    // commented again above line bcos this will not work for the handover
                                                    // scenario
                                                    if (taskvo.getIsclaimed() != null
                                                            && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")) {
                                                        ClaimedRefList.add(taskvo.getRefno().trim().toLowerCase());
                                                    }
                                                        }
                                                    }
                                                }
                                            }


                                } catch (Exception ex) {
                                    logger.fatal(ex);
                                    Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, ex);
                                }

                } catch (Exception e) {
                    logger.info("lndcbean","//==//==|ERROR IN APPLY BPM first catch|==>" + e.getMessage());
                    logger.fatal(e);
                }
            
             }
        });
     }
     
    
    
 

            // workflow id itration is done for modulid and activestatus not in "V"
            // wrkFlowId.getWorkflowmapping().stream().forEach(wfid -> {
            //     if (!wfid.getActive_status().equalsIgnoreCase("A")) {
            //             formCreationWFID = wfid.getWorkflowid().trim();
            //             formCreationbpmWFID = wfid.getBpmwrkflowid().trim();
            //             logger.info("lndcbean","formCreationWFID in applyBPMRights ?????? " + formCreationWFID);
        
            //         }
            //     // logger.info("lndcbean","wfid IN STREEEEEMMMMMMMMMM " + wfid.getWorkflowid());
            //     WFID = wfid.getWorkflowid().trim();
            //     wrkflowIdList.add(WFID);
            //     bpmWFID = wfid.getBpmwrkflowid().trim();
            //     logger.info("lndcbean",
            //             "WFID IN LANDING PAGE applyBPMRights &&&&&&&&&&&&&&&&& " + WFID + "?? bpmWFID ??" + bpmWFID);

            //     try {

            //         logger.info("lndcbean","<<<=============getchatbyuserandmodule============>>>>");
            //         List<TaskSummaryVo> taskvolist = smbpmUtil.getPendingTaskByUserNGroup(WFID,
            //                 mData.getMetaData(USERINFO.USERCODE));
            //         logger.info("lndcbean","taskvolist size in applyBPMRights===>" + taskvolist.size());

            //         taskvolist.stream().forEach(taskvo -> {
            //             String curGrpcode = null;
            //             String Grpcode = null;
            //             List<String> usergrouplist = null;
            //             try {
            //                 // logger.info("lndcbean","BPM RefNo=====" + taskvo.getRefno());

            //                 refnotaskMap.put(taskvo.getRefno(), taskvo);   // used  in  btnrefsearchActionListener
            //                 refnoBPMMap.put(taskvo.getRefno(), WFID + "~" + bpmWFID); 
            //                 refnoList.add(taskvo); // used in view pending ref dlg
            //                 boolean checkEditaccess = true;

            //                 if (taskvo.getFlag() != null && taskvo.getFlag().equalsIgnoreCase("A")) {
            //                     AdditionalrevAddedList.add(taskvo.getRefno().toLowerCase());  // additional review button is enable for this referance need to check top additional reviewr
            //                     checkEditaccess = false;
            //                 }
            //                 if (taskvo.getFlag() != null && taskvo.getFlag().equalsIgnoreCase("L")) {
            //                     recallList.add(taskvo.getRefno().toLowerCase()); // recall button is enabled
            //                     recallMap.put(taskvo.getRefno().toLowerCase(), taskvo); //after clicking recall button this map is used
            //                     recallMap.put("bpmdetails" + taskvo.getRefno().toLowerCase(), WFID + "~" + bpmWFID); //after clicking recall button this map is used
            //                     checkEditaccess = false;
            //                 }
            //                 if (checkEditaccess) {

            //                     if (!GroupCodeMap
            //                             .containsKey(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode())) {   //used for same id should come
            //                         if (!userWiseGroupsMap.containsKey(  // this condition will always be true
            //                                 mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode())) {
            //                             userWiseGroupsMap.put(
            //                                     mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode(),
            //                                     getUsersGroupcode(taskvo.getCode()));   // vds runs in this method
            //                         }
            //                         if (!applicableGroupMap.containsKey(taskvo.getNodeid().trim() + "~" + WFID)) {   //used for same id should come
            //                             usergrouplist = new ArrayList();
            //                             VDSMackBpmUtil modelProcessintncegrpnodeid = service              // vds runs in this
            //                                     .getbpmprocessinstancegroupnodeid(taskvo.getWfid(),
            //                                             taskvo.getInstanceid(), taskvo.getNodeid());
            //                                             modelProcessintncegrpnodeid.getProcessinstancegroup().stream()
            //                                             .map(group -> group.getUsergroup())
            //                                             .forEach(usergrouplist::add);

            //                             applicableGroupMap.put(taskvo.getNodeid().trim() + "~" + WFID, usergrouplist);
            //                         }
            //                         List<Bpmusergroupmapping_vessel> bpmusrgrplist = (List<Bpmusergroupmapping_vessel>) userWiseGroupsMap
            //                                 .get(mData.getMetaData(USERINFO.USERCODE) + "~" + taskvo.getCode());
            //                         List<String> usergrouplistnew = (List) applicableGroupMap
            //                                 .get(taskvo.getNodeid().trim() + "~" + WFID);
            //                         if (usergrouplistnew != null && usergrouplistnew.size() > 0) {
            //                             revokeMap.put(taskvo.getRefno(), usergrouplistnew); // not used any where
            //                         }
            //                         Usergroupvo usergroupvo = (Usergroupvo) getCurrentGroupcode(taskvo, WFID,  
            //                                 usergrouplistnew, bpmusrgrplist);     // used Mbutil has many vds
            //                         Grpcode = usergroupvo.getGroupcode();
            //                         logger.info("lndcbean","isIsbackup isIsbackup " + usergroupvo.isIsbackup());
            //                         logger.info("lndcbean","getBackupfor getBackupfor " + usergroupvo.getBackupfor());
            //                         logger.info("lndcbean",
            //                                 "getBackupforgroup getBackupforgroup " + usergroupvo.getBackupforgroup());

            //                         groupMap.put(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode(),          //only used in this method
            //                                 usergroupvo);
            //                         // logger.info("lndcbean","Grpcode====" + Grpcode);
            //                         // if (Grpcode != null && Grpcode.trim().length() > 0) {
            //                         GroupCodeMap.put(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode(),  //used same map with differnt key
            //                                 Grpcode);
            //                     }

            //                     List<String> grouplist = (List) applicableGroupMap    // list of getbpmprocessinstancegroupnodeid list size is 1
            //                             .get(taskvo.getNodeid().trim() + "~" + WFID);
            //                     curGrpcode = (String) GroupCodeMap
            //                             .get(taskvo.getNodeid().trim() + "~" + WFID + "~" + taskvo.getCode()); // current grp code if again same id then in will go inside top if condition
            //                     // logger.info("lndcbean","applicableGroupMap=====" + applicableGroupMap);
            //                     // logger.info("lndcbean","GroupCodeMap=====" + GroupCodeMap);
            //                     logger.info("lndcbean","grouplist================" + grouplist);
            //                     logger.info("lndcbean","curGrpcode===============" + curGrpcode);
            //                     String strgrpList = "";
            //                     if (grouplist != null) {
            //                         strgrpList = grouplist.toString().toLowerCase();
            //                     }

            //                     // logger.info("lndcbean","BPM returened refno== editable====" +
            //                     // taskvo.getRefno().trim().toLowerCase());

            //                     // comparing applicableGroupMap & Group List
            //                     boolean proceed = false;
            //                     if (curGrpcode != null && curGrpcode.trim().length() > 0
            //                             && strgrpList.contains("dyn_grp")) {
            //                         proceed = true;

            //                     } else if (curGrpcode != null && curGrpcode.trim().length() > 0 && grouplist != null) {
            //                         for (int ii = 0; ii < grouplist.size(); ii++) { //list size will be 1
            //                             String groupcode1 = grouplist.get(ii);
            //                             if (groupcode1 != null && groupcode1.trim().length() > 0
            //                                     && groupcode1.trim().equalsIgnoreCase(curGrpcode)) {
            //                                 proceed = true;
            //                                 break;
            //                             }
            //                         }
            //                     }

            //                     if (proceed) {
            //                         logger.info("lndcbean","BPM returened refno== and groupcode also matched===="
            //                                 + taskvo.getRefno().trim().toLowerCase() + taskvo.getIsclaimed()
            //                                 + "==taskvo.getClaimuser()==" + taskvo.getClaimuser()
            //                                 + "==mData.getMetaData(USERINFO.USERCODE).trim()=="
            //                                 + mData.getMetaData(USERINFO.USERCODE).trim());

            //                         // if the task is claimed but not claimed by the login user,those applicable for
            //                         // orange color edit button (claimed status indicator)
            //                         if (taskvo.getIsclaimed() != null
            //                                 && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")
            //                                 && taskvo.getClaimuser() != null
            //                                 && !mData.getMetaData(USERINFO.USERCODE).trim()
            //                                         .equalsIgnoreCase(taskvo.getClaimuser().trim())) {
            //                             revokableReflist.add(taskvo.getRefno().trim().toLowerCase());
            //                             revokableRefMap.put(taskvo.getRefno().trim().toLowerCase(), taskvo);
            //                         } else {
            //                             if (!revokableReflist.contains(taskvo.getRefno().trim().toLowerCase())) {
            //                                 bpmReflist.add(taskvo.getRefno().trim().toLowerCase());
            //                                 refnowfidMap.put(taskvo.getRefno().trim().toLowerCase(),
            //                                         WFID + "~" + bpmWFID);
            //                                 // bpmExtraReflist.add(taskvo.getRefno().trim().toLowerCase() + "-" +
            //                                 // model.getDataModel().getMdlId().toLowerCase());
            //                                 refnoTaskSummaryMap.put(taskvo.getRefno().trim().toLowerCase(), taskvo);
            //                                 // if the task is claimed by the login user and the task contains more than
            //                                 // one group,those records are applicable for revoke
            //                                 // if (grouplist != null && grouplist.size() > 1 && taskvo.getIsclaimed() !=
            //                                 // null && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")) {
            //                                 // ClaimedRefList.add(taskvo.getRefno().trim().toLowerCase());
            //                                 // }
            //                                 // below line commented and above line comment reverted to fix re-assign
            //                                 // ccase revoke enable issue //SVMINTBUG-46715
            //                                 // commented again above line bcos this will not work for the handover
            //                                 // scenario
            //                                 if (taskvo.getIsclaimed() != null
            //                                         && taskvo.getIsclaimed().trim().equalsIgnoreCase("Y")) {
            //                                     ClaimedRefList.add(taskvo.getRefno().trim().toLowerCase());
            //                                 }
            //                             }
            //                         }
            //                     }
            //                 }

            //             } catch (Exception ex) {
            //                 logger.fatal(ex);
            //                 Logger.getLogger(LandingPageCtrl.class.getName()).log(Level.SEVERE, null, ex);
            //             }
            //         });

            //         // && (col.get(backuptypeIndex)==null ||
            //         // !col.get(backuptypeIndex).toString().equalsIgnoreCase("O"))) ;-- these
            //         // conditions are added below to disable the edit for other vessel
            //     } catch (Exception e) {
            //         logger.info("lndcbean","//==//==|ERROR IN APPLY BPM first catch|==>" + e.getMessage());
            //         logger.fatal(e);
            //     }
            // });

            logger.info("lndcbean","<<<=============Pending task BPM loop End============>>>>");

            logger.info("lndcbean","<<<=============Processing Pending task with total records Starts============>>>>");
            List<List> tmpbpmAppicableRows;
                       logger.info("lndcbean","refnofieldwithoutdot======" + refnofieldwithoutdot);
            if (widgetList != null && widgetList.size() > 0) {
                CompleteModel notificationModel = service.getnotificationbyuserandmodule(
                        mData.getMetaData(USERINFO.USERCODE), model.getDataModel().getMdlId());

                // if (!notificationModel.getNotificationhistory().isEmpty()) {
                // for (int i = 0; i < notificationModel.getNotificationhistory().size(); i++) {
                // notificationhistoryrefList
                // .add(notificationModel.getNotificationhistory().get(i).getRefno().trim().toLowerCase());

                // }
                // }
                if (!notificationModel.getNotificationhistory().isEmpty()) {
                    notificationModel.getNotificationhistory().stream()
                            .map(notification -> notification.getRefno().trim().toLowerCase())
                            .forEach(notificationhistoryrefList::add);
                }
                // logger.info("lndcbean","<<<=============getnotificationbyuserandmodule============>>>>"
                // + notificationhistoryrefList);
                CompleteModel chatModel = service.getchatbyuserandmodule(mData.getMetaData(USERINFO.USERCODE),
                        model.getDataModel().getMdlId());

                if (!chatModel.getCommunicationwindowchat().isEmpty()) {
                    chatModel.getCommunicationwindowchat().stream()
                            .map(chat -> chat.getFormserialid().trim().toLowerCase())
                            .forEach(chatrefList::add);
                }
                // logger.info("lndcbean","<<<=============chatrefList============>>>>" + chatrefList);
            }
            String bpmdetails = "";
            // logger.info("lndcbean","refnowfidMap====" + refnowfidMap);
            if (Hmrows != null) {
                logger.info("lndcbean","Hmrows.size()===applybpmrights====" + Hmrows.size());
                for (int i = 0; i < Hmrows.size(); i++) {
                    HashMap hm = (HashMap) Hmrows.get(i);

                    if (hm.containsKey(refnofieldwithoutdot)) { // for internal audit scheduler,
                        if (bpmReflist.contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {

                            hm.put("bpmapplicable", true);
                            hm.put("btnEditRenderInHm", "Yes");
                            bpmdetails = (String) refnowfidMap
                                    .get(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim());
                            hm.put("bpmdetails", bpmdetails);
                            hm.put("tasksummaryvo", refnoTaskSummaryMap
                                    .get(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim()));
                        } else {
                            hm.put("bpmnotapplicable", true);
                            hm.put("btnEditRenderInHm", "No");
                        }

                        if (notificationhistoryrefList
                                .contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {
                            hm.put("notificationapplicable", "Yes");
                        } else {
                            hm.put("notificationapplicable", "No");
                        }

                        if (chatrefList.contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {
                            hm.put("chatapplicable", "Yes");
                        } else {
                            hm.put("chatapplicable", "No");
                        }

                        if (!hm.get("strStatusDescValue").toString().toLowerCase().trim().contains("inprogress")) {
                            if (ClaimedRefList.contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {
                                hm.put("btnRevokeBtn", "true");
                            } else {
                                hm.put("btnRevokeBtn", "false");
                            }
                            if (revokableReflist
                                    .contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {
                                hm.put("btnRevokeOrangeBtn", "true");
                            } else {
                                hm.put("btnRevokeOrangeBtn", "false");
                            }
                        }
                        if (AdditionalrevAddedList
                                .contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {
                            hm.put("btnaddtionalrevvalidation", "true");

                        } else {
                            hm.put("btnaddtionalrevvalidation", "false");
                        }
                        if (recallList.contains(hm.get(refnofieldwithoutdot).toString().toLowerCase().trim())) {

                            hm.put("recallbtn", "true");
                        } else {
                            hm.put("recallbtn", "false");
                        }
                    }
                }
            }
           
            logger.info("lndcbean","<<<=============Processing Pending task with total records Ends============>>>>");
           
        } catch (Exception e) {
            logger.info("lndcbean","//==//==|ERROR IN APPLY BPM METHODDDDDD|==>" + e.getMessage());
            logger.fatal(e);
        }
    }

     private List<Bpmgroupcodelevel> GetgroupcodeListforEditAction1(List<String> applicablegrouplist, List<Bpmusergroupmapping_vessel> bpmusergrplist) {
    this.logger.info("lndcbean","GetgroupcodeListforEditAction<>");
    String grpcode = "", usercode = "";
    List<Bpmgroupcodelevel> bpmgroupcodelevelList = new ArrayList<>();
    String bpmusergroupmappinggroupcode = "", processinstancegroupcode = "";
    try {
        if (applicablegrouplist!=null && applicablegrouplist.size() > 0 && bpmusergrplist!=null && bpmusergrplist.size() > 0) {
      for (int i = 0; i < applicablegrouplist.size(); i++) {
        for (int j = 0; j < bpmusergrplist.size(); j++) {
          bpmusergroupmappinggroupcode = ((Bpmusergroupmapping_vessel)bpmusergrplist.get(j)).getGroupcode();
          processinstancegroupcode = applicablegrouplist.get(i);
          if (bpmusergroupmappinggroupcode != null && processinstancegroupcode != null && bpmusergroupmappinggroupcode
            .trim().equalsIgnoreCase(processinstancegroupcode.trim())) {
            if(bpmusergrplist.get(j).getGroupcode()!=null && bpmusergrplist.get(j).getUsercode()!=null) {
            Bpmgroupcodelevel ObjGrpCodeLevel = new Bpmgroupcodelevel();
            grpcode = ((Bpmusergroupmapping_vessel)bpmusergrplist.get(j)).getGroupcode();
            usercode = ((Bpmusergroupmapping_vessel)bpmusergrplist.get(j)).getUsercode();
            ObjGrpCodeLevel.setGroupcode(grpcode);
            ObjGrpCodeLevel.setUsercode(usercode);
            if (BPMcodelevelmap!= null && BPMcodelevelmap.containsKey(grpcode)) {
              ObjGrpCodeLevel.setLevel(Integer.parseInt(BPMcodelevelmap.get(grpcode).toString()));
            } else {
              ObjGrpCodeLevel.setLevel(99);
            } 
            bpmgroupcodelevelList.add(ObjGrpCodeLevel);
          } 
        }
        } 
      } 
    }
      Collections.sort(bpmgroupcodelevelList, new MBmainComparator());
      this.logger.info("lndcbean","edit action Map::: " + this.BPMcodelevelmap);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return bpmgroupcodelevelList;
  }

  public Usergroupvo getBPMCurrentGroupcode(List<String> applicablegrouplist,
  List<Bpmusergroupmapping_vessel> bpmusergrplist,List<Bpmusergroupmapping_vessel> bpmusergrplistR3,List<Rs4> r4List) {

    boolean flag = false;
    Usergroupvo usergrpvo = new Usergroupvo();
    String grpcode = "";
    boolean matchFound = false;
    List<Bpmgroupcodelevel> bpmgroupcodelevelList = new ArrayList<>(); 
    if (applicablegrouplist!=null && applicablegrouplist.size() > 0 && bpmusergrplist!=null && bpmusergrplist.size() > 0) {
     bpmgroupcodelevelList = GetgroupcodeListforEditAction1(applicablegrouplist, bpmusergrplist);
     
     if (bpmgroupcodelevelList!=null && bpmgroupcodelevelList.size() > 0) {
        grpcode = ((Bpmgroupcodelevel)bpmgroupcodelevelList.get(0)).getGroupcode();
        matchFound = true;
        this.logger.info("lndcbean"," Inside grpcode at 1st Leval:: " + grpcode);
      } else {
        matchFound = false;
      }
    } else {
        flag = true;
      }
      String usercode = "";
      if (!matchFound) {
        bpmgroupcodelevelList = new ArrayList<>(); 
        if (bpmusergrplistR3 != null && bpmusergrplistR3.size() > 0 && applicablegrouplist != null && applicablegrouplist.size() > 0) {
            bpmgroupcodelevelList = GetgroupcodeListforEditAction1(applicablegrouplist, bpmusergrplistR3);
            if (bpmgroupcodelevelList!=null && bpmgroupcodelevelList.size() > 0) {  
                grpcode = ((Bpmgroupcodelevel)bpmgroupcodelevelList.get(0)).getGroupcode();
                usercode = ((Bpmgroupcodelevel)bpmgroupcodelevelList.get(0)).getUsercode();
                this.logger.info("lndcbean","Inside Backup grpcode:: " + grpcode);
                flag = false;
                usergrpvo.setIsbackup(true);
                usergrpvo.setBackupfor(usercode);
                usergrpvo.setBackupforgroup(grpcode);

            } else {
                flag = true;
              } 

      }  else {
        flag = true;
      } 

    }

      if (flag) {
        this.logger.info("lndcbean"," flag Inside existing groupcode in Mackbpmutil ");
        bpmgroupcodelevelList = new ArrayList<>(); 
        
        this.logger.info("lndcbean","flag getusercode list size<>" + r4List.size());
        if (r4List != null && r4List.size() > 0 ) {
          for (int j = 0; j < r4List.size(); j++) {
            if(((Rs4)r4List.get(j)).getGroupcode()!=null && ((Rs4)r4List.get(j)).getUsercode()!=null) {
            grpcode = ((Rs4)r4List.get(j)).getGroupcode();
            Bpmgroupcodelevel ObjGrpCodeLevel = new Bpmgroupcodelevel();
            ObjGrpCodeLevel.setGroupcode(grpcode);
            if (BPMcodelevelmap!= null && BPMcodelevelmap.containsKey(grpcode)) {
              this.logger.info("lndcbean","Level Matched1 :" + grpcode);
              ObjGrpCodeLevel.setLevel(Integer.parseInt(BPMcodelevelmap.get(grpcode).toString()));
            } else {
              this.logger.info("lndcbean","Level Not Matched1 :" + grpcode);
              ObjGrpCodeLevel.setLevel(99);
            } 
            bpmgroupcodelevelList.add(ObjGrpCodeLevel);
          }  
        }
        Collections.sort(bpmgroupcodelevelList, new MBmainComparator());
        this.logger.info("lndcbean","flag Map::: " + BPMcodelevelmap);
        this.logger.info("lndcbean","flag List:: " + bpmgroupcodelevelList.size());
        if (bpmgroupcodelevelList.size() > 0) {
          grpcode = ((Bpmgroupcodelevel)bpmgroupcodelevelList.get(0)).getGroupcode();
          this.logger.info("lndcbean","flag Inside grpcode at 2st Level:: " + grpcode);
        } 
      } 
     }
      usergrpvo.setGroupcode(grpcode);
      this.logger.info("lndcbean"," final grpcode :: " + grpcode);
     
    return usergrpvo;
  }
 

  
    public String checknull(String value) {
        if (value == null) {
            value = "";
        }
        return value;

    }

    
    public List<Bpmusergroupmapping_vessel> getBpmusergroupmappingMap_vesselList(List<Rs1> RS1list) {
        List<Bpmusergroupmapping_vessel> bpmusergroupmapping_vesselList = new ArrayList<Bpmusergroupmapping_vessel>();
       
            for (int i = 0; i < RS1list.size(); i++) {
                Bpmusergroupmapping_vessel bpmusergroupmapping_vessel = new Bpmusergroupmapping_vessel();
                bpmusergroupmapping_vessel.setGroupcode(RS1list.get(i).getGroupcode());
                bpmusergroupmapping_vessel.setRoltype(RS1list.get(i).getRoltype());
                bpmusergroupmapping_vessel.setUsercode(RS1list.get(i).getUsercode());
                bpmusergroupmapping_vessel.setVslcompcode(RS1list.get(i).getVslcompcode());
                bpmusergroupmapping_vesselList.add(bpmusergroupmapping_vessel);
            }

            return bpmusergroupmapping_vesselList;  
    }

    public List<Bpmusergroupmapping_vessel> getBpmusergroupmappingMap_vesselList1(List<Rs3> RS3list) {
        List<Bpmusergroupmapping_vessel> bpmusergroupmapping_vesselList = new ArrayList<Bpmusergroupmapping_vessel>();
       
            for (int i = 0; i < RS3list.size(); i++) {
                Bpmusergroupmapping_vessel bpmusergroupmapping_vessel = new Bpmusergroupmapping_vessel();
                bpmusergroupmapping_vessel.setGroupcode(RS3list.get(i).getGroupcode());
                bpmusergroupmapping_vessel.setRoltype(RS3list.get(i).getRoltype());
                bpmusergroupmapping_vessel.setUsercode(RS3list.get(i).getUsercode());
                bpmusergroupmapping_vessel.setVslcompcode(RS3list.get(i).getVslcompcode());
                bpmusergroupmapping_vesselList.add(bpmusergroupmapping_vessel);
            }

            return bpmusergroupmapping_vesselList;  
    }


    public TaskSummaryVo getTaskSummaryMapper(Rs0 Vo) {
        TaskSummaryVo taskSummaryVo = new TaskSummaryVo();
        try {
            taskSummaryVo.setTaskid(Vo.getTaskid());
            taskSummaryVo.setWfid(checknull((Vo.getWfid())));
           
            taskSummaryVo.setInstanceid(checknull((Vo.getInstanceid())));
            taskSummaryVo.setNodeid(checknull((Vo.getNodeid())));
            taskSummaryVo.setStatus(checknull((Vo.getStatus())));
            taskSummaryVo.setIsclaimed(checknull((Vo.getIsclaimed())));
            taskSummaryVo.setClaimuser(checknull((Vo.getClaimuser())));
            taskSummaryVo.setClaimdate(checknull((Vo.getClaimdate())));
            taskSummaryVo.setUsergroup(checknull((Vo.getUsergroup())));
            taskSummaryVo.setOfficecode(checknull((Vo.getOfficecode())));
            taskSummaryVo.setGateid(checknull((Vo.getGateid())));
            taskSummaryVo.setIsreassinged(checknull((Vo.getIsreassinged())));
            taskSummaryVo.setClaimduration(Vo.getClaimduration());
            taskSummaryVo.setDueduration(Vo.getDueduration());
            taskSummaryVo.setDeadlinedate(checknull((Vo.getDeadlinedate())));
            taskSummaryVo.setDatalogid(checknull((Vo.getDatalogid())));
            taskSummaryVo.setRemarks(checknull((Vo.getRemarks())));
            taskSummaryVo.setDisprefno(checknull((Vo.getDisprefno())));
            taskSummaryVo.setId(Vo.getId());
            taskSummaryVo.setRefno(checknull((Vo.getRefno())));
            taskSummaryVo.setNodename(checknull((Vo.getNodename())));
            taskSummaryVo.setSubdate(checknull((Vo.getSubdate())));
            taskSummaryVo.setLastclaimuser(Vo.getLastclaimuser());
            taskSummaryVo.setLastmannodeid(Vo.getLastmannodeid());
           
            taskSummaryVo.setCode(checknull((Vo.getCode())));
            taskSummaryVo.setType(checknull((Vo.getType())));
            taskSummaryVo.setIsBackup(checknull((Vo.getIsBackup())));
            taskSummaryVo.setBackupfor(checknull((Vo.getBackupfor())));
            
            taskSummaryVo.setInitiatorid(checknull((Vo.getInitiatorid())));
            taskSummaryVo.setFormid(checknull((Vo.getFormid())));
            taskSummaryVo.setMisc(checknull((Vo.getMisc())));
            taskSummaryVo.setIsinviter(Vo.getIsinviter());
            taskSummaryVo.setIsinvited(Vo.getIsinvited());
            taskSummaryVo.setBatchid(Vo.getBatchid());
            taskSummaryVo.setBackupforGroup(checknull((Vo.getBackupforGroup())));
            taskSummaryVo.setOwnership(checknull((Vo.getOwnership())));
            taskSummaryVo.setTasktype(checknull((Vo.getTasktype())));
            taskSummaryVo.setNodename(checknull((Vo.getNodename())));
            taskSummaryVo.setFlag(checknull((Vo.getFlag())));
        } catch (Exception e) {
            logger.info("lndcbean","//==//==|ERROR IN GETTING TASK SUMMARY|==>" + e.getMessage());
            logger.fatal(e);
        }
        return taskSummaryVo;
    }

    public List<Bpmusergroupmapping_vessel> getBPMUsersGroupcode(List <Bpmusergroupmapping_vessel>BPMlist,String VesselorCompanycode) {
        List<Bpmusergroupmapping_vessel> filteredList = new ArrayList<Bpmusergroupmapping_vessel>();
        try {

            if (PROJECTTYPE != null && PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
                filteredList = BPMlist.stream()
                .filter(vo -> vo.getVslcompcode().equalsIgnoreCase(VesselorCompanycode) ||
                 vo.getVslcompcode().equalsIgnoreCase(mData.getMetaData(APPINFO.COMPANY_CODE)))
                .collect(Collectors.toList());

            } else {
                filteredList = BPMlist;
            }

        } catch (Exception e) {
            logger.fatal(e);
        }
        return filteredList;
    }


    private List<Bpmusergroupmapping_vessel> getUsersGroupcode(String VesselorCompanycode) {
        VDSMackBpmUtil mackusergroup1 = null;
        VDSMackBpmUtil mackusergroup2 = null;
        try {

            if (PROJECTTYPE != null && PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
                mackusergroup1 = service.getgrpcodebyvessel(mData.getMetaData(USERINFO.USERCODE), VesselorCompanycode); 

                mackusergroup2 = service.getfunbasedgrpcode(mData.getMetaData(USERINFO.USERCODE),
                        mData.getMetaData(APPINFO.COMPANY_CODE));

            } else {
                mackusergroup1 = service.getgrpcodebyvessel(mData.getMetaData(USERINFO.USERCODE));
            }

            if (mackusergroup2 != null && mackusergroup2.getBpmusergroupmapping_vessel() != null) {
                mackusergroup1.getBpmusergroupmapping_vessel().addAll(mackusergroup2.getBpmusergroupmapping_vessel());
            }

        } catch (Exception e) {
            logger.fatal(e);
        }
        return mackusergroup1.getBpmusergroupmapping_vessel();
    }

    private Usergroupvo getCurrentGroupcode(TaskSummaryVo taskvo, String WFID, List<String> usergrouplist,
            List<Bpmusergroupmapping_vessel> userallgrouplist) throws Exception {
        String sGrpCode = "";
        HashMap paramMap = new HashMap();
        paramMap.put(Keyconstants.userCode, mData.getMetaData(USERINFO.USERCODE));
        paramMap.put(Keyconstants.WFID, WFID);
        paramMap.put(Keyconstants.refNo, taskvo.getRefno());
        paramMap.put(Keyconstants.taskvo, taskvo);
        paramMap.put(Keyconstants.applicablegrouplist, usergrouplist);
        paramMap.put(Keyconstants.controlType, PROJECTTYPE);
        paramMap.put(Keyconstants.vslOrCompcode, taskvo.getCode());
        paramMap.put(Keyconstants.WFType, taskvo.getType());
        paramMap.put(Keyconstants.Flag, false);
        paramMap.put(Keyconstants.bpmusergrpList, userallgrouplist);
        logger.info("lndcbean","---lnc---paramMap " + paramMap);
        Usergroupvo usergroupvo = this.mbutil.getBpmUserGroupCode_LandingPageNew(paramMap); 
        return usergroupvo;
    }

    public Date getdateString(String colname, String coltype, String strdate) {

        String convertedString = "";
        SimpleDateFormat dfwtt = new SimpleDateFormat("yyyy-MM-dd");
        Date colDate = null;
        try {
            if (strdate != null && strdate.trim().length() > 0) {
                if (TimeZoneColList.contains(colname)) {
                    if (strdate != null && strdate.trim().length() > 0) {
                        SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATETIMEFORMAT).trim());
                        colDate = mackUtility.stringToDateConverterWithTimeZone(strdate);
                        convertedString = sdf.format(colDate);
                    }
                } else {
                    if (coltype.trim().equalsIgnoreCase("date")) {
                        // logger.info("lndcbean","date========"+coltype);
                        SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATEFORMAT).trim());
                        if (strdate != null && strdate.trim().length() > 0) {
                            colDate = mackUtility.stringToDateConverter(strdate);
                            convertedString = sdf.format(dfwtt.parse(strdate));
                        }
                    } else if (coltype.trim().equalsIgnoreCase("datetime")) {
                        // logger.info("lndcbean","datetime========"+coltype);
                        SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATETIMEFORMAT).trim());
                        if (strdate != null && strdate.trim().length() > 0) {
                            colDate = mackUtility.stringToDateConverter(strdate);
                            convertedString = sdf.format(colDate);
                        }
                    }
                }
            }

            // logger.info("lndcbean","colDate====" + colDate);
        } catch (Exception e) {
            logger.info("lndcbean","//==//==|ERROR IN getDateFormat METHODDDDDD|==>" + e.getMessage());
            logger.fatal(e);
        }
        return colDate;
    }

    public void columnheaderButton() { // *************** for button ****************
        ArrayList list = new ArrayList();
        ArrayList columnvaluelist = new ArrayList();
        ArrayList groupbuttonlist = new ArrayList();
        ButtonActionColumn vo = new ButtonActionColumn();
        String displayname = "";
        // logger.info("lndcbean","button map in columnheaderButton===>" + buttonMap);
        Iterator itrbutton = buttonMap.keySet().iterator();
        while (itrbutton.hasNext()) {
            String groupcolumnName = itrbutton.next().toString();
            groupbuttonlist.add(groupcolumnName);
        }
        if (groupbuttonlist != null) {
            for (int m = 0; m < groupbuttonlist.size(); m++) {
                Iterator itr = groupbuttonHeaders.keySet().iterator();
                while (itr.hasNext()) {
                    String columnName = itr.next().toString();
                    if (groupbuttonlist.get(m).toString().equalsIgnoreCase(columnName)) {
                        displayname = (String) buttonMap.get(columnName);
                        columnvaluelist.add(displayname);
                    }
                }
            }
        }
        for (int i = 0; i < columnvaluelist.size(); i++) {
            vo = new ButtonActionColumn();
            vo.setColumnheader(columnvaluelist.get(i).toString());
            list.add(vo);
            model.getDataModel().setColumnhearderbuttonlist(list);
        }
        RequestContext.getCurrentInstance().execute("lnd_navigate_rcform()");
        // RequestContext.getCurrentInstance().update("landingPageForm");
    }

    public void navigateEditColumnClicked(int colIndex, String statusDesc) {
        logger.info("lndcbean","inisde navigateEditColumnClicked====>");
        int index = 0;
        String mdlcode = "";
        LinkedTreeMap allvalue = null;
        LinkedTreeMap editallvalue = null;
        ArrayList lstToEdit = null;
        TaskSummaryVo taskSummary = new TaskSummaryVo();
        LandingDataVo landingdata = new LandingDataVo();
        boolean navigateflag;
        String refnofieldval = "";
        ClaimRights claimRights;
        try {
            Iterator itr = indexcolumnmap.keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next().toString();
                index = (int) indexcolumnmap.get(key);
                if (colIndex == index) {
                    if (groupbuttonHeaders.containsKey(key)) {
                        allvalue = (LinkedTreeMap) groupbuttonHeaders.get(key);
                        if (allvalue.containsKey("edit")) {
                            editallvalue = (LinkedTreeMap) allvalue.get("edit");
                            model.getStateModel().setCommandlinkrender(true);
                            mdlcode = (String) editallvalue.get("targetmdl");
                            lstToEdit = (ArrayList) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance())
                                    .getAttributes().get("selectedRowButton");
                            refnofieldval = lstToEdit.get(refnofieldIndex).toString();
                            if (reodersubmit || loadingreorderbool) {
                                lstToEdit = reorderSetdata(refnofieldval);
                            }
                            landingdata.setReferenceNumber(refnofieldval);
                            landingdata.setData(lstToEdit);
                            landingdata.setAction(LandingDataVo.LandingAction.NAVIGATEEDIT);
                            landingdata.setIsDynamicMdl(isDynamicMdl);
                            if (applyBPM) {
                                if (refnoTaskSummaryMap
                                        .get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase()) != null) {
                                    taskSummary = refnoTaskSummaryMap
                                            .get(((String) lstToEdit.get(refnofieldIndex)).trim().toLowerCase());
                                }
                                String[] latColVal = lstToEdit.get(lstToEdit.size() - 1).toString().split("~");
                                WFID = latColVal[0].trim();
                                bpmWFID = latColVal[1].trim();
                                landingdata.setBpmwfid(bpmWFID);
                                landingdata.setWfid(WFID);
                                landingdata.setIsBPMEnabled(true);
                                boolean rarEditRights = false;

                                claimRights = smbpmUtil.hasClaimRights(model.getDataModel().getMdlId().trim(),
                                        mData.getMetaData(APPINFO.COMPANY_CODE),
                                        WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                        mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                                rarEditRights = claimRights.isHasRights();
                                if (!rarEditRights) {
                                    claimRights = smbpmUtil.hasClaimRightsDynamic(
                                            model.getDataModel().getMdlId().trim(),
                                            mData.getMetaData(APPINFO.COMPANY_CODE),
                                            WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                            mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                                    rarEditRights = claimRights.isHasRights();
                                }

                                logger.info("lndcbean","navigateEditColumnClicked >> Final rarEditRights >>" + rarEditRights);
                                if (rarEditRights) {
                                    StatusVo claimStatus = smbpmUtil.claimTask(taskSummary,
                                            mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());

                                    landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
                                    landingdata.setStatus(claimStatus.getStatus());
                                    if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS
                                            || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED) {

                                        taskSummary = claimStatus.getTaskSummaryVo();
                                        landingdata.setTasksummary(taskSummary);
                                        if (reodersubmit || loadingreorderbool) {
                                            lstToEdit = reorderSetdata(refnofieldval);
                                        }
                                        landingdata.setReferenceNumber(refnofieldval);
                                        landingdata.setData(lstToEdit);
                                        landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
                                        if (name != null && name.equalsIgnoreCase("parent")) {
                                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
                                                    landingdata, true);
                                        } else {
                                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
                                                    landingdata, false, true);
                                        }
                                    } else {
                                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);

                                    }
                                } else {
                                    dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
                                }
                            } else {
                                landingdata.setTasksummary(null);
                                landingdata.setWfid(null);
                                if (reodersubmit || loadingreorderbool) {
                                    lstToEdit = reorderSetdata(refnofieldval);
                                }
                                landingdata.setReferenceNumber(refnofieldval);
                                landingdata.setData(lstToEdit);
                                landingdata.getData().add(0, lstToEdit.get(refnofieldIndex));
                                if (name != null && name.equalsIgnoreCase("parent")) {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata,
                                            true);
                                } else {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata,
                                            false, true);
                                }
                            }
                            if (editallvalue.containsKey("navigateflag")) {
                                navigateflag = (boolean) editallvalue.get("navigateflag");
                            } else {
                                navigateflag = false;
                            }
                            if (name != null && name.equalsIgnoreCase("parent")) {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata,
                                        navigateflag);
                            } else {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata, false,
                                        navigateflag);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

            logger.info("lndcbean","exception in navigateEditColumnClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    } // ****************** button End ***************************

    public void selectedRadioBtn() { // ************************ Filter Start *************************
        logger.info("lndcbean","inside selectedRadioBtn()*************");
        try {
            SingleChoiceRadioVo vo = new SingleChoiceRadioVo();
            ArrayList all = model.getDataModel().getRepeatradioallitems();
            for (int i = 0; i < all.size(); i++) {
                vo = (SingleChoiceRadioVo) all.get(i);
                filtergetfieldname.get(vo.getSelectedradiobtn());
                defaultselradio.put(filtergetfieldname.get(vo.getSelectedradiobtn()), vo.getSelectedradiobtn());

            }
            logger.info("lndcbean","Inside defaultselradio===>" + defaultselradio);
        } catch (Exception e) {
            logger.info("lndcbean","exception in selectedRadioBtn ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public void selectedCheckBox() {
        defaultselchk.clear();
        logger.info("lndcbean","inisde chkbox===>" + model.getDataModel().getSelectedchkbox());
        String fldname = "";
        String dspname = "";
        for (int k = 0; k < model.getDataModel().getSelectedchkbox().size(); k++) {
            fldname = filtergetfieldname.get(model.getDataModel().getSelectedchkbox().get(k)).toString();
            dspname = model.getDataModel().getSelectedchkbox().get(k).toString();
            defaultselchk.put(fldname, dspname);
        }
        logger.info("lndcbean","hiudsfn chk radio===>" + defaultselchk);
    }

    public void selectedCalendar() {
        logger.info("lndcbean","inisde selectedCalendar==>");
        try {
            SingleChoiceRadioVo vo = new SingleChoiceRadioVo();
            ArrayList all = model.getDataModel().getDaterepeatlist();
            for (int i = 0; i < all.size(); i++) {
                vo = (SingleChoiceRadioVo) all.get(i);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String m = formatter.format(vo.getFromdate());
                String fieldname = dspflddate.get(vo.getOpvaluedate()).toString();
                datehashmap.put(fieldname, m);
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in selectedCalendar ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public void refreshbtnClicked() {
        logger.info("lndcbean","******** refreshbtnClicked *********");
        refresh = true;
        toggleList.clear();
        toggleList.add(true);
        columnHeaderLstHide.clear();// vvv added by vino
        try {
            initializeLandingPage();
        } catch (Exception e) {
            logger.info("lndcbean","exception in refreshbtnClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
        // RequestContext.getCurrentInstance().update("landingPageForm");
    }

    public String selecradiohashmap(String fieldval) {
        return selradiohshmap.get(fieldval).toString();
    } // ************************ Filter End *************************

    public void togglerCliked() { // ************ Toggle Start *************************
        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
        RequestContext.getCurrentInstance().update("dlg1");
    }

    public void exportClicked() { // ***************** Export Excel Start *****************
        model.getDataModel().setDiaplay("display:none");
        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
        RequestContext.getCurrentInstance().update("dlg1");
    }

    public boolean isColumnVisible(String columnHeader) { // *********** Column Hidden Start ********************
        boolean showColumn = true;
        try {
            for (Object columnHeaderLstHide1 : columnHeaderLstHide) {
                if (columnHeaderLstHide1.toString().trim().equalsIgnoreCase(columnHeader.trim())) {
                    showColumn = false;
                }
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in isColumnVisible ==>" + e.getMessage());
            logger.fatal(e);
        }
        return showColumn;
    } // *********** Column Hidden End ********************

    public String actionDisplay() { // **************** Default Action *****************
        String value = "";
        // logger.info("lndcbean","==defaultaction===>"+defaultaction);
        if (defaultaction.equalsIgnoreCase("N")) {
            value = "display: none";
            model.getStateModel().setDefaultactionrender(false);
            model.getStateModel().setDefaultcolumrender(true);
            model.getDataModel().setActioncolumnwidth(0);
            editable = false;
            RequestContext.getCurrentInstance().update("landingPageForm");
        } else {
            model.getStateModel().setDefaultactionrender(true);
            model.getStateModel().setDefaultcolumrender(false);
            value = "display: false";
            RequestContext.getCurrentInstance().update("landingPageForm");
        }
        return value;
    } // **************** Default Action End *****************

    public String revokeDisplay() { // **************** Default Action *****************
        String value = "";
        logger.info("lndcbean","==revokeDisplay===>");

        return value;
    }

    public String applyStatusColorsForHeader(String columnname) { // ************color for span columns Start
                                                                  // *************
        String style = "";
        if (headerstlehm.containsKey(columnname)) {
            style = headerstlehm.get(columnname).toString();
        }
        return style;
    } // ************color for span columns End *************

    public String applyStatusColorsForRows(String statusDesc, String column) {
        // ************color for Statusdesc column Start *************
        String value = "";
        try {
            HashMap hm = new HashMap();
            if (column.equalsIgnoreCase(statusdescdpname)) {
                value = "<span class=\"label-" + statusDesc + "\" >" + statusDesc + "</span>";
            } else {
                value = statusDesc;
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in applyStatusColorsForRows ==>" + e.getMessage());
            logger.fatal(e);
        }
        return value;
    } // ************color for Statusdesc column End *************

    public String getHashmapViewvalue(int colIndex, String columnname) {
        String newval = "";
        // logger.info("lndcbean","kjs viewbtnlist>>>" + viewbtnlist);
        // logger.info("lndcbean","isjsk view>>>" + columnname + ">>>map>>" + indexmap);
        if (viewbtnlist.contains(columnname)) {
            newval = indexmap.get(colIndex).toString();
        }
        return newval;
    }

    public boolean getHashmapNewvalue(int colIndex, List row, String columnname) {
        boolean newbool;
        boolean bl = false;
        // logger.info("lndcbean","kjs newbtnlist>>>" + newbtnlist);
        // logger.info("lndcbean","isjsk new>>>" + columnname + ">>>map>>" + indexmapnew);
        if (newbtnlist.contains(columnname)) {
            bl = (boolean) indexmapnew.get(colIndex);
            if (bl) {
                if (newrenidentybool) {
                    newbool = newrenidentifierlistrows.contains(row);
                    if (newbool) {
                        bl = false;
                        // logger.info("lndcbean","inide elsefalse editable====>" + newbool);
                    }
                }
            }
        }
        return bl;
    }

    public boolean getHashmapEditvalue(int colIndex, List row, String columnname) {
        // logger.info("lndcbean","kjs editbtnlist>>>" + editbtnlist);
        // logger.info("lndcbean","isjsk edit>>>" + columnname + ">>>map>>" + indexmapedit);
        if (editbtnlist.contains(columnname)) {
            boolean bl = (boolean) indexmapedit.get(colIndex);
            if (bl) {
                if (applyBPM && editactionapplybpm) {
                    editable = bpmAppicableRows.contains(row);
                    if (editable) {
                        editable = model.getDataModel().isSm_editBtnRender();
                    }
                } else {
                    if (editrenidentybool) {
                        editable = editrenidentifierlistrows.contains(row);
                        if (editable) {
                            editable = false;
                        } else {
                            editable = model.getDataModel().isSm_editBtnRender();
                        }
                    } else {
                        editable = model.getDataModel().isSm_editBtnRender();
                    }
                }
                RequestContext.getCurrentInstance().update("datatableajax");
            } else {
                editable = bl;
            }
        } else {
            editable = false;
        }
        // logger.info("lndcbean","ijk edit>>>>" + editable);
        return editable;
    }

    public List<Map<String, Object>> checkEditable_new(List<Map<String, Object>> filteredHmrows) { // *******************
                                                                                                   // Edit Button Render
                                                                                                   // Handled
                                                                                                   // **********************
        logger.info("lndcbean","checkEditable_new called");
        // System.out.println("this.model.getDataModel().isSm_editBtnRender()====" +
        // this.model.getDataModel().isSm_editBtnRender());
        boolean isSuperEditor = superEditChecker();
        if (this.applyBPM) {
            for (int i = 0; i < filteredHmrows.size(); i++) {
                HashMap hm = (HashMap) filteredHmrows.get(i);
                // logger.info("lndcbean","apply bpm=====" + hm);
                if (this.model.getDataModel().isSm_editBtnRender() && !hm.containsKey("editidentifierlistrows")
                        && ((hm.containsKey("bpmapplicable") || (hm.containsKey("thirdlevelbpmapplicablerows")
                                && hm.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true"))))) {
                    hm.put("btnEditRenderInHm", "Yes");
                    btnEditRenderInHmcount++;
                } else if (isSuperEditor && superEditRestrictor(hm)) {
                    hm.put("btnEditRenderInHm", "Yes");
                    hm.put("superEditor", "yes");
                    btnEditRenderInHmcount++;
                } else {
                    hm.put("btnEditRenderInHm", "No");
                }
            }
        } else if (this.model.getDataModel().isSm_editBtnRender() && !applyBPM && thirdlevelvalidation != null
                && thirdlevelvalidation.equalsIgnoreCase("y")) {
            for (int i = 0; i < filteredHmrows.size(); i++) {
                HashMap hm = (HashMap) filteredHmrows.get(i);
                if (hm.containsKey("thirdlevelbpmapplicablerows")
                        && hm.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true")) {
                    hm.put("btnEditRenderInHm", "Yes");
                    btnEditRenderInHmcount++;
                } else {
                    hm.put("btnEditRenderInHm", "No");
                }
            }
        } else {
            if (this.model.getDataModel().isSm_editBtnRender() && this.editidentybool) {
                // logger.info("lndcbean","editidentybool in check editable method===" + editidentybool);
                for (int i = 0; i < filteredHmrows.size(); i++) {
                    HashMap hm = (HashMap) filteredHmrows.get(i);
                    if (hm.containsKey("editidentifierlistrows")) {
                        if (isSuperEditor && superEditRestrictor(hm)) {
                            hm.put("btnEditRenderInHm", "Yes");
                            hm.put("superEditor", "yes");
                        } else {
                            hm.put("btnEditRenderInHm", "No");
                        }

                    } else {
                        hm.put("btnEditRenderInHm", "Yes");
                        btnEditRenderInHmcount++;
                    }
                }

            } else {
                // logger.info("lndcbean","editidentybool in check editable method==else=");
                for (int i = 0; i < filteredHmrows.size(); i++) {
                    HashMap hm = (HashMap) filteredHmrows.get(i);
                    if (this.model.getDataModel().isSm_editBtnRender()) {
                        hm.put("btnEditRenderInHm", "Yes");
                        btnEditRenderInHmcount++;
                    } else {
                        hm.put("btnEditRenderInHm", "No");
                    }
                }
            }
        }

        // logger.info("lndcbean","btnEditRenderInHmcount===" + btnEditRenderInHmcount);
        return filteredHmrows;
    }

    public boolean checkEditable(final List row) { // ******************* Edit Button Render Handled
                                                   // **********************

        if (this.applyBPM) {
            if (this.editidentifierlistrows.contains(row)) {
                this.editable = false;
            } else {
                this.editable = this.bpmAppicableRows.contains(row);
                if (this.editable) {
                    this.editable = this.model.getDataModel().isSm_editBtnRender();
                }
                if (!this.editable && this.thirdlevelbpmapplicablerows != null
                        && this.thirdlevelbpmapplicablerows.contains(row)) {
                    this.editable = this.model.getDataModel().isSm_editBtnRender();
                }
            }
        } // else if added by vinothini.r for non bpm third level validation
        else if (!applyBPM && landingPageDatasHm.get("thirdlevelvalidation") != null
                && landingPageDatasHm.get("thirdlevelvalidation").toString().equalsIgnoreCase("y")) {
            if (!this.editable && this.thirdlevelbpmapplicablerows != null
                    && this.thirdlevelbpmapplicablerows.contains(row)) {
                this.editable = this.model.getDataModel().isSm_editBtnRender();
            }
        } else {
            if (this.editidentybool) {
                this.editable = this.editidentifierlistrows.contains(row);
                // logger.info("lndcbean","==this.editable==>"+this.editable);
                if (this.editable) {
                    this.editable = false;
                } else {
                    this.editable = this.model.getDataModel().isSm_editBtnRender();
                }
            } else {
                this.editable = this.model.getDataModel().isSm_editBtnRender();
            }
        }
        // if (this.editable && backUpTypeIndex != -1 && row.get(backUpTypeIndex) !=
        // null) {
        // String backUpType = row.get(backUpTypeIndex).toString();
        // if (backUpType != null && backUpType.equalsIgnoreCase("O")) {
        // this.editable = false;
        // }
        // }
        RequestContext.getCurrentInstance().update("datatableajax");
        return this.editable;
    } // ******************* Edit Button Render Handled End **********************

    public List settingLandingDataList(Map<String, Object> selectedRowMap) {
        List landingDataList = new ArrayList();
        referenceNumber = "";
        try {
            String strRefNo = "";
            String strWrkFlowAndBpmId = "-";
            logger.info("lndcbean","refnofieldwithoutdot>>>>>>" + refnofieldwithoutdot);
            if (selectedRowMap != null && selectedRowMap.get(refnofieldwithoutdot) != null) {
                strRefNo = selectedRowMap.get(refnofieldwithoutdot).toString();
            }
            landingDataList.add(strRefNo);
            referenceNumber = strRefNo;
            // System.out.println("new tab list in landing page" + referenceNumber);
            String key = null;
            for (int i = 0; i < tmpColHeaderNamesLstwithoutdot.size(); i++) {
                key = (String) tmpColHeaderNamesLstwithoutdot.get(i);
                if (selectedRowMap.get(key) == null) {
                    landingDataList.add("");
                } else {
                    landingDataList.add(selectedRowMap.get(key).toString());
                }
            }
            if (applyBPM) {
                if (selectedRowMap.get("tasksummaryvo") != null) {
                    landingDataList.add(selectedRowMap.get("bpmdetails"));
                } else {
                    landingDataList.add("-");
                }
            }
            logger.info("lndcbean","//==//==|landingDataList|==>" + landingDataList);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return landingDataList;
    }

    // ************** Clear Filter End ************************
    public void cancelClicked() {
        RequestContext.getCurrentInstance().execute("PF('dlg1').hide();");
    }

    public TimeZone getTimeZone() {
        logger.info("lndcbean","getTimezone called");
        logger.info("lndcbean","TimeZone.getDefault()=====" + TimeZone.getDefault());
        logger.info("lndcbean","TimeZone.getDefault()=====" + TimeZone.getDefault());
        return TimeZone.getDefault();
    }

    public ArrayList reorderSetdata(String refnofieldval) {
        ArrayList listtodata = null;
        List<List> viewallrows = (List<List>) reorderlandingPageDatasHm.get("rowValues");
        for (int i = 0; i < viewallrows.size(); i++) {
            if (viewallrows.get(i).contains(refnofieldval)) {
                // referenceNumber = refnofieldval;
                listtodata = (ArrayList) viewallrows.get(i);
                break;
            }
        }
        return listtodata;
    }

    public boolean isColumnRederable(String columnHeader) {
        boolean status = true;
        String columnHeaderVar = headerDisplayNameVarMap.get(columnHeader);
        if (columnHeaderVar != null && PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHORE)) {
            status = !((ArrayList) landingPageDatasHm.get("hideInShore")).contains(columnHeaderVar);
        } else if (columnHeaderVar != null && PROJECTTYPE.trim().equalsIgnoreCase(MackUtil_IF.S_SHIP)) {
            status = !((ArrayList) landingPageDatasHm.get("hideInShip")).contains(columnHeaderVar);
        }
        return status;
    }

    public String defaultSortingSymbol(String columnName) {
        String returnClass = "";
        HashMap sortHm = model.getDataModel().getSortByHm();
        try {
            if (sortHm != null && sortHm.get(columnName) != null) {
                returnClass = (String) sortHm.get(columnName);
                if (returnClass != null && returnClass.equalsIgnoreCase("sort")) {
                    logger.info("lndcbean","===defaultSortingSymbol JS called for===" + columnName);
                    RequestContext.getCurrentInstance().execute("defaultSortingSymbol()");
                }
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in defaultSortingSymbol ==>" + e.getMessage());
            logger.fatal(e);
        }
        return returnClass;
    }

    public void onSort() {
        try {
            RequestContext.getCurrentInstance().execute("removeDefaultSortingSymbol()");
        } catch (Exception e) {
            logger.info("lndcbean","exception in onSort ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public String getDateAsString(String conIndex) {
        String returnString = "";
        try {
            returnString = (String) model.getDataModel().getDateConverterHm().get(Integer.parseInt(conIndex));
        } catch (Exception e) {
            logger.info("lndcbean","exception in getDateAsString ==>" + e.getMessage());
            logger.fatal(e);
        }
        return returnString;
    }

    public void clearAllFilters(String compId) {
        try {
            logger.info("lndcbean","//==//==|INSIDE REMOVE FILTER|==>");
            logger.info("lndcbean","//==//==|compId|==>" + compId);
            DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(compId);
            logger.info("lndcbean","//==//==|dataTable|==>" + dataTable);
            if (dataTable != null) {
                if (!dataTable.getFilters().isEmpty()) {
                    dataTable.reset();
                    RequestContext requestContext = RequestContext.getCurrentInstance();
                    requestContext.update(compId);
                }
            }

            // RequestContext.getCurrentInstance().update("MGC_chooseTemplateDialog");
        } catch (Exception e) {
            logger.info("lndcbean","exception in clearAllFilters ==>" + e.getMessage());
            logger.fatal(e);
        }
    }


    private void getandLoadVessels() {
        try {
           
            CompleteModel completeModel = new CompleteModel();
            completeModel = service.getusermappedvessels(mData.getMetaData(USERINFO.USERCODE),
                    mData.getMetaData(APPINFO.COMPANY_CODE));
            if (completeModel.getVesselmapping() != null && completeModel.getVesselmapping().size() > 0) {

                for (int i = 0; i < completeModel.getVesselmapping().size(); i++) {
                    Vesselmaster vm = new Vesselmaster();
                    Vesselmapping vm1 = (Vesselmapping) completeModel.getVesselmapping().get(i);
                    vm.setVesselcode(vm1.getVesselcode());
                    vm.setVesselname(vm1.getVesselname());

                    vesselList.add(vm);
                }

            }
          
        } catch (Exception e) {
            // explog.setExceptionlog("LND", model.getDataModel().getMdlId(),
            // mData.getMetaData(APPINFO.COMPANY_CODE), PROJECTTYPE, e);
            // logger.info("lndcbean","exception in getandLoadVessels ==>" + e.getMessage());
            // logger.fatal(e);
        }

    }

    public List<Vesselmaster> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vesselmaster> vesselList) {
        this.vesselList = vesselList;
    }

    public String getSelectedvesselcode() {
        return selectedvesselcode;
    }

    public void setSelectedvesselcode(String selectedvesselcode) {
        this.selectedvesselcode = selectedvesselcode;
    }

    public void vsldlgsubmitClicked() {
        try {
            RequestContext.getCurrentInstance().execute("PF('vsldlg').hide();");
            if (selectedvesselcode != null && selectedvesselcode.trim().length() > 0) {
                if (applyBPM) {
                    StatusVo initStatus = new StatusVo();
                    LandingDataVo landingdata = new LandingDataVo();
                    landingdata.setData(null);
                    landingdata.setReferenceNumber(null);
                    landingdata.setIsBPMEnabled(true);
                    landingdata.setAction(LandingDataVo.LandingAction.NEW);
                    landingdata.setTasksummary(new TaskSummaryVo());
                    landingdata.setWfid(formCreationWFID);
                    landingdata.setBpmwfid(formCreationbpmWFID);
                    landingdata.setIsDynamicMdl(isDynamicMdl);
                    landingdata.setSelectedvessel(selectedvesselcode);
                    if (!isDynamicMdl) {
                        logger.info("lndcbean","selectedvesselcode=====" + selectedvesselcode);
                        initStatus = smbpmUtil.hasRightsToIntiateProcess(model.getDataModel().getMdlId(),
                                mData.getMetaData(APPINFO.COMPANY_CODE),
                                formCreationWFID, mData.getMetaData(USERINFO.USERCODE).trim(), selectedvesselcode, "V"); // instead
                                                                                                                         // of
                                                                                                                         // common
                                                                                                                         // wfcode,here
                                                                                                                         // we
                                                                                                                         // are
                                                                                                                         // passing
                                                                                                                         // the
                                                                                                                         // selected
                                                                                                                         // vesselcode
                                                                                                                         // as
                                                                                                                         // wfcode

                        if (initStatus.getStatus() == StatusVo.STATUS.SUCCESS) {
                            HashMap hmap = new HashMap();
                            hmap.put(Keyconstants.userCode, mData.getMetaData(USERINFO.USERCODE));
                            hmap.put(Keyconstants.WFID, formCreationWFID);
                            hmap.put(Keyconstants.vslOrCompcode, selectedvesselcode);
                            hmap.put(Keyconstants.Flag, true);
                            hmap.put(Keyconstants.WFType, "V");
                            hmap.put(Keyconstants.controlType, PROJECTTYPE);
                            boolean proceed = mbutil.hasNewAccess(hmap);
                            if (proceed) {
                                if (name != null && name.equalsIgnoreCase("parent")) {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata,
                                            true);
                                } else {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata,
                                            false, true);
                                }
                                // NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
                                // landingdata, true);
                            } else {
                                dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                            }
                        } else {
                            dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                        }
                    } else {
                        if (name != null && name.equalsIgnoreCase("parent")) {
                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                        } else {
                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false,
                                    true);
                        }
                        // NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
                        // landingdata, true);
                    }
                } else {
                    logger.info("lndcbean","### Master New Action =else=>" + redirectMdlId);
                    LandingDataVo landingdata = new LandingDataVo();
                    landingdata.setData(null);
                    landingdata.setReferenceNumber(null);
                    landingdata.setAction(LandingDataVo.LandingAction.NEW);
                    landingdata.setTasksummary(null);
                    landingdata.setWfid(null);
                    landingdata.setSelectedvessel(selectedvesselcode);
                    // logger.info("lndcbean","company code in landing page======after NO BPM=11=============="
                    // + mData.getMetaData(APPINFO.COMPANY_CODE));
                    // NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
                    // landingdata, true);
                    if (name != null && name.equalsIgnoreCase("parent")) {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                    } else {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                    }
                }
                selectedvesselcode="";
            } else {
                selectedvesselcode="";
                this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00003", "", null);
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in vsldlgsubmitClicked ==>" + e.getMessage());
            logger.fatal(e);
            selectedvesselcode="";
        }
    }

    public Object sortBy(Object obj, String column) throws ParseException {
        logger.info("lndcbean","sort by called ====" + obj);
        logger.info("lndcbean","sort by called =column===" + column);
        if (obj != null && obj.toString().trim().length() > 0) {
            if (datetimeColumHashMap.containsKey(column)) {
                String strdate = (String) obj;
                SimpleDateFormat fromUser = new SimpleDateFormat(this.mData.getMetaData(USERINFO.DATETIMEFORMAT));
                Date dateobj = fromUser.parse(strdate);
                obj = (int) (dateobj.getTime() / 1000);
            } else if (dateColumHashMap.containsKey(column)) {
                String strdate = (String) obj;
                SimpleDateFormat fromUser = new SimpleDateFormat(mData.getMetaData(USERINFO.DATEFORMAT).trim());
                Date dateobj = fromUser.parse(strdate);
                obj = (int) (dateobj.getTime() / 1000);
            }
        } else if (datetimeColumHashMap.containsKey(column) || dateColumHashMap.containsKey(column)) {
            obj = 0;
        }
        // logger.info("lndcbean","obj===" + obj);
        return obj;
    }

    // PRAVEEN .S JACK ASLAN SPARROW GOING TO TAKE CARE OF LND
    public List<DefaultColumnModel> getColumnModelList() {
        return columnModelList;
    }

    public void setColumnModelList(List<DefaultColumnModel> columnModelList) {
        this.columnModelList = columnModelList;
    }

    public List<DefaultColumnModel> getColumnModelListunhandled() {
        return columnModelListunhandled;
    }

    public void setColumnModelListunhandled(List<DefaultColumnModel> columnModelListunhandled) {
        this.columnModelListunhandled = columnModelListunhandled;
    }

    public List<ContextMenuModel> getContextMenuModelList() {
        return contextMenuModelList;
    }

    public void setContextMenuModelList(List<ContextMenuModel> contextMenuModelList) {
        this.contextMenuModelList = contextMenuModelList;
    }

    //
    HashMap grpbtnMap = new HashMap();

    private void createDataTableColumnModel() {
        try {
            logger.info("lndcbean","//==//==|INSIDE createDataTableColumnModel|==> " + columnHeaderLst.size() + " " + tmpColumnNames.size()
            + " " + columnHeaderLst + " " + tmpColumnNames);
            columnModelList = new ArrayList();
            columnModelListunhandled = new ArrayList();
            // logger.info("lndcbean","//==//==|columnHeaderLst.size() IN createDataTableColumnModel|==>" + columnHeaderLst.size());
            // logger.info("lndcbean","//==//==|tmpColumnNames.size() IN createDataTableColumnModel|==>" + tmpColumnNames.size());
            // logger.info("lndcbean","//==//==|columnHeaderLst IN createDataTableColumnModel|==>" + columnHeaderLst);
            // logger.info("lndcbean","//==//==|tmpColumnNames IN createDataTableColumnModel|==>" + tmpColumnNames);
            List<String> temColumnNamesListNew = new ArrayList();

            temColumnNamesListNew = tmpColumnNames;
            logger.info("lndcbean","//==//==|temColumnNamesListNew|==>" + temColumnNamesListNew);
            DefaultColumnModel dfc = new DefaultColumnModel();
            if (defaultaction == null || !defaultaction.trim().equalsIgnoreCase("N")) {
                dfc.setHeaderName("Action");
                dfc.setField("view");
                dfc.setCellRenderer("LandingCellRenderer");
                dfc.setLockPosition(Boolean.TRUE);
                dfc.setPinned(DefaultColumnModel.PINNED_LEFT);
                columnModelList.add(dfc);
                DefaultColumnModel dfc1 = new DefaultColumnModel();
                dfc1.setHeaderName("Action");
                dfc1.setField("view");
                dfc1.setCellRenderer("LandingCellRendererfortable2");
                dfc1.setLockPosition(Boolean.TRUE);
                dfc1.setPinned(DefaultColumnModel.PINNED_LEFT);
                columnModelListunhandled.add(dfc1);
            }

            if (tmpColHeaderNamesLst.size() > 0) {
                DefaultColumnModel df = null;
                int i = 0;
                for (Object tempObj : tmpColHeaderNamesLst) {
                    df = new DefaultColumnModel();
                    String key = tempObj.toString().replaceAll("\\.", "");
                    if (!hideList.contains(key)) {
                        df.setHeaderName(ColumnDisplayNameVarMap.get(tempObj.toString()));
                        df.setField(key);
                        df.setDataType(DefaultColumnModel.DATATYPE_STRING);
                        if (newbtnlist.contains(key)) {
                            df.setCellRenderer("GroupNewBtnRenderer");
                        } else if (editbtnlist.contains(key)) {
                            df.setCellRenderer("GroupEditBtnRenderer");
                        } else if (viewbtnlist.contains(key)) {
                            df.setCellRenderer("GroupviewBtnRenderer");
                        }
                        if (statusdescwithoutdot.equalsIgnoreCase(key)) {
                            df.setCellClass("if(params){return getcellcolor(params)}");
                        }
                        // // System.out.println("backgroundtobeaddedList====" +
                        // backgroundtobeaddedList);
                        // // System.out.println("key===" + key);
                        if (backgroundtobeaddedList != null && backgroundtobeaddedList.contains(key)) {
                            // // System.out.println("class added========================");
                            df.setCellClass("if(params){return getBackgroundcolor(params)}");
                        }
                        if (customFieldBackGroundColourList != null && customFieldBackGroundColourList.contains(key)) {
                            // // System.out.println("class added========================");
                            df.setCellRenderer("customColurSettingJs");
                        }

                        if (ColTypeMap.containsKey(key)) {
                            if (ColTypeMap.get(key).toString().equalsIgnoreCase("date")) {
                                df.setDataType(DefaultColumnModel.DATATYPE_DATE);
                                // df.setDataFormat(dateformat);
                            } else if (ColTypeMap.get(key).toString().equalsIgnoreCase("datetime")) {
                                df.setDataType(DefaultColumnModel.DATATYPE_DATETIME);
                                // df.setDataFormat(datetimeformat);
                            } else if (ColTypeMap.get(key).toString().equalsIgnoreCase("int")) {
                                df.setDataType(DefaultColumnModel.DATATYPE_INTEGER);
                            } else if (ColTypeMap.get(key).toString().equalsIgnoreCase("float")) {
                                df.setDataType(DefaultColumnModel.DATATYPE_DOUBLE);
                            } else if (ColTypeMap.get(key).toString().equalsIgnoreCase("double")) {
                                df.setDataType(DefaultColumnModel.DATATYPE_DOUBLE);
                            }
                        }

                        if (dateTimeColList.contains(key)) {
                            df.setDataType(DefaultColumnModel.DATATYPE_DATETIME);
                            df.setDataFormat(datetimeformat);
                        }

                        columnModelList.add(df);
                        columnModelListunhandled.add(df);
                    }
                    i++;
                }

                // df.setDataType(DefaultColumnModel.DATATYPE_DATE);
            }
            if (applyBPM) {
                dfc = new DefaultColumnModel();
                dfc.setHeaderName("Revoke/Recall");
                // dfc.setHeaderName("Revoke");
                dfc.setField("revoke");
                dfc.setCellRenderer("RevokeCellRenderer");
                columnModelList.add(dfc);
                columnModelListunhandled.add(dfc);
            } else {
                // NFR-3304 Non BPM Revoke Recall
                // // System.out.println("Apply BPM Is false === >>");
                // if ((model.getDataModel().getnBPMconfig() != null &&
                // !model.getDataModel().getnBPMconfig().isEmpty())
                // || (model.getDataModel().getnBPMconfigrecall() != null &&
                // !model.getDataModel().getnBPMconfigrecall().isEmpty())) {
                // // System.out.println("Condition become ture === >>");
                // if (model.getDataModel().getRevokeHeaders() != null ||
                // model.getDataModel().getRecallHeaders() != null) {
                // // System.out.println("Condition become ture === for revoke recall>>");
                // dfc = new DefaultColumnModel();
                // dfc.setHeaderName("Revoke\\Recall");
                // dfc.setField("revoke");
                // dfc.setCellRenderer("NBpmRevokeRecallRenderer");
                // this.columnModelList.add(dfc);
                // this.columnModelListunhandled.add(dfc);
                // }
                // }
            }

            dfc = new DefaultColumnModel();
            dfc.setHeaderName("My Actions");
            dfc.setHide(true);
            dfc.setField("btnEditRenderInHm");
            columnModelList.add(dfc);
            columnModelListunhandled.add(dfc);
            if (widgetList != null && widgetList.size() > 0) { // these are applicable only for configured modules
                dfc = new DefaultColumnModel();
                dfc.setHide(true);
                dfc.setHeaderName("My Chat");
                dfc.setField("chatapplicable");
                columnModelList.add(dfc);
                dfc = new DefaultColumnModel();
                dfc.setHide(true);
                dfc.setField("notificationapplicable");
                dfc.setHeaderName("My Notification");
                // dfc.setHide(true);
                columnModelList.add(dfc);
                columnModelListunhandled.add(dfc);
            }

        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    // NFR-3304 Non BPM Revoke Recall
    // public String nonbpmIdentifier(Map<String, Object> Hmrows) {
    // try {
    // LinkedTreeMap nonbpmIdentifier = new LinkedTreeMap();
    // LinkedTreeMap revokeIdentifier = new LinkedTreeMap();
    // LinkedTreeMap recallIdentifier = new LinkedTreeMap();
    // String hmrowValues, hmrowRecall = null;
    // model.getDataModel().setRevokeHeaders(new ArrayList<>());
    // model.getDataModel().setRevokeValues(new ArrayList<>());
    // model.getDataModel().setRecallHeaders(new ArrayList<>());
    // model.getDataModel().setRecallValues(new ArrayList<>());
    // if (model.getDataModel().getNonBPMRevokeRecallIdentifier() != null &&
    // !model.getDataModel().getNonBPMRevokeRecallIdentifier().isEmpty()) {
    // nonbpmIdentifier = (LinkedTreeMap)
    // model.getDataModel().getNonBPMRevokeRecallIdentifier();
    // // System.out.println("nonbpmIdentifier===>>" + nonbpmIdentifier);
    // // nonbpm revoke
    // if (nonbpmIdentifier.containsKey("revokeidentifier")
    // && nonbpmIdentifier.get("revokeidentifier") != null) {
    // revokeIdentifier = (LinkedTreeMap) nonbpmIdentifier.get("revokeidentifier");
    // if (revokeIdentifier.get("column") != null && revokeIdentifier.get("values")
    // != null) {
    // model.getDataModel().getRevokeHeaders().add(revokeIdentifier.get("column").toString());
    // model.getDataModel().getRevokeValues().add(revokeIdentifier.get("values").toString());
    // } else {
    // logger.info("lndcbean","---lndnonbpm revoke column or value is null");
    // }
    // } else {
    // logger.info("lndcbean","---lndrevoke identifier is not configured");
    // }
    //
    // // nonbpm recall
    // if (nonbpmIdentifier.containsKey("recallidentifier")
    // && nonbpmIdentifier.get("recallidentifier") != null) {
    // recallIdentifier = (LinkedTreeMap) nonbpmIdentifier.get("recallidentifier");
    // if (recallIdentifier.get("column") != null && recallIdentifier.get("values")
    // != null) {
    // model.getDataModel().getRecallHeaders().add(recallIdentifier.get("column").toString());
    // model.getDataModel().getRecallValues().add(recallIdentifier.get("values").toString());
    // } else {
    // logger.info("lndcbean","---lndnonbpm recall column or value is null");
    // }
    // } else {
    // logger.info("lndcbean","---lndrecall identifier is not configured");
    // }
    // }
    //
    // if (model.getDataModel().getRevokeHeaders() != null) {
    // for (String headers : model.getDataModel().getRevokeHeaders()) {
    // hmrowValues = Hmrows.get(headers.toString().replace(".",
    // "").trim()).toString();
    // for (String values : model.getDataModel().getRevokeValues()) {
    // if (hmrowValues.equalsIgnoreCase(values.replace("[", "").replace("]", ""))) {
    // return "revoke";
    // }
    // }
    // }
    // }
    //
    // if (model.getDataModel().getRecallHeaders() != null) {
    // for (String headers : model.getDataModel().getRecallHeaders()) {
    // hmrowRecall = Hmrows.get(headers.toString().replace(".",
    // "").trim()).toString();
    // for (String values : model.getDataModel().getRecallValues()) {
    // if (hmrowRecall.equalsIgnoreCase(values.replace("[", "").replace("]", ""))) {
    // return "recall";
    // }
    // }
    // }
    // }
    //
    // } catch (Exception e) {
    // logger.info("lndcbean","---lndException " + e);
    // e.printStackTrace();
    // }
    // return null;
    // }
    String strRefNoFieldValue;
    String strStatusDescValue;

    // public void setSmRowListToDynamicEntityMap1(List<String>
    // temColumnNamesListNew) {
    // try {
    //// logger.info("lndcbean","//==//==|INISDE setSmRowListToDynamicEntityMap|==>");
    //// logger.info("lndcbean","//==//==|model.getDataModel().getSm_rowsLst()|==>" +
    // model.getDataModel().getSm_rowsLst());
    // logger.info("lndcbean","//==//==|model.getDataModel().getSm_rowsLst().size()|==>" +
    // model.getDataModel().getSm_rowsLst().size());
    // logger.info("lndcbean","//==//==|temColumnNamesListNew.size()|==>" +
    // temColumnNamesListNew.size());
    // logger.info("lndcbean","//==//==|landingPageDatasHm.get(refnofield).toString()|==>" +
    // landingPageDatasHm.get("refnofield").toString());
    // strRefNoFieldValue =
    // landingPageDatasHm.get("refnofield").toString().split("\\.")[1];
    // strStatusDescValue =
    // landingPageDatasHm.get("statusdesc").toString().split("\\.")[1];
    // logger.info("lndcbean","//==//==|strRefNoFieldValue|==>" + strRefNoFieldValue);
    // logger.info("lndcbean","//==//==|strStatusDescValue|==>" + strStatusDescValue);
    // if (model.getDataModel().getSm_rowsLst().size() > 0) {
    // List<Map<String, String>> tempDynEntityList = new ArrayList();
    // Map<String, String> hm = null;
    // String btnEditRender = "";
    // String bNavigateNewBtnRendered = "";
    // String btnRevokeOrangeBtn = "";
    // String btnRevokeBtn = "";
    // int i = 0;
    // for (List tempObj : model.getDataModel().getSm_rowsLst()) {
    // int j = 0;
    // boolean isJisEqualToTempColmnListSize = true;
    // hm = new HashMap();
    // btnEditRender = "No";
    // bNavigateNewBtnRendered = "false";
    // btnRevokeOrangeBtn = "false";
    // btnRevokeBtn = "false";
    // if (checkEditable(tempObj)) {
    // btnEditRender = "Yes";
    // }
    //
    // for (int k = 0; k < model.getDataModel().getSm_allcolumnsLst().size(); k++) {
    // if (getHashmapNewvalue(k, tempObj,
    // model.getDataModel().getSm_allcolumnsLst().get(k).toString())) {
    // bNavigateNewBtnRendered = "true";
    // }
    // }
    //
    // for (Object tempObj2 : tempObj) {
    // if (j == tempObj.size() - 1) {
    // if ("-".equalsIgnoreCase(tempObj2.toString())) {
    // hm.put("lastPosition", tempObj2.toString());
    // } else {
    // hm.put("wfId~bpmId", tempObj2.toString());
    // }
    // isJisEqualToTempColmnListSize = false;
    // }
    // if (isJisEqualToTempColmnListSize) {
    // hm.put(temColumnNamesListNew.get(j), tempObj2.toString());
    // if (temColumnNamesListNew.get(j).equalsIgnoreCase(strRefNoFieldValue)) {
    // hm.put("strRefNoFieldValue", tempObj2.toString());
    // }
    // if (temColumnNamesListNew.get(j).equalsIgnoreCase(strStatusDescValue)) {
    // hm.put("strStatusDescValue", tempObj2.toString());
    // }
    // }
    // j++;
    // }
    // hm.put("btnEditRenderInHm", btnEditRender);
    // hm.put("bNavigateNewBtnRendered", bNavigateNewBtnRendered);
    // tempDynEntityList.add(hm);
    // i++;
    // }
    //
    // model.getDataModel().setDynamicEntityMap(new ArrayList());
    //
    // logger.info("lndcbean","//==//==|model.getDataModel().getDynamicEntityMap().size()|==>"
    // + model.getDataModel().getDynamicEntityMap().size());
    // }
    //
    // } catch (Exception e) {
    // logger.fatal(e);
    // }
    // }
    public int getRowIndex() {
        logger.info("lndcbean","//==//==|INSIDE getRowIndex|==>");
        Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) params.get("rowIndex");
        int rowIndex = Integer.parseInt(param1);
        logger.info("lndcbean","//==//==|rowIndex|==>" + rowIndex);
        return rowIndex;
    }

    public void newtabviewClicked_other() {
        logger.info("lndcbean","Inside newtabviewClicked>>>>>");
        // ArrayList lstToView = null;
        LandingDataVo landingdata = new LandingDataVo();
        String refnofieldval = "";

        String strWfIdAndBpmId = "-";
        boolean thirdlevelbpmapplicable = false;

        try {
            logger.info("lndcbean","//==//==|View Clicked statusdescindex|==>" + statusdescindex);
            int iRowIndex = getRowIndex();
            logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex);

            Map editedRowMap = model.getDataModel().getUnhandleddynamicEntityMap().get(iRowIndex);
            logger.info("lndcbean","//==//==|editedRowMap In viewClicked()==>" + editedRowMap);
            refnofieldval = getValuesFromEditedRowMap("strRefNoFieldValue", editedRowMap);
            strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails", editedRowMap);
            if (editedRowMap.containsKey("thirdlevelbpmapplicablerows")
                    && editedRowMap.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true")) {
                thirdlevelbpmapplicable = true;
            }
            landingdata.setReferenceNumber(refnofieldval);
            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            if (applyBPM) {
                if (thirdlevelbpmapplicable) {
                    landingdata.setThirdvalidationstatus(true);
                }
                String lastIndexVal = strWfIdAndBpmId;
                if (lastIndexVal.trim().contains("~")) {
                    String[] latColVal = lastIndexVal.trim().split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                } else {
                    WFID = "-";
                    bpmWFID = "";
                }
                logger.info("lndcbean","//==//==|WFID|==>" + WFID + "===|bpmWFID|==>" + bpmWFID);
                landingdata.setBpmwfid(bpmWFID);
                landingdata.setWfid(WFID);
                if (editedRowMap.get("tasksummaryvo") != null) {
                    TaskSummaryVo taskSummary = (TaskSummaryVo) editedRowMap.get("tasksummaryvo");
                    taskSummary = addBackupdetails(taskSummary);
                    landingdata.setTasksummary(taskSummary);
                }
                landingdata.setIsBPMEnabled(true);
            } else {
                landingdata.setTasksummary(null);
            }
            // landingdata.setReferenceNumber(refnofieldval);
            landingdata.setData(settingLandingDataList(editedRowMap));
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            } else {
                referenceNumber = "";
                landingdata.setReferenceNumber(refnofieldval);
            }

            logger.info("lndcbean","//==//==WFID VIEW IN LANDING PAGE=====" + WFID + "?? bpmWFID ??" + bpmWFID);
            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
        } catch (Exception e) {
            logger.info("lndcbean","exception in viewClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public void userlistGetterDefaultColumnModel() {
        try {
            ArrayList<Object> columnHeaders = new ArrayList<>();
            Set<Object> keySet = new HashSet<Object>();
            LinkedTreeMap<Object, Object> columnDefs = new LinkedTreeMap<>();
            LinkedTreeMap<Object, Object> innerColumnDefs = new LinkedTreeMap<>();
            List<DefaultColumnModel> columnlist = new ArrayList<>();
            DefaultColumnModel dfc = new DefaultColumnModel();
            dfc = new DefaultColumnModel();
            dfc.setHeaderName("User");
            dfc.setField("revoke");
            dfc.setCellRenderer("NBpmDataSetRenderer");
            columnlist.add(dfc);

            if (model.getDataModel().getnBPMconfig().containsKey("userlistGetter")) {
                columnDefs = (LinkedTreeMap) model.getDataModel().getnBPMconfig().get("userlistGetter");
                if (columnDefs.containsKey("columnDefs")) {
                    columnDefs = (LinkedTreeMap) columnDefs.get("columnDefs");
                    if (columnDefs.keySet() != null) {
                        keySet = columnDefs.keySet();
                        for (Object key : keySet) {
                            innerColumnDefs = (LinkedTreeMap) columnDefs.get(key);
                            dfc = new DefaultColumnModel();
                            dfc.setHeaderName(innerColumnDefs.get("displayname").toString());
                            dfc.setField("map." + key.toString());
                            dfc.setWidth(Integer.valueOf(200));
                            dfc.setDataType(DefaultColumnModel.DATATYPE_STRING);
                            columnlist.add(dfc);

                        }
                    }
                }
            }
            if (columnlist != null && !columnlist.isEmpty()) {
                model.getDataModel().setNonbpmcolumnlist(columnlist);
            }

        } catch (Exception e) {
            logger.info("lndcbean","---lndException " + e);
            e.printStackTrace();
        }

    }

    public void revokeRecallDialog() {
        try {
            this.dUtil.showDialog("LND", SMDialogUtil.type.CONF, "LND00006",
                    "#{LandingPageCBean.ctrl.revokeRecallDialogConfirm()}", null);
        } catch (Exception e) {
            // System.out.println("---tei---Exception " + e);
            e.printStackTrace();
        }
    }

    public void revokeRecallDialogConfirm() {
        try {
            String eventType = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance())
                    .getAttributes().get("eventType");
            if ("yes".equalsIgnoreCase(eventType)) {
                userlistGetter();
            }
        } catch (Exception e) {
            // System.out.println("---tei---Exception " + e);
            e.printStackTrace();
        }
    }

    public void userlistGetter() {
        try {
            LinkedTreeMap<Object, Object> apiConfig = new LinkedTreeMap<>();
            String vds = "";
            List resultSet = new ArrayList<Object>();
            Object obj = new Object();
            String json = "";
            SvmJsonObject svmJson = new SvmJsonObject();
            SvmJsonObject data = null;
            JSONObject response = null;
            String res = "";
            JSONObject lastRes = null;
            JSONArray userlist = null;
            int params = 0;
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                if (model.getDataModel().getnBPMconfig().containsKey("userlistGetter")) {
                    apiConfig = (LinkedTreeMap) model.getDataModel().getnBPMconfig().get("userlistGetter");
                    logger.info("lndcbean","---lnd---userlistgetter " + apiConfig);
                    if (apiConfig != null) {
                        if (apiConfig.containsKey("servicename")) {
                            vds = apiConfig.get("servicename").toString().trim();
                            // --
                            params = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
                                    .getRequestParameterMap().get("rowIndex"));
                            json = objectMapper.writeValueAsString(HmapList.get(params));
                            data = new SvmJsonObject(json);
                            svmJson.put("data", data);
                            svmJson.put("loginuser", mData.getMetaData(USERINFO.USERCODE));
                            svmJson.put("moduleid", this.model.getDataModel().getMdlId());
                            logger.info("lndcbean","---lnduserlistGetter svmJson " + svmJson);
                            // --
                            // Gson gson = new GsonBuilder().create();
                            // json = gson.toJson(apiConfig.get("inputjson"));
                            // svmJson = new SvmJsonObject(json);
                            response = new JSONObject(this.serviceInvoker.invokeHttpService(vds, "mac", svmJson));
                            logger.info("lndcbean","---lnduserlistGetter response " + response);
                            if (response.has("FUNRESPONSE")) {
                                res = response.get("FUNRESPONSE").toString();
                                lastRes = new JSONObject(res);
                                if (response.get("status").equals(200)) {
                                    if (lastRes.has("userlist")) {
                                        lastRes = new JSONObject(lastRes.getString("userlist"));
                                        userlist = lastRes.getJSONArray("data");
                                    } else {
                                        logger.info("lndcbean","---lndresponse has no userlist");
                                    }
                                } else {
                                    logger.info("lndcbean","---lndunable to invoke the provided API");
                                }
                            } else {
                                logger.info("lndcbean","---lndno apiConfig vlaue");
                            }

                            for (int i = 0; i < userlist.length(); i++) {
                                Object user = new Object();
                                user = userlist.get(i);
                                resultSet.add(user);
                            }
                            model.getDataModel().setNbpmheader(
                                    model.getDataModel().getnBPMconfig().get("header").toString().trim());
                            model.getDataModel().setNonbpmValuelist((ArrayList<String>) resultSet);
                            RequestContext.getCurrentInstance().execute("PF('nonbpm').show()");
                            RequestContext.getCurrentInstance().update("nonbpmrevokewidgetvar");
                        } else {
                            logger.info("lndcbean","---lndno servicename");
                        }
                    } else {
                        logger.info("lndcbean","---lndno apiConfig");
                    }
                } else {
                    logger.info("lndcbean","---lndno userlistGetter");
                }
            } catch (Exception e) {
                logger.info("lndcbean","---lnde " + e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            logger.info("lndcbean","---lndException " + e);
            e.printStackTrace();
        }
    }

    public void userSetter() {
        try {
            LinkedTreeMap<Object, Object> apiConfig = new LinkedTreeMap<>();
            String vds = "";
            JSONObject response = null;
            String res = "";
            SvmJsonObject svmJson = new SvmJsonObject();
            SvmJsonObject data = null;
            String json = "";
            if (model.getDataModel().getnBPMconfig().containsKey("userSetter")) {
                apiConfig = (LinkedTreeMap) model.getDataModel().getnBPMconfig().get("userSetter");
                logger.info("lndcbean","---lnduserSetter " + apiConfig);
                Gson gson = new GsonBuilder().create();
                json = gson.toJson(apiConfig.get("data"));
                ObjectMapper objectMapper = new ObjectMapper();
                if (apiConfig != null) {
                    if (apiConfig.containsKey("servicename")) {
                        vds = apiConfig.get("servicename").toString().trim();
                        Map rowdata = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                        data = new SvmJsonObject(rowdata.get("rowFilterValue").toString());
                        svmJson.put("data", data);
                        svmJson.put("loginuser", mData.getMetaData(USERINFO.USERCODE));
                        svmJson.put("moduleid", this.model.getDataModel().getMdlId());
                        logger.info("lndcbean","---lnduserSetter svmsjson " + svmJson);
                        response = new JSONObject(this.serviceInvoker.invokeHttpService(vds, "mac", svmJson));
                        logger.info("lndcbean","---lnduserSetter response " + response);
                        if (response.has("FUNRESPONSE")) {
                            res = response.get("FUNRESPONSE").toString();
                            if (!res.contains("200")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("", "Unable to process the request."));
                            } else {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("", "Successfully Revoked/Recalled."));
                            }
                            RequestContext.getCurrentInstance().execute("PF('nonbpm').hide();");
                            RequestContext.getCurrentInstance().update("landingPageForm");
                        } else {
                            logger.info("lndcbean","---lndSecond API is not configured");
                        }
                    }

                }
            }

        } catch (Exception e) {
            logger.info("lndcbean","---lndException " + e);
            e.printStackTrace();
        }

    }

    public void callNonBPMRecall() {
        try {
            LinkedTreeMap<Object, Object> apiConfig = new LinkedTreeMap<>();
            String vds = "";
            JSONObject response = null;
            String res = "";
            SvmJsonObject svmJson = new SvmJsonObject();
            SvmJsonObject data = null;
            String json = "";
            if (model.getDataModel().getnBPMconfigrecall().containsKey("userSetter")) {
                apiConfig = (LinkedTreeMap) model.getDataModel().getnBPMconfigrecall().get("userSetter");
                logger.info("lndcbean","---lnduserSetter " + apiConfig);
                Gson gson = new GsonBuilder().create();
                json = gson.toJson(apiConfig.get("data"));
                ObjectMapper objectMapper = new ObjectMapper();
                if (apiConfig != null) {
                    if (apiConfig.containsKey("servicename")) {
                        vds = apiConfig.get("servicename").toString().trim();
                        int iRowIndex = getRowIndex();
                        logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex);
                        Map editedRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
                        // Map rowdata =
                        // FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                        // data = new SvmJsonObject(rowdata.get("rowFilterValue").toString());
                        logger.info("lndcbean","//==//==|editedRowMap|==>" + editedRowMap);
                        data = new SvmJsonObject(json);
                        svmJson.put("data", data);
                        svmJson.put("loginuser", mData.getMetaData(USERINFO.USERCODE));
                        svmJson.put("moduleid", this.model.getDataModel().getMdlId());
                        logger.info("lndcbean","---lnduserSetter svmsjson " + svmJson);
                        response = new JSONObject(this.serviceInvoker.invokeHttpService(vds, "mac", svmJson));
                        logger.info("lndcbean","---lnduserSetter response " + response);
                        if (response.has("FUNRESPONSE")) {
                            res = response.get("FUNRESPONSE").toString();
                            if (!res.contains("200")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("", "Unable to process the request."));
                            } else {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("", "Successfully Revoked/Recalled."));
                            }
                            RequestContext.getCurrentInstance().execute("PF('nonbpm').hide();");
                            RequestContext.getCurrentInstance().update("landingPageForm");
                        } else {
                            logger.info("lndcbean","---lndSecond API is not configured");
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.info("lndcbean","---lndException " + e);
            e.printStackTrace();
        }

    }

    public void newtabviewClicked() {
        logger.info("lndcbean","Inside newtabviewClicked>>>>>");
        // ArrayList lstToView = null;
        LandingDataVo landingdata = new LandingDataVo();
        String refnofieldval = "";
        String strWfIdAndBpmId = "-";
        boolean thirdlevelbpmapplicable = false;
        boolean isSuperEditorNewTab = false;

        try {
            logger.info("lndcbean","//==//==|View Clicked statusdescindex|==>" + statusdescindex);
            int iRowIndex = getRowIndex();
            logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex);

            Map editedRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            logger.info("lndcbean","//==//==|editedRowMap In viewClicked()==>" + editedRowMap);
            refnofieldval = getValuesFromEditedRowMap("strRefNoFieldValue", editedRowMap);
            strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails", editedRowMap);
            if (editedRowMap.containsKey("thirdlevelbpmapplicablerows")
                    && editedRowMap.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true")) {
                thirdlevelbpmapplicable = true;
            }
            // landingdata.setReferenceNumber(refnofieldval);
            if (superEditorList != null) {
                for (Mdl_super_user msu : superEditorList) {
                    if (msu.getUsercode().equalsIgnoreCase(mData.getMetaData(USERINFO.USERCODE))) {
                        // landingdata.setSuperEditor(true);
                        isSuperEditorNewTab = true;
                        break;
                    } else {
                        // landingdata.setSuperEditor(false);
                        isSuperEditorNewTab = false;
                    }
                }
            }
            logger.info("lndcbean","---lndnewtabviewclicked isSuperEditorNewTab " + isSuperEditorNewTab);
            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            if (applyBPM) {
                if (thirdlevelbpmapplicable) {
                    landingdata.setThirdvalidationstatus(true);
                }
                String lastIndexVal = strWfIdAndBpmId;
                if (lastIndexVal.trim().contains("~")) {
                    String[] latColVal = lastIndexVal.trim().split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                } else if (WFID != null && isSuperEditorNewTab) {
                    logger.info("lndcbean","---lnd--wfid will remain same");
                } else {
                    WFID = "-";
                    bpmWFID = "";
                }
                logger.info("lndcbean","//==//==|WFID|==>" + WFID + "===|bpmWFID|==>" + bpmWFID);
                landingdata.setBpmwfid(bpmWFID);
                landingdata.setWfid(WFID);
                if (editedRowMap.get("tasksummaryvo") != null) {
                    TaskSummaryVo taskSummary = (TaskSummaryVo) editedRowMap.get("tasksummaryvo");
                    taskSummary = addBackupdetails(taskSummary);
                    if (isSuperEditorNewTab) {
                        taskSummary.setSuperEditor(true);
                    } else {
                        taskSummary.setSuperEditor(false);
                    }
                    landingdata.setTasksummary(taskSummary);
                    logger.info("lndcbean","---lndnew tab tasksummary super editor " + taskSummary.isSuperEditor());
                }
                landingdata.setIsBPMEnabled(true);
            } else {
                landingdata.setTasksummary(null);
            }

            landingdata.setData(settingLandingDataList(editedRowMap));
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            } else {
                referenceNumber = "";
                landingdata.setReferenceNumber(refnofieldval);
            }

            logger.info("lndcbean","//==//==WFID VIEW IN LANDING PAGE=====" + WFID + "?? bpmWFID ??" + bpmWFID);
            if (isSuperEditorNewTab) {
                landingdata.setSuperEditor(true);
            } else {
                landingdata.setSuperEditor(false);
            }
            
            landingdata = powerEditChecker(landingdata);
            logger.info("lndcbean","---lndopen in new tab " + landingdata.isSuperEditor() + " Poweredit "
                    + landingdata.isPowerEditor());
            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
        } catch (Exception e) {
            logger.info("lndcbean","exception in viewClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    // New TAb
    public void newtabviewClickedold() { // ************* Action View Clicked Started ****************
        LandingDataVo landingdata = new LandingDataVo();
        boolean rarEditRights = false;
        TaskSummaryVo taskSummary = new TaskSummaryVo();
        String refnofieldval = "";
        List lstselected = null;
        boolean isEditable = false;
        boolean isEdit = false;
        ClaimRights claimRights;

        boolean thirdlevelbpmapplicable = false;
        try {
            int iRowIndex = getRowIndex();
            Map editedRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            model.getDataModel().setSelectedRowMap(editedRowMap);
            // logger.info("lndcbean","Selected row in navigateToModule==>" +
            // model.getDataModel().getTmpSelectedRow());
            lstselected = settingLandingDataList(editedRowMap);
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            } else {
                referenceNumber = "";
                landingdata.setReferenceNumber(refnofieldval);
            }

            // lstToView = model.getDataModel().getTmpSelectedRow();
            landingdata.setData(lstselected);
            if (model.getDataModel().getSelectedRowMap().containsKey("btnEditRenderInHm") && model.getDataModel()
                    .getSelectedRowMap().get("btnEditRenderInHm").toString().equalsIgnoreCase("Yes")) {
                isEditable = true;

            }
            // commented as per capt.Ritesh comment that in new tab, form should be opened
            // in View mode
            // if (!isEditable) {
            // landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            // landingdata.setIsDynamicMdl(isDynamicMdl);
            // refnofieldval =
            // model.getDataModel().getSelectedRowMap().get(refnofieldwithoutdot).toString();
            // } else {
            // landingdata.setAction(LandingDataVo.LandingAction.EDIT);
            // isEdit = true;
            // refnofieldval =
            // model.getDataModel().getSelectedRowMap().get(refnofieldwithoutdot).toString();
            // if
            // (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
            // &&
            // model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true"))
            // {
            // landingdata.setThirdvalidationstatus(true);
            // }
            // }

            landingdata.setAction(LandingDataVo.LandingAction.VIEW);

            refnofieldval = model.getDataModel().getSelectedRowMap().get(refnofieldwithoutdot).toString();
            // landingdata.setReferenceNumber(refnofieldval);
            if (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                    && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                            .equalsIgnoreCase("true")) {
                landingdata.setThirdvalidationstatus(true);
            }
            boolean checkthirlevel = true;
            if (isEditable) {
                if (applyBPM) {
                    if (model.getDataModel().getSelectedRowMap().containsKey("tasksummaryvo")
                            && model.getDataModel().getSelectedRowMap().get("tasksummaryvo") != null) {
                        taskSummary = (TaskSummaryVo) model.getDataModel().getSelectedRowMap().get("tasksummaryvo");
                        landingdata.setTasksummary(taskSummary);
                        landingdata.setIsBPMEnabled(true);
                        landingdata.setWfid(WFID);
                    }
                    String strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails",
                            model.getDataModel().getSelectedRowMap());
                    String[] latColVal = strWfIdAndBpmId.split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                    logger.info("lndcbean","bpmWFID ??? in Double CLICKED ??????????? " + bpmWFID + "?? WFID ??" + WFID);
                    landingdata.setBpmwfid(bpmWFID);
                    landingdata.setWfid(WFID);
                    landingdata.setIsBPMEnabled(true);

                    if (!rarEditRights) {
                        claimRights = smbpmUtil.hasClaimRights(model.getDataModel().getMdlId().trim(),
                                mData.getMetaData(APPINFO.COMPANY_CODE),
                                WFID, taskSummary.getCode(), WFType, taskSummary.getNodeid(),
                                mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                        rarEditRights = claimRights.isHasRights();
                        if (!rarEditRights) {
                            claimRights = smbpmUtil.hasClaimRightsDynamic(model.getDataModel().getMdlId().trim(),
                                    mData.getMetaData(APPINFO.COMPANY_CODE),
                                    WFID, taskSummary.getCode(), WFType, taskSummary.getNodeid(),
                                    mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                            rarEditRights = claimRights.isHasRights();
                        }
                    }
                    logger.info("lndcbean","navigateToModule :: Final rarEditRights >> " + rarEditRights);
                    if (rarEditRights) {

                        checkthirlevel = false;
                        StatusVo claimStatus = smbpmUtil.claimTask(taskSummary,
                                mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());

                        landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
                        landingdata.setStatus(claimStatus.getStatus());

                        if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS
                                || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED) {
                            taskSummary = claimStatus.getTaskSummaryVo();
                            taskSummary = addBackupdetails(taskSummary);
                            landingdata.setTasksummary(taskSummary);
                            landingdata.setReferenceNumber(refnofieldval);
                            landingdata.setData(lstselected);

                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false,
                                    true);
                        } else {
                            checkthirlevel = true;
                        }
                    } else {
                        checkthirlevel = true;
                    }
                } else {
                    checkthirlevel = true;
                }
            } else {
                if (applyBPM) {
                    String strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails",
                            model.getDataModel().getSelectedRowMap());
                    String[] latColVal = strWfIdAndBpmId.split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                    if (thirdlevelbpmapplicablerows != null && thirdlevelbpmapplicablerows.contains(lstselected)) { // added
                                                                                                                    // by
                                                                                                                    // vinothini.r
                        landingdata.setThirdvalidationstatus(true);
                    }
                    landingdata.setBpmwfid(bpmWFID);
                    landingdata.setWfid(WFID);
                    if (model.getDataModel().getSelectedRowMap().containsKey("tasksummaryvo")
                            && model.getDataModel().getSelectedRowMap().get("tasksummaryvo") != null) {
                        taskSummary = (TaskSummaryVo) model.getDataModel().getSelectedRowMap().get("tasksummaryvo");
                        taskSummary = addBackupdetails(taskSummary);
                        landingdata.setTasksummary(taskSummary);
                    }
                    landingdata.setIsBPMEnabled(true);
                } else {
                    landingdata.setTasksummary(null);
                    if (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                            && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                                    .equalsIgnoreCase("true")) { // added by vinothini.r
                        landingdata.setThirdvalidationstatus(true);
                    }
                }
                landingdata.setReferenceNumber(refnofieldval);
                landingdata.setData(lstselected);
                logger.info("lndcbean","WFID VIEW IN LANDING PAGE on double click=====" + WFID + "?? bpmWFID ??" + bpmWFID);

                logger.info("lndcbean","lstToView in View on double clicked ??" + lstselected);
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
            }

            if (checkthirlevel && model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                    && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                            .equalsIgnoreCase("true")) {

                landingdata.setTasksummary(null);
                landingdata.setWfid(null);
                landingdata.setThirdvalidationstatus(true);
                if (landingPageDatasHm.get("refnofield") != null) {
                    landingdata.setReferenceNumber(refnofieldval);
                    landingdata.setData(lstselected);

                } else {
                    landingdata.setReferenceNumber(refnofieldval);
                    landingdata.setData(lstselected);
                }
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);

            }

            logger.info("lndcbean","==WFID====WFID>" + WFID);
            logger.info("lndcbean","==bpmWFID====bpmWFID>" + bpmWFID);

            //
            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
        } catch (Exception e) {
            logger.fatal(e);
            // explog.setExceptionlog("LND", model.getDataModel().getMdlId(),
            // mData.getMetaData(APPINFO.COMPANY_CODE), PROJECTTYPE, e);
            // logger.info("lndcbean","exception in viewClicked ==>" + e.getMessage());
            // logger.fatal(e);
        }
    }

    // {tempfinal_sas.selfassessmentmatrix={view={targetmdl=SDM,
    // navigateflag=false}},
    // tempfinal_sas.selfassessmentdeclraration={view={targetmdl=SDF,
    // navigateflag=false}}
    // }}
    public void processGroupbtnHeaders() {
        try {
            groupbuttonHeadersdotreplaced = new LinkedTreeMap();

            Iterator itrgrpbtn = groupbuttonHeaders.keySet().iterator();

            while (itrgrpbtn.hasNext()) {
                String key = itrgrpbtn.next().toString();
                String chkcolumn = key.replaceAll("\\.", "");
                LinkedTreeMap columnPropHmgrpbtn = (LinkedTreeMap) groupbuttonHeaders.get(key);
                groupbuttonHeadersdotreplaced.put(chkcolumn, columnPropHmgrpbtn);
            }
            logger.info("lndcbean","groupbuttonHeadersdotreplaced====" + groupbuttonHeadersdotreplaced);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateNewColumnClicked() {
        logger.info("lndcbean","navigateNewColumnClicked>>>>>>>>");
        ArrayList lstToNew = null;
        boolean navigatefalgbool;
        String refnofieldval = "";
        try {

            Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String param1 = (String) params.get("rowIndex");
            int iRowIndex = Integer.parseInt(param1);
            navigatefalgbool = newnavigateflag1;
            List landingDataList = new ArrayList();
            String key = null;
            Map newRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            logger.info("lndcbean","//==//==|RowMap In navigateNewColumnClicked()==>" + newRowMap);
            refnofieldval = getValuesFromEditedRowMap("strRefNoFieldValue", newRowMap);

            for (int i = 0; i < tmpColHeaderNamesLstwithoutdot.size(); i++) {
                key = (String) tmpColHeaderNamesLstwithoutdot.get(i);
                if (newRowMap.get(key) == null) {
                    landingDataList.add("");
                } else {
                    landingDataList.add(newRowMap.get(key).toString());
                }
            }
            if (applyBPM) {
                if (newRowMap.get("tasksummaryvo") != null) {
                    landingDataList.add(newRowMap.get("bpmdetails"));
                } else {
                    landingDataList.add("-");
                }
            }
            logger.info("lndcbean","===landingDataList==>" + landingDataList);
            if (applyBPM) {
                StatusVo initStatus = new StatusVo();
                LandingDataVo landingdata = new LandingDataVo();
                landingdata.setReferenceNumber(refnofieldval);
                landingdata.setData(landingDataList);
                landingdata.setIsBPMEnabled(true);
                landingdata.setAction(LandingDataVo.LandingAction.NAVIGATENEW);
                landingdata.setTasksummary(new TaskSummaryVo());
                landingdata.setWfid(formCreationWFID);
                landingdata.setBpmwfid(bpmWFID);
                landingdata.setIsDynamicMdl(isDynamicMdl);
                landingdata.setPowerEditor(false);
                landingdata.setPowerEditorType(null);
                if (!isDynamicMdl) {
                    initStatus = smbpmUtil.hasRightsToIntiateProcess(model.getDataModel().getMdlId(),
                            mData.getMetaData(APPINFO.COMPANY_CODE),
                            formCreationWFID, mData.getMetaData(USERINFO.USERCODE).trim(), wfCode, "V");
                    if (initStatus.getStatus() == StatusVo.STATUS.SUCCESS) {
                        if (name != null && name.equalsIgnoreCase("parent")) {
                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata,
                                    navigatefalgbool);
                        } else {
                            NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata, false,
                                    navigatefalgbool);
                        }
                    } else {
                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                    }
                } else {
                    if (name != null && name.equalsIgnoreCase("parent")) {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata,
                                navigatefalgbool);
                    } else {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata, false,
                                navigatefalgbool);
                    }
                }

            } else {
                LandingDataVo landingdata = new LandingDataVo();
                logger.info("lndcbean","====newRowMap==2==>>" + newRowMap);
                landingdata.setReferenceNumber(refnofieldval);
                landingdata.setData(landingDataList);
                landingdata.setAction(LandingDataVo.LandingAction.NEW);
                landingdata.setTasksummary(null);
                landingdata.setWfid(null);
                landingdata.setPowerEditor(false);
                landingdata.setPowerEditorType(null);
                if (name != null && name.equalsIgnoreCase("parent")) {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata, navigatefalgbool);
                } else {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), newtargetmdl1, landingdata, false,
                            navigatefalgbool);
                }
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in navigateNewColumnClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    public void navigateViewColumnClicked() {
        logger.info("lndcbean","navigateViewColumnClicked====>");
        int index = 0;
        String mdlcode = "";
        LinkedTreeMap allvalue = null;
        LinkedTreeMap viewallvalue = null;
        ArrayList lstToView = null;
        LandingDataVo landingdata = new LandingDataVo();
        boolean navigateflag;
        String refnofieldval = "";
        try {
            logger.info("lndcbean","//==//==|navigateViewColumnClicked  statusdescindex|==>" + statusdescindex);

            Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String param1 = (String) params.get("rowIndex");
            int iRowIndex = Integer.parseInt(param1);
            String Currentcolname = (String) params.get("colname");
            processGroupbtnHeaders();
            logger.info("lndcbean","Currentcolname===========" + Currentcolname);
            logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex + "=======>>>" + viewbtnlist);
            logger.info("lndcbean","groupbuttonHeaders=====" + groupbuttonHeadersdotreplaced);
            model.getStateModel().setCommandlinkrender(true);
            if (groupbuttonHeadersdotreplaced.containsKey(Currentcolname)) {
                allvalue = (LinkedTreeMap) groupbuttonHeadersdotreplaced.get(Currentcolname);
                if (allvalue.containsKey("view")) {
                    viewallvalue = (LinkedTreeMap) allvalue.get("view");
                    mdlcode = (String) viewallvalue.get("targetmdl");

                    Map viewRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
                    logger.info("lndcbean","//==//==|RowMap In navigateviewClicked()==>" + viewRowMap);
                    refnofieldval = getValuesFromEditedRowMap("strRefNoFieldValue", viewRowMap);

                    String strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails", viewRowMap);

                    landingdata.setAction(LandingDataVo.LandingAction.NAVIGATEVIEW);
                    landingdata.setIsDynamicMdl(isDynamicMdl);
                    if (applyBPM) {
                        String lastIndexVal = strWfIdAndBpmId;
                        if (lastIndexVal.trim().contains("~")) {
                            String[] latColVal = lastIndexVal.trim().split("~");
                            if (latColVal != null && latColVal.length == 2) {
                                WFID = latColVal[0].trim();
                                bpmWFID = latColVal[1].trim();
                            }
                        } else {
                            WFID = "-";
                            bpmWFID = "";
                        }
                        logger.info("lndcbean","//==//==|WFID|==>" + WFID + "===|bpmWFID|==>" + bpmWFID);
                        landingdata.setBpmwfid(bpmWFID);
                        landingdata.setWfid(WFID);
                        if (viewRowMap.get("tasksummaryvo") != null) {
                            TaskSummaryVo taskSummary = (TaskSummaryVo) viewRowMap.get("tasksummaryvo");
                            landingdata.setTasksummary(taskSummary);
                        }
                        landingdata.setIsBPMEnabled(true);
                    } else {
                        landingdata.setTasksummary(null);
                    }
                    landingdata.setData(settingLandingDataList(viewRowMap));
                    if (referenceNumber != null && !referenceNumber.isEmpty()) {
                        landingdata.setReferenceNumber(referenceNumber);
                        referenceNumber = "";
                    } else {
                        referenceNumber = "";
                        landingdata.setReferenceNumber(refnofieldval);
                    }

                    if (viewallvalue.containsKey("navigateflag")) {
                        navigateflag = (boolean) viewallvalue.get("navigateflag");
                    } else {
                        navigateflag = false;
                    }
                    logger.info("lndcbean","====Navigating from view=====");
                    if (name != null && name.equalsIgnoreCase("parent")) {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata, navigateflag);
                    } else {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), mdlcode, landingdata, false, navigateflag);
                    }
                    // RequestContext.getCurrentInstance().update("landingPageForm");
                }
            }

            // RequestContext.getCurrentInstance().update("landingPageForm");
        } catch (Exception e) {
            logger.info("lndcbean","exception in navigateViewColumnClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }
    // VIEW

    public void viewClicked() { // ************* Action View Clicked Started ****************
        logger.info("lndcbean","Inside viewClicked>>>>>");
        // ArrayList lstToView = null;
        LandingDataVo landingdata = new LandingDataVo();
        String refnofieldval = "";

        String strWfIdAndBpmId = "-";
        boolean thirdlevelbpmapplicable = false;
        boolean isSuperEditorViewClicked = false;

        try {

            viewlist = (List) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("DashboardModelMenuDetails") != null
                            ? (List) FacesContext.getCurrentInstance().getExternalContext()
                                    .getSessionMap().get("DashboardModelMenuDetails")
                            : new ArrayList<>();
            if (viewlist != null && !viewlist.isEmpty()) {
                List viewresult = viewlist.stream()
                        .filter(line -> model.getDataModel().getMdlId().equalsIgnoreCase(line.getModuleid())
                                && "Y".equalsIgnoreCase(line.getViewModeEnable()))
                        .collect(Collectors.toList());
                // System.out.println("lnd target moduleid" + model.getDataModel().getMdlId() +
                // ">> viewEyeRender >>>" + viewresult.toString());
                if (viewresult != null && !viewresult.isEmpty() && this.name != null && this.name.equalsIgnoreCase("parent")) {
                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
                    RequestContext.getCurrentInstance().execute("toggleViewMode();");
                }
            }

            logger.info("lndcbean","//==//==|View Clicked statusdescindex|==>" + statusdescindex);
            int iRowIndex = getRowIndex();
            logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex);

            Map editedRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            logger.info("lndcbean","//==//==|editedRowMap In viewClicked()==>" + editedRowMap);
            refnofieldval = getValuesFromEditedRowMap("strRefNoFieldValue", editedRowMap);
            strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails", editedRowMap);
            if (editedRowMap.containsKey("thirdlevelbpmapplicablerows")
                    && editedRowMap.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true")) {
                thirdlevelbpmapplicable = true;
            }
            if (superEditorList != null) {
                for (Mdl_super_user msu : superEditorList) {
                    if (msu.getUsercode().equalsIgnoreCase(mData.getMetaData(USERINFO.USERCODE))) {
                        // landingdata.setSuperEditor(true);
                        isSuperEditorViewClicked = true;
                        break;
                    } else {
                        // landingdata.setSuperEditor(false);
                        isSuperEditorViewClicked = false;
                    }
                }
            }
            logger.info("lndcbean","---lndviewclicked isSuperEditorViewClicked " + isSuperEditorViewClicked);

            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            if (applyBPM) {
                if (thirdlevelbpmapplicable) {
                    landingdata.setThirdvalidationstatus(true);
                }
                String lastIndexVal = strWfIdAndBpmId;
                if (lastIndexVal.trim().contains("~")) {
                    String[] latColVal = lastIndexVal.trim().split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                } else {
                    WFID = "-";
                    bpmWFID = "";
                }
                logger.info("lndcbean","//==//==|WFID|==>" + WFID + "===|bpmWFID|==>" + bpmWFID);
                landingdata.setBpmwfid(bpmWFID);
                landingdata.setWfid(WFID);
                if (editedRowMap.get("tasksummaryvo") != null) {
                    TaskSummaryVo taskSummary = (TaskSummaryVo) editedRowMap.get("tasksummaryvo");
                    taskSummary = addBackupdetails(taskSummary);
                    if (isSuperEditorViewClicked) {
                        taskSummary.setSuperEditor(true);
                    } else {
                        taskSummary.setSuperEditor(false);
                    }
                    landingdata.setTasksummary(taskSummary);
                    logger.info("lndcbean","---lndviewclicked tasksummary supereditor " + taskSummary.isSuperEditor());
                }
                landingdata.setIsBPMEnabled(true);
            } else {
                landingdata.setTasksummary(null);
            }

            landingdata.setData(settingLandingDataList(editedRowMap));
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            } else {
                referenceNumber = "";
                landingdata.setReferenceNumber(refnofieldval);
            }

            logger.info("lndcbean","//==//==WFID VIEW IN LANDING PAGE=====" + WFID + "?? bpmWFID ??" + bpmWFID);
            if (isSuperEditorViewClicked) {
                landingdata.setSuperEditor(true);
            } else {
                landingdata.setSuperEditor(false);
            }

            logger.info("lndcbean","---lnd---viewclicked landingdata supereditor " + landingdata.isSuperEditor());
            landingdata = powerEditChecker(landingdata);
            logger.info("lndcbean","---lnd---powerEditChecker " + landingdata.isPowerEditor() + landingdata.getPowerEditorType());
            if (name != null && name.equalsIgnoreCase("parent")) {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
            } else {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
            }
        } catch (Exception e) {
            logger.info("lndcbean","exception in viewClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }
    // ************* Action View Clicked End ****************
    // EDIT

    public void superEditorDialog() {
        try {
            List<String> superUsers = new ArrayList<>();
            for (Mdl_super_user str : superEditorList) {
                superUsers.add(str.getUsercode());
            }
            // this.onDemandRowIndex = getRowIndex();
            setOnDemandRowIndex(getRowIndex());
            isSuperEditorRowIndex = true;
            if (superUsers.contains(this.mData.getMetaData(USERINFO.USERCODE))) {
                this.dUtil.showDialog("LND", SMDialogUtil.type.CONF, "LND00008",
                        "#{LandingPageCBean.ctrl.superEditorDialogConfirm()}", null);
            } else {
                editClicked();
            }
        } catch (Exception e) {
            // System.out.println("---tei---Exception " + e);
            e.printStackTrace();
        }
    }

    public void superEditorDialogConfirm() {
        try {
            String eventType = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance())
                    .getAttributes().get("eventType");
            if ("Yes".equalsIgnoreCase(eventType)) {
                RequestContext.getCurrentInstance().execute("showLNDGlassPane()");
                editClicked();
            }
        } catch (Exception e) {
            // System.out.println("---tei---Exception " + e);
            e.printStackTrace();
        }
    }

    public void editClicked() { // ************* Action Edit Clicked Started ****************
        logger.info("lndcbean","Inside editClicked>>>>>");
        LandingDataVo landingdata = new LandingDataVo();
        boolean rarEditRights = false;
        boolean superEditRights = false;
        String refnofieldval = "";
        ClaimRights claimRights;
        String strWfIdAndBpmId = "-";
        boolean thirdlevelbpmapplicable = false;

        try {
            viewlist = (List) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("DashboardModelMenuDetails") != null
                            ? (List) FacesContext.getCurrentInstance().getExternalContext()
                                    .getSessionMap().get("DashboardModelMenuDetails")
                            : new ArrayList<>();
            if (viewlist != null && !viewlist.isEmpty()) {
                List viewresult = viewlist.stream()
                        .filter(line -> model.getDataModel().getMdlId().equalsIgnoreCase(line.getModuleid())
                                && "Y".equalsIgnoreCase(line.getViewModeEnable()))
                        .collect(Collectors.toList());
                // System.out.println("lnd target moduleid" + model.getDataModel().getMdlId() +
                // ">> viewEyeRender >>>" + viewresult.toString());
                if (viewresult != null && !viewresult.isEmpty() && this.name != null && this.name.equalsIgnoreCase("parent")) {
                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
                    RequestContext.getCurrentInstance().execute("toggleEditMode();");

                }
            }

            int iRowIndex = 0;
            // RequestContext.getCurrentInstance().execute("showLNDGlassPane()");
            if (isSuperEditorRowIndex) {
                iRowIndex = getOnDemandRowIndex();
            } else {
                iRowIndex = getRowIndex();
            }
            isSuperEditorRowIndex = false;

            // iRowIndex = getOnDemandRowIndex();
            // if(getOnDemandRowIndex() == null){
            //
            // }
            logger.info("lndcbean","//==//==|iRowIndex|==>" + iRowIndex);
            Map editedRowMap = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            try {
                TaskSummaryVo taskSummaryVo = (TaskSummaryVo) editedRowMap.get("tasksummaryvo");
            } catch (Exception e) {
                logger.info("lndcbean","---lndException " + e);
                e.printStackTrace();
            }

            refnofieldval = getValuesFromEditedRowMap(refnofieldwithoutdot, editedRowMap);
            strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails", editedRowMap);
            // thirdlevelbpmapplicable =
            // editedRowMap.containsKey("thirdlevelbpmapplicablerows");
            if (editedRowMap.containsKey("thirdlevelbpmapplicablerows")
                    && editedRowMap.get("thirdlevelbpmapplicablerows").toString().equalsIgnoreCase("true")) {
                thirdlevelbpmapplicable = true;
            }
            TaskSummaryVo taskSummary = new TaskSummaryVo();
            landingdata.setAction(LandingDataVo.LandingAction.EDIT);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            landingdata.setThirdvalidationstatus(false);
            if (applyBPM) {
                if (thirdlevelbpmapplicable) {
                    landingdata.setTasksummary(null);
                    landingdata.setWfid(null);
                    landingdata.setThirdvalidationstatus(true);
                    // landingdata.setReferenceNumber(refnofieldval);
                    landingdata.setData(settingLandingDataList(editedRowMap));
                    if (referenceNumber != null && !referenceNumber.isEmpty()) {
                        landingdata.setReferenceNumber(referenceNumber);
                        referenceNumber = "";
                    } else {
                        referenceNumber = "";
                        landingdata.setReferenceNumber(refnofieldval);
                    }
                    landingdata.setPowerEditor(false);
                    landingdata.setPowerEditorType(null);
                    logger.info("lndcbean","---lnd---editclicked 1 " + landingdata.isSuperEditor() + landingdata.isPowerEditor()
                            + landingdata.getPowerEditorType());

                    if (name != null && name.equalsIgnoreCase("parent")) {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                    } else {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                    }
                } else {
                    if (editedRowMap.get("tasksummaryvo") != null) {
                        taskSummary = (TaskSummaryVo) editedRowMap.get("tasksummaryvo");
                        logger.info("lndcbean","//==//==|taskSummary**|==>" + taskSummary);
                    }

                    String[] latColVal = strWfIdAndBpmId.split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                    logger.info("lndcbean","//==//==|bpmWFID ??? in EDIT CLICKED ??????????? " + bpmWFID + "?? WFID ??" + WFID);
                    landingdata.setBpmwfid(bpmWFID);
                    landingdata.setWfid(WFID);
                    landingdata.setIsBPMEnabled(true);
                    logger.info("lndcbean","//==//==|rarEditRights*****|==>" + rarEditRights);
                    if (!rarEditRights) {

                        claimRights = smbpmUtil.hasClaimRights(model.getDataModel().getMdlId().trim(),
                                mData.getMetaData(APPINFO.COMPANY_CODE),
                                WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                        rarEditRights = claimRights.isHasRights();
                        if (!rarEditRights) {
                            claimRights = smbpmUtil.hasClaimRightsDynamic(model.getDataModel().getMdlId().trim(),
                                    mData.getMetaData(APPINFO.COMPANY_CODE),
                                    WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                    mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                            rarEditRights = claimRights.isHasRights();
                        }
                        // Super Editor NFR-1981
                        if (!rarEditRights) {
                            if (superEditorList != null) {
                                for (Mdl_super_user msu : superEditorList) {
                                    if (msu.getUsercode().equalsIgnoreCase(mData.getMetaData(USERINFO.USERCODE))) {
                                        superEditRights = true;
                                        rarEditRights = true;
                                    }
                                }
                            }
                        }

                    }
                    logger.info("lndcbean","==editClicked :: Final rarEditRights===>" + rarEditRights);
                    if (rarEditRights) {
                        taskSummary = addBackupdetails(taskSummary);
                        StatusVo claimStatus = smbpmUtil.claimTask(taskSummary,
                                mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());
                        if (superEditRights) {
                            landingdata.setCreateWFHistory(true);
                            landingdata.setStatus(StatusVo.STATUS.SUCCESS);
                        } else {
                            landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
                            landingdata.setStatus(claimStatus.getStatus());
                        }
                        // landingdata.setStatus(claimStatus.getStatus());
                        if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS
                                || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED || superEditRights) {
                            // Super Editor NFR-1981
                            if (superEditRights) {
                                landingdata.setSuperEditor(true);
                                StatusVo newtaskSummary = smbpmUtil.getTaskSummaryByRefno(refnofieldval);
                                taskSummary = newtaskSummary.getTaskSummaryVo();
                                taskSummary.setSuperEditor(true);
                            } else {
                                taskSummary = claimStatus.getTaskSummaryVo();
                                landingdata.setSuperEditor(false);
                                taskSummary.setSuperEditor(false);
                            }

                            landingdata.setTasksummary(taskSummary);
                            // landingdata.setReferenceNumber(refnofieldval);
                            landingdata.setData(settingLandingDataList(editedRowMap));
                            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                                landingdata.setReferenceNumber(referenceNumber);
                                referenceNumber = "";
                            } else {
                                referenceNumber = "";
                                landingdata.setReferenceNumber(refnofieldval);
                            }
                            landingdata.setPowerEditor(false);
                            landingdata.setPowerEditorType(null);
                            logger.info("lndcbean","---lnd---editclicked 2 " + landingdata.isSuperEditor()
                                    + landingdata.isPowerEditor() + landingdata.getPowerEditorType());

                            if (name != null && name.equalsIgnoreCase("parent")) {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                            } else {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false,
                                        true);
                            }
                        } else {
                            dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
                        }
                    } else {
                        dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105006", "", null);
                    }
                }
            } else {
                landingdata.setTasksummary(null);
                landingdata.setWfid(null);
                if (refnofield != null && refnofield.trim().length() > 0) {
                    // landingdata.setReferenceNumber(refnofieldval);
                    landingdata.setData(settingLandingDataList(editedRowMap));

                } else {
                    // landingdata.setReferenceNumber(refnofieldval);
                    landingdata.setData(settingLandingDataList(editedRowMap));
                }
                if (referenceNumber != null && !referenceNumber.isEmpty()) {
                    landingdata.setReferenceNumber(referenceNumber);
                    referenceNumber = "";
                } else {
                    referenceNumber = "";
                    landingdata.setReferenceNumber(refnofieldval);
                }
                if (superEditorList != null) {
                    for (Mdl_super_user msu : superEditorList) {
                        if (msu.getUsercode().equalsIgnoreCase(mData.getMetaData(USERINFO.USERCODE))) {
                            landingdata.setSuperEditor(true);
                            break;
                        } else {
                            landingdata.setSuperEditor(false);
                        }
                    }
                }

                landingdata.setPowerEditor(false);
                landingdata.setPowerEditorType(null);
                logger.info("lndcbean","---lnd---editclicked 3 " + landingdata.isSuperEditor() + landingdata.isPowerEditor()
                        + landingdata.getPowerEditorType());
                if (name != null && name.equalsIgnoreCase("parent")) {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                } else {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                }

            }
            logger.info("lndcbean","===getData in editClicked ??" + landingdata.getData());
            doubleboolean = false;
            RequestContext.getCurrentInstance().execute("hideLNDGlassPane()");
        } catch (Exception e) {
            // RequestContext.getCurrentInstance().execute("hideLNDGlassPane()");
            logger.info("lndcbean","//==//==|exception in editClicked|==>" + e.getMessage());
            logger.fatal(e);
            e.printStackTrace();
        }
    }

    private TaskSummaryVo addBackupdetails(TaskSummaryVo taskSummary) {
        try {
            logger.info("lndcbean","groupMap===" + groupMap);
            logger.info("lndcbean","WFID===" + WFID);
            if (taskSummary != null) {
                Usergroupvo vo = (Usergroupvo) groupMap
                        .get(taskSummary.getNodeid().trim() + "~" + WFID + "~" + taskSummary.getCode());
                taskSummary.setIsBackTask_Form(vo.isIsbackup());
                taskSummary.setBackupfor_form(vo.getBackupfor());
                taskSummary.setBackupforGroup_form(vo.getBackupforgroup());
                logger.info("lndcbean","vo.isIsbackup=========" + vo.isIsbackup());
                logger.info("lndcbean","vo.isIsbackup=========" + vo.getBackupfor());
                logger.info("lndcbean","vo.getBackupforgroup=========" + vo.getBackupforgroup());
            }

        } catch (Exception e) {
            logger.fatal(e);
        }

        return taskSummary;
    }

    public void newClicked() {  // ************* Action New Clicked Start ****************
        logger.info("lndcbean","Inside newClicked>>>>>");
        try {

//                   viewlist = (List) FacesContext.getCurrentInstance().getExternalContext()
//                    .getSessionMap().get("DashboardModelMenuDetails") != null
//                    ? (List) FacesContext.getCurrentInstance().getExternalContext()
//                            .getSessionMap().get("DashboardModelMenuDetails") : new ArrayList<>();
//            if (viewlist != null && !viewlist.isEmpty()) {
//                List viewresult = viewlist.stream()
//                        .filter(line -> model.getDataModel().getMdlId().equalsIgnoreCase(line.getModuleid()) && "Y".equalsIgnoreCase(line.getViewModeEnable()))
//                        .collect(Collectors.toList());
//                // System.out.println("lnd target moduleid" + model.getDataModel().getMdlId() + ">> viewEyeRender >>>" + viewresult.toString());
//                if (viewresult != null && !viewresult.isEmpty() && this.name != null && this.name.equalsIgnoreCase("parent")) {
//                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
//                   RequestContext.getCurrentInstance().execute("lndcNewBtn();");
//
//               }
//            }

            if (applyBPM) {
               
                if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001") && choosevessel != null && (choosevessel.trim().equalsIgnoreCase("Y") || choosevessel.trim().equalsIgnoreCase("F"))) {
                    RequestContext.getCurrentInstance().execute("PF('vsldlg').show();");

                } else {
                    
                    logger.info("### BPM FORM New Action ==>" + redirectMdlId);
                    StatusVo initStatus = new StatusVo();
                    LandingDataVo landingdata = new LandingDataVo();
                    landingdata.setReferenceNumber(null);
                    landingdata.setData(null);
                    landingdata.setIsBPMEnabled(true);
                    landingdata.setAction(LandingDataVo.LandingAction.NEW);
                    landingdata.setTasksummary(new TaskSummaryVo());
                    logger.info("formCreationWFID==========" + formCreationWFID);
                    landingdata.setWfid(formCreationWFID);
                    landingdata.setBpmwfid(formCreationbpmWFID);
                    landingdata.setIsDynamicMdl(isDynamicMdl);
                    if (!isDynamicMdl) {
                        
                        initStatus = smbpmUtil.hasRightsToIntiateProcess(model.getDataModel().getMdlId(), mData.getMetaData(APPINFO.COMPANY_CODE),
                                formCreationWFID, mData.getMetaData(USERINFO.USERCODE).trim(), wfCode, "V");

                        if (initStatus.getStatus() == StatusVo.STATUS.SUCCESS) {
                            HashMap hmap = new HashMap();
                            hmap.put(Keyconstants.userCode, mData.getMetaData(USERINFO.USERCODE));
                            hmap.put(Keyconstants.WFID, formCreationWFID);
                            if (PROJECTTYPE.trim().equalsIgnoreCase("CNT002")) {
                                hmap.put(Keyconstants.vslOrCompcode, mData.getMetaData(APPINFO.VESSEL_CODE));
                            } else {
                                hmap.put(Keyconstants.vslOrCompcode, mData.getMetaData(APPINFO.COMPANY_CODE));
                            }
                            hmap.put(Keyconstants.Flag, true);
                            hmap.put(Keyconstants.WFType, WFType);
                            hmap.put(Keyconstants.controlType, PROJECTTYPE);
                           
                            boolean proceed = mbutil.hasNewAccess(hmap);
                            //  logger.info("company code in landing page======after BPM===============" + mData.getMetaData(APPINFO.COMPANY_CODE));
                            if (proceed) {
                                if (name != null && name.equalsIgnoreCase("parent")) {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                                } else {
                                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                                }
                            } else {
                                dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                            }
                        } else {
                            dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                        }
                    } else {

                        
                        HashMap hmap = new HashMap();
                        hmap.put(Keyconstants.userCode, mData.getMetaData(USERINFO.USERCODE));
                        hmap.put(Keyconstants.WFID, formCreationWFID);
                        if (PROJECTTYPE.trim().equalsIgnoreCase("CNT002")) {
                            hmap.put(Keyconstants.vslOrCompcode, mData.getMetaData(APPINFO.VESSEL_CODE));
                        } else {
                            hmap.put(Keyconstants.vslOrCompcode, mData.getMetaData(APPINFO.COMPANY_CODE));
                        }
                        hmap.put(Keyconstants.Flag, true);
                        hmap.put(Keyconstants.WFType, WFType);
                        hmap.put(Keyconstants.controlType, PROJECTTYPE);
                      //  System.out.println("applyBPM hmap newClicked>>>>>"+hmap);
                        boolean proceed = mbutil.hasNewAccess(hmap);
                        //  logger.info("company code in landing page======after BPM===============" + mData.getMetaData(APPINFO.COMPANY_CODE));
                        if (proceed) {
                            //  logger.info("company code in landing page======after NO BPM===============" + mData.getMetaData(APPINFO.COMPANY_CODE));
                            if (name != null && name.equalsIgnoreCase("parent")) {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                            } else {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                            }
                        } else {
                            dUtil.showDialog("BPM", SMDialogUtil.type.INFO, "02105004", "", null);
                        }
                    }

                }
               logger.info("lndcbean"+"bpmWFID in newClicked ?? " + bpmWFID + "?? isDynamicMdl ??" + isDynamicMdl + "?? formCreationbpmWFID ??" + formCreationbpmWFID);

            } else {
                if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001") && choosevessel != null && (choosevessel.trim().equalsIgnoreCase("Y") || choosevessel.trim().equalsIgnoreCase("F"))) {
                    RequestContext.getCurrentInstance().execute("PF('vsldlg').show();");

                } else {

                    logger.info("### Master New Action =else=>" + redirectMdlId);
                    LandingDataVo landingdata = new LandingDataVo();
                    landingdata.setReferenceNumber(null);
                    landingdata.setData(null);
                    landingdata.setAction(LandingDataVo.LandingAction.NEW);
                    landingdata.setTasksummary(null);
                    landingdata.setWfid(null);
                    //    logger.info("company code in landing page======after NO BPM=11==============" + mData.getMetaData(APPINFO.COMPANY_CODE));
                    if (name != null && name.equalsIgnoreCase("parent")) {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                    } else {
                        NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                    }
                }
            }
        } catch (Exception e) {
            logger.info("exception in newClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }   // ************* Action New Clicked End ****************

    public String getValuesFromSelectedRowMap(String strKey) {
        String strVlaueFromMap = "";
        try {
            if (model.getDataModel().getSelectedRowMap() != null
                    && model.getDataModel().getSelectedRowMap().get(strKey) != null) {
                strVlaueFromMap = (String) model.getDataModel().getSelectedRowMap().get(strKey);
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return strVlaueFromMap;
    }

    public String getValuesFromEditedRowMap(String strKey, Map<String, Object> editedRowMap) {
        String strVlaueFromMap = "";
        try {
            if (editedRowMap != null && editedRowMap.get(strKey) != null) {
                strVlaueFromMap = editedRowMap.get(strKey).toString();
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return strVlaueFromMap;
    }

    // DOUBLE CLICK
    // public void doubleClicked(SelectEvent event) { // ********* Double Click in
    // datatable Handle ********
    public void doubleClicked() { // ********* Double Click in datatable Handle ********
        try {
            logger.info("lndcbean","//==//==|INISDIE DBL CLICKED|==>");
            doubleboolean = true;
            boolean doubleselectedrow = false;
            logger.info("lndcbean",
                    "//==//==|model.getDataModel().getSelectedRowMap()|==>" + model.getDataModel().getSelectedRowMap());
            doubleselectedrow = model.getDataModel().getSelectedRowMap().containsKey("bpmapplicable");
            if (doubleselectedrow) {
                doubleboolean = false;
            } else {
                if (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                        && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                                .equalsIgnoreCase("true")) {
                    doubleboolean = false;
                }
            }
            RequestContext.getCurrentInstance().execute("lnd_navigate_rc()");
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // ********* Double Click Hadle End ********

    public void openNewtab() { // ********* Double Click in datatable Handle ********
        List lstselected = null;
        LandingDataVo landingdata = new LandingDataVo();
        try {
            logger.info("lndcbean","//==//==|INISDIE openNewtab CLICKED|==>");
            logger.info("lndcbean",
                    "//==//==|model.getDataModel().getSelectedRowMap()|==>" + model.getDataModel().getSelectedRowMap());
            lstselected = settingLandingDataList(model.getDataModel().getSelectedRowMap());
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            }
            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setData(lstselected);
            logger.info("lndcbean","WFID VIEW IN LANDING PAGE on double click=====" + WFID + "?? bpmWFID ??" + bpmWFID);
            // landingdata.getData().add(0, refnofieldval);
            logger.info("lndcbean","lstToView in View on double clicked ??" + lstselected);
            NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
            RequestContext.getCurrentInstance().execute("lnd_navigate_rc()");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigateToModule() { // ****** Selected Row to navigate *****************//while clicking the third
                                     // level validation edit applicable rows,
        // form opened in view mode or u dont have access to edit the form meessage is
        // came - issue fixed in this method
        LandingDataVo landingdata = new LandingDataVo();
        boolean rarEditRights = false;
        TaskSummaryVo taskSummary = new TaskSummaryVo();
        String refnofieldval = "";
        List lstselected = null;

        boolean isEdit = false;
        ClaimRights claimRights;
        try {
            // logger.info("lndcbean","Selected row in navigateToModule==>" +
            // model.getDataModel().getTmpSelectedRow());
            lstselected = settingLandingDataList(model.getDataModel().getSelectedRowMap());
            // lstToView = model.getDataModel().getTmpSelectedRow();
            landingdata.setData(lstselected);
            // MPRD-4934
            List viewresult = new ArrayList<>();
            viewlist = (List) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("DashboardModelMenuDetails") != null
                            ? (List) FacesContext.getCurrentInstance().getExternalContext()
                                    .getSessionMap().get("DashboardModelMenuDetails")
                            : new ArrayList<>();
            if (viewlist != null && !viewlist.isEmpty()) {
                viewresult = viewlist.stream()
                        .filter(line -> model.getDataModel().getMdlId().equalsIgnoreCase(line.getModuleid())
                                && "Y".equalsIgnoreCase(line.getViewModeEnable()))
                        .collect(Collectors.toList());
            }
            if (referenceNumber != null && !referenceNumber.isEmpty()) {
                landingdata.setReferenceNumber(referenceNumber);
                referenceNumber = "";
            } else {
                referenceNumber = "";
                landingdata.setReferenceNumber(refnofieldval);
            }
            if (doubleboolean) {
                landingdata.setAction(LandingDataVo.LandingAction.VIEW);
                landingdata.setIsDynamicMdl(isDynamicMdl);
                refnofieldval = model.getDataModel().getSelectedRowMap().get(refnofieldwithoutdot).toString();
                landingdata.setReferenceNumber(refnofieldval);
                // MPRD-4934
                if (viewresult != null && !viewresult.isEmpty()) {
                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
                    RequestContext.getCurrentInstance().execute("toggleViewMode();");
                }

            } else {
                landingdata.setAction(LandingDataVo.LandingAction.EDIT);
                doubleboolean = true;
                isEdit = true;
                refnofieldval = model.getDataModel().getSelectedRowMap().get(refnofieldwithoutdot).toString();
                landingdata.setReferenceNumber(refnofieldval);
                // if
                // (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows"))
                // {
                // landingdata.setThirdvalidationstatus(true);
                // }
                // MPRD-4934
                if (viewresult != null && !viewresult.isEmpty()) {
                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
                    RequestContext.getCurrentInstance().execute("toggleEditMode();");
                }
                
            }

            boolean checkthirlevel = false;
            if (isEdit) {
                if (applyBPM) {
                    if (model.getDataModel().getSelectedRowMap().containsKey("tasksummaryvo")
                            && model.getDataModel().getSelectedRowMap().get("tasksummaryvo") != null) {
                        taskSummary = (TaskSummaryVo) model.getDataModel().getSelectedRowMap().get("tasksummaryvo");
                        taskSummary = addBackupdetails(taskSummary);
                        landingdata.setTasksummary(taskSummary);
                        landingdata.setIsBPMEnabled(true);
                        landingdata.setWfid(WFID);
                    }
                    String strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails",
                            model.getDataModel().getSelectedRowMap());
                    String[] latColVal = strWfIdAndBpmId.split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                    logger.info("lndcbean","bpmWFID ??? in Double CLICKED ??????????? " + bpmWFID + "?? WFID ??" + WFID);
                    landingdata.setBpmwfid(bpmWFID);
                    landingdata.setWfid(WFID);
                    landingdata.setIsBPMEnabled(true);

                    if (!rarEditRights) {
                        claimRights = smbpmUtil.hasClaimRights(model.getDataModel().getMdlId().trim(),
                                mData.getMetaData(APPINFO.COMPANY_CODE),
                                WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                        rarEditRights = claimRights.isHasRights();
                        if (!rarEditRights) {
                            claimRights = smbpmUtil.hasClaimRightsDynamic(model.getDataModel().getMdlId().trim(),
                                    mData.getMetaData(APPINFO.COMPANY_CODE),
                                    WFID, taskSummary.getCode(), taskSummary.getType(), taskSummary.getNodeid(),
                                    mData.getMetaData(USERINFO.USERCODE).trim(), taskSummary.getInstanceid());
                            rarEditRights = claimRights.isHasRights();
                        }
                    }
                    logger.info("lndcbean","navigateToModule :: Final rarEditRights >> " + rarEditRights);
                    if (rarEditRights) {

                        checkthirlevel = false;
                        StatusVo claimStatus = smbpmUtil.claimTask(taskSummary,
                                mData.getMetaData(USERINFO.USERCODE).trim(), new HashMap());

                        landingdata.setCreateWFHistory(claimStatus.getStatus() == StatusVo.STATUS.SUCCESS);
                        landingdata.setStatus(claimStatus.getStatus());

                        if (claimStatus.getStatus() == StatusVo.STATUS.SUCCESS
                                || claimStatus.getStatus() == StatusVo.STATUS.CLAIMED_FOR_PROCEED) {
                            taskSummary = claimStatus.getTaskSummaryVo();
                            taskSummary = addBackupdetails(taskSummary);
                            landingdata.setTasksummary(taskSummary);
                            landingdata.setData(lstselected);
                            landingdata.setReferenceNumber(refnofieldval);
                            // landingdata.getData().add(0, refnofieldval);
                            if (name != null && name.equalsIgnoreCase("parent")) {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                            } else {
                                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false,
                                        true);
                            }
                        } else {
                            checkthirlevel = true;
                        }
                    } else {
                        checkthirlevel = true;
                    }
                } else {
                    checkthirlevel = true;
                }
            } else {
                if (applyBPM) {
                    String strWfIdAndBpmId = getValuesFromEditedRowMap("bpmdetails",
                            model.getDataModel().getSelectedRowMap());
                    String[] latColVal = strWfIdAndBpmId.split("~");
                    if (latColVal != null && latColVal.length == 2) {
                        WFID = latColVal[0].trim();
                        bpmWFID = latColVal[1].trim();
                    }
                    if (thirdlevelbpmapplicablerows != null && thirdlevelbpmapplicablerows.contains(lstselected)) { // added
                                                                                                                    // by
                                                                                                                    // vinothini.r
                        landingdata.setThirdvalidationstatus(true);
                    }
                    landingdata.setBpmwfid(bpmWFID);
                    landingdata.setWfid(WFID);
                    if (model.getDataModel().getSelectedRowMap().containsKey("tasksummaryvo")
                            && model.getDataModel().getSelectedRowMap().get("tasksummaryvo") != null) {
                        taskSummary = (TaskSummaryVo) model.getDataModel().getSelectedRowMap().get("tasksummaryvo");
                        taskSummary = addBackupdetails(taskSummary);
                        landingdata.setTasksummary(taskSummary);
                    }
                    landingdata.setIsBPMEnabled(true);
                } else {
                    landingdata.setTasksummary(null);
                    if (model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                            && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                                    .equalsIgnoreCase("true")) { // added by vinothini.r
                        landingdata.setThirdvalidationstatus(true);
                    }
                }

                landingdata.setData(lstselected);
                landingdata.setReferenceNumber(refnofieldval);
                logger.info("lndcbean","WFID VIEW IN LANDING PAGE on double click=====" + WFID + "?? bpmWFID ??" + bpmWFID);
                // landingdata.getData().add(0, refnofieldval);
                logger.info("lndcbean","lstToView in View on double clicked ??" + lstselected);
                if (name != null && name.equalsIgnoreCase("parent")) {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                } else {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                }
            }

            if (checkthirlevel && model.getDataModel().getSelectedRowMap().containsKey("thirdlevelbpmapplicablerows")
                    && model.getDataModel().getSelectedRowMap().get("thirdlevelbpmapplicablerows").toString()
                            .equalsIgnoreCase("true")) {
                landingdata.setTasksummary(null);
                landingdata.setWfid(null);
                landingdata.setThirdvalidationstatus(true);
                landingdata.setReferenceNumber(refnofieldval);
                if (landingPageDatasHm.get("refnofield") != null) {

                    landingdata.setData(lstselected);
                    // landingdata.getData().add(0, refnofieldval);
                } else {
                    landingdata.setData(lstselected);
                }
                if (name != null && name.equalsIgnoreCase("parent")) {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
                } else {
                    NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
                }

            }

            logger.info("lndcbean","==WFID====WFID>" + WFID);
            logger.info("lndcbean","==bpmWFID====bpmWFID>" + bpmWFID);
            // landingdata.getData().add(0,
            // model.getDataModel().getTmpSelectedRow().get(refnofieldIndex));
            //
            // NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId,
            // landingdata, true);
        } catch (Exception e) {
            logger.fatal(e);
            // logger.info("lndcbean","exception in navigateToModule ==>" + e.getMessage());
            // logger.fatal(e);
        }
    }

    public void revokerequestClicked() {
        logger.info("lndcbean","Inside revokerequestClicked>>>>>");
        ArrayList lstToRevoke = null;
        String refnofieldval = "";
        try {

            int iRowIndex = getRowIndex();
            logger.info("lndcbean","//==//==|iRowIndex****|==>" + iRowIndex);
            Map<String, Object> mapToRevoke = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            String refno = mapToRevoke.get(refnofieldwithoutdot).toString().trim().toLowerCase();
            TaskSummaryVo taskVo = new TaskSummaryVo();

            if (revokableRefMap.get(refno) != null) {
                taskVo = revokableRefMap.get(refno);
            }
            String claimeduser = taskVo.getClaimuser();

            CompleteModel completeModel = new CompleteModel();
            completeModel = service.getClaimeduserdetail(claimeduser);
            Uvs_userdetail uservo = completeModel.getUserdetail().get(0);
            this.claimedusername = uservo.getEmpname() + " " + uservo.getSurname();
            this.claimeduserrankname = uservo.getRankname();
            this.claimeduserdepname = uservo.getDepname();
            this.claimedusergroupname = taskVo.getUsergroup();

            CompleteModel grpModel = new CompleteModel();
            grpModel = service.getGroupname(taskVo.getUsergroup());
            if (grpModel.getBpmgroupmaster() != null && grpModel.getBpmgroupmaster().size() > 0) {
                Bpmgroupmaster grpVo = grpModel.getBpmgroupmaster().get(0);
                if (grpVo != null && grpVo.getDescription() != null && grpVo.getDescription().trim().length() > 0) {
                    this.claimedusergroupname = grpVo.getDescription();
                }
            }

            logger.info("lndcbean",
                    " model.getDataModel().setClaimedusername===" + claimedusername + "====" + claimedusergroupname);
            RequestContext.getCurrentInstance().update("revokewarningdlg");
            // model.getDataModel().setClaimedusergroupname(uservo.get);
            RequestContext.getCurrentInstance().execute("PF('revokewarningdlg').show();");
        } catch (Exception e) {
            logger.fatal(e);
            // explog.setExceptionlog("LND", model.getDataModel().getMdlId(),
            // mData.getMetaData(APPINFO.COMPANY_CODE), PROJECTTYPE, e);
        }

    }

    public void closewarningdlg() {
        RequestContext.getCurrentInstance().execute("PF('revokewarningdlg').hide();");
    }

    public void closeadrdlg() {

        RequestContext.getCurrentInstance().execute("PF('adrdlg').hide();");
    }

    public void closedelreqdlg() {

        RequestContext.getCurrentInstance().execute("PF('deletreqdlg').hide();");
    }

    List lstToRevoke = null;
    Map<String, Object> mapToRevoke = null;
    Map<String, Object> mapToRecall = null;

    public void revokeClicked() throws Exception {
        // revoke();
        int iRowIndex = getRowIndex();
        logger.info("lndcbean","//==//==|iRowIndex****|==>" + iRowIndex);
        mapToRevoke = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
        // lstToRevoke = (ArrayList)
        // UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("selectedRow");
        // lstToRevoke = (ArrayList)
        // model.getDataModel().getSm_rowsLst().get(iRowIndex);
        // logger.info("lndcbean","==lstToRevoke===1====>" + ((String)
        // lstToRevoke.get(refnofieldIndex)).trim().toLowerCase());
        dUtil.showDialog("LND", SMDialogUtil.type.CONF, "LND00004", "#{LandingPageCBean.ctrl.revoke}", null);

    }

    List<Deleterequest> delreqdetailList = new ArrayList();

    public void delreqValidation() {
        // revoke();
        try {
            int iRowIndex = getRowIndex();
            logger.info("lndcbean","//==//==|iRowIndex****|==addrValidation  ====>" + iRowIndex);
            Map map = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
            CompleteModel completeModel = new CompleteModel();
            completeModel = service.getdelreqdetails(map.get(refnofieldwithoutdot).toString());
            delreqdetailList = new ArrayList();
            if (completeModel.getDeleterequest() != null && completeModel.getDeleterequest().size() > 0) {
                for (int i = 0; i < completeModel.getDeleterequest().size(); i++) {

                    Deleterequest vo = completeModel.getDeleterequest().get(i);
                    if (vo.getReqdate() != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATETIMEFORMAT).trim());
                        Date colDate = mackUtility.stringToDateConverter(vo.getReqdate());
                        vo.setReqdate(sdf.format(colDate));
                    }
                    // vo.setRevtargetdate(mackUtility.);
                    delreqdetailList.add(vo);
                }
            }
            RequestContext.getCurrentInstance().update("deleterequesttbl");
            RequestContext.getCurrentInstance().execute("PF('deletreqdlg').show();");
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    public List<Deleterequest> getDelreqdetailList() {
        return delreqdetailList;
    }

    public void setDelreqdetailList(List<Deleterequest> delreqdetailList) {
        this.delreqdetailList = delreqdetailList;
    }

    public void addrValidation() throws Exception {
        // revoke();
        int iRowIndex = getRowIndex();
        logger.info("lndcbean","//==//==|iRowIndex****|==addrValidation  ====>" + iRowIndex);
        Map map = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
        CompleteModel completeModel = new CompleteModel();
        completeModel = service.getadrdetails(mData.getMetaData(USERINFO.USERCODE),
                map.get(refnofieldwithoutdot).toString());
        adrList = new ArrayList();
        if (completeModel.getPictask() != null && completeModel.getPictask().size() > 0) {
            for (int i = 0; i < completeModel.getPictask().size(); i++) {

                Pictask vo = completeModel.getPictask().get(i);
                if (vo.getRevtargetdate() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat(mData.getMetaData(USERINFO.DATETIMEFORMAT).trim());
                    Date colDate = mackUtility.stringToDateConverter(vo.getRevtargetdate());
                    vo.setRevtargetdate(sdf.format(colDate));
                }
                // vo.setRevtargetdate(mackUtility.);
                adrList.add(vo);
            }
        }
        RequestContext.getCurrentInstance().update("adrtbl");
        RequestContext.getCurrentInstance().execute("PF('adrdlg').show();");
    }

    public void recall_remotecall() throws Exception {
        // revoke();
        int iRowIndex = getRowIndex();
        logger.info("lndcbean","//==//==|iRowIndex****|==recall  ====>" + iRowIndex);
        mapToRecall = model.getDataModel().getDynamicEntityMap().get(iRowIndex);
        dUtil.showDialog("LND", SMDialogUtil.type.CONF, "LND00005", "#{LandingPageCBean.ctrl.recall}", null);

    }

    public void recall() throws Exception {
        String eventType = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes()
                .get("eventType");
        logger.info("lndcbean","//==//==|eventType=====>" + eventType);
        if ("yes".equalsIgnoreCase(eventType)) {
            String sGrpCode = "";
            logger.info("lndcbean","recall================called");
            TaskSummaryVo taskSummary = new TaskSummaryVo();
            Rs0 Rs0taskSummary = new Rs0();
            String refno = mapToRecall.get(refnofieldwithoutdot).toString().trim().toLowerCase();
            if (recallMap.get(refno) != null) {
                Rs0taskSummary = (Rs0) recallMap.get(refno);
                taskSummary = getTaskSummaryMapper(Rs0taskSummary);
                boolean valid = checkRevokable(taskSummary);
                if (valid) {
                    StatusVo svo = smbpmUtil.onRevoke(taskSummary, mData.getMetaData(USERINFO.USERCODE));
                    // System.out.println("Status =====>>>>>>" + svo.getStatus());
                    if (svo.getStatus() != null && svo.getStatus().toString().equalsIgnoreCase("success")) {

                        this.wFHistoryUtil.setManualWorkFlowHistory(this.mData, refno,
                                this.model.getDataModel().getMdlId(), "", "");
                        this.wFHistoryUtil.putManualWorkFlowHistory(mData.getMetaData(USERINFO.USERCODE), refno, "",
                                "RCL", "");
                        TaskSummaryVo newtsmvo = getCurrentTaskSummaryVo(refno);
                        if (newtsmvo != null) {
                            mapToRecall.put("bpmapplicable", true);
                            mapToRecall.put("btnEditRenderInHm", "Yes");
                            mapToRecall.put("bpmdetails", (String) recallMap.get("bpmdetails" + refno));
                            mapToRecall.put("tasksummaryvo", newtsmvo);
                            mapToRecall.put("recallbtn", false);
                            RequestContext.getCurrentInstance().update("landingPageForm");
                        }
                    } else {

                        this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00007", "", null);
                    }
                } else {

                    this.dUtil.showDialog("LND", SMDialogUtil.type.INFO, "LND00007", "", null);
                }
            }
        }
    }

    public void revoke() throws Exception {
        String eventType = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes()
                .get("eventType");
        logger.info("lndcbean","//==//==|eventType=====>" + eventType);
        if ("yes".equalsIgnoreCase(eventType)) {
            String sGrpCode = "";
            logger.info("lndcbean","revokeClicked================called");
            TaskSummaryVo taskSummary = new TaskSummaryVo();
            // logger.info("lndcbean","(String)
            // lstToRevoke.get(refnofieldIndex)).trim().toLowerCase()====" +
            // lstToRevoke.get(refnofieldIndex).toString().trim().toLowerCase());
            String refno = mapToRevoke.get(refnofieldwithoutdot).toString().trim().toLowerCase();
            logger.info("lndcbean","refnoTaskSummaryMap===" + refnoTaskSummaryMap);
            if (refnoTaskSummaryMap.get(refno) != null) {
                taskSummary = refnoTaskSummaryMap.get(refno);
                boolean valid = validateRevoke(taskSummary);
                logger.info("lndcbean","//==//==|taskSummary|==>" + taskSummary);
                if (valid) {
                    StatusVo svo = smbpmUtil.releaseTaskToBasket(taskSummary, "Task revoked through landingpage");
                    if (svo.getStatus() != null && svo.getStatus().toString().equalsIgnoreCase("success")) {
                        // List<Workflowhistory> wlist = new ArrayList();
                        // Workflowhistory wfvo = new Workflowhistory();
                        // wfvo.setRefno(refno);
                        // wlist.add(wfvo);
                        // CompleteModel model = new CompleteModel();
                        // model.setWorkflowhistory(wlist);
                        // Map mapResult = service.updaterevoke(model);
                        this.wFHistoryUtil.setManualWorkFlowHistory(this.mData, refno,
                                this.model.getDataModel().getMdlId(), "", "");
                        this.wFHistoryUtil.putManualWorkFlowHistory(mData.getMetaData(USERINFO.USERCODE), refno, "",
                                "RVK", "");
                        mapToRevoke.put("btnRevokeBtn", "false");
                        RequestContext.getCurrentInstance().update("landingPageForm");
                        // boolean removed = revokeRenderRows.remove(lstToRevoke);
                        // logger.info("lndcbean","//==//==|removed|==>" + removed);
                        // RequestContext.getCurrentInstance().execute("PF('datagrid').filter();");
                    }
                } else {
                    logger.info("lndcbean","====================================already revoked=============================");
                    // boolean removed = revokeRenderRows.remove(lstToRevoke);
                    // logger.info("lndcbean","//==//==|removed" + removed);
                    // RequestContext.getCurrentInstance().execute("PF('datagrid').filter();");
                }
            }
        }
    }

    private boolean validateRevoke(TaskSummaryVo taskvo) {
        boolean check = false;
        try {
            CompleteModel completeModel;
            completeModel = service.checkbeforerevoke(taskvo.getRefno(), taskvo.getStatus(), taskvo.getClaimuser(),
                    taskvo.getNodeid());
            List<Processinstancemaster> masList = completeModel.getProcessinstancemaster();
            if (masList != null && masList.size() > 0 && masList.get(0).getRefno() != null) {
                check = true;
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return check;
    }

    private HashMap replaceDot(List<String> tmpColHeaderNamesLst) {
        tmpColHeaderNamesLstwithoutdot = new ArrayList();
        HashMap hmap = new HashMap();
        tmpColHeaderNamesLst.stream().forEach((var) -> {
            String headerstr = var.replaceAll("\\.", "");
            tmpColHeaderNamesLstwithoutdot.add(headerstr);
            hmap.put(var, headerstr);
        });
        logger.info("lndcbean","hmap==replaceDot==" + hmap);
        return hmap;
    }

    private String getNewDate() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    ArrayList dateColList = new ArrayList();
    ArrayList dateTimeColList = new ArrayList();
    HashMap ColTypeMap = new HashMap();
    // ArrayList dateTimeColList = new ArrayList();

    List<String> refnumList = new ArrayList();

    // public void ex_VesselnameCacheLoader() {
    //     try {
    //         // System.out.println("<<<<landingpagecacheloader>>>>");
    //         Ex_VesselLogCacheContainer = (CacheContainer) new InitialContext()
    //                 .lookup("java:jboss/infinispan/container/Ex_VesselnameCache");
    //         vesselMasterDetailList = new ArrayList();
    //         this.Ex_VesselLogCache = Ex_VesselLogCacheContainer.getCache("Ex_VesselnameCache");
    //         // this.VesselmasterCache =
    //         // this.Ex_VesselLogCacheContainer.getCache("VesselmasterCache");
    //         // System.out.println("---landingCache---landingCache.size" +
    //         // Ex_VesselLogCache.size());
    //     } catch (Exception e) {
    //         // System.out.println("---landingCache---error " + e);
    //         e.printStackTrace();
    //     }
    // }

    public boolean vesselCacheData(String vesselcode, String date, String refid) {

        Ex_vesselnameHistoryList = new ArrayList<>();
        previousHistoryCompanyName = "";
        previousHistoryVesselName = "";
        boolean isDateTimeInRange = false;
        try {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String foundVesselCode = vesselcode;

            if (foundVesselCode != null && !foundVesselCode.isEmpty()) {
                ;
                if (tenantIdentifier != null && tenantIdentifier.trim().length() > 0) {                 
                        Ex_vesselnameHistoryList = Cacheintr.cacheEx_vesselname(tenantIdentifier,foundVesselCode);
                } else {
                    Ex_vesselnameHistoryList = Cacheintr.cacheEx_vesselname("",foundVesselCode);
                }

                // System.out.println("foundVesselCode>>>" + foundVesselCode);

                // System.out.println("Ex_vesselnameHistoryList>>>" +
                //  Ex_vesselnameHistoryList.size());
            }

            // if (foundVesselCode != null && !foundVesselCode.isEmpty()) {
            // if (Ex_VesselLogCache.containsKey(foundVesselCode)) {
            // Ex_vesselnameHistoryList.addAll((Collection<? extends Ex_vesselname>)
            // this.Ex_VesselLogCache.get(foundVesselCode));
            // } else {
            // // System.out.println("key not found");
            // }
            //
            //
            // }
            //
            if (Ex_vesselnameHistoryList != null && Ex_vesselnameHistoryList.size() > 0) {

                for (int i = 0; i < Ex_vesselnameHistoryList.size(); i++) {
                    previousHistoryCompanyName = "";
                    previousHistoryVesselName = "";
                    isDateTimeInRange = false;
                    String Startdate = Ex_vesselnameHistoryList.get(i).getStartdate();
                    String Enddate = Ex_vesselnameHistoryList.get(i).getEnddate();

                    if (Startdate != null && Startdate.trim().length() > 0 && Enddate != null
                            && Enddate.trim().length() > 0 && date != null && date.trim().length() > 0) {
                        DateTimeFormatter formatterWithMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                        DateTimeFormatter formatterWithoutMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                        LocalDateTime StartDateTime = null;
                        LocalDateTime EndDateTime = null;
                        LocalDateTime requiredDateTime = null;

                        try {
                            StartDateTime = LocalDateTime.parse(Startdate, formatterWithMillis);
                        } catch (DateTimeParseException e1) {
                            // If parsing with milliseconds fails, try parsing without milliseconds
                            StartDateTime = LocalDateTime.parse(Startdate, formatterWithoutMillis);
                        }

                        try {
                            EndDateTime = LocalDateTime.parse(Enddate, formatterWithMillis);
                        } catch (DateTimeParseException e2) {
                            // If parsing with milliseconds fails, try parsing without milliseconds
                            EndDateTime = LocalDateTime.parse(Enddate, formatterWithoutMillis);
                        }

                        try {
                            requiredDateTime = LocalDateTime.parse(date, formatterWithMillis);
                        } catch (DateTimeParseException e3) {
                            // If parsing with milliseconds fails, try parsing without milliseconds
                            requiredDateTime = LocalDateTime.parse(date, formatterWithoutMillis);
                        }

                        isDateTimeInRange = isDateTimeBetween(StartDateTime, EndDateTime, requiredDateTime);
                        // System.out.println("requiredDateTime>>>>" + requiredDateTime);
                        if (isDateTimeInRange) {
                            // System.out.println("isDateInRange>>>>" + isDateTimeInRange + ">>>refid>>" +
                            // refid);
                            previousHistoryCompanyName = Ex_vesselnameHistoryList.get(i).getShorename();
                            previousHistoryVesselName = Ex_vesselnameHistoryList.get(i).getVesselname();
                            // System.out.println("isDateInRange>>>>" + isDateTimeInRange + ">>>refid>>" +
                            // refid + ">>> companycode >>" + previousHistoryCompanyName);
                            break;

                        } else {
                            // // System.out.println("isDateInRange>>>> NOT in RANGE>> " + isDateTimeInRange
                            // + ">>>refid>>" + refid);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDateTimeInRange;

    }

    public boolean isDateTimeBetween(LocalDateTime start, LocalDateTime end, LocalDateTime required) {
        return !required.isBefore(start) && !required.isAfter(end);
    }

    public void managementCompanyVesselWhiltelistProperties() {
        try {
            // System.out.println("managementCompanyVesselWhiltelistProperties methodv>>>");

            if (dynamicLandingVesselcodePropertyCode != null && dynamicLandingVesselcodePropertyCode.trim().length() > 0
                    && dynamicLandingCreatedDatePropertyCode != null
                    && dynamicLandingCreatedDatePropertyCode.trim().length() > 0) {
                logger.info("lndcbean","managementCompanyVesselWhiltelistProperties is set true");
                for (int i = 0; i < dataSet.size(); i++) {
                    // for (int p = 0; p < tmpColHeaderNamesLst.size(); p++) {
                    LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
                    String createddate = tm.get(dynamicLandingCreatedDatePropertyCode).toString();

                    String refid = tm.get(dynamicLandingReferenceCode).toString();

                    String recordvesselcode = tm.get(dynamicLandingVesselcodePropertyCode).toString();

                    if (recordvesselcode != null && recordvesselcode.trim().length() > 0 && createddate != null
                            && createddate.trim().length() > 0) {

                        boolean isDateInRangevalid = vesselCacheData(recordvesselcode, createddate, refid);

                        if (isDateInRangevalid) {
                            tm.put(dynamicLandingVesselnamePropertyCode, previousHistoryVesselName);
                            if (dynamicLandingCompanynamePropertyCode != null
                                    && dynamicLandingCompanynamePropertyCode.trim().length() > 0) {
                                tm.put(dynamicLandingCompanynamePropertyCode, previousHistoryCompanyName);
                            }
                            dataSet.remove(i);
                            dataSet.add(i, tm);
                            // System.out.println("data replaced>>...refid" + refid);
                        }
                    }
                }
            } else {
                // System.out.println("managementCompanyVesselWhiltelistProperties>>>>>no");
            }
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    private List processDataset() {
      
        try {
            int rstZise;
            if (!this.model.getDataModel().isIncludeOpenItems()) {
                HmapList = new ArrayList();

            }
            dataSet = this.invokeGetterService(viewServiceName, viewIdentifier, viewInputHm, List.class, serviceType, mDataMap);
            dateColList = new ArrayList();
            dateTimeColList = new ArrayList();

            if (dataSet != null) {
                rstZise = dataSet.size();
                managementCompanyVesselWhiltelistProperties();
                logger.info("lndcbean","rstZise======" + rstZise);
                for (int i = 0; i < dataSet.size(); i++) {
                    ArrayList lst = new ArrayList();
                    HashMap hmap = new HashMap();
                    boolean toAdd = true;
                    for (int p = 0; p < tmpColHeaderNamesLst.size(); p++) {
                        LinkedTreeMap tm = (LinkedTreeMap) dataSet.get(i);
                        Boolean bColnMatched = false;
                        Iterator it = tm.keySet().iterator();
                        String tmpcolheadername = (String) tmpColHeaderNamesLst.get(p);
                        while (it.hasNext()) {
                            String key = it.next().toString();
                            //  // System.out.println("key====="+key);
                            //    // System.out.println("tmpColHeaderNamesLst===" + tmpColHeaderNamesLst);
                            if (key != null && key.equalsIgnoreCase(tmpcolheadername)) {
                                //// System.out.println("key=contain namelist====");
                                Iterator it1 = headerDisplayNameVarMap.keySet().iterator();
                                boolean check1 = false;
                                while (it1.hasNext()) {
                                    String key1 = it1.next().toString();
                                    String colName = (String) headerDisplayNameVarMap.get(key1);

                                    //  // System.out.println("key1=============" + key1);
                                    //  // System.out.println("tm.get(key)=============" + tm.get(key));
                                    //  // System.out.println("key=============" + key);
                                    if (colName.equalsIgnoreCase(key)) {
                                        if (key1.equalsIgnoreCase("Company Name") && tm.get(key) != null) {
                                            if (toAdd) {
                                                toAdd = validatetoAdd(tm.get(key).toString());
                                            }
                                        }

                                        if (key1.equalsIgnoreCase(refnofield) && tm.get(key) != null) {

                                            refnumList.add("'" + tm.get(key).toString() + "',");
                                        }
                                        String colType = (String) columnTypeLstreoderMap.get(key1);
                                        //   // System.out.println("colType====" + colType);
                                        String headername = colNameMap.get(colName).toString().trim();

                                        if ("int".equalsIgnoreCase(colType)) {
                                            hmap.put(headername, Integer.parseInt(tm.get(key).toString()));
                                            ColTypeMap.put(headername, "int");
                                        } else if ("float".equalsIgnoreCase(colType)) {
                                    //                                                    lst.add(Float.parseFloat(tm.get(key).toString()));
                                    //                                                    lstDummy.add(Float.parseFloat(tm.get(key).toString()));

                                            if (tm.get(key) != null && tm.get(key).toString().trim().length() > 0) {
                                                BigDecimal bd = new BigDecimal(tm.get(key).toString());
                                                double val = bd.doubleValue();
                                                hmap.put(headername, val);
                                            } else {
                                                hmap.put(headername, "");
                                            }
                                            ColTypeMap.put(headername, "float");
                                        } else if ("double".equalsIgnoreCase(colType)) {
                                            if (tm.get(key) != null && tm.get(key).toString().trim().length() > 0) {
                                                BigDecimal bd = new BigDecimal(tm.get(key).toString());
                                                double val = bd.doubleValue();
                                                hmap.put(headername, val);
                                            } else {
                                                hmap.put(headername, "");
                                            }
                                            ColTypeMap.put(headername, "double");
                                        } else if ("date".equalsIgnoreCase(colType)) {
                                            Date dateval = getdateString(colName, colType, tm.get(key).toString());
                                            hmap.put(headername, dateval);
                                            ColTypeMap.put(headername, "date");
                                        } else if ("datetime".equalsIgnoreCase(colType)) {
                                            Date dateval = getdateString(colName, colType, tm.get(key).toString());
                                            hmap.put(headername, dateval);
                                            ColTypeMap.put(headername, "datetime");
                                        } else {
                                            if (colName.equalsIgnoreCase(statusdesc)) {
                                                if (controltypebasedstatusbool) {
                                                    if (controltypebasedstatus.contains("all") || controltypebasedstatus.contains("All") || controltypebasedstatus.contains("ALL") || tm.get(key) != null && controltypebasedstatus.contains(tm.get(key).toString().toLowerCase())) {
                                                        hmap.put("statustoshowallusersrows", true);
                                                    }
                                                } else if (statustoshowallusersbool && !controltypebasedstatusbool) {
                                                    if (tm.get(key) != null && statustoshowallusersvalues.contains(tm.get(key).toString().toLowerCase())) {
                                                        hmap.put("statustoshowallusersrows", true);
                                                    }
                                                }
                                                hmap.put("strStatusDescValue", tm.get(key)); //for status background style
                                            }
                                            // // System.out.println("backgroundtobeaddedList1=========+"+colName+"======"+backgroundtobeaddedList1);
                                            if (backgroundtobeaddedList1 != null && backgroundtobeaddedList1.contains(colName)) {
                                                //  // System.out.println("backgroundtobeaddedList===" + backgroundtobeaddedList);
                                                hmap.put("backgroundcolor", tm.get(key));
                                            }
                                            if (commonidentybool && tm.get(key) != null) {
                                                if (editidentybool && editidentifiercolumn.contains(colName)
                                                        && editidentifiervalues.contains(tm.get(key).toString().toLowerCase())) {
                                                    hmap.put("editidentifierlistrows", true);
                                                }

                                                if (viewrenidentybool && viewrenidentifiercolumn.contains(colName) && viewrenidentifiervalues.contains(tm.get(key).toString().toLowerCase())) {
                                                    hmap.put("viewrenidentifierlistrows", "true");
                                                    grpbtnMap.put(colName.replaceAll("\\.", ""), "View");
                                                }
                                                if (editrenidentybool && editrenidentifiercolumn.contains(colName) && editrenidentifiervalues.contains(tm.get(key).toString().toLowerCase())) {
                                                    hmap.put("editrenidentifierlistrows", "true");
                                                    grpbtnMap.put(colName.replaceAll("\\.", ""), "Edit");
                                                }

                                                if (newrenidentybool && newrenidentifiercolumn.contains(colName) && newrenidentifiervalues.contains(tm.get(key).toString().toLowerCase())) {
                                                    hmap.put("newrenidentifierlistrows", "true");
                                                    grpbtnMap.put(colName.replaceAll("\\.", ""), "New");
                                                }
                                            }
                                            hmap.put("isNewTabEnable", isNewTabEnable); // to control new tab btn
                                            hmap.put(colNameMap.get(colName), tm.get(key));
                                        }
                                    }

                                }
                                bColnMatched = true;
                            }
                                }
                                if (!bColnMatched) {
                                    hmap.put(tmpcolheadername, "");
                                }
                            }
                            //vvv  makeWidgetCountMap(hmap);
                            //need to continue
                            if (toAdd) {
                                if(hmap.get(refnofieldwithoutdot)!=null && !hmap.get(refnofieldwithoutdot).toString().isEmpty()){
                                    Refidhdata.add(hmap.get(refnofieldwithoutdot).toString().toLowerCase().trim());
                                }
                                
                                if (delreqlist.contains(hmap.get(refnofieldwithoutdot).toString().toUpperCase())) {
                                    hmap.put("delrequest", "true");
                                }
                               // System.out.println("Refidhdata==============" + hmap.get(refnofieldwithoutdot).toString().toLowerCase().trim());
                                HmapList.add(hmap);
                            }
                        }
                    }
            // System.out.println("HmapList size==============" + HmapList.size());
            
        } catch (Exception e) {
            logger.fatal(e);
        }
        return HmapList;
    }

    private String convertListtoString(List refnolist) {
        String refnostr = "";
        try {
            refnostr = refnolist.toString();
            // System.out.println("refnostr====" + refnostr);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return refnostr;
    }

    private String checkDeleteRequest(String refnostr) {

        try {
            // refnostr = refnolist.toString();
            // // System.out.println("refnostr====" + refnostr);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return refnostr;
    }

    private String getDateToString(Date date) {
        String strDate = null;
        try {
            strDate = mackUtility.dateToStringConverter(date);

            logger.info("lndcbean","strDate=====" + strDate);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return strDate;
    }

    public void showPendingTask() {
        try {
            logger.info("lndcbean","showPendingTask= called");

            RequestContext.getCurrentInstance().execute("PF('pendingrefdlg').show()");

        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    public void pendingTaskViewClicked() {
        logger.info("lndcbean","Inside pendingTaskViewClicked>>>>>");

        LandingDataVo landingdata = new LandingDataVo();
        TaskSummaryVo vo = (TaskSummaryVo) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance())
                .getAttributes().get("selectedRow");
        landingdata.setAction(LandingDataVo.LandingAction.VIEW);
        landingdata.setIsDynamicMdl(isDynamicMdl);
        try {
            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            if (applyBPM) {
                landingdata.setBpmwfid(bpmWFID);
                if (vo != null) {
                    landingdata.setWfid(vo.getWfid());

                    landingdata.setTasksummary(vo);
                    ArrayList reflist = new ArrayList();
                    reflist.add(vo.getRefno());
                    landingdata.setReferenceNumber(vo.getRefno());
                    landingdata.setData(reflist);
                }
                landingdata.setIsBPMEnabled(true);
            } else {
                landingdata.setTasksummary(null);
            }
            if (name != null && name.equalsIgnoreCase("parent")) {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
            } else {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
            }

        } catch (Exception e) {
            logger.info("lndcbean","exception in pendingTaskViewClicked ==>" + e.getMessage());
            logger.fatal(e);
        }
    }

    // private void getPendingTaskdetails() {
    // refnotaskMap = new HashMap();
    // refnoList = new ArrayList();
    // CompleteModel wrkFlowId =
    // service.getworkflowmappingid(model.getDataModel().getMdlId(),
    // PROJECTTYPE.trim(), "V");
    //
    // wrkFlowId.getWorkflowmapping().stream().forEach(wfid -> {
    // WFID = wfid.getWorkflowid().trim();
    // bpmWFID = wfid.getBpmwrkflowid().trim();
    // logger.info("lndcbean","WFID IN LANDING PAGE getPendingTaskdetails &&&&&&&&&&&&&&&&& " +
    // WFID + "?? bpmWFID ??" + bpmWFID);
    // List<TaskSummaryVo> revalidatedtaskvolist = new ArrayList();
    // try {
    // List<TaskSummaryVo> taskvolist =
    // smbpmUtil.getPendingTaskByUser(mData.getMetaData(USERINFO.USERCODE), WFID);
    // logger.info("lndcbean","taskvolist size in applyBPMRights===>" + taskvolist.size());
    // for (int i = 0; i < taskvolist.size(); i++) {
    // TaskSummaryVo vo = taskvolist.get(i);
    // refnotaskMap.put(vo.getRefno(), vo);
    // refnoBPMMap.put(vo.getRefno(), WFID + "~" + bpmWFID);
    // refnoList.add(vo);
    // }
    // } catch (Exception e) {
    // logger.fatal(e);
    // }
    // });
    // }
    public List getRefnoList() {
        return refnoList;
    }

    public void setRefnoList(List refnoList) {
        this.refnoList = refnoList;
    }

    public void btnrefSearchActionPerformed(ActionEvent evt) {
        try {
            logger.info("lndcbean","defaultsearchid====" + defaultsearchid);
            SearchUtils su = new SearchUtils();
            su.invokeTwoColSearch("LandingPageCBean", defaultsearchid, evt);
            logger.info("lndcbean","btnrefSearchActionPerformed end...................");
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    public void btnrefsearchActionListener(ArrayList arrayList) {
        logger.info("lndcbean","btnpersonActionListener called'''''....................");
        try {
            TaskSummaryVo vo = null;
            Rs0 rs = null;
            String Wfid = "", bpmID = "";
            String refno = arrayList.get(1).toString();
            if (refnotaskMap != null && refnotaskMap.containsKey(refno)) {
                // vo = (TaskSummaryVo) refnotaskMap.get(refno);
                rs = (Rs0) refnotaskMap.get(refno);
                vo = getTaskSummaryMapper(rs);
                String bpmvar = null;
                String strArr[] = null;

                if (refnoBPMMap.containsKey(refno)) {
                    bpmvar = (String) refnoBPMMap.get(refno);
                }
                if (bpmvar != null) {
                    strArr = bpmvar.split("~");
                }

                if (strArr != null && strArr.length == 2) {
                    Wfid = strArr[0];
                    bpmID = strArr[1];
                }
            } else {
                StatusVo svo = smbpmUtil.getTaskSummaryByRefno(refno);
                if (svo != null && svo.getStatus().toString().equals(StatusVo.STATUS.SUCCESS)) {
                    vo = svo.getTaskSummaryVo();
                }
            }
            LandingDataVo landingdata = new LandingDataVo();
            landingdata.setAction(LandingDataVo.LandingAction.VIEW);
            landingdata.setIsDynamicMdl(isDynamicMdl);
            if (applyBPM) {

                if (vo != null) {
                    landingdata.setTasksummary(vo);
                    landingdata.setBpmwfid(bpmID);
                    landingdata.setWfid(vo.getWfid());
                }
                landingdata.setIsBPMEnabled(true);
            } else {
                landingdata.setTasksummary(null);
            }
            ArrayList reflist = new ArrayList();
            reflist.add(refno);
            landingdata.setReferenceNumber(refno);
            landingdata.setData(reflist);
            // nfr-8013(viewmodechanges)
            this.viewlist = new ArrayList<>();
            this.viewlist = ((List) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .get("DashboardModelMenuDetails") != null)
                            ? (List<MenuVo>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                                    .get("DashboardModelMenuDetails")
                            : new ArrayList<>();
            if (this.viewlist != null && !this.viewlist.isEmpty()) {
                List viewresult = (List) this.viewlist.stream()
                        .filter(line -> (this.model.getDataModel().getMdlId().equalsIgnoreCase(line.getModuleid())
                                && "Y".equalsIgnoreCase(line.getViewModeEnable())))
                        .collect(Collectors.toList());
                // System.out.println("lnd target moduleid" +
                // this.model.getDataModel().getMdlId() + ">> viewEyeRender >>>" +
                // viewresult.toString());
                if (viewresult != null && !viewresult.isEmpty() && this.name != null && this.name.equalsIgnoreCase("parent")) {
                    RequestContext.getCurrentInstance().execute("eyeViewEnable();");
                    RequestContext.getCurrentInstance().execute("toggleViewMode();");
                }
            }
            landingdata = powerEditChecker(landingdata);
            if (name != null && name.equalsIgnoreCase("parent")) {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, true);
            } else {
                NFRUtils.navigateTo(model.getDataModel().getMdlId(), redirectMdlId, landingdata, false, true);
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    private void makeWidgets() {
        // logger.info("lndcbean","widgetMap====" + widgetMap);
        this.model.getDataModel().setWidgetVolist(new ArrayList());
        WidgetVo vo;
        if (widgetMap != null && widgetList != null) {
            for (int j = 0; j < widgetList.size(); j++) {
                int k = j + 1;
                String strclass = "dlp-bg" + k;
                vo = new WidgetVo();
                vo.setWvalue(widgetList.get(j));
                vo.setTitle(widgetList.get(j));

                if (widgetToolTipConfig != null && widgetToolTipConfig.containsKey(widgetList.get(j))) {
                    // // System.out.println("=======1=====>>>" +
                    // widgetToolTipConfig.get(widgetList.get(j)));
                    vo.setTooltip(widgetToolTipConfig.get(widgetList.get(j)).toString());
                } else {
                    // // System.out.println("=======2=====>>>" +
                    // getDefaultWidgetTitle(widgetList.get(j)));
                    vo.setTooltip(getDefaultWidgetTitle(widgetList.get(j)));
                }
                // // System.out.println("widgetMap.get(widgetList.get(j).trim())===" +
                // widgetMap.get(widgetList.get(j).trim()));
                vo.setCount(widgetMap.get(widgetList.get(j).trim()));
                vo.setStrclass(strclass);
                // feb
                Iterator itr1 = WidgetconfigMapwithoutdot.keySet().iterator();
                while (itr1.hasNext()) {
                    String wcolumnName = "";
                    Object nextElement = itr1.next();
                    if (nextElement != null) {
                        wcolumnName = nextElement.toString();
                    }
                    if(wcolumnName.toString()!=null && !wcolumnName.isEmpty()){
//                     itr1.next().toString();
                    wcolumnName = wcolumnName.replaceAll("\\.", "");
                    // System.out.println("wcolumnName=====================" + wcolumnName);
                    ArrayList valuelist = (ArrayList) WidgetconfigMapwithoutdot.get(wcolumnName);
                    // System.out.println("valuelist=====================" + valuelist);
                    if (valuelist.contains(widgetList.get(j).trim())) {
                        // System.out.println("=========entered inside============");
                        vo.setwColumnname(wcolumnName);
                        break;
                    }
                }
                }
                // feb
                // feb vo.setwColumnname(widgetcolumn);
                if (widgetList.get(j).equalsIgnoreCase("chatapplicable")) {
                    vo.setwColumnname("chatapplicable");
                    vo.setTitle("My Chats");
                    vo.setTooltip(getDefaultWidgetTitle("Chat"));
                    vo.setWvalue("Yes");
                } else if (widgetList.get(j).equalsIgnoreCase("notificationapplicable")) {
                    vo.setwColumnname("notificationapplicable");
                    vo.setWvalue("Yes");
                    vo.setTooltip(getDefaultWidgetTitle("Notification"));
                    vo.setTitle("My Notification");
                }
                this.model.getDataModel().getWidgetVolist().add(vo);
            }

            widgetvolistSize = widgetList.size();
        }
    }

    // public void callWidgetFilter(ActionEvent evt) {
    //
    // int id = ((Integer)
    // evt.getComponent().getAttributes().get("index")).intValue();
    // WidgetVo vo = ((WidgetVo) evt.getComponent().getAttributes().get("vo"));
    //
    // String strid = "repeatVOlst-" + id + "-filterSymbl";
    // logger.info("lndcbean","strid===" + strid);
    // logger.info("lndcbean","vo===" + vo.getWvalue());
    // logger.info("lndcbean","widgetcolumn===" + widgetcolumn);
    // RequestContext.getCurrentInstance().execute("Widgetfilter('" + strid + "','"
    // + widgetcolumn + "','" + vo.getWvalue() + "')");
    //
    // }
    //
    // public void callWidgetFilter2() {
    //
    // String strid = "repeatVOlst-" + "0-filterSymbl";
    // logger.info("lndcbean","strid===" + strid);
    //// logger.info("lndcbean","vo===" + vo.getWvalue());
    // logger.info("lndcbean","widgetcolumn===" + widgetcolumn);
    // RequestContext.getCurrentInstance().execute("Widgetfilter('" + strid + "','"
    // + widgetcolumn + "','Reviewed')");
    //
    // }
    // private void makeWidgetCountMap(HashMap hmap) {
    // try {
    // String status = (String) hmap.get(statusdescwithoutdot);
    // int count = 0;
    // if (widgetMap.containsKey(status.trim())) {
    // count = widgetMap.get(status);
    // count = count + 1;
    // widgetMap.put(status, count);
    // }
    // } catch (Exception e) {
    // logger.fatal(e);
    // }
    //
    // }
    private void makeWidgetCountMap(List hmaplist) {
        try {
            if (widgetMap != null && hmaplist != null) {
                // System.out.println("hmaplist.size============" + hmaplist.size());
                for (int i = 0; i < hmaplist.size(); i++) {
                    HashMap hmap = (HashMap) hmaplist.get(i);
                    String status = (String) hmap.get(widgetcolumn);
                    String chatapplicable = (String) hmap.get("chatapplicable");
                    String notificationapplicable = (String) hmap.get("notificationapplicable");
                    String taskapplicable = (String) hmap.get("Taskapplicable");
                    String alerts = (String) hmap.get("alerts");
                    // logger.info("lndcbean","status=====" + status);
                    int count;
                    if (wcolumnlist != null && wcolumnlist.size() > 0) {
                        for (int ii = 0; ii < wcolumnlist.size(); ii++) {  // feb
                            if (hmap.containsKey(wcolumnlist.get(ii).toString())) {
                                status = (String) hmap.get(wcolumnlist.get(ii).toString()); // feb
                                if (status != null && widgetMap.containsKey(status.trim())) {
                                    count = widgetMap.get(status.trim());
                                    count = count + 1;
                                    widgetMap.put(status.trim(), count);
                                }
                            }
                        }
                    } // feb
                    if (chatapplicable != null && chatapplicable.equalsIgnoreCase("Yes")) {
                        count = widgetMap.get("chatapplicable");
                        count = count + 1;
                        widgetMap.put("chatapplicable", count);
                    }
                    if (notificationapplicable != null && notificationapplicable.equalsIgnoreCase("Yes")) {
                        count = widgetMap.get("notificationapplicable");
                        count = count + 1;
                        widgetMap.put("notificationapplicable", count);
                    }
                    if (alerts != null && alerts.equalsIgnoreCase("Yes")) {
                        count = widgetMap.get("alerts");
                        count = count + 1;
                        widgetMap.put("alerts", count);
                    }
                    // if (taskapplicable != null && taskapplicable.equalsIgnoreCase("Yes")) {
                    // count = widgetMap.get("Taskapplicable");
                    // count = count + 1;
                    // widgetMap.put("Taskapplicable", count);
                    // }

                    // }
                }
            }
            // System.out.println("widgetMap====makeWidgetCountMap=========" + widgetMap);
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    boolean rendermaintable = true;
    boolean renderunhandledtable = false;

    public boolean isRendermaintable() {
        return rendermaintable;
    }

    public void setRendermaintable(boolean rendermaintable) {
        this.rendermaintable = rendermaintable;
    }

    public boolean isRenderunhandledtable() {
        return renderunhandledtable;
    }

    public void setRenderunhandledtable(boolean renderunhandledtable) {
        this.renderunhandledtable = renderunhandledtable;
    }

    public void checkincludeopenitems() {
        try {
            Load();

        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    public void enableunhanledtable() {
        try {
            if (this.model.getDataModel().isOpenunhandledtable()) {
                rendermaintable = false;
                renderunhandledtable = true;
                // if (widgetList != null && widgetList.size() > 0) {
                // for (int i = 0; i < widgetList.size(); i++) {
                // widgetMap.put(widgetList.get(i), 0);
                // }
                // }
                dynamicstyle = "doublegrid";
                // makeWidgetCountMap(model.getDataModel().getUnhandleddynamicEntityMap());

                // makeWidgets();
            } else {
                rendermaintable = true;
                renderunhandledtable = false;
                // if (widgetList != null && widgetList.size() > 0) {
                // for (int i = 0; i < widgetList.size(); i++) {
                // widgetMap.put(widgetList.get(i), 0);
                // }
                // }
                dynamicstyle = "singlegrid";
                // makeWidgetCountMap(model.getDataModel().getDynamicEntityMap());
                // makeWidgets();
            }

            // RequestContext.getCurrentInstance().update("landingPageForm");
            RequestContext.getCurrentInstance().update("LND_dataTableNewPanel");
            RequestContext.getCurrentInstance().update("LND_dataTableNewPanel2");
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    private void setConfigDates() {
        try {
            logger.info("lndcbean","setConfigDates===");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

            mDataMap.put("todate", sdf.format(addhrs(new Date())));
            Date fromDate = addDates(new Date(), -defaultrange);

            Calendar cal = Calendar.getInstance();
            cal.setTime(fromDate);
            cal.set(Calendar.DATE, 1);
            Date fromDate1 = cal.getTime();
            findDateDiff(fromDate1);
            mDataMap.put("fromdate", sdf1.format(fromDate1));
            // RequestContext.getCurrentInstance().execute("setInitialDates('" +
            // getDateToString(new Date()) + "','" + getDateToString(fromDate) + "')");

        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    private void findDateDiff(Date inputDate) {
        try {
            Date dateBefore = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(new SimpleDateFormat("yyyy-MM-dd").format(inputDate));
            Date dateAfter = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            long difference = dateAfter.getTime() - dateBefore.getTime();
            float daysBetween = (difference / (1000 * 60 * 60 * 24));
            defaultrange = (int) daysBetween;
            // System.out.println("defaultrange===" + defaultrange);
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    private Date addhrs(Date inputDate) {
        Calendar cal = Calendar.getInstance();
        logger.info("lndcbean","defaultrange in addhrs method===");
        try {
            cal.setTime(inputDate);
            cal.add(Calendar.HOUR_OF_DAY, 23);
            cal.add(Calendar.MINUTE, 59);
            // System.out.println("cal.getTime()===" + cal.getTime());
        } catch (Exception e) {
            logger.fatal(e);
        }
        return cal.getTime();
    }

    private Date addDates(Date inputDate, int defaultrange) {
        Calendar cal = Calendar.getInstance();
        logger.info("lndcbean","defaultrange in addDates method===" + defaultrange);
        try {
            cal.setTime(inputDate);
            cal.add(Calendar.DAY_OF_MONTH, defaultrange);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return cal.getTime();
    }

    private void getAssignDefaultRange() {
        defaultrange = 60;
        try {

            Systemconfig syscconvo = this.mackUtility.getSystemconfig("LND_defaultrange");
            if (syscconvo.getSysvalue() != null && syscconvo.getSysvalue().length() > 0) {
                defaultrange = Integer.parseInt(syscconvo.getSysvalue());
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
    }

    private String getDefaultWidgetTitle(String status) {
        String title = "";
        try {
            // getlndsystemconfig getlndsystemconfig
            String param = "LND_" + status;
            // System.out.println("param===" + param);
           // CompleteModel model = this.service.getlndsystemconfig(param);
          
            Systemconfig svoList =  this.mackUtility.getSystemconfig(param);
            if (svoList.getSysvalue() != null && svoList.getSysvalue().length() > 0){
                String value = svoList.getSysvalue();
                if (value != null && value.length() > 0) {
                    title = value;
                }
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return title;
    }

    /*
     * Action Defination ex:
     * {"groupbutton":{
     * 
     * "tempfinal_RAO.newbtn":{
     * "new":{
     * "targetmdl":"RAO",
     * "navigateflag":true,
     * "renderidentifier":{
     * "column":"tempfinal_RAO.btnnew",
     * "values":["0"]
     * }
     * }
     * }
     * }
     * }
     * 
     */
    private TaskSummaryVo getCurrentTaskSummaryVo(String refno) {
        TaskSummaryVo tsmvo = null;
        try {
            StatusVo svo = smbpmUtil.getTaskSummaryByRefno(refno);
            tsmvo = svo.getTaskSummaryVo();

        } catch (Exception e) {
            logger.fatal(e);
        }

        return tsmvo;
    }

    private boolean checkRevokable(TaskSummaryVo taskSummary) {
        boolean allow = false;
        try {
            StatusVo svo = smbpmUtil.isRevokable(taskSummary, mData.getMetaData(USERINFO.USERCODE));

            if (svo.getStatus() != null && svo.getStatus().toString().trim().equalsIgnoreCase("Success")) {
                // System.out.println("checkRevokable ===>>> true");
                allow = true;
            }
        } catch (Exception e) {
            logger.fatal(e);
        }
        return allow;
    }

    private void userCompanyList() {
        try {
            // System.out.println("ShoremasterList================" +
            // ShoremasterList.size());
            String companycode = mData.getMetaData(APPINFO.COMPANY_CODE);

            // CompleteModel model = this.service.checkheadoffice(companycode, "A");

            List<com.svm.mac.atc.model.entity.Shoremaster> shorelist = ShoremasterList.stream()
                    .filter(e -> e.getShorecode().equalsIgnoreCase(companycode)).collect(Collectors.toList());
            com.svm.mac.atc.model.entity.Shoremaster sm = shorelist.get(0);
            if (sm.getIshead() != null && sm.getIshead().trim().equalsIgnoreCase("Y")) {
                companynamelist.addAll(
                    ShoremasterList.stream()
                        .filter(a -> a.getCorporateid() == sm.getCorporateid()) // Filter by corporate ID
                        .map(a -> a.getShorename() != null ? a.getShorename().trim().toUpperCase() : "") // Map to Shorename and handle null
                        .filter(name -> !name.isEmpty()) // Filter out empty names
                        .collect(Collectors.toList()) // Collect names into a list and add them to companynamelist
                );
                } else {
                    companynamelist.add(mData.getMetaData(APPINFO.COMPANY_NAME).trim().toUpperCase());
                }
            
            // System.out.println("companynamelist======" + companynamelist);
        } catch (Exception e) {
            logger.fatal(e);
        }

    }

    private boolean validatetoAdd(String companyname) {
        boolean toadd = false;
        try {
            if (PROJECTTYPE.trim().equalsIgnoreCase("CNT001")) {
                // // System.out.println("companyname====" + companyname);
                // // System.out.println("companynamelist===" + companynamelist);
                if (companynamelist.contains(companyname.trim().toUpperCase())) {
                    toadd = true;

                }
            } else {
                toadd = true;
            }
            // // System.out.println("companyname================" + companyname +
            // "===================" + toadd);
        } catch (Exception e) {
            logger.fatal(e);
        }
        return toadd;
    }

    public void getDelReqRefnos() {
        try {
            
            CompleteModel model = this.service.getdelreqrefno("'REQ','STC'", this.model.getDataModel().getMdlId());
            if (model.getDeleterequest() != null && model.getDeleterequest().size() > 0) {
                delreqlist.addAll(
                    model.getDeleterequest().stream()
                        .map(req -> req.getMdlrefno().toUpperCase())
                        .collect(Collectors.toList())
                );
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getSuperEditor() {
        try {
        
            CompleteModel superEditorModel = this.service.getsupereditor(this.model.getDataModel().getMdlId(),
                    mData.getMetaData(APPINFO.COMPANY_CODE), "A", "A");
            if (superEditorModel.getMdl_super_user() != null && !superEditorModel.getMdl_super_user().isEmpty()) {
                superEditorList = superEditorModel.getMdl_super_user();
            }
           // logger.info("lndcbean","---lndgetSuperEditor list size " + superEditorList.size());
           
        } catch (Exception e) {
            logger.info("lndcbean","---lndgetSuperEditor Exception " + e);
            e.printStackTrace();
        }
    }

    public boolean superEditChecker() {
        boolean valueBool = false;
        try {

            Set<String> valueSet = new HashSet<>();
            if (superEditorList != null) {
                for (Mdl_super_user mdlSuperUser : superEditorList) {
                    if (mdlSuperUser.getUsercode().trim().equalsIgnoreCase(mData.getMetaData(USERINFO.USERCODE))) {
                        valueSet.add("true");
                    } else {
                        valueSet.add("false");
                    }
                }
                if (valueSet.stream().anyMatch(value -> value.equals("true"))) {
                    valueBool = true;
                } else {
                    valueBool = false;
                }
            }
          //  logger.info("lndcbean","---lndsuperEditChecker valueBool " + valueBool);
        } catch (Exception e) {
            logger.info("lndcbean","---lndsuperEditChecker Exception " + e);
            e.printStackTrace();
        }

        return valueBool;

    }

    public boolean superEditRestrictor(HashMap hm) {
        try {
            HashMap<Object, Object> rowData = new HashMap<>();
            rowData = hm;
            boolean restrict = false;
            try {
                if (rowData != null && rowData.containsKey(this.model.getDataModel().getSuperEditRestrictorColumn())
                        && rowData
                                .get(this.model.getDataModel().getSuperEditRestrictorColumn()) != null
                        && this.model
                                .getDataModel().getSuperEditRestrictorColumn() != null
                        && this.model
                                .getDataModel().getSuperEditRestrictorValues() != null) {
                    String columnValue = rowData.get(this.model.getDataModel().getSuperEditRestrictorColumn())
                            .toString();
                    restrict = model.getDataModel().getSuperEditRestrictorValues().stream()
                            .anyMatch(str -> str.trim().equalsIgnoreCase(columnValue));
                    restrict = !restrict;
                    return restrict;
                } else {
                   // logger.info("lndcbean","---lndsuperEditRestrictor No configuration");
                }
            } catch (Exception e) {
                logger.info("lndcbean","---lndsuperEditRestrictor Exception " + e);
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            logger.info("lndcbean","---lndsuperEditRestrictor Exception " + e);
            e.printStackTrace();
        }

        return false;
    }

    public void windowOpenedState(ActionEvent evt) throws ScriptException, IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        name = map.get("windowname");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("viewmodemdltabname", name);
    }

    public void guidanceRedirect() {
        this.logger.info("lndcbean","==|== GuidanceRedirect ==|==>");
        LandingDataVo landingdata = new LandingDataVo();
        NFRUtils.navigateTo("CLL", "GDC", landingdata, false, true);
    }

    private void isEnableOtherlistToggle() {
        try {
            Systemconfig syscconvo = this.mackUtility.getSystemconfig("Landingpage-To show other records");

            if (syscconvo.getSysvalue() != null && syscconvo.getSysvalue().length() > 0
                    && applyhandlybyuserlogic != null && applyhandlybyuserlogic.trim().equalsIgnoreCase("Y")) {
                if (syscconvo.getSysvalue().equalsIgnoreCase("Yes")) {
                    this.model.getStateModel().setEnableunhandledswitch(true);
                } else {
                    this.model.getStateModel().setEnableunhandledswitch(false);
                }
            } else {
                this.model.getStateModel().setEnableunhandledswitch(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public LandingDataVo powerEditChecker(LandingDataVo landingdata) {
        try{
            logger.info("---lnd---powerEditChecker start " + tenantIdentifier);
            HashMap<String, String> paramMap = new HashMap<String, String>();
            HashMap<String, String> returnMap = new HashMap<String, String>();
            paramMap.put("moduleId", this.model.getDataModel().getMdlId());
            paramMap.put("shoreCode", mData.getMetaData(APPINFO.COMPANY_CODE));
            paramMap.put("userCode", mData.getMetaData(USERINFO.USERCODE));
            paramMap.put("referenceNumber", landingdata.getReferenceNumber());
            paramMap.put("tenantIdentifier", tenantIdentifier);
            returnMap = iPowerEditChecker.powerEditChecker(paramMap);
            if(returnMap != null){
                if(returnMap.get("PowerEditor") != null && returnMap.get("PowerEditorType") != null){
                    landingdata.setPowerEditor("t".equalsIgnoreCase(returnMap.getOrDefault("PowerEditor", "")));
                    landingdata.setPowerEditorType(returnMap.get("PowerEditorType"));
                }
            }
            logger.info("---lnd---powereditor values " + landingdata.isPowerEditor() + " " + landingdata.getPowerEditorType());
        }catch(Exception e){
            logger.info("lndcbean","---lnd---powerEditChecker Exception " + e);
            logger.fatal(e);
            e.printStackTrace();
        }
        return landingdata;
    }


    public List<DefaultColumnModel> getNonbpmcolumnlistCtrl() {
        return nonbpmcolumnlistCtrl;
    }

    public void setNonbpmcolumnlistCtrl(List<DefaultColumnModel> nonbpmcolumnlistCtrl) {
        this.nonbpmcolumnlistCtrl = nonbpmcolumnlistCtrl;
    }

    public String getDynamicstyle() {
        return dynamicstyle;
    }

    public void setDynamicstyle(String dynamicstyle) {
        this.dynamicstyle = dynamicstyle;
    }

    public ArrayList<String> getCompanynamelist() {
        return companynamelist;
    }

    public void setCompanynamelist(ArrayList<String> companynamelist) {
        this.companynamelist = companynamelist;
    }

    public boolean isDisMyactions() {
        return disMyactions;
    }

    public void setDisMyactions(boolean disMyactions) {
        this.disMyactions = disMyactions;
    }

    public String getMyactiontooltip() {
        return myactiontooltip;
    }

    public void setMyactiontooltip(String myactiontooltip) {
        this.myactiontooltip = myactiontooltip;
    }

    public int getWidgetvolistSize() {
        return widgetvolistSize;
    }

    public void setWidgetvolistSize(int widgetvolistSize) {
        this.widgetvolistSize = widgetvolistSize;
    }

    public int getDefaultrange() {
        return defaultrange;
    }

    public void setDefaultrange(int defaultrange) {
        this.defaultrange = defaultrange;
    }

    public boolean isRendergrid() {
        return rendergrid;
    }

    public void setRendergrid(boolean rendergrid) {
        this.rendergrid = rendergrid;
    }

    public int getBtnEditRenderInHmcount() {
        return btnEditRenderInHmcount;
    }

    public void setBtnEditRenderInHmcount(int btnEditRenderInHmcount) {
        this.btnEditRenderInHmcount = btnEditRenderInHmcount;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    List<Map<String, Object>> Hmrows = null;

    public String getClaimedusername() {
        return claimedusername;
    }

    public void setClaimedusername(String claimedusername) {
        this.claimedusername = claimedusername;
    }

    public String getClaimeduserdepname() {
        return claimeduserdepname;
    }

    public void setClaimeduserdepname(String claimeduserdepname) {
        this.claimeduserdepname = claimeduserdepname;
    }

    public String getClaimedusergroupname() {
        return claimedusergroupname;
    }

    public void setClaimedusergroupname(String claimedusergroupname) {
        this.claimedusergroupname = claimedusergroupname;
    }

    public String getClaimeduserrankname() {
        return claimeduserrankname;
    }

    public void setClaimeduserrankname(String claimeduserrankname) {
        this.claimeduserrankname = claimeduserrankname;
    }

    //
    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getDatetimeformat() {
        return datetimeformat;
    }

    public void setDatetimeformat(String datetimeformat) {
        this.datetimeformat = datetimeformat;
    }

    public List<Pictask> getAdrList() {
        return adrList;
    }

    public void setAdrList(List<Pictask> adrList) {
        this.adrList = adrList;
    }

    public int getOnDemandRowIndex() {
        return onDemandRowIndex;
    }

    public void setOnDemandRowIndex(int onDemandRowIndex) {
        this.onDemandRowIndex = onDemandRowIndex;
    }

    public List<String> getPowerEditorWorkflowGroup() {
        return powerEditorWorkflowGroup;
    }

    public void setPowerEditorWorkflowGroup(List<String> powerEditorWorkflowGroup) {
        this.powerEditorWorkflowGroup = powerEditorWorkflowGroup;
    }

    public List<String> getPowerEditorUsercode() {
        return powerEditorUsercode;
    }

    public void setPowerEditorUsercode(List<String> powerEditorUsercode) {
        this.powerEditorUsercode = powerEditorUsercode;
    }

}
