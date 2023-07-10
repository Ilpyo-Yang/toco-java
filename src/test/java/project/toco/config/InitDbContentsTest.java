package project.toco.config;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.entity.Level;
import project.toco.service.EducationService;
import project.toco.service.EducationTypeService;

@SpringBootTest
@Transactional
@Rollback(false)
public class InitDbContentsTest {
  @Autowired
  EducationService educationService;
  @Autowired
  EducationTypeService educationTypeService;

  @Test
  public void initJavaBasicDb(){
    EducationContentDto ec = new EducationContentDto(null, 0,
        "Java 기초 개념",
        "Java 언어의 역사와 특징, JDK(Java Development Kit) 설치 방법, 개발 환경 구성 방법 등을 학습합니다. 이번 주차에서는 Java 개발을 위한 기본적인 준비를 마칩니다.",
        "1. Java 언어의 역사와 특징에 대한 소개\n"
            + "2. JDK(Java Development Kit)와 JRE(Java Runtime Environment)의 개념과 설치 방법\n"
            + "3. 개발 환경 구성: 통합 개발 환경(IDE) 소개와 설치 방법",
        null);
    EducationContentDto ec1 = new EducationContentDto(null, 1,
        "변수와 자료형",
        "변수의 개념과 활용 방법, 자료형의 종류와 특징, 변수 선언과 초기화 방법 등을 학습합니다. 이번 주차에서는 Java에서 변수를 활용하여 데이터를 저장하고 처리하는 방법에 대해 배웁니다.",
        "1. 변수의 개념과 활용 방법\n"
            + "2. 기본 자료형(정수, 실수, 문자, 논리)과 참조 자료형(문자열, 배열) 소개\n"
            + "3. 변수 선언과 초기화 방법",
        null);
    EducationContentDto ec2 = new EducationContentDto(null, 2,
        "연산자와 제어문",
        "산술 연산자, 논리 연산자, 비교 연산자 등의 다양한 연산자와 조건문(if문, switch문), 반복문(for문, while문) 등을 학습합니다. 이번 주차에서는 프로그램의 흐름을 제어하는 방법을 익힙니다.",
        "1. 산술 연산자와 대입 연산자의 사용법\n"
            + "2. 논리 연산자와 비교 연산자의 활용 방법\n"
            + "3. 조건문(if문, switch문)과 반복문(for문, while문)의 사용법과 예제",
        null);
    EducationContentDto ec3 = new EducationContentDto(null, 3,
        "배열과 문자열",
        "배열의 개념과 사용 방법, 다차원 배열, 문자열(String) 클래스와 문자열 다루기 등을 학습합니다. 이번 주차에서는 여러 개의 데이터를 다루는 방법과 문자열 처리에 대해 알아봅니다.",
        "1. 배열의 선언과 초기화 방법\n"
            + "2. 다차원 배열과 배열의 활용 방법\n"
            + "3. 문자열(String) 클래스의 기능과 문자열 다루기",
        null);
    EducationContentDto ec4 = new EducationContentDto(null, 4,
        "객체 지향 프로그래밍 기본",
        "객체 지향 프로그래밍의 개념과 특징, 클래스와 객체, 메서드와 생성자, 상속과 다형성 등을 학습합니다. 이번 주차에서는 Java에서 객체 지향 프로그래밍을 구현하는 방법을 배웁니다.",
        "1. 객체 지향 프로그래밍의 개념과 특징 소개\n"
            + "2. 클래스와 객체의 개념과 관계\n"
            + "3. 메서드와 생성자의 역할과 사용법\n"
            + "4. 상속과 다형성에 대한 이해와 활용 방법",
        null);
    EducationContentDto ec5 = new EducationContentDto(null, 5,
        "예외 처리",
        "예외(Exception)의 개념과 발생 원인, 예외 처리 방법, 예외 클래스의 계층 구조 등을 학습합니다. 이번 주차에서는 예외 상황에 대비하여 프로그램을 안정적으로 실행하는 방법을 익힙니다.",
        "1. 예외의 개념과 종류를 이해하고 예외 처리의 필요성을 학습합니다.\n"
            + "2. try-catch 문을 사용하여 예외를 처리하는 방법을 익힙니다.\n"
            + "3. finally 블록의 역할과 사용법에 대해 알아봅니다.",
        null);
    EducationContentDto ec6 = new EducationContentDto(null, 6,
        "파일 입출력",
        "파일 입출력의 개념과 기본적인 파일 처리 방법, 텍스트 파일과 바이너리 파일 입출력, 입출력 스트림 등을 학습합니다. 이번 주차에서는 파일을 읽고 쓰는 방법에 대해 배웁니다.",
        "1. 파일 입출력의 기본 개념과 처리 방법을 학습합니다.\n"
            + "2. FileReader, FileWriter, BufferedReader, BufferedWriter 등의 클래스를 사용하여 파일을 읽고 쓰는 방법을 익힙니다.\n"
            + "3. 텍스트 파일과 바이너리 파일을 다루는 방법을 실습합니다.",
        null);
    EducationContentDto ec7 = new EducationContentDto(null, 7,
        "추가적인 주제와 응용 - Java에서 제공하는 다양한 기능과 라이브러리, GUI 프로그래밍, 네트워크 프로그래밍",
        "이번 목차에서는 Java의 다양한 기능과 라이브러리를 학습합니다. 날짜와 시간 처리, 정규표현식, 컬렉션 프레임워크 등의 주제를 다루며, GUI 프로그래밍과 네트워크 프로그래밍에 대해 응용적으로 학습합니다.",
        "1. Java에서 제공하는 다양한 기능과 라이브러리를 학습합니다. (예: 날짜와 시간 처리, 정규표현식, 컬렉션 프레임워크 등)\n"
            + "2. GUI 프로그래밍을 위한 Swing 또는 JavaFX를 학습합니다.\n"
            + "3. 네트워크 프로그래밍을 위한 Socket, URLConnection 등을 사용하여 네트워크 통신을 학습합니다.",
        null);

    List<EducationContentDto> list = List.of(ec, ec1, ec2, ec3, ec4, ec5, ec6, ec7);
    String type_uuid = educationTypeService.findUuid("Backend", "Java").get(0);
    EducationDto educationDto = new EducationDto(null, "Java 기초 학습 가이드",
        "이 학습 가이드는 Java 프로그래밍 언어의 기초를 학습하고자 하는 사람들을 위한 자료입니다. 이 가이드를 통해 Java 언어의 기본 문법, 객체 지향 프로그래밍, 예외 처리, 파일 입출력 등을 학습할 수 있습니다. 각 주차별로 구성된 학습 내용을 따라가면서 스스로 Java에 대해 학습하는 데 도움이 될 것입니다.",
        0, list.size(), 0, type_uuid, Level.Basic, LocalDateTime.now(), null);
    String education_uuid = educationService.create(educationDto, list);
    assert educationService.findById(education_uuid).getType().equals(type_uuid);
  }


