Java Scripting Sandbox
======


Building 
======
No installation is required. To build, you need 
Java 6 or higher and Maven 2 or higher (http://maven.apache.org/). 

Before cloning this repository, be sure to enable automatic conversion 
of CRLF/LF on your machine using "git config --global core.autocrlf input". 
For more information, please  refer to http://help.github.com/dealing-with-lineendings/

Clone the repository using "git clone git://github.com/pfisterer/scripting-sandbox.git"
To build, run "mvn install", this will build the program and place the 
generated jar file in target/ and in your local Maven repository.  

Use in your Maven project
======

Add the following dependency to your pom.xml:
	
	<dependency>
		<groupId>de.farberg.scripting.sandbox</groupId>
		<artifactId>scripting-sandbox</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</dependency>
	
Add the following repositories to your pom.xml:

	<repositories>
		<repository>
			<id>itm-maven-repository-releases</id>
			<url>http://www.itm.uni-luebeck.de/projects/maven/releases/</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>

		<repository>
			<id>itm-maven-repository-snapshots</id>
			<url>http://www.itm.uni-luebeck.de/projects/maven/snapshots/</url>
			<releases>
				<enabled>false</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>


Contact
======
Any feedback will be greatly appreciated, at the GitHub project page
(https://github.com/pfisterer/scripting-sandbox) or by contacting
[pfisterer](mailto:github@farberg.de)
