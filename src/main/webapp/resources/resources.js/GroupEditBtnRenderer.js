/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    //    console.log("//==//==|span **|==>" + this.span);
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupEditBtnRenderer');
