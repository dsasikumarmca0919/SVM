/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vds;

import com.svm.json.SvmJsonList;
import com.svm.lrp.nfr.lnd.vo.CompleteModel;
import com.svm.lrp.nfr.query.annotation.FP;
import com.svm.lrp.nfr.query.annotation.VDS;
import com.svm.lrp.nfr.query.bean.helper.Condition;
import com.svm.mac.mas.wfm.vds.VDSWorkflowGroupMappingModel;
import com.svm.mack.model.vds.VDSMackBpmUtil;
import java.util.Map;

/**
 *
 * @author salomi.a
 */
public interface LandingPageVds {

    @VDS(name = "getlndtest", tenant = "MAC")
    public SvmJsonList getlndtest(SvmJsonList jsonstr);

    @VDS(name = "getdynamiclandingpage", tenant = "MAC")
    public CompleteModel getdynamiclandingpage(@FP(name = "mdlid") String strMdlId);

    @VDS(name = "gemodulerights", tenant = "MAC")
    public CompleteModel gemodulerights(@FP(name = "moduleId") String strMdlId, @FP(name = "LoginName") String strLoginName);

    @VDS(name = "setusertablepreferences", tenant = "MAC")
    public Map setusertablepreferences(CompleteModel completeModel);

    @VDS(name = "setreoderusertblprefer", tenant = "MAC")
    public Map setreoderusertblprefer(CompleteModel completeModel);

    @VDS(name = "putusertablepreferences", tenant = "MAC")
    public Map putusertablepreferences(CompleteModel completeModel);

    @VDS(name = "putreoderusertblprefer", tenant = "MAC")
    public Map putreoderusertblprefer(CompleteModel completeModel);

    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingid(@FP(name = "workflowid") String workflowid);

    @VDS(name = "getusertablepreferences", tenant = "MAC")
    public CompleteModel getusertablepreferences(@FP(name = "usercode") String usercode, @FP(name = "moduleid") String moduleid);

    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getwkformwkmapping(@FP(name = "mdlcode") String strMdlId, @FP(name = "cnttypecode") String cnttypecode);

    @VDS(name = "getworkflowgrpmapping", tenant = "MAC")
    public VDSWorkflowGroupMappingModel getworkflowgrpmapping(@FP(name = "rankcode") String rankcode);

//    @VDS(name = "getworkflowmappingid", tenant = "MAC")
//    public CompleteModel getworkflowmappingid(@FP(name = "mdlcode") String mdlcode, @FP(name = "cnttypecode") String cnttypecode, @FP(name = "active_status") String active_status);
    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingid(@FP(name = "mdlcode") String mdlcode, @FP(name = "active_status") String active_status);

    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingid(@FP(name = "mdlcode") String mdlcode, @FP(name = "cnttypecode") String cnttypecode, @FP(name = "fromcnttypecode") String fromCntType, @FP(name = "active_status") String active_status);

    @VDS(name = "getrskmasterlanding", tenant = "MAC")
    public CompleteModel getrskmasterlanding(@FP(name = "rskid") String rskid);

    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingidrsk(@FP(name = "mdlcode") String mdlcode, @FP(name = "cnttypecode") String cnttypecode, @FP(name = "bpmwrkflowid") String bpmwrkflowid);

    @VDS(name = "setusd_userdetail", tenant = "mac")
    public abstract Map setusd_userdetail(CompleteModel userDetail);

    @VDS(name = "getusd_userdetailbyempcode", tenant = "mac")
    public abstract CompleteModel getusd_userdetailbyempcode(@FP(name = "empcode") String empCode);

    @VDS(name = "getusd_countrycode", tenant = "mac")
    public abstract CompleteModel getusd_countrycode(@FP(name = "countryname") String countryCode);

    @VDS(name = "getusdshorecode", tenant = "mac")
    public abstract CompleteModel getusdshorecode(@FP(name = "shorename") String shoreCode);

    @VDS(name = "getusdrankcode", tenant = "mac")
    public abstract CompleteModel getusdrankcode(@FP(name = "rankname") String rankName);

    @VDS(name = "getusdmanningofficecode", tenant = "mac")
    public abstract CompleteModel getusdmanningofficecode(@FP(name = "mannoffdesc") String mannoffDesc);

    @VDS(name = "getusdusertypecode", tenant = "mac")
    public abstract CompleteModel getusdusertypecode(@FP(name = "usertypedesc") String usertypeDesc);

    // new changes - depricated bpm
    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingid(@FP(name = "mdlcode") String mdlcode, @FP(name = "cnttypecode") String cnttypecode, @FP(name = "active_status", condition = Condition.NOTEQUALS) String active_status);

    @VDS(name = "getworkflowmappingid", tenant = "MAC")
    public CompleteModel getworkflowmappingidwfid(@FP(name = "mdlcode") String mdlcode, @FP(name = "cnttypecode") String cnttypecode, @FP(name = "fromcnttypecode") String fromCntType, @FP(name = "active_status", condition = Condition.NOTEQUALS) String active_status);

    @VDS(name = "getiasvesselcode", tenant = "mac")
    public CompleteModel getusermappedvessels(@FP(name = "usercode") String usercode, @FP(name = "shorecode") String shorecode);

    @VDS(name = "getworkflowtype", tenant = "MAC")
    public CompleteModel getworkflowtype(@FP(name = "mdlcode") String mdlcode);

    //FOR REVOKE
    @VDS(name = "getClaimeduser", tenant = "MAC")
    public CompleteModel getClaimeduserdetail(@FP(name = "usercode") String mdlcode);

