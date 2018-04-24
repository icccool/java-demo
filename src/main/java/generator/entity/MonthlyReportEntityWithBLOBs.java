package entity;

import java.io.Serializable;

public class MonthlyReportEntityWithBLOBs extends MonthlyReportEntity implements Serializable {
    private String wechatIntroduction;

    private String pcIntroduction;

    private String wechatConvertMethod;

    private String pcConvertMethod;

    private String wechatAttention;

    private String pcAttention;

    private static final long serialVersionUID = 1L;

    public String getWechatIntroduction() {
        return wechatIntroduction;
    }

    public void setWechatIntroduction(String wechatIntroduction) {
        this.wechatIntroduction = wechatIntroduction == null ? null : wechatIntroduction.trim();
    }

    public String getPcIntroduction() {
        return pcIntroduction;
    }

    public void setPcIntroduction(String pcIntroduction) {
        this.pcIntroduction = pcIntroduction == null ? null : pcIntroduction.trim();
    }

    public String getWechatConvertMethod() {
        return wechatConvertMethod;
    }

    public void setWechatConvertMethod(String wechatConvertMethod) {
        this.wechatConvertMethod = wechatConvertMethod == null ? null : wechatConvertMethod.trim();
    }

    public String getPcConvertMethod() {
        return pcConvertMethod;
    }

    public void setPcConvertMethod(String pcConvertMethod) {
        this.pcConvertMethod = pcConvertMethod == null ? null : pcConvertMethod.trim();
    }

    public String getWechatAttention() {
        return wechatAttention;
    }

    public void setWechatAttention(String wechatAttention) {
        this.wechatAttention = wechatAttention == null ? null : wechatAttention.trim();
    }

    public String getPcAttention() {
        return pcAttention;
    }

    public void setPcAttention(String pcAttention) {
        this.pcAttention = pcAttention == null ? null : pcAttention.trim();
    }
}