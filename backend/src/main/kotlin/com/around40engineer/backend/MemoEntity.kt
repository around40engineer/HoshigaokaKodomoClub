package com.around40engineer.backend

import jakarta.persistence.*

@Entity
@Table(name = "memoTable")
class MemoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int = 0,
    val memo: String = ""
)
