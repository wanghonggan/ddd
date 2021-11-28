package cn.loosing.demo.dao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_demo", indexes = {
        @Index(name = "idx_demo_type", columnList = "type")
})
@EntityListeners(AuditingEntityListener.class)
@Data
@Accessors(chain = true)
public class Demo {

    @Column(nullable = false, length = 50)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Enumerated(EnumType.STRING)
    private Status type;

    @Column(length = 500)
    private String name;

    @Column(length = 2000)
    public String description;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    enum Status {
        a, b, c
    }
}
