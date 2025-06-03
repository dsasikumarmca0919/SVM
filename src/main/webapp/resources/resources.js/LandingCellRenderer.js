/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// cell renderer class

function LandingCellRenderer() {
}


function windowOpenedName(){
    var name = window.name;
    lnd_navigate_rc_windowOpenedState([{name:'windowname', value:name}]);
    
}
// init method gets the details of the cell to be rendere
LandingCellRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;

        this.params = params.data;
        this.rk = data.rk;
        this.btnEditRenderInHm = false;
        this.btnNavigateNewRenderInHm = false;
        this.btnRevokeOrangeBtnRenderInHm = false;
        this.btnnewtabrender = false;
        this.btnaddrev = false;
        this.deleterequest = false;
        this.isSuperEditor = false;
       
        var btnEditRenderFromHashMap = data.btnEditRenderInHm;
        //  console.log("btnEditRenderFromHashMap====" + btnEditRenderFromHashMap);
        var btnNavigateNewRenderFromHashMap = data.bNavigateNewBtnRendered;
        var btnRevokeOrangeBtnFromHashMap = data.btnRevokeOrangeBtn;
        var btnRevokeOrangeBtnFromHashMap = data.btnRevokeOrangeBtn;

        var btnaddrevFromHashMap = data.btnaddtionalrevvalidation;
         var btndelrequest = data.delrequest;
         var superEditor = data.superEditor;
      
        // var strStatusDescValueFromHashMap = data.strStatusDescValue;
        this.btnnewtabrender = data.isNewTabEnable;
        if (btnEditRenderFromHashMap === 'Yes') {
            this.btnEditRenderInHm = btnEditRenderFromHashMap;
        }
        if (btnNavigateNewRenderFromHashMap === 'true') {
            this.btnNavigateNewRenderInHm = btnNavigateNewRenderFromHashMap;
        }
        if (btnRevokeOrangeBtnFromHashMap === 'true') {
            this.btnRevokeOrangeBtnRenderInHm = btnRevokeOrangeBtnFromHashMap;
        }

        if (btnaddrevFromHashMap === 'true') {
            this.btnaddrev = btnaddrevFromHashMap;
        }
        
        if (btndelrequest === 'true') {
            this.deleterequest = btndelrequest;
        }
        if(superEditor){
            this.isSuperEditor = true;
        }
        

//        console.log("//==//==|this.btnEditRenderInHm|==>" + this.btnEditRenderInHm);

        //var d = JSON.stringify(data);
        //console.log("//==//==|d|==>" + d);
        //console.log(data.isNewTabEnable);
