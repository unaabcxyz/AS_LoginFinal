package com.dwiauliaanugerah_202102359.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CuacaListModel
{
    @SerializedName("main")
    private CuacaMainModel cuacaMainModel;
    @SerializedName("weather")
    private List<CuacaWeatherModel> cuacaWeatherModelList;
    private String dt_txt;

    public CuacaListModel(){}

    public CuacaMainModel getCuacaMainModel() {
        return cuacaMainModel;
    }

    public void setCuacaMainModel(CuacaMainModel cuacaMainModel) {
        this.cuacaMainModel = cuacaMainModel;
    }

    public List<CuacaWeatherModel> getCuacaWeatherModels() {
        return cuacaWeatherModelList;
    }

    public void setCuacaWeatherModels(List<CuacaWeatherModel> cuacaWeatherModels) {
        this.cuacaWeatherModelList = cuacaWeatherModels;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }




}
