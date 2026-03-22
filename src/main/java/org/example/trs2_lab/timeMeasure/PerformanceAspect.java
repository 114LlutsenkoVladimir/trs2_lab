package org.example.trs2_lab.timeMeasure;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceAspect.class);

    // 1. Указываем, ГДЕ перехватывать (у вас здесь всё верно)
    @Pointcut("within(org.example.trs2_lab.repository..*) || " +
            "execution(* org.example.trs2_lab.repository..*.*(..)) || " +
            "within(org.example.trs2_lab.service.DistributedTransactionService)")
    public void myMonitorPointcut() {}

    // 2. Указываем, ЧТО делать (добавляем аннотацию @Around)
    @Around("myMonitorPointcut()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed(); // Запуск самого метода
        } finally {
            long duration = System.currentTimeMillis() - start;
            log.info("Метод: {}.{} | Время выполнения: {} мс",
                    joinPoint.getSignature().getDeclaringType().getSimpleName(), // Берем тип и достаем простое имя
                    joinPoint.getSignature().getName(),
                    duration);
        }
    }
}
