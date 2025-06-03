/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.util;

import com.svm.lrp.bpm.nfr.bpm.vo.TaskSummaryVo;
import com.svm.lrp.bpm.util.vo.StatusVo;
import com.svm.lrp.nfr.jsf.utils.APPINFO;
import com.svm.lrp.nfr.jsf.utils.Category;
import com.svm.lrp.nfr.jsf.utils.ILogger;
import com.svm.lrp.nfr.jsf.utils.IMetaData;
import com.svm.lrp.nfr.jsf.utils.NFRUtils;
import com.svm.lrp.nfr.jsf.utils.USERINFO;
import com.svm.lrp.nfr.lnd.ctrl.LandingPageCtrl;
import com.svm.lrp.nfr.lnd.model.LandingDataVo;
import com.svm.lrp.nfr.lnd.vds.LandingPageVds;
import com.svm.lrp.nfr.lnd.vo.Bpmusergroupmapping_vessel;
import com.svm.lrp.nfr.lnd.vo.CompleteModel;
import com.svm.lrp.nfr.query.cbean.VDSInvoker;
import com.svm.mac.macs.multitenanacy.INFRMultiTenanacyUtil;
import com.svm.mac.nfr.util.powerEdit.vds.IPowerEditChecker;
import com.svm.mac.wfa.bean.WFHistoryUtil;
import com.svm.mac.wfa.model.entity.Workflowhistory;
import com.svm.mac.wfa.model.entity.Workflownextuser;
import com.svm.nfr.notify.smbpmutil.ISMBPMUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author ragavi.r
 */
@Dependent
public class LandingUtil { // newbutbpm

  @Inject
  @Category(name = "Landing_Page")
  ILogger logger;

  @Inject
  VDSInvoker serviceInvoker;
  //
  LandingPageVds service;
  @Inject
  ISMBPMUtil smbpmUtil;

  @Inject
  WFHistoryUtil wFHistoryUtil;

  IMetaData mData;

  @Inject
  IPowerEditChecker iPowerEditChecker;

  long newButtonActionbefore = System.currentTimeMillis();
  String pwdMdlCode ="";

  @Inject
  INFRMultiTenanacyUtil multitenency;

  String tenantIdentifier = "";

  @PostConstruct
  public void init() {
    mData = NFRUtils.getMetaData();
    service = serviceInvoker.create(LandingPageVds.class);
    this.tenantIdentifier = multitenency.getApplicationContextProperty();

  }
  public LandingDataVo getNewActionLandingData(String sMdlid, String sCurrentCtrltype, String sFormCtrlType) {
    logger.info("---getNewActionLandingData time in " + (System.currentTimeMillis() - newButtonActionbefore));
    LandingDataVo landingdata = new LandingDataVo();
    landingdata.setData(null);
    landingdata.setIsBPMEnabled(true);
    landingdata.setAction(LandingDataVo.LandingAction.NEW);
    landingdata.setTasksummary(new TaskSummaryVo());
    // landingdata.setTaskid(new TaskSummaryVo());
    //
    CompleteModel wrkFlowIdCreate = service.getworkflowmappingid(sMdlid, sCurrentCtrltype, sFormCtrlType, "A");
    logger.info("## Test==>" + wrkFlowIdCreate.getWorkflowmapping().isEmpty());
    if (!wrkFlowIdCreate.getWorkflowmapping().isEmpty()) {
      logger.info("==wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid()===>"
          + wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid());
      logger.info("==wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid()===>"
          + wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid());

      landingdata.setWfid(wrkFlowIdCreate.getWorkflowmapping().get(0).getWorkflowid().trim());
      landingdata.setBpmwfid(wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid().trim());
      if (wrkFlowIdCreate.getWorkflowmapping().get(0).getIsdynamicmdl().trim().equalsIgnoreCase("Y")) {
        landingdata.setIsDynamicMdl(true);
      }
    }
    logger.info("---getNewActionLandingData time out " + (System.currentTimeMillis() - newButtonActionbefore));
    return landingdata;
  }

