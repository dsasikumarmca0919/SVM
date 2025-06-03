/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// cell renderer class

function LandingCellRendererfortable2() {
}



// init method gets the details of the cell to be rendere
LandingCellRendererfortable2.prototype.init = function (params) {
     console.log("//==//==|LandingCellRendererfortable2 **|==>");
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

        viewBtn.innerHTML = '<span class=\"ui-button-icon-left ui-icon ui-c fa-landPg-eye\" style=\"margin-top: -8px;color: #ffff;\"></span>';
        this.span.appendChild(viewBtn);
    }




    //  console.log("//==//==|span **|==>" + this.span);
    return this.span;
};



svmdt.addCellRenderer('LND', 'LandingCellRendererfortable2');



