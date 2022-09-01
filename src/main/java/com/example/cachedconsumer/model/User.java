package com.example.cachedconsumer.model;


import lombok.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.NONE)
@RedisHash("User")
public class User implements Serializable {
    @Id
    @XmlElement(name="id")
    private Long id;
    @XmlElement(name="balance")
    private Balance balance;


}
