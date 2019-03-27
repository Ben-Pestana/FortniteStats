package com.hfad.fortnitestats;

import java.util.List;

public class FortniteResponse  {

    private String accountId;
    private int platformId;
    private String platformName;
    private String platformLongName;
    private String epicUserHandle;
    private List<Stat> lifeTimeStats;

    public FortniteResponse(String accountId, int platformId, String platformName, String platformLongName, String epicUserHandle, List<Stat> lifeTimeStats) {

        this.accountId = accountId;
        this.platformId = platformId;
        this.platformName = platformName;
        this.platformLongName = platformLongName;
        this.epicUserHandle = epicUserHandle;
        this.lifeTimeStats = lifeTimeStats;
    }

    public FortniteResponse() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformLongName() {
        return platformLongName;
    }

    public void setPlatformLongName(String platformLongName) {
        this.platformLongName = platformLongName;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

    public List<Stat> getLifeTimeStats() {
        return lifeTimeStats;
    }

    public void setLifeTimeStats(List<Stat> lifeTimeStats) {
        this.lifeTimeStats = lifeTimeStats;
    }

    @Override
    public String toString() {
        return "FortniteResponse{" +
                "accountId='" + accountId + '\'' +
                ", platformId=" + platformId +
                ", platformName='" + platformName + '\'' +
                ", platformLongName='" + platformLongName + '\'' +
                ", epicUserHandle='" + epicUserHandle + '\'' +
                ", lifeTimeStats=" + lifeTimeStats +
                '}';
    }
}
