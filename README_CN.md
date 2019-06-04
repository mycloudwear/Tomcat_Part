# 目录
* [Java Web](#java-web)
    * [1. 安装 Tomcat服务器并配置环境](#1-安装-tomcat服务器并配置环境)
    * [2. 部署 Java Web](#2-部署-java-web)
    * [3. 功能介绍](#3-功能介绍)

# Java Web
[![License](https://img.shields.io/badge/License-Apache%202-brightgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![JDK](https://img.shields.io/badge/JDK-8u212%20-orange.svg)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[![Dependencies](https://img.shields.io/badge/Dependencies-up%20to%20date-green.svg)](https://dev.mysql.com/downloads/connector/j/5.1.html)
[![Platform](https://img.shields.io/badge/Platform-Windows%2010%20%7C%20macOS%20Mojave%20%7C%20Unbuntu%2016.04-blue.svg)](http://releases.ubuntu.com/16.04/)

中文 | [English](README.md) 
## 1. 安装 Tomcat服务器并配置环境

推荐安装 **Tomcat 8**. 

Tomcat 下载地址: <https://tomcat.apache.org/download-80.cgi>

Mac 下配置方法: <https://www.youtube.com/watch?v=h_qQOVDTxo8>

Windows 下配置方法: <https://www.youtube.com/watch?v=grW6afp8yE4>

Linux 下配置方法: <https://www.youtube.com/watch?v=KoXiRXjZgwc>
   
## 2. 部署 Java Web

将 `MyCloudwearWeb/out/artifacts` 文件下的全部文件迁移到 `Tomcat/webapps` 文件下，最后在终端里输入两行指令：

```Java
"cd" + 空格 + Tomcat/bin 所在的绝对地址
./startup.sh
```

## 3. 功能介绍
* 数据库操作(增，删，改，查)；
* 返回和接受图像字符串流并写入到本地文件夹中用户；
* 读写文本，创建或删除目录等。
