package com.wa.pojo;

public class Worm {
    private String originalIp;

    private String dnsQueryIp;

    private String refData1;

    private String refData2;

    private String refData3;

    private String refData4;

    public Worm(String originalIp, String dnsQueryIp, String refData1, String refData2, String refData3, String refData4) {
        this.originalIp = originalIp;
        this.dnsQueryIp = dnsQueryIp;
        this.refData1 = refData1;
        this.refData2 = refData2;
        this.refData3 = refData3;
        this.refData4 = refData4;
    }

    public Worm() {
        super();
    }

    public String getOriginalIp() {
        return originalIp;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp == null ? null : originalIp.trim();
    }

    public String getDnsQueryIp() {
        return dnsQueryIp;
    }

    public void setDnsQueryIp(String dnsQueryIp) {
        this.dnsQueryIp = dnsQueryIp == null ? null : dnsQueryIp.trim();
    }

    public String getRefData1() {
        return refData1;
    }

    public void setRefData1(String refData1) {
        this.refData1 = refData1 == null ? null : refData1.trim();
    }

    public String getRefData2() {
        return refData2;
    }

    public void setRefData2(String refData2) {
        this.refData2 = refData2 == null ? null : refData2.trim();
    }

    public String getRefData3() {
        return refData3;
    }

    public void setRefData3(String refData3) {
        this.refData3 = refData3 == null ? null : refData3.trim();
    }

    public String getRefData4() {
        return refData4;
    }

    public void setRefData4(String refData4) {
        this.refData4 = refData4 == null ? null : refData4.trim();
    }
}