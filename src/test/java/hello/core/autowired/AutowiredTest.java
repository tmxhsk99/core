package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * setter 생성자 옵션 처리 관련 테스트
 */
public class AutowiredTest {
    @Test
    void AutoWiredOption(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean {

        //스프링 컨테이너에서 등록이 안된 빈이기 때문에 호출자체가 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        //호출은 되지만 스프링 컨테이너에 등록되지 않았기 때문에 null이 나옴
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        //Optional.empty 값이 나타난다.
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
