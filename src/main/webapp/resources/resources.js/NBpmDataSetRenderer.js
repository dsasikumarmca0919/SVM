/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */



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

    var userSelectBtn= document.createElement('button');
    userSelectBtn.setAttribute("type", "submit");
    userSelectBtn.setAttribute("class", "ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ");
    userSelectBtn.setAttribute("style", "width: 23px !important;height: 23px !important;padding: 1px 9px;border: 1px solid #247bc8 !important;border-radius: 20%;background-color: #247bc8 !important");
    userSelectBtn.setAttribute("onclick", "getRowData('" + JSON.stringify(this.params) + "');return false;");
    userSelectBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa fa-stack-exchange\" style=\"margin-left: -5px;color:#fff;\"></span>';
    this.span.appendChild(userSelectBtn);
    //    console.log("//==//==|span **|==>" + this.span);
    return this.span;
};
svmdt.addCellRenderer('LND', 'NBpmDataSetRenderer');