  public LandingDataVo getLandingDataByWrkFlowID(String sWorkFlowID) {
    // THIS METHOD USED FOR ONLY TO FIND THE bpmworkflowid and dynamiclandingmdl by
    // workflowid
    LandingDataVo landingdata = new LandingDataVo();
    if (sWorkFlowID != null) {
      landingdata.setIsBPMEnabled(true);
      landingdata.setWfid(sWorkFlowID);
      //
      CompleteModel wrkFlowIdCreate = service.getworkflowmappingid(sWorkFlowID);
      logger.info("## Test==>" + wrkFlowIdCreate.getWorkflowmapping().isEmpty());
      if (!wrkFlowIdCreate.getWorkflowmapping().isEmpty()) {
        landingdata.setBpmwfid(wrkFlowIdCreate.getWorkflowmapping().get(0).getBpmwrkflowid().trim());
        if (wrkFlowIdCreate.getWorkflowmapping().get(0).getIsdynamicmdl().trim().equalsIgnoreCase("Y")) {
          landingdata.setIsDynamicMdl(true);
        }
      }
    }
    return landingdata;
  }

  public void navigatetomodule(String fromMdlid, String ToMdlid, String refno, boolean isBPM) {
    LandingDataVo landingdata = new LandingDataVo();
    try {
      logger.info("fromMdlid ::" + fromMdlid + "ToMdlid::" + ToMdlid + "refno::" + refno + "isBPM::" + isBPM);
      List NavigateList = new ArrayList();
      NavigateList.add(refno);
      landingdata.setData(NavigateList);
      landingdata.setAction(LandingDataVo.LandingAction.VIEW);

      if (isBPM) {
        StatusVo statusVo = this.smbpmUtil.getTaskSummaryByRefno(refno);
        if (statusVo.getStatus() == StatusVo.STATUS.SUCCESS) {
          landingdata.setTasksummary(statusVo.getTaskSummaryVo());
          landingdata.setWfid(statusVo.getWfid());
          CompleteModel workflowid = this.service.getworkflowmappingid(statusVo.getWfid());
          if (workflowid.getWorkflowmapping() != null) {
            landingdata.setBpmwfid((workflowid.getWorkflowmapping().get(0)).getBpmwrkflowid().trim());
            if (workflowid.getWorkflowmapping().get(0).getIsdynamicmdl().trim().equalsIgnoreCase("Y")) {
              landingdata.setIsDynamicMdl(true);
            }
          }
          landingdata.setIsBPMEnabled(true);
        }
      }
      pwdMdlCode = ToMdlid;
      landingdata.setReferenceNumber(refno);
      landingdata = powerEditCheckerUtil(landingdata);
      NFRUtils.navigateTo(fromMdlid, ToMdlid, landingdata, false, true);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

/**
     * NFR-6937
     * This method checks if the current user has the power editor rights to edit the task while navigating via corporate page and dashboard.
     *
     * @param landingdata The LandingDataVo object that contains the task details.
     * @param mdlcode The module code of the task.
     * @param refno The reference number of the task.
     * @return The LandingDataVo object with the power editor flag and type set.
     */
  public LandingDataVo powerEditCheckerUtil(LandingDataVo landingdata) {
    try {
      logger.info("---lndutil---powerEditChecker start " + tenantIdentifier);
            HashMap<String, String> paramMap = new HashMap<String, String>();
            HashMap<String, String> returnMap = new HashMap<String, String>();
            paramMap.put("moduleId", pwdMdlCode);
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
            logger.info("---lndutil---powereditor values " + landingdata.isPowerEditor() + " " + landingdata.getPowerEditorType());
            }catch(Exception e){
            logger.info("lndcbean","---lndutil---powerEditChecker Exception " + e);
            logger.fatal(e);
            e.printStackTrace();
        }
        return landingdata;
    }

}