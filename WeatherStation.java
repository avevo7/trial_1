package Final_5;

/*
title: WEEK 5
*/

public class WeatherStation extends GreenStation  // used extends to create Weatherstation class as a subclass of GreenStation class
{

     private String StationDesignation;  //Identifies the station
     private double Temperature; //...and, of course, how hot is it?

     public WeatherStation()  
     {
     	StationDesignation = "";
     	Temperature = 0.0;
     }

     public WeatherStation(String LocationID)
     {
     	StationDesignation = LocationID;
     	Temperature = 0.0;
     }        

     public WeatherStation(String LocationID, double InitialPollen, double InitialAirQuality)  // constructor to add pollen count and air quality info
     {
     	super(InitialPollen, InitialAirQuality);		// using super keyword to initialize a weatherstation's pollen count and air quality
     	StationDesignation = LocationID;
     	Temperature = 0.0;
     } 
     
     //Define some mutators...These member functions allow us to
     //   change values in the object...

    
     public void SetDesignation(String ID)      { StationDesignation = ID; }
     public void SetTemperature(double Degree)  {Temperature = Degree; }

      //Define some accessors...These member functions allow us to get
     //  at the internal values

     public String GetDesignation()    { return StationDesignation; }
     public double GetTemperature()    { return Temperature; }

}
