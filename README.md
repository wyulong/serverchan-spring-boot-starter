# SpringBoot starter for Serverchan 
Server酱推送服务starter，通过本starter可以快速集成Server酱推送服务到springboot工程  
Server酱网址: [https://sc.ftqq.com][https://sc.ftqq.com]
## 快速开始
### 安装到本地仓库
由于本工程暂未推送到中央仓库，所以需要手动安装jar到本地仓库
```
git clone https://gitee.com/wyulong/serverchan-spring-boot-starter.git
cd serverchan-spring-boot-starter
mvn clean install
```

### 添加pom依赖
```xml
<dependency>
    <groupId>com.lnold</groupId>
    <artifactId>serverchan-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
### 添加server酱配置
application.properties中添加starter的配置  
_**sckey需通过Server酱网站注册帐户后获取**_
```properties
# server酱sckey
spring.serverchan.sckey=YOUR_SCKEY
```

### 使用
注入ServerchanService，即可按照普通Service使用  
示例代码：
```java
import com.lnold.serverchan.PushResult;
import com.lnold.serverchan.ServerchanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ServerchanService serverchanService;

    @PostMapping("/push")
    public PushResult push(String title,String content){
        PushResult result = serverchanService.sendMessage(title, content);
        if (result.isSuccess()){
            //doSomething()
        }else{
            //doOtherthing()
        }
        return result;
    }
}
```

