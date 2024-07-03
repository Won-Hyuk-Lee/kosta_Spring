package com.lec12.web;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "FILE")
@Data
public class FileVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FSEQ")
    private int fseq;

    @Column(name = "ONAME", nullable = false)
    private String oname;

    @Column(name = "SNAME", nullable = false)
    private String sname;

    @Column(name = "FSIZE", nullable = false)
    private long fsize;

    @Column(name = "FPATH", nullable = false)
    private String fpath;

    @ManyToOne
    @JoinColumn(name = "BSEQ", nullable = false)
    private BoardVO board;
}