    @VDS(name = "updaterevoke", tenant = "MAC")
    public Map updaterevoke(CompleteModel completeModel);

    @VDS(name = "checkbeforerevoke", tenant = "MAC")
    public CompleteModel checkbeforerevoke(@FP(name = "refno") String refno, @FP(name = "status") String status, @FP(name = "claimuser") String claimuser, @FP(name = "nodeid") String nodeid);

    @VDS(name = "getnotificationbyuserandmodule", tenant = "MAC")
    public CompleteModel getnotificationbyuserandmodule(@FP(name = "usercode") String refno, @FP(name = "mdlcode") String status);

    @VDS(name = "getchatbyuserandmodule", tenant = "MAC")
    public CompleteModel getchatbyuserandmodule(@FP(name = "receiverid") String refno, @FP(name = "formmoduleid") String status);
 //------------------------------------------------------

    @VDS(name = "getCompanyMappedvessels", tenant = "mac")
    public CompleteModel getCompanyMappedvessels(@FP(name = "shorecode") String shorecode);

    @VDS(name = "checkIsHead", tenant = "mac")
    public CompleteModel checkIsHead(@FP(name = "shorecode") String shorecode);

    @VDS(name = "getCorporateMappedvessels", tenant = "mac")
    public CompleteModel getCorporateMappedvessels(@FP(name = "corporateid") int corporateid);

    @VDS(name = "getgroupnamelnd", tenant = "mac")
    public CompleteModel getGroupname(@FP(name = "groupcode") String usergroup);
//mbutil vds

    @VDS(name = "getgrpcodebyvessel", tenant = "mac")
    public abstract VDSMackBpmUtil getgrpcodebyvessel(@FP(name = "usercode") String username, @FP(name = "vslcompcode") String vesselcode);

    @VDS(name = "getfunbasedgrpcode", tenant = "mac")
    public abstract VDSMackBpmUtil getfunbasedgrpcode(@FP(name = "usercode") String usercode, @FP(name = "vslcompcode") String vslcompcode);

    @VDS(name = "getfunbasedgrpcode", tenant = "mac")
    public abstract VDSMackBpmUtil getfunbasedgrpcode(@FP(name = "usercode") String usercode);

    @VDS(name = "getgrpcodebyvessel", tenant = "mac")
    public abstract VDSMackBpmUtil getgrpcodebyvessel(@FP(name = "usercode") String usercode);

    @VDS(name = "getcompanycodeofvessel", tenant = "MAC")
    public VDSMackBpmUtil getcompanycodeofvessel(@FP(name = "vesselcode") String fromuser);

    @VDS(name = "getmodulenamelnd", tenant = "MAC")
    public CompleteModel getModuleName(@FP(name = "moduleid") String moduleid);

    @VDS(name = "getbpmprocessinstancegroup", tenant = "mac")
    public abstract VDSMackBpmUtil getbpmprocessinstancegroupnodeid(@FP(name = "wfid") String wfid, @FP(name = "instanceid") String instanceid, @FP(name = "nodeid") String nodeid);

    @VDS(name = "getlndsystemconfig", tenant = "MAC")
    public CompleteModel getlndsystemconfig(@FP(name = "sysparam") String moduleid);

    @VDS(name = "getadrdetails", tenant = "MAC")
    public CompleteModel getadrdetails(@FP(name = "submittedby") String submittedby, @FP(name = "frmrefno") String frmrefno);
// company validation vds
     @VDS(name = "checkheadoffice", tenant = "MAC")
    public CompleteModel checkheadoffice(@FP(name = "shorecode") String shorecode, @FP(name = "active_status") String active_status);

     @VDS(name = "getcompanybycorp", tenant = "MAC")
    public CompleteModel getcompanybycorp(@FP(name = "corporateid") int corporateid,@FP(name = "active_status") String active_status);
// Delete portal vds
    
      @VDS(name = "getdelreqrefno", tenant = "MAC")
    public CompleteModel getdelreqrefno(@FP(name = "reqstatus",condition = Condition.IN) String reqstatus,@FP(name = "mdlcode") String mdlcode);
 
    @VDS(name = "getdelreqdetails", tenant = "MAC")
    public CompleteModel getdelreqdetails(@FP(name = "mdlrefno") String mdlrefno);

    @VDS(name = "getsupereditor", tenant = "MAC")
    public CompleteModel getsupereditor(@FP(name = "mdlcode") String mdlcode, @FP(name = "companycode") String companycode, @FP(name = "active_status") String active_status
    , @FP(name = "status") String status);
    

    @VDS(name = "getpowereditor", tenant = "MAC")
    public CompleteModel getpowereditor(@FP(name = "mdlcode") String mdlcode, @FP(name = "status") String status, @FP(name = "shorecode") String shorecode );
    
    @VDS(name = "getworkflowstage", tenant = "MAC")
    public CompleteModel getworkflowstage(@FP(name = "mdlcode") String mdlcode);
    
    @VDS(name = "getcurrentformstatus", tenant = "MAC")
    public CompleteModel getcurrentformstatus(@FP(name = "refno") String refno);
    
    @VDS(name = "getworkflowgroup", tenant = "MAC")
    public CompleteModel getworkflowgroup(@FP(name = "usercode") String usercode);

    @VDS(name="getlandingpagetaskdeatils", tenant="mac")
    public abstract CompleteModel getlandingpagetaskdeatils(SvmJsonList paramSvmJsonList);

    @VDS(name="getRefnoHandledByUserSP", tenant="mac")
    public abstract CompleteModel getRefnoHandledByUserSP(SvmJsonList paramSvmJsonList);
}
