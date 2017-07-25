package com.wa.vo;

import com.wa.pojo.DataMap;

import java.util.List;

public class MapDataVo {

    private String consoledtitle;

    private String controltitle;

    private String wormtitle;

    private List<DataMap> concoled;
    private List<DataMap> control;
    private List<DataMap> worm;

    public MapDataVo() {
    }

    public MapDataVo(String consoledtitle, String controltitle, String wormtitle, List<DataMap> concoled, List<DataMap> control, List<DataMap> worm) {
        this.consoledtitle = consoledtitle;
        this.controltitle = controltitle;
        this.wormtitle = wormtitle;
        this.concoled = concoled;
        this.control = control;
        this.worm = worm;
    }

    public String getConsoledtitle() {
        return consoledtitle;
    }

    public void setConsoledtitle(String consoledtitle) {
        this.consoledtitle = consoledtitle;
    }

    public String getControltitle() {
        return controltitle;
    }

    public void setControltitle(String controltitle) {
        this.controltitle = controltitle;
    }

    public String getWormtitle() {
        return wormtitle;
    }

    public void setWormtitle(String wormtitle) {
        this.wormtitle = wormtitle;
    }

    public List<DataMap> getConcoled() {
        return concoled;
    }

    public void setConcoled(List<DataMap> concoled) {
        this.concoled = concoled;
    }

    public List<DataMap> getControl() {
        return control;
    }

    public void setControl(List<DataMap> control) {
        this.control = control;
    }

    public List<DataMap> getWorm() {
        return worm;
    }

    public void setWorm(List<DataMap> worm) {
        this.worm = worm;
    }
}
