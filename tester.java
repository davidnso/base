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
public class tester {
    public static void main(String[] args){
    Temperature Ftemp = new Fahrenheit(72.0);
    Temperature CTemp = new Celsius(54.0);
    
    System.out.println("Degrees Fahrenheit: "+Ftemp.getTemp());
    System.out.println("Temperature of 73 degrees below freezing?...."+Ftemp.belowFreezing());
    
      System.out.println("Is Temperature of 73 swimming weather?(Above 80)..."+Ftemp.swimmingWeather());
      System.out.println("72 degrees F converted is..." + Ftemp.convert());
      System.out.println();
     System.out.println("Degrees Celsius: "+ CTemp.getTemp());
    System.out.println("Temperature of 54 degrees below freezing?...."+CTemp.belowFreezing());
    
      System.out.println("Is Temperature of 54 swimming weather?(above or equal 27)..."+CTemp.swimmingWeather());
      System.out.println("54 degrees C converted is..." + CTemp.convert());
}
}
