# 批量图片生成PDF文档

* 批量下载图片保存到本地

* 读取批量图片生成PDF文档

# 系统环境

Arch Manjaro/JDK 1.8/Spring boot 2.16

# 实现过程

## 下载图片

使用HttpClient包，调用第三方接口下载

```
compile('org.apache.httpcomponents:httpclient')
```

## 生成pdf文档

使用com.lowagie.text-2.1.7.jar对pdf文档的读取写入进行操作

```
compile files('lib/com.lowagie.text-2.1.7.jar')
```

# 可能遇到的问题

* 导入包无效，一般是缺少依赖，或者导入的依赖不正确，填写正确的依赖即可

* 调用接口404，一般检查是否是内网环境，需要开代理。网络正常，检查地址是否正常

* 保存图片或pdf失败，一般是地址书写格式问题，Windows/linux的地址格式写法不一样

* 生成的pdf格式错误，或者排版错乱，一般是没有设置宽度和高度，宽度需要和图片宽度一致，总高度=每页高度*页数。每页高度等于每张图片高度

* Todo
