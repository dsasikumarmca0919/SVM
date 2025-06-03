/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function customColurSettingJs() {

}
var customColumnValue;
var customColumnId;
customColurSettingJs.prototype.init = function (params) {
    this.container = document.createElement('div');
    if (params.data) {
        var data = params.data;
        this.params = params.data;
        this.rk = data.rk;
        this.customColumnId = params.column.colId;
        this.customColumnValue = data[this.customColumnId];
    }
};

customColurSettingJs.prototype.getGui = function () {
    
        if (typeof this.customColumnValue === 'string') {
            var labels = this.customColumnValue.split('~'); 
            labels.forEach(label => {
                var labelElement = document.createElement('span');
                labelElement.textContent = label.trim(); 
                labelElement.classList.add('LNDcolurLabel'); 
                this.container.appendChild(labelElement);
            });
        }
        
    return this.container;
};
svmdt.addCellRenderer('LND', 'customColurSettingJs');
