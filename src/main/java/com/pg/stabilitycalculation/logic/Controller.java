/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pg.stabilitycalculation.logic;

/**
 *
 * @author pgarc
 */
public class Controller {
    private Tank peakPrtTank;
    private Tank no00CTank;
    private Tank no01CTank;
    private Tank no02CTank;
    private Tank no03CTank;
    private Tank no04CTank;
    private Tank no05CTank;
    private Tank no06Tank;
    private Tank fWMagPrt05Tank;
    private Tank fWMagPrt06Tank;
    private Tank fWMagStb05Tank;
    private Tank fWMagStb06Tank;
    private Tank fWManPrt05Tank;
    private Tank fWManPrt06Tank;
    private Tank fWManStb05Tank;
    private Tank fWManStb06Tank;
    private Tank doEmerPrtTank;
    private Tank doPrt03Tank;
    private Tank doPrt04Tank;
    private Tank doPrt07Tank;
    private Tank doStb03Tank;
    private Tank doStb04Tank;
    private Tank doStb07Tank;
    private Tank misGrayWater08Tank;
    private Tank misOilyWater07Tank;
    private Tank misSludgeStb09Tank;
    private WeightedEntity crewValue;
    private WeightedEntity luggageValue;
    private WeightedEntity paxValue;

    public double getPeakPrtTank() {
        return peakPrtTank.getTankValue();
    }

    public Tank getNo00CTank() {
        return no00CTank;
    }

    public Tank getNo01CTank() {
        return no01CTank;
    }

    public Tank getNo02CTank() {
        return no02CTank;
    }

    public Tank getNo03CTank() {
        return no03CTank;
    }

    public Tank getNo04CTank() {
        return no04CTank;
    }

    public Tank getNo05CTank() {
        return no05CTank;
    }

    public Tank getNo06Tank() {
        return no06Tank;
    }

    public Tank getFWMagPrt05Tank() {
        return fWMagPrt05Tank;
    }

    public Tank getFWMagPrt06Tank() {
        return fWMagPrt06Tank;
    }

    public Tank getFWMagStb05Tank() {
        return fWMagStb05Tank;
    }

    public Tank getFWMagStb06Tank() {
        return fWMagStb06Tank;
    }

    public Tank getFWManPrt05Tank() {
        return fWManPrt05Tank;
    }

    public Tank getFWManPrt06Tank() {
        return fWManPrt06Tank;
    }

    public Tank getFWManStb05Tank() {
        return fWManStb05Tank;
    }

    public Tank getFWManStb06Tank() {
        return fWManStb06Tank;
    }

    public Tank getDoEmerPrtTank() {
        return doEmerPrtTank;
    }

    public Tank getDoPrt03Tank() {
        return doPrt03Tank;
    }

    public Tank getDoPrt04Tank() {
        return doPrt04Tank;
    }

    public Tank getDoPrt07Tank() {
        return doPrt07Tank;
    }

    public Tank getDoStb03Tank() {
        return doStb03Tank;
    }

    public Tank getDoStb04Tank() {
        return doStb04Tank;
    }

    public Tank getDoStb07Tank() {
        return doStb07Tank;
    }

    public Tank getMisGrayWater08Tank(){
        return misGrayWater08Tank;
    }
    
    public Tank getMisOilyWater07Tank(){
        return misOilyWater07Tank;
    }

    public Tank getSludgeStb09Tank(){
        return misSludgeStb09Tank;
    }

    public WeightedEntity getCrewValue(){
        return crewValue;
    }

    public WeightedEntity getPaxValue(){
        return paxValue;
    }

    public WeightedEntity getLuggageValue(){
        return luggageValue;
    }

    public void nextBallast(double peakPrt, double no00c, double no01c, double no02c, 
                double no03c, double no04c, double no05c, double no06c) {
        peakPrtTank = new Tank(peakPrt);
        no00CTank = new Tank(no00c);
        no01CTank = new Tank(no01c);
        no02CTank = new Tank(no02c);
        no03CTank = new Tank(no03c);
        no04CTank = new Tank(no04c);
        no05CTank = new Tank(no05c);
        no06Tank = new Tank(no06c);
    }

    public void nextFW(double fWMagPrt05, double fWMagPrt06, double fWMagStb05, double fWMagStb06, double fWManPrt05,
                double fWManPrt06, double fWManStb05, double fWManStb06) {
    fWMagPrt05Tank = new Tank(fWMagPrt05);
    fWMagPrt06Tank = new Tank(fWMagPrt06);
    fWMagStb05Tank = new Tank(fWMagStb05);
    fWMagStb06Tank = new Tank(fWMagStb06);
    fWManPrt05Tank = new Tank(fWManPrt05);
    fWManPrt06Tank = new Tank(fWManPrt06);
    fWManStb05Tank = new Tank(fWManStb05);
    fWManStb06Tank = new Tank(fWManStb06);                    
    }

    public void nextDO(double doEmerPrt, double doPrt03, double doPrt04, double doPrt07, double doStb03, double doStb04,
            double doStb07) {
        doEmerPrtTank = new Tank(doEmerPrt);
        doPrt03Tank = new Tank(doPrt03);
        doPrt04Tank = new Tank(doPrt04);
        doPrt07Tank = new Tank(doPrt07);
        doStb03Tank = new Tank(doStb03);
        doStb04Tank = new Tank(doStb04);
        doStb07Tank = new Tank(doStb07);        
    }

    public void nextMisc(double misGrayWater08, double misOilyWater07, double misSludgeStb09) {
        misGrayWater08Tank = new Tank(misGrayWater08);
        misOilyWater07Tank = new Tank(misOilyWater07);
        misSludgeStb09Tank = new Tank(misSludgeStb09);
    }

    public void nextWeightedEntity(double crewNo, double luggageNo, double paxNo) {
        crewValue = new WeightedEntity(crewNo);
        luggageValue = new WeightedEntity(luggageNo);
        paxValue = new WeightedEntity(paxNo);
    }
    
}