  @Test
  public void initCsArchitecture(){
    EducationContentDto ec = new EducationContentDto(null, 0,
        "소프트웨어 아키텍처의 개념과 중요성, 아키텍처 설계의 목표 및 가치",
        "소프트웨어 아키텍처의 역할과 중요성을 이해하고, 아키텍처 설계가 가져다주는 가치에 대해 학습합니다. 이번 주제에서는 아키텍처 설계의 목표와 기대효과에 대해 알아봅니다.",
        "1. 소프트웨어 아키텍처의 개념과 중요성 이해하기\n"
            + "2. 아키텍처 설계의 목표와 가치 파악하기\n"
            + "3. 아키텍처 설계와 개발 생명주기의 관계 이해하기\n"
            + "4. 아키텍처 판단 기준과 품질 속성 이해하기",
        null);
    EducationContentDto ec1 = new EducationContentDto(null, 1,
        "아키텍처 설계의 원칙과 원칙의 적용 방법",
        "아키텍처 설계에 적용되는 기본적인 원칙들을 학습합니다. SOLID 원칙, DRY 원칙 등의 원칙을 이해하고, 실제 설계 시에 원칙을 적용하는 방법을 다룹니다.",
        "1. SOLID 원칙 이해하기 (단일 책임 원칙, 개방-폐쇄 원칙 등)\n"
            + "2. DRY 원칙과 코드 중복 제거하기\n"
            + "3. 의존성 관리 원칙 이해하기 (의존성 역전 원칙, 인터페이스 분리 원칙 등)\n"
            + "4. 아키텍처 원칙 적용 사례 분석하기",
        null);
    EducationContentDto ec2 = new EducationContentDto(null, 2,
        "다양한 아키텍처 스타일 소개와 적용 사례",
        "대표적인 아키텍처 스타일인 계층형, 이벤트 기반, 마이크로서비스, 서비스 지향, 헥사고날 등을 소개하고, 각 스타일의 특징과 적용 사례를 학습합니다.",
        "1. 계층형 아키텍처의 개념과 구성 요소 이해하기\n"
            + "2. 이벤트 기반 아키텍처의 특징과 장단점 파악하기\n"
            + "3. 마이크로서비스 아키텍처의 개념과 주요 구성 요소 이해하기\n"
            + "4. 서비스 지향 아키텍처의 특징과 장점 이해하기",
        null);
    EducationContentDto ec3 = new EducationContentDto(null, 3,
        "아키텍처 패턴의 개념과 실무 적용 사례",
        "다양한 아키텍처 패턴인 MVC, MVP, MVVM, CQRS, 이벤트 소싱 등을 학습합니다. 각 패턴의 특징과 실무에서의 적용 사례를 다루며, 적합한 패턴 선택과 적용 방법에 대해 학습합니다.",
        "1. MVC 아키텍처 패턴의 개념과 역할 이해하기\n"
            + "2. MVP 아키텍처 패턴의 특징과 구성 요소 파악하기\n"
            + "3. MVVM 아키텍처 패턴의 개념과 적용 사례 분석하기\n"
            + "4. CQRS 패턴과 이벤트 소싱의 개념과 활용 방법 이해하기",
        null);
    EducationContentDto ec4 = new EducationContentDto(null, 4,
        "아키텍처 설계를 위한 도구와 표준 소개",
        "아키텍처 설계를 위해 사용되는 도구와 표준을 소개합니다. UML(Unified Modeling Language), 아키텍처 다이어그램, 툴 및 플랫폼 등의 활용 방법과 실제 프로젝트에서의 적용 사례를 학습합니다.",
        "1. UML(Unified Modeling Language) 다이어그램의 종류와 활용 방법 익히기\n"
            + "2. 아키텍처 설계 도구의 종류와 선택 기준 이해하기\n"
            + "3. 아키텍처 표준과 지침 이해하기 (예: TOGAF, 아키텍처 표준 프레임워크)\n"
            + "4. 실제 프로젝트에서의 아키텍처 도구와 표준 적용 사례 분석하기",
        null);
    EducationContentDto ec5 = new EducationContentDto(null, 5,
        "아키텍처 품질 특성과 평가 방법",
        "아키텍처의 품질을 평가하는 기준과 방법을 학습합니다. 성능, 확장성, 유지보수성 등의 품질 특성을 이해하고, 아키텍처 평가를 위한 도구와 기법을 소개합니다.",
        "1. 아키텍처 품질 특성 이해하기 (성능, 보안, 확장성, 유지보수성 등)\n"
            + "2. 아키텍처 품질 평가를 위한 기법과 도구 학습하기\n"
            + "3. 아키텍처 품질 개선을 위한 리팩토링 기법 이해하기\n"
            + "4. 실전 프로젝트에서의 아키텍처 품질 평가와 개선 사례 분석하기",
        null);
    EducationContentDto ec6 = new EducationContentDto(null, 6,
        "아키텍처 변화 관리의 필요성과 전략",
        "소프트웨어 아키텍처는 변화하는 요구사항과 기술적 환경에 대응해야 합니다. 이번 주제에서는 아키텍처 변화 관리의 필요성과 전략을 학습하며, 버전 관리, 리팩토링, 재설계 등의 방법을 다룹니다.",
        "1. 아키텍처 변화의 필요성과 동기 이해하기\n"
            + "2. 버전 관리 시스템의 활용 방법 익히기\n"
            + "3. 아키텍처 리팩토링의 개념과 전략 학습하기\n"
            + "4. 아키텍처 재설계와 변화 관리의 사례 분석하기",
        null);
    EducationContentDto ec7 = new EducationContentDto(null, 7,
        "실무에서의 아키텍처 설계 프로세스와 사례",
        "실무에서의 아키텍처 설계 프로세스를 학습합니다. 요구사항 분석, 아키텍처 설계, 구현 및 테스트, 평가 및 개선 등의 단계를 다루며, 실제 프로젝트에서의 아키텍처 설계 사례를 살펴봅니다.",
        "1. 요구사항 분석을 위한 기법과 도구 학습하기\n"
            + "2. 아키텍처 설계 단계별 프로세스 이해하기\n"
            + "3. 구현 및 테스트를 위한 아키텍처 패턴 및 도구 활용하기\n"
            + "4. 아키텍처 평가와 개선을 위한 리뷰와 피드백 프로세스 학습하기",
        null);

    List<EducationContentDto> list = List.of(ec, ec1, ec2, ec3, ec4, ec5, ec6, ec7);
    String type_uuid = educationTypeService.findUuid("CS", "Architecture").get(0);
    EducationDto educationDto = new EducationDto(null, "소프트웨어 아키텍처 기초 학습 가이드",
        "이 학습 가이드는 소프트웨어 아키텍처에 대한 기초를 학습하고자 하는 현업 개발자를 대상으로 제작된 자료입니다. 소프트웨어 아키텍처의 기본 개념과 원칙, 다양한 아키텍처 스타일 및 패턴을 학습할 수 있으며, 실무에서 아키텍처를 설계하고 구축하는 방법에 대한 가이드라인을 제공합니다.",
        0, list.size(), 0, type_uuid, Level.Challenge, LocalDateTime.now(), null);
    String education_uuid = educationService.create(educationDto, list);
    assert educationService.findById(education_uuid).getType().equals(type_uuid);
  }


