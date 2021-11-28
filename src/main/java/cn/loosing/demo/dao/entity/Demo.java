package cn.loosing.demo.dao.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_demo", indexes = {
        @Index(name = "idx_demo_type", columnList = "type")
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Demo demo = (Demo) o;
        return id != null && Objects.equals(id, demo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
