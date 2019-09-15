package com.jd.mvvmexample.repository.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSlist {
    @SerializedName("DistrictCd")
    @Expose
    private String districtCd;
    @SerializedName("psid")
    @Expose
    private String psid;
    @SerializedName("psname")
    @Expose
    private String psname;

    public String getDistrictCd() {
        return districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }

    public String getPsid() {
        return psid;
    }

    public void setPsid(String psid) {
        this.psid = psid;
    }

    public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }}