  @Test
  public void initCsArchitectureChallenge(){
    EducationContentDto ec = new EducationContentDto(null, 0,
        "마이크로서비스 아키텍처의 개념과 중요성, 장단점 파악하기",
        "마이크로서비스 아키텍처의 기본 개념과 주요 특징을 이해하고, 전통적인 모놀리틱 아키텍처와의 비교를 통해 장단점을 파악합니다.",
        "1. 마이크로서비스 아키텍처의 정의와 주요 특징 학습하기\n"
            + "2. 서비스 분해와 독립적인 배포, 확장성에 대한 이해"
            + "3. 모놀리틱 아키텍처의 특징과 제약 사항 이해하기\n"
            + "4. 마이크로서비스 아키텍처의 장단점 비교 및 혜택 파악"
            + "5. 성공적인 마이크로서비스 아키텍처 구축 사례 분석하기\n"
            + "6. 각 사례에서의 도전 과제와 해결 방법 이해하기",
        null);
    EducationContentDto ec1 = new EducationContentDto(null, 1,
        "마이크로서비스 설계를 위한 원칙과 모범 사례 이해하기",
        "마이크로서비스 아키텍처를 설계하기 위한 주요 원칙과 모범 사례를 학습합니다. 단일 책임 원칙, 서비스 경계의 명확성, 데이터 관리 전략 등을 다루며, 실제 프로젝트에서의 적용 사례를 살펴봅니다.",
        "1. 단일 책임 원칙의 개념과 이점 학습하기\n"
            + "2. 마이크로서비스에서 SRP를 적용한 실제 설계 사례 분석"
            + "3. Bounded Context와 Domain-Driven Design(DDD)의 개념 학습하기\n"
            + "4. 서비스 경계를 정의하고 유지하는 방법과 기법 학습"
            + "5. 데이터의 독립성과 관련된 전략 학습하기\n"
            + "6. 데이터베이스 분리, 이벤트 소싱, CQRS 등의 데이터 관리 패턴 이해",
        null);
    EducationContentDto ec2 = new EducationContentDto(null, 2,
        "마이크로서비스의 분해와 각 서비스의 독립적 배포 전략 학습하기",
        "모놀리틱 아키텍처에서의 서비스 분해와 마이크로서비스 아키텍처에서의 서비스 분해 방법을 학습합니다. 각 서비스를 독립적으로 배포하기 위한 전략과 배포 도구를 다룹니다.",
        "1. 마이크로서비스를 어떻게 분해할 것인지 결정하는 방법 학습하기\n"
            + "2. 서비스 경계 식별과 컨텍스트 매핑에 대한 이해"
            + "3. 개별 서비스를 독립적으로 배포하기 위한 전략 이해하기\n"
            + "4. 컨테이너 기반 배포 도구 (예: Docker, Kubernetes) 학습 및 활용 방법 이해"
            + "5. 마이크로서비스 간의 통신 방식 (REST, 메시지 큐 등) 학습하기\n"
            + "6. 각 통신 방식의 특징과 장단점 이해하기",
        null);
    EducationContentDto ec3 = new EducationContentDto(null, 3,
        "서비스 간 통신 방식과 API 게이트웨이의 역할 이해하기",
        "마이크로서비스 아키텍처에서의 서비스 간 통신 방식과 메시지 전송 프로토콜을 학습합니다. 또한, API 게이트웨이의 역할과 기능, 실무에서의 활용 방법을 학습합니다.",
        "1. HTTP 기반의 RESTful API 디자인 원칙과 예제 학습하기\n"
            + "2. 메시지 큐를 활용한 이벤트 기반 통신 방식 이해하기"
            + "3. API 게이트웨이의 역할과 중요성 이해하기\n"
            + "4. 마이크로서비스 아키텍처에서의 API 게이트웨이 활용 방법 학습"
            + "5. 주요 API 게이트웨이 도구 (예: Kong, Netflix Zuul) 학습 및 사용법 이해하기\n"
            + "6. API 게이트웨이를 활용한 보안, 로깅, 트래픽 관리 등의 기능 학습",
        null);
    EducationContentDto ec4 = new EducationContentDto(null, 4,
        "분산 데이터 관리와 서비스 디스커버리의 필요성과 도구 이해하기",
        "분산 환경에서의 데이터 관리 전략과 도구를 학습합니다. 또한, 서비스 디스커버리의 개념과 구현 방법, 주요 도구를 학습하여 서비스 검색과 동적 로드 밸런싱을 구현하는 방법을 이해합니다.",
        "1. 데이터의 분산과 일관성 유지를 위한 전략 학습하기\n"
            + "2. 이벤트 소싱, CQRS 등의 데이터 관리 패턴 이해 및 활용 방법 학습"
            + "3. 서비스 디스커버리의 역할과 필요성 이해하기\n"
            + "4. 서비스 디스커버리 도구 (예: Netflix Eureka, Consul)의 사용법 학습"
            + "5. 서비스 디스커버리를 통한 동적 로드 밸런싱 개념 이해하기\n"
            + "6. 클라이언트와 서비스 간의 효율적인 통신을 위한 방법 학습",
        null);
    EducationContentDto ec5 = new EducationContentDto(null, 5,
        "마이크로서비스 환경에서의 모니터링과 로깅 전략 학습하기",
        " 마이크로서비스 아키텍처에서의 모니터링과 로깅 전략을 학습합니다. 서비스 상태 모니터링, 분산 추적, 로그 수집과 분석 등의 핵심 개념과 도구를 다루며, 실무에서의 적용 사례를 살펴봅니다.",
        "1. 분산 환경에서의 서비스 상태 모니터링 방법 이해하기\n"
            + "2. 실시간 로그 및 지표 수집을 위한 도구 학습 (예: Prometheus, ELK Stack)"
            + "3. 중앙화된 로깅 시스템의 구축과 활용 방법 학습하기\n"
            + "4. 로그 데이터의 수집, 저장, 분석을 위한 도구 (예: Logstash, Splunk) 학습"
            + "5. 분산 추적 시스템의 개념과 구성 요소 이해하기\n"
            + "6. 마이크로서비스 간의 트랜잭션 추적과 분석 도구 (예: Jaeger, Zipkin) 학습",
        null);
    EducationContentDto ec6 = new EducationContentDto(null, 6,
        "마이크로서비스 아키텍처의 보안과 테스트 전략 학습하기",
        "마이크로서비스 환경에서의 보안 전략과 도구, 인증과 권한 부여 방식을 학습합니다. 또한, 테스트 전략과 방법론, 자동화 테스트 도구의 활용 방법을 다룹니다.",
        "1. 인증과 권한 부여 방식 이해하기 (예: OAuth, JWT)\n"
            + "2. 서비스 간의 보안 통신 (HTTPS) 설정 및 관리 방법 학습"
            + "3. 마이크로서비스 아키텍처에서의 테스트 전략과 방법론 학습\n"
            + "4. 단위 테스트, 통합 테스트, E2E 테스트 등의 자동화 방법과 도구 학습"
            + "5. 보안 취약점 스캐닝 도구 (예: OWASP ZAP) 활용 방법 학습\n"
            + "6. 테스트 자동화 도구 (예: JUnit, Selenium) 사용법 이해하기",
        null);
    EducationContentDto ec7 = new EducationContentDto(null, 7,
        "마이크로서비스 아키텍처의 운영과 확장성 관리 전략 학습하기",
        "마이크로서비스 아키텍처에서의 운영 및 확장성 관리 전략을 학습합니다. 서비스 모니터링, 로드 밸런싱, 오토스케일링, 컨테이너 오케스트레이션 등의 주제를 다루며, 클라우드 기반 환경에서의 실전 적용 사례를 살펴봅니다.",
        "1. 로깅, 모니터링, 오류 추적 등 운영 관련 핵심 요소 이해하기\n"
            + "2. 효과적인 서비스 운영을 위한 도구 (예: Prometheus, Grafana) 활용 방법 학습"
            + "3. 클라우드 환경에서의 자동 스케일링과 자원 관리 방법 학습\n"
            + "4. 컨테이너 오케스트레이션 도구 (예: Kubernetes)를 활용한 확장성 관리 학습"
            + "5. 장애 탐지, 복구, 격리 등의 서비스 장애 대응 전략 학습하기\n"
            + "6. 고가용성 및 복구 기술 (예: 서킷 브레이커 패턴) 이해하기"
            + "7. 클라우드 기반 서비스 (예: AWS, Azure)를 활용한 인프라 관리 방법 학습\n"
            + "8. 인프라스트럭처 코드 (Infrastructure as Code)를 통한 자동화 학습",
        null);
    EducationContentDto ec8 = new EducationContentDto(null, 8,
        "마이크로서비스 아키텍처와 DevOps의 상호 관계 및 협업 방식 학습하기",
        "마이크로서비스 아키텍처와 DevOps 사이의 관계와 상호작용을 학습합니다. CI/CD, 자동화, 인프라스트럭처 코드 등의 개념과 도구, 팀 구성과 협업 방식을 다룹니다.",
        "1. 마이크로서비스와 DevOps의 원리와 목표에 대한 이해\n"
            + "2. CI/CD, 자동화, 팀 구성 등을 통한 협업 방식 학습"
            + "3. 지속적 통합 (Continuous Integration)과 지속적 전달 (Continuous Delivery) 이해하기\n"
            + "4. CI/CD 파이프라인 구축을 위한 도구 및 자동화 방법 학습"
            + "5. 인프라스트럭처 자동화를 위한 도구 (예: Terraform, Ansible) 학습하기\n"
            + "6. 서버 구성 관리 도구 (예: Puppet, Chef) 사용법 이해하기",
        null);
    EducationContentDto ec9 = new EducationContentDto(null, 9,
        "실제 프로젝트에서의 마이크로서비스 아키텍처 구축 사례 분석하기",
        "실제 현업에서 마이크로서비스 아키텍처를 구축한 사례를 분석합니다. 성공 사례와 도전 과제, 경험 공유를 통해 실전 마이크로서비스 아키텍처의 구축 방법과 패턴을 학습합니다.",
        "1. 실제 프로젝트에서 성공적으로 마이크로서비스 아키텍처를 구축한 사례 분석\n"
            + "2. 프로젝트의 목표, 아키텍처 결정, 구현 방법 등을 학습하고 분석"
            + "3. 실전 마이크로서비스 구축 과정에서의 도전 과제 파악하기\n"
            + "4. 도전 과제를 해결하기 위한 방법과 적용된 기술 학습"
            + "5. 실무에서 마이크로서비스 아키텍처를 구축한 개발자들의 경험 공유\n"
            + "6. 성공적인 구축을 위한 Best Practice와 주의사항 학습",
        null);
    EducationContentDto ec10 = new EducationContentDto(null, 10,
        "마이크로서비스 아키텍처의 한계와 대안 아키텍처 학습하기",
        "마이크로서비스 아키텍처의 한계와 도전 과제를 학습합니다. 서비스 간 통신의 복잡성, 분산 트랜잭션, 데이터 일관성 등에 대한 문제를 다루며, 대안 아키텍처 패턴과 접근 방식을 학습합니다.",
        "1. 마이크로서비스 아키텍처에서의 도전 과제 및 한계 파악하기\n"
            + "2. 분산 트랜잭션, 데이터 일관성 유지 등에 대한 문제 학습"
            + "3. 마이크로서비스 아키텍처의 한계를 극복하기 위한 대안 아키텍처 학습\n"
            + "4. 서비스 메시, 이벤트 소싱, 서버리스 아키텍처 등의 패턴 이해하기"
            + "5. 마이크로서비스 아키텍처와 대안 아키텍처 패턴의 장단점 비교\n"
            + "6. 프로젝트의 특성과 요구 사항에 따른 선택 기준 학습",
        null);
    EducationContentDto ec11 = new EducationContentDto(null, 11,
        "모놀리틱 아키텍처에서 마이크로서비스로의 마이그레이션과 분해 전략 학습하기",
        "기존 모놀리틱 아키텍처에서 마이크로서비스 아키텍처로의 전환과 분해 전략을 학습합니다. 도메인 분석, 서비스 경계의 식별, 단계적인 분해 전략 등에 대해 다루며, 실무에서의 마이그레이션 사례를 살펴봅니다.",
        "1. 기존 모놀리틱 아키텍처에서 마이크로서비스 아키텍처로의 전환 방법 학습\n"
            + "2. 마이크로서비스로의 분해 전략과 접근 방식 이해하기"
            + "3. 도메인 주도 설계(Domain-Driven Design)의 개념과 중요성 학습하기\n"
            + "4. 마이크로서비스 경계 식별을 위한 도메인 분석 방법 학습"
            + "5. 단계적인 모놀리틱 분해와 마이크로서비스 전환 전략 학습하기\n"
            + "6. 실제 마이그레이션 사례를 통해 단계별 접근 방법 이해하기",
        null);

    List<EducationContentDto> list = List.of(ec, ec1, ec2, ec3, ec4, ec5, ec6, ec7, ec8, ec9, ec10, ec11);
    String type_uuid = educationTypeService.findUuid("CS", "Architecture").get(0);
    EducationDto educationDto = new EducationDto(null, "실전 마이크로서비스 아키텍처 구축 학습 가이드",
        "백엔드 서버를 마이크로서비스 아키텍처로 구축하고자 하는 현업 개발자를 대상으로 제작된 자료입니다. 마이크로서비스 아키텍처의 기본 개념과 특징, 설계 원칙, 구현 방법 및 도구 등을 학습할 수 있으며, 실제 현장에서 마이크로서비스 아키텍처를 구축하는 방식과 개발 패턴을 익힐 수 있습니다.",
        0, list.size(), 0, type_uuid, Level.Challenge, LocalDateTime.now(), null);
    String education_uuid = educationService.create(educationDto, list);
    assert educationService.findById(education_uuid).getType().equals(type_uuid);
  }
}
