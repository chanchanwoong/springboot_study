#### 의존성 주입
- 제어 역전에서 언급한 방식을 구체화한 것
- 사용할 객체를 직접 생성하지 않고 스프링 컨테이너가 생성한 객체를 주입받아 사용하는 방식의 의미
- 의존성 주입할 때 @Autowired 어노테이션을 사용해야 한다.
	- @Autowired 어노테이션으로 선언한 것들은 스프링 애플리케이션이 실행될 때, 스프링 IoC컨테이너가 빈의 생성과 주입을 처리한다.


#### 의존성 주입 세 가지 방식
- 생성자를 통한 의존성 주입(Spring에서 권장하는 방식)
- 필드 객체 선언을 통한 의존성 주입
- setter 메서드를 통한 의존성 주입


#### 생성자를 이용한 의존성 주입
- 클래스 생성자에 의존성 주입 과정을 넣는다.

```
public class DI {
	// 객체 선언
	// 의존성 주입 전
	MyService myService;
	
	// 생성자에 의존성 주입
	@Autowired
	public DI(MyService myService) {
		this.myService = myService;
	}
}
```
- lombok의 @RequiredArgsConstructor을 사용하면 동일 과정을 간략하게 작성 가능
	- @RequiredArgsConstructor을 사용하려면 객체에 "final" 키워드를 사용해줘야 한다.


#### 필드 객체 선언을 통한 의존성 주입

```
public class DI {
	
	@Autowired
	private MyService myService;
}
```
- 스프링 컨테이너에 있는 것을 가져다 쓰는 느낌이 강하다.


#### setter 메서드를 통한 의존성 주입

```
public class DI {
	
	MyService myService;
	
	@Autowired
	public void setMyService(MyService myService){
		this.myService = myService;
	}
}
```



#### 질문거리
- "new 객체" 하는 부분이 의존성을 주입?
	- 초기화 부분이 의존성 주입과 동일한 의미인가?

```
전통적인 방식인 `MyService service = new MyService();`는 객체가 직접 의존 객체를 생성하는 것으로, 의존성 주입과는 다른 개념입니다. 이러한 방식은 의존성 주입보다 결합도가 높고, 유연성이 낮습니다. 객체가 직접 의존 객체를 생성하면 해당 객체와 의존 객체 간의 결합도가 높아져서 객체의 재사용성과 테스트 용이성이 저하될 수 있습니다.
```


- @RequiredArgsContructor을 사용해서 생성자 의존 주입 방식에는 "final" 안 쓰면 에러 발생하는 경험이 있었다.
	- 해당 도서에서는 생성자 의존 주입 방식에 "final"을 안 쓰던데 이유가 뭘까?

```
lombok에서 제공해주는 @RequiredArgsConstructor는 final일때만 생성자를 생성해준다.
```

- 의존성 주입한 객체는 불변성이 있는 것이 항상 좋을까?
	- "final" 키워드를 객체 선언에 붙힐까?

```
일반적으로 의존성 주입된 객체를 불변하게 만드는 것이 바람직하지만, 모든 경우에 적합하지는 않습니다. 때로는 특정 상황에서 필드를 변경해야 할 수도 있습니다. 예를 들어, 테스트용으로 가짜(mock) 객체를 주입하거나, 다른 의존성을 주입하는 경우가 있을 수 있습니다. 이러한 경우에는 필드를 `final`로 선언하지 않는 것이 유연성을 제공할 수 있습니다.
```

- setter를 이용한 의존성 주입은 setter 메서드를 호출하기 전에는 의존성 주입이 안되는 것 아닌가?

```
`@Autowired` 어노테이션이 선언된 메서드에 대해 Spring IoC 컨테이너가 자동으로 해당 타입의 빈을 주입합니다. 따라서 `setMyService()` 메서드가 호출되지 않아도 Spring은 해당 타입의 빈을 찾아 자동으로 주입합니다.

즉, 위의 코드에서는 `DI` 클래스가 Spring IoC 컨테이너에 등록되어 있어야 합니다. 그리고 `MyService` 타입의 빈이 Spring 컨테이너에 등록되어 있어야 합니다. 그러면 Spring은 `DI` 클래스의 `setMyService()` 메서드에 `MyService` 타입의 빈을 자동으로 주입합니다.

이는 `@Autowired` 어노테이션이 붙은 메서드가 호출되면서 자동으로 의존성이 주입되는 원리입니다. 따라서 `setMyService()` 메서드를 명시적으로 호출하지 않아도 Spring이 자동으로 해당 의존성을 주입합니다.
```