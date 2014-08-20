/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nugo
 */
import java.util.Date;
public class PeriodsDifference {

    public static void main(String[] args) {
        Period p11 = new Period(new Date(97, 1, 21),new Date(97, 1, 26));
        Period p22 = new Period(new Date(97, 1, 14),new Date(97, 1, 16));
        long diff2 = periodsDifferenceCounter(p11,p22);
        System.out.println("date diff in DAYs : " + diff2/(24*60));
       
    }
    public static long periodsDifferenceCounter(Period per1, Period per2){
        long diff;
        long per1_Start = per1.startDate.getTime()/60000; //( period 1 's start date) - ( midnight, January 1, 1970) in minutes
        long per1_End = per1.endDate.getTime()/60000; //( period 1 's end date) - ( midnight, January 1, 1970) in minutes
       
        long per2_Start = per2.startDate.getTime()/60000; //( period 2 's start date) - ( midnight, January 1, 1970) in minutes
        long per2_End = per2.endDate.getTime()/60000; //( period 2 's end date) - ( midnight, January 1, 1970) in minutes
        
        long per1_Duration = per1_End - per1_Start;//period 1 duration in minutes
        long per2_Duration = per2_End - per2_Start;//period 2 duration in minutes
        
        if((per1_Start == per2_Start && per1_End < per2_End)|| (per1_Start == per2_Start && per1_End == per2_End) ||
           (per1_Start > per2_Start && per1_End == per2_End)|| (per1_Start > per2_Start && per1_End < per2_End)){
        
           diff = per1_Duration;
        }
        else if ((per1_Start < per2_Start && per1_End > per2_End) || (per1_Start == per2_Start && per1_End > per2_End) ||
                 (per1_Start < per2_Start && per1_End == per2_End)){
            diff = per2_Duration;
        }
        else if ((per1_End <= per2_Start || per2_End <= per1_Start)){
            diff = 0;
        }
        else if((per1_Start < per2_Start && per1_End < per2_End)){
            diff = per1_End - per2_Start;
        }
        else{
            diff = per2_End - per1_Start;
        }
        return diff;//returns overlap in minutes
    }
}
