#### 추상적인 차이
- "스프링 부트를 이용하면 단독으로 실행 가능한 상용 수준의 스프링 기반 애플리케이션을 손쉽게 만들 수 있습니다."
	- 해당 문구는 모듈 추가에 따른 복잡한 설정이 있는 스프링과 다르게 스프링 부트의 편리함을 나타낸다.


#### 의존성 관리
- 스프링의 경우 모듈의 의존성을 직접 설정하고 호환 버전을 명시해야 정상 작동
- 스프링 부트는 "spring-boot-starter" 의존성을 제공하여 호환되는 버전 모듈 조합을 제공
	- 편리해졌다.


#### 자동 설정
- 스프링 부트는 자동 설정을 지원
- 프로젝트 생성하면 메인 애플리케이션 자바 파일이 생성
	- 여기에 @SpringBootApplication 어노테이션이 명시되는데 다음 어노테이션을 합친 것
		- @SpringBootConfiguration
		- @EnableAutoConfiguration
		- @ComponentScan

1. 스프링 부트 애플리케이션 실행 시, @ComponentScan 어노테이션이 @Component 시리즈 어노이션이 붙은 클래스를 찾아 빈 등록
2. @EnableAutoConfiguration 어노테이션을 통해 자동 설정이 적용된다.

- @Component 대표적인 시리즈
	- @Controller
	- @RestController
	- @Service
	- @Repository
	- @Configuration


#### 내장 WAS
- 스프링 부트에는 내장 WAS이 존재
	- 기본은 "톰캣"이며 다른 웹 서버도 대체 가능하다.
