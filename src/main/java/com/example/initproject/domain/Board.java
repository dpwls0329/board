//DB connect ver
package com.example.initproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Board {

    //식별 필드
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    @Column(updatable = false)
    private String writer;
    private String content;
    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private long cnt;
}
//
//package com.example.initproject.domain;
//
//        import lombok.Getter;
//        import lombok.Setter;
//        import lombok.ToString;
//
//        import java.util.Date;
//
//@Getter
//@Setter
//@ToString
//public class Board {
//
//    private Long seq;
//    private String title;
//    private String writer;
//    private String content;
//    private Date createDate;
//    private long cnt;
//}