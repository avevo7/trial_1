package Final_5;


/*
title: WEEK 5
*/

import java.util.*;				// This file contains the definition of Scanner.
import java.io.*;				// file contains IO exception handling

public class WeatherStationList 
{																		// Field variables declared as private
	private static Scanner Input = new Scanner(System.in);
	private static WeatherStation[] Stations = new WeatherStation[8];	// Array of WeatherStation objects
	private static int i= 0;
	private String FileName="RedwoodBayWeather"; 		// Filename variable used to hold the name of the current file
	private static double Celsius=0, Average=0;							// Celsius variable used to hold converted Fahrenheit to Celsius value
																		// Average variable used to hold temperature average
	public WeatherStationList()	// WeatherStationList method that calls Setup method
	{
		Setup();				// Calls Setup method to initialize array of WeatherStation objects
	}
	
	private void Setup()		// Setup method initializes WeatherStation objects
	{							// Putting station names into Stations array
		Stations[0]= new WeatherStation("Tciitcgaitc");		
		Stations[1]= new WeatherStation("Redwood Haven");
		Stations[2]= new WeatherStation("Barrier Mts.");
		Stations[3]= new WeatherStation("Nina's Folly");
		Stations[4]= new WeatherStation("Sooly's Hill");
		Stations[5]= new WeatherStation("Twin Cones Park");
		Stations[6]= new WeatherStation("Scramble Lake");
		Stations[7]= new WeatherStation("Coastal Range");
	}
	
	public void Post()									// Method to post temperature, pollen count and air quality data to weatherstations
	{
		double Temp = 0, PollenCount=0, AQScore=0;			// variable to hold user inputed temperature, pollen count and air quality
		
		System.out.println("Enter the temperature for each Weather Station below.");
		System.out.println("-------------------------------------------------------------------------");		
		for (i=0; i<8; i++)  							// For loop to ask and input user station temp, pollen count and air quality data into Stations array
		{	System.out.println("Weather Station: " + Stations[i].GetDesignation());
			System.out.print("Temperature:" + "\t");
			Temp = Input.nextDouble();
			System.out.print("Pollen Count:" + "\t");
			PollenCount = Input.nextDouble();
			System.out.print("Air Quality:" + "\t");
			AQScore = Input.nextDouble();
			
			Stations[i].SetTemperature(Temp);			// Mutator to enter in a station temperature
			Stations[i].SetPollenCount(PollenCount);	// Mutator to enter in a station pollen count
			Stations[i].SetAQScore(AQScore);			// Mutator to enter in a station air quality
		}
		System.out.println("\n\n");
	}
	
	public void HighLow()										// Method to display and find the High/Low temperature
	{
		double High = Stations[0].GetTemperature();				// Declaring variables to hold high/low temperature equal to Station 0.
		double Low = Stations[0].GetTemperature();
		int HighID = 0, LowID =0;								// Declaring variable to hold Station ID of high/low temperature
		i=-1;
		do 														// Do While loop that compares Station temps to current High/Low temperature
		{	i++;
			if (Stations[i].GetTemperature() > High)  			// Compares Station i temperature to current high temperature
			{	High= Stations[i].GetTemperature();				// If Station i is higher....then Station i becomes the high temperature
				HighID= i;						
			}			
			if (Stations[i].GetTemperature() <Low)  			// Compares Station i temperature to current low temperature
			{	Low= Stations[i].GetTemperature();				// If Station i is lower....then Station i becomes the low temperature
				LowID=i;
			}
		}
		while (i<7);		
				
		System.out.println("========================Temperatue Data Report===========================" + "\n"); //Display formatting
		System.out.println("\t\t\t\t" + "Fahrenheit" + "\t" + "Celsius"); 							
		System.out.println("-------------------------------------------------------------------------"); 	
		Celsius = ComputeCelsius(Low);							// Call to ComputeCelsius method to convert low fahrenheit temp to celsius
		System.out.println("Lowest Temperature =" + "\t\t" + String.format("%3.2f", Stations[LowID].GetTemperature()) + "\t\t" + String.format("%3.2f", Celsius));
		System.out.println("-------------------------------------------------------------------------"); 	
		Celsius = ComputeCelsius(High);							// Call to ComputeCelsius method to convert high fahrenheit temp to celsius
		System.out.println("Highest Temperature =" + "\t\t" + String.format("%3.2f", Stations[HighID].GetTemperature())  + "\t\t" + String.format("%3.2f", Celsius));
		System.out.println("-------------------------------------------------------------------------" + "\n\n"); 
	}
	
