package entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String prescriptionCode;

    private Integer cgCode;

    private Integer cpCode;

    private Integer busiCode;

    private String posCode;

    private String memberCardNumber;

    private Byte prescriptionType;

    private Byte prescriptionSource;

    private Byte prescriptionCheckLevel;

    private Date prescriptionTime;

    private Long pharmacistId;

    private Byte pharmacistCheckStatus;

    private String pharmacistAdvice;

    private Date pharmacistTime;

    private Long physicianId;

    private Byte physicianCheckStatus;

    private String physicianAdvice;

    private Date physicianTime;

    private Byte checkStatus;

    private String checkDescription;

    private Double netCost;

    private Long cashierId;

    private Byte syncStatus;

    private Byte deleteStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode == null ? null : prescriptionCode.trim();
    }

    public Integer getCgCode() {
        return cgCode;
    }

    public void setCgCode(Integer cgCode) {
        this.cgCode = cgCode;
    }

    public Integer getCpCode() {
        return cpCode;
    }

    public void setCpCode(Integer cpCode) {
        this.cpCode = cpCode;
    }

    public Integer getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(Integer busiCode) {
        this.busiCode = busiCode;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode == null ? null : posCode.trim();
    }

    public String getMemberCardNumber() {
        return memberCardNumber;
    }

    public void setMemberCardNumber(String memberCardNumber) {
        this.memberCardNumber = memberCardNumber == null ? null : memberCardNumber.trim();
    }

    public Byte getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(Byte prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public Byte getPrescriptionSource() {
        return prescriptionSource;
    }

    public void setPrescriptionSource(Byte prescriptionSource) {
        this.prescriptionSource = prescriptionSource;
    }

    public Byte getPrescriptionCheckLevel() {
        return prescriptionCheckLevel;
    }

    public void setPrescriptionCheckLevel(Byte prescriptionCheckLevel) {
        this.prescriptionCheckLevel = prescriptionCheckLevel;
    }

    public Date getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(Date prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public Long getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(Long pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public Byte getPharmacistCheckStatus() {
        return pharmacistCheckStatus;
    }

    public void setPharmacistCheckStatus(Byte pharmacistCheckStatus) {
        this.pharmacistCheckStatus = pharmacistCheckStatus;
    }

    public String getPharmacistAdvice() {
        return pharmacistAdvice;
    }

    public void setPharmacistAdvice(String pharmacistAdvice) {
        this.pharmacistAdvice = pharmacistAdvice == null ? null : pharmacistAdvice.trim();
    }

    public Date getPharmacistTime() {
        return pharmacistTime;
    }

    public void setPharmacistTime(Date pharmacistTime) {
        this.pharmacistTime = pharmacistTime;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public Byte getPhysicianCheckStatus() {
        return physicianCheckStatus;
    }

    public void setPhysicianCheckStatus(Byte physicianCheckStatus) {
        this.physicianCheckStatus = physicianCheckStatus;
    }

    public String getPhysicianAdvice() {
        return physicianAdvice;
    }

    public void setPhysicianAdvice(String physicianAdvice) {
        this.physicianAdvice = physicianAdvice == null ? null : physicianAdvice.trim();
    }

    public Date getPhysicianTime() {
        return physicianTime;
    }

    public void setPhysicianTime(Date physicianTime) {
        this.physicianTime = physicianTime;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription == null ? null : checkDescription.trim();
    }

    public Double getNetCost() {
        return netCost;
    }

    public void setNetCost(Double netCost) {
        this.netCost = netCost;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Byte getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Byte syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}