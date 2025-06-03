package com.svm.lrp.nfr.lnd.model;

import java.io.Serializable;
import com.svm.lrp.nfr.jsf.utils.IModel;
import com.svm.lrp.nfr.jsf.utils.IUIModel;
import java.util.List;

public class LandingPageModel
        implements Serializable, IModel {

    LandingPageUIDataModel dataModel;
    LandingPageUIStateModel stateModel;

    public LandingPageModel() {
        this.dataModel = new LandingPageUIDataModel();
        this.stateModel = new LandingPageUIStateModel();
    }

    public List<String> getScrRefList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> getWfRefList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public IModel getClonedModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public LandingPageUIDataModel getDataModel() {
        return this.dataModel;
    }

    public void setDataModel(LandingPageUIDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public LandingPageUIStateModel getStateModel() {
        return this.stateModel;
    }

    public void setStateModel(LandingPageUIStateModel stateModel) {
        this.stateModel = stateModel;
    }

    public IUIModel getUIModel() {
        return this.stateModel;
    }
}



//{"prop":{
//     "tempfinalall.rskid": {
//  		"displayname":"S.No",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"	
//  
//               }, 
//     "tempfinalall.rskrfid": {
//  		"displayname":"Ref.Id",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//    "tempfinalall.taskname": {
//  		"displayname":"Task",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//    "tempfinalall.locationname":{
//  		"displayname":"Location",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.assessmentdate":{
//  		"displayname":"Date of Task",
// 		"type" : "Datetime",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.companyapprovalreq":{
//  		"displayname":"Company Approval Required",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.jobcommencedate":{
//  		"displayname":"Commenced",
// 		"type" : "Datetime",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.jobcompleteddate":{
//  		"displayname":"Completed",
// 		"type" : "Datetime",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.crName":{
//  		"displayname":"Created By",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.statusdesc":{
//  		"displayname":"Status",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.vesselname":{
//  		"displayname":"Ship Name",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    },
//    "tempfinalall.fleetname":{
//  		"displayname":"Fleet Name",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//    }
//  },
//   "columnorder":["tempfinalall.rskid","tempfinalall.rskrfid","tempfinalall.taskname","tempfinalall.vesselname","tempfinalall.fleetname","tempfinalall.locationname","tempfinalall.assessmentdate","tempfinalall.companyapprovalreq","tempfinalall.jobcommencedate","tempfinalall.jobcompleteddate","tempfinalall.crName","tempfinalall.statusdesc"],
//   "hideinship":[""],
//  	"hideinshore":[""],
//  	"refnofield":"tempfinalall.rskid",
//  	"statusdesc" : "tempfinalall.statusdesc",
//	"columngroup":"Y",
//"groupprop":{
//"Ship Status":{
//     "shiptempstatus.ship_formstatus": {
//  		"displayname":"Status",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"	
//  
//               }, 
//     "shiptempstatus.ship_empname": {
//  		"displayname":"Action By",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//"shiptempstatus.ship_grpname": {
//  		"displayname":"Department",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//"shiptempstatus.ship_completedate": {
//  		"displayname":"Date",
// 		"type" : "Datetime",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        }
//	},
//"Shore Status":{
//    "tempfinalall.Shore_formstatus": {
//  		"displayname":"Status",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"	
//  
//               }, 
//     "tempfinalall.Shore_empname": {
//  		"displayname":"Action By",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//"tempfinalall.Shore_grpname": {
//  		"displayname":"Department",
// 		"type" : "String",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//  
//        },
//"tempfinalall.Shore_completedate": {
//  		"displayname":"Date",
// 		"type" : "Datetime",
// 		"format":"",
//  		"show":"Y",
//  		"cwidth":"10",
//  		"isnavgate":"y",
//  		"targetmdl":"RSK"
//	}
//  }
//},
//  "spancolumnorder":["tempfinalall.rskrfid","tempfinalall.vesselname","tempfinalall.fleetname","tempfinalall.locationname","tempfinalall.taskname","tempfinalall.assessmentdate","tempfinalall.companyapprovalreq","tempfinalall.jobcommencedate","tempfinalall.jobcompleteddate","tempfinalall.crName","tempfinalall.rskid","tempfinalall.statusdesc","shiptempstatus.ship_formstatus","shiptempstatus.Ship_empname","shiptempstatus.Ship_grpname","shiptempstatus.Ship_completedate","tempfinalall.Shore_formstatus","tempfinalall.Shore_empname","tempfinalall.Shore_grpname","tempfinalall.Shore_completedate"]}