	public void Daily()												// Method to display mean temperature and raw data
	{
		System.out.println("========================Temperatue Data Report===========================" + "\n\n"); //Display formatting
		System.out.println("\t\t\t\t" + "Fahrenheit" + "\t" + "Celsius");
		ComputeAverage();											// Call to ComputeAverage method to compute the average temperature then displaying it
		Celsius= ComputeCelsius(Average);							// Call to ComputeCelsius method to convert average fahrenheit temp to celsius then displaying it
		System.out.println("-------------------------------------------------------------------------"); 	
		System.out.println("Mean Temperature =" + "\t\t" + String.format("%3.2f", Average) + "\t\t" + String.format("%3.2f", Celsius));
		System.out.println("-------------------------------------------------------------------------" + "\n"); 	
		System.out.println("Raw Data:"+"\n"); 								
		
		for (i=0; i<8; i++)											// Display formatting using for loop
		{	
			Celsius= ComputeCelsius(Stations[i].GetTemperature());	// Converting Fahrenheit station temp to celsius then displaying it
			System.out.println(Stations[i].GetDesignation() + "\t\t\t"+ String.format("%3.1f", Stations[i].GetTemperature()) + "\t\t" + String.format("%3.2f",Celsius));
		}
		System.out.println("-------------------------------------------------------------------------" + "\n\n");		
	}

	public static double ComputeCelsius(double FTemp)  				// Method to convert Fahrenheit temperatures to Celsius temperatures
	{
		Celsius= (5*(FTemp-32))/9;           						// Converting Fahrenheit data to Celsius
		return Celsius;
	}
	
	public static void ComputeAverage() 							// Method to compute average fahrenheit and celsius station temperatures
	{
		double Total=0;
	    
	    for (i=0; i<8; i++)											// For loop to get data from user, convert to celsius and sum up data
	    	Total += Stations[i].GetTemperature();					// Summing up Fahrenheit data
	    
		if (i>0)													// Using conditional to check for data
			Average=Total/i;                      					// Calculating Fahrenheit Mean
		else 
			System.out.println("No numbers were entered");
	}
	
	public void DisplayPollenCount()
	{
		System.out.println("========================Daily Pollen Count==========================="); //Display formatting
		
		for (i=0; i<8; i++)											// Display formatting using for loop
		{	
			System.out.println(Stations[i].GetDesignation() + "\t\t\t"+ String.format("%3.1f", Stations[i].GetPollenCount()));
		}
		System.out.println("======================================================================");	
	}
	
	public void DisplayAQScore()
	{
		System.out.println("========================Daily Air Quality Index======================="); //Display formatting
		
		for (i=0; i<8; i++)											// Display formatting using for loop
		{	
			System.out.println(Stations[i].GetDesignation() + "\t\t\t"+ String.format("%3.1f", Stations[i].GetAQScore()));
		}
		System.out.println("======================================================================");	
	}
	
	public String GetFileName()           { return FileName; }  	// accessor to get the current FileName
	
	public void SetFileName(String FName) { FileName = FName; } 	// mutator to set a new file name
	
	public void SaveWeatherStationInfo() throws IOException  //In subsequent courses, we'll talk about exception...this is require to use these
	{                                       //file manipulation routines...

		PrintWriter OutFile;      
	    OutFile = new PrintWriter(new FileWriter(FileName));  //Open a connection to a file...notice that the FileWriter
	                                                          //object is anonymous but specifies where the values will be sent...
	     
	    for(i = 0 ; i < 8 ; i++) {
	    	OutFile.println(Stations[i].GetDesignation());  //Copy the values from the list...
	    	OutFile.println(Stations[i].GetTemperature());
	    	OutFile.println(Stations[i].GetPollenCount());
	    	OutFile.println(Stations[i].GetAQScore());
	    }
	    
	    OutFile.close();  //Always shut down the list when you're finished...
	}
	
	public void ReadWeatherStationInfo() throws IOException
	{
		 String InBuffer = "";
         
		 BufferedReader InFile;  //This is a file type that allows read access...it processes the values that come from the file...
		  
	  
	     InFile = new BufferedReader(new FileReader(FileName)); //Here, too, the FileReader object specifies the source of the values
	                                                            // but is anonymous...
	     
	     for(i = 0 ; i< 8 ; i++ ) {
	    	 
	    	 Stations[i] = new WeatherStation(); //Create an new empty object for the location
	    	                                          //and then fill it with values from the file...
	    	 
	    	 InBuffer = InFile.readLine();  //This doesn't need to be converted
	    	 Stations[i].SetDesignation(InBuffer);
	    	 
	    	 InBuffer = InFile.readLine();   //...but since the value come off the file as Strings, most of the rest of these values do
	    	 Stations[i].SetTemperature(Double.parseDouble(InBuffer));
	    	     
	    	 InBuffer = InFile.readLine();
	    	 Stations[i].SetPollenCount(Double.parseDouble(InBuffer));
	    	     
	    	 InBuffer = InFile.readLine();
	    	 Stations[i].SetAQScore(Double.parseDouble(InBuffer));
	    	      
	     }
	    		 
	     InFile.close();     
	}
}




