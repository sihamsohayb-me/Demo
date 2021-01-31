package com.example.demo;

import lombok.Data;

@Data
public class Vessel {
    private Integer id;
    private String registrationCountry;
    private String cfr;
    private Integer uvi;
    private String registrationNumber;
    private String externalMarketing;
    private String name;
    private String registrationPlace;
    private String ircs;
    private Boolean ircsIndicator;
    private Boolean licenceIndicator;
    private Boolean vmsIndicator;
    private String ers;
    private String ais;
    private String mmsi;
    private String type;
    private String mainGear;
    private String subsidiaryGear;
    private Double loa;
    private Double lbp;
    private Double tonageGt;
    private Double otherTonage;
    private Double gts;
    private Double grt;
    private Double powerMainEngine;
    private Double powerAuxiliaryEngine;
    private String hullMaterial;
    private String entryServiceDate;
    private String segment;
    private String exportCountry;
    private String exportType;
    private String publicAid;
    private String constructionDate;
    private Integer iccatNumber;
    private Boolean neafcIndicator;
    private Integer neafcNumber;
    private Boolean nafoIndicator;
    private Integer nafoNumber;
    private Double speed;
    private Double  breadth;
    private Double draught;
}
