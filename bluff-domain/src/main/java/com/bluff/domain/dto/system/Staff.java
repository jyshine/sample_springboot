package com.bluff.domain.dto.system;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "staffs")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff {

    // 아이디
    @Id
    @Column(name = "staff_id")
    @GeneratedValue
    Long id;

    // 비밀번호
    String password;

    //이름
    String firstName;

    // 성
    String lastName;

    // 닉네임
    String nickName;

    // 이메일
    String email;

    // 연락처
    String tel;

}
