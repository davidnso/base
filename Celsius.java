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
public class Celsius extends Temperature {
    double temp;
    Celsius(double temp){
        this.temp=temp;
    }
    @Override
     public double getTemp(){
         return temp;
     }
     public String toString(){
         return temp+" degrees Celcius";
     }
     @Override
   public boolean belowFreezing(){
       if(temp<0){
               return true;
       }else{
           return false; 
       }
   }
   @Override
   public boolean swimmingWeather(){
       if(temp>=27){
       return true;}else{
           return false;
       }
   }
   @Override
   public Temperature convert(){
       
       return new Fahrenheit((temp*1.8)+32);
   }
    
}
