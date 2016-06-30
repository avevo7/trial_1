package Final_5;

/*
title: WEEK 5
*/


public class GreenStation 
{
	private double AirQualityIndex;
	private double PollenCount;
	
	public GreenStation()
	{
		PollenCount = 0;
		AirQualityIndex = 0.0;
	}
	public GreenStation(double MeasuredCount, double MeasuredIndex)
	{
		PollenCount = MeasuredCount;
		AirQualityIndex = MeasuredIndex;
	}

		//Define mutators...

	public void SetPollenCount(double MeasuredCount) { PollenCount = MeasuredCount; }
	public void SetAQScore(double MeasuredIndex)		{ AirQualityIndex = MeasuredIndex; }
	
		// Define accessors...
	public double GetPollenCount() 		{ return PollenCount; }
	public double GetAQScore()			{ return AirQualityIndex; }
	
	
}

