package com.jd.mvvmexample.repository.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ParentResponse {

    @SerializedName("PSlist")
    @Expose
    private List<PSlist> pSlist = null;

    public List<PSlist> getPSlist() {
        return pSlist;
    }

    public void setPSlist(List<PSlist> pSlist) {
        this.pSlist = pSlist;
    }
}