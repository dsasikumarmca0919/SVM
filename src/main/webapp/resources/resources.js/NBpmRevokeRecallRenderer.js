/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

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
            console.log('---lnd---values');
            console.log(finalFilterObjdataarray);
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







