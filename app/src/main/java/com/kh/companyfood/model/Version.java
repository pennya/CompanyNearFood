package com.kh.companyfood.model;

/**
 * Created by KIM on 2017-07-26.
 */

public class Version {
    public int versionCode;
    public String versionName;
    public String osType;

    public Version(int versionCode, String versionName, String osType) {
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.osType = osType;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}
