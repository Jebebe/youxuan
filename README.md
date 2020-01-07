# youxuan 
~~~~
youxuan-search-service  9102
youxuan-goods-service   9104
youxuan-order-service   9106
youxuan-pay-service     9108
youxuan-goods-center    8101
youxuan-user-center     8103
youxuan-system-center   8105
youxuan-common-center   8107
youxuan-portal-center   8109
youxuan-eureka-service 注册中心     9001/9002/9003
youxuan-config-service Config配置中心   8000
youxuan-gateway-service 网关服务    7000
~~~~
~~~~
ES索引数据结构:
index:youxuan
{
  "settings": {
    "number_of_replicas": 0
  },
  "mappings": {
    "item": {
      "dynamic": false,
      "properties": {
		"itemId": {
          "type": "long"
        },
        "goodsId": {
          "type": "long"
        },
        "title": {
          "type": "text",
          "index": "true",
          "analyzer": "ik_smart",
          "search_analyzer": "ik_smart"
        },
        "price": {
          "type": "double"
        },
        "category": {
          "type": "keyword"
        },
		"seller": {
          "type": "text",
		  "index": "true",
		  "analyzer": "ik_smart",
          "search_analyzer": "ik_smart"
        },
		"brand": {
          "type": "keyword"
        },
        "imageUrl": {
            "type": "keyword"
        }
      }
    }
  }
}
~~~~

~~~~
场景描述：电脑不工作时没关机直接休眠状态。虚拟机有三台linux环境，每台有一个ES，在第三台启动完成几分钟之后，
第一台linux es 出现了问题
node-1 被自动杀死
[2019-12-29T16:16:41,761][INFO ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][young][457][46] duration [964ms], collections [1]/[1.4s], total [964ms]/[3.1s], memory [178.1mb]->[125.2mb]/[1015.6mb], all_pools {[young] [53.7mb]->[1mb]/[66.5mb]}{[survivor] [536.9kb]->[330.9kb]/[8.3mb]}{[old] [123.8mb]->[123.8mb]/[940.8mb]}
[2019-12-29T16:16:41,814][WARN ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][457] overhead, spent [964ms] collecting in the last [1.4s]
[2019-12-29T16:16:46,202][INFO ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][461] overhead, spent [514ms] collecting in the last [1.2s]
[2019-12-29T16:16:48,825][INFO ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][463] overhead, spent [639ms] collecting in the last [1.3s]
[2019-12-29T16:16:51,501][INFO ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][young][465][49] duration [761ms], collections [1]/[1.5s], total [761ms]/[5s], memory [169.6mb]->[125mb]/[1015.6mb], all_pools {[young] [46mb]->[891.1kb]/[66.5mb]}{[survivor] [248.9kb]->[196.7kb]/[8.3mb]}{[old] [123.9mb]->[123.9mb]/[940.8mb]}
[2019-12-29T16:16:51,536][WARN ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][465] overhead, spent [761ms] collecting in the last [1.5s]
[2019-12-29T16:17:01,976][WARN ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][young][474][50] duration [1.1s], collections [1]/[2s], total [1.1s]/[6.2s], memory [150.8mb]->[125.6mb]/[1015.6mb], all_pools {[young] [26.7mb]->[1.1mb]/[66.5mb]}{[survivor] [196.7kb]->[453.7kb]/[8.3mb]}{[old] [123.9mb]->[123.9mb]/[940.8mb]}
[2019-12-29T16:17:02,044][WARN ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][474] overhead, spent [1.1s] collecting in the last [2s]
[2019-12-29T16:17:04,958][INFO ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][young][476][51] duration [987ms], collections [1]/[1.6s], total [987ms]/[7.2s], memory [152.6mb]->[125.3mb]/[1015.6mb], all_pools {[young] [28.2mb]->[1mb]/[66.5mb]}{[survivor] [453.7kb]->[316.1kb]/[8.3mb]}{[old] [123.9mb]->[123.9mb]/[940.8mb]}
[2019-12-29T16:17:05,039][WARN ][o.e.m.j.JvmGcMonitorService] [es-node-1] [gc][476] overhead, spent [987ms] collecting in the last [1.6s]
已杀死
~~~~
~~~~
nginx 安装配置
上传 nginx-1.14.1.tar.gz包
解压
进到解压目录，执行以下配置
./configure \
--prefix=/usr/local/nginx \
--pid-path=/var/run/nginx/nginx.pid \
--lock-path=/var/lock/nginx.lock \
--error-log-path=/var/log/nginx/error.log \
--http-log-path=/var/log/nginx/access.log \
--with-http_gzip_static_module \
--http-client-body-temp-path=/var/temp/nginx/client \
--http-proxy-temp-path=/var/temp/nginx/proxy \
--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
--http-scgi-temp-path=/var/temp/nginx/scgi

创建此文件夹
mkdir /var/temp/nginx/client -p
进到主目录sbin  ./nginx  启动
关闭   ./nginx -s stop
./nginx -s reload  重新加载
~~~~

~~~~
搭建完成第一次启动出现的问题
***************************
APPLICATION FAILED TO START
***************************
Description:
An attempt was made to call a method that does not exist. The attempt was made from the following location:
    java.lang.invoke.MethodHandleNatives.resolve(Native Method)
The following method did not exist:
    com.google.gson.GsonBuilder.setLenient()Lcom/google/gson/GsonBuilder;
The method's class, com.google.gson.GsonBuilder, is available from the following locations:
    jar:file:/E:/JAR/repository/com/google/code/gson/gson/2.1/gson-2.1.jar!/com/google/gson/GsonBuilder.class
It was loaded from the following location:
    file:/E:/JAR/repository/com/google/code/gson/gson/2.1/gson-2.1.jar
Action:
Correct the classpath of your application so that it contains a single, compatible version of com.google.gson.GsonBuilder
Disconnected from the target VM, address: '127.0.0.1:49836', transport: 'socket'
Process finished with exit code 1

解决一:找到依赖了此gson的依赖去除
解决二：本地仓库下添加此包
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.1</version>
  <scope>runtime</scope>
</dependency>
~~~~

~~~~
跨系统传文件：
注："root"：之间为本地路径，之后为远程IP及路径
scp -v -r /usr/local/es-1/elasticsearch-6.5.4/plugins/ik root@10.18.190.11:/usr/local/es-2/elasticsearch-6.5.4/plugins/ik
~~~~