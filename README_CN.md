# 目录
* [Java Web](#java-web)
    * [1. 安装 Tomcat服务器并配置环境](#1-安装-tomcat服务器并配置环境)
    * [2. 部署 Java Web](#2-部署-java-web)
    * [3. 功能介绍](#3-功能介绍)

# Java Web
中文|[English](README.md) 
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
1. 数据库操作(增，删，改，查)；
2. 返回和接受图像字符串流并写入到本地文件夹中用户；
3. 读写文本，创建或删除目录等。
