package com.seughyun.java.project03.aims.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;




//모든 변수 Getter 생성
/*
@Getter
//모든 변수 Setter 생성
@Setter
//Equals() & hashCode() 를 자동 Overriding 해줌
@EqualsAndHashCode

//toString() 자동 Overriding
@ToString
*/

//아래의 어노테이션(Getter, Setter, EqualsAndHashCode, RequiredArgsConstructor, ToString ) 을 가져옴.
@Data
//기본 생성자
@NoArgsConstructor
//그 외의 모든 생성자
@AllArgsConstructor
//필수 생성자 선택 할 수 있게함
@RequiredArgsConstructor

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    private LocalDate BirthDay;

    private String job;

    //ToString 예외시키기.
    @ToString.Exclude
    private String phoneNumber;

    //cascade == 종속 --> 연결된 블록 또한 업데이드 시켜줌. 아래와 같이 선택적으로 업데이트 할 수 있다.
    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    // CascadeType.ALL로 하면 모든 업데이트를 해준다.
    // FetchType.EAGER을 이용하면 LEFT JOIN을 함. 이것에 Optional = false ( false로 하면 항상 필요하다는 뜻 ( Not NULL) ) 를 이용하면, INNER JOIN으로 변경됨.

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch =FetchType.LAZY)
    @ToString.Exclude
    private Block block;





/*    public boolean equals(Object object){
        if(object == null)
            return false;

        Person person = (Person) object;

        if(!person.getName().equals(this.getName()))
            return false;
        if(person.getAge() != this.getAge())
            return false;

        return true;
    }

    public  int hashCode(){
        return (name+age).hashCode();
    }
*/

}