//        console.log("//==//==|params.column.colDef|==>"+params.column.colDef.field);
    }
};
LandingCellRenderer.prototype.getGui = function () {

    var viewBtn = document.createElement('button');
    viewBtn.setAttribute("type", "submit");
    viewBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only submitBtn");
    viewBtn.setAttribute("style", "width: 23px !important;height: 23px !important; padding: 1px 9px;  border: 1px solid #247bc8; border-radius: 20%; background-color: #247bc8;");
    viewBtn.setAttribute("onclick", "lnd_navigate_rc_viewClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
    viewBtn.setAttribute("title", "View");

    viewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c icon-landpg_eye\" style=\"margin-top: -9px;color: #ffff;margin-left: -9px;font-size: 18px;\"></span>';
    this.span.appendChild(viewBtn);
    //
    //   console.log("this.btnEditRenderInHm========" + this.btnEditRenderInHm);
    if (this.btnEditRenderInHm) {
        var editBtn = document.createElement('button');
        editBtn.setAttribute("type", "submit");
        editBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only editBtn");
        if(this.isSuperEditor){
            editBtn.setAttribute("style", "background-color: #7e42f5;border: 1px solid #7e42f5;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
            editBtn.setAttribute("onclick", "lnd_navigate_rc_supereditClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
            editBtn.setAttribute("title", "Super Edit");
        }else{
            editBtn.setAttribute("style", "background-color: #4caf50;border: 1px solid #4caf50;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
            editBtn.setAttribute("onclick", "lnd_navigate_rc_editClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
            editBtn.setAttribute("title", "Edit");
        }
        editBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c icon-landpg_edit\" style=\"margin-top: -8px;color: #ffff;margin-left: -8px;font-size: 17px;\"></span>';
        this.span.appendChild(editBtn);
    }

    if (this.btnNavigateNewRenderInHm) {
        var navigateNewBtn = document.createElement('button');
        navigateNewBtn.setAttribute("type", "navigateNew");
        navigateNewBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        navigateNewBtn.setAttribute("style", "width:23px !important; height:23px !important;");
        navigateNewBtn.setAttribute("onclick", "lnd_navigate_rc_navigateNewClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        navigateNewBtn.setAttribute("title", "New");
        navigateNewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-file-o\" style=\"margin-left: -7px;\"></span>';

        this.span.appendChild(navigateNewBtn);
    }
    //
    if (this.btnRevokeOrangeBtnRenderInHm) {
        var revokeOrangeBtn = document.createElement('button');
        revokeOrangeBtn.setAttribute("type", "rewokeEditBtn");
        revokeOrangeBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        revokeOrangeBtn.setAttribute("style", "width: 23px !important;height: 23px !important;margin-left: 4px; padding: 1px 9px;border: 1px solid #FE9331;border-radius: 20%;background-color: #FE9331;");
        revokeOrangeBtn.setAttribute("onclick", "lnd_navigate_rc_RevokeEditBtn([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        revokeOrangeBtn.setAttribute("title", "Info");
        revokeOrangeBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-info\" style="margin-left: -6px;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';
        this.span.appendChild(revokeOrangeBtn);
    }
    if (this.btnnewtabrender) {
        console.log("//==//==|this.btnnewtabrender **|==>" + this.btnnewtabrender);
        var newtabBtn = document.createElement('button');
        newtabBtn.setAttribute("type", "submit");
        newtabBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only submitBtn");
        newtabBtn.setAttribute("style", "width: 23px !important;height: 23px !important;border: 1px solid #191970;background-color: #191970;border-radius: 20%;margin-left: 4px;padding: 1px 9px;");
        newtabBtn.setAttribute("onclick", "lnd_navigate_rc_tabviewClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        newtabBtn.setAttribute("title", "New Tab");
        newtabBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-external-link-square popouticon\" style=\"margin-left: -7px;margin-top: -8px;color:#ffff;\"></span>';
        this.span.appendChild(newtabBtn);
    }
    
       if (this.btnaddrev) {
        var adrbtn = document.createElement('button');
        adrbtn.setAttribute("type", "addrEditBtn");
        adrbtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        adrbtn.setAttribute("style", "width: 23px !important;height: 23px !important;margin-left: 4px; padding: 1px 9px;border: 1px solid #00ae8d;border-radius: 20%;background-color: #00ae8d;");
        adrbtn.setAttribute("onclick", "remoteadrbtn([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        adrbtn.setAttribute("title", "Additional Reviewer Added Info");
        adrbtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-info\" style="margin-left: -6px;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';
        this.span.appendChild(adrbtn);
    }
    
       if (this.deleterequest) {
        var delreqbtn = document.createElement('button');
        delreqbtn.setAttribute("type", "delreqbtn");
        delreqbtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        delreqbtn.setAttribute("style", "width: 23px !important;height: 23px !important;margin-left: 4px; padding: 1px 9px;border: 1px solid #00ae8d;border-radius: 20%;background-color: #757575;");
        delreqbtn.setAttribute("onclick", "remotedeletereqbtn([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        delreqbtn.setAttribute("title", "Delete request");
        delreqbtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-info\" style="margin-left: -6px;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';
        this.span.appendChild(delreqbtn);
    }
    
    
    
    //  console.log("//==//==|span **|==>" + this.span);
    return this.span;
};



svmdt.addCellRenderer('LND', 'LandingCellRenderer');



