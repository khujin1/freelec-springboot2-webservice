package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // class내 모든 필드의 getter 메소드 자동 생성
@NoArgsConstructor // 기본생성자 자동추가. public Posts와 같은 효과
@Entity // table과 링크될 클래스임을 나타냄. e.g. SalesManager.java --> sales_manager table

public class Posts extends BaseTimeEntity {

    @Id // 해당 table의 pk 필드를 나타냅니다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk생성규칙. auto_increment 가
    private Long id; // field 선언

    @Column(length = 500, nullable = false) // 기본값외 추가 변경이 필요한 옵션이 있으면 사용
    private String title; // field 선언

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // field 선언

    private String author; // field 선언

    @Builder // 사용자 정의 생성자
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
