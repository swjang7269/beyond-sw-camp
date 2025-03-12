package com.ohgiraffers.mybatisspring.config;

import com.ohgiraffers.mybatisspring.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 설명. 나중엔 간편히 할 수 있으나 이번 프로젝트에서는 추가적인 설정을 할 예정 */
@Configuration
public class MybatisConfiguration {
    // .yml 파일에서 값을 읽어와 할당
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    // 커넥션 객체를 생성하여 datasource를 관리
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 단위 (ms)
        /* 설명. 데이터베이스 연결 시도 유지 시간 */
        dataSource.setConnectionTimeout(30000); // 30초

        /* 설명. 데이터베이스 유휴 시간(연결이 된 이후 요청이 없어도 유지하는 시간 -> 해당 시간 이후엔 해당 커넥션 객체 제거) */
        dataSource.setIdleTimeout(600000);      // 10분

        /* 설명. 데이터베이스 연결 최대 유지 시간 */
        dataSource.setMaxLifetime(1800000);     // 30분

        // 생성해 놓을 커넥션 객체 수
        dataSource.setMaximumPoolSize(50);

        return dataSource;
    }

    // bean은 singleton으로 관리된다.
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);  // MenuMapper 인터페이스를 매퍼로 등록

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());        // datasource 등록
        factoryBean.setConfiguration(configuration);    // mapper 등록

        return factoryBean.getObject();
    }

    // SqlSessionFactory를 이용하여 SqlSessionTemplate 커넥션 객체를 생성
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}
