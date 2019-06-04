# Table of Contents
* [Java Web](#java-web)
   * [1. Install and configure Apache Tomcat 8:](#1-install-and-configure-apache-tomcat-8)
   * [2. Java Web deployment](#2-java-web-deployment)
   * [3. Features](#3-features)
   
# Java Web
[![License](https://img.shields.io/badge/License-Apache%202-brightgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![JDK](https://img.shields.io/badge/JDK-8u212%20-orange.svg)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[![Dependencies](https://img.shields.io/badge/Dependencies-up%20to%20date-green.svg)](https://dev.mysql.com/downloads/connector/j/5.1.html)
[![Platform](https://img.shields.io/badge/Platform-Windows%2010%20%7C%20macOS%20Mojave%20%7C%20Unbuntu%2016.04-blue.svg)](http://releases.ubuntu.com/16.04/)

[中文](README_CN.md) | English
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

* Database operation (insert, delete, update, select statements).
* Return and accept image string streams and save in webl folders.
* Read and write text, create or delete directories, etc.
