package hello.core.logdemo;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;

    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
        System.out.println("myLogger  = " + myLogger.getClass());
    }

    public void logic(String id){
        myLogger.log("service id = " + id);
    }

}
