### 基于 SpringBoot+Mybatis+Redis+RabbitMQ 秒杀系统  

### 开发工具

idea  2017.7

### 开发环境

| JDK | Maven| Mysql  | SpringBoot | redis | RabbitMQ| 
| :-------------: |:-------------:| :-------------:| :-------------:|:-------------:| :-------------:|
| 1.8  | 3.2.2 | 5.7| 1.5.10.RELEASE | 3.2 | 4.X | 

### 项目启动说明

1、启动前，请配置 application.properties 中相关redis、mysql、rabbitmq地址以及代码中文件地址。 

2、登录地址：http://localhost:8888/user/login/page   

3、商品秒杀列表地址：http://localhost:8888/goods/list

### 其它说明

1、sql执行完数据库共有一千个用户左右（手机号：从18077200000~18077200998 密码为：123456），为压测准备的。（使用 com.waein.seckill.util.UserUtil.java该类生成的，生成token做压测也是在此类里面）

2、此项目完成了秒杀的所有业务逻辑功能，并优化以下几个模块：

    1)、页面缓存、商品详情静态化、订单静态化（感兴趣可以把所有页面都做静态化）
    2)、加入消息队列RabbitMQ，对秒杀接口进行优化。
    3)、隐藏秒杀接口地址
    4)、接口限流防刷
    5)、解决超卖问题

### 页面截图
登录页
![123](img/1.png)
商品列表情页
![123](img/2.png)
商品详情页
![123](img/3.png)
订单详情页
![123](img/4.png)


