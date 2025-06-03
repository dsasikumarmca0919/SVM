/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function getBackgroundcolor(params)
{
    console.log("//==//==|getBackgroundcolor JS CALED|==>");
    this.data = params.data;

     var d = JSON.stringify(data);
  //console.log("//==//==|vinooooo====|==>" + d);
    var rk = this.data.rk;
    var currentRowData = "";
    var strbackgroundcolor = this.data.backgroundcolor;

    try {
        if (strbackgroundcolor !== null) {

            //   status.setAttribute("class", "label-" + this.data.strStatusDescValue);
            currentRowData = "status-center-align" + ' ' + "label-" + this.data.backgroundcolor;
            // console.log("currentRowData" + currentRowData);
        }
        return currentRowData;
    }
    catch (e) {
        console.log("//==//==|Error while getting color|==>" + e);
    }

}



