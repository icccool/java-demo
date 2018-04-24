package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class adCoupon implements Serializable {
    private Long id;

    private Long businessId;

    private Date beginDate;

    private Date endDate;

    private String name;

    private String productSn;

    private Integer quantity;

    private String isOpen;

    private String productId;

    private String productName;

    private String businessName;

    private String activityName;

    private String isCreat;

    private String createBy;

    private String delFlag;

    private String remarks;

    private Date updateDate;

    private String updateBy;

    private Date createDate;

    private String couponType;

    private String categoryType;

    private Integer distributionQuantity;

    private Integer remindQuantity;

    private Integer productSecondCategory;

    private String firstShow;

    private Integer productFirstCategory;

    private String receiveType;

    private BigDecimal couponValue;

    private String couponUnit;

    private String type;

    private String wechatListImage;

    private String wechatDetailImage;

    private String pcDetailImage;

    private String description;

    private String kind;

    private Integer tagId;

    private Integer couponCategory;

    private String businessOnlineUrl;

    private String businessAppUrl;

    private String receiveChannel;

    private String appDownload;

    private String businessActivity;

    private String businessActivityUrl;

    private String couponUserDetail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getIsCreat() {
        return isCreat;
    }

    public void setIsCreat(String isCreat) {
        this.isCreat = isCreat == null ? null : isCreat.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType == null ? null : categoryType.trim();
    }

    public Integer getDistributionQuantity() {
        return distributionQuantity;
    }

    public void setDistributionQuantity(Integer distributionQuantity) {
        this.distributionQuantity = distributionQuantity;
    }

    public Integer getRemindQuantity() {
        return remindQuantity;
    }

    public void setRemindQuantity(Integer remindQuantity) {
        this.remindQuantity = remindQuantity;
    }

    public Integer getProductSecondCategory() {
        return productSecondCategory;
    }

    public void setProductSecondCategory(Integer productSecondCategory) {
        this.productSecondCategory = productSecondCategory;
    }

    public String getFirstShow() {
        return firstShow;
    }

    public void setFirstShow(String firstShow) {
        this.firstShow = firstShow == null ? null : firstShow.trim();
    }

    public Integer getProductFirstCategory() {
        return productFirstCategory;
    }

    public void setProductFirstCategory(Integer productFirstCategory) {
        this.productFirstCategory = productFirstCategory;
    }

    public String getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType == null ? null : receiveType.trim();
    }

    public BigDecimal getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(BigDecimal couponValue) {
        this.couponValue = couponValue;
    }

    public String getCouponUnit() {
        return couponUnit;
    }

    public void setCouponUnit(String couponUnit) {
        this.couponUnit = couponUnit == null ? null : couponUnit.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getWechatListImage() {
        return wechatListImage;
    }

    public void setWechatListImage(String wechatListImage) {
        this.wechatListImage = wechatListImage == null ? null : wechatListImage.trim();
    }

    public String getWechatDetailImage() {
        return wechatDetailImage;
    }

    public void setWechatDetailImage(String wechatDetailImage) {
        this.wechatDetailImage = wechatDetailImage == null ? null : wechatDetailImage.trim();
    }

    public String getPcDetailImage() {
        return pcDetailImage;
    }

    public void setPcDetailImage(String pcDetailImage) {
        this.pcDetailImage = pcDetailImage == null ? null : pcDetailImage.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCouponCategory() {
        return couponCategory;
    }

    public void setCouponCategory(Integer couponCategory) {
        this.couponCategory = couponCategory;
    }

    public String getBusinessOnlineUrl() {
        return businessOnlineUrl;
    }

    public void setBusinessOnlineUrl(String businessOnlineUrl) {
        this.businessOnlineUrl = businessOnlineUrl == null ? null : businessOnlineUrl.trim();
    }

    public String getBusinessAppUrl() {
        return businessAppUrl;
    }

    public void setBusinessAppUrl(String businessAppUrl) {
        this.businessAppUrl = businessAppUrl == null ? null : businessAppUrl.trim();
    }

    public String getReceiveChannel() {
        return receiveChannel;
    }

    public void setReceiveChannel(String receiveChannel) {
        this.receiveChannel = receiveChannel == null ? null : receiveChannel.trim();
    }

    public String getAppDownload() {
        return appDownload;
    }

    public void setAppDownload(String appDownload) {
        this.appDownload = appDownload == null ? null : appDownload.trim();
    }

    public String getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(String businessActivity) {
        this.businessActivity = businessActivity == null ? null : businessActivity.trim();
    }

    public String getBusinessActivityUrl() {
        return businessActivityUrl;
    }

    public void setBusinessActivityUrl(String businessActivityUrl) {
        this.businessActivityUrl = businessActivityUrl == null ? null : businessActivityUrl.trim();
    }

    public String getCouponUserDetail() {
        return couponUserDetail;
    }

    public void setCouponUserDetail(String couponUserDetail) {
        this.couponUserDetail = couponUserDetail == null ? null : couponUserDetail.trim();
    }
}