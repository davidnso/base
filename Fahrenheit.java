/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature;

/**
 *
 * @author David
 */
public class Fahrenheit extends Temperature{
    double temp;
     Fahrenheit(double temp){
       this.temp= temp;
    }
     @Override
     public double getTemp(){
         return temp;
     }
     public String toString(){
         return temp+" degrees Fahrenheit";
     }
     @Override
   public boolean belowFreezing(){
       if(temp<32){
       return true;
       }else{
           return false;
       }
   }
   public boolean swimmingWeather(){
       if(temp>80){
       return true;}
       else{
           return false;
       }
   }
   public Temperature convert(){
       
       return new Celsius((temp-32)/1.8);
   }
    
    
}
