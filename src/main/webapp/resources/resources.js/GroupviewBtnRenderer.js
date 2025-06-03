/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
       // console.log("this.colname===="+this.colname);
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
    groupviewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa-landPg-eye\" style=\"margin-left: -8px;color:#fff;\"></span>';
    this.span.appendChild(groupviewBtn);

    }
    //    console.log("//==//==|span **|==>" + this.span);
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupviewBtnRenderer');
