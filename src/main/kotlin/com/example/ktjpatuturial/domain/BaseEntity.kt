package com.example.ktjpatuturial.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    //    @CreatedDate
    // 위에는 안되고, 아래는 됨;
    @CreationTimestamp
    var createDate: LocalDateTime? = null;

    @UpdateTimestamp
    var lastModifiedDate: LocalDateTime? = null;
}
