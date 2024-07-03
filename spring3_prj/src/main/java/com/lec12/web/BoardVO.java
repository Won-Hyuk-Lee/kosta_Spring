package com.lec12.web;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOARD")
@Data
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    private int seq;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENTS", nullable = false)
    private String contents;

    @Column(name = "REGID")
    private String regid;

    @Column(name = "REGDATE")
    private String regdate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<FileVO> files;
}
