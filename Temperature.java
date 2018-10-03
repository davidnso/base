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
public abstract class Temperature {
    public double temperature; 
    public double getTemp(){
         return temperature;
    }
    public void setTemp(double n){
        temperature =n;
    }
   public abstract String toString();
   public abstract boolean belowFreezing();
   public abstract boolean swimmingWeather();
   public abstract Temperature convert();
}
