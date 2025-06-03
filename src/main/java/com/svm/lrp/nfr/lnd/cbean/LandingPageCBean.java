package com.svm.lrp.nfr.lnd.cbean;

import com.svm.jsf.nfr.module.RightsIntercptor;
import com.svm.json.SvmJsonUtil;
import java.io.Serializable;
import javax.inject.Named;
import com.svm.lrp.jsf.context.scope.LRPViewScope;
import com.svm.lrp.nfr.impModel.ImportResponse;
import com.svm.lrp.nfr.jsf.exp.IFileExport;
import com.svm.lrp.nfr.jsf.importutil.IImport;
import com.svm.lrp.nfr.jsf.utils.AbsToolBarUtils;
import com.svm.lrp.nfr.jsf.utils.Category;
import com.svm.lrp.nfr.jsf.utils.ILogger;
import com.svm.lrp.nfr.jsf.utils.IMetaData;
import com.svm.lrp.nfr.jsf.utils.ISearch;
import com.svm.lrp.nfr.jsf.utils.IToolBar;
import com.svm.lrp.nfr.jsf.utils.NFRUtils;
import com.svm.lrp.nfr.jsf.utils.SMDialogUtil;
import com.svm.lrp.nfr.jsf.utils.USERINFO;
import com.svm.lrp.nfr.lnd.ctrl.LandingPageCtrl;
import com.svm.lrp.nfr.lnd.model.LandingPageModel;
import com.svm.lrp.nfr.lnd.vds.LandingPageVds;
import com.svm.lrp.nfr.lnd.vo.CompleteModel;
import com.svm.lrp.nfr.mack.QuickModuleRights;
import com.svm.lrp.nfr.main.bean.ToolbarCBean;
import com.svm.lrp.nfr.query.cbean.VDSInvoker;
import com.svm.mac.macs.multitenanacy.INFRMultiTenanacyUtil;
import com.svm.mac.macs.sps.ds.cntr.IVesselParticulers;
import com.svm.mac.macs.sps.importexcel.CommunicationTab;
import com.svm.mac.macs.sps.importexcel.DimensionDetailsTab;
import com.svm.mac.macs.sps.importexcel.MachineryDetailsTab;
import com.svm.mac.macs.sps.importexcel.ManagmentResourceTab;
import com.svm.mac.macs.sps.model.vds.VDSVesselParticulers;
import com.svm.mac.nfr.usd.importexcel.BasicInformationTab;
import com.svm.mac.nfr.usd.importexcel.DetailedInformationTab;
import com.svm.mac.nfr.usd.importexcel.FinalModel;
import com.svm.mac.nfr.usd.importexcel.UserDetail;
import com.svm.mac.nfr.util.cacheinformation.IMDMCacheUtil;
import com.svm.mac.nfr.util.powerEdit.vds.IPowerEditChecker;
import com.svm.mac.util.MackUtil_IF;
import com.svm.mac.util.MackUtility;
import com.svm.mac.wfa.bean.WFHistoryUtil;
import com.svm.mack.util.MackBpmUtil;
import com.svm.nfr.notify.smbpmutil.ISMBPMUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import org.primefaces.event.SelectEvent;
import svm.nfr.sec.SMMessageDigest;

@LRPViewScope
@Named("LandingPageCBean")
@Interceptors({RightsIntercptor.class})
public class LandingPageCBean implements Serializable, ISearch, IToolBar, IImport {

    @Inject
    @Category(name = "Landing_Page")
    ILogger logger;

//    @Inject
//    ILogger logger;
    @Inject
    VDSInvoker serviceInvoker;
    SMDialogUtil dUtil;

    LandingPageCtrl ctrl;
    LandingPageModel model;

    @Inject
    ToolbarCBean toolbar;

    @Inject
    QuickModuleRights quickModuleRights;

    @Inject
    ISMBPMUtil smbpmUtil;

    @Inject
    IFileExport fileexp;

    IMetaData mData;

    LandingPageVds service;

    @Inject
    MackUtility mackUtility;
   @Inject
    WFHistoryUtil wFHistoryUtil;
    IVesselParticulers spsService;

    @Inject
    MackBpmUtil mbutil;
    @Inject
    INFRMultiTenanacyUtil multitenency;

      @Inject
    IMDMCacheUtil Cacheintr;
    
    @Inject
    IPowerEditChecker IPowerEditChecker;

