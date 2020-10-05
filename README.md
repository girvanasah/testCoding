# testCoding

Problem Statement:
To take the temperature(both in degree celsius and Fahrenheit) and humidity of any Indian city from NDTV website and then comparing its temperature from openweather api (https://openweathermap.org/current) with some variance logic for each of the attribute of weather

Solution:
For this I have created Java based framework using following libraries:
Selenium - 3.12.0
TestNG - 6.8.8
Rest Assured - 3.0.2
org.json - 20190722
This is a Maven based project.

Variables like City name, variance, browser type are configurable and can be changed in config.properties

Steps to execute

1. Change the variables in config.properties as per requirement 
2. We need to set the path of chrome/gecko driver in config.properties file
3. Run the testng.xml directly or from terminal/cmd navigate inside the project and execute the command "mvn test"

