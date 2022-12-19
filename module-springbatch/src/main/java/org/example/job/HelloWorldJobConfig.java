package org.example.job;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {

  @Bean
  public Job HelloWorldJob(JobRepository jobRepository) {
    return new JobBuilder("helloWorldJob", jobRepository)
        .incrementer(new RunIdIncrementer())
        .start(helloWorldStep(jobRepository))
        .build();

  }

  @Bean
  public JobRepository jobRepository(DataSource dataSource) throws Exception {
    JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
    factory.setDataSource(dataSource);
    factory.setTransactionManager(new ResourcelessTransactionManager());
    factory.afterPropertiesSet();
    return (JobRepository) factory.getObject();
  }

  @JobScope
  @Bean
  public Step helloWorldStep(JobRepository jobRepository) {
    return new StepBuilder("helloWorldStep", jobRepository)
        .tasklet(helloWorldTasklet())
        .build();
  }

  @StepScope
  @Bean
  public Tasklet helloWorldTasklet() {
    return new Tasklet() {
      @Override
      public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
          throws Exception {
        System.out.println("Hello World Spring Batch");
        return RepeatStatus.FINISHED;
      }
    };
  }

}