    public LandingPageCBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.mData = NFRUtils.getMetaData();
            model = new com.svm.lrp.nfr.lnd.model.LandingPageModel();
            // logger.info("="+this.model.dataModel.mdlId+"_LND_datagrid";
            String mdl = toolbar.getModuleId() + "_LND_datagrid";
            model.getDataModel().setGridid(mdl);
            model.getDataModel().setSecondgridid(toolbar.getModuleId() + "_LND_secondgridid");
            model.getDataModel().setMdlId(toolbar.getModuleId());
            this.service = serviceInvoker.create(LandingPageVds.class);
            this.spsService = serviceInvoker.create(IVesselParticulers.class);
            logger.info("===model=====>" + model);
            this.dUtil = new SMDialogUtil("landingPageForm_progress");
            ctrl = new LandingPageCtrl(logger, serviceInvoker, model, quickModuleRights, smbpmUtil, dUtil, fileexp, mackUtility, mbutil,wFHistoryUtil,multitenency,Cacheintr, IPowerEditChecker);
            logger.info("//==//==|VALUE OF model.getDataModel().getGridid()|======>" + model.getDataModel().getGridid());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("LND-CURRENT-MDL", model.getDataModel().getGridid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private LandingPageLocal lookupLandingPageBean() throws RemoteException, NamingException, CreateException {
//        logger.info("---inside lookup------");
//        LandingPageLocal rv = null;
//        try {
//            javax.naming.Context c = new javax.naming.InitialContext();
//            rv = (LandingPageLocal) c.lookup("java:global/lndejb/LandingPageBean!com.svm.lrp.nfr.lnd.ejb.LandingPageLocal");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rv;
//    }
//    @PreDestroy()
//    public void releaseConnection()
//    {
//  
//        logger.info("PreDestroy called"+toolbar.getModuleId());
//      
//    }
    @Override
    public void getSearchData(String idvalue, Object o) {
      logger.info("idvalue=====" + idvalue);
        ctrl.btnrefsearchActionListener((ArrayList) o);
    }

    public ToolbarCBean getToolbar() {
        return toolbar;
    }

    public void setToolbar(ToolbarCBean toolbar) {
        this.toolbar = toolbar;
    }

    public LandingPageModel getModel() {
        return model;
    }

    public void setModel(LandingPageModel model) {
        this.model = model;
    }

    public ILogger getLogger() {
        return logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public VDSInvoker getServiceInvoker() {
        return serviceInvoker;
    }

    public void setServiceInvoker(VDSInvoker serviceInvoker) {
        this.serviceInvoker = serviceInvoker;
    }

    public LandingPageCtrl getCtrl() {
        return ctrl;
    }

    public void setCtrl(LandingPageCtrl ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public String onImportExcel(ImportResponse impr) {
        logger.info("//==//==|VALUE OF model.getDataModel().getMdlId()|==>" + model.getDataModel().getMdlId());
        if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("USD")) {
            logger.info("//==//==|INSIDE USD MODULE ID|==>");
            userDetailImportExcel(impr);
        } else if (model.getDataModel().getMdlId().trim().equalsIgnoreCase("SPS")) {
            logger.info("//==//==|INSIDE SPS MODULE ID|==>");
            vesselPartucilarsImportExcel(impr);
        }
        return null;
    }

    void vesselPartucilarsImportExcel(ImportResponse imp) {
        logger.info("//--/--|INSIDE ON IMPORT EXCEL |++-->");
        try {
            logger.info("File name in client side=====>" + imp.getFilename());
            logger.info("inside client=###=======>" + imp.getResultdata().toString());
            if ("SPS2".equalsIgnoreCase(imp.getProfileid().trim())) {
                Map statusMap = new HashMap();
                FinalModel finalmodel = null;

                com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS baseInfovo = new com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS();
                com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS detailInfoVo = new com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS();

                DimensionDetailsTab dimensionDetVo = new DimensionDetailsTab();
                ManagmentResourceTab managmentResVo = new ManagmentResourceTab();
                MachineryDetailsTab machineryDetVo = new MachineryDetailsTab();
                CommunicationTab communicationVo = new CommunicationTab();

                ArrayList lst = null;

                SvmJsonUtil util = new SvmJsonUtil();

                finalmodel = (FinalModel) util.toObject(imp.getResultdata().toString(), FinalModel.class);
                logger.info("//--//SIZE OF BASIC INFO---------->TAB 1 LIST===>>>" + finalmodel.getVslMstrBasInfoImptList().size());
                logger.info("//--//SIZE OF DETAILE INFO-------->TAB 2 LIST===>>>" + finalmodel.getVslMstrDetInfoImptList().size());
                logger.info("//--//SIZE OF DIMENSION DETAIL---->TAB 3 LIST===>>>" + finalmodel.getVslMstrDimDetImptList().size());
                logger.info("//--//SIZE OF MANAGMENT RESOURSE-->TAB 4 LIST===>>>" + finalmodel.getVslMstrMngtRsImptList().size());
                logger.info("//--//SIZE OF MACINERY DETAILS --> TAB 5 LST ===>>>" + finalmodel.getVslMstrMcDetImptList().size());
                logger.info("//--//SIZE OF COMMUNICATION  ----->TAB 6 LIST===>>>" + finalmodel.getVslMstrCommImptList().size());

                ((com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(0)).getVesselcode();
                ((com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(0)).getVesselname();
                ((com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(0)).getVesselTypeCode();
                ((com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(0)).getFlagcode();
                ((com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(0)).getTypeManagement();

                lst = new ArrayList();
                for (int i = 0; i < finalmodel.getVslMstrBasInfoImptList().size(); i++) {
                    baseInfovo = (com.svm.mac.macs.sps.importexcel.BasicInformationTabSPS) finalmodel.getVslMstrBasInfoImptList().get(i);
                    lst.add(baseInfovo);
                }

                this.model.getDataModel().setBaseInfoListfromXcel(lst);
                logger.info("//--//SIZE OF|getBaseInfoListfromXcel|===>>>" + this.model.getDataModel().getBaseInfoListfromXcel().size());

                lst = new ArrayList();
                for (int j = 0; j < finalmodel.getVslMstrDetInfoImptList().size(); j++) {
                    detailInfoVo = (com.svm.mac.macs.sps.importexcel.DetailedInformationTabSPS) finalmodel.getVslMstrDetInfoImptList().get(j);
                    lst.add(detailInfoVo);
                    logger.info("//--//OUTPUT OF|detailInfoVo Insurancehullmachineries|===>>>" + detailInfoVo.getInsurancehullmachineries());
                }

                this.model.getDataModel().setDetailedInfoListfromXcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().setDetailedInfoListfromXcel(lst)|===>>>" + this.model.getDataModel().getDetailedInfoListfromXcel().size());

                lst = new ArrayList();
                for (int k = 0; k < finalmodel.getVslMstrDimDetImptList().size(); k++) {
                    dimensionDetVo = (DimensionDetailsTab) finalmodel.getVslMstrDimDetImptList().get(k);
                    lst.add(dimensionDetVo);
                }

                this.model.getDataModel().setDimensionDetInfoListFromxcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().setDimensionDetInfoListFromxcel(lst)|===>>>" + this.model.getDataModel().getDimensionDetInfoListFromxcel().size());

                lst = new ArrayList();
                for (int l = 0; l < finalmodel.getVslMstrMngtRsImptList().size(); l++) {
                    managmentResVo = (ManagmentResourceTab) finalmodel.getVslMstrMngtRsImptList().get(l);
                    lst.add(managmentResVo);
                    logger.info("//--//OUTPUT OF|managmentResVo getSuperintendent|===>>>" + managmentResVo.getSuperintendent());
                }

                this.model.getDataModel().setManagmentResourceListFromxcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().setManagmentResourceListFromxcel(lst)|===>>>" + this.model.getDataModel().getManagmentResourceListFromxcel().size());

                lst = new ArrayList();
                for (int m = 0; m < finalmodel.getVslMstrMcDetImptList().size(); m++) {
                    machineryDetVo = (MachineryDetailsTab) finalmodel.getVslMstrMcDetImptList().get(m);
                    lst.add(machineryDetVo);
                    logger.info("//--//OUTPUT OF|machineryDetVo getMainEngineMake|===>>>" + machineryDetVo.getMainEngineMake());
                }

                this.model.getDataModel().setMachineryDetListFromxcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().setMachineryDetListFromxcel(lst)|===>>>" + this.model.getDataModel().getMachineryDetListFromxcel().size());

                lst = new ArrayList();
                for (int n = 0; n < finalmodel.getVslMstrCommImptList().size(); n++) {
                    communicationVo = (CommunicationTab) finalmodel.getVslMstrCommImptList().get(n);
                    lst.add(communicationVo);
                    logger.info("//--//OUTPUT OF|communicationVo getSatEmail|===>>>" + communicationVo.getSatEmail());
                }

                this.model.getDataModel().setCommunicationListFromxcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().setCommunicationListFromxcel(lst)|===>>>" + this.model.getDataModel().getCommunicationListFromxcel().size());

                statusMap = getAllValuesFromExcelSPS();
//                if ((statusMap.get("status") != null) && (!statusMap.get("status").equals(""))
//                        && (statusMap.get("status").toString().trim().equalsIgnoreCase("200.0"))) {
//                    logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE|===>>>");
//                    this.dUtil.showDialog("SPS", SMDialogUtil.type.INFO, "01029003", "", null);
//                    logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE END|===>>>");
//                }

                if ((statusMap.get("status") != null) && (!statusMap.get("status").equals(""))
                        && (statusMap.get("status").toString().trim().equalsIgnoreCase("200.0"))) {
                    String save = "Saved successfully";
                    dUtil.showDialog("USD", SMDialogUtil.type.INFO, "19032010", "", new String[]{save});
                    logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE END|===>>>");
                }
            } else {
                logger.info("//--//============>You Are In Wrong ProfileId====================>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map getAllValuesFromExcelSPS() {
        logger.info("//--//|INSIDE FROM getAllValuesFromExcel |-->");
        Map statusmap = new HashMap();
        try {
            VDSVesselParticulers vdsModelForImport = new VDSVesselParticulers();
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 1|-->" + model.getDataModel().getBaseInfoListfromXcel().size());
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 2|-->" + model.getDataModel().getDetailedInfoListfromXcel().size());
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 3|-->" + model.getDataModel().getDimensionDetInfoListFromxcel().size());
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 4|-->" + model.getDataModel().getManagmentResourceListFromxcel().size());
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 5|-->" + model.getDataModel().getMachineryDetListFromxcel().size());
            logger.info("//--//----|IMPORT FROM EXCEL LIST SIZE TAB 6|-->" + model.getDataModel().getCommunicationListFromxcel().size());

//            List<VesselMaster> vmList = new ArrayList<>();
            // Note, MM is months Should be MM, not mm
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");

            int size = model.getDataModel().getBaseInfoListfromXcel().size();
           
            boolean error = false;
            String missingfield = "";
            int errorcnt = 1;
            for (int i = 0; i < size; i++) {
                com.svm.mac.macs.sps.model.entity.VesselMaster vm = new com.svm.mac.macs.sps.model.entity.VesselMaster();
                logger.info("//--//------------------->>>>>|INSIDE FOR LOOP IN IMPORTEXCEL=============>|===>>>");

                //BASIC INFORMATION
                logger.info("//--//OUTPUT OF|model.getDataModel().getBaseInfoListfromXcel().get(i))|===>>>" + model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselcode());
                logger.info("//--//OUTPUT OF|vm.getVesselcode|===>>>" + vm.getVesselcode());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselcode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselcode().isEmpty()) {
                    vm.setVesselcode(model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselcode());
                } else {
                    missingfield = "<br>" + missingfield + "<br>" + errorcnt + ". " + "VesselCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselname() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselname().isEmpty()) {
                    logger.info("inside vesselname if condition?????????");
                    vm.setVesselname(model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselname());
                } else {
                    logger.info("inside else condition >>>>>>>????????");
                    missingfield = missingfield + errorcnt + ". " + "VesselName" + "<br>";
                    error = true;
                    errorcnt++;
                }

//                logger.info("//--//OUTPUT OF|bit.getVesselname()|===>>>" + model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselname());
//                logger.info("//--//OUTPUT OF|getVesselname|===>>>" + vm.getVesselname());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselTypeCode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselTypeCode().equalsIgnoreCase("")) {
                    vm.setVesselTypeCode(model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselTypeCode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "VesselTypeCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
                //vm.setFleetcode(bit.getFleetcode());

                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getFlagcode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getFlagcode().equals("")) {
                    vm.setFlagcode(model.getDataModel().getBaseInfoListfromXcel().get(i).getFlagcode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "FlagCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getTypeManagement() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getTypeManagement().equals("")) {
                    vm.setTypeManagement(model.getDataModel().getBaseInfoListfromXcel().get(i).getTypeManagement());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "TypeOfMgnt" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getPortcode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getPortcode().equalsIgnoreCase("")) {
                    vm.setPortcode(model.getDataModel().getBaseInfoListfromXcel().get(i).getPortcode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "PortCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
//                logger.info("//--//OUTPUT OF|model.getDataModel().getBaseInfoListfromXcel().get(i).getBusinessSection()|===>>>" + model.getDataModel().getBaseInfoListfromXcel().get(i).getBusinessSection());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getBusinessSection() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getBusinessSection().equalsIgnoreCase("")) {
                    vm.setBusinessSection(model.getDataModel().getBaseInfoListfromXcel().get(i).getBusinessSection());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "BussinessSection" + "<br>";
                    error = true;
                    errorcnt++;
                }
//                logger.info("//--//OUTPUT OF|vm.getBussinessSection|===>>>" + vm.getBusinessSection());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getShorecode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getShorecode().equalsIgnoreCase("")) {
                    vm.setShorecode(model.getDataModel().getBaseInfoListfromXcel().get(i).getShorecode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "MgntCompany" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyIMONo() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyIMONo().equalsIgnoreCase("")) {
                    vm.setCompanyIMONo(model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyIMONo());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "CompanyIMONo" + "<br>";
                    error = true;
                    errorcnt++;
                }
                vm.setFormerCompany(model.getDataModel().getBaseInfoListfromXcel().get(i).getFormerCompany());

                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyAccountCode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyAccountCode().equalsIgnoreCase("")) {
                    vm.setCompanyAccountCode(model.getDataModel().getBaseInfoListfromXcel().get(i).getCompanyAccountCode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "CompanyAccountCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getOwnerAccountCode() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getOwnerAccountCode().equalsIgnoreCase("")) {
                    vm.setOwnerAccountCode(model.getDataModel().getBaseInfoListfromXcel().get(i).getOwnerAccountCode());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "OwnerAccountCode" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getCurrency() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getCurrency().equalsIgnoreCase("")) {
                    vm.setCurrency(model.getDataModel().getBaseInfoListfromXcel().get(i).getCurrency());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Currency" + "<br>";
                    error = true;
                    errorcnt++;
                }
//                logger.info("//--//OUTPUT OF|financialyearend in Basic InFO|===>>>" + model.getDataModel().getBaseInfoListfromXcel().get(i).getFinancialYearEnd());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getFinancialYearEnd() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getFinancialYearEnd().equalsIgnoreCase("")) {
                    vm.setFinancialYearEnd(model.getDataModel().getBaseInfoListfromXcel().get(i).getFinancialYearEnd());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "FinancialYearEnd" + "<br>";
                    error = true;
                    errorcnt++;
                }
//                logger.info("//--//OUTPUT OF|vm.getFinancialYearEnd|===>>>" + vm.getFinancialYearEnd());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselkpi() != null){
                        // && !model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselkpi().) {
                    vm.setVesselkpi(model.getDataModel().getBaseInfoListfromXcel().get(i).getVesselkpi());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Vesselkpi" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getShipyard() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getShipyard().equalsIgnoreCase("")) {
                    vm.setShipyard(model.getDataModel().getBaseInfoListfromXcel().get(i).getShipyard());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Shipyard" + "<br>";
                    error = true;
                    errorcnt++;
                }

//                logger.info("//--//OUTPUT OF|model.getDataModel().getBaseInfoListfromXcel().get(i).getDateOfBuilt|===>>>" + model.getDataModel().getBaseInfoListfromXcel().get(i).getDateOfBuilt());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getDateOfBuilt() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getDateOfBuilt().equalsIgnoreCase("")) {
                    String inputDate = model.getDataModel().getBaseInfoListfromXcel().get(i).getDateOfBuilt();
                    Date date = inputFormat.parse(inputDate);
                    String outputDate = outputFormat.format(date);
//                logger.info("//--//OUTPUT OF|outputDate|===>>>" + outputDate);

                    vm.setDateOfBuilt(outputDate);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "DateOfBuilt" + "<br>";
                    error = true;
                    errorcnt++;
                }
                logger.info("//--//OUTPUT OF|vm.setDateOfBuilt|===>>>" + vm.getDateOfBuilt());

                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getAge() != null
                        && model.getDataModel().getBaseInfoListfromXcel().get(i).getAge() != 0) {
                    String age = Integer.toString(model.getDataModel().getBaseInfoListfromXcel().get(i).getAge());

                    vm.setAge(age);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Age" + "<br>";
                    error = true;
                    errorcnt++;
                }
                logger.info("//--//OUTPUT OF|vm.getAge|===>>>" + vm.getAge());
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getHullno() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getHullno().equalsIgnoreCase("")) {
                    vm.setHullno(model.getDataModel().getBaseInfoListfromXcel().get(i).getHullno());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Hullno" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getImono() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getImono().equalsIgnoreCase("")) {
                    vm.setImono(model.getDataModel().getBaseInfoListfromXcel().get(i).getImono());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Imono" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getOfficialno() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getOfficialno().equalsIgnoreCase("")) {
                    vm.setOfficialno(model.getDataModel().getBaseInfoListfromXcel().get(i).getOfficialno());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Officialno" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getCallsign() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getCallsign().equalsIgnoreCase("")) {
                    vm.setCallsign(model.getDataModel().getBaseInfoListfromXcel().get(i).getCallsign());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Callsign" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getCbaca() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getCbaca().equalsIgnoreCase("")) {
                    vm.setCbaca(model.getDataModel().getBaseInfoListfromXcel().get(i).getCbaca());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Cbaca" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getClas() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getClas().equalsIgnoreCase("")) {
                    vm.setClas(model.getDataModel().getBaseInfoListfromXcel().get(i).getClas());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Clas" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getBaseInfoListfromXcel().get(i).getClassno() != null
                        && !model.getDataModel().getBaseInfoListfromXcel().get(i).getClassno().equalsIgnoreCase("")) {
                    vm.setClassno(model.getDataModel().getBaseInfoListfromXcel().get(i).getClassno());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Classno" + "<br>";
                    error = true;
                    errorcnt++;
                }
//                vm.setNatrating(model.getDataModel().getBaseInfoListfromXcel().get(i).getNatrating());
//                vm.setTotalcrew(model.getDataModel().getBaseInfoListfromXcel().get(i).getTotalcrew());
                vm.setActiveStatus(model.getDataModel().getBaseInfoListfromXcel().get(i).getActiveStatus());
//                }else{
//                       this.dUtil.showDialog("SPS", SMDialogUtil.type.CONF, "01029004", "", new String[]{"BasicInformation"}); 
//                   RequestContext.getCurrentInstance().update("SPS");
//                }

                //DETAILED INFORMATION
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancehullmachineries() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancehullmachineries().equalsIgnoreCase("")) {
                    vm.setInsurancehullmachineries(model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancehullmachineries());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Insurancehullmachineries" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancepi() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancepi().equalsIgnoreCase("")) {
                    vm.setInsurancepi(model.getDataModel().getDetailedInfoListfromXcel().get(i).getInsurancepi());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Insurancepi" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatemanagement() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatemanagement().equalsIgnoreCase("")) {
                    String inputStartDateMgmnt = model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatemanagement();
                    Date dateForStartDateMgmnt = inputFormat.parse(inputStartDateMgmnt);
                    String outputStartDateMgmnt = outputFormat.format(dateForStartDateMgmnt);

                    vm.setStartdatemanagement(outputStartDateMgmnt);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Startdatemanagement" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatetechmgmt() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatetechmgmt().equalsIgnoreCase("")) {
                    String inputStartDatetechMgmnt = model.getDataModel().getDetailedInfoListfromXcel().get(i).getStartdatetechmgmt();
                    Date dateForStartDatetechMgmnt = inputFormat.parse(inputStartDatetechMgmnt);
                    String outputStartDatetechMgmnt = outputFormat.format(dateForStartDatetechMgmnt);

                    vm.setStartdatetechmgmt(outputStartDatetechMgmnt);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Startdatetechmgmt" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getNextdrydockdate() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getNextdrydockdate().equalsIgnoreCase("")) {
                    String inputNextdrydockdatet = model.getDataModel().getDetailedInfoListfromXcel().get(i).getNextdrydockdate();
                    Date dateForNextdrydockdate = inputFormat.parse(inputNextdrydockdatet);
                    String outputNextdrydockdate = outputFormat.format(dateForNextdrydockdate);

                    vm.setNextdrydockdate(outputNextdrydockdate);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Nextdrydockdate" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getLastdrydockdate() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getLastdrydockdate().equalsIgnoreCase("")) {
                    String inputLastdrydockdate = model.getDataModel().getDetailedInfoListfromXcel().get(i).getLastdrydockdate();
                    Date dateForLastdrydockdate = inputFormat.parse(inputLastdrydockdate);
                    String outputLastdrydockdate = outputFormat.format(dateForLastdrydockdate);

                    vm.setLastdrydockdate(outputLastdrydockdate);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Lastdrydockdate" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getDeliverydate() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getDeliverydate().equalsIgnoreCase("")) {
                    String inputDeliverydate = model.getDataModel().getDetailedInfoListfromXcel().get(i).getDeliverydate();
                    Date dateForDeliverydate = inputFormat.parse(inputDeliverydate);
                    String outputDeliverydate = outputFormat.format(dateForDeliverydate);

                    vm.setDeliverydate(outputDeliverydate);
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Deliverydate" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofownerprincipal() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofownerprincipal().equalsIgnoreCase("")) {
                    vm.setNameofownerprincipal(model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofownerprincipal());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Nameofownerprincipal" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerIMO() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerIMO().equalsIgnoreCase("")) {
                    vm.setOwnerIMO(model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerIMO());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "OwnerIMO" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerAddress() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerAddress().equalsIgnoreCase("")) {
                    vm.setOwnerAddress(model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerAddress());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "OwnerAddress" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyName() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyName().equalsIgnoreCase("")) {
                    vm.setOwnerEmergencyName(model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyName());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "OwnerEmergencyName" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyContactNumber() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyContactNumber().equalsIgnoreCase("")) {
                    vm.setOwnerEmergencyContactNumber(model.getDataModel().getDetailedInfoListfromXcel().get(i).getOwnerEmergencyContactNumber());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "OwnerEmergencyContactNumber" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofregisteredowner() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofregisteredowner().equalsIgnoreCase("")) {
                    vm.setNameofregisteredowner(model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofregisteredowner());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Nameofregisteredowner" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofregisteredowner() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getNameofregisteredowner().equalsIgnoreCase("")) {
                    vm.setRegisteredOwnerIMO(model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerIMO());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "RegisteredOwnerIMO" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerAddress() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerAddress().equalsIgnoreCase("")) {
                    vm.setRegisteredOwnerAddress(model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerAddress());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "RegisteredOwnerAddress" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyName() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyName().equalsIgnoreCase("")) {
                    vm.setRegisteredOwnerEmergencyName(model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyName());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "RegisteredOwnerEmergencyName" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyContactNumber() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyContactNumber().equalsIgnoreCase("")) {
                    vm.setRegisteredOwnerEmergencyContactNumber(model.getDataModel().getDetailedInfoListfromXcel().get(i).getRegisteredOwnerEmergencyContactNumber());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "RegisteredOwnerEmergencyContactNumber" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualprincipal() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualprincipal().equalsIgnoreCase("")) {
                    vm.setActualprincipal(model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualprincipal());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "Actualprincipal" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerIMO() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerIMO().equalsIgnoreCase("")) {
                    vm.setActualOwnerIMO(model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerIMO());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "ActualOwnerIMO" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerAddress() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerAddress().equalsIgnoreCase("")) {
                    vm.setActualOwnerAddress(model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerAddress());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "ActualOwnerAddress" + "<br>";
                    error = true;
                    errorcnt++;
                }
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyName() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyName().equalsIgnoreCase("")) {
                    vm.setActualOwnerEmergencyName(model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyName());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "ActualOwnerEmergencyName" + "<br>";
                    error = true;
                    errorcnt++;
                }
                logger.info("//--//OUTPUT OF|   vm.getActualOwnerEmergencyName|===>>>" + vm.getActualOwnerEmergencyName());
                if (model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyContactNumber() != null
                        && !model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyContactNumber().equalsIgnoreCase("")) {
                    vm.setActualOwnerEmergencyContactNumber(model.getDataModel().getDetailedInfoListfromXcel().get(i).getActualOwnerEmergencyContactNumber());
                } else {
                    missingfield = missingfield + errorcnt + ". " + "ActualOwnerEmergencyContactNumber" + "<br>";
                    error = true;
                    errorcnt++;
                }

                //DIMENSION TAB
                if (model.getDataModel().getDimensionDetInfoListFromxcel().size() > 0) {
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLengthloa() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLengthloa().equalsIgnoreCase("")) {
                        vm.setLengthloa(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLengthloa());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Lengthloa" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLengthloa() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLbp().equalsIgnoreCase("")) {
                        vm.setLbp(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLbp());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Lbp" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getBreadth() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getBreadth().equalsIgnoreCase("")) {
                        vm.setBreadth(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getBreadth());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Breadth" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getHeight() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getHeight().equalsIgnoreCase("")) {
                        vm.setHeight(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getHeight());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Height" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDepth() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDepth().equalsIgnoreCase("")) {
                        vm.setDepth(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDepth());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Depth" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDraft() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDraft().equalsIgnoreCase("")) {
                        vm.setDraft(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDraft());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Draft" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDeadweight() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDeadweight().equalsIgnoreCase("")) {
                        vm.setDeadweight(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getDeadweight());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Deadweight" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getCapacity() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getCapacity().equalsIgnoreCase("")) {
                        vm.setCapacity(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getCapacity());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Capacity" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalGrosston() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalGrosston().equalsIgnoreCase("")) {
                        vm.setInternationalGrosston(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalGrosston());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "InternationalGrosston" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalNetton() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalNetton().equalsIgnoreCase("")) {
                        vm.setInternationalNetton(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getInternationalNetton());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "InternationalNetton" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredGrosston() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredGrosston().equalsIgnoreCase("")) {
                        vm.setRegisteredGrosston(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredGrosston());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "RegisteredGrosston" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredNetton() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredNetton().equalsIgnoreCase("")) {
                        vm.setRegisteredNetton(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getRegisteredNetton());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "RegisteredNetton" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtSuez() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtSuez().equalsIgnoreCase("")) {
                        vm.setGtSuez(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtSuez());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "GtSuez" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getNtSuez() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getNtSuez().equalsIgnoreCase("")) {
                        vm.setNtSuez(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getNtSuez());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "NtSuez" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtpan() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtpan().equalsIgnoreCase("")) {
                        vm.setGtpan(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getGtpan());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Gtpan" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getMsums() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getMsums().equalsIgnoreCase("")) {
                        vm.setMsums(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getMsums());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Msums" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLightShip() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLightShip().equalsIgnoreCase("")) {
                        vm.setLightShip(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getLightShip());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "LightShip" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getConstant() != null
                            && !model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getConstant().equalsIgnoreCase("")) {
                        vm.setConstant(model.getDataModel().getDimensionDetInfoListFromxcel().get(i).getConstant());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Constant" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                }
                logger.info("//--//OUTPUT OF| vm.getConstant|===>>>" + vm.getConstant());

//                //MANAGMENT RESOUCES
                if (model.getDataModel().getManagmentResourceListFromxcel().size() > 0) {
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getSuperintendent() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getSuperintendent().equalsIgnoreCase("")) {
                    vm.setSuperintendent(model.getDataModel().getManagmentResourceListFromxcel().get(i).getSuperintendent());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "Superintendent" +"<br>";
//                        error = true;
//                    }
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetgm() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetgm().equalsIgnoreCase("")) {
                    vm.setFleetgm(model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetgm());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "Fleetgm" +"<br>";
//                        error = true;
//                    }
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getSecondBackupSI() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getSecondBackupSI().equalsIgnoreCase("")) {
                    vm.setSecondBackupSI(model.getDataModel().getManagmentResourceListFromxcel().get(i).getSecondBackupSI());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "SecondBackupSI" +"<br>";
//                        error = true;
//                    }
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqManager() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqManager().equalsIgnoreCase("")) {
                    //agmQshe
                    vm.setHseqManager(model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqManager());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "agmQshe" +"<br>";
//                        error = true;
//                    }
                    //AGMAT
                    vm.setMarineOperationManager(model.getDataModel().getManagmentResourceListFromxcel().get(i).getMarineOperationManager());
                    vm.setAccountant(model.getDataModel().getManagmentResourceListFromxcel().get(i).getAccountant());
                    //AGMCrew
                    vm.setCrewInCharge(model.getDataModel().getManagmentResourceListFromxcel().get(i).getCrewInCharge());

                    logger.info("//--//OUTPUT OF|model.getDataModel().getManagmentResourceListFromxcel().get(i).getStartdatesuperintendent()|===>>>" + model.getDataModel().getManagmentResourceListFromxcel().get(i).getStartdatesuperintendent());
                    String inputStartdatesuperintendent = model.getDataModel().getManagmentResourceListFromxcel().get(i).getStartdatesuperintendent();
                    Date dateForStartdatesuperintendent = inputFormat.parse(inputStartdatesuperintendent);
                    String outputStartdatesuperintendent = outputFormat.format(dateForStartdatesuperintendent);
                    logger.info("//--//OUTPUT OF|outputDate for detTab|===>>>" + outputStartdatesuperintendent);
                    vm.setStartdatesuperintendent(outputStartdatesuperintendent);
                    logger.info("//--//OUTPUT OF|  vm.getStartdatesuperintendent|===>>>" + vm.getStartdatesuperintendent());

//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetmanager() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetmanager().equalsIgnoreCase("")) {
                    vm.setFleetmanager(model.getDataModel().getManagmentResourceListFromxcel().get(i).getFleetmanager());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "Fleetmanager" +"<br>";
//                        error = true;
//                    }

//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getFirstBackupSI() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getFirstBackupSI().equalsIgnoreCase("")) {
                    //Superintendent
                    vm.setFirstBackupSI(model.getDataModel().getManagmentResourceListFromxcel().get(i).getFirstBackupSI());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "FirstBackupSI" +"<br>";
//                        error = true;
//                    }
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqSuperintendant() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqSuperintendant().equalsIgnoreCase("")) {
                    //MSI
                    vm.setHseqSuperintendant(model.getDataModel().getManagmentResourceListFromxcel().get(i).getHseqSuperintendant());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "MSI" +"<br>";
//                        error = true;
//                    }
//                    if (model.getDataModel().getManagmentResourceListFromxcel().get(i).getMarineOperationSI() != null
//                            && !model.getDataModel().getManagmentResourceListFromxcel().get(i).getMarineOperationSI().equalsIgnoreCase("")) {
                    //ATSI
                    vm.setMarineOperationSI(model.getDataModel().getManagmentResourceListFromxcel().get(i).getMarineOperationSI());
//                    } else {
//                        missingfield = missingfield + errorcnt + "."  + "ATSI" + "<br>";
//                        error = true;
//                    }
                    vm.setPurchaseunit(model.getDataModel().getManagmentResourceListFromxcel().get(i).getPurchaseunit());
                    vm.setPurchaser(model.getDataModel().getManagmentResourceListFromxcel().get(i).getPurchaser());
                    vm.setInvoicername(model.getDataModel().getManagmentResourceListFromxcel().get(i).getInvoicername());
                }
                //MACHINERY DETAILS 
                if (model.getDataModel().getMachineryDetListFromxcel().size() > 0) {
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineMake() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineMake().equalsIgnoreCase("")) {
                        vm.setMainEngineMake(model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineMake());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "MainEngineMake" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineType() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineType().equalsIgnoreCase("")) {
                        vm.setMainEngineType(model.getDataModel().getMachineryDetListFromxcel().get(i).getMainEngineType());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "MainEngineType" + "<br>";
                        error = true;
                        errorcnt++;
                    }

                    String noOfCylinder = Integer.toString(model.getDataModel().getMachineryDetListFromxcel().get(i).getNoOfCylinder());
                    if (noOfCylinder != null
                            && !noOfCylinder.equalsIgnoreCase("")) {
                        vm.setNoOfCylinder(noOfCylinder);
                        logger.info("//--//OUTPUT OF|vm.getNoOfCylinder|===>>>" + vm.getNoOfCylinder());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "NoOfCylinder" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrPs() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrPs().equalsIgnoreCase("")) {
                        vm.setMcrPs(model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrPs());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "McrPs" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrKw() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrKw().equalsIgnoreCase("")) {
                        vm.setMcrKw(model.getDataModel().getMachineryDetListFromxcel().get(i).getMcrKw());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "McrKw" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getCamlessornot() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getCamlessornot().equalsIgnoreCase("")) {
                        vm.setCamlessornot(model.getDataModel().getMachineryDetListFromxcel().get(i).getCamlessornot());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "Camlessornot" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getLicense() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getLicense().equalsIgnoreCase("")) {
                        vm.setLicense(model.getDataModel().getMachineryDetListFromxcel().get(i).getLicense());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "License" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrPs() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrPs().equalsIgnoreCase("")) {
                        vm.setNsrPs(model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrPs());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "NsrPs" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrKw() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrKw().equalsIgnoreCase("")) {
                        vm.setNsrKw(model.getDataModel().getMachineryDetListFromxcel().get(i).getNsrKw());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "NsrKw" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerMake() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerMake().equalsIgnoreCase("")) {
                        vm.setTurboChargerMake(model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerMake());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "TurboChargerMake" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    if (model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerType() != null
                            && !model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerType().equalsIgnoreCase("")) {
                        vm.setTurboChargerType(model.getDataModel().getMachineryDetListFromxcel().get(i).getTurboChargerType());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "TurboChargerType" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                }
                //COMMUNNICATION
                if (model.getDataModel().getCommunicationListFromxcel().size() > 0) {
                    String mMsiNo = Integer.toString(model.getDataModel().getCommunicationListFromxcel().get(i).getMmsino());
                    vm.setMmsino(mMsiNo);
                    logger.info("//--//OUTPUT OF|vm.getMmsino|===>>>" + vm.getMmsino());
                    vm.setAatdhldigits(model.getDataModel().getCommunicationListFromxcel().get(i).getAatdhldigits());
                    vm.setSatCID(model.getDataModel().getCommunicationListFromxcel().get(i).getSatCID());
                    vm.setCellphone(model.getDataModel().getCommunicationListFromxcel().get(i).getCellphone());
                    vm.setIridiumphone(model.getDataModel().getCommunicationListFromxcel().get(i).getIridiumphone());
                    if (model.getDataModel().getCommunicationListFromxcel().get(i).getSatEmail() != null
                            && !model.getDataModel().getCommunicationListFromxcel().get(i).getSatEmail().equalsIgnoreCase("")) {
                        vm.setSatEmail(model.getDataModel().getCommunicationListFromxcel().get(i).getSatEmail());
                    } else {
                        missingfield = missingfield + errorcnt + ". " + "SatEmail" + "<br>";
                        error = true;
                        errorcnt++;
                    }
                    vm.setSatTelex(model.getDataModel().getCommunicationListFromxcel().get(i).getSatTelex());

                    //logger.info("mData.getMetaData(USERINFO.USERCODE)"+mData.getMetaData(USERINFO.USERCODE));
                    String x = "USC00001";
                    vm.setCruser(x);
                    vm.setCrdate(outputFormat.format(new Date()));
//                vm.setUpduser(mData.getMetaData(USERINFO.USERCODE));
//                vm.setUpddate(outputFormat.format(new Date()));
                    vm.setSatVoice(model.getDataModel().getCommunicationListFromxcel().get(i).getSatVoice());
                    vm.setSatFax(model.getDataModel().getCommunicationListFromxcel().get(i).getSatFax());
                    vm.setSatData(model.getDataModel().getCommunicationListFromxcel().get(i).getSatData());
                    vm.setSatHSD(model.getDataModel().getCommunicationListFromxcel().get(i).getSatHSD());

                }
                vdsModelForImport.getVesselmaster().add(vm);
//                vmList.add(vm);
                logger.info("//--//--------->>>FOR LOOP IS FINISHED FIRST TIME--|===>>>");
                logger.info("error is ????????????? " + error);
                if (error) {
                    logger.info("missingfield ????????? :: " + missingfield);
                    this.dUtil.showDialog("SPS", SMDialogUtil.type.INFO, "01029004", "", new String[]{missingfield});
                    //    RequestContext.getCurrentInstance().update("SPS");
                    break;
                }

            }
//            vdsModelForImport.setVesselmaster(vmList);
            logger.info("//--//OUTPUT OF BEFORE VDS | vdsModelForImport.getVesselmaster().size() |===>>>" + vdsModelForImport.getVesselmaster().size());
            if (!error) {
                //statusmap = spsService.setsps_vesselmasterDataForImportExcel(vdsModelForImport);
                logger.info("//--//=================================>SUCCESSFULLY SAVED===>>>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusmap;
    }

    void userDetailImportExcel(ImportResponse impr) {
        logger.info("//--/--|INSIDE ON USD IMPORT EXCEL |++-->");
        try {
            if ("USD1".equalsIgnoreCase(impr.getProfileid().trim())) {
                Map statusMap = new HashMap();
                FinalModel finalmodel = null;
                BasicInformationTab baseInfovo = new BasicInformationTab();
                DetailedInformationTab detailInfoVo = new DetailedInformationTab();
                ArrayList lst = null;
                SvmJsonUtil util = new SvmJsonUtil();
                finalmodel = (FinalModel) util.toObject(impr.getResultdata().toString(), FinalModel.class);
                logger.info("//--//SIZE OF BASIC INFO---------->TAB 1 LIST===>>>" + finalmodel.getUserDetsilBasicInfoImptList().size());
                logger.info("//--//SIZE OF DETAILE INFO-------->TAB 2 LIST===>>>" + finalmodel.getUserDetailInfoImptList().size());
                /**
                 * **************BASIC INFORMATION TAB******START********
                 */
                logger.info("//--//--OUTPUT OF TAB 1--|getEmp code |-->" + finalmodel.getUserDetsilBasicInfoImptList().get(0).getEmpcode());
                logger.info("//--//--OUTPUT OF TAB 2--|get PlaceOf Birth|-->" + finalmodel.getUserDetailInfoImptList().get(0).getPlaceofbirth());

                lst = new ArrayList();
                for (int i = 0; i < finalmodel.getUserDetsilBasicInfoImptList().size(); i++) {
                    baseInfovo = finalmodel.getUserDetsilBasicInfoImptList().get(i);
                    lst.add(baseInfovo);
                    logger.info("//--//OUTPUT OF|baseInfoVo empcode|===>>>" + baseInfovo.getEmpcode());
                }
                model.getDataModel().setUserDetBasicInfoListfromXcel(lst);
                logger.info("//--//SIZE OF|getBaseInfoListfromXcel|===>>>" + model.getDataModel().getUserDetBasicInfoListfromXcel().size());

                /**
                 * **************BASIC INFORMATION TAB******END********
                 */
                /**
                 * **************DETAILED INFORMATION TAB******START********
                 */
                lst = new ArrayList();
                for (int j = 0; j < finalmodel.getUserDetailInfoImptList().size(); j++) {
                    detailInfoVo = finalmodel.getUserDetailInfoImptList().get(j);
                    lst.add(detailInfoVo);
                    logger.info("//--//OUTPUT OF|detailInfoVo Place OF Birth|===>>>" + detailInfoVo.getPlaceofbirth());
                    logger.info("//--//OUTPUT OF|detailInfoVo.getGmdss_goc_Number |===>>>" + detailInfoVo.getGmdss_goc_number());
                }
                model.getDataModel().setUserDetailedInfoListfromXcel(lst);
                logger.info("//--//OUTPUT OF|model.getDataModel().getDetailedInfoListfromXcel(lst)|===>>>" + model.getDataModel().getUserDetailedInfoListfromXcel().size());
                /**
                 * **************DETAILED INFORMATION TAB******END********
                 */

                getAllValuesFromExcel();
//                if (statusMap.get("status").toString().trim().equalsIgnoreCase("200.0")) {
//                    logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE|===>>>");
//                    this.dUtil.showDialog("USD", SMDialogUtil.type.INFO, "19032000", "", null);
//                    logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE END|===>>>");
//                }

            } else {
                logger.info("//--//============>You Are In Wrong ProfileId====================>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map getAllValuesFromExcel() {
        logger.info("//--//|INSIDE FROM getAllValuesFromExcel |-->");
        Map statusmap = new HashMap();
        try {
            StringBuffer importValidation = validateImportExcel(model.getDataModel().getUserDetBasicInfoListfromXcel(), model.getDataModel().getUserDetailedInfoListfromXcel());
            String strvalmsg = importValidation.toString();
            logger.info("importValidation ?????????????? " + importValidation);
            logger.info("strvalmsg ??????????? " + strvalmsg);
            dUtil.showDialog("USD", SMDialogUtil.type.CONF, "19032010", "#{LandingPageCBean.saveImportedUserDetailAfterValidation}", new String[]{strvalmsg});
//            if (importValidation.length() > 0) {
//                dUtil.showDialog("USD", SMDialogUtil.type.INFO, "19032010", "", new String[]{strvalmsg});
//            }
//            statusmap = saveImportedUserDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusmap;
    }

    public void saveImportedUserDetailAfterValidation() {
        String eventType = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("eventType");
        if ("yes".equalsIgnoreCase(eventType)) {
            Map statusmap = saveImportedUserDetail();
            if (statusmap.get("status").toString().trim().equalsIgnoreCase("200.0")) {
                String save = "Saved successfully";
                dUtil.showDialog("USD", SMDialogUtil.type.INFO, "19032010", "", new String[]{save});
                logger.info("//--//OUTPUT OF|STATUS LOOP INSIDE END|===>>>");
            }
        }
    }

    public Map saveImportedUserDetail() {
        Map statusmap = new HashMap();
        CompleteModel vdsModelForImport = new CompleteModel();
        // Note, MM is months Should be MM, not mm
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");

        int size = model.getDataModel().getUserDetBasicInfoListfromXcel().size();
        logger.info("//--//OUTPUT OF|size|===>>> " + size);
        try {
            for (int i = 0; i < size; i++) {
                UserDetail usd = new UserDetail();
                logger.info("//--//------------------->>>>>|INSIDE FOR LOOP IN IMPORTEXCEL=============>|===>>>");

                //BASIC INFORMATION
                usd.setEmpcode(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getEmpcode());
                String password = new SMMessageDigest().getBytes(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getEpassword());
                usd.setEpassword(password);

                usd.setEmpname(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getEmpname());
                usd.setSurname(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getSurname());
                usd.setCntrltype(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getCntrltype());
                String inputDoj = model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getTxtDateOfJoining();
                Date dateForDoj = inputFormat.parse(inputDoj);
                String outputDoj = outputFormat.format(dateForDoj);
                usd.setDoj(outputDoj);

                usd.setGender(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getGender());
                usd.setNationality(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getNationality());
                usd.setEmail(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getEmail());
                String inputDob = model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getTxtDateOfBirth();
                Date dateForDob = inputFormat.parse(inputDob);
                String outputDob = outputFormat.format(dateForDob);
                usd.setDateofbirth(outputDob);

                usd.setUsertype(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getUsertype());
                usd.setCompanycode(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getCompanycode());
                usd.setRankcode(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getRankcode());
                usd.setDateformat(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getDateformat());
                usd.setManningoffice(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getManningoffice());
                usd.setUserlocation(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getUserlocation());
                usd.setApplication(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getApplication());
                usd.setIsadmin(model.getDataModel().getUserDetBasicInfoListfromXcel().get(i).getIsadmin());
                //DETAILED INFORMATION
                usd.setPlaceofbirth(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getPlaceofbirth());
                usd.setAddress(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getAddress());
                usd.setZipcode(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getZipcode());
                usd.setTelephonenumber(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTelephonenumber());
                usd.setMobilenumber(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getMobilenumber());
                usd.setEmergencycontactnumber(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getEmergencycontactnumber());
                usd.setPassportnumber(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getPassportnumber());
                String inputPassportExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtPassportExpiry();
                Date dateForPassportExpiry = inputFormat.parse(inputPassportExpiry);
                String outputPassportExpiry = outputFormat.format(dateForPassportExpiry);
                usd.setPassportexpiry(outputPassportExpiry);

                String inputMedCerIssued = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtMedCerIssued();
                Date dateForMedCerIssued = inputFormat.parse(inputMedCerIssued);
                String outputMedCerIssued = outputFormat.format(dateForMedCerIssued);
                usd.setMediccert_issued(outputMedCerIssued);

                String inputMedCerExpiryt = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtMedCerExpiry();
                Date dateForMedCerExpiry = inputFormat.parse(inputMedCerExpiryt);
                String outputMedCerExpiry = outputFormat.format(dateForMedCerExpiry);
                usd.setMediccert_expiry(outputMedCerExpiry);

                usd.setFlag_lic_number(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getFlag_lic_number());
                String inputFlagLicExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFlagLicExpiry();
                Date dateForFlagLicExpiry = inputFormat.parse(inputFlagLicExpiry);
                String outputFlagLicExpiry = outputFormat.format(dateForFlagLicExpiry);
                usd.setFlag_lic_expiry(outputFlagLicExpiry);

                String inputUSVisaExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtUSVisaExpiry();
                Date dateForUSVisaExpiry = inputFormat.parse(inputUSVisaExpiry);
                String outputUSVisaExpiry = outputFormat.format(dateForUSVisaExpiry);
                usd.setUs_visa_expiry(outputUSVisaExpiry);

                String inputFlagDCEExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFlagDCEExpiry();
                Date dateForFlagDCEExpiry = inputFormat.parse(inputFlagDCEExpiry);
                String outputFlagDCEExpiry = outputFormat.format(dateForFlagDCEExpiry);
                usd.setFlag_dce_expiry(outputFlagDCEExpiry);

                usd.setSeamans_number(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getSeamans_number());
                String inputFlagSeaBookExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFlagSeaBookExpiry();
                Date dateForFlagSeaBookExpiry = inputFormat.parse(inputFlagSeaBookExpiry);
                String outputFlagSeaBookExpiry = outputFormat.format(dateForFlagSeaBookExpiry);
                usd.setSeamans_expiry(outputFlagSeaBookExpiry);

                usd.setGmdss_goc_number(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getGmdss_goc_number());

                String inputFlagGMDSSExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFlagGMDSSExpiry();
                Date dateForFlagGMDSSExpiry = inputFormat.parse(inputFlagGMDSSExpiry);
                String outputFlagGMDSSExpiry = outputFormat.format(dateForFlagGMDSSExpiry);
                usd.setGmdss_goc_expiry(outputFlagGMDSSExpiry);

                usd.setFinal_appraisal_comp(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFinalAppCom());
                usd.setHalf_appraisal_comp(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtHalfAppCom());

                String inputFinalApp = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtFinalApp();
                Date dateForFinalApp = inputFormat.parse(inputFinalApp);
                String outputFinalApp = outputFormat.format(dateForFinalApp);
                usd.setFinal_appraisal(outputFinalApp);

                String inputHalfApp = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtHalfApp();
                Date dateForHalfApp = inputFormat.parse(inputHalfApp);
                String outputHalfApp = outputFormat.format(dateForHalfApp);
                usd.setHalf_appraisal(outputHalfApp);

                String inputEmpContractExpiry = model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getTxtEmpContractExpiry();
                Date dateForEmpContractExpiry = inputFormat.parse(inputEmpContractExpiry);
                String outputEmpContractExpiry = outputFormat.format(dateForEmpContractExpiry);
                usd.setContract_expiry(outputEmpContractExpiry);
                usd.setRemarks(model.getDataModel().getUserDetailedInfoListfromXcel().get(i).getRemarks());

                usd.setCruser(mData.getMetaData(USERINFO.USERCODE));
                usd.setCrdate(outputFormat.format(new Date()));
//              usd.setUpduser(mData.getMetaData(USERINFO.USERCODE));
//              usd.setUpddate(outputFormat.format(new Date()));

                Map<Integer, Object> resultMap = this.mackUtility.getNFRMasterSerialNumber("USD");
//                Map<Integer, Object> resultMap = this.com.getSerialNumberFrmNFR("USD");
                int status = (int) resultMap.get(MackUtil_IF.I_STATUS);
                if (status == MackUtil_IF.I_SUCCESS) {
                    String scerNo = String.valueOf(resultMap.get(MackUtil_IF.I_RESULT));
                    usd.setUsercode(scerNo);
                }

                String tenant = "MAC";
                String activeStatus = "A";
                usd.setActive_status(activeStatus);

                usd.setUsercode(usd.getUsercode());

                vdsModelForImport.getUserDetail().add(usd);
            }
            statusmap = service.setusd_userdetail(vdsModelForImport);
        } catch (Exception e) {
        }
        return statusmap;
    }

    private StringBuffer validateImportExcel(List<BasicInformationTab> basicList, List<DetailedInformationTab> detailedList) {
        logger.info("//==//==|INSIDE IMPORT XCEL VALIDATION|==>");
        StringBuffer importValidation = null;
        try {
            List<Integer> removeRows = new ArrayList<>();
            logger.info("//==//==|basicList.size()|==>" + basicList.size());
            logger.info("//==//==|detailedList.size|==>" + detailedList.size());
            int basicSize = basicList.size();
            importValidation = new StringBuffer();
            boolean deleteRow = false;
            importValidation.append("<html><font face='Verdana' size='2'><b>");
            for (int i = 0; i < basicSize; i++) {
                logger.info("//==//==|VALUES OF I|==>" + i);
                if ((basicList.get(i).getEmpcode() != null) && (!basicList.get(i).getEmpcode().trim().equalsIgnoreCase(""))) {
                    CompleteModel userDetail = service.getusd_userdetailbyempcode(basicList.get(i).getEmpcode());
                    if (!userDetail.getUserDetail().isEmpty()) {
                        importValidation.append("Employee Code : <font color=red>" + basicList.get(i).getEmpcode() + "</font> already exist<br/>");
                        deleteRow = true;
                    }
                } else {
                    importValidation.append("Employee Code is not exist in <font color=blue>" + i + "</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getEmpname() == null && basicList.get(i).getEmpname().trim().equalsIgnoreCase("")) {
                    importValidation.append("Employee Name is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getSurname() == null && basicList.get(i).getSurname().trim().equalsIgnoreCase("")) {
                    importValidation.append("Sur Name is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getCntrltype() == null && basicList.get(i).getCntrltype().trim().equalsIgnoreCase("")) {
                    importValidation.append("Control Type is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getTxtDateOfJoining() == null && basicList.get(i).getTxtDateOfJoining().trim().equalsIgnoreCase("")) {
                    importValidation.append("Employment Date is not exist in <font color=blue>'" + i + "' row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getGender() == null && basicList.get(i).getGender().trim().equalsIgnoreCase("")) {
                    importValidation.append("Gender is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getNationality() == null && basicList.get(i).getNationality().trim().equalsIgnoreCase("")) {
                    importValidation.append("Nationality is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getEmail() == null && basicList.get(i).getEmail().trim().equalsIgnoreCase("")) {
                    importValidation.append("Email is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getTxtDateOfBirth() == null && basicList.get(i).getTxtDateOfBirth().trim().equalsIgnoreCase("")) {
                    importValidation.append("Date of Birth is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getCntrltype() != null && basicList.get(i).getCntrltype().trim().equalsIgnoreCase("Others")) {
                    if (basicList.get(i).getUsertype() == null && basicList.get(i).getUsertype().trim().equalsIgnoreCase("")) {
                        importValidation.append("User Type is not exist in <font color=blue>'" + i + "' row of the excel<br/>");
                        deleteRow = true;
                    }
                }
                if (basicList.get(i).getCompanycode() == null && basicList.get(i).getCompanycode().trim().equalsIgnoreCase("")) {
                    importValidation.append("Company is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getCntrltype() != null && !basicList.get(i).getCntrltype().trim().equalsIgnoreCase("Others")) {
                    if (basicList.get(i).getRankcode() == null && basicList.get(i).getRankcode().trim().equalsIgnoreCase("")) {
                        importValidation.append("Designation is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                        deleteRow = true;
                    }
                }
                if (basicList.get(i).getDateformat() == null && basicList.get(i).getDateformat().trim().equalsIgnoreCase("")) {
                    importValidation.append("Date Format is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                    deleteRow = true;
                }
                if (basicList.get(i).getCntrltype() != null && basicList.get(i).getCntrltype().trim().equalsIgnoreCase("Vessel")) {
                    if (basicList.get(i).getManningoffice() == null && basicList.get(i).getManningoffice().trim().equalsIgnoreCase("")) {
                        importValidation.append("Manning Office is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                        deleteRow = true;
                    }
                }
                if (basicList.get(i).getCntrltype() != null && (basicList.get(i).getCntrltype().trim().equalsIgnoreCase("Office")
                        || (basicList.get(i).getCntrltype().trim().equalsIgnoreCase("Others")))) {
                    if (basicList.get(i).getUserlocation() == null && basicList.get(i).getUserlocation().trim().equalsIgnoreCase("")) {
                        importValidation.append("User Location is not exist in <font color=blue>'" + i + "'</font> row of the excel<br/>");
                        deleteRow = true;
                    }
                }

                if (basicList.get(i).getNationality() != null && !basicList.get(i).getNationality().trim().equalsIgnoreCase("")) {
                    CompleteModel countryCode = service.getusd_countrycode(basicList.get(i).getNationality().trim());
                    if (!countryCode.getCountrymaster().isEmpty()) {
                        basicList.get(i).setNationality(countryCode.getCountrymaster().get(0).getCountrycode());
                    } else {
                        importValidation.append("Invalid Nationality of <font color=red>'" + basicList.get(i).getNationality().trim() + "'</font> in the row of - <font color=blue>" + i + "'</font> in excel<br/>");
                        deleteRow = true;
                    }
                }

                if (basicList.get(i).getCompanycode() != null && !basicList.get(i).getCompanycode().trim().equalsIgnoreCase("")) {
                    CompleteModel shoreCode = service.getusdshorecode(basicList.get(i).getCompanycode().trim());
                    if (!shoreCode.getShoreMaster().isEmpty()) {
                        basicList.get(i).setNationality(shoreCode.getShoreMaster().get(0).getShorecode());
                    } else {
                        importValidation.append("Invalid Company of <font color=red>'" + basicList.get(i).getCompanycode().trim() + "'</font> in the row of - <font color=blue>" + i + "'</font> in excel<br/>");
                        deleteRow = true;
                    }
                }

                if (basicList.get(i).getRankcode() != null && !basicList.get(i).getRankcode().trim().equalsIgnoreCase("")) {
                    CompleteModel rankCode = service.getusdrankcode(basicList.get(i).getRankcode().trim());
                    if (!rankCode.getRankmaster().isEmpty()) {
                        basicList.get(i).setNationality(rankCode.getRankmaster().get(0).getRankcode());
                    } else {
                        importValidation.append("Invalid Rank of <font color=red>'" + basicList.get(i).getRankcode().trim() + "'</font> in the row of - <font color=blue>" + i + "'</font> in excel<br/>");
                        deleteRow = true;
                    }
                }

                if (basicList.get(i).getUsertype() != null && !basicList.get(i).getUsertype().trim().equalsIgnoreCase("")) {
                    CompleteModel usertypeCode = service.getusdusertypecode(basicList.get(i).getUsertype().trim());
                    if (!usertypeCode.getUsertypemaster().isEmpty()) {
                        basicList.get(i).setNationality(usertypeCode.getUsertypemaster().get(0).getUsertypecode());
                    } else {
                        importValidation.append("Invalid Uset Type of <font color=red>'" + basicList.get(i).getUsertype().trim() + "'</font> in the row of - <font color=blue>" + i + "'</font> in excel<br/>");
                        deleteRow = true;
                    }
                }

                if (basicList.get(i).getManningoffice() != null && !basicList.get(i).getManningoffice().trim().equalsIgnoreCase("")) {
                    CompleteModel manningCode = service.getusdmanningofficecode(basicList.get(i).getManningoffice().trim());
                    if (!manningCode.getManningofficemaster().isEmpty()) {
                        basicList.get(i).setNationality(manningCode.getManningofficemaster().get(0).getMannoffcode());
                    } else {
                        importValidation.append("Invalid Manning Office of <font color=red>'" + basicList.get(i).getManningoffice().trim() + "'</font> in the row of - <font color=blue>" + i + "'</font> in excel<br/>");
                        deleteRow = true;
                    }
                }

                if (deleteRow) {
                    removeRows.add(i);
                }
            }
            importValidation.append("<font color=green> Do you want to proceed with other details ? </font>");
            importValidation.append("</b></font><html>");
            logger.info("removeRows ??????????????? " + removeRows);
            for (int i = 0; i < removeRows.size(); i++) {
                logger.info("removeRows.get(i) ??????????? " + removeRows.get(i));
                model.getDataModel().getUserDetBasicInfoListfromXcel().remove(removeRows.get(i));
                model.getDataModel().getUserDetailedInfoListfromXcel().remove(removeRows.get(i));
            }
            logger.info("size after removed ?????????? " + model.getDataModel().getUserDetBasicInfoListfromXcel().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return importValidation;
    }

    public Object getDateConverter(String str) {
        return getCtrl().getDateAsString(str);
    }

    @Override
    public boolean btnNewActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnEditActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnDeleteActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnCancelActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnToolBarSearchActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveReturn(SelectEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnToolBarSearchReturn(SelectEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveAsActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnExportActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnMoveLastActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnMoveFirstActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnForwardActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnBackwardFirstActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnPrintActionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbsToolBarUtils getToolBarBean() {
        return toolbar;
    }

    public INFRMultiTenanacyUtil getMultitenency() {
        return multitenency;
    }

    public void setMultitenency(INFRMultiTenanacyUtil multitenency) {
        this.multitenency = multitenency;
    }
    
}
