package com.example.trainingvideorental.rental;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import static javax.persistence.TemporalType.TIMESTAMP;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

        @CreatedBy
        protected U createdBy;

        @CreatedDate
        @Temporal(TIMESTAMP)
        protected Date createdDate;

        @LastModifiedBy
        protected U lastModifiedBy;

        @LastModifiedDate
        @Temporal(TIMESTAMP)
        protected Date lastModifiedDate;

    }


