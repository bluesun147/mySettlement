
## 👋 Project Overview

**Spring Batch를 사용한 음원 콘텐츠 관련 정산 MSA 시스템 구현**

<h2 id="features"> 💡 프로젝트 소개 </h2>

소개 페이지 : https://satin-loganberry-da5.notion.site/My-Settlement-c6fdff2f8b284657913a9f308ceb15de?pvs=4

시연 영상 : https://youtu.be/uOXLv-qj7MY

![구조도](https://github.com/bluesun147/mySettlement/assets/86697585/54541f87-efeb-4697-9705-9955a39dfd8a)
![배포과정](https://github.com/bluesun147/mySettlement/assets/86697585/f0e7f7cb-ebb4-4880-898f-8988171636a0)

<h2 id="features"> ✨ Key Features </h2>

- MSA
  - [monolithic 구조로 구현 후 전환](https://velog.io/@bluesun147/series/MSA-%EC%A0%84%ED%99%98)
    
- Spring Batch
  - [Spring Batch 이용한 월별 자동 정산](https://velog.io/@bluesun147/spring-batch-u0yaoyhr)

- 동시성 문제
  - [Pessimistic Lock을 이용한 동시성 문제 해결](https://velog.io/@bluesun147/MSA%EC%97%90%EC%84%9C%EC%9D%98-%EB%8F%99%EC%8B%9C%EC%84%B1)

- Docker + ECS
  - [Docker와 ECS를 활용한 CI/CD](https://velog.io/@bluesun147/Docker-ECS)
 
<h2 id="stacks"> 🛠️  Tech Stacks </h2>


### 🚉 Platform

- Docker
- AWS ECR
- AWS ECS
- Cloudtype DB

### 🦾 Server

- JAVA 17
- Spring Boot v3.2.3
- MariaDB
- JPA
- Spring Batch
- Spring Cloud
- Eureka
