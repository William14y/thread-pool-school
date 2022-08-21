package br.com.mentorama.threadpoolschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

@Configuration
public class AlunoAsyncConfig {

    @Bean
    public Executor executorService(){

        return ForkJoinPool.commonPool();
    }

    @Bean
    public Executor customThreadPool(){
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(30);
        return  executor;
    }
}
