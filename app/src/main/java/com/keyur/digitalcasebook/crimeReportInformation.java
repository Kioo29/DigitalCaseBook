package com.keyur.digitalcasebook;

public class crimeReportInformation {
    String reportOf,fullName,Address,state,phoneNum,gender,age,Email,Investigator,locationOfOccurance,dateOfOccurance,timeOfOccurance,dateOfReport,timeOfReport;

    public crimeReportInformation() {

    }

    public crimeReportInformation(String reportOf, String fullName, String address, String state, String phoneNum, String gender, String age, String email, String investigator, String locationOfOccurance, String dateOfOccurance, String timeOfOccurance, String dateOfReport, String timeOfReport) {
        this.reportOf = reportOf;
        this.fullName = fullName;
        Address = address;
        this.state = state;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.age = age;
        Email = email;
        Investigator = investigator;
        this.locationOfOccurance = locationOfOccurance;
        this.dateOfOccurance = dateOfOccurance;
        this.timeOfOccurance = timeOfOccurance;
        this.dateOfReport = dateOfReport;
        this.timeOfReport = timeOfReport;
    }

    public String getReportOf() {
        return reportOf;
    }

    public void setReportOf(String reportOf) {
        this.reportOf = reportOf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInvestigator() {
        return Investigator;
    }

    public void setInvestigator(String investigator) {
        Investigator = investigator;
    }

    public String getLocationOfOccurance() {
        return locationOfOccurance;
    }

    public void setLocationOfOccurance(String locationOfOccurance) {
        this.locationOfOccurance = locationOfOccurance;
    }

    public String getDateOfOccurance() {
        return dateOfOccurance;
    }

    public void setDateOfOccurance(String dateOfOccurance) {
        this.dateOfOccurance = dateOfOccurance;
    }

    public String getTimeOfOccurance() {
        return timeOfOccurance;
    }

    public void setTimeOfOccurance(String timeOfOccurance) {
        this.timeOfOccurance = timeOfOccurance;
    }

    public String getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(String dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getTimeOfReport() {
        return timeOfReport;
    }

    public void setTimeOfReport(String timeOfReport) {
        this.timeOfReport = timeOfReport;
    }
}
