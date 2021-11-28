package cn.loosing.demo.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_demo")
@EntityListeners(AuditingEntityListener.class)
@Data
@Accessors(chain = true)
public class Demo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Enumerated(EnumType.STRING)
    private Status type;

    private String name;

    @Column(length = 1000)
    public String description;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    enum Status {
        a, b, c
    }
}
