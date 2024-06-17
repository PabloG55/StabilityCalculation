package com.pg.stabilitycalculation.logic;

class ShipData {
    private String name;
    private double pesos;
    private double lcg;
    private double momv1;
    private double vcg;
    private double momv2;
    private double superficieLibre;

    public ShipData(String name, double pesos, double lcg, double momv1, double vcg, double momv2, double superficieLibre) {
        this.name = name;
        this.pesos = pesos;
        this.lcg = lcg;
        this.momv1 = momv1;
        this.vcg = vcg;
        this.momv2 = momv2;
        this.superficieLibre = superficieLibre;
    }

    public String getName() {
        return name;
    }

    public double getPesos() {
        return pesos;
    }

    public double getLcg() {
        return lcg;
    }

    public double getMomv1() {
        return momv1;
    }

    public double getVcg() {
        return vcg;
    }

    public double getMomv2() {
        return momv2;
    }

    public double getSuperficieLibre() {
        return superficieLibre;
    }
}
