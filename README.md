# Table of Contents
* [Java Web](#java-web)
   * [1. Install and configure Apache Tomcat 8:](#1-install-and-configure-apache-tomcat-8)
   * [2. Java Web deployment](#2-java-web-deployment)
   * [3. Features](#3-features)
   
# Java Web

## 1. Install and configure Apache Tomcat 8:

Download at <https://tomcat.apache.org/download-80.cgi>. 
	
Install Apache Tomcat on Mac OS: <https://www.youtube.com/watch?v=h_qQOVDTxo8>. 
	
Install Apache Tomcat on Windows 10: <https://www.youtube.com/watch?v=grW6afp8yE4>. 
	
Install Apache Tomcat on Ubuntu 16.04: <https://www.youtube.com/watch?v=KoXiRXjZgwc>.
	
## 2. Java Web deployment
Migrate all the files under the `MyCloudwearWeb/out/artifacts` to the `Tomcat/webapps`, then enter two lines of commands in the terminal:

```Java
"cd" + blank space + the absolute address where Tomcat/bin is located
./startup.sh

```
## 3. Features

1. Database operation (insert, delete, update, select statements).
2. Return and accept image string streams and save in webl folders.
3. Read and write text, create or delete directories, etc.
