/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// cell renderer class
function StatusCellRenderer() {
}

// init method gets the details of the cell to be rendere
StatusCellRenderer.prototype.init = function (params) {
   // console.log("StatusCellRenderer called");
    this.span = document.createElement('span');
    this.data = params.data;
   

};
StatusCellRenderer.prototype.getGui = function () {
  // console.log("StatusCellRenderer getGui called");
        var status = document.createElement('span');
        status.setAttribute("class", "label-" + this.data.strStatusDescValue);
        status.innerHTML = this.data.strStatusDescValue;
        this.span.appendChild(status);
      //  console.log("this.span=333==" + this.span);

    return this.span;
};
svmdt.addCellRenderer('LND', 'StatusCellRenderer');
