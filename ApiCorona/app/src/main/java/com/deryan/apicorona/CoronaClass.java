package com.deryan.apicorona;

public class CoronaClass {
    private String country,cases,death,recovered,update;
    public CoronaClass(String country,String cases, String death, String recovered, String update) {
        this.country = country;
        this.cases = cases;
        this.death = death;
        this.recovered = recovered;
        this.update = update;
    }
    public String getCountry() {
        return country;
    }
    public String getCases() {
        return cases;
    }
    public String getDeath() {
        return death;
    }
    public String getRecovered() {
        return recovered;
    }
    public String getUpdate() {
        return update;
    }
}
