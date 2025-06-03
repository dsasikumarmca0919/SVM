/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// cell renderer class
function GroupNewBtnRenderer() {
}

// init method gets the details of the cell to be rendere
GroupNewBtnRenderer.prototype.init = function (params) {
    this.span = document.createElement('span');
    //  console.log("groupNewBtnRenderer==="+params.data);
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
    //    console.log("//==//==|span **|==>" + this.span);
    return this.span;
};
svmdt.addCellRenderer('LND', 'GroupNewBtnRenderer');
