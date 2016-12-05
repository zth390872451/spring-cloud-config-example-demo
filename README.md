 服务注册中心(Eureka的服务器端):
    应用程序名称：eureka-server
     应用名称：eureka-server
    端口：1000

 服务客户端：
     应用程序名称：eureka-client-node-one、eureka-client-node-two、eureka-client-node-three
     服务名称：eureka-client-node (这三个应用提供同一种服务所以服务名称相同)
     eureka-client-node-one：Eureka客户端
     eureka-client-node-two：Ribbon客户端
     eureka-client-node-three：Feign客户端
     端口：1001  1002 1003


配置服务器(配置服务器的服务器端)：
    应用程序名称：config-server
    端口：8888

公共网关层(路由设置):
    应用程序名称：api-gateway
    端口:3000









