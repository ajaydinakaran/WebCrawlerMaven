# WebCrawlerMaven
Maven project

This project is using Spring 4.0 

com.webcrawler.config has Configurations for the project.
com.webcrawler.controller has Controller Classes
Test classes are under src/test/java
Add your maven project to yout tomcat and run the application

home page is localhost:8080/webcrawler/home

once you click on the "Link here to Crawl your application" ,it will crawl all your pages in your local and display it in the page .

If you want to crawl another website .Please follow the below steps:
1.Go to src\main\java\com\webcrawler\constants\ApplicationConstants.JAVA
2.Change the DOMAIN value to your domain .eg:-http://wiprodigital.com
3.Change the DOMAIN_HOME_PAGE_URL value to the home page of the website.eg:- http://wiprodigital.com/who-we-are/

If you want to build and delpoy the application in another envrionment .Please follow the below steps :
1.Once you have made the changes ,compile the project using mvn install command.This command will generate a war file under /target in the project.
2.Go to tomcat/bin folder and execute ./shutdown.sh (Linux)to stop the server
3.Copy the war file to your tomcat webapps directory
4.Execute ./startup.sh (Linux) to start the server
