# Discharge Process By Spring Application Events

Let me first explain you why i created this small dummy service:

* My purpose is to make use of spring events which i only heard but now i tried this and I amazed to see that how we can make our code loosely coupled nature and less error-prone.

### Let's Getting Started Step By Step

* Create a Application Event by extending **ApplicationEvent** class

```java
@Getter
@Setter
public class PatientDischargeEvent extends ApplicationEvent {

    private Long patientId;
    private String patientName;

    public PatientDischargeEvent(Object source, PatientInfoDto patientInfoDto) {
        super(source);
        this.patientId = patientInfoDto.getPatientId();
        this.patientName = patientInfoDto.getPatientName();
    }

}
```

* Remove all other service dependencies and Autowire **ApplicationEventPublisher** class for publish event.

```java

@Slf4j
@Service
public class DischargeService {


    private final ApplicationEventPublisher publisher;

    public DischargeService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    public void process(PatientInfoDto patientInfoDto) {

        try {
            log.info("<-------------Begin patient discharge process!!--------------->");

            this.publisher.publishEvent(new PatientDischargeEvent(this, patientInfoDto));

            log.info("<------------End patient discharge process successfully!!----->");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Failed during patient discharge process!!", ex);
        }

    }
    
}
```

* Now you can create an interface just like **DischargeProcessService** given below and declare an abstract method with below given annotations.

1. **_@Async_** : To make asynchronous process, in simple words run it in a different thread.
2. **_@EventListener_** : To listen the event and perform the execution.

Why we specify these annotations here?

We can specify while implementing the particular method in the child class,
reason because to reduce the _boilerplate/repeatable_ code. 

No need to specify over and over again and not the fear of missing anywhere.

```java
public interface DischargeProcessService {

    @Async
    @EventListener
    void process(PatientDischargeEvent event);

}
```

* Now here you can see the implementations of above given interface **DischargeProcessService**.

```java
@Slf4j
@Service
@Qualifier("patientDischargeFNFProcess")
public class PatientDischargeFNFProcess implements DischargeProcessService { ... }
```

```java
@Slf4j
@Service
@Qualifier("houseKeepingProcess")
public class HouseKeepingProcess implements DischargeProcessService { ... }
```

```java
@Slf4j
@Service
@Qualifier("patientNotificationProcess")
public class PatientNotificationProcess implements DischargeProcessService { ... }
```

```java
@Slf4j
@Service
@Qualifier("allocateNewPatientProcess")
public class AllocateNewPatientProcess implements DischargeProcessService { ... }
```

### Reference Video
For further reference, please consider the following sections:

[Spring Application Events Usage](https://www.youtube.com/watch?v=imF5ja5OkAo&list=WL&index=1)
