/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

        // revokeEditBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-revoked\" style="font-size: 15px;top: 2px; position: relative;left: 0px;margin-left: -7px;color: #ffff;"></span><span class=\"ui-button-text ui-c\"></span><span class=\"ink animate\" style=\"height: 26px; width: 26px;top: -3.53125px; left: 4.02777px; pointer-events: none;\"></span>';

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
        console.log("//==//==|btnrecall **|==>" + this.btnrecall);
    } 
    //    console.log("//==//==|span **|==>" + this.span);
    return this.span;
};
svmdt.addCellRenderer('LND', 'RevokeCellRenderer');
