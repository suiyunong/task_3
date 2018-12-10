package cn.syn.chuilun.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

import static cn.syn.chuilun.utils.DBTools.longToDate;


@Aspect
@Service
public class DBAop {
    private static Logger logger = Logger.getLogger(DBAop.class);
    private static long time1 = 0;
    @Before("execution(* cn.syn.chuilun.dao.*.*(..))")
    public void beginTransaction() {
        time1 = System.currentTimeMillis();
        System.out.println("[前置通知]  开启事务.."+longToDate(time1,"yyyy年-MM月dd日-HH时mm分ss秒"));
    }

    @After("execution(* cn.syn.chuilun.dao.*.*(..))")
    public void commit(JoinPoint joinPoint) {
        long time2 = System.currentTimeMillis();
        System.out.println("[后置通知] 提交事务.."+longToDate(time2,"yyyy年-MM月dd日-HH时mm分ss秒"));
//        System.out.println(time2-time1+"ms ");
//        System.out.println(joinPoint.getSignature().getName());

        String DB = "数据库操作总耗时： "+(time2-time1)+"ms "+"操作方法为："+joinPoint.getSignature().getName();
        logger.info(DB);
        System.out.println(DB);
    }

    @AfterReturning("execution(* cn.syn.chuilun.dao.*.*(..))")
    public void afterReturing() {
        long time2 = System.currentTimeMillis();
        System.out.print("[返回后通知");
        System.out.println(time2-time1+"ms ]");
    }

    @AfterThrowing("execution(* cn.syn.chuilun.dao.*.*(..))")
    public void afterThrowing() {
        System.out.println("[异常通知]");
    }

    @Around(("execution(* cn.syn.chuilun.dao.*.*(..))"))
    public Object arroud(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[环绕通知执行前：]");
        Object result=pjp.proceed();                   // 执行目标方法
        long time2 = System.currentTimeMillis();
        System.out.print("[环绕通知执行后：");
        System.out.println(time2 - time1+"ms ]");
        return result;
    }
}
