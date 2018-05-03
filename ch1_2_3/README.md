# 相关说明


## 2. Spring常用配置

### 2.3 Bean的初始化与销毁:
> 在我们实际开发的时候，经常会遇到在使用之前或者之后做些必要的操作，Spring对Bean的生命周期的操作提供了支持。
- `ch2.prepost`

### 2.4 Profile
> Profile为在不同环境下使用不同的配置提供了支持（例如数据库的配置）
- `ch2.profile`

### 2.5 事件(Application Event):
> Spring的事件为Bean与Bean之间的消息通信提供支持，当一个Bean完成一个任务之后，希望另一个Bean知道并做相应的处理，
这个时候就需要让另一个Bean监听当前Bean所发送的事件
- `ch2.event`

## 3. Spring高级话题
### 3.1 Spring Aware
> Spring Aware的目的是为了让Bean获取Spring容器的服务

### 3.2 多线程
> Spring 通过任务执行器(TaskExecutor)来实现多线程与并发编程
- `ch3.taskexecutor`

### 3.3 计划任务
> 通过在配置类中注解`@EnableScheduling`来开启对计划任务的支持，然后在要执行计划任务的方法上注解`@Scheduled`，声明这是一个计划任务
- `ch3.taskscheduler`

### 3.4 条件注解@Conditional
> 通过活动的profile，我们可以获得不同的bean，Spring4提供了更通用基于条件的Bean的创建，即使用@Conditional注解
@Conditional根据满足特定条件创建一个特定的bean，
- `ch3.conditional`

### 3.5 组合注解与元注解
> 所谓元注解，就是可以注解到别的注解上的注解 别注解的注解称之为组合注解，

### 3.7  测试
- `ch3.fortest`