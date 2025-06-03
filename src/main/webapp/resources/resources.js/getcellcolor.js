/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function getcellcolor(params)
{

    this.data = params.data;
   
     var d = JSON.stringify(data);
      
    var rk = this.data.rk;
    var currentRowData = "";
    var strStatusDescription = this.data.strStatusDescValue;

    try {
        if (strStatusDescription !== null) {
            
           //   status.setAttribute("class", "label-" + this.data.strStatusDescValue);
            currentRowData = "status-center-align" + ' ' + "label-" + this.data.strStatusDescValue;
           // console.log("currentRowData" + currentRowData);
        }
        return currentRowData;
    }
    catch (e) {
        console.log("//==//==|Error while getting color|==>" + e);
    }

}



