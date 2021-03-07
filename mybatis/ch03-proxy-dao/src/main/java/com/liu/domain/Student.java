package com.liu.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Integer id;
    private String name;
    private String email;
    private Integer age;

}
