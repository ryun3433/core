package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    static class TestConfig {
        @Test
        void statefulServiceSingleton() {
            ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
            StatefulService statefulService1 = ac.getBean(StatefulService.class);
            StatefulService statefulService2 = ac.getBean(StatefulService.class);

            //ThreadA: A 사용자가 10000원 주문
            int userAPrice = statefulService1.order("userA", 10000);
            //ThreadB: B 사용자가 20000원 주문
            int userBPrice = statefulService2.order("userB", 20000);


            //hreadA: 사용자A 주문 금액 조회
            System.out.println("price = " + userAPrice);

            Assertions.assertThat(userAPrice).isEqualTo(10000);

        }


        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}