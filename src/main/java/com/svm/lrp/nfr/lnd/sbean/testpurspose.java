/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.sbean;

import com.google.gson.internal.LinkedTreeMap;
import com.svm.json.SvmJsonList;
import com.svm.json.SvmJsonObject;
import com.svm.json.SvmJsonUtil;
import com.svm.lrp.nfr.lnd.vds.LandingPageVds;
import com.svm.lrp.nfr.lnd.vo.LNDPageThirdLevelValidation;
import com.svm.lrp.nfr.query.cbean.VDSInvoker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author durgadevi.b
 */
@Stateless
public class testpurspose {

    LandingPageVds service;

    @Inject
    VDSInvoker vds;

    @Inject
    SvmJsonUtil svmJsonUtil;

    @PostConstruct
    public void init() {
//        System.out.println("Init of webservce called.. haiyyyaa.........");
        service = vds.create(LandingPageVds.class);
    }

    public String getData(String str) {
        LNDPageThirdLevelValidation ans = new LNDPageThirdLevelValidation();
        try {
            SvmJsonList sptrdlParam = new SvmJsonList(str);
            ArrayList ls = new ArrayList();
            List getval = new ArrayList();
            LinkedTreeMap<String, String> hm = new LinkedTreeMap<String, String>();
            Map<String, String> newhm = new HashMap<String, String>();
            ArrayList newls = new ArrayList();
            LNDPageThirdLevelValidation getans = (LNDPageThirdLevelValidation) this.svmJsonUtil.toObject(str, LNDPageThirdLevelValidation.class);
            ls = getans.getReflist();
            for (int i = 0; i < getans.getReflist().size(); i++) {
                hm = new LinkedTreeMap<String, String>();
                newhm = new HashMap<String, String>();
                hm = (LinkedTreeMap<String, String>) getans.getReflist().get(i);
                newhm.put("Refno", hm.get("Refno").toString());
                if (i < 5) {
                    newhm.put("Access", "true");
                } else {
                    newhm.put("Access", "false");
                }
                newls.add(newhm);
            }
            
            ans.setAccesslist(newls);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return svmJsonUtil.toString(ans);
    }

}
