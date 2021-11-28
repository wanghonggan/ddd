package cn.loosing.demo.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class Admin {

    private static final long serialVersionUID = 1L;

    @Id/*主键*/
    @GeneratedValue(strategy= GenerationType.IDENTITY)/*自动递增*/
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
