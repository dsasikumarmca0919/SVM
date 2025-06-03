/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

//1. GroupEditBtnRenderer.js 
// cell renderer class
function GroupEditBtnRenderer() {
}

// init method gets the details of the cell to be rendere
GroupEditBtnRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.groupEditBtnRenderer = false;
        var groupEditBtnRendererFromHashMap = data.groupEditBtnRenderer;
        if (groupEditBtnRendererFromHashMap === 'true') {
            this.groupEditBtnRenderer = groupEditBtnRendererFromHashMap;
        }
    }
};
GroupEditBtnRenderer.prototype.getGui = function () {

    if (!this.groupEditBtnRenderer) {
        var groupeditBtn = document.createElement('button');
        groupeditBtn.setAttribute("type", "submit");
        groupeditBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only editBtn");
        groupeditBtn.setAttribute("style", "background-color: #4caf50;border: 1px solid #4caf50;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
        groupeditBtn.setAttribute("onclick", "lnd_navigate_rc_editClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        groupeditBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-edit\" style=\"margin-left: -8px;color: #4caf50;\"></span>';

        this.span.appendChild(groupeditBtn);
    }
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupEditBtnRenderer');

//2. GroupNewBtnRendere.js 
// cell renderer class
function GroupNewBtnRenderer() {
}

// init method gets the details of the cell to be rendere
GroupNewBtnRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.groupNewBtnRenderer = false;
        var groupNewBtnRendererFromHashMap = data.newrenidentifierlistrows;
        if (groupNewBtnRendererFromHashMap === 'true') {
            this.groupNewBtnRenderer = groupNewBtnRendererFromHashMap;
        }

    }
};
GroupNewBtnRenderer.prototype.getGui = function () {

    if (!this.groupNewBtnRenderer) {
        var navigateNewBtn = document.createElement('button');
        navigateNewBtn.setAttribute("type", "navigateNew");
        navigateNewBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        navigateNewBtn.setAttribute("style", "width:23px !important; height:23px !important;");
        navigateNewBtn.setAttribute("onclick", "lnd_navigate_rc_navigateNewClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        navigateNewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-file-o\" style=\"margin-left: -7px;\"></span>';

        this.span.appendChild(navigateNewBtn);

    }
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupNewBtnRenderer');

//3. GroupviewBtnRenderer.js
// cell renderer class
function GroupviewBtnRenderer() {
}

// init method gets the details of the cell to be rendere
GroupviewBtnRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.groupviewBtnRenderer = false;
        this.colname = params.column.colId;
        var groupviewBtnRendererFromHashMap = data.viewrenidentifierlistrows;
        if (groupviewBtnRendererFromHashMap === 'true') {
            this.groupviewBtnRenderer = groupviewBtnRendererFromHashMap;
        }
    }
};
GroupviewBtnRenderer.prototype.getGui = function () {

    if (!this.groupviewBtnRenderer) {
        var groupviewBtn = document.createElement('button');
        groupviewBtn.setAttribute("type", "submit");
        groupviewBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only submitBtn");
        groupviewBtn.setAttribute("style", "width: 23px !important;height: 23px !important; padding: 1px 9px;  border: 1px solid #247bc8; border-radius: 20%; background-color: #247bc8;");
        groupviewBtn.setAttribute("onclick", "lnd_navigate_rc_navigateViewClicked([{name:'rowIndex',value:'" + this.rk + "'},{name:'colname',value:'" + this.colname + "'}]);return false;");
        groupviewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c icon-landpg_eye\" style=\"margin-top: -9px;color: #ffff;margin-left: -9px;font-size: 18px;\"></span>';
        this.span.appendChild(groupviewBtn);
    }
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupviewBtnRenderer');

//4. LandingCellRenderer.js
// cell renderer class

function LandingCellRenderer() {
}

function windowOpenedName() {
    var name = window.name;
    setTimeout(function () {
        lnd_navigate_rc_windowOpenedState([{name: 'windowname', value: name}]);
    }, 2000);
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
        var btnNavigateNewRenderFromHashMap = data.bNavigateNewBtnRendered;
        var btnRevokeOrangeBtnFromHashMap = data.btnRevokeOrangeBtn;
        var btnRevokeOrangeBtnFromHashMap = data.btnRevokeOrangeBtn;

        var btnaddrevFromHashMap = data.btnaddtionalrevvalidation;
        var btndelrequest = data.delrequest;
        var superEditor = data.superEditor;

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
        if (superEditor) {
            this.isSuperEditor = true;
        }
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
    if (this.btnEditRenderInHm) {
        var editBtn = document.createElement('button');
        editBtn.setAttribute("type", "submit");
        editBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only editBtn");
        if (this.isSuperEditor) {
            editBtn.setAttribute("style", "background-color: #7e42f5;border: 1px solid #7e42f5;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
            editBtn.setAttribute("onclick", "lnd_navigate_rc_supereditClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
            editBtn.setAttribute("title", "Super Edit");
        } else {
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
    return this.span;
};
svmdt.addCellRenderer('LND', 'LandingCellRenderer');

//5. LandingCellRendererfortable2
// cell renderer class
function LandingCellRendererfortable2() {
}

// init method gets the details of the cell to be rendere
LandingCellRendererfortable2.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.btnnewtabrender = false;
        this.btnnewtabrender = data.isNewTabEnable;
    }
};
LandingCellRendererfortable2.prototype.getGui = function () {
    if (this.btnnewtabrender) {
        var newtabBtn = document.createElement('button');
        newtabBtn.setAttribute("type", "submit");
        newtabBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only submitBtn");
        newtabBtn.setAttribute("style", "width: 23px !important;height: 23px !important;border: 1px solid #191970;background-color: #191970;border-radius: 20%;margin-left: 4px;padding: 1px 9px;");
        newtabBtn.setAttribute("onclick", "lnd_navigate_rc_tabviewClicked_oth([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        newtabBtn.setAttribute("title", "New Tab");
        newtabBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-external-link-square popouticon\" style=\"margin-left: -7px;margin-top: -8px;color:#ffff;\"></span>';
        this.span.appendChild(newtabBtn);
    } else {
        var viewBtn = document.createElement('button');
        viewBtn.setAttribute("type", "submit");
        viewBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only submitBtn");
        viewBtn.setAttribute("style", "width: 23px !important;height: 23px !important; padding: 1px 9px;  border: 1px solid #247bc8; border-radius: 20%; background-color: #247bc8;");
        viewBtn.setAttribute("onclick", "lnd_navigate_rc_viewClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        viewBtn.setAttribute("title", "View");
        viewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c icon-landpg_eye\" style=\"margin-top: -9px;color: #ffff;margin-left: -9px;font-size: 18px;\"></span>';
        this.span.appendChild(viewBtn);
    }
    return this.span;
};
svmdt.addCellRenderer('LND', 'LandingCellRendererfortable2');

//6. NBpmDataSetRenderer.js
function NBpmDataSetRenderer() {
}

NBpmDataSetRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
    }
};

NBpmDataSetRenderer.prototype.getGui = function () {
    var userSelectBtn = document.createElement('button');
    userSelectBtn.setAttribute("type", "submit");
    userSelectBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ");
    userSelectBtn.setAttribute("style", "width: 23px !important;height: 23px !important;padding: 1px 9px;border: 1px solid #247bc8 !important;border-radius: 20%;background-color: #247bc8 !important");
    userSelectBtn.setAttribute("onclick", "getRowData('" + JSON.stringify(this.params) + "');return false;");
    userSelectBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-stack-exchange\" style=\"margin-left: -5px;color:#fff;\"></span>';
    this.span.appendChild(userSelectBtn);
    return this.span;
};
svmdt.addCellRenderer('LND', 'NBpmDataSetRenderer');

//7. NBpmRevokeRecallRenderer.js
function NBpmRevokeRecallRenderer() {
}

NBpmRevokeRecallRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.nonbpmrevoke = false;
        this.nonbpmrecall = false;
        if (data.nonbpmrevoke) {
            this.nonbpmrevoke = true;
        } else if (data.nonbpmrecall) {
            this.nonbpmrecall = true;
        }
    }
};
NBpmRevokeRecallRenderer.prototype.getGui = function () {
    if (this.nonbpmrevoke) {
        var nBpmRRBtn = document.createElement('button');
        nBpmRRBtn.setAttribute("type", "submit");
        nBpmRRBtn.setAttribute("class", "btn btn-success btn-sm");
        nBpmRRBtn.setAttribute("style", "background-color: #4caf50;border: 1px solid #4caf50;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
        nBpmRRBtn.setAttribute("onclick", "lnd_navigate_rc_nbpnmRevoke([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        nBpmRRBtn.setAttribute("title", "Revoke");
        nBpmRRBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-revoked\" style=\"margin-left: -7px;color: #ffff;\"></span>';
        this.span.appendChild(nBpmRRBtn);
        return this.span;
    } else if (this.nonbpmrecall) {
        var recallbtn = document.createElement('button');
        recallbtn.setAttribute("type", "btnrecall");
        recallbtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        recallbtn.setAttribute("style", "width: 23px !important;height: 23px !important;margin-left: 4px; padding: 1px 9px;border: 1px solid #a714a2;border-radius: 20%;background-color: #a714a2;");
        recallbtn.setAttribute("onclick", "lnd_navigate_rc_nbpnmRecall([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        recallbtn.setAttribute("title", "Recall");
        recallbtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-revoked\" style="margin-left: -6px;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';
        this.span.appendChild(recallbtn);
        return this.span;
    }
};
svmdt.addCellRenderer('LND', 'NBpmRevokeRecallRenderer');

function getRowData(data) {
    try {
        if (data !== null) {
            var finalFilterObjdataarray = data.data.map;
            if (finalFilterObjdataarray !== null) {
                lnd_navigate_rc_getRowData([{
                        name: 'rowFilterValue',
                        value: JSON.stringify(finalFilterObjdataarray)
                    }]);
            }
        }
    } catch (e) {
        console.log('---lnd---Exception ' + e)
    }
}

//8. RevokeCellRenderer.js
// cell renderer class
function RevokeCellRenderer() {
}

// init method gets the details of the cell to be rendere
RevokeCellRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.btnRevokeEditRenderInHm = false;
        this.btnrecall = false;
        var btnRevokeEditRenderFromHashMap = data.btnRevokeBtn;
        var btnrecallFromHashMap = data.recallbtn;
        if (btnRevokeEditRenderFromHashMap === 'true') {
            this.btnRevokeEditRenderInHm = btnRevokeEditRenderFromHashMap;
        }
        if (btnrecallFromHashMap === 'true') {
            this.btnrecall = btnrecallFromHashMap;
        }
    }
};
RevokeCellRenderer.prototype.getGui = function () {

    if (this.btnRevokeEditRenderInHm) {
        var revokeEditBtn = document.createElement('button');
        revokeEditBtn.setAttribute("type", "submit");
        revokeEditBtn.setAttribute("class", "btn btn-success btn-sm");
        revokeEditBtn.setAttribute("style", "background-color: #4caf50;border: 1px solid #4caf50;width: 23px !important;height: 23px !important;padding: 1px 9px;border-radius: 20%;margin-left: 4px;");
        revokeEditBtn.setAttribute("onclick", "lnd_navigate_rc_revokeEditClicked([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        revokeEditBtn.setAttribute("title", "Revoke");
        revokeEditBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-revoked\" style=\"margin-left: -7px;color: #ffff;\"></span>';
        this.span.appendChild(revokeEditBtn);
    }

    if (this.btnrecall) {
        var recallbtn = document.createElement('button');
        recallbtn.setAttribute("type", "btnrecall");
        recallbtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only");
        recallbtn.setAttribute("style", "width: 23px !important;height: 23px !important;margin-left: 4px; padding: 1px 9px;border: 1px solid #a714a2;border-radius: 20%;background-color: #a714a2;");
        recallbtn.setAttribute("onclick", "remoterecall([{name:'rowIndex',value:'" + this.rk + "'}]);return false;");
        recallbtn.setAttribute("title", "Recall");
        recallbtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-revoked\" style="margin-left: -6px;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';
        this.span.appendChild(recallbtn);
    }
    return this.span;
};
svmdt.addCellRenderer('LND', 'RevokeCellRenderer');

//9. StatusCellRenderer.js
// cell renderer class
function StatusCellRenderer() {
}

// init method gets the details of the cell to be rendere
StatusCellRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    this.data = params.data;
};
StatusCellRenderer.prototype.getGui = function () {
    var status = document.createElement('span');
    status.setAttribute("class", "label-" + this.data.strStatusDescValue);
    status.innerHTML = this.data.strStatusDescValue;
    this.span.appendChild(status);
    return this.span;
};
svmdt.addCellRenderer('LND', 'StatusCellRenderer');

//10. getBackgroundcolor.js
function getBackgroundcolor(params)
{
    this.data = params.data;
    var d = JSON.stringify(data);
    var rk = this.data.rk;
    var currentRowData = "";
    var strbackgroundcolor = this.data.backgroundcolor;
    try {
        if (strbackgroundcolor !== null) {
            currentRowData = "status-center-align" + ' ' + "label-" + this.data.backgroundcolor;
        }
        return currentRowData;
    } catch (e) {
        console.log("//==//==|Error while getting color|==>" + e);
    }

}

//11. getcellcolor.js
function getcellcolor(params)
{
    this.data = params.data;
    var d = JSON.stringify(data);
    var rk = this.data.rk;
    var currentRowData = "";
    var strStatusDescription = this.data.strStatusDescValue;

    try {
        if (strStatusDescription !== null) {
            currentRowData = "status-center-align" + ' ' + "label-" + this.data.strStatusDescValue;
        }
        return currentRowData;
    } catch (e) {
        console.log("//==//==|Error while getting color|==>" + e);
    }

}
