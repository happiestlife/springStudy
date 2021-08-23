package shopping;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Announcement {

    @Pointcut("execution(* shopping*())")
    private void publicAspect(){}

    @Around("publicAspect()")
    public void startAndFinishAnnouncement(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("안녕하세요, 고객님.");
        System.out.println("저희 매장을 찾아주셔서 감사합니다.");
        long start = System.currentTimeMillis();

        joinPoint.proceed();

        long finish = System.currentTimeMillis();
        int shoppedTime = (int)(finish - start);

        int tmp = shoppedTime/1000;
        int min = tmp/60;
        int sec = tmp%60;
        System.out.printf("쇼핑시간은 %d분 %d초 입니다.", (int)min, sec);
        System.out.println("지금까지 매장을 이용해주셔서 감사합니다.");
        System.out.println("다음에 또 뵙겠습니다. 안녕히 가세요");
    }
}
