package com.svm.lrp.nfr.lnd.model;

import java.io.Serializable;
import com.svm.lrp.nfr.jsf.utils.IUIModel;

public class LandingPageUIStateModel
        implements Serializable, IUIModel {

    boolean columngrouprender = true;
    boolean facetrender = false;
    boolean commandlinkrender = false;
    boolean editcommandlinkrender = true;
    boolean viewcommandlinkrender = true;
    boolean defaultactionrender;
    boolean defaultcolumrender;
    boolean filtersessionrender = false;
    boolean radiofieldesetrender;

//----------------for filter-----------
    boolean radiobtnrender = false;
    boolean inputfieldrender = false;
    boolean chkboxrender = false;
    boolean closebtnrender = false;
    boolean refreshbtnrender = false;
    boolean subdomaincodedisabledDis = false;
//------------------
    boolean doubleclickdisbled;
    boolean reorderlistrender;
    boolean isDateConversionapplicable = false;
    boolean defaultsearch = false;
    boolean datewisesearch = false;
    boolean enablestatusbar = false;
    boolean enableIncludeOpenItems = false;
boolean enableunhandledswitch = false;

    public boolean isEnableunhandledswitch() {
        return enableunhandledswitch;
    }

    public void setEnableunhandledswitch(boolean enableunhandledswitch) {
        this.enableunhandledswitch = enableunhandledswitch;
    }


    public boolean isEnableIncludeOpenItems() {
        return enableIncludeOpenItems;
    }

    public void setEnableIncludeOpenItems(boolean enableIncludeOpenItems) {
        this.enableIncludeOpenItems = enableIncludeOpenItems;
    }

    public boolean isEnablestatusbar() {
        return enablestatusbar;
    }

    public void setEnablestatusbar(boolean enablestatusbar) {
        this.enablestatusbar = enablestatusbar;
    }

    public boolean isDatewisesearch() {
        return datewisesearch;
    }

    public void setDatewisesearch(boolean datewisesearch) {
        this.datewisesearch = datewisesearch;
    }

    public boolean isDefaultsearch() {
        return defaultsearch;
    }

    public void setDefaultsearch(boolean defaultsearch) {
        this.defaultsearch = defaultsearch;
    }

    public boolean isIsDateConversionapplicable() {
        return isDateConversionapplicable;
    }

    public void setIsDateConversionapplicable(boolean isDateConversionapplicable) {
        this.isDateConversionapplicable = isDateConversionapplicable;
    }

    public boolean isColumngrouprender() {
        return columngrouprender;
    }

    public void setColumngrouprender(boolean columngrouprender) {
        this.columngrouprender = columngrouprender;
    }

    public boolean isFacetrender() {
        return facetrender;
    }

    public void setFacetrender(boolean facetrender) {
        this.facetrender = facetrender;
    }

    public boolean isCommandlinkrender() {
        return commandlinkrender;
    }

    public void setCommandlinkrender(boolean commandlinkrender) {
        this.commandlinkrender = commandlinkrender;
    }

    public boolean isEditcommandlinkrender() {
        return editcommandlinkrender;
    }

    public void setEditcommandlinkrender(boolean editcommandlinkrender) {
        this.editcommandlinkrender = editcommandlinkrender;
    }

    public boolean isViewcommandlinkrender() {
        return viewcommandlinkrender;
    }

    public void setViewcommandlinkrender(boolean viewcommandlinkrender) {
        this.viewcommandlinkrender = viewcommandlinkrender;
    }

    public boolean isDefaultactionrender() {
        return defaultactionrender;
    }

    public void setDefaultactionrender(boolean defaultactionrender) {
        this.defaultactionrender = defaultactionrender;
    }

    public boolean isDefaultcolumrender() {
        return defaultcolumrender;
    }

    public void setDefaultcolumrender(boolean defaultcolumrender) {
        this.defaultcolumrender = defaultcolumrender;
    }

    public boolean isFiltersessionrender() {
        return filtersessionrender;
    }

    public void setFiltersessionrender(boolean filtersessionrender) {
        this.filtersessionrender = filtersessionrender;
    }

    public boolean isRadiobtnrender() {
        return radiobtnrender;
    }

    public void setRadiobtnrender(boolean radiobtnrender) {
        this.radiobtnrender = radiobtnrender;
    }

    public boolean isInputfieldrender() {
        return inputfieldrender;
    }

    public void setInputfieldrender(boolean inputfieldrender) {
        this.inputfieldrender = inputfieldrender;
    }

    public boolean isChkboxrender() {
        return chkboxrender;
    }

    public void setChkboxrender(boolean chkboxrender) {
        this.chkboxrender = chkboxrender;
    }

    public boolean isClosebtnrender() {
        return closebtnrender;
    }

    public void setClosebtnrender(boolean closebtnrender) {
        this.closebtnrender = closebtnrender;
    }

    public boolean isRefreshbtnrender() {
        return refreshbtnrender;
    }

    public void setRefreshbtnrender(boolean refreshbtnrender) {
        this.refreshbtnrender = refreshbtnrender;
    }

    public boolean isSubdomaincodedisabledDis() {
        return subdomaincodedisabledDis;
    }

    public void setSubdomaincodedisabledDis(boolean subdomaincodedisabledDis) {
        this.subdomaincodedisabledDis = subdomaincodedisabledDis;
    }

    public boolean isDoubleclickdisbled() {
        return doubleclickdisbled;
    }

    public void setDoubleclickdisbled(boolean doubleclickdisbled) {
        this.doubleclickdisbled = doubleclickdisbled;
    }

    public boolean isRadiofieldesetrender() {
        return radiofieldesetrender;
    }

    public void setRadiofieldesetrender(boolean radiofieldesetrender) {
        this.radiofieldesetrender = radiofieldesetrender;
    }

    public boolean isReorderlistrender() {
        return reorderlistrender;
    }

    public void setReorderlistrender(boolean reorderlistrender) {
        this.reorderlistrender = reorderlistrender;
    }

    private boolean actionColumnRender = true;

    public boolean isActionColumnRender() {
        return actionColumnRender;
    }

    public void setActionColumnRender(boolean actionColumnRender) {
        this.actionColumnRender = actionColumnRender;
    }

}